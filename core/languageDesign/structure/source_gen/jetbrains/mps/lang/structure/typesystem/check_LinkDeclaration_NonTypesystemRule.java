package jetbrains.mps.lang.structure.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.core.behavior.IDeprecatable_Behavior;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ITranslator;
import jetbrains.mps.internal.collections.runtime.ISequence;
import jetbrains.mps.internal.collections.runtime.ISequenceIterableAdapter;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_LinkDeclaration_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {

  public check_LinkDeclaration_NonTypesystemRule() {
  }

  public void applyRule(final SNode linkToCheck, final TypeCheckingContext typeCheckingContext) {
    if ((SLinkOperations.getTarget(linkToCheck, "target", false) != null)) {
      if (IDeprecatable_Behavior.call_isDeprecated_1224609060727(SLinkOperations.getTarget(linkToCheck, "target", false))) {
        String error = BaseConcept_Behavior.call_getPresentation_1213877396640(SLinkOperations.getTarget(linkToCheck, "target", false));
        {
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.reportWarning(linkToCheck, error + " is deprecated" + (SPropertyOperations.getInteger(SLinkOperations.getTarget(linkToCheck, "target", false), "build") != 0 ?
            " since b." + SPropertyOperations.getInteger(SLinkOperations.getTarget(linkToCheck, "target", false), "build") :
            ""
          ), "r:00000000-0000-4000-0000-011c8959028f(jetbrains.mps.lang.structure.typesystem)", "1224250219917", intentionProvider);
        }
      }
    }
    // link role shouldn't hide roles in super-concepts
    if (SPropertyOperations.getString(linkToCheck, "role") == null) {
      return;
    }
    SNode declaringConcept = SNodeOperations.getAncestor(linkToCheck, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration", false, false);
    List<SNode> supers = SConceptOperations.getDirectSuperConcepts(declaringConcept, false);
    Iterable<SNode> linksInSupers = ListSequence.fromList(supers).translate(new ITranslator <SNode, SNode>() {

      public ISequence<SNode> translate(final SNode concept) {
        return new ISequenceIterableAdapter <SNode>() {

          public Iterator<SNode> iterator() {
            return new YieldingIterator <SNode>() {

              private int __CP__ = 0;
              private List<SNode> _3_links;
              private SNode _4_link;
              private Iterator<SNode> _4_link_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 4:
                      this._4_link_it = this._3_links.iterator();
                    case 5:
                      if (!(this._4_link_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._4_link = this._4_link_it.next();
                      this.__CP__ = 6;
                      break;
                    case 7:
                      this.__CP__ = 5;
                      this.yield(this._4_link);
                      return true;
                    case 0:
                      this._3_links = SLinkOperations.getTargets(concept, "linkDeclaration", true);
                      this.__CP__ = 4;
                      break;
                    case 6:
                      this.__CP__ = 7;
                      break;
                    default:
                      break __loop__;
                  }
                } while(true);
                return false;
              }

            };
          }

        };
      }

    });
    for(SNode link : linksInSupers) {
      if (SPropertyOperations.getString(linkToCheck, "role").equals(SPropertyOperations.getString(link, "role"))) {
        {
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.reportTypeError(linkToCheck, "link '" + SPropertyOperations.getString(link, "role") + "' is already declared in " + SPropertyOperations.getString(SNodeOperations.getAncestor(link, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration", false, false), "name"), "r:00000000-0000-4000-0000-011c8959028f(jetbrains.mps.lang.structure.typesystem)", "1212181840083", intentionProvider);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.structure.structure.LinkDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
