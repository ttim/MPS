package jetbrains.mps.baseLanguage.tuples.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.baseLanguage.tuples.behavior.NamedTupleDeclaration_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_NamedTupleDeclaration_extends_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_NamedTupleDeclaration_extends_NonTypesystemRule() {
  }

  public void applyRule(final SNode ntd, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if ((SLinkOperations.getTarget(ntd, "extends", false) != null)) {
      List<SNode> allExtends = NamedTupleDeclaration_Behavior.call_allExtends_3142843783245461132(SLinkOperations.getTarget(ntd, "extends", false));
      if (!(!(ListSequence.fromList(allExtends).contains(ntd)))) {
        BaseQuickFixProvider intentionProvider = null;
        IErrorTarget errorTarget = new NodeErrorTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(ntd, "extends", false), "circular extends relation", "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "7367153454745473434", intentionProvider, errorTarget);
      }
      for (final SNode cmp : ListSequence.fromList(SLinkOperations.getTargets(ntd, "component", true))) {
        if (cmp != null) {
          if (!(!(ListSequence.fromList(allExtends).translate(new ITranslator2<SNode, SNode>() {
            public Iterable<SNode> translate(SNode td) {
              return SLinkOperations.getTargets(td, "component", true);
            }
          }).any(new IWhereFilter<SNode>() {
            public boolean accept(SNode c) {
              return SPropertyOperations.getString(cmp, "name") == SPropertyOperations.getString(c, "name");
            }
          })))) {
            BaseQuickFixProvider intentionProvider = null;
            IErrorTarget errorTarget = new NodeErrorTarget();
            IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(cmp, "duplicate component name", "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "7367153454745473486", intentionProvider, errorTarget);
          }
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }
}
