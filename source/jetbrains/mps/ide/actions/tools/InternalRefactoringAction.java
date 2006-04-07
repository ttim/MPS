package jetbrains.mps.ide.actions.tools;

import jetbrains.mps.baseLanguage.*;
import jetbrains.mps.ide.action.ActionContext;
import jetbrains.mps.ide.action.MPSAction;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Condition;

import java.util.*;

/**
 * serves as template: just loads all models from MPSFileModelDescriptor and "process" them.
 */
public class InternalRefactoringAction extends MPSAction {
  public static boolean SHOW = true;

  private static final Logger LOG = Logger.getLogger(InternalRefactoringAction.class);

  public InternalRefactoringAction() {
    super("... refactor static members ...");
  }

  public void execute(ActionContext context) {
    System.out.println(" -- load models -- ");
    List<SModel> models = loadAllModels();

    System.out.println(" -- process models (" + models.size() + ") -- ");
    for (SModel model : models) {
      System.out.println("process model: " + model.getUID().toString());
      processModel(model);
    }
  }


  /**
   * load all that has MPSFileModelDescriptor
   */
  private List<SModel> loadAllModels() {
    // load all models
    List<SModel> models = new LinkedList<SModel>();
    boolean wasLoaded = true;
    while (wasLoaded) {
      wasLoaded = false;
      List<SModelDescriptor> modelDescriptors = new LinkedList<SModelDescriptor>(GlobalScope.getInstance().getModelDescriptors());
      for (SModelDescriptor descriptor : modelDescriptors) {
        if (descriptor.getStereotype().equals("java_stub")) continue;
        if (!descriptor.isInitialized()) {
          wasLoaded = true;
          System.out.println("load model: " + descriptor.getModelUID().toString());
        }
        SModel model = descriptor.getSModel();
        if (!models.contains(model)) {
          models.add(model);
        }
      }
    }
    return models;
  }

  /**
   * perform "refactoring"
   */
  private void processModel(SModel model) {
//    _checkUsageOfSomeDeprecatedFeatures(model);
    _refactorStaticMemberReferences(model);
  }


  private void _refactorStaticMemberReferences(SModel model) {
    // ---- static field ref.
    List<SNode> staticFieldReferences = SModelUtil.allNodes(model, new Condition<SNode>() {
      public boolean met(SNode object) {
        return object instanceof StaticFieldReference;
      }
    });
    System.out.println("// ---- static field ref.:" + staticFieldReferences.size());
    for (SNode node : staticFieldReferences) {
      StaticFieldReference staticFieldReference = (StaticFieldReference) node;
      ClassifierType classifierType = staticFieldReference.getClassifierType();
      if (classifierType != null) {
        if (classifierType.getChildCount() > 0) {
          System.out.println("   !!!! do not replace !!! in " + SModelUtil.getRootParent(classifierType).getDebugText());
          staticFieldReference.setClassifier(classifierType.getClassifier());
        } else {
          System.out.println("    *** replace ***");
          staticFieldReference.setClassifierType(null);
          staticFieldReference.setClassifier(classifierType.getClassifier());
        }
      }
    }

    // ---- static method call.
    List<SNode> staticMethodCalls = SModelUtil.allNodes(model, new Condition<SNode>() {
      public boolean met(SNode object) {
        return object instanceof StaticMethodCall;
      }
    });
    System.out.println("// ---- static method call:" + staticMethodCalls.size());
    for (SNode node : staticMethodCalls) {
      StaticMethodCall staticMethodCall = (StaticMethodCall) node;
      ClassifierType classifierType = staticMethodCall.getClassType();
      if (classifierType != null) {
        if (classifierType.getChildCount() > 0) {
          System.out.println("   !!!! do not replace !!! in " + SModelUtil.getRootParent(classifierType).getDebugText());
          Classifier classifier = classifierType.getClassifier();
          if (classifier instanceof ClassConcept) {
            staticMethodCall.setClassConcept((ClassConcept) classifier);
          }
        } else {
          System.out.println("    *** replace ***");
          staticMethodCall.setClassType(null);
          Classifier classifier = classifierType.getClassifier();
          if (classifier instanceof ClassConcept) {
            staticMethodCall.setClassConcept((ClassConcept) classifier);
          }
        }
      }
    }

    // ---- enum const ref.
    List<SNode> enumConstantRefs = SModelUtil.allNodes(model, new Condition<SNode>() {
      public boolean met(SNode object) {
        return object instanceof EnumConstantReference;
      }
    });
    System.out.println("// ---- enum const ref:" + enumConstantRefs.size());
    for (SNode node : enumConstantRefs) {
      EnumConstantReference enumConstantReference = (EnumConstantReference) node;
      ClassifierType classifierType = enumConstantReference.getClassType();
      if (classifierType != null) {
        if (classifierType.getChildCount() > 0) {
          System.out.println("   !!!! do not replace !!! in " + SModelUtil.getRootParent(classifierType).getDebugText());
          Classifier classifier = classifierType.getClassifier();
          if (classifier instanceof EnumClass) {
            enumConstantReference.setEnumClass((EnumClass) classifier);
          }
        } else {
          System.out.println("    *** replace ***");
          enumConstantReference.setClassType(null);
          Classifier classifier = classifierType.getClassifier();
          if (classifier instanceof EnumClass) {
            enumConstantReference.setEnumClass((EnumClass) classifier);
          }
        }
      }
    }
  }


  private void _checkUsageOfSomeDeprecatedFeatures(SModel model) {
    SModelUtil.allNodes(model, new Condition<SNode>() {
      public boolean met(SNode object) {
        // SURROUND WITH ..
//        if (object instanceof CellActionSetDeclaration) {
//          CellActionSetDeclaration cellActionSet = (CellActionSetDeclaration) object;
//          Iterator<CellActionModel> iterator = cellActionSet.actionDeclarations();
//          for (SNode actionModel : cellActionSet) {
//            if (actionModel instanceof ActionModel_SurroundNodeWith) {
//              System.out.println("(!)SURROUND WITH ...: " + actionModel.getDebugText() + " in " + SModelUtil.getRootParent(actionModel));
//            }
//          }
//        }

//        if (object instanceof CellModel_RefNode) {
//          CellModel_RefNode cellModel = (CellModel_RefNode) object;
//          if (cellModel.getErrorActionSet() != null) {
//            System.out.println("(!)ErrorActionSet:" + cellModel.getDebugText() + " in " + SModelUtil.getRootParent(cellModel));
//          }
//        }
//        if (object instanceof CellModel_RefCell) {
//          CellModel_RefCell cellModel = (CellModel_RefCell) object;
//          if (cellModel.getNullActionSet() != null) {
//            System.out.println("(!)NullActionSet:" + cellModel.getDebugText() + " in " + SModelUtil.getRootParent(cellModel));
//          }
//        }

        // DISABLE action
//        if (object instanceof CellActionModel) {
//          CellActionModel action = (CellActionModel) object;
//          if (action.getDisabled()) {
//            System.out.println("(!)action DIASBLED: " + action.getDebugText() + " in " + SModelUtil.getRootParent(action));
//          }
//        }
        return false;
      }
    });
  }
}
