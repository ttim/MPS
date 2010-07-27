/*
 * Copyright 2003-2010 JetBrains s.r.o.
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
package jetbrains.mps.smodel.constraints;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.constraints.structure.ConceptConstraints;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.structure.structure.ConceptDeclaration;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.lang.typesystem.structure.RuntimeTypeVariable;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.NodeReadAccessCasterInEditor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.IModule;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.behaviour.BehaviorConstants;
import jetbrains.mps.smodel.search.SModelSearchUtil;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.misc.StringBuilderSpinAllocator;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelConstraintsManager implements ApplicationComponent {
  private static final Logger LOG = Logger.getLogger(ModelConstraintsManager.class);

  private static final Pattern CONCEPT_FQNAME = Pattern.compile("(.*)\\.structure\\.(\\w+)$");

  public static ModelConstraintsManager getInstance() {
    return ApplicationManager.getApplication().getComponent(ModelConstraintsManager.class);
  }

  private Object myLock = new Object();
  private Map<String, List<IModelConstraints>> myAddedLanguageNamespaces = new HashMap<String, List<IModelConstraints>>();
  private Map<String, INodeReferentSetEventHandler> myNodeReferentSetEventHandlersMap = new HashMap<String, INodeReferentSetEventHandler>();
  private Map<String, INodePropertyGetter> myNodePropertyGettersCache = new HashMap<String, INodePropertyGetter>();
  private Map<String, INodePropertySetter> myNodePropertySettersCache = new HashMap<String, INodePropertySetter>();
  private Map<String, INodePropertyValidator> myNodePropertyValidatorsCache = new HashMap<String, INodePropertyValidator>();

  private Map<String, INodePropertyGetter> myNodePropertyGettersMap = new ConcurrentHashMap<String, INodePropertyGetter>();
  private Map<String, INodePropertySetter> myNodePropertySettersMap = new ConcurrentHashMap<String, INodePropertySetter>();
  private Map<String, INodePropertyValidator> myNodePropertyValidatorsMap = new ConcurrentHashMap<String, INodePropertyValidator>();

  private Map<String, INodeReferentSearchScopeProvider> myNodeReferentSearchScopeProvidersMap = new ConcurrentHashMap<String, INodeReferentSearchScopeProvider>();
  private Map<String, INodeReferentSearchScopeProvider> myNodeDefaultSearchScopeProvidersMap = new ConcurrentHashMap<String, INodeReferentSearchScopeProvider>();

  private Map<String, Method> myCanBeChildMethods = new HashMap<String, Method>();
  private Map<String, Method> myCanBeParentMethods = new HashMap<String, Method>();
  private Map<String, Method> myCanBeAncestorMethods = new HashMap<String, Method>();
  private Map<String, Method> myCanBeRootMethods = new HashMap<String, Method>();
  private Map<String, String> myDefaultConceptNames = new HashMap<String, String>();

  private Map<String, String> myConstraintClassNames = new HashMap<String, String>();

  public ModelConstraintsManager(ClassLoaderManager cm) {
  }

  public void initComponent() {
    MPSModuleRepository.getInstance().addModuleRepositoryListener(new ModuleRepositoryListener() {
      public void moduleAdded(IModule module) {
      }

      public void beforeModuleRemoved(IModule module) {
      }

      public void moduleRemoved(IModule module) {
        if (module instanceof Language) {
          processLanguageRemoved((Language) module);
        }
      }

      public void moduleInitialized(IModule module) {
      }

      public void moduleChanged(IModule module) {
      }
    });

    ClassLoaderManager.getInstance().addReloadHandler(new ReloadAdapter() {
      public void unload() {
        clearAll();
      }
    });
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Model Constraints Manager";
  }

  public void disposeComponent() {

  }

  public void registerNodePropertyGetter(String conceptFqName, String propertyName, INodePropertyGetter getter) {
    String key = conceptFqName + "#" + propertyName;
    INodePropertyGetter old = myNodePropertyGettersMap.put(key, getter);
    if(old != null) {
      LOG.error("property getter is already registered for key '" + key + "' : " + old);
    }
    synchronized (myLock) {
      myNodePropertyGettersCache.clear();
    }
  }

  public void unRegisterNodePropertyGetter(String conceptFqName, String propertyName) {
    myNodePropertyGettersMap.remove(conceptFqName + "#" + propertyName);
    synchronized (myLock) {
      myNodePropertyGettersCache.clear();
    }
  }

  public void registerNodePropertySetter(String conceptFqName, String propertyName, INodePropertySetter setter) {
    String key = conceptFqName + "#" + propertyName;
    INodePropertySetter old = myNodePropertySettersMap.put(key, setter);
    if(old != null) {
      LOG.error("property setter is already registered for key '" + key + "' : " + old);
    }

    synchronized (myLock) {
      myNodePropertySettersCache.clear();
    }
  }

  public void unRegisterNodePropertySetter(String conceptFqName, String propertyName) {
    myNodePropertySettersMap.remove(conceptFqName + "#" + propertyName);
    synchronized (myLock) {
      myNodePropertySettersCache.clear();
    }
  }

  public void registerNodePropertyValidator(String conceptFqName, String propertyName, INodePropertyValidator validator) {
    String key = conceptFqName + "#" + propertyName;
    INodePropertyValidator old = myNodePropertyValidatorsMap.put(key, validator);
    if(old != null) {
      LOG.error("property validator is already registered for key '" + key + "' : " + old);
    }
    synchronized (myLock) {
      myNodePropertyValidatorsCache.clear();
    }
  }

  public void unRegisterNodePropertyValidator(String conceptFqName, String propertyName) {
    myNodePropertyValidatorsMap.remove(conceptFqName + "#" + propertyName);
    synchronized (myLock) {
      myNodePropertyValidatorsCache.clear();
    }
  }

  public void registerNodeReferentSetEventHandler(String conceptFqName, String referentRole, INodeReferentSetEventHandler eventHandler) {
    String key = conceptFqName + "#" + referentRole;
    synchronized (myLock) {
      INodeReferentSetEventHandler old = myNodeReferentSetEventHandlersMap.put(key, eventHandler);
      if(old != null) {
        LOG.error("'set referent' event handler is already registered for key '" + key + "' : " + old);
      }
    }
  }

  public void unRegisterNodeReferentSetEventHandler(String conceptFqName, String referentRole) {
    synchronized (myLock) {
      myNodeReferentSetEventHandlersMap.remove(conceptFqName + "#" + referentRole);
    }
  }

  public INodeReferentSetEventHandler getNodeReferentSetEventHandler(SNode node, String referentRole) {
    String nodeConceptFqName = node.getConceptFqName();
    String originalKey = nodeConceptFqName + "#" + referentRole;
    synchronized (myLock) {
      INodeReferentSetEventHandler result = myNodeReferentSetEventHandlersMap.get(originalKey);
      if (result != null || myNodeReferentSetEventHandlersMap.containsKey(originalKey)) {
        return result;
      }

      // find set-event-handler and put to cache
      List<AbstractConceptDeclaration> hierarchy = SModelUtil_new.getConceptAndSuperConcepts(node.getConceptDeclarationAdapter());
      for (AbstractConceptDeclaration concept : hierarchy) {
        Language l = SModelUtil_new.getDeclaringLanguage(concept, GlobalScope.getInstance());
        ensureLanguageAdded(l);

        String conceptFqName = NameUtil.nodeFQName(concept);
        result = myNodeReferentSetEventHandlersMap.get(conceptFqName + "#" + referentRole);
        if (result != null) {
          break;
        }
      }

      myNodeReferentSetEventHandlersMap.put(originalKey, result);
      return result;
    }
  }

  public void registerNodeReferentSearchScopeProvider(String conceptFqName, String referenceRole, INodeReferentSearchScopeProvider provider) {
    String key = conceptFqName + "#" + referenceRole;
    INodeReferentSearchScopeProvider old = myNodeReferentSearchScopeProvidersMap.put(key, provider);
    if(old != null) {
      LOG.error("search scope provider is already registered for key '" + key + "' : " + old);
    }
  }

  public void unRegisterNodeReferentSearchScopeProvider(String conceptFqName, String referenceRole) {
    myNodeReferentSearchScopeProvidersMap.remove(conceptFqName + "#" + referenceRole);
  }

  public void registerNodeDefaultSearchScopeProvider(String conceptFqName, INodeReferentSearchScopeProvider provider) {
    INodeReferentSearchScopeProvider old = myNodeDefaultSearchScopeProvidersMap.put(conceptFqName, provider);
    if(old != null) {
      LOG.error("default search scope provider is already registered for concept '" + conceptFqName + "' : " + old);
    }
  }

  public void unRegisterNodeDefaultSearchScopeProvider(String conceptFqName) {
    myNodeDefaultSearchScopeProvidersMap.remove(conceptFqName);
  }

  public boolean isComplexNodeProperty(SNode node, String propertyName) {
    return getNodePropertyGetter(node, propertyName) != null || getNodePropertySetter(node, propertyName) != null;
  }

  public INodePropertyGetter getNodePropertyGetter(SNode node, String propertyName) {
    return (INodePropertyGetter) getNodePropertyGetterOrSetter(node, propertyName, false);
  }

  public INodePropertySetter getNodePropertySetter(SNode node, String propertyName) {
    return (INodePropertySetter) getNodePropertyGetterOrSetter(node, propertyName, true);
  }

  public boolean hasGetter(String conceptFqName, String property) {
    return getNodePropertyGetterOrSetter(conceptFqName, property, false) != null;
  }

  public IModelConstraints getNodePropertyGetterOrSetter(@NotNull final SNode node, @NotNull final String propertyName, final boolean isSetter) {
    return getNodePropertyGetterOrSetter(node.getConceptFqName(), propertyName, isSetter);
  }

  public IModelConstraints getNodePropertyGetterOrSetter(@NotNull final String conceptFqName, @NotNull final String propertyName, final boolean isSetter) {
    String namespace = NameUtil.namespaceFromConceptFQName(conceptFqName);

    // 'bootstrap' properties
    if (namespace.equals("jetbrains.mps.bootstrap.structureLanguage") && propertyName.equals(INamedConcept.NAME)
      && !conceptFqName.equals("jetbrains.mps.bootstrap.structureLanguage.structure.AnnotationLinkDeclaration")) {
      return null;
    }
    if (conceptFqName.equals(RuntimeTypeVariable.concept)) {
      // helgins ku-ku!
      return null;
    }

    final StringBuilder builder = StringBuilderSpinAllocator.alloc();
    try {
      builder.append('#');
      builder.append(propertyName);
      final String prefixedPropertyName = builder.toString();
      builder.setLength(0);

      builder.append(conceptFqName);
      builder.append(prefixedPropertyName);
      final String originalKey = builder.toString();

      synchronized (myLock) {
        if (isSetter) {
          if (myNodePropertySettersCache.containsKey(originalKey)) {
            return myNodePropertySettersCache.get(originalKey);
          }
        } else {
          if (myNodePropertyGettersCache.containsKey(originalKey)) {
            return myNodePropertyGettersCache.get(originalKey);
          }
        }

        return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<IModelConstraints>() {
          public IModelConstraints compute() {
            AbstractConceptDeclaration conceptDeclaration = SModelUtil_new.findConceptDeclaration(conceptFqName, GlobalScope.getInstance());
            List<AbstractConceptDeclaration> hierarchy = SModelUtil_new.getConceptAndSuperConcepts(conceptDeclaration);

            for (final AbstractConceptDeclaration concept : hierarchy) {
              Language l = SModelUtil_new.getDeclaringLanguage(concept, GlobalScope.getInstance());
              ensureLanguageAdded(l);

              final String conceptFqName = NameUtil.nodeFQName(concept);
              final IModelConstraints result;
              builder.setLength(0);
              builder.append(conceptFqName);
              builder.append(prefixedPropertyName);
              if (isSetter) {
                result = myNodePropertySettersMap.get(builder.toString());
              } else {
                result = myNodePropertyGettersMap.get(builder.toString());
              }
              if (result != null) {
                if (isSetter) {
                  myNodePropertySettersCache.put(originalKey, (INodePropertySetter) result);
                } else {
                  myNodePropertyGettersCache.put(originalKey, (INodePropertyGetter) result);
                }
                return result;
              }
            }

            // no setter/getter found
            if (isSetter) {
              myNodePropertySettersCache.put(originalKey, null);
            } else {
              myNodePropertyGettersCache.put(originalKey, null);
            }
            return null;
          }
        });
      }
    }
    finally {
      StringBuilderSpinAllocator.dispose(builder);
    }
  }

  public INodePropertyValidator getNodePropertyValidator(final SNode node, @NotNull String propertyName) {
    if (node == null) return null;

    final StringBuilder builder = new StringBuilder();
    builder.append('#');
    builder.append(propertyName);
    final String prefixedPropertyName = builder.toString();
    builder.setLength(0);

    String nodeConceptFqName = node.getConceptFqName();
    builder.append(nodeConceptFqName);
    builder.append(prefixedPropertyName);
    final String originalKey = builder.toString();

    synchronized (myLock) {
      INodePropertyValidator result = myNodePropertyValidatorsCache.get(originalKey);
      if (result != null || myNodePropertyValidatorsCache.containsKey(originalKey)) {
        return result;
      }

      return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<INodePropertyValidator>() {
        public INodePropertyValidator compute() {
          // find validator and put to cache
          List<AbstractConceptDeclaration> hierarchy = SModelUtil_new.getConceptAndSuperConcepts(node.getConceptDeclarationAdapter());
          for (AbstractConceptDeclaration concept : hierarchy) {
            Language l = SModelUtil_new.getDeclaringLanguage(concept, GlobalScope.getInstance());
            ensureLanguageAdded(l);

            String conceptFqName = NameUtil.nodeFQName(concept);
            builder.setLength(0);
            builder.append(conceptFqName);
            builder.append(prefixedPropertyName);
            INodePropertyValidator result = myNodePropertyValidatorsMap.get(builder.toString());
            if (result != null) {
              myNodePropertyValidatorsCache.put(originalKey, result);
              return result;
            }
          }

          // no setter/getter found
          myNodePropertyValidatorsCache.put(originalKey, null);
          return null;
        }
      });
    }
  }

  INodeReferentSearchScopeProvider getNodeReferentSearchScopeProvider(AbstractConceptDeclaration nodeConcept, String referentRole) {
    INodeReferentSearchScopeProvider result = null;
    result = getNodeReferentSearchScopeProviderNonDefault(nodeConcept, referentRole);
    if (result != null) {
      return result;
    }
    LinkDeclaration linkDeclaration = SModelSearchUtil.findLinkDeclaration(nodeConcept, referentRole);
    return getNodeDefaultSearchScopeProvider(linkDeclaration.getTarget());
  }

  private INodeReferentSearchScopeProvider getNodeDefaultSearchScopeProvider(AbstractConceptDeclaration referentConcept) {
    while (referentConcept != null) {
      Language l = SModelUtil_new.getDeclaringLanguage(referentConcept, GlobalScope.getInstance());
      ensureLanguageAdded(l);

      String conceptFqName = NameUtil.nodeFQName(referentConcept);
      INodeReferentSearchScopeProvider provider = myNodeDefaultSearchScopeProvidersMap.get(conceptFqName);
      if (provider != null) return provider;
      if (!(referentConcept instanceof ConceptDeclaration)) break;
      referentConcept = ((ConceptDeclaration) referentConcept).getExtends();
    }
    return null;
  }

  /**
   * use the ModelConstraintsUtil.getSearchScope()
   */
  private INodeReferentSearchScopeProvider getNodeReferentSearchScopeProviderNonDefault(AbstractConceptDeclaration nodeConcept, String referentRole) {
    List<AbstractConceptDeclaration> hierarchy = SModelUtil_new.getConceptAndSuperConcepts(nodeConcept);
    for (AbstractConceptDeclaration concept : hierarchy) {
      Language l = SModelUtil_new.getDeclaringLanguage(concept, GlobalScope.getInstance());
      ensureLanguageAdded(l);

      String conceptFqName = NameUtil.nodeFQName(concept);
      INodeReferentSearchScopeProvider provider = myNodeReferentSearchScopeProvidersMap.get(conceptFqName + "#" + referentRole);
      if (provider != null) return provider;
    }
    return null;
  }

  private void ensureLanguageAdded(Language language) {
    String namespace = language.getNamespace();
    synchronized (myLock) {
      if (myAddedLanguageNamespaces.containsKey(namespace)) {
        return;
      }

      LinkedList<IModelConstraints> loadedConstraints = new LinkedList<IModelConstraints>();
      myAddedLanguageNamespaces.put(namespace, loadedConstraints);
      loadConstraints(namespace, loadedConstraints);
    }
  }

  private void processLanguageRemoved(Language language) {
    String namespace = language.getNamespace();
    synchronized (myLock) {
      if (!myAddedLanguageNamespaces.containsKey(namespace)) {
        return;
      }

      List<IModelConstraints> loadedConstraints = myAddedLanguageNamespaces.get(namespace);
      for (IModelConstraints constraints : loadedConstraints) {
        constraints.unRegisterSelf(this);
      }
      myAddedLanguageNamespaces.remove(namespace);
    }
  }

  private void clearAll() {
    synchronized (myCanBeChildMethods) {
      myCanBeChildMethods.clear();
    }
    synchronized (myCanBeParentMethods) {
      myCanBeParentMethods.clear();
    }
    synchronized (myCanBeAncestorMethods) {
      myCanBeAncestorMethods.clear();
    }
    synchronized (myCanBeRootMethods) {
      myCanBeRootMethods.clear();
    }
    synchronized (myDefaultConceptNames) {
      myDefaultConceptNames.clear();
    }

    myNodePropertyGettersMap.clear();
    myNodePropertySettersMap.clear();
    myNodePropertyValidatorsMap.clear();
    myNodeReferentSearchScopeProvidersMap.clear();
    myNodeDefaultSearchScopeProvidersMap.clear();

    synchronized (myConstraintClassNames) {
      myConstraintClassNames.clear();
    }

    synchronized (myLock) {
      myNodeReferentSetEventHandlersMap.clear();
      for (List<IModelConstraints> loadedConstraints : myAddedLanguageNamespaces.values()) {
        for (IModelConstraints constraints : loadedConstraints) {
          constraints.unRegisterSelf(this);
        }
      }
      myAddedLanguageNamespaces.clear();

      // should be empty, clear once again
      myNodePropertyGettersCache.clear();
      myNodePropertySettersCache.clear();
      myNodePropertyValidatorsCache.clear();
    }
  }

  private void loadConstraints(String languageNamespace, List<IModelConstraints> loadedConstraints) {
    // load constraints
    Language l = MPSModuleRepository.getInstance().getLanguage(languageNamespace);
    assert l != null;
    String packageName = languageNamespace + ".constraints";
    SModelDescriptor constraintsModelDescriptor = l.getConstraintsModelDescriptor();
    if (constraintsModelDescriptor == null) {
      return;
    }

    try {
      String className = packageName + "." + "ConstraintsDescriptor";
      Class constraintsClass = l.getClass(className);
      if (constraintsClass == null) {
        // it is ok: constraints model can be empty
        return;
      }

      IModelConstraints constraints = (IModelConstraints) constraintsClass.newInstance();
      constraints.registerSelf(this);
      loadedConstraints.add(constraints);
    } catch (InstantiationException e) {
      LOG.error(e);
    } catch (IllegalAccessException e) {
      LOG.error(e);
    } catch (Throwable t) {
      LOG.error(t);
    }
  }

  public String getDefaultConcreteConceptFqName(String fqName, IScope scope) {
    synchronized (myDefaultConceptNames) {
      String result = myDefaultConceptNames.get(fqName);
      if (result != null || myDefaultConceptNames.containsKey(fqName)) {
        return result;
      }

      String behaviorClass = constraintsClassByConceptFqName(fqName);
      String namespace = NameUtil.namespaceFromConceptFQName(fqName);
      Language language = scope.getLanguage(namespace);
      if (language != null) {
        result = fqName;
        Class cls = language.getClass(behaviorClass);
        if (cls != null) {
          try {
            Method method = cls.getMethod(BehaviorConstants.GET_DEFAULT_CONCRETE_CONCEPT_FQ_NAME);
            try {
              result = (String) method.invoke(null);
            } catch (IllegalAccessException e) {
              LOG.error(e);
            } catch (InvocationTargetException e) {
              LOG.error(e);
            }
          } catch (NoSuchMethodException e) {
            //it's absolutely ok
          }
        }
        myDefaultConceptNames.put(fqName, result);
      }
      return result;
    }
  }

  private Method getCanBeAncestorMethod(SNode parentNode, IOperationContext context) {
    final String fqName = parentNode.getConceptFqName();
    synchronized (myCanBeAncestorMethods) {
      Method result = myCanBeAncestorMethods.get(fqName);
      if (result != null || myCanBeAncestorMethods.containsKey(fqName)) {
        return result;
      }

      Language language = context.getScope().getLanguage(NameUtil.namespaceFromConceptFQName(fqName));
      if (language != null) {
        Class behaviorClass = language.getClass(constraintsClassByConceptFqName(fqName));
        if (behaviorClass != null) {
          try {
            result = behaviorClass.getMethod(BehaviorConstants.CAN_BE_AN_ANCESTOR_METHOD_NAME, IOperationContext.class, CanBeAnAncestorContext.class);
          } catch (NoSuchMethodException e) {
            /* ignore */
          }
        }
      }

      myCanBeAncestorMethods.put(fqName, result);
      return result;
    }
  }

  private Method getCanBeParentMethod(SNode parentNode, IOperationContext context) {
    final String fqName = parentNode.getConceptFqName();
    synchronized (myCanBeParentMethods) {
      Method result = myCanBeParentMethods.get(fqName);
      if (result != null || myCanBeParentMethods.containsKey(fqName)) {
        return result;
      }

      Language language = context.getScope().getLanguage(NameUtil.namespaceFromConceptFQName(fqName));
      if (language != null) {
        Class behaviorClass = language.getClass(constraintsClassByConceptFqName(fqName));
        if (behaviorClass != null) {
          try {
            result = behaviorClass.getMethod(BehaviorConstants.CAN_BE_A_PARENT_METHOD_NAME, IOperationContext.class, CanBeAParentContext.class);
          } catch (NoSuchMethodException e) {
            /* ignore */
          }
        }
      }

      myCanBeParentMethods.put(fqName, result);
      return result;
    }
  }

  public boolean canBeAncestor(SNode parentNode, SNode childConcept, IOperationContext context) {
    Method m = getCanBeAncestorMethod(parentNode, context);
    if (m != null) {
      try {
        if (!(Boolean) m.invoke(null, context, new CanBeAnAncestorContext(parentNode, childConcept))) {
          return false;
        }
      } catch (IllegalAccessException e) {
        LOG.error(e);
      } catch (InvocationTargetException e) {
        LOG.error(e);
      }
    }
    final SNode parentOfParent = parentNode.getParent();
    return parentOfParent != null ? canBeAncestor(parentOfParent, childConcept, context): true;
  }

  public boolean canBeParent(SNode parentNode, SNode childConcept, SNode link, IOperationContext context) {
    Method m = getCanBeParentMethod(parentNode, context);
    if (m != null) {
      try {
        return (Boolean) m.invoke(null, context, new CanBeAParentContext(parentNode, childConcept, link));
      } catch (IllegalAccessException e) {
        LOG.error(e);
      } catch (InvocationTargetException e) {
        LOG.error(e);
      }
    }
    return true;
  }

  public SNode getCanBeParentBlock(SNode parentNode, IOperationContext context) {
    Method m = getCanBeParentMethod(parentNode, context);
    ConceptConstraints constraints = getClassConstraints(context, m);
    if (constraints == null) return null;
    return BaseAdapter.fromAdapter(constraints.getCanBeParent());
  }

  private Method getCanBeChildMethod(String conceptFqName, IOperationContext context) {
    synchronized (myCanBeChildMethods) {
      if (myCanBeChildMethods.containsKey(conceptFqName)) {
        return myCanBeChildMethods.get(conceptFqName);
      }

      IScope scope = context.getScope();
      AbstractConceptDeclaration topConcept = SModelUtil_new.findConceptDeclaration(conceptFqName, scope);

      if (topConcept != null) {
        List<AbstractConceptDeclaration> conceptAndSuperConcepts = SModelUtil_new.getConceptAndSuperConcepts(topConcept);
  
        for (AbstractConceptDeclaration concept : conceptAndSuperConcepts) {
          String fqName = NameUtil.nodeFQName(concept);
          Language language = scope.getLanguage(NameUtil.namespaceFromConcept(concept));
          if (language == null) {
            continue;
          }

          Class behaviorClass = language.getClass(constraintsClassByConceptFqName(fqName));
          if (behaviorClass == null) {
            continue;
          }

          try {
            Method method = behaviorClass.getMethod(BehaviorConstants.CAN_BE_A_CHILD_METHOD_NAME, IOperationContext.class, CanBeAChildContext.class);
            myCanBeChildMethods.put(conceptFqName, method);
            return method;
          } catch (NoSuchMethodException e) {
            //it's ok
          }
        }
      }

      myCanBeChildMethods.put(conceptFqName, null);
      return null;
    }
  }

  public boolean canBeChild(String fqName, IOperationContext context, SNode parentNode, SNode link) {
    Method method = getCanBeChildMethod(fqName, context);
    if (method != null) {
      try {
        SNode concept = BaseAdapter.fromAdapter(SModelUtil_new.findConceptDeclaration(fqName, context.getScope()));
        return (Boolean) method.invoke(null, context, new CanBeAChildContext(parentNode, link, concept));
      } catch (IllegalAccessException e) {
        LOG.error(e);
      } catch (InvocationTargetException e) {
        LOG.error(e);
      }
    }
    return true;
  }

  public SNode getCanBeChildBlock(IOperationContext context, String conceptFqName) {
    Method m = getCanBeChildMethod(conceptFqName, context);
    ConceptConstraints constraints = getClassConstraints(context, m);
    if (constraints == null) return null;
    return BaseAdapter.fromAdapter(constraints.getCanBeChild());
  }

  @Nullable
  private Method getCanBeRootMethod(String conceptFqName, IOperationContext context) {
    synchronized (myCanBeRootMethods) {
      if (myCanBeRootMethods.containsKey(conceptFqName)) {
        return myCanBeRootMethods.get(conceptFqName);
      }

      IScope scope = context.getScope();
      SNode concept = SModelUtil.findConceptDeclaration(conceptFqName, scope);

      if (concept != null) {
        String fqName = NameUtil.nodeFQName(concept);
        Language language = scope.getLanguage(NameUtil.namespaceFromConceptFQName(fqName));
        if (language != null) {

          Class behaviorClass = language.getClass(constraintsClassByConceptFqName(fqName));
          if (behaviorClass != null) {
            try {
              Method method = behaviorClass.getMethod(BehaviorConstants.CAN_BE_A_ROOT_METHOD_NAME, IOperationContext.class, CanBeARootContext.class);
              myCanBeRootMethods.put(conceptFqName, method);
              return method;
            } catch (NoSuchMethodException e) {
              //it's ok
            }
          }
        }
      }

      myCanBeRootMethods.put(conceptFqName, null);
      return null;
    }
  }

  public Method getAlternativeIconMethod(ConceptDeclaration concept) {
    String fqName = NameUtil.nodeFQName(concept);
    String namespace = NameUtil.namespaceFromConcept(concept);
    Language language = GlobalScope.getInstance().getLanguage(namespace);
    String behaviorClassName = constraintsClassByConceptFqName(fqName);
    Class behaviorClass = language.getClass(behaviorClassName);

    if (behaviorClass == null) {
      return null;
    }

    try {
      Method method = behaviorClass.getMethod(BehaviorConstants.GET_ALTERNATIVE_ICON_METHOD_NAME, SNode.class);
      return method;
    } catch (NoSuchMethodException e) {
      //it's ok
    }
    return null;
  }

  public SNode getCanBeRootBlock(IOperationContext context, String conceptFqName) {
    Method m = getCanBeRootMethod(conceptFqName, context);
    if (m == null) return null;
    ConceptConstraints constraints = getClassConstraints(context, m);
    if (constraints == null) return null;
    return BaseAdapter.fromAdapter(constraints.getCanBeRoot());
  }

  public boolean canBeRoot(IOperationContext context, String conceptFqName, SModel model) {
    AbstractConceptDeclaration concept = SModelUtil_new.findConceptDeclaration(conceptFqName, context.getScope());
    if (concept == null) {
      return false;
    }

    if (concept instanceof ConceptDeclaration && ((ConceptDeclaration) concept).getRootable()) {
      Method method = getCanBeRootMethod(conceptFqName, context);
      if (method != null) {
        try {
          return (Boolean) method.invoke(null, context, new CanBeARootContext(model));
        } catch (IllegalAccessException e) {
          LOG.error(e);
        } catch (InvocationTargetException e) {
          LOG.error(e);
        }
      } else {
        return true;
      }
    }

    return false;
  }

  private ConceptConstraints getClassConstraints(IOperationContext context, Method m) {
    Class cls = m.getDeclaringClass();
    String fqName = cls.getName();
    String modelName = NameUtil.namespaceFromLongName(fqName);
    String rootName = NameUtil.shortNameFromLongName(fqName);
    Language language = context.getScope().getLanguage(NameUtil.namespaceFromLongName(modelName));
    if (language == null) {
      return null;
    }
    SModelDescriptor sm = language.getConstraintsModelDescriptor();
    if (sm == null) return null;
    SNode root = sm.getSModel().getRootByName(rootName);
    if (root == null) return null;
    if (root.getAdapter() instanceof ConceptConstraints) {
      return (ConceptConstraints) root.getAdapter();
    }
    return null;
  }

  private String constraintsClassByConceptFqName(String fqName) {
    synchronized (myConstraintClassNames) {
      String cachedValue = myConstraintClassNames.get(fqName);
      if (cachedValue != null) {
        return cachedValue;
      }

      // TODO replace with code like in NameUtil.namespaceFromConceptFQName, remove cache
      Matcher m = CONCEPT_FQNAME.matcher(fqName);
      if (m.matches()) {
        String result = m.group(1) + ".constraints." + m.group(2) + "_Constraints";
        myConstraintClassNames.put(fqName, result);
        return result;
      } else {
        throw new RuntimeException();
      }
    }
  }
}
