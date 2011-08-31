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
import jetbrains.mps.lang.pattern.IMatchingPattern;

@MPSLaunch
public class PatternMultipleOr_Test extends BaseTransformationTest {
  public PatternMultipleOr_Test() {
  }

  @Test
  public void testMethod() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:ef0e231b-e6bd-436f-9003-b53de4081716(jetbrains.mps.lang.pattern.test)");
    this.runTest("jetbrains.mps.lang.pattern.test.PatternMultipleOr_Test$TestBody", "testMultipleOr", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public TestBody() {
    }

    public void testMultipleOr() {
      assertTrue(match());

    }

    public boolean match() {
      SNode nodeToMatch = new PatternMultipleOr_Test.TestBody.QuotationClass_ay21uv_a0a0a1a().createNode();
      GeneratedMatchingPattern pattern = new PatternMultipleOr_Test.TestBody.Pattern_ay21uv_a0a1a1a();
      boolean matchNeeded = true;
      boolean matches = pattern.match(nodeToMatch);
      if (matchNeeded != matches) {
        return false;
      }
      if (!(matchNeeded)) {
        return true;
      }
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), new PatternMultipleOr_Test.TestBody.QuotationClass_ay21uv_a1a0g0b0().createNode()), ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), (SNode) pattern.getFieldValue("patternVar_s"))));
      return true;
    }

    public static class QuotationClass_ay21uv_a0a0a1a {
      public QuotationClass_ay21uv_a0a0a1a() {
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
        SNode quotedNode_7 = null;
        SNode quotedNode_8 = null;
        SNode quotedNode_9 = null;
        SNode quotedNode_10 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IfStatement", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_11 = quotedNode_1;
          {
            quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AndExpression", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_12 = quotedNode_2;
            {
              quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.EqualsExpression", null, GlobalScope.getInstance(), false);
              SNode quotedNode1_13 = quotedNode_4;
              {
                quotedNode_6 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerConstant", null, GlobalScope.getInstance(), false);
                SNode quotedNode1_14 = quotedNode_6;
                quotedNode1_14.setProperty("value", "3");
                quotedNode_4.addChild("rightExpression", quotedNode1_14);
              }
              {
                quotedNode_7 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerConstant", null, GlobalScope.getInstance(), false);
                SNode quotedNode1_15 = quotedNode_7;
                quotedNode1_15.setProperty("value", "4");
                quotedNode_4.addChild("leftExpression", quotedNode1_15);
              }
              quotedNode_2.addChild("rightExpression", quotedNode1_13);
            }
            {
              quotedNode_5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.NotEqualsExpression", null, GlobalScope.getInstance(), false);
              SNode quotedNode1_16 = quotedNode_5;
              {
                quotedNode_8 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.NullLiteral", null, GlobalScope.getInstance(), false);
                SNode quotedNode1_17 = quotedNode_8;
                quotedNode_5.addChild("leftExpression", quotedNode1_17);
              }
              {
                quotedNode_9 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.PrimitiveClassExpression", null, GlobalScope.getInstance(), false);
                SNode quotedNode1_18 = quotedNode_9;
                {
                  quotedNode_10 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", null, GlobalScope.getInstance(), false);
                  SNode quotedNode1_19 = quotedNode_10;
                  quotedNode_9.addChild("primitiveType", quotedNode1_19);
                }
                quotedNode_5.addChild("rightExpression", quotedNode1_18);
              }
              quotedNode_2.addChild("leftExpression", quotedNode1_16);
            }
            quotedNode_1.addChild("condition", quotedNode1_12);
          }
          {
            quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StatementList", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_20 = quotedNode_3;
            quotedNode_1.addChild("ifTrue", quotedNode1_20);
          }
          result = quotedNode1_11;
        }
        return result;
      }
    }

    public static class Pattern_ay21uv_a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
      /*package*/ SNode patternVar_s;
      private GeneratedMatchingPattern myOrPattern_qy0uft_a0a;

      public Pattern_ay21uv_a0a1a1a() {
      }

      public boolean match(SNode nodeToMatch) {
        {
          SNode nodeToMatch_MultipleOr_qy0uft_a0;
          nodeToMatch_MultipleOr_qy0uft_a0 = nodeToMatch;
          if (!("jetbrains.mps.baseLanguage.structure.IfStatement".equals(nodeToMatch_MultipleOr_qy0uft_a0.getConceptFqName()))) {
            return false;
          }
          {
            String childRole_MultipleOr_qy0uft_ = "condition";
            if (nodeToMatch_MultipleOr_qy0uft_a0.getChildCount(childRole_MultipleOr_qy0uft_) != 1) {
              return false;
            }
            {
              SNode childVar_MultipleOr_qy0uft_a0a = nodeToMatch_MultipleOr_qy0uft_a0.getChildren(childRole_MultipleOr_qy0uft_).get(0);
              {
                SNode nodeToMatch_MultipleOr_qy0uft_a0a;
                nodeToMatch_MultipleOr_qy0uft_a0a = childVar_MultipleOr_qy0uft_a0a;
                {
                  boolean orMatches = false;
                  GeneratedMatchingPattern orPattern;
                  orPattern = new PatternMultipleOr_Test.TestBody.Pattern_ay21uv_a0a1a1a.Pattern_ay21uv_a0a0a2a2a1a1a1a0a1a2a0a0a0a1a1a();
                  if (orPattern.match(nodeToMatch_MultipleOr_qy0uft_a0a)) {
                    orMatches = true;
                    myOrPattern_qy0uft_a0a = orPattern;
                  }
                  orPattern = new PatternMultipleOr_Test.TestBody.Pattern_ay21uv_a0a1a1a.Pattern_ay21uv_a0a0a3a2a1a1a1a0a1a2a0a0a0a1a1a();
                  if (orPattern.match(nodeToMatch_MultipleOr_qy0uft_a0a)) {
                    orMatches = true;
                    myOrPattern_qy0uft_a0a = orPattern;
                  }
                  orPattern = new PatternMultipleOr_Test.TestBody.Pattern_ay21uv_a0a1a1a.Pattern_ay21uv_a0a0a4a2a1a1a1a0a1a2a0a0a0a1a1a();
                  if (orPattern.match(nodeToMatch_MultipleOr_qy0uft_a0a)) {
                    orMatches = true;
                    myOrPattern_qy0uft_a0a = orPattern;
                  }
                  orPattern = new PatternMultipleOr_Test.TestBody.Pattern_ay21uv_a0a1a1a.Pattern_ay21uv_a0a0a5a2a1a1a1a0a1a2a0a0a0a1a1a();
                  if (orPattern.match(nodeToMatch_MultipleOr_qy0uft_a0a)) {
                    orMatches = true;
                    myOrPattern_qy0uft_a0a = orPattern;
                  }
                  if (!(orMatches)) {
                    return false;
                  }
                }
              }
            }
          }
          {
            String childRole_MultipleOr_qy0uft__12 = "ifTrue";
            if (nodeToMatch_MultipleOr_qy0uft_a0.getChildCount(childRole_MultipleOr_qy0uft__12) != 1) {
              return false;
            }
            {
              SNode childVar_MultipleOr_qy0uft_a0a_0 = nodeToMatch_MultipleOr_qy0uft_a0.getChildren(childRole_MultipleOr_qy0uft__12).get(0);
              {
                SNode nodeToMatch_MultipleOr_qy0uft_a0a_0;
                nodeToMatch_MultipleOr_qy0uft_a0a_0 = childVar_MultipleOr_qy0uft_a0a_0;
                if (!("jetbrains.mps.baseLanguage.structure.StatementList".equals(nodeToMatch_MultipleOr_qy0uft_a0a_0.getConceptFqName()))) {
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
        if (pattern != null && pattern.getClass() == this.getClass()) {
          patternVar_s = (SNode) pattern.getFieldValue("patternVar_s");
        }
      }

      public Object getFieldValue(String fieldName) {
        if ("patternVar_s".equals(fieldName)) {
          return patternVar_s;
        }
        return null;
      }

      public void performActions(Object o) {
      }

      public class Pattern_ay21uv_a0a0a2a2a1a1a1a0a1a2a0a0a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
        public Pattern_ay21uv_a0a0a2a2a1a1a1a0a1a2a0a0a0a1a1a() {
        }

        public boolean match(SNode nodeToMatch) {
          {
            SNode nodeToMatch_MultipleOr_qy0uft_a0a0a;
            nodeToMatch_MultipleOr_qy0uft_a0a0a = nodeToMatch;
            if (!("jetbrains.mps.baseLanguage.structure.NotEqualsExpression".equals(nodeToMatch_MultipleOr_qy0uft_a0a0a.getConceptFqName()))) {
              return false;
            }
            {
              String childRole_MultipleOr_qy0uft__0 = "leftExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a0a0a.getChildCount(childRole_MultipleOr_qy0uft__0) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0a0a0 = nodeToMatch_MultipleOr_qy0uft_a0a0a.getChildren(childRole_MultipleOr_qy0uft__0).get(0);
                {
                  SNode nodeToMatch_MultipleOr_qy0uft_a0a0a0;
                  nodeToMatch_MultipleOr_qy0uft_a0a0a0 = childVar_MultipleOr_qy0uft_a0a0a0;
                  if (!("jetbrains.mps.baseLanguage.structure.NullLiteral".equals(nodeToMatch_MultipleOr_qy0uft_a0a0a0.getConceptFqName()))) {
                    return false;
                  }
                }
              }
            }
            {
              String childRole_MultipleOr_qy0uft__1 = "rightExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a0a0a.getChildCount(childRole_MultipleOr_qy0uft__1) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0a0a0_0 = nodeToMatch_MultipleOr_qy0uft_a0a0a.getChildren(childRole_MultipleOr_qy0uft__1).get(0);
                {
                  SNode nodeToMatch_MultipleOr_qy0uft_a0a0a0_0;
                  nodeToMatch_MultipleOr_qy0uft_a0a0a0_0 = childVar_MultipleOr_qy0uft_a0a0a0_0;
                  patternVar_s = nodeToMatch_MultipleOr_qy0uft_a0a0a0_0;
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

      public class Pattern_ay21uv_a0a0a3a2a1a1a1a0a1a2a0a0a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
        public Pattern_ay21uv_a0a0a3a2a1a1a1a0a1a2a0a0a0a1a1a() {
        }

        public boolean match(SNode nodeToMatch) {
          {
            SNode nodeToMatch_MultipleOr_qy0uft_a1a0a;
            nodeToMatch_MultipleOr_qy0uft_a1a0a = nodeToMatch;
            if (!("jetbrains.mps.baseLanguage.structure.NotEqualsExpression".equals(nodeToMatch_MultipleOr_qy0uft_a1a0a.getConceptFqName()))) {
              return false;
            }
            {
              String childRole_MultipleOr_qy0uft__2 = "leftExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a1a0a.getChildCount(childRole_MultipleOr_qy0uft__2) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0b0a0 = nodeToMatch_MultipleOr_qy0uft_a1a0a.getChildren(childRole_MultipleOr_qy0uft__2).get(0);
                {
                  SNode nodeToMatch_MultipleOr_qy0uft_a0b0a0;
                  nodeToMatch_MultipleOr_qy0uft_a0b0a0 = childVar_MultipleOr_qy0uft_a0b0a0;
                  patternVar_s = nodeToMatch_MultipleOr_qy0uft_a0b0a0;
                }
              }
            }
            {
              String childRole_MultipleOr_qy0uft__3 = "rightExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a1a0a.getChildCount(childRole_MultipleOr_qy0uft__3) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0b0a0_0 = nodeToMatch_MultipleOr_qy0uft_a1a0a.getChildren(childRole_MultipleOr_qy0uft__3).get(0);
                {
                  SNode nodeToMatch_MultipleOr_qy0uft_a0b0a0_0;
                  nodeToMatch_MultipleOr_qy0uft_a0b0a0_0 = childVar_MultipleOr_qy0uft_a0b0a0_0;
                  if (!("jetbrains.mps.baseLanguage.structure.NullLiteral".equals(nodeToMatch_MultipleOr_qy0uft_a0b0a0_0.getConceptFqName()))) {
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

      public class Pattern_ay21uv_a0a0a4a2a1a1a1a0a1a2a0a0a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
        public Pattern_ay21uv_a0a0a4a2a1a1a1a0a1a2a0a0a0a1a1a() {
        }

        public boolean match(SNode nodeToMatch) {
          {
            SNode nodeToMatch_MultipleOr_qy0uft_a2a0a;
            nodeToMatch_MultipleOr_qy0uft_a2a0a = nodeToMatch;
            if (!("jetbrains.mps.baseLanguage.structure.AndExpression".equals(nodeToMatch_MultipleOr_qy0uft_a2a0a.getConceptFqName()))) {
              return false;
            }
            {
              String childRole_MultipleOr_qy0uft__4 = "leftExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a2a0a.getChildCount(childRole_MultipleOr_qy0uft__4) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0c0a0 = nodeToMatch_MultipleOr_qy0uft_a2a0a.getChildren(childRole_MultipleOr_qy0uft__4).get(0);
                {
                  SNode nodeToMatch_MultipleOr_qy0uft_a0c0a0;
                  nodeToMatch_MultipleOr_qy0uft_a0c0a0 = childVar_MultipleOr_qy0uft_a0c0a0;
                  if (!("jetbrains.mps.baseLanguage.structure.NotEqualsExpression".equals(nodeToMatch_MultipleOr_qy0uft_a0c0a0.getConceptFqName()))) {
                    return false;
                  }
                  {
                    String childRole_MultipleOr_qy0uft__5 = "leftExpression";
                    if (nodeToMatch_MultipleOr_qy0uft_a0c0a0.getChildCount(childRole_MultipleOr_qy0uft__5) != 1) {
                      return false;
                    }
                    {
                      SNode childVar_MultipleOr_qy0uft_a0a2a0a = nodeToMatch_MultipleOr_qy0uft_a0c0a0.getChildren(childRole_MultipleOr_qy0uft__5).get(0);
                      {
                        SNode nodeToMatch_MultipleOr_qy0uft_a0a2a0a;
                        nodeToMatch_MultipleOr_qy0uft_a0a2a0a = childVar_MultipleOr_qy0uft_a0a2a0a;
                        patternVar_s = nodeToMatch_MultipleOr_qy0uft_a0a2a0a;
                      }
                    }
                  }
                  {
                    String childRole_MultipleOr_qy0uft__6 = "rightExpression";
                    if (nodeToMatch_MultipleOr_qy0uft_a0c0a0.getChildCount(childRole_MultipleOr_qy0uft__6) != 1) {
                      return false;
                    }
                    {
                      SNode childVar_MultipleOr_qy0uft_a0a2a0a_0 = nodeToMatch_MultipleOr_qy0uft_a0c0a0.getChildren(childRole_MultipleOr_qy0uft__6).get(0);
                      {
                        SNode nodeToMatch_MultipleOr_qy0uft_a0a2a0a_0;
                        nodeToMatch_MultipleOr_qy0uft_a0a2a0a_0 = childVar_MultipleOr_qy0uft_a0a2a0a_0;
                        if (!("jetbrains.mps.baseLanguage.structure.NullLiteral".equals(nodeToMatch_MultipleOr_qy0uft_a0a2a0a_0.getConceptFqName()))) {
                          return false;
                        }
                      }
                    }
                  }
                }
              }
            }
            {
              String childRole_MultipleOr_qy0uft__7 = "rightExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a2a0a.getChildCount(childRole_MultipleOr_qy0uft__7) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0c0a0_0 = nodeToMatch_MultipleOr_qy0uft_a2a0a.getChildren(childRole_MultipleOr_qy0uft__7).get(0);
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

      public class Pattern_ay21uv_a0a0a5a2a1a1a1a0a1a2a0a0a0a1a1a extends GeneratedMatchingPattern implements IMatchingPattern {
        public Pattern_ay21uv_a0a0a5a2a1a1a1a0a1a2a0a0a0a1a1a() {
        }

        public boolean match(SNode nodeToMatch) {
          {
            SNode nodeToMatch_MultipleOr_qy0uft_a3a0a;
            nodeToMatch_MultipleOr_qy0uft_a3a0a = nodeToMatch;
            if (!("jetbrains.mps.baseLanguage.structure.AndExpression".equals(nodeToMatch_MultipleOr_qy0uft_a3a0a.getConceptFqName()))) {
              return false;
            }
            {
              String childRole_MultipleOr_qy0uft__8 = "leftExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a3a0a.getChildCount(childRole_MultipleOr_qy0uft__8) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0d0a0 = nodeToMatch_MultipleOr_qy0uft_a3a0a.getChildren(childRole_MultipleOr_qy0uft__8).get(0);
                {
                  SNode nodeToMatch_MultipleOr_qy0uft_a0d0a0;
                  nodeToMatch_MultipleOr_qy0uft_a0d0a0 = childVar_MultipleOr_qy0uft_a0d0a0;
                  if (!("jetbrains.mps.baseLanguage.structure.NotEqualsExpression".equals(nodeToMatch_MultipleOr_qy0uft_a0d0a0.getConceptFqName()))) {
                    return false;
                  }
                  {
                    String childRole_MultipleOr_qy0uft__9 = "leftExpression";
                    if (nodeToMatch_MultipleOr_qy0uft_a0d0a0.getChildCount(childRole_MultipleOr_qy0uft__9) != 1) {
                      return false;
                    }
                    {
                      SNode childVar_MultipleOr_qy0uft_a0a3a0a = nodeToMatch_MultipleOr_qy0uft_a0d0a0.getChildren(childRole_MultipleOr_qy0uft__9).get(0);
                      {
                        SNode nodeToMatch_MultipleOr_qy0uft_a0a3a0a;
                        nodeToMatch_MultipleOr_qy0uft_a0a3a0a = childVar_MultipleOr_qy0uft_a0a3a0a;
                        if (!("jetbrains.mps.baseLanguage.structure.NullLiteral".equals(nodeToMatch_MultipleOr_qy0uft_a0a3a0a.getConceptFqName()))) {
                          return false;
                        }
                      }
                    }
                  }
                  {
                    String childRole_MultipleOr_qy0uft__10 = "rightExpression";
                    if (nodeToMatch_MultipleOr_qy0uft_a0d0a0.getChildCount(childRole_MultipleOr_qy0uft__10) != 1) {
                      return false;
                    }
                    {
                      SNode childVar_MultipleOr_qy0uft_a0a3a0a_0 = nodeToMatch_MultipleOr_qy0uft_a0d0a0.getChildren(childRole_MultipleOr_qy0uft__10).get(0);
                      {
                        SNode nodeToMatch_MultipleOr_qy0uft_a0a3a0a_0;
                        nodeToMatch_MultipleOr_qy0uft_a0a3a0a_0 = childVar_MultipleOr_qy0uft_a0a3a0a_0;
                        patternVar_s = nodeToMatch_MultipleOr_qy0uft_a0a3a0a_0;
                      }
                    }
                  }
                }
              }
            }
            {
              String childRole_MultipleOr_qy0uft__11 = "rightExpression";
              if (nodeToMatch_MultipleOr_qy0uft_a3a0a.getChildCount(childRole_MultipleOr_qy0uft__11) != 1) {
                return false;
              }
              {
                SNode childVar_MultipleOr_qy0uft_a0d0a0_0 = nodeToMatch_MultipleOr_qy0uft_a3a0a.getChildren(childRole_MultipleOr_qy0uft__11).get(0);
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

    public static class QuotationClass_ay21uv_a1a0g0b0 {
      public QuotationClass_ay21uv_a1a0g0b0() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        SNode quotedNode_2 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.PrimitiveClassExpression", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_3 = quotedNode_1;
          {
            quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_4 = quotedNode_2;
            quotedNode_1.addChild("primitiveType", quotedNode1_4);
          }
          result = quotedNode1_3;
        }
        return result;
      }
    }
  }
}
