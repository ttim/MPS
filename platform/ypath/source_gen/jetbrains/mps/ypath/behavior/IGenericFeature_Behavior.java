package jetbrains.mps.ypath.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IGenericFeature_Behavior {
  private static Class[] PARAMETERS_1213877249147 = {SNode.class ,SNode.class};
  private static Class[] PARAMETERS_1213877249152 = {SNode.class ,SNode.class ,SNode.class ,ITemplateGenerator.class};
  private static Class[] PARAMETERS_1213877249161 = {SNode.class ,SNode.class ,SNode.class ,SNode.class ,SNode.class ,ITemplateGenerator.class};
  private static Class[] PARAMETERS_1213877249174 = {SNode.class ,SNode.class ,SNode.class ,SNode.class ,ITemplateGenerator.class};
  private static Class[] PARAMETERS_1213877249185 = {SNode.class ,SNode.class ,SNode.class ,SNode.class ,SNode.class ,ITemplateGenerator.class};

  public static void init(SNode thisNode) {
  }

  public static boolean call_hasModifyStatement_1213877249198(SNode thisNode, final SNode range, SNode replaceExp) {
    SNode fh = ListSequence.fromList(SLinkOperations.getTargets(thisNode, "funHolders", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SPropertyOperations.getBoolean(it, "byIndex") == SNodeOperations.isInstanceOf(range, "jetbrains.mps.ypath.structure.IndexRange");
      }

    }).first();
    if ((fh != null)) {
      if (IRange_Behavior.call_isInsertionPoint_1213877238219(range)) {
        if (ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

          public boolean accept(SNode it) {
            return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.GFInsertFunWrapper");
          }

        }).isNotEmpty()) {
          return true;
        }
        if (!(SPropertyOperations.getBoolean(range, "has_start") || SPropertyOperations.getBoolean(range, "has_end")) && SPropertyOperations.getBoolean(range, "includes_start")) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "INSERT_AT_START", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        } else
        if (!(SPropertyOperations.getBoolean(range, "has_start") || SPropertyOperations.getBoolean(range, "has_end")) && SPropertyOperations.getBoolean(range, "includes_end")) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "INSERT_AT_END", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        } else
        if (SPropertyOperations.getBoolean(range, "has_start")) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "INSERT_AFTER", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        } else
        {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "INSERT_BEFORE", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        }
      } else
      if (SNodeOperations.isInstanceOf(replaceExp, "jetbrains.mps.ypath.structure.EmptySequenceExpression")) {
        if (ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

          public boolean accept(SNode it) {
            return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.GFRemoveFunWrapper");
          }

        }).isNotEmpty()) {
          return true;
        }
        if (IRange_Behavior.call_isSingle_1213877238256(range)) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "REMOVE_SINGLE", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        } else
        if (IRange_Behavior.call_isLeftOpenSelection_1213877238312(range) || IRange_Behavior.call_isRightOpenSelection_1213877238328(range) || IRange_Behavior.call_isDoubleSelection_1213877238301(range)) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "REMOVE_SELECTION", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        } else
        if (IRange_Behavior.call_isAll_1213877238199(range)) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "REMOVE_ALL", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        }
      } else
      {
        if (ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

          public boolean accept(SNode it) {
            return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.GFReplaceFunWrapper");
          }

        }).isNotEmpty()) {
          return true;
        }
        if (IRange_Behavior.call_isSingle_1213877238256(range)) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "REPLACE_SINGLE", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        } else
        if (IRange_Behavior.call_isLeftOpenSelection_1213877238312(range) || IRange_Behavior.call_isRightOpenSelection_1213877238328(range) || IRange_Behavior.call_isDoubleSelection_1213877238301(range)) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "REPLACE_SELECTION", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        } else
        if (IRange_Behavior.call_isAll_1213877238199(range)) {
          return ListSequence.fromList(SLinkOperations.getTargets(fh, "functions", true)).where(new IWhereFilter <SNode>() {

            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.ypath.structure.IGenericFeatureFunFragment") && SPropertyOperations.hasValue(it, "fragmentType", "REPLACE_ALL", "REPLACE_SINGLE");
            }

          }).isNotEmpty();
        }
      }
    }
    return false;
  }

  public static boolean call_isSingleCardinality_1213877249147(SNode thisNode, SNode param) {
    return (Boolean)BehaviorManager.getInstance().invoke(Boolean.class, thisNode, "virtual_isSingleCardinality_1213877249147", PARAMETERS_1213877249147, param);
  }

  public static SNode call_getterExpression_1213877249152(SNode thisNode, SNode srcExpr, SNode param, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getterExpression_1213877249152", PARAMETERS_1213877249152, srcExpr, param, generator);
  }

  public static SNode call_replaceStatement_1213877249161(SNode thisNode, SNode srcExp, SNode param, SNode range, SNode replaceExp, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_replaceStatement_1213877249161", PARAMETERS_1213877249161, srcExp, param, range, replaceExp, generator);
  }

  public static SNode call_removeStatement_1213877249174(SNode thisNode, SNode srcExp, SNode param, SNode range, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_removeStatement_1213877249174", PARAMETERS_1213877249174, srcExp, param, range, generator);
  }

  public static SNode call_insertStatement_1213877249185(SNode thisNode, SNode srcExp, SNode param, SNode range, SNode insertExp, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_insertStatement_1213877249185", PARAMETERS_1213877249185, srcExp, param, range, insertExp, generator);
  }

  public static boolean callSuper_isSingleCardinality_1213877249147(SNode thisNode, String callerConceptFqName, SNode param) {
    return (Boolean)BehaviorManager.getInstance().invokeSuper(Boolean.class, thisNode, callerConceptFqName, "virtual_isSingleCardinality_1213877249147", PARAMETERS_1213877249147, param);
  }

  public static SNode callSuper_getterExpression_1213877249152(SNode thisNode, String callerConceptFqName, SNode srcExpr, SNode param, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getterExpression_1213877249152", PARAMETERS_1213877249152, srcExpr, param, generator);
  }

  public static SNode callSuper_replaceStatement_1213877249161(SNode thisNode, String callerConceptFqName, SNode srcExp, SNode param, SNode range, SNode replaceExp, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_replaceStatement_1213877249161", PARAMETERS_1213877249161, srcExp, param, range, replaceExp, generator);
  }

  public static SNode callSuper_removeStatement_1213877249174(SNode thisNode, String callerConceptFqName, SNode srcExp, SNode param, SNode range, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_removeStatement_1213877249174", PARAMETERS_1213877249174, srcExp, param, range, generator);
  }

  public static SNode callSuper_insertStatement_1213877249185(SNode thisNode, String callerConceptFqName, SNode srcExp, SNode param, SNode range, SNode insertExp, ITemplateGenerator generator) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_insertStatement_1213877249185", PARAMETERS_1213877249185, srcExp, param, range, insertExp, generator);
  }

}
