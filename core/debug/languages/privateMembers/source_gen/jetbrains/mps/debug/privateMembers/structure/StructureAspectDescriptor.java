package jetbrains.mps.debug.privateMembers.structure;

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
      case 1470068757:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.debug.privateMembers.structure.PrivateFieldReferenceOperation", new String[]{"jetbrains.mps.baseLanguage.structure.FieldReferenceOperation"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.FieldReferenceOperation"});
      case 279156242:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.debug.privateMembers.structure.PrivateInstanceMethodCallOperation", new String[]{"jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"});
      case -795608384:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.debug.privateMembers.structure.PrivateStaticFieldReference", new String[]{"jetbrains.mps.baseLanguage.structure.StaticFieldReference"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.StaticFieldReference"});
      case 227879342:
        return new StructureAspectDescriptor.DataBasedStructureDescriptor("jetbrains.mps.debug.privateMembers.structure.PrivateStaticMethodCall", new String[]{"jetbrains.mps.baseLanguage.structure.StaticMethodCall"}, new String[]{}, new String[]{"jetbrains.mps.baseLanguage.structure.StaticMethodCall"});
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
