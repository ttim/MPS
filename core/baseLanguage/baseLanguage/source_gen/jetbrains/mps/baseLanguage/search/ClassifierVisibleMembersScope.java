package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.structure.Classifier;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.search.IReferenceInfoResolver;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.structure.ClassConcept;
import jetbrains.mps.baseLanguage.structure.IMethodCall;
import jetbrains.mps.lang.core.structure.BaseConcept;

public class ClassifierVisibleMembersScope extends AbstractSearchScope {
  protected static Log log = LogFactory.getLog(ClassifierVisibleMembersScope.class);

  private SNode myClassifierType;
  private final SNode myContextNode;
  private final ClassifierAndSuperClassifiersScope myClassifierScope;

  @Deprecated
  public ClassifierVisibleMembersScope(@Nullable ClassifierType classifierType, @Nullable SNode contextNode, int constraint) {
    this(SNodeOperations.cast(check_y8c6cm_a0a0a(classifierType), "jetbrains.mps.baseLanguage.structure.ClassifierType"), contextNode, constraint);
  }

  public ClassifierVisibleMembersScope(@Nullable SNode classifierType, @Nullable SNode contextNode, int constraint) {
    this.myClassifierType = classifierType;
    this.myContextNode = contextNode;
    this.myClassifierScope = new ClassifierAndSuperClassifiersScope(((Classifier) SNodeOperations.getAdapter(SLinkOperations.getTarget(classifierType, "classifier", false))), constraint);
  }

  @NotNull
  public List<SNode> getNodes(final Condition<SNode> condition) {
    return myClassifierScope.getNodes(new Condition<SNode>() {
      public boolean met(SNode node) {
        SNode member = SNodeOperations.as(node, "jetbrains.mps.baseLanguage.structure.ClassifierMember");
        return (member != null) && ((myContextNode == null) || isVisible(member)) && condition.met(node);
      }
    });
  }

  public boolean isInScope(SNode node) {
    if (myContextNode == null || !(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.ClassifierMember"))) {
      if (log.isErrorEnabled()) {
        log.error("isInScope(" + node + ") - context is null or not ClassifierMember");
      }
      return super.isInScope(node);
    }
    return myClassifierScope.getClassifierNodes().contains(SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.Classifier", false, false)) && isVisible(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassifierMember"));
  }

  public IReferenceInfoResolver getReferenceInfoResolver(SNode referenceNode, SNode targetConcept) {
    if (this.myClassifierType != null) {
      if (SModelUtil.isAssignableConcept(targetConcept, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration"))) {
        SNode classifier = SLinkOperations.getTarget(this.myClassifierType, "classifier", false);
        if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.ClassConcept") && SNodeOperations.isInstanceOf(referenceNode, "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
          return new StaticMethodReferenceInfoResolver(this.myClassifierScope, (ClassConcept) ((Classifier) SNodeOperations.getAdapter(classifier)), ((IMethodCall) ((BaseConcept) SNodeOperations.getAdapter(referenceNode))).getActualArguments());
        }
      } else
      if (SModelUtil.isAssignableConcept(targetConcept, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"))) {
        if (((BaseConcept) SNodeOperations.getAdapter(referenceNode)) instanceof IMethodCall) {
          return new InstanceMethodReferenceInfoResolver(this.myClassifierScope, ((ClassifierType) SNodeOperations.getAdapter(this.myClassifierType)), ((IMethodCall) ((BaseConcept) SNodeOperations.getAdapter(referenceNode))).getActualArguments());
        }
      }
    }
    return this.myClassifierScope.getReferenceInfoResolver(referenceNode, targetConcept);
  }

  protected boolean isVisible(SNode member) {
    return VisibilityUtil.isVisible(myContextNode, member);
  }

  private static SNode check_y8c6cm_a0a0a(ClassifierType p) {
    if (null == p) {
      return null;
    }
    return p.getNode();
  }
}
