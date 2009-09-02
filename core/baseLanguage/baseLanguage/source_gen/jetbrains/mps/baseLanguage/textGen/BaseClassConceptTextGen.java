package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;

public abstract class BaseClassConceptTextGen {
  public static void body(SNode concept, final SNodeTextGen textGen) {
    boolean needNewLine = false;
    if ((SLinkOperations.getTarget(concept, "instanceInitializer", true) != null)) {
      TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), SLinkOperations.getTarget(concept, "instanceInitializer", true), textGen.getSNode());
      needNewLine = true;
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(concept, "staticField", true)).isNotEmpty()) {
      BaseClassConceptTextGen.collection(SLinkOperations.getTargets(concept, "staticField", true), textGen);
      needNewLine = true;
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(concept, "field", true)).isNotEmpty()) {
      BaseClassConceptTextGen.collection(SLinkOperations.getTargets(concept, "field", true), textGen);
      needNewLine = true;
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(concept, "constructor", true)).isNotEmpty()) {
      for (SNode constructor : SLinkOperations.getTargets(concept, "constructor", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), constructor, textGen.getSNode());
        textGen.appendNewLine();
      }
      needNewLine = true;
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(concept, "method", true)).isNotEmpty()) {
      if (ListSequence.fromList(SLinkOperations.getTargets(concept, "method", true)).isNotEmpty()) {
        for (SNode item : SLinkOperations.getTargets(concept, "method", true)) {
          TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
        }
      }
      needNewLine = true;
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(concept, "staticMethod", true)).isNotEmpty()) {
      if (ListSequence.fromList(SLinkOperations.getTargets(concept, "staticMethod", true)).isNotEmpty()) {
        for (SNode item : SLinkOperations.getTargets(concept, "staticMethod", true)) {
          TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
        }
      }
      needNewLine = true;
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(concept, "staticInnerClassifiers", true)).isNotEmpty()) {
      BaseLanguageTextGen.newLine(needNewLine, textGen);
      BaseClassConceptTextGen.innerClassifiers(concept, textGen);
      needNewLine = true;
    }
    if ((SLinkOperations.getTarget(concept, "staticInitializer", true) != null)) {
      BaseLanguageTextGen.newLine(needNewLine, textGen);
      textGen.appendWithIndent("static {");
      textGen.increaseDepth();
      TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), SLinkOperations.getTarget(concept, "staticInitializer", true), textGen.getSNode());
      textGen.appendNewLine();
      textGen.decreaseDepth();
      textGen.appendWithIndent("}");
      textGen.appendNewLine();
      needNewLine = true;
    }
    if ((SLinkOperations.getTarget(concept, "classInitializer", true) != null)) {
      BaseLanguageTextGen.newLine(needNewLine, textGen);
      textGen.appendWithIndent("static {");
      textGen.increaseDepth();
      TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), SLinkOperations.getTarget(SLinkOperations.getTarget(concept, "classInitializer", true), "statementList", true), textGen.getSNode());
      textGen.appendNewLine();
      textGen.decreaseDepth();
      textGen.appendWithIndent("}");
      textGen.appendNewLine();
    }
  }

  public static void innerClassifiers(SNode concept, final SNodeTextGen textGen) {
    for (SNode classifier : SLinkOperations.getTargets(concept, "staticInnerClassifiers", true)) {
      TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), classifier, textGen.getSNode());
      if (!(classifier.equals(ListSequence.fromList(SLinkOperations.getTargets(concept, "staticInnerClassifiers", true)).last()))) {
        textGen.appendNewLine();
      }
    }
  }

  public static void collection(List<SNode> nodes, final SNodeTextGen textGen) {
    if (ListSequence.fromList(nodes).isNotEmpty()) {
      for (SNode item : nodes) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
      }
    }
    textGen.appendNewLine();
  }
}
