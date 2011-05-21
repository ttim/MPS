package jetbrains.mps.baseLanguage.closures.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    if ("jetbrains.mps.baseLanguage.closures.structure.FunctionType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new FunctionType_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionExpression"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.InvokeExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.InvokeExpression"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.YieldStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.YieldStatement"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.UnboundClosureParameterDeclaration".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new UnboundClosureParameterDeclaration_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.PairOfInts".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.PairOfInts"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.StringPropertyHolder".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.StringPropertyHolder"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new InvokeFunctionOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.YieldAllStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.YieldAllStatement"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.ClosureControlStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.ClosureControlStatement"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.ControlClosureLiteral".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.ControlClosureLiteral"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionContainer".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ControlAbstractionContainer_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionDeclaration".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionDeclaration"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedFunctionType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedFunctionType"));
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.CompactInvokeFunctionExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new CompactInvokeFunctionExpression_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.FunctionMethodDeclaration".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new FunctionMethodDeclaration_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.closures.structure.AbstractFunctionType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AbstractFunctionType_Constraints());
    }

    return null;
  }
}
