package jetbrains.mps.debug.customViewers.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    if ("jetbrains.mps.debug.customViewers.structure.ValueType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.ValueType"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.ArrayValueType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.ArrayValueType"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.ObjectValueType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.ObjectValueType"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.PrimitiveValueType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.PrimitiveValueType"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.CustomWatchable".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.CustomWatchable"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.CustomWatchablesContainer".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.CustomWatchablesContainer"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.CustomViewer".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.CustomViewer"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.WatchableType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.WatchableType"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.WatchableCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new WatchableCreator_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.GetWatchablesBlock_ConceptFunction".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.GetWatchablesBlock_ConceptFunction"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.OriginalValue_ConceptFunctionParameter".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.OriginalValue_ConceptFunctionParameter"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.FieldsListOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new FieldsListOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.FieldOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new FieldOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.ElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ElementOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.GetValuePresentation_ConceptFunction".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.GetValuePresentation_ConceptFunction"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.CanWrapValue_ConceptFunction".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.CanWrapValue_ConceptFunction"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.ClassNameOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ClassNameOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.ClassFqNameOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ClassFqNameOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.SizeOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new SizeOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.AllElementsOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AllElementsOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.ElementsRangeOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ElementsRangeOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.CallMethodOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new CallMethodOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.JavaValueOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new JavaValueOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.StringValueType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.StringValueType"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.StringValueOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new StringValueOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.IsInstanceOfOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new IsInstanceOfOperation_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.HighLevelCustomViewer".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.HighLevelCustomViewer"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.GetHighLevelValuePresentation_ConceptFunction".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new GetHighLevelValuePresentation_ConceptFunction_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.GetHighLevelWatchablesBlock_ConceptFunction".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new GetHighLevelWatchablesBlock_ConceptFunction_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.CanWrapHighLevelValue_ConceptFunction".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new CanWrapHighLevelValue_ConceptFunction_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.HighLevelValue_ConceptFunctionParameter".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.HighLevelValue_ConceptFunctionParameter"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.HighLevelWatchableCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new HighLevelWatchableCreator_Constraints());
    }
    if ("jetbrains.mps.debug.customViewers.structure.WatchablesListCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.WatchablesListCreator"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.WatchableListType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.WatchableListType"));
    }
    if ("jetbrains.mps.debug.customViewers.structure.ToProcessMethod".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.debug.customViewers.structure.ToProcessMethod"));
    }

    return null;
  }
}
