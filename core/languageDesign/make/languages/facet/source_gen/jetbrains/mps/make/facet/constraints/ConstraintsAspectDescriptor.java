package jetbrains.mps.make.facet.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  private static String[] stringSwitchCases_2qnle6_a0a0a = new String[]{"jetbrains.mps.make.facet.structure.ExtendsFacetReference", "jetbrains.mps.make.facet.structure.FacetDeclaration", "jetbrains.mps.make.facet.structure.FacetReference", "jetbrains.mps.make.facet.structure.FacetReferenceExpression", "jetbrains.mps.make.facet.structure.ForeignParametersComponentExpression", "jetbrains.mps.make.facet.structure.ForeignParametersExpression", "jetbrains.mps.make.facet.structure.IFacet", "jetbrains.mps.make.facet.structure.LocalParametersComponentExpression", "jetbrains.mps.make.facet.structure.LocalParametersExpression", "jetbrains.mps.make.facet.structure.NamedFacetReference", "jetbrains.mps.make.facet.structure.ParametersDeclaration", "jetbrains.mps.make.facet.structure.RelatedFacetReference", "jetbrains.mps.make.facet.structure.ResourceClassifierType", "jetbrains.mps.make.facet.structure.ResourceTypeDeclaration", "jetbrains.mps.make.facet.structure.TargetDeclaration", "jetbrains.mps.make.facet.structure.TargetDependency"};

  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_2qnle6_a0a0a, fqName)) {
      case 6:
        return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.make.facet.structure.IFacet"));
      case 1:
        return new DataHolderConstraintsDescriptor(new FacetDeclaration_Constraints());
      case 14:
        return new DataHolderConstraintsDescriptor(new TargetDeclaration_Constraints());
      case 15:
        return new DataHolderConstraintsDescriptor(new TargetDependency_Constraints());
      case 2:
        return new DataHolderConstraintsDescriptor(new FacetReference_Constraints());
      case 0:
        return new DataHolderConstraintsDescriptor(new ExtendsFacetReference_Constraints());
      case 11:
        return new DataHolderConstraintsDescriptor(new RelatedFacetReference_Constraints());
      case 10:
        return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.make.facet.structure.ParametersDeclaration"));
      case 8:
        return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.make.facet.structure.LocalParametersExpression"));
      case 7:
        return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.make.facet.structure.LocalParametersComponentExpression"));
      case 5:
        return new DataHolderConstraintsDescriptor(new ForeignParametersExpression_Constraints());
      case 4:
        return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.make.facet.structure.ForeignParametersComponentExpression"));
      case 13:
        return new DataHolderConstraintsDescriptor(new ResourceTypeDeclaration_Constraints());
      case 12:
        return new DataHolderConstraintsDescriptor(new ResourceClassifierType_Constraints());
      case 3:
        return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.make.facet.structure.FacetReferenceExpression"));
      case 9:
        return new DataHolderConstraintsDescriptor(new NamedFacetReference_Constraints());
      default:
        return null;
    }
  }
}
