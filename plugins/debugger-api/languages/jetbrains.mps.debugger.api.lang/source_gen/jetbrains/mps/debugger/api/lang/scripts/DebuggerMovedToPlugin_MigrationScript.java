package jetbrains.mps.debugger.api.lang.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class DebuggerMovedToPlugin_MigrationScript extends BaseMigrationScript {
  public DebuggerMovedToPlugin_MigrationScript(IOperationContext operationContext) {
    super("Fix references to debugger classes");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix classifier types";
      }

      public String getAdditionalInfo() {
        return "Fix classifier types";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.ClassifierType";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", "classifier"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.findAndReplace(node, SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", "classifier"))), new _FunctionTypes._return_P1_E0<String, SNode>() {
          public String invoke(SNode node) {
            return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier"), "resolveInfo");
          }
        }, "jetbrains.mps.baseLanguage.structure.Classifier");
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix instance method calls";
      }

      public String getAdditionalInfo() {
        return "Fix instance method calls";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation", "instanceMethodDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.resolveAndReplace(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation", "instanceMethodDeclaration"))));
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix local instance method calls";
      }

      public String getAdditionalInfo() {
        return "Fix local instance method calls";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall", "instanceMethodDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.resolveAndReplace(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall", "instanceMethodDeclaration"))));
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix super method calls";
      }

      public String getAdditionalInfo() {
        return "Fix super method calls";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.SuperMethodCall";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.SuperMethodCall", "instanceMethodDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.resolveAndReplace(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.SuperMethodCall", "instanceMethodDeclaration"))));
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix super constructor invokations";
      }

      public String getAdditionalInfo() {
        return "Fix super constructor invokations";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.SuperConstructorInvocation";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ConstructorInvocationStatement", "constructorDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.findAndReplace(node, SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ConstructorInvocationStatement", "constructorDeclaration"))), new _FunctionTypes._return_P1_E0<String, SNode>() {
          public String invoke(SNode node) {
            return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), "resolveInfo");
          }
        }, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration");
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix enum constant reference";
      }

      public String getAdditionalInfo() {
        return "Fix enum constant reference";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.EnumConstantReference";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.EnumConstantReference", "enumConstantDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.findAndReplace(node, SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.EnumConstantReference", "enumClass"))), new _FunctionTypes._return_P1_E0<String, SNode>() {
          public String invoke(SNode node) {
            return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.EnumClass"), "resolveInfo");
          }
        }, "jetbrains.mps.baseLanguage.structure.EnumClass");
        StubUtil.resolveAndReplace(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.EnumConstantReference", "enumConstantDeclaration"))));
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix class creators";
      }

      public String getAdditionalInfo() {
        return "Fix class creators";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.ClassCreator";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassCreator", "constructorDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.findAndReplace(node, SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassCreator", "constructorDeclaration"))), new _FunctionTypes._return_P1_E0<String, SNode>() {
          public String invoke(SNode node) {
            return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), "resolveInfo");
          }
        }, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration");
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix local instance fields references";
      }

      public String getAdditionalInfo() {
        return "Fix local instance fields references";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference", "fieldDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.resolveAndReplace(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.FieldDeclaration"), SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference", "fieldDeclaration"))));
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Fix instance fields references";
      }

      public String getAdditionalInfo() {
        return "Fix instance fields references";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.FieldReferenceOperation";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        SReference reference = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", "fieldDeclaration"));
        return StubUtil.isReferenceToDebuggerStub(reference);
      }

      public void doUpdateInstanceNode(SNode node) {
        StubUtil.resolveAndReplace(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.FieldDeclaration"), SLinkOperations.getRole(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", "fieldDeclaration"))));
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
