package jetbrains.mps.patterns.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.quotation.structure.Antiquotation_AnnotationLink;
import jetbrains.mps.quotation.structure.ReferenceAntiquotation_AnnotationLink;
import jetbrains.mps.quotation.structure.AbstractAntiquotation;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.patterns.structure.AsPattern_AnnotationLink;
import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.INodeAdapter;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.patterns.structure.AsPattern;
import jetbrains.mps.patterns.structure.Pattern;
import jetbrains.mps.patterns.structure.PatternVariableDeclaration;
import java.util.List;
import jetbrains.mps.patterns.structure.ListPattern;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.patterns.structure.PropertyPatternVariableDeclaration;
import jetbrains.mps.patterns.structure.LinkPatternVariableDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.smodel.SModelUtil_new;

public class QueriesGenerated {

  public static Object propertyMacro_GetPropertyValue_1174811055861(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getGenerator().getGeneratorSessionContext().createUniqueName("Pattern_");
  }

  public static Object propertyMacro_GetPropertyValue_1174811358972(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getGenerator().getGeneratorSessionContext().createUniqueName("PatternVar");
  }

  public static Object propertyMacro_GetPropertyValue_1176737323510(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getGenerator().getGeneratorSessionContext().createUniqueName("AntiquotationField");
  }

  public static Object propertyMacro_GetPropertyValue_1176737392657(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "parameter_" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1190931376940(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "nodeToMatch_" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1190931377077(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("propertyValue");
  }

  public static Object propertyMacro_GetPropertyValue_1190931377087(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("propertyName");
  }

  public static Object propertyMacro_GetPropertyValue_1190931377185(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("propertyName");
  }

  public static Object propertyMacro_GetPropertyValue_1190931377378(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("referentRole");
  }

  public static Object propertyMacro_GetPropertyValue_1190931377528(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("referentRole");
  }

  public static Object propertyMacro_GetPropertyValue_1190931377589(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("childRole");
  }

  public static Object propertyMacro_GetPropertyValue_1190931377601(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode mainNode = _context.getNode().getReferent("mainNode");
    String role = _context.getNode().getProperty("childRole");
    return mainNode.getChildCount(role) + "";
  }

  public static Object propertyMacro_GetPropertyValue_1190931377666(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getParent().getChildren(_context.getNode().getRole_()).indexOf(_context.getNode()) + "";
  }

  public static Object propertyMacro_GetPropertyValue_1190931377684(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "childVar_" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1190932035191(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("referentModel");
  }

  public static Object propertyMacro_GetPropertyValue_1190932077903(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("referentId");
  }

  public static Object propertyMacro_GetPropertyValue_1202825939894(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getConceptFqName();
  }

  public static Object referenceMacro_GetReferent_1176737467861(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "antiquotations");
  }

  public static Object referenceMacro_GetReferent_1176737471291(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "antiquotationParameters");
  }

  public static Object referenceMacro_GetReferent_1190931376965(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(SNodeOperations.getParent(_context.getNode(), null, false, false), "matchMethodParameter");
  }

  public static Object referenceMacro_GetReferent_1190931376991(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "childVar");
  }

  public static Object referenceMacro_GetReferent_1190931377016(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode antiquotation = _context.getNode().getAttribute(Antiquotation_AnnotationLink.ANTIQUOTATION);
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(antiquotation, "antiquotations");
  }

  public static Object referenceMacro_GetReferent_1190931377156(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    String propertyName = _context.getNode().getProperty("propertyName");
    SNode mainNode = _context.getNode().getReferent("mainNode");
    SNode propertyPattern = mainNode.getPropertyAttribute(propertyName);
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(propertyPattern, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377315(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    String refRole = _context.getNode().getProperty("referentRole");
    SNode mainNode = _context.getNode().getReferent("mainNode");
    SNode refAntiq = mainNode.getLinkAttribute(ReferenceAntiquotation_AnnotationLink.REFERENCE_ANTIQUOTATION, refRole);
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(refAntiq.getChild(AbstractAntiquotation.EXPRESSION), "antiquotations");
  }

  public static Object referenceMacro_GetReferent_1190931377499(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    String referentRole = _context.getNode().getProperty("referentRole");
    SNode mainNode = _context.getNode().getReferent("mainNode");
    SNode linkPattern = mainNode.getLinkAttribute(referentRole);
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(linkPattern, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377635(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode attribute = _context.getNode().getAttribute();
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(attribute, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377654(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(SNodeOperations.getParent(_context.getNode(), null, false, false), "nodeToMatch");
  }

  public static Object referenceMacro_GetReferent_1190931377722(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode attribute = _context.getNode().getAttribute();
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(attribute, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377736(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "childVar");
  }

  public static Object referenceMacro_GetReferent_1190931377817(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode attribute = BaseAdapter.fromAdapter(AsPattern_AnnotationLink.getAsPattern((BaseConcept)((INodeAdapter)SNodeOperations.getAdapter(_context.getNode()))));
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(attribute, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377842(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode attribute = _context.getNode().getAttribute();
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(attribute, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377894(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode attribute = _context.getNode().getAttribute();
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(attribute, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377920(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode attribute = BaseAdapter.fromAdapter(AsPattern_AnnotationLink.getAsPattern((BaseConcept)((INodeAdapter)SNodeOperations.getAdapter(_context.getNode()))));
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(attribute, "patternVarField");
  }

  public static Object referenceMacro_GetReferent_1190931377941(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(SNodeOperations.getParent(_context.getNode(), null, false, false), "nodeToMatch");
  }

  public static boolean ifMacro_Condition_1174824018407(final IOperationContext operationContext, final IfMacroContext _context) {
    return true;
  }

  public static boolean ifMacro_Condition_1176815681743(final IOperationContext operationContext, final IfMacroContext _context) {
    return true;
  }

  public static boolean ifMacro_Condition_1190931376948(final IOperationContext operationContext, final IfMacroContext _context) {
    return true;
  }

  public static boolean ifMacro_Condition_1190931376956(final IOperationContext operationContext, final IfMacroContext _context) {
    return false;
  }

  public static boolean ifMacro_Condition_1190931376975(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.getParent(_context.getNode(), null, false, false) == SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.patterns.structure.PatternExpression", false, false);
  }

  public static boolean ifMacro_Condition_1190931376999(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.getParent(_context.getNode(), null, false, false) != SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.patterns.structure.PatternExpression", false, false);
  }

  public static boolean ifMacro_Condition_1190931377036(final IOperationContext operationContext, final IfMacroContext _context) {
    return _context.getNode().getAttribute(Antiquotation_AnnotationLink.ANTIQUOTATION) != null;
  }

  public static boolean ifMacro_Condition_1190931377347(final IOperationContext operationContext, final IfMacroContext _context) {
    String refRole = _context.getNode().getProperty("referentRole");
    SNode mainNode = _context.getNode().getReferent("mainNode");
    return mainNode.getLinkAttribute(ReferenceAntiquotation_AnnotationLink.REFERENCE_ANTIQUOTATION, refRole) != null;
  }

  public static boolean ifMacro_Condition_1190931377679(final IOperationContext operationContext, final IfMacroContext _context) {
    return true;
  }

  public static boolean ifMacro_Condition_1190931377695(final IOperationContext operationContext, final IfMacroContext _context) {
    SNode attribute = _context.getNode().getAttribute();
    return attribute == null || attribute.getAdapter() instanceof AsPattern || !(attribute.getAdapter() instanceof Pattern);
  }

  public static boolean ifMacro_Condition_1190931377744(final IOperationContext operationContext, final IfMacroContext _context) {
    return BaseAdapter.isInstance(_context.getNode().getAttribute(), PatternVariableDeclaration.class);
  }

  public static boolean ifMacro_Condition_1190931377771(final IOperationContext operationContext, final IfMacroContext _context) {
    String childRole_ = _context.getNode().getProperty("childRole");
    SNode mainNode = _context.getNode().getReferent("mainNode");
    List<SNode> children = mainNode.getChildren(childRole_);
    SNode attribute = BaseAdapter.fromAdapter(AsPattern_AnnotationLink.getAsPattern((BaseConcept)children.get(0).getAdapter()));
    return !(BaseAdapter.isInstance(attribute, ListPattern.class));
  }

  public static boolean ifMacro_Condition_1190931377858(final IOperationContext operationContext, final IfMacroContext _context) {
    return true;
  }

  public static boolean ifMacro_Condition_1190931377867(final IOperationContext operationContext, final IfMacroContext _context) {
    SNode attribute = _context.getNode().getAttribute();
    return attribute == null || attribute.getAdapter() instanceof AsPattern || !(attribute.getAdapter() instanceof Pattern);
  }

  public static boolean ifMacro_Condition_1190931377908(final IOperationContext operationContext, final IfMacroContext _context) {
    return BaseAdapter.isInstance(_context.getNode().getAttribute(), PatternVariableDeclaration.class);
  }

  public static boolean ifMacro_Condition_1190931377983(final IOperationContext operationContext, final IfMacroContext _context) {
    String childRole_ = _context.getNode().getProperty("childRole");
    SNode mainNode = _context.getNode().getReferent("mainNode");
    List<SNode> children = mainNode.getChildren(childRole_);
    SNode attribute = BaseAdapter.fromAdapter(AsPattern_AnnotationLink.getAsPattern((BaseConcept)children.get(0).getAdapter()));
    return BaseAdapter.isInstance(attribute, ListPattern.class);
  }

  public static boolean ifMacro_Condition_1190931378075(final IOperationContext operationContext, final IfMacroContext _context) {
    return _context.getNode().getAttribute(Antiquotation_AnnotationLink.ANTIQUOTATION) == null;
  }

  public static boolean ifMacro_Condition_1190931671231(final IOperationContext operationContext, final IfMacroContext _context) {
    String refRole = _context.getNode().getProperty("referentRole");
    SNode mainNode = _context.getNode().getReferent("mainNode");
    return mainNode.getLinkAttribute(ReferenceAntiquotation_AnnotationLink.REFERENCE_ANTIQUOTATION, refRole) == null;
  }

  public static boolean ifMacro_Condition_1197652523288(final IOperationContext operationContext, final IfMacroContext _context) {
    SNode attribute = _context.getNode().getAttribute();
    return attribute != null;
  }

  public static SNode sourceNodeQuery_1174830361094(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "patternNode", true);
  }

  public static List sourceNodesQuery_1174811353234(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    result.addAll(SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.patterns.structure.PatternVariableDeclaration", false));
    result.addAll(SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.patterns.structure.LinkPatternVariableDeclaration", false));
    result.addAll(SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.patterns.structure.PropertyPatternVariableDeclaration", false));
    result.addAll(SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.patterns.structure.AsPattern", false));
    return result;
  }

  public static List sourceNodesQuery_1176737298135(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    for(SNode child : SNodeOperations.getDescendants(_context.getNode(), null, false)) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.quotation.structure.AbstractAntiquotation")) {
        result.add(SLinkOperations.getTarget(child, "expression", true));
      }
    }
    return result;
  }

  public static List sourceNodesQuery_1176737399740(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    for(SNode child : SNodeOperations.getDescendants(_context.getNode(), null, false)) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.quotation.structure.AbstractAntiquotation")) {
        result.add(SLinkOperations.getTarget(child, "expression", true));
      }
    }
    return result;
  }

  public static List sourceNodesQuery_1176737411271(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    for(SNode child : SNodeOperations.getDescendants(_context.getNode(), null, false)) {
      if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.quotation.structure.AbstractAntiquotation")) {
        result.add(SLinkOperations.getTarget(child, "expression", true));
      }
    }
    return result;
  }

  public static List sourceNodesQuery_1190931377097(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList();
    SModel model = _context.getGenerator().getTargetModel();
    for(String propertyName : _context.getNode().getPropertyNames()) {
      if(BaseAdapter.isInstance(_context.getNode().getPropertyAttribute(propertyName), PropertyPatternVariableDeclaration.class)) {
        continue;
      }
      String propertyValue = _context.getNode().getProperty(propertyName);
      SNode propertyNode = BaseConcept.newInstance(model).getNode();
      propertyNode.setProperty("propertyName", propertyName);
      propertyNode.setProperty("propertyValue", propertyValue);
      result.add(propertyNode);
    }
    return result;
  }

  public static List sourceNodesQuery_1190931377192(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList();
    SModel model = _context.getGenerator().getTargetModel();
    for(String propertyName : _context.getNode().getPropertyNames()) {
      if(BaseAdapter.isInstance(_context.getNode().getPropertyAttribute(propertyName), PropertyPatternVariableDeclaration.class)) {
        SNode propertyNode = BaseConcept.newInstance(model).getNode();
        propertyNode.setProperty("propertyName", propertyName);
        propertyNode.setReferent("mainNode", _context.getNode());
        result.add(propertyNode);
      }
    }
    return result;
  }

  public static List sourceNodesQuery_1190931377388(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList();
    SModel model = _context.getGenerator().getTargetModel();
    for(String referentRole : _context.getNode().getReferenceRoles()) {
      if(BaseAdapter.isInstance(_context.getNode().getLinkAttribute(referentRole), LinkPatternVariableDeclaration.class)) {
        continue;
      }
      SNode referenceNode = BaseConcept.newInstance(model).getNode();
      SNode referent = _context.getNode().getReferent(referentRole);
      referenceNode.setProperty("referentRole", referentRole);
      referenceNode.setProperty("referentModel", referent.getModel().getUID().toString());
      referenceNode.setProperty("referentId", referent.getId());
      referenceNode.setReferent("mainNode", _context.getNode());
      result.add(referenceNode);
    }
    return result;
  }

  public static List sourceNodesQuery_1190931377535(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList();
    SModel model = _context.getGenerator().getTargetModel();
    for(String referentRole : _context.getNode().getReferenceRoles()) {
      if(BaseAdapter.isInstance(_context.getNode().getLinkAttribute(referentRole), LinkPatternVariableDeclaration.class)) {
        SNode linkNode = BaseConcept.newInstance(model).getNode();
        linkNode.setProperty("referentRole", referentRole);
        linkNode.setReferent("mainNode", _context.getNode());
        result.add(linkNode);
      }
    }
    return result;
  }

  public static List sourceNodesQuery_1190931377752(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    SNode mainNode = _context.getNode().getReferent("mainNode");
    String role = _context.getNode().getProperty("childRole");
    return mainNode.getChildren(role);
  }

  public static List sourceNodesQuery_1190931377952(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    SNode mainNode = _context.getNode().getReferent("mainNode");
    String role = _context.getNode().getProperty("childRole");
    result.add(mainNode.getChildren(role).get(0));
    return result;
  }

  public static List sourceNodesQuery_1190931378020(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    SModel model = _context.getGenerator().getTargetModel();
    AbstractConceptDeclaration concept = _context.getNode().getConceptDeclarationAdapter();
    for(String childRole : _context.getNode().getChildRoles()) {
      SNode childRoleNode = BaseConcept.newInstance(model).getNode();
      childRoleNode.setProperty("childRole", childRole);
      childRoleNode.setReferent("childLinkDeclaration", SModelUtil_new.findLinkDeclaration(concept, childRole).getNode());
      childRoleNode.setReferent("mainNode", _context.getNode());
      result.add(childRoleNode);
    }
    return result;
  }

}
