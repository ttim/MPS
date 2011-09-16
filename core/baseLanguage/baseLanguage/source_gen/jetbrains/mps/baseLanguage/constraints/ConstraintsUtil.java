package jetbrains.mps.baseLanguage.constraints;

/*Generated by MPS */

import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.baseLanguage.behavior.ClassifierMember_Behavior;

public class ConstraintsUtil {
  private static Set<String> javaKeywords = SetSequence.fromSetAndArray(new HashSet<String>(), new String[]{"abstract", "continue", "for", "new", "switch", "assert", "default", "if", "package", "synchronized", "boolean", "do", "goto", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"});

  private ConstraintsUtil() {
  }

  public static boolean isInNonStaticClasssifierContext(SNode node) {
    if (!(isInsideOfClassifier(node))) {
      return false;
    }
    return ListSequence.fromList(SNodeOperations.getAncestors(node, "jetbrains.mps.baseLanguage.structure.ClassifierMember", false)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(ClassifierMember_Behavior.call_isStatic_8986964027630462944(it));
      }
    }).isNotEmpty();
  }

  public static boolean isInsideOfClassifier(SNode node) {
    return (SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.Classifier", true, false) != null);
  }

  public static boolean isJavaKeyword(String s) {
    return SetSequence.fromSet(javaKeywords).contains(s);
  }
}
