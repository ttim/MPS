package jetbrains.mps.make.script.structure;

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
      case 983572414:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.ResultStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case -741479940:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.ResourceType", new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Type"});
      case 1427448848:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.OutputResources", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case -1101840932:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.JobDefinition", new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"});
      case 575325786:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.InputResourcesParameter", new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"});
      case -102130137:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.QueryDefinition", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.baseLanguage.structure.IWillBeClassifier"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.IWillBeClassifier", "jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"});
      case -1702025755:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.QueryParameterDeclaration", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"});
      case 1354309897:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.Option", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"});
      case -950406463:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.Text", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"});
      case 1079744641:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.OptionExpression", new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"});
      case 501708771:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.OptionType", new String[]{"jetbrains.mps.baseLanguage.structure.Type", "jetbrains.mps.baseLanguage.structure.IWillBeClassifier"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.IWillBeClassifier", "jetbrains.mps.baseLanguage.structure.Type"});
      case -123496991:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.ExpectedOption", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.make.script.structure.IExpected", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.baseLanguage.structure.IWillBeClassifier"}, new String[]{"jetbrains.mps.make.script.structure.IExpected"}, new String[]{"jetbrains.mps.baseLanguage.structure.IWillBeClassifier", "jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"});
      case -1739978164:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.Expected", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"});
      case -1672155938:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.ExpectedInput", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.make.script.structure.IExpected"}, new String[]{"jetbrains.mps.make.script.structure.IExpected"}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"});
      case -443646447:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.JobDeclaration", new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"});
      case -902242003:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.IExpected", new String[]{}, new String[]{}, new String[]{});
      case -1879092157:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.RelayQueryExpression", new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"});
      case 722524617:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.ConfigDefinition", new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"});
      case -1001578878:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.ReportFeedbackStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case -861662775:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.BeginWorkStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case 1713558928:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.AdvanceWorkStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case 1362544503:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.FinishWorkStatement", new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"});
      case 69496797:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.make.script.structure.AllWorkLeftExpression", new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"});
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
