package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.textGen.TraceInfoGenerationUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.textGen.TextGenManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.JavaNameUtil;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.traceable.behavior.UnitConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class Annotation_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    if (getBuffer().hasPositionsSupport()) {
      TraceInfoGenerationUtil.createUnitInfo(this, node);
    }
    BaseLanguageTextGen.fileHeader(node, this);
    BaseLanguageTextGen.annotations(node, this);
    BaseLanguageTextGen.visibility(SLinkOperations.getTarget(node, "visibility", true), this);
    if ((AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.javadoc.structure.ClassifierDocComment"))) != null)) {
      TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.javadoc.structure.ClassifierDocComment"))), this.getSNode());
    }
    if (!(node.isRoot())) {
      this.append("static ");
    }
    this.appendWithIndent("@interface ");
    if (isEmpty_ydmu3t_a0f0a(SPropertyOperations.getString(node, "name"))) {
      this.foundError("annotation name is empty");
      this.append("???");
    } else {
      this.append(JavaNameUtil.shortName(SPropertyOperations.getString(node, "name")));
    }
    this.append(" {");
    this.increaseDepth();
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "method", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "method", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
      }
    }
    this.decreaseDepth();
    this.decreaseDepth();
    this.appendNewLine();
    this.append("}");
    this.appendNewLine();
    if (getBuffer().hasPositionsSupport()) {
      TraceInfoGenerationUtil.fillUnitInfo(this, node, UnitConcept_Behavior.call_getUnitName_5067982036267369911(SNodeOperations.cast(node, "jetbrains.mps.lang.traceable.structure.UnitConcept")));
    }
  }

  public String getExtension(SNode node) {
    return "java";
  }

  public static boolean isEmpty_ydmu3t_a0f0a(String str) {
    return str == null || str.length() == 0;
  }
}
