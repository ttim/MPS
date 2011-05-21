package jetbrains.mps.baseLanguage.collections.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.DataHolderConstraintsDescriptor;
import jetbrains.mps.smodel.structure.EmptyConstraintsDataHolder;

public class ConstraintsAspectDescriptor extends DescriptorProvider<ConstraintsDescriptor> {
  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    if ("jetbrains.mps.baseLanguage.collections.structure.ListType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ListType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SequenceType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SequenceType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SequenceOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new SequenceOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ToListOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ToListOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ForEachStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ForEachStatement"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ForEachVariableReference_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new ListCreatorWithInit_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AddElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AddElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AddAllElementsOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AddAllElementsOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IsEmptyOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.IsEmptyOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetLastOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetLastOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetIndexOfOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetIndexOfOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ContainsOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ContainsOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SkipOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SkipOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TakeOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.TakeOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.PageOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.PageOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveAllElementsOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveAllElementsOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ReverseOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ReverseOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IsNotEmptyOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.IsNotEmptyOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.UnionOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.UnionOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.BinaryOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.BinaryOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IntersectOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.IntersectOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ExcludeOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ExcludeOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SortDirection".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SortDirection"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.DistinctOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.DistinctOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ConcatOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ConcatOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ToArrayOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ToArrayOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MapType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.HashMapCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new HashMapCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapElement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MapElement"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapOperationExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MapOperationExpression"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new MapOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetKeysOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetKeysOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapInitializer".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MapInitializer"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapEntry".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MapEntry"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapRemoveOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MapRemoveOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ToIteratorOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ToIteratorOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MapClearOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MapClearOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TranslateOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.TranslateOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.WhereOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.WhereOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SelectOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SelectOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new SmartClosureParameterDeclaration_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.InternalSequenceOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.InternalSequenceOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.VisitAllOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.VisitAllOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.DisjunctOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.DisjunctOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SortOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SortOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ChunkOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ChunkOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.CutOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.CutOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TailOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.TailOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ComparatorSortOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ComparatorSortOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SequenceCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SequenceCreator"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SkipStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SkipStatement"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.StopStatement".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.StopStatement"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.InsertElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.InsertElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SetElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SetElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ListElementAccessExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ListElementAccessExpression"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.FindFirstOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.FindFirstOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.FindLastOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.FindLastOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SetType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SetType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.HashSetCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new HashSetCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AbstractSetOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AbstractSetOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveSetElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveSetElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AddAllSetElementsOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AddAllSetElementsOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveAllSetElementsOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveAllSetElementsOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ClearSetOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ClearSetOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.LinkedListCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new LinkedListCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AddFirstElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AddFirstElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AddLastElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AddLastElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveAtElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveAtElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ClearAllElementsOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ClearAllElementsOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveFirstElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveFirstElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveLastElementOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveLastElementOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.DowncastExpression".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.DowncastExpression"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AnyOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AnyOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AllOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AllOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SingletonSequenceCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SingletonSequenceCreator"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetIteratorOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetIteratorOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IteratorType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.IteratorType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AbstractIteratorOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AbstractIteratorOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.HasNextOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.HasNextOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetNextOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetNextOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetCurrentOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetCurrentOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MoveNextOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MoveNextOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.EnumeratorType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.EnumeratorType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AbstractEnumeratorOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AbstractEnumeratorOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetEnumeratorOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetEnumeratorOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AbstractContainerCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AllConstant".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AllConstant_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ContainsValueOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ContainsValueOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.GetValuesOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.GetValuesOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ContainerIteratorType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ContainerIteratorType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new RemoveOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.LinkedHashMapCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.LinkedHashMapCreator"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.LinkedHashSetCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.LinkedHashSetCreator"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SortedMapType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SortedMapType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TreeMapCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new TreeMapCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SortedMapOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new SortedMapOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.HeadMapOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.HeadMapOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TailMapOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.TailMapOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SubMapOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SubMapOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SortedSetType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SortedSetType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TreeSetCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new TreeSetCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SortedSetOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new SortedSetOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.HeadSetOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.HeadSetOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TailSetOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.TailSetOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SubSetOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SubSetOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AsSequenceOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AsSequenceOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MappingType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MappingType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.JoinOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new JoinOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AbstractMappingOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new AbstractMappingOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ValueAccessOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ValueAccessOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.KeyAccessOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.KeyAccessOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.MappingsSetOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.MappingsSetOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.PutAllOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.PutAllOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.QueueType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.QueueType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AbstractContainerType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AbstractContainerType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.DequeType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.DequeType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IContainerOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new IContainerOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IListOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new IListOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IQueueOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new IQueueOperation_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.StackType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.StackType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IDequeOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.IDequeOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.IStackOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.IStackOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.PopOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.PopOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.PushOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.PushOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.PriorityQueueCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.PriorityQueueCreator"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.LinkedListType".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.LinkedListType"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SingleArgumentSequenceOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SingleArgumentSequenceOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.NoArgumentsSequenceOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.NoArgumentsSequenceOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.RemoveWhereOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.RemoveWhereOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.AlsoSortOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.AlsoSortOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ContainsAllOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ContainsAllOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.SubListOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.SubListOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.PeekOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.PeekOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.HeadListOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.HeadListOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.TailListOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.TailListOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.CustomContainerDeclaration".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new CustomContainerDeclaration_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.CustomContainers".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.CustomContainers"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.CustomContainerCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new CustomContainerCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.CustomMapCreator".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new CustomMapCreator_Constraints());
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ForEachVariable".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ForEachVariable"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ReduceLeftOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ReduceLeftOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.ReduceRightOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.ReduceRightOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.FoldLeftOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.FoldLeftOperation"));
    }
    if ("jetbrains.mps.baseLanguage.collections.structure.FoldRightOperation".equals(fqName)) {
      return new DataHolderConstraintsDescriptor(new EmptyConstraintsDataHolder("jetbrains.mps.baseLanguage.collections.structure.FoldRightOperation"));
    }

    return null;
  }
}
