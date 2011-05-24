package jetbrains.mps.baseLanguage.closures.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.StructureDescriptor;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import java.util.Collections;

public class StructureAspectDescriptor extends DescriptorProvider<StructureDescriptor> {
  public StructureAspectDescriptor() {
  }

  public StructureDescriptor getDescriptor(String conceptFqName) {
    switch ((conceptFqName).hashCode()) {
      case 131995956:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.FunctionType", new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Type"});
      case 1285562922:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionExpression", new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.lang.core.structure.IDeprecatable"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.lang.core.structure.IDeprecatable"});
      case 258022262:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.IStatementListContainer", "jetbrains.mps.baseLanguage.structure.IContainsStatementList", "jetbrains.mps.baseLanguage.structure.IMethodLike", "jetbrains.mps.baseLanguage.structure.IFinalWrapper", "jetbrains.mps.baseLanguage.structure.IControlFlowInterrupter"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.IContainsStatementList", "jetbrains.mps.baseLanguage.structure.IControlFlowInterrupter", "jetbrains.mps.baseLanguage.structure.IFinalWrapper", "jetbrains.mps.baseLanguage.structure.IMethodLike", "jetbrains.mps.baseLanguage.structure.IStatementListContainer"});
      case -1356334542:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.InvokeExpression", new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"});
      case -1617564188:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.YieldStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case 1427710889:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.UnboundClosureParameterDeclaration", new String[]{"jetbrains.mps.baseLanguage.structure.ParameterDeclaration"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.ParameterDeclaration"});
      case -28029225:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.PairOfInts", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"});
      case -1786475948:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.StringPropertyHolder", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"});
      case 1069353877:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionOperation", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.baseLanguage.structure.IOperation"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.IOperation", "jetbrains.mps.lang.core.structure.BaseConcept"});
      case 228589625:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.YieldAllStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case 1139512650:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral", new String[]{"jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"}, new String[]{"jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.IContainsStatementList", "jetbrains.mps.baseLanguage.structure.IControlFlowInterrupter", "jetbrains.mps.baseLanguage.structure.IFinalWrapper", "jetbrains.mps.baseLanguage.structure.IMethodLike", "jetbrains.mps.baseLanguage.structure.IStatementListContainer"});
      case 28365227:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.ClosureControlStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case 1681761519:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.ControlClosureLiteral", new String[]{"jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral"}, new String[]{"jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", "jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral"}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.IContainsStatementList", "jetbrains.mps.baseLanguage.structure.IControlFlowInterrupter", "jetbrains.mps.baseLanguage.structure.IFinalWrapper", "jetbrains.mps.baseLanguage.structure.IMethodLike", "jetbrains.mps.baseLanguage.structure.IStatementListContainer"});
      case 738468150:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionContainer", new String[]{"jetbrains.mps.baseLanguage.structure.Classifier"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Classifier"});
      case -1237847825:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionDeclaration", new String[]{"jetbrains.mps.baseLanguage.structure.GenericDeclaration", "jetbrains.mps.baseLanguage.structure.ClassifierMember", "jetbrains.mps.lang.core.structure.IResolveInfo", "jetbrains.mps.baseLanguage.structure.HasAnnotation"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.ClassifierMember", "jetbrains.mps.baseLanguage.structure.GenericDeclaration", "jetbrains.mps.baseLanguage.structure.HasAnnotation", "jetbrains.mps.lang.core.structure.IResolveInfo"});
      case -760940536:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedFunctionType", new String[]{"jetbrains.mps.baseLanguage.closures.structure.FunctionType"}, new String[]{"jetbrains.mps.baseLanguage.closures.structure.FunctionType"}, new String[]{"jetbrains.mps.baseLanguage.structure.Type"});
      case 1385843753:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.CompactInvokeFunctionExpression", new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"});
      case 1246863903:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.FunctionMethodDeclaration", new String[]{"jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"});
      case -1521674122:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.baseLanguage.closures.structure.AbstractFunctionType", new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Type"});
      default:
        return null;
    }
  }

  public static class DataBasedStructureDescriptor extends StructureDescriptor {
    private ImmutableList<String> parents;
    private Set<String> ancestors;

    public DataBasedStructureDescriptor(String fqName, String[] parents, String[] ancestorsInLanguage, String[] ancestorsNotInLanguage) {
      this.parents = ImmutableList.copyOf(parents);
      this.ancestors = getAncestors(fqName, ancestorsInLanguage, ancestorsNotInLanguage);
    }

    public Set<String> getAncestorsNames() {
      return ancestors;
    }

    public boolean isAssignableTo(String toConceptFqName) {
      return ancestors.contains(toConceptFqName);
    }

    public List<String> getParentsNames() {
      return parents;
    }

    private static Set<String> getAncestors(String conceptFqName, String[] ancestorsInLanguage, String[] ancestorsNotInLanguage) {
      Set<String> result = new HashSet(ancestorsInLanguage.length + 1);

      result.add(conceptFqName);
      for (String ancestor : ancestorsInLanguage) {
        result.add(ancestor);
      }

      ConceptRegistry registry = ConceptRegistry.getInstance();
      for (String parent : ancestorsNotInLanguage) {
        if (!(result.contains(parent))) {
          result.addAll(registry.getStructureDescriptor(parent).getAncestorsNames());
        }
      }

      return Collections.unmodifiableSet(result);
    }
  }
}
