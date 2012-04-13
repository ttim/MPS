/*
 * Copyright 2003-2011 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.typesystem.inference;

import gnu.trove.THashMap;
import jetbrains.mps.components.CoreComponent;
import jetbrains.mps.lang.typesystem.runtime.RuntimeSupport;
import jetbrains.mps.lang.typesystem.runtime.performance.RuntimeSupport_Tracer;
import jetbrains.mps.lang.typesystem.runtime.performance.SubtypingManager_Tracer;
import jetbrains.mps.newTypesystem.RuntimeSupportNew;
import jetbrains.mps.newTypesystem.SubTypingManagerNew;
import jetbrains.mps.project.AuxilaryRuntimeModel;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.language.LanguageRegistry;
import jetbrains.mps.smodel.language.LanguageRegistryListener;
import jetbrains.mps.smodel.language.LanguageRuntime;
import jetbrains.mps.typesystem.TypeSystemReporter;
import jetbrains.mps.typesystem.inference.util.ConcurrentSubtypingCache;
import jetbrains.mps.typesystem.inference.util.SubtypingCache;
import jetbrains.mps.util.Computable;
import jetbrains.mps.util.Pair;
import jetbrains.mps.util.performance.IPerformanceTracer;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TypeChecker implements CoreComponent, LanguageRegistryListener {
  private static final String RUNTIME_TYPES = "$runtimeTypes$";
  private static final String TYPES_MODEL_NAME = "typesModel";
  private static final SModelFqName TYPES_MODEL_UID = new SModelFqName(TYPES_MODEL_NAME, RUNTIME_TYPES);
  private static TypeChecker INSTANCE;

  public final Object LISTENERS_LOCK = new Object();

  private SubtypingManager mySubtypingManager;
  private RuntimeSupport myRuntimeSupport;
  private RulesManager myRulesManager;

  private RuntimeSupport myRuntimeSupportTracer;
  private SubtypingManager mySubtypingManagerTracer;

  private ThreadLocal<TypesReadListener> myTypesReadListener = new ThreadLocal<TypesReadListener>();

  private SubtypingCache mySubtypingCache = null;
  private SubtypingCache myGlobalSubtypingCache = null;
  private SubtypingCache myGenerationSubTypingCache = null;

  private Map<SNode, SNode> myComputedTypesForCompletion = null;

  private IPerformanceTracer myPerformanceTracer = null;

  private List<TypeRecalculatedListener> myTypeRecalculatedListeners = new ArrayList<TypeRecalculatedListener>(5);

  private final LanguageRegistry myLanguageRegistry;

  private ThreadLocal<Boolean> myIsGenerationThread = new ThreadLocal<Boolean>() {
    @Override
    protected Boolean initialValue() {
      return Boolean.FALSE;
    }
  };
  private Thread myMainGenerationThread;

  public TypeChecker(LanguageRegistry languageRegistry) {
    myLanguageRegistry = languageRegistry;
    myRuntimeSupport = new RuntimeSupportNew(this);
    mySubtypingManager = new SubTypingManagerNew(this);
    myRulesManager = new RulesManager(this);
    myRuntimeSupportTracer = new RuntimeSupport_Tracer(this);
    mySubtypingManagerTracer = new SubtypingManager_Tracer(this);
  }

  public void init() {
    if (INSTANCE != null) {
      throw new IllegalStateException("double initialization");
    }

    INSTANCE = this;
    ModelAccess.instance().runWriteAction(new Runnable() {
      @Override
      public void run() {
        Collection<LanguageRuntime> availableLanguages = myLanguageRegistry.getAvailableLanguages();
        if (availableLanguages != null) {
          for (LanguageRuntime l : availableLanguages) {
            myRulesManager.loadLanguage(l.getNamespace());
          }
        }
        myLanguageRegistry.addRegistryListener(TypeChecker.this);
      }
    });
  }

  public void dispose() {
    myLanguageRegistry.removeRegistryListener(this);
    INSTANCE = null;
  }

  @Override
  public void languagesLoaded(Iterable<LanguageRuntime> languages) {
    for (LanguageRuntime l : languages) {
      myRulesManager.loadLanguage(l.getNamespace());
    }
  }

  @Override
  public void languagesUnloaded(Iterable<LanguageRuntime> languages, boolean unloadAll) {
    myRulesManager.clear();
  }


  public static TypeChecker getInstance() {
    return INSTANCE;
  }

  private boolean isMainGenerationThread() {
    return Thread.currentThread() == myMainGenerationThread;
  }

  public SubtypingManager getSubtypingManager() {
    if (isMainGenerationThread()) {
      return mySubtypingManagerTracer;
    }
    return mySubtypingManager;
  }

  public RuntimeSupport getRuntimeSupport() {
    if (isMainGenerationThread()) {
      return myRuntimeSupportTracer;
    }
    return myRuntimeSupport;
  }

  public SubtypingCache getSubtypingCache() {
    if (isGenerationMode()) {
      SubtypingCache generationSubTypingCache = myGenerationSubTypingCache;
      if (generationSubTypingCache != null) {
        return generationSubTypingCache;
      }
    }
    return mySubtypingCache;
  }

  public SubtypingCache getGlobalSubtypingCache() {
    return myGlobalSubtypingCache;
  }

  public void enableGlobalSubtypingCache() {
    myGlobalSubtypingCache = createSubtypingCache();
  }

  public void clearGlobalSubtypingCache() {
    myGlobalSubtypingCache = null;
  }

  public RulesManager getRulesManager() {
    return myRulesManager;
  }

  public void enableTypesComputingForCompletion() {
    //todo add assertion that it is in synchronized with below (e.g. in write action)
    myComputedTypesForCompletion = new THashMap<SNode, SNode>(1);
    if (mySubtypingCache == null) {
      mySubtypingCache = createSubtypingCache();
    }
  }

  public void clearTypesComputedForCompletion() {
    //todo add assertion that it is in synchronized with above (e.g. in write action)
    myComputedTypesForCompletion = null;
    if (!isGenerationMode()) {
      mySubtypingCache = null;
    }
  }

  private SubtypingCache createSubtypingCache() {
    return new ConcurrentSubtypingCache();
  }

  public Pair<SNode, Boolean> getTypeComputedForCompletion(SNode node) {
    if (myComputedTypesForCompletion != null && myComputedTypesForCompletion.containsKey(node)) {
      return new Pair<SNode, Boolean>(myComputedTypesForCompletion.get(node), true);
    } else {
      return new Pair<SNode, Boolean>(null, false);
    }
  }

  public void putTypeComputedForCompletion(SNode node, SNode type) {
    if (myComputedTypesForCompletion != null) {
      myComputedTypesForCompletion.put(node, type);
    }
  }

  public void generationStarted(IPerformanceTracer performanceTracer) {
    myGenerationSubTypingCache = createSubtypingCache();
    initTracing(performanceTracer);
    myIsGenerationThread.set(Boolean.TRUE);
    myMainGenerationThread = Thread.currentThread();
  }

  public void generationFinished() {
    myGenerationSubTypingCache = null;
    disposeTracing();
    myIsGenerationThread.set(Boolean.FALSE);
    myMainGenerationThread = null;
  }

  public void generationWorkerStarted() {
    myIsGenerationThread.set(Boolean.TRUE);
  }

  public void generationWorkerFinished() {
    myIsGenerationThread.set(Boolean.FALSE);
  }

  public boolean isGenerationMode() {
    return myIsGenerationThread.get();
  }

  private void initTracing(IPerformanceTracer performanceTracer) {
    if (performanceTracer != null) {
      myPerformanceTracer = performanceTracer;
      TypeSystemReporter.getInstance().reset();
    }
  }

  private void disposeTracing() {
    if (myPerformanceTracer != null) {
      TypeSystemReporter.getInstance().printReport(10, myPerformanceTracer);
      myPerformanceTracer = null;
    }
  }

  public boolean hasPerformanceTracer() {
    return myPerformanceTracer != null;
  }

  public <T> T computeWithTrace(Computable<T> c, String taskName) {
    if (myPerformanceTracer != null) {
      try {
        myPerformanceTracer.push(taskName, true);
        return c.compute();
      } finally {
        myPerformanceTracer.pop();
      }
    } else {
      return c.compute();
    }
  }

  public InequalitySystem getInequalitiesForHole(SNode hole, boolean holeIsAType) {
    TypeCheckingContext typeCheckingContext = TypeContextManager.getInstance().createTypeCheckingContext(hole.getContainingRoot());
    typeCheckingContext.setSingleTypeComputation(true);
    InequalitySystem inequalitySystem = typeCheckingContext.getBaseNodeTypesComponent().computeInequalitiesForHole(hole, holeIsAType);
    typeCheckingContext.dispose();
    return inequalitySystem;
  }

  public SNode getInferredTypeOf(final SNode node) {
    if (node == null) return null;
    TypeCheckingContext typeCheckingContext =
      TypeContextManager.getInstance().createTypeCheckingContext(node);
    SNode type = typeCheckingContext.computeTypeInferenceMode(node);
    typeCheckingContext.dispose();
    return type;
  }

  @Nullable
  public SNode getTypeOf(final SNode node) {
    if (node == null) return null;
    fireNodeTypeAccessed(node);
    return TypeContextManager.getInstance().getTypeOf(node);
  }


  public SModelFqName getRuntimeTypesModelUID() {
    return TYPES_MODEL_UID;
  }

  public SModel getRuntimeTypesModel() {
    return AuxilaryRuntimeModel.getDescriptor().getSModel();
  }

  public boolean isGlobalIncrementalMode() {
    return !isGenerationMode();
  }

  private List<TypeRecalculatedListener> copyTypeRecalculatedListeners() {
    synchronized (LISTENERS_LOCK) {
      return new ArrayList<TypeRecalculatedListener>(myTypeRecalculatedListeners);
    }
  }

  public void addTypesReadListener(TypesReadListener typesReadListener) {
    assert myTypesReadListener.get() == null;
    myTypesReadListener.set(typesReadListener);
  }

  public void removeTypesReadListener(TypesReadListener typesReadListener) {
    assert myTypesReadListener.get() == typesReadListener;
    myTypesReadListener.set(null);
  }

  public void removeTypeRecalculatedListener(TypeRecalculatedListener typeRecalculatedListener) {
    synchronized (LISTENERS_LOCK) {
      myTypeRecalculatedListeners.remove(typeRecalculatedListener);
    }
  }

  public void addTypeRecalculatedListener(TypeRecalculatedListener typeRecalculatedListener) {
    synchronized (LISTENERS_LOCK) {
      if (!myTypeRecalculatedListeners.contains(typeRecalculatedListener)) {
        myTypeRecalculatedListeners.add(typeRecalculatedListener);
      }
    }
  }

  public void fireTypeWillBeRecalculatedForTerm(SNode term) {
    for (TypeRecalculatedListener typeRecalculatedListener : copyTypeRecalculatedListeners()) {
      typeRecalculatedListener.typeWillBeRecalculatedForTerm(term);
    }
  }

  private void fireNodeTypeAccessed(SNode term) {
    TypesReadListener typesReadListener = myTypesReadListener.get();
    if (typesReadListener != null) {
      typesReadListener.nodeTypeAccessed(term);
    }
  }
}
