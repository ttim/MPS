package jetbrains.mps.transformation.test.outputLang.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.generator.template.TemplateFragmentContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.generator.template.WeavingMappingRuleContext;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.generator.template.PatternRuleContext;
import jetbrains.mps.generator.runtime.TemplateModel;
import jetbrains.mps.generator.runtime.TemplateModule;
import jetbrains.mps.lang.pattern.IMatchingPattern;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_3571912445009978241(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return (SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.transformation.test.outputLang.structure.CustomRoot", false, false) != null);
  }

  public static boolean baseMappingRule_Condition_4112907264514778044(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(!(!(SNodeOperations.getConceptDeclaration(((SNode) _context.getPatternVariable("patternVar_yy"))) != SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalVariableReference") || SNodeOperations.getConceptDeclaration(((SNode) _context.getPatternVariable("patternVar_xx"))) != SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalVariableReference"))) || SLinkOperations.getTarget(SNodeOperations.cast(((SNode) _context.getPatternVariable("patternVar_xx")), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false) != SLinkOperations.getTarget(SNodeOperations.cast(((SNode) _context.getPatternVariable("patternVar_yy")), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "variableDeclaration", false));
  }

  public static boolean baseMappingRule_Condition_8900764248744322639(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return false;
  }

  public static boolean baseMappingRule_Condition_8371596541809088659(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "inner", true), "jetbrains.mps.baseLanguage.structure.IntegerLiteral");
  }

  public static boolean baseMappingRule_Condition_8371596541809090605(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "inner", true), "jetbrains.mps.baseLanguage.structure.PlusExpression");
  }

  public static Object propertyMacro_GetPropertyValue_2163819695913945867(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(((SNode) _context.getPatternVariable("patternVar_aaa")), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6010543442198681251(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name1");
  }

  public static Object propertyMacro_GetPropertyValue_6010543442198681260(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name2");
  }

  public static Object propertyMacro_GetPropertyValue_2681305894288695070(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ((String) _context.getVariable("name")) + ((Boolean) _context.getVariable("b"));
  }

  public static Object propertyMacro_GetPropertyValue_2163819695913280744(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ((String) _context.getVariable("name2"));
  }

  public static Object propertyMacro_GetPropertyValue_2681305894288695040(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "var" + ((Integer) _context.getVariable("i"));
  }

  public static Object propertyMacro_GetPropertyValue_5857536350883039219(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BaseConcept_Behavior.call_getPresentation_1213877396640(((SNode) _context.getVariable("node")));
  }

  public static Object propertyMacro_GetPropertyValue_3571912445009937377(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getConceptFqName();
  }

  public static Object propertyMacro_GetPropertyValue_3571912445009934894(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "statement" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_3571912445009937427(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "in ctor " + _context.getNode().getId();
  }

  public static Object referenceMacro_GetReferent_1473665232107455264(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return "a";
  }

  public static Object referenceMacro_GetReferent_5955416080080987363(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByMappingLabel("testlabel");
  }

  public static SNode sourceNodeQuery_2681305894288283515(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ((SNode) _context.getPatternVariable("patternVar_right"));
  }

  public static SNode sourceNodeQuery_2681305894288283498(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ((SNode) _context.getPatternVariable("patternVar_left"));
  }

  public static SNode sourceNodeQuery_2681305894288387824(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ((SNode) _context.getPatternVariable("patternVar_right"));
  }

  public static SNode sourceNodeQuery_2681305894288387821(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ((SNode) _context.getPatternVariable("patternVar_left"));
  }

  public static SNode sourceNodeQuery_1209604320455(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_1473665232107485240(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return null;
  }

  public static SNode sourceNodeQuery_1209662301920(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_4146564171992412788(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "statement", true);
  }

  public static SNode sourceNodeQuery_4146564171992617089(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ((SNode) _context.getVariable("left"));
  }

  public static SNode sourceNodeQuery_4146564171992617085(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ((SNode) _context.getVariable("right"));
  }

  public static SNode sourceNodeQuery_2681305894288695056(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ((SNode) _context.getVariable("expr"));
  }

  public static Object templateArgumentQuery_4816349095291000368(final IOperationContext operationContext, final TemplateQueryContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Iterable sourceNodesQuery_3571912445009918069(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "statements", true), "statement", true);
  }

  public static SNode templateFragment_ContextNodeQuery_3571912445009937447(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return SLinkOperations.getTarget(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(_context.getMainContextNode(), "jetbrains.mps.baseLanguage.structure.ClassConcept"), "constructor", true)).first(), "body", true);
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_3571912445009918066(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.transformation.test.outputLang.structure.CustomRoot", false, false), "rootcustom");
  }

  public static GeneratedMatchingPattern patternRule_Condition_4146564171992608883(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a23();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    _context.createPatternContext(pattern);
    if (!(baseMappingRule_Condition_4112907264514778044(operationContext, _context))) {
      return null;
    }
    return pattern;
  }

  public static GeneratedMatchingPattern patternRule_Condition_2681305894288275225(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a33();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    return pattern;
  }

  public static GeneratedMatchingPattern patternRule_Condition_2681305894288382558(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a43();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    return pattern;
  }

  public static GeneratedMatchingPattern patternRule_Condition_2681305894288486365(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a53();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    return pattern;
  }

  public static GeneratedMatchingPattern patternRule_Condition_2163819695913701566(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a63();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    return pattern;
  }

  public static GeneratedMatchingPattern patternRule_Condition_5857536350883030949(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a73();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    return pattern;
  }

  public static GeneratedMatchingPattern patternRule_Condition_933643154465852759(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a83();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    return pattern;
  }

  public static GeneratedMatchingPattern patternRule_Condition_8371596541809088644(final IOperationContext operationContext, final PatternRuleContext _context) {
    GeneratedMatchingPattern pattern = new QueriesGenerated.Pattern_x583g4_a0a0a93();
    if (!(pattern.match(_context.getNode()))) {
      return null;
    }
    return pattern;
  }

  public static TemplateModel getDescriptor(TemplateModule module) {
    return new TemplateModelImpl(module);
  }

  public static class Pattern_x583g4_a0a0a23 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_right;
    /*package*/ SNode patternVar_xx;
    /*package*/ SNode patternVar_yy;

    public Pattern_x583g4_a0a0a23() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a23;
        nodeToMatch_x583g4_a0a0a23 = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.structure.ExpressionStatement".equals(nodeToMatch_x583g4_a0a0a23.getConceptFqName()))) {
          return false;
        }
        {
          String childRole_x583g4_ = "expression";
          if (nodeToMatch_x583g4_a0a0a23.getChildCount(childRole_x583g4_) != 1) {
            return false;
          }
          {
            SNode childVar_a0a0a0gb = nodeToMatch_x583g4_a0a0a23.getChildren(childRole_x583g4_).get(0);
            {
              SNode nodeToMatch_x583g4_a0a0a0gb;
              nodeToMatch_x583g4_a0a0a0gb = childVar_a0a0a0gb;
              if (!("jetbrains.mps.baseLanguage.structure.AssignmentExpression".equals(nodeToMatch_x583g4_a0a0a0gb.getConceptFqName()))) {
                return false;
              }
              {
                String childRole_x583g4__0 = "lValue";
                if (nodeToMatch_x583g4_a0a0a0gb.getChildCount(childRole_x583g4__0) != 1) {
                  return false;
                }
                {
                  SNode childVar_a0a0a0a23 = nodeToMatch_x583g4_a0a0a0gb.getChildren(childRole_x583g4__0).get(0);
                  this.patternVar_yy = childVar_a0a0a0a23;
                }
              }
              {
                String childRole_x583g4__1 = "rValue";
                if (nodeToMatch_x583g4_a0a0a0gb.getChildCount(childRole_x583g4__1) != 1) {
                  return false;
                }
                {
                  SNode childVar_a0a0a0a23_0 = nodeToMatch_x583g4_a0a0a0gb.getChildren(childRole_x583g4__1).get(0);
                  {
                    SNode nodeToMatch_x583g4_a0a0a0a23;
                    nodeToMatch_x583g4_a0a0a0a23 = childVar_a0a0a0a23_0;
                    if (!("jetbrains.mps.baseLanguage.structure.MulExpression".equals(nodeToMatch_x583g4_a0a0a0a23.getConceptFqName()))) {
                      return false;
                    }
                    {
                      String childRole_x583g4__2 = "leftExpression";
                      if (nodeToMatch_x583g4_a0a0a0a23.getChildCount(childRole_x583g4__2) != 1) {
                        return false;
                      }
                      {
                        SNode childVar_a0a0a0a0gb = nodeToMatch_x583g4_a0a0a0a23.getChildren(childRole_x583g4__2).get(0);
                        this.patternVar_xx = childVar_a0a0a0a0gb;
                      }
                    }
                    {
                      String childRole_x583g4__3 = "rightExpression";
                      if (nodeToMatch_x583g4_a0a0a0a23.getChildCount(childRole_x583g4__3) != 1) {
                        return false;
                      }
                      {
                        SNode childVar_a0a0a0a0gb_0 = nodeToMatch_x583g4_a0a0a0a23.getChildren(childRole_x583g4__3).get(0);
                        this.patternVar_right = childVar_a0a0a0a0gb_0;
                      }
                    }
                  }
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
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_right = (SNode) pattern.getFieldValue("patternVar_right");
        patternVar_xx = (SNode) pattern.getFieldValue("patternVar_xx");
        patternVar_yy = (SNode) pattern.getFieldValue("patternVar_yy");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_right".equals(fieldName)) {
        return patternVar_right;
      }
      if ("patternVar_xx".equals(fieldName)) {
        return patternVar_xx;
      }
      if ("patternVar_yy".equals(fieldName)) {
        return patternVar_yy;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_x583g4_a0a0a33 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_left;
    /*package*/ SNode patternVar_right;

    public Pattern_x583g4_a0a0a33() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a33;
        nodeToMatch_x583g4_a0a0a33 = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.structure.AndExpression".equals(nodeToMatch_x583g4_a0a0a33.getConceptFqName()))) {
          return false;
        }
        {
          String childRole_x583g4__4 = "leftExpression";
          if (nodeToMatch_x583g4_a0a0a33.getChildCount(childRole_x583g4__4) != 1) {
            return false;
          }
          {
            SNode childVar_a0a0a0hb = nodeToMatch_x583g4_a0a0a33.getChildren(childRole_x583g4__4).get(0);
            this.patternVar_left = childVar_a0a0a0hb;
          }
        }
        {
          String childRole_x583g4__5 = "rightExpression";
          if (nodeToMatch_x583g4_a0a0a33.getChildCount(childRole_x583g4__5) != 1) {
            return false;
          }
          {
            SNode childVar_a0a0a0hb_0 = nodeToMatch_x583g4_a0a0a33.getChildren(childRole_x583g4__5).get(0);
            this.patternVar_right = childVar_a0a0a0hb_0;
          }
        }
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_left = (SNode) pattern.getFieldValue("patternVar_left");
        patternVar_right = (SNode) pattern.getFieldValue("patternVar_right");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_left".equals(fieldName)) {
        return patternVar_left;
      }
      if ("patternVar_right".equals(fieldName)) {
        return patternVar_right;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_x583g4_a0a0a43 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_right;
    /*package*/ SNode patternVar_left;

    public Pattern_x583g4_a0a0a43() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a43;
        nodeToMatch_x583g4_a0a0a43 = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.structure.NotExpression".equals(nodeToMatch_x583g4_a0a0a43.getConceptFqName()))) {
          return false;
        }
        {
          String childRole_x583g4__6 = "expression";
          if (nodeToMatch_x583g4_a0a0a43.getChildCount(childRole_x583g4__6) != 1) {
            return false;
          }
          {
            SNode childVar_a0a0a0ib = nodeToMatch_x583g4_a0a0a43.getChildren(childRole_x583g4__6).get(0);
            {
              SNode nodeToMatch_x583g4_a0a0a0ib;
              nodeToMatch_x583g4_a0a0a0ib = childVar_a0a0a0ib;
              if (!("jetbrains.mps.baseLanguage.structure.EqualsExpression".equals(nodeToMatch_x583g4_a0a0a0ib.getConceptFqName()))) {
                return false;
              }
              {
                String childRole_x583g4__7 = "leftExpression";
                if (nodeToMatch_x583g4_a0a0a0ib.getChildCount(childRole_x583g4__7) != 1) {
                  return false;
                }
                {
                  SNode childVar_a0a0a0a43 = nodeToMatch_x583g4_a0a0a0ib.getChildren(childRole_x583g4__7).get(0);
                  this.patternVar_left = childVar_a0a0a0a43;
                }
              }
              {
                String childRole_x583g4__8 = "rightExpression";
                if (nodeToMatch_x583g4_a0a0a0ib.getChildCount(childRole_x583g4__8) != 1) {
                  return false;
                }
                {
                  SNode childVar_a0a0a0a43_0 = nodeToMatch_x583g4_a0a0a0ib.getChildren(childRole_x583g4__8).get(0);
                  this.patternVar_right = childVar_a0a0a0a43_0;
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
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_right = (SNode) pattern.getFieldValue("patternVar_right");
        patternVar_left = (SNode) pattern.getFieldValue("patternVar_left");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_right".equals(fieldName)) {
        return patternVar_right;
      }
      if ("patternVar_left".equals(fieldName)) {
        return patternVar_left;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_x583g4_a0a0a53 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_myExpr;
    /*package*/ String patternVar_jobName;

    public Pattern_x583g4_a0a0a53() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a53;
        nodeToMatch_x583g4_a0a0a53 = nodeToMatch;
        if (!("jetbrains.mps.transformation.test.outputLang.structure.CustomStatement".equals(nodeToMatch_x583g4_a0a0a53.getConceptFqName()))) {
          return false;
        }
        patternVar_jobName = nodeToMatch_x583g4_a0a0a53.getProperty("name");
        {
          String childRole_x583g4__9 = "inner";
          if (nodeToMatch_x583g4_a0a0a53.getChildCount(childRole_x583g4__9) != 1) {
            return false;
          }
          {
            SNode childVar_a0a0a0jb = nodeToMatch_x583g4_a0a0a53.getChildren(childRole_x583g4__9).get(0);
            this.patternVar_myExpr = childVar_a0a0a0jb;
          }
        }
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_myExpr = (SNode) pattern.getFieldValue("patternVar_myExpr");
        patternVar_jobName = (String) pattern.getFieldValue("patternVar_jobName");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_myExpr".equals(fieldName)) {
        return patternVar_myExpr;
      }
      if ("patternVar_jobName".equals(fieldName)) {
        return patternVar_jobName;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_x583g4_a0a0a63 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_aaa;
    /*package*/ String patternVar_null;

    public Pattern_x583g4_a0a0a63() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a63;
        nodeToMatch_x583g4_a0a0a63 = nodeToMatch;
        if (!("jetbrains.mps.transformation.test.outputLang.structure.CustomStatementRef".equals(nodeToMatch_x583g4_a0a0a63.getConceptFqName()))) {
          return false;
        }
        if (!("22".equals(nodeToMatch_x583g4_a0a0a63.getProperty("ii")))) {
          return false;
        }
        patternVar_null = nodeToMatch_x583g4_a0a0a63.getProperty("name");
        patternVar_aaa = nodeToMatch_x583g4_a0a0a63.getReferent("myStatement");
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_aaa = (SNode) pattern.getFieldValue("patternVar_aaa");
        patternVar_null = (String) pattern.getFieldValue("patternVar_null");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_aaa".equals(fieldName)) {
        return patternVar_aaa;
      }
      if ("patternVar_null".equals(fieldName)) {
        return patternVar_null;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_x583g4_a0a0a73 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_ref;

    public Pattern_x583g4_a0a0a73() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a73;
        nodeToMatch_x583g4_a0a0a73 = nodeToMatch;
        if (!("jetbrains.mps.transformation.test.outputLang.structure.CustomStatementRef".equals(nodeToMatch_x583g4_a0a0a73.getConceptFqName()))) {
          return false;
        }
        if (!("0".equals(nodeToMatch_x583g4_a0a0a73.getProperty("ii")))) {
          return false;
        }
        patternVar_ref = nodeToMatch_x583g4_a0a0a73.getReferent("myStatement");
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_ref = (SNode) pattern.getFieldValue("patternVar_ref");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_ref".equals(fieldName)) {
        return patternVar_ref;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_x583g4_a0a0a83 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_ref;

    public Pattern_x583g4_a0a0a83() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a83;
        nodeToMatch_x583g4_a0a0a83 = nodeToMatch;
        if (!("jetbrains.mps.transformation.test.outputLang.structure.CustomStatementRef".equals(nodeToMatch_x583g4_a0a0a83.getConceptFqName()))) {
          return false;
        }
        if (!("12".equals(nodeToMatch_x583g4_a0a0a83.getProperty("ii")))) {
          return false;
        }
        patternVar_ref = nodeToMatch_x583g4_a0a0a83.getReferent("myStatement");
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_ref = (SNode) pattern.getFieldValue("patternVar_ref");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_ref".equals(fieldName)) {
        return patternVar_ref;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }

  public static class Pattern_x583g4_a0a0a93 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode patternVar_ref;

    public Pattern_x583g4_a0a0a93() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_x583g4_a0a0a93;
        nodeToMatch_x583g4_a0a0a93 = nodeToMatch;
        if (!("jetbrains.mps.transformation.test.outputLang.structure.CustomStatementRef".equals(nodeToMatch_x583g4_a0a0a93.getConceptFqName()))) {
          return false;
        }
        if (!("13".equals(nodeToMatch_x583g4_a0a0a93.getProperty("ii")))) {
          return false;
        }
        patternVar_ref = nodeToMatch_x583g4_a0a0a93.getReferent("myStatement");
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (!(!(pattern != null) || pattern.getClass() != this.getClass())) {
        patternVar_ref = (SNode) pattern.getFieldValue("patternVar_ref");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("patternVar_ref".equals(fieldName)) {
        return patternVar_ref;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }
}
