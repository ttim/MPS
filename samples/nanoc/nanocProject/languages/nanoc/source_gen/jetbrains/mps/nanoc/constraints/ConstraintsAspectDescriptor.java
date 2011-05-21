package jetbrains.mps.nanoc.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    if ("jetbrains.mps.nanoc.structure.File".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.File"));
    }
    if ("jetbrains.mps.nanoc.structure.CType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CType"));
    }
    if ("jetbrains.mps.nanoc.structure.CInt".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CInt"));
    }
    if ("jetbrains.mps.nanoc.structure.CChar".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CChar"));
    }
    if ("jetbrains.mps.nanoc.structure.CFloat".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CFloat"));
    }
    if ("jetbrains.mps.nanoc.structure.CShort".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CShort"));
    }
    if ("jetbrains.mps.nanoc.structure.CLong".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CLong"));
    }
    if ("jetbrains.mps.nanoc.structure.CDouble".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CDouble"));
    }
    if ("jetbrains.mps.nanoc.structure.CExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CExpression"));
    }
    if ("jetbrains.mps.nanoc.structure.CStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CStatement"));
    }
    if ("jetbrains.mps.nanoc.structure.VarDecl".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new VarDecl_Constraints());
    }
    if ("jetbrains.mps.nanoc.structure.VarDeclStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.VarDeclStatement"));
    }
    if ("jetbrains.mps.nanoc.structure.CWhile".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CWhile"));
    }
    if ("jetbrains.mps.nanoc.structure.CBody".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CBody"));
    }
    if ("jetbrains.mps.nanoc.structure.CParenthesis".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CParenthesis"));
    }
    if ("jetbrains.mps.nanoc.structure.CBinaryOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CBinaryOp"));
    }
    if ("jetbrains.mps.nanoc.structure.DivOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.DivOp"));
    }
    if ("jetbrains.mps.nanoc.structure.PlusOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.PlusOp"));
    }
    if ("jetbrains.mps.nanoc.structure.MultOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.MultOp"));
    }
    if ("jetbrains.mps.nanoc.structure.MinusOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.MinusOp"));
    }
    if ("jetbrains.mps.nanoc.structure.IntConst".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.IntConst"));
    }
    if ("jetbrains.mps.nanoc.structure.CExpressionStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CExpressionStatement"));
    }
    if ("jetbrains.mps.nanoc.structure.CAssignmentExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CAssignmentExpression"));
    }
    if ("jetbrains.mps.nanoc.structure.VarRef".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.VarRef"));
    }
    if ("jetbrains.mps.nanoc.structure.EqualOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.EqualOp"));
    }
    if ("jetbrains.mps.nanoc.structure.LessOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.LessOp"));
    }
    if ("jetbrains.mps.nanoc.structure.GreaterOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.GreaterOp"));
    }
    if ("jetbrains.mps.nanoc.structure.LessEqOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.LessEqOp"));
    }
    if ("jetbrains.mps.nanoc.structure.GreaterEqOp".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.GreaterEqOp"));
    }
    if ("jetbrains.mps.nanoc.structure.CFor".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.nanoc.structure.CFor"));
    }

    return null;
  }
}
