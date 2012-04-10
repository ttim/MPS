package jetbrains.mps.baseLanguage.scopes;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Map;
import jetbrains.mps.baseLanguage.search.MethodResolveUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class InstanceMethodDeclarationScope extends BaseMethodsScope {
  public InstanceMethodDeclarationScope(SNode classifierNode, Iterable<SNode> extendedClassifiers) {
    super(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), classifierNode, extendedClassifiers);
  }

  public String getSignatureForOverriding(SNode method, SNode contextClassifier) {
    return ClassifierScopeUtils.getMethodSignatureForOverriding(contextClassifier, method);
  }

  @Nullable
  @Override
  public SNode resolveMethod(SNode contextNode, @NotNull String refText, List<SNode> actualArguments, List<SNode> methods) {
    // two variants: 
    if (SNodeOperations.isInstanceOf(contextNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation")) {
      // as part of DotExpression 
      SNode instanceType = SNodeOperations.cast(((SNode) BehaviorManager.getInstance().invoke(Object.class, ((SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(contextNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), "call_getDotExpression_1224687669172", new Class[]{SNode.class})), "call_getOperandType_8871623299328377715", new Class[]{SNode.class})), "jetbrains.mps.baseLanguage.structure.ClassifierType");
      Map<SNode, SNode> typeByTypeVar = MethodResolveUtil.getTypesByTypeVars(SLinkOperations.getTarget(instanceType, "classifier", false), SLinkOperations.getTargets(instanceType, "parameter", true));
      return MethodResolveUtil.chooseByParameterType(methods, actualArguments, typeByTypeVar);
    } else {
      // as local 
      Map<SNode, SNode> typeByTypeVar = ClassifierScopeUtils.resolveClassifierTypeVars(classifier);
      return MethodResolveUtil.chooseByParameterType(methods, actualArguments, typeByTypeVar);
    }
  }

  @Override
  public Iterable<SNode> getMethodsFromGroup(Iterable<SNode> groupWithEqualSignature) {
    // if != nonAbstract - use it 
    Iterable<SNode> nonAbstractMethods = Sequence.fromIterable(groupWithEqualSignature).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), "virtual_isAbstract_1232982539764", new Class[]{SNode.class})));
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration");
      }
    });
    if (Sequence.fromIterable(nonAbstractMethods).isNotEmpty()) {
      // todo: is it right? 
      return ((int) Sequence.fromIterable(nonAbstractMethods).count() == 1 ?
        nonAbstractMethods :
        Sequence.fromIterable(nonAbstractMethods).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SNodeOperations.getParent(it) != SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object");
          }
        })
      );
    } else {
      return super.getMethodsFromGroup(groupWithEqualSignature);
    }
  }
}
