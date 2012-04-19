package jetbrains.mps.baseLanguage.scopes;

/*Generated by MPS */

import jetbrains.mps.scope.DelegatingScope;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.scope.ModelPlusImportedScope;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IterableUtils;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import java.util.Collection;
import jetbrains.mps.project.IModule;
import jetbrains.mps.util.IterableUtil;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.LanguageID;
import jetbrains.mps.smodel.SModelId;
import jetbrains.mps.smodel.StubMigrationHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import java.util.Collections;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class ClassifiersScope extends DelegatingScope {
  protected static Log log = LogFactory.getLog(ClassifiersScope.class);

  private final SModel model;
  private final IScope scope;

  public ClassifiersScope(SModel model, IScope scope, String conceptFqName) {
    super(new ModelPlusImportedScope(model, false, scope, conceptFqName));
    // todo: not use delegating, use just getClassifiersByModel 
    this.model = model;
    this.scope = scope;
  }

  public List<SNode> getClassifiersByRefName(SModel model, @NotNull String refName) {
    List<SNode> result = new ArrayList<SNode>();

    String simpleName = refName.substring(Math.max(refName.lastIndexOf("$"), refName.lastIndexOf(".")) + 1);
    for (SNode classifier : getClassifiersByModelAndSimpleNamePrefix(model, scope, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Classifier"), simpleName)) {
      if (refName.equals(getRefName(classifier))) {
        ListSequence.fromList(result).addElement(classifier);
      }
    }
    return result;
  }

  @Override
  public SNode resolve(SNode contextNode, String refText) {
    // todo: CRAP, rewrite it! 
    String classname = refText;
    int dotIndex = classname.lastIndexOf(".");
    if (dotIndex >= 0) {
      // try local nested classes 
      List<SNode> localClassifiers = getClassifiersByRefName(model, classname);
      if (ListSequence.fromList(localClassifiers).count() >= 1) {
        return ListSequence.fromList(localClassifiers).first();
      }

      if (classname.contains("$")) {
        // search everywhere 
        String package_ = classname.substring(0, dotIndex);
        classname = classname.substring(dotIndex + 1).replace('$', '.');
        return resolveClass(package_, null, classname);
      } else {
        String[] parts = classname.split("\\.");
        for (int sizeOfClassifier = 1; sizeOfClassifier <= parts.length; sizeOfClassifier++) {
          String packageName = IterableUtils.join(Sequence.fromIterable(Sequence.fromArray(parts)).take(parts.length - sizeOfClassifier), ".");
          String className = IterableUtils.join(Sequence.fromIterable(Sequence.fromArray(parts)).skip(parts.length - sizeOfClassifier), ".");
          SNode resolved = resolveClass(packageName, null, className);
          if (resolved != null) {
            return resolved;
          }
        }
      }
      // search everywhere 
      String package_ = classname.substring(0, dotIndex);
      classname = classname.substring(dotIndex + 1).replace('$', '.');

      return resolveClass(package_, null, classname);
    }

    SModelReference targetModelReference = model.getSModelReference();
    if (targetModelReference.getSModelId() != null) {
      SModelDescriptor targetModel = scope.getModelDescriptor(targetModelReference);
      if (targetModel == null) {
        return null;
      }
      return ListSequence.fromList(getClassifiersByRefName(targetModel.getSModel(), classname)).first();
    }
    SModelFqName modelname = targetModelReference.getSModelFqName();
    return resolveClass(modelname.getLongName(), modelname.getStereotype(), classname);
  }

  public SNode resolveClass(String modelname, String stereotype, String nestedClassName) {
    List<SNode> classifiers = new ArrayList<SNode>();
    for (SModelDescriptor model : Sequence.fromIterable(getVisibleModels())) {
      SModelFqName modelFqName = model.getSModelReference().getSModelFqName();
      if (!(modelFqName.getLongName().equals(modelname))) {
        continue;
      }
      if (stereotype != null && !(modelFqName.getStereotype().equals(stereotype))) {
        continue;
      }

      ListSequence.fromList(classifiers).addSequence(ListSequence.fromList(getClassifiersByRefName(model.getSModel(), nestedClassName)));
    }

    if (ListSequence.fromList(classifiers).isEmpty()) {
      return null;
    }
    if (ListSequence.fromList(classifiers).count() > 1) {
      for (SNode cls : ListSequence.fromList(classifiers)) {
        if (SNodeOperations.getModel(cls) == model) {
          return cls;
        }
        if (check_npo0wh_a0b0a0e0c_0(check_npo0wh_a0a1a0a4a2_0(model)) == check_npo0wh_a0b0a0e0c(check_npo0wh_a0a1a0a4a2(SNodeOperations.getModel(cls)))) {
          return cls;
        }
      }
      Iterable<SNode> userClassifiers = ListSequence.fromList(classifiers).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SModelStereotype.isUserModel(SNodeOperations.getModel(it));
        }
      });
      if ((int) Sequence.fromIterable(userClassifiers).count() == 1) {
        return Sequence.fromIterable(userClassifiers).first();
      }

      // trying stubs 
      SModelDescriptor stub = getStubModelByName(modelname);
      if (stub != null) {
        Iterable<SNode> stubClassifiers = getClassifiersByRefName(stub.getSModel(), nestedClassName);
        if ((int) Sequence.fromIterable(stubClassifiers).count() == 1) {
          return Sequence.fromIterable(stubClassifiers).first();
        }
      }

      final StringBuilder warn = new StringBuilder();
      warn.append("reference can't be resolved: ");
      warn.append(nestedClassName);
      warn.append(" in ");
      warn.append(model.getLongName());
      warn.append(" can reference nodes from models: ");
      ListSequence.fromList(classifiers).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          warn.append(SNodeOperations.getModel(it).getSModelReference()).append("; ");
        }
      });

      if (log.isWarnEnabled()) {
        log.warn(warn);
      }
      return null;
    }
    return ListSequence.fromList(classifiers).getElement(0);
  }

  private Iterable<SModelDescriptor> getVisibleModels() {
    Collection<IModule> visibleModules = IterableUtil.asCollection(scope.getVisibleModules());
    return Sequence.fromIterable(((Iterable<IModule>) visibleModules)).translate(new ITranslator2<IModule, SModelDescriptor>() {
      public Iterable<SModelDescriptor> translate(IModule it) {
        return it.getOwnModelDescriptors();
      }
    }).distinct();
  }

  @Nullable
  private SModelDescriptor getStubModelByName(String packageName) {
    String stereo = SModelStereotype.getStubStereotypeForId(LanguageID.JAVA);
    SModelId id = StubMigrationHelper.convertModelUIDInScope(stereo + "#" + packageName, getVisibleModels());
    return scope.getModelDescriptor(new SModelReference(new SModelFqName(packageName, stereo), id));
  }

  @Override
  public String getReferenceText(SNode contextNode, SNode node) {
    // <node> 
    // todo: should use fqName 
    return getRefName(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier"));
  }

  private static String getRefName(SNode classifier) {
    String name = SPropertyOperations.getString(classifier, "name");
    if (name == null) {
      name = "";
    }
    SNode parent = SNodeOperations.getParent(classifier);
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.Classifier")) {
      return getRefName(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.Classifier")) + "." + name;
    }
    return name;
  }

  public static Iterable<SNode> getClassifiersByModelAndSimpleNamePrefix(final SModel model, IScope scope, SNode concreteConcept, @Nullable String prefix) {
    // for simplicity - prefix is prefix for simple name 
    // todo: use FastNodeFinder directly 
    return Sequence.fromIterable(new ModelPlusImportedScope(model, false, scope, INamedConcept_Behavior.call_getFqName_1213877404258(concreteConcept)) {
      @Override
      public String getReferenceText(SNode contextNode, SNode node) {
        if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
          // todo: why???, now it's fix for bug with jetbrains.mps.ui.sandbox 
          return null;
        }
        return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier"), "name");
      }

      @Override
      public Collection<SModelDescriptor> getModels() {
        return Collections.singletonList(model.getModelDescriptor());
      }
    }.getAvailableElements(prefix)).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.Classifier");
      }
    });
  }

  private static IModule check_npo0wh_a0b0a0e0c(SModelDescriptor checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }

  private static SModelDescriptor check_npo0wh_a0a1a0a4a2(SModel checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelDescriptor();
    }
    return null;
  }

  private static IModule check_npo0wh_a0b0a0e0c_0(SModelDescriptor checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }

  private static SModelDescriptor check_npo0wh_a0a1a0a4a2_0(SModel checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelDescriptor();
    }
    return null;
  }
}
