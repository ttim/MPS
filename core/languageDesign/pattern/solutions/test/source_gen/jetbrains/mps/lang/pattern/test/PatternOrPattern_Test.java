package jetbrains.mps.lang.pattern.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.lang.pattern.IMatchingPattern;

@MPSLaunch
public class PatternOrPattern_Test extends BaseTransformationTest {
  public PatternOrPattern_Test() {
  }

  @Test
  public void testMethod() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:ef0e231b-e6bd-436f-9003-b53de4081716(jetbrains.mps.lang.pattern.test)");
    this.runTest("jetbrains.mps.lang.pattern.test.PatternOrPattern_Test$TestBody", "testOrPattern", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public TestBody() {
    }

    public void testOrPattern() {
      assertTrue(match());

    }

    public boolean match() {
      SNode nodeToMatch = new PatternOrPattern_Test.TestBody.QuotationClass_qttyfe_a0a0a1a().createNode();
      GeneratedMatchingPattern pattern = new PatternOrPattern_Test.TestBody.Pattern_qttyfe_a0a1a1a();
      boolean matchNeeded = true;
      boolean matches = pattern.match(nodeToMatch);
      if (matchNeeded != matches) {
        return false;
      }
      if (!(matchNeeded)) {
        return true;
      }
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), new PatternOrPattern_Test.TestBody.QuotationClass_qttyfe_a1a0g0b0().createNode()), ListSequence.fromListAndArray(new ArrayList<SNode>(), (SNode) pattern.getFieldValue("patternVar_ds"))));
      return true;
    }

    public static class QuotationClass_qttyfe_a0a0a1a {
      public QuotationClass_qttyfe_a0a0a1a() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        SNode quotedNode_2 = null;
        SNode quotedNode_3 = null;
        SNode quotedNode_4 = null;
        SNode quotedNode_5 = null;
        SNode quotedNode_6 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IfStatement", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_7 = quotedNode_1;
          {
            quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StatementList", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_8 = quotedNode_2;
            {
              quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.Statement", null, GlobalScope.getInstance(), false);
              SNode quotedNode1_9 = quotedNode_4;
              quotedNode_2.addChild("statement", quotedNode1_9);
            }
            quotedNode_1.addChild("ifTrue", quotedNode1_8);
          }
          {
            quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.NotEqualsExpression", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_10 = quotedNode_3;
            {
              quotedNode_5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.NullLiteral", null, GlobalScope.getInstance(), false);
              SNode quotedNode1_11 = quotedNode_5;
              quotedNode_3.addChild("rightExpression", quotedNode1_11);
            }
            {
              quotedNode_6 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", null, GlobalScope.getInstance(), false);
              SNode quotedNode1_12 = quotedNode_6;
              quotedNode1_12.addReference(SReference.create("classifier", quotedNode1_12, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.io(JDK/java.io@java_stub)"), SNodeId.fromString("~BufferedOutputStream")));
              quotedNode_3.addChild("leftExpression", quotedNode1_12);
            }
            quotedNode_1.addChild("condition", quotedNode1_10);
          }
          result = quotedNode1_7;
        }
        return result;
      }
    }

    public static class Pattern_qttyfe_a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
      /*package*/ SNode patternVar_body;
      /*package*/ SNode patternVar_ds;
      private GeneratedMatchingPattern myOrPattern_7ozj7q_a0a;

      public Pattern_qttyfe_a0a1a1a() {
      }

      public boolean match(SNode nodeToMatch) {
        {
          SNode nodeToMatch_2879868312063084279;
          nodeToMatch_2879868312063084279 = nodeToMatch;
          if (!("jetbrains.mps.baseLanguage.structure.IfStatement".equals(nodeToMatch_2879868312063084279.getConceptFqName()))) {
            return false;
          }
          {
            String childRole_2879868312063084279 = "condition";
            if (nodeToMatch_2879868312063084279.getChildCount(childRole_2879868312063084279) != 1) {
              return false;
            }
            {
              SNode childVar_4855904478356985691 = nodeToMatch_2879868312063084279.getChildren(childRole_2879868312063084279).get(0);
              {
                SNode nodeToMatch_4855904478356985691;
                nodeToMatch_4855904478356985691 = childVar_4855904478356985691;
                {
                  boolean orMatches = false;
                  GeneratedMatchingPattern orPattern;
                  orPattern = new PatternOrPattern_Test.TestBody.Pattern_qttyfe_a0a1a1a.Pattern_qttyfe_a0a0a2a2a1a1a1a0a1a2a0a0a0a1a1a();
                  if (orPattern.match(nodeToMatch_4855904478356985691)) {
                    orMatches = true;
                    myOrPattern_7ozj7q_a0a = orPattern;
                  }
                  orPattern = new PatternOrPattern_Test.TestBody.Pattern_qttyfe_a0a1a1a.Pattern_qttyfe_a0a0a3a2a1a1a1a0a1a2a0a0a0a1a1a();
                  if (orPattern.match(nodeToMatch_4855904478356985691)) {
                    orMatches = true;
                    myOrPattern_7ozj7q_a0a = orPattern;
                  }
                  if (!(orMatches)) {
                    return false;
                  }
                }
              }
            }
          }
          {
            String childRole_2879868312063084279 = "ifTrue";
            if (nodeToMatch_2879868312063084279.getChildCount(childRole_2879868312063084279) != 1) {
              return false;
            }
            {
              SNode childVar_2879868312063084281 = nodeToMatch_2879868312063084279.getChildren(childRole_2879868312063084279).get(0);
              {
                SNode nodeToMatch_2879868312063084281;
                nodeToMatch_2879868312063084281 = childVar_2879868312063084281;
                if (!("jetbrains.mps.baseLanguage.structure.StatementList".equals(nodeToMatch_2879868312063084281.getConceptFqName()))) {
                  return false;
                }
                {
                  String childRole_2879868312063084281 = "statement";
                  if (nodeToMatch_2879868312063084281.getChildCount(childRole_2879868312063084281) != 1) {
                    return false;
                  }
                  {
                    SNode childVar_612919440683666600 = nodeToMatch_2879868312063084281.getChildren(childRole_2879868312063084281).get(0);
                    this.patternVar_body = childVar_612919440683666600;
                  }
                }
              }
            }
          }
        }
        return true;
      }

      public boolean hasAntiquotations() {
        return false;
      }

      public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
        if (pattern != null && pattern.getClass() == this.getClass()) {
          patternVar_body = (SNode) pattern.getFieldValue("patternVar_body");
          patternVar_ds = (SNode) pattern.getFieldValue("patternVar_ds");
        }
      }

      public Object getFieldValue(String fieldName) {
        if ("patternVar_body".equals(fieldName)) {
          return patternVar_body;
        }
        if ("patternVar_ds".equals(fieldName)) {
          return patternVar_ds;
        }
        return null;
      }

      public void performActions(Object o) {
      }

      public class Pattern_qttyfe_a0a0a2a2a1a1a1a0a1a2a0a0a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
        public Pattern_qttyfe_a0a0a2a2a1a1a1a0a1a2a0a0a0a1a1a() {
        }

        public boolean match(SNode nodeToMatch) {
          {
            SNode nodeToMatch_7447026300559943984;
            nodeToMatch_7447026300559943984 = nodeToMatch;
            if (!("jetbrains.mps.baseLanguage.structure.NotEqualsExpression".equals(nodeToMatch_7447026300559943984.getConceptFqName()))) {
              return false;
            }
            {
              String childRole_7447026300559943984 = "leftExpression";
              if (nodeToMatch_7447026300559943984.getChildCount(childRole_7447026300559943984) != 1) {
                return false;
              }
              {
                SNode childVar_7447026300559948863 = nodeToMatch_7447026300559943984.getChildren(childRole_7447026300559943984).get(0);
                {
                  SNode nodeToMatch_7447026300559948863;
                  nodeToMatch_7447026300559948863 = childVar_7447026300559948863;
                  patternVar_ds = nodeToMatch_7447026300559948863;
                }
              }
            }
            {
              String childRole_7447026300559943984 = "rightExpression";
              if (nodeToMatch_7447026300559943984.getChildCount(childRole_7447026300559943984) != 1) {
                return false;
              }
              {
                SNode childVar_4855904478356985690 = nodeToMatch_7447026300559943984.getChildren(childRole_7447026300559943984).get(0);
                {
                  SNode nodeToMatch_4855904478356985690;
                  nodeToMatch_4855904478356985690 = childVar_4855904478356985690;
                  if (!("jetbrains.mps.baseLanguage.structure.NullLiteral".equals(nodeToMatch_4855904478356985690.getConceptFqName()))) {
                    return false;
                  }
                }
              }
            }
          }
          return true;
        }

        public boolean hasAntiquotations() {
          return false;
        }

        public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
        }

        public Object getFieldValue(String fieldName) {
          return null;
        }

        public void performActions(Object o) {
        }
      }

      public class Pattern_qttyfe_a0a0a3a2a1a1a1a0a1a2a0a0a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
        public Pattern_qttyfe_a0a0a3a2a1a1a1a0a1a2a0a0a0a1a1a() {
        }

        public boolean match(SNode nodeToMatch) {
          {
            SNode nodeToMatch_455132893173200872;
            nodeToMatch_455132893173200872 = nodeToMatch;
            if (!("jetbrains.mps.baseLanguage.structure.NotEqualsExpression".equals(nodeToMatch_455132893173200872.getConceptFqName()))) {
              return false;
            }
            {
              String childRole_455132893173200872 = "leftExpression";
              if (nodeToMatch_455132893173200872.getChildCount(childRole_455132893173200872) != 1) {
                return false;
              }
              {
                SNode childVar_4855904478357000968 = nodeToMatch_455132893173200872.getChildren(childRole_455132893173200872).get(0);
                {
                  SNode nodeToMatch_4855904478357000968;
                  nodeToMatch_4855904478357000968 = childVar_4855904478357000968;
                  if (!("jetbrains.mps.baseLanguage.structure.NullLiteral".equals(nodeToMatch_4855904478357000968.getConceptFqName()))) {
                    return false;
                  }
                }
              }
            }
            {
              String childRole_455132893173200872 = "rightExpression";
              if (nodeToMatch_455132893173200872.getChildCount(childRole_455132893173200872) != 1) {
                return false;
              }
              {
                SNode childVar_455132893173205750 = nodeToMatch_455132893173200872.getChildren(childRole_455132893173200872).get(0);
                {
                  SNode nodeToMatch_455132893173205750;
                  nodeToMatch_455132893173205750 = childVar_455132893173205750;
                  patternVar_ds = nodeToMatch_455132893173205750;
                }
              }
            }
          }
          return true;
        }

        public boolean hasAntiquotations() {
          return false;
        }

        public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
        }

        public Object getFieldValue(String fieldName) {
          return null;
        }

        public void performActions(Object o) {
        }
      }
    }

    public static class QuotationClass_qttyfe_a1a0g0b0 {
      public QuotationClass_qttyfe_a1a0g0b0() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.io(JDK/java.io@java_stub)"), SNodeId.fromString("~BufferedOutputStream")));
          result = quotedNode1_2;
        }
        return result;
      }
    }
  }
}
