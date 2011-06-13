package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.baseLanguage.collections.structure.AddAllElementsOperation", "jetbrains.mps.baseLanguage.collections.structure.AddAllSetElementsOperation", "jetbrains.mps.baseLanguage.collections.structure.AddElementOperation", "jetbrains.mps.baseLanguage.collections.structure.AddFirstElementOperation", "jetbrains.mps.baseLanguage.collections.structure.AddLastElementOperation", "jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation", "jetbrains.mps.baseLanguage.collections.structure.AllConstant", "jetbrains.mps.baseLanguage.collections.structure.AllOperation", "jetbrains.mps.baseLanguage.collections.structure.AlsoSortOperation", "jetbrains.mps.baseLanguage.collections.structure.AnyOperation", "jetbrains.mps.baseLanguage.collections.structure.AsSequenceOperation", "jetbrains.mps.baseLanguage.collections.structure.ClearAllElementsOperation", "jetbrains.mps.baseLanguage.collections.structure.ClearSetOperation", "jetbrains.mps.baseLanguage.collections.structure.ComparatorSortOperation", "jetbrains.mps.baseLanguage.collections.structure.ConcatOperation", "jetbrains.mps.baseLanguage.collections.structure.ContainerIteratorType", "jetbrains.mps.baseLanguage.collections.structure.ContainsAllOperation", "jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation", "jetbrains.mps.baseLanguage.collections.structure.ContainsOperation", "jetbrains.mps.baseLanguage.collections.structure.ContainsValueOperation", "jetbrains.mps.baseLanguage.collections.structure.CustomContainerCreator", "jetbrains.mps.baseLanguage.collections.structure.CustomContainerDeclaration", "jetbrains.mps.baseLanguage.collections.structure.CustomContainers", "jetbrains.mps.baseLanguage.collections.structure.CustomMapCreator", "jetbrains.mps.baseLanguage.collections.structure.CutOperation", "jetbrains.mps.baseLanguage.collections.structure.DequeType", "jetbrains.mps.baseLanguage.collections.structure.DisjunctOperation", "jetbrains.mps.baseLanguage.collections.structure.DistinctOperation", "jetbrains.mps.baseLanguage.collections.structure.DowncastExpression", "jetbrains.mps.baseLanguage.collections.structure.EnumeratorType", "jetbrains.mps.baseLanguage.collections.structure.ExcludeOperation", "jetbrains.mps.baseLanguage.collections.structure.FindFirstOperation", "jetbrains.mps.baseLanguage.collections.structure.FindLastOperation", "jetbrains.mps.baseLanguage.collections.structure.FoldLeftOperation", "jetbrains.mps.baseLanguage.collections.structure.FoldRightOperation", "jetbrains.mps.baseLanguage.collections.structure.ForEachStatement", "jetbrains.mps.baseLanguage.collections.structure.ForEachVariable", "jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference", "jetbrains.mps.baseLanguage.collections.structure.GetCurrentOperation", "jetbrains.mps.baseLanguage.collections.structure.GetElementOperation", "jetbrains.mps.baseLanguage.collections.structure.GetEnumeratorOperation", "jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation", "jetbrains.mps.baseLanguage.collections.structure.GetIndexOfOperation", "jetbrains.mps.baseLanguage.collections.structure.GetIteratorOperation", "jetbrains.mps.baseLanguage.collections.structure.GetKeysOperation", "jetbrains.mps.baseLanguage.collections.structure.GetLastIndexOfOperation", "jetbrains.mps.baseLanguage.collections.structure.GetLastOperation", "jetbrains.mps.baseLanguage.collections.structure.GetNextOperation", "jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation", "jetbrains.mps.baseLanguage.collections.structure.GetValuesOperation", "jetbrains.mps.baseLanguage.collections.structure.HasNextOperation", "jetbrains.mps.baseLanguage.collections.structure.HashMapCreator", "jetbrains.mps.baseLanguage.collections.structure.HashSetCreator", "jetbrains.mps.baseLanguage.collections.structure.HeadListOperation", "jetbrains.mps.baseLanguage.collections.structure.HeadMapOperation", "jetbrains.mps.baseLanguage.collections.structure.HeadSetOperation", "jetbrains.mps.baseLanguage.collections.structure.InsertElementOperation", "jetbrains.mps.baseLanguage.collections.structure.IntersectOperation", "jetbrains.mps.baseLanguage.collections.structure.IsEmptyOperation", "jetbrains.mps.baseLanguage.collections.structure.IsNotEmptyOperation", "jetbrains.mps.baseLanguage.collections.structure.IteratorType", "jetbrains.mps.baseLanguage.collections.structure.JoinOperation", "jetbrains.mps.baseLanguage.collections.structure.KeyAccessOperation", "jetbrains.mps.baseLanguage.collections.structure.LinkedHashMapCreator", "jetbrains.mps.baseLanguage.collections.structure.LinkedHashSetCreator", "jetbrains.mps.baseLanguage.collections.structure.LinkedListCreator", "jetbrains.mps.baseLanguage.collections.structure.LinkedListType", "jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit", "jetbrains.mps.baseLanguage.collections.structure.ListElementAccessExpression", "jetbrains.mps.baseLanguage.collections.structure.ListType", "jetbrains.mps.baseLanguage.collections.structure.MapClearOperation", "jetbrains.mps.baseLanguage.collections.structure.MapElement", "jetbrains.mps.baseLanguage.collections.structure.MapEntry", "jetbrains.mps.baseLanguage.collections.structure.MapInitializer", "jetbrains.mps.baseLanguage.collections.structure.MapOperationExpression", "jetbrains.mps.baseLanguage.collections.structure.MapRemoveOperation", "jetbrains.mps.baseLanguage.collections.structure.MapType", "jetbrains.mps.baseLanguage.collections.structure.MappingType", "jetbrains.mps.baseLanguage.collections.structure.MappingsSetOperation", "jetbrains.mps.baseLanguage.collections.structure.MoveNextOperation", "jetbrains.mps.baseLanguage.collections.structure.PageOperation", "jetbrains.mps.baseLanguage.collections.structure.PeekOperation", "jetbrains.mps.baseLanguage.collections.structure.PopOperation", "jetbrains.mps.baseLanguage.collections.structure.PriorityQueueCreator", "jetbrains.mps.baseLanguage.collections.structure.PushOperation", "jetbrains.mps.baseLanguage.collections.structure.PutAllOperation", "jetbrains.mps.baseLanguage.collections.structure.QueueType", "jetbrains.mps.baseLanguage.collections.structure.ReduceLeftOperation", "jetbrains.mps.baseLanguage.collections.structure.ReduceRightOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveAllElementsOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveAllSetElementsOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveAtElementOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveElementOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveFirstElementOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveLastElementOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveSetElementOperation", "jetbrains.mps.baseLanguage.collections.structure.RemoveWhereOperation", "jetbrains.mps.baseLanguage.collections.structure.ReverseOperation", "jetbrains.mps.baseLanguage.collections.structure.SelectOperation", "jetbrains.mps.baseLanguage.collections.structure.SequenceCreator", "jetbrains.mps.baseLanguage.collections.structure.SequenceType", "jetbrains.mps.baseLanguage.collections.structure.SetElementOperation", "jetbrains.mps.baseLanguage.collections.structure.SetType", "jetbrains.mps.baseLanguage.collections.structure.SingletonSequenceCreator", "jetbrains.mps.baseLanguage.collections.structure.SkipOperation", "jetbrains.mps.baseLanguage.collections.structure.SkipStatement", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration", "jetbrains.mps.baseLanguage.collections.structure.SortDirection", "jetbrains.mps.baseLanguage.collections.structure.SortOperation", "jetbrains.mps.baseLanguage.collections.structure.SortedMapType", "jetbrains.mps.baseLanguage.collections.structure.SortedSetType", "jetbrains.mps.baseLanguage.collections.structure.StackType", "jetbrains.mps.baseLanguage.collections.structure.StopStatement", "jetbrains.mps.baseLanguage.collections.structure.SubListOperation", "jetbrains.mps.baseLanguage.collections.structure.SubMapOperation", "jetbrains.mps.baseLanguage.collections.structure.SubSetOperation", "jetbrains.mps.baseLanguage.collections.structure.TailListOperation", "jetbrains.mps.baseLanguage.collections.structure.TailMapOperation", "jetbrains.mps.baseLanguage.collections.structure.TailOperation", "jetbrains.mps.baseLanguage.collections.structure.TailSetOperation", "jetbrains.mps.baseLanguage.collections.structure.TakeOperation", "jetbrains.mps.baseLanguage.collections.structure.ToArrayOperation", "jetbrains.mps.baseLanguage.collections.structure.ToIteratorOperation", "jetbrains.mps.baseLanguage.collections.structure.ToListOperation", "jetbrains.mps.baseLanguage.collections.structure.TranslateOperation", "jetbrains.mps.baseLanguage.collections.structure.TreeMapCreator", "jetbrains.mps.baseLanguage.collections.structure.TreeSetCreator", "jetbrains.mps.baseLanguage.collections.structure.UnionOperation", "jetbrains.mps.baseLanguage.collections.structure.ValueAccessOperation", "jetbrains.mps.baseLanguage.collections.structure.VisitAllOperation", "jetbrains.mps.baseLanguage.collections.structure.WhereOperation"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 69:
        return new ListType_BehaviorDescriptor();
      case 101:
        return new SequenceType_BehaviorDescriptor();
      case 124:
        return new ToListOperation_BehaviorDescriptor();
      case 35:
        return new ForEachStatement_BehaviorDescriptor();
      case 37:
        return new ForEachVariableReference_BehaviorDescriptor();
      case 67:
        return new ListCreatorWithInit_BehaviorDescriptor();
      case 2:
        return new AddElementOperation_BehaviorDescriptor();
      case 0:
        return new AddAllElementsOperation_BehaviorDescriptor();
      case 39:
        return new GetElementOperation_BehaviorDescriptor();
      case 48:
        return new GetSizeOperation_BehaviorDescriptor();
      case 41:
        return new GetFirstOperation_BehaviorDescriptor();
      case 58:
        return new IsEmptyOperation_BehaviorDescriptor();
      case 46:
        return new GetLastOperation_BehaviorDescriptor();
      case 92:
        return new RemoveElementOperation_BehaviorDescriptor();
      case 42:
        return new GetIndexOfOperation_BehaviorDescriptor();
      case 18:
        return new ContainsOperation_BehaviorDescriptor();
      case 105:
        return new SkipOperation_BehaviorDescriptor();
      case 121:
        return new TakeOperation_BehaviorDescriptor();
      case 80:
        return new PageOperation_BehaviorDescriptor();
      case 89:
        return new RemoveAllElementsOperation_BehaviorDescriptor();
      case 98:
        return new ReverseOperation_BehaviorDescriptor();
      case 59:
        return new IsNotEmptyOperation_BehaviorDescriptor();
      case 128:
        return new UnionOperation_BehaviorDescriptor();
      case 57:
        return new IntersectOperation_BehaviorDescriptor();
      case 30:
        return new ExcludeOperation_BehaviorDescriptor();
      case 108:
        return new SortDirection_BehaviorDescriptor();
      case 27:
        return new DistinctOperation_BehaviorDescriptor();
      case 14:
        return new ConcatOperation_BehaviorDescriptor();
      case 122:
        return new ToArrayOperation_BehaviorDescriptor();
      case 76:
        return new MapType_BehaviorDescriptor();
      case 51:
        return new HashMapCreator_BehaviorDescriptor();
      case 71:
        return new MapElement_BehaviorDescriptor();
      case 74:
        return new MapOperationExpression_BehaviorDescriptor();
      case 17:
        return new ContainsKeyOperation_BehaviorDescriptor();
      case 44:
        return new GetKeysOperation_BehaviorDescriptor();
      case 73:
        return new MapInitializer_BehaviorDescriptor();
      case 72:
        return new MapEntry_BehaviorDescriptor();
      case 75:
        return new MapRemoveOperation_BehaviorDescriptor();
      case 123:
        return new ToIteratorOperation_BehaviorDescriptor();
      case 70:
        return new MapClearOperation_BehaviorDescriptor();
      case 125:
        return new TranslateOperation_BehaviorDescriptor();
      case 131:
        return new WhereOperation_BehaviorDescriptor();
      case 99:
        return new SelectOperation_BehaviorDescriptor();
      case 107:
        return new SmartClosureParameterDeclaration_BehaviorDescriptor();
      case 130:
        return new VisitAllOperation_BehaviorDescriptor();
      case 26:
        return new DisjunctOperation_BehaviorDescriptor();
      case 109:
        return new SortOperation_BehaviorDescriptor();
      case 24:
        return new CutOperation_BehaviorDescriptor();
      case 119:
        return new TailOperation_BehaviorDescriptor();
      case 13:
        return new ComparatorSortOperation_BehaviorDescriptor();
      case 100:
        return new SequenceCreator_BehaviorDescriptor();
      case 106:
        return new SkipStatement_BehaviorDescriptor();
      case 113:
        return new StopStatement_BehaviorDescriptor();
      case 56:
        return new InsertElementOperation_BehaviorDescriptor();
      case 102:
        return new SetElementOperation_BehaviorDescriptor();
      case 68:
        return new ListElementAccessExpression_BehaviorDescriptor();
      case 31:
        return new FindFirstOperation_BehaviorDescriptor();
      case 32:
        return new FindLastOperation_BehaviorDescriptor();
      case 103:
        return new SetType_BehaviorDescriptor();
      case 52:
        return new HashSetCreator_BehaviorDescriptor();
      case 5:
        return new AddSetElementOperation_BehaviorDescriptor();
      case 96:
        return new RemoveSetElementOperation_BehaviorDescriptor();
      case 1:
        return new AddAllSetElementsOperation_BehaviorDescriptor();
      case 90:
        return new RemoveAllSetElementsOperation_BehaviorDescriptor();
      case 12:
        return new ClearSetOperation_BehaviorDescriptor();
      case 65:
        return new LinkedListCreator_BehaviorDescriptor();
      case 3:
        return new AddFirstElementOperation_BehaviorDescriptor();
      case 4:
        return new AddLastElementOperation_BehaviorDescriptor();
      case 91:
        return new RemoveAtElementOperation_BehaviorDescriptor();
      case 11:
        return new ClearAllElementsOperation_BehaviorDescriptor();
      case 93:
        return new RemoveFirstElementOperation_BehaviorDescriptor();
      case 94:
        return new RemoveLastElementOperation_BehaviorDescriptor();
      case 28:
        return new DowncastExpression_BehaviorDescriptor();
      case 9:
        return new AnyOperation_BehaviorDescriptor();
      case 7:
        return new AllOperation_BehaviorDescriptor();
      case 104:
        return new SingletonSequenceCreator_BehaviorDescriptor();
      case 43:
        return new GetIteratorOperation_BehaviorDescriptor();
      case 60:
        return new IteratorType_BehaviorDescriptor();
      case 50:
        return new HasNextOperation_BehaviorDescriptor();
      case 47:
        return new GetNextOperation_BehaviorDescriptor();
      case 38:
        return new GetCurrentOperation_BehaviorDescriptor();
      case 79:
        return new MoveNextOperation_BehaviorDescriptor();
      case 29:
        return new EnumeratorType_BehaviorDescriptor();
      case 40:
        return new GetEnumeratorOperation_BehaviorDescriptor();
      case 6:
        return new AllConstant_BehaviorDescriptor();
      case 19:
        return new ContainsValueOperation_BehaviorDescriptor();
      case 49:
        return new GetValuesOperation_BehaviorDescriptor();
      case 15:
        return new ContainerIteratorType_BehaviorDescriptor();
      case 95:
        return new RemoveOperation_BehaviorDescriptor();
      case 63:
        return new LinkedHashMapCreator_BehaviorDescriptor();
      case 64:
        return new LinkedHashSetCreator_BehaviorDescriptor();
      case 110:
        return new SortedMapType_BehaviorDescriptor();
      case 126:
        return new TreeMapCreator_BehaviorDescriptor();
      case 54:
        return new HeadMapOperation_BehaviorDescriptor();
      case 118:
        return new TailMapOperation_BehaviorDescriptor();
      case 115:
        return new SubMapOperation_BehaviorDescriptor();
      case 111:
        return new SortedSetType_BehaviorDescriptor();
      case 127:
        return new TreeSetCreator_BehaviorDescriptor();
      case 55:
        return new HeadSetOperation_BehaviorDescriptor();
      case 120:
        return new TailSetOperation_BehaviorDescriptor();
      case 116:
        return new SubSetOperation_BehaviorDescriptor();
      case 10:
        return new AsSequenceOperation_BehaviorDescriptor();
      case 77:
        return new MappingType_BehaviorDescriptor();
      case 61:
        return new JoinOperation_BehaviorDescriptor();
      case 129:
        return new ValueAccessOperation_BehaviorDescriptor();
      case 62:
        return new KeyAccessOperation_BehaviorDescriptor();
      case 78:
        return new MappingsSetOperation_BehaviorDescriptor();
      case 85:
        return new PutAllOperation_BehaviorDescriptor();
      case 86:
        return new QueueType_BehaviorDescriptor();
      case 25:
        return new DequeType_BehaviorDescriptor();
      case 112:
        return new StackType_BehaviorDescriptor();
      case 82:
        return new PopOperation_BehaviorDescriptor();
      case 84:
        return new PushOperation_BehaviorDescriptor();
      case 83:
        return new PriorityQueueCreator_BehaviorDescriptor();
      case 66:
        return new LinkedListType_BehaviorDescriptor();
      case 97:
        return new RemoveWhereOperation_BehaviorDescriptor();
      case 8:
        return new AlsoSortOperation_BehaviorDescriptor();
      case 16:
        return new ContainsAllOperation_BehaviorDescriptor();
      case 114:
        return new SubListOperation_BehaviorDescriptor();
      case 81:
        return new PeekOperation_BehaviorDescriptor();
      case 53:
        return new HeadListOperation_BehaviorDescriptor();
      case 117:
        return new TailListOperation_BehaviorDescriptor();
      case 21:
        return new CustomContainerDeclaration_BehaviorDescriptor();
      case 22:
        return new CustomContainers_BehaviorDescriptor();
      case 20:
        return new CustomContainerCreator_BehaviorDescriptor();
      case 23:
        return new CustomMapCreator_BehaviorDescriptor();
      case 36:
        return new ForEachVariable_BehaviorDescriptor();
      case 87:
        return new ReduceLeftOperation_BehaviorDescriptor();
      case 88:
        return new ReduceRightOperation_BehaviorDescriptor();
      case 33:
        return new FoldLeftOperation_BehaviorDescriptor();
      case 34:
        return new FoldRightOperation_BehaviorDescriptor();
      case 45:
        return new GetLastIndexOfOperation_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
