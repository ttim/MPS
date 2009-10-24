package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class AssignmentExpression_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_deriveType_1213877435747(SNode thisNode, SNode expression) {
    SNode type = null;
    if (SNodeOperations.getParent(expression) == thisNode && SNodeOperations.hasRole(expression, "jetbrains.mps.baseLanguage.structure.AssignmentExpression", "rValue")) {
      type = SNodeOperations.cast(SNodeOperations.copyNode(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(thisNode, "lValue", true))), "jetbrains.mps.baseLanguage.structure.Type");
    }
    return type;
  }

  public static boolean virtual_isReadAsignment_1215696236033(SNode thisNode) {
    return false;
  }

  public static boolean call_canConvertToLocalVariableDeclaration_1221573334330(SNode thisNode) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.structure.ExpressionStatement");
  }

  public static SNode call_convertToLocalVariableDeclaration_1221573391693(SNode thisNode) {
    assert SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.structure.ExpressionStatement");
    SNode exprStatement = SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.structure.ExpressionStatement");
    SNode varType = SNodeOperations.cast(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(thisNode, "rValue", true)), "jetbrains.mps.baseLanguage.structure.Type");
    SNode varDeclStmnt = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement", null);
    SPropertyOperations.set(SLinkOperations.getTarget(varDeclStmnt, "localVariableDeclaration", true), "name", SPropertyOperations.getString(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false), "name"));
    SLinkOperations.setTarget(SLinkOperations.getTarget(varDeclStmnt, "localVariableDeclaration", true), "type", SNodeOperations.copyNode(varType), true);
    SLinkOperations.setTarget(SLinkOperations.getTarget(varDeclStmnt, "localVariableDeclaration", true), "initializer", SNodeOperations.copyNode(SLinkOperations.getTarget(thisNode, "rValue", true)), true);
    SNodeOperations.replaceWithAnother(exprStatement, varDeclStmnt);
    return varDeclStmnt;
  }
}
