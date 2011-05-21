package jetbrains.mps.lang.editor.editorTest.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    if ("jetbrains.mps.lang.editor.editorTest.structure.TestBlockList".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.TestBlockList"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.BracesBlock".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.BracesBlock"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.IBaseTestBlock".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.IBaseTestBlock"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.StubBlock".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.StubBlock"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.VerticalLayoutBlockList".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.VerticalLayoutBlockList"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.BracesStubBlock".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.BracesStubBlock"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.InspectorBlock".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.InspectorBlock"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.ReferenceAnnotataion".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.ReferenceAnnotataion"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.SideTranformWrapper".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.SideTranformWrapper"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.IntegerLiteral".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.IntegerLiteral"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.BinaryExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.BinaryExpression"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.PlusExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.PlusExpression"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.AttractsFocusBlock".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.AttractsFocusBlock"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.VariableDeclarationBlock".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.VariableDeclarationBlock"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.VariableDeclarationReference".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new VariableDeclarationReference_Constraints());
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.NonEmptyProperty".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.lang.editor.editorTest.structure.NonEmptyProperty"));
    }
    if ("jetbrains.mps.lang.editor.editorTest.structure.NotEditableVaraileReference".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new NotEditableVaraileReference_Constraints());
    }

    return null;
  }
}
