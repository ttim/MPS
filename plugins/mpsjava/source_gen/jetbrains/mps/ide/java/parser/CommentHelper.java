package jetbrains.mps.ide.java.parser;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.Sequence;
import org.apache.commons.lang.StringUtils;

public class CommentHelper {
  public CommentHelper() {
  }

  public static List<String> splitString(char[] content, int[] lineends, int start, int end) {
    List<String> result = ListSequence.fromList(new ArrayList<String>());
    for (int i = Math.abs(Arrays.binarySearch(lineends, start) + 1); i < lineends.length && lineends[i] <= end; ++i) {
      ListSequence.fromList(result).addElement(new String(content, start, lineends[i] - start));
      start = lineends[i] + 1;
    }
    if (start < end) {
      ListSequence.fromList(result).addElement(new String(content, start, end - start));
    }
    return result;
  }

  public static List<String> processLines(Iterable<String> lines, String start, String end) {
    // remove start and end (if any) tags, indent 
    List<String> result = ListSequence.fromList(new ArrayList<String>());
    if (Sequence.fromIterable(lines).isEmpty()) {
      return result;
    }
    // remove start prefix 
    if (StringUtils.trim(Sequence.fromIterable(lines).first()).equals(start)) {
      lines = Sequence.fromIterable(lines).skip(1);
    } else if (Sequence.fromIterable(lines).first().startsWith(start)) {
      ListSequence.fromList(result).addElement(Sequence.fromIterable(lines).first().substring(start.length()));
      lines = Sequence.fromIterable(lines).skip(1);
    }
    // find common indent for nonempty lines 
    if (Sequence.fromIterable(lines).isNotEmpty()) {
      int mintrim = Sequence.fromIterable(lines).first().length();
      for (String line : Sequence.fromIterable(lines)) {
        if (StringUtils.isNotEmpty(line)) {
          mintrim = Math.min(mintrim, line.length() - StringUtils.stripStart(line, " \n\r\t").length());
        }
      }
      boolean trimok = mintrim > 0;
      String prefix = Sequence.fromIterable(lines).first().substring(0, mintrim);
      for (String line : Sequence.fromIterable(lines)) {
        if (StringUtils.isNotEmpty(line)) {
          trimok = trimok && line.startsWith(prefix);
        }
      }
      for (String line : Sequence.fromIterable(lines)) {
        ListSequence.fromList(result).addElement((trimok && StringUtils.isNotEmpty(line) ?
          line.substring(mintrim) :
          line
        ));
      }
    }
    if (StringUtils.isNotEmpty(end) && ListSequence.fromList(result).isNotEmpty()) {
      if (StringUtils.trim(ListSequence.fromList(result).last()).equals(end)) {
        ListSequence.fromList(result).removeLastElement();
      } else if (ListSequence.fromList(result).last().endsWith(end)) {
        String last = ListSequence.fromList(result).removeLastElement();
        ListSequence.fromList(result).addElement(last.substring(0, last.length() - end.length()));
      }
    }
    return result;
  }

  public static List<String> processJavadoc(Iterable<String> lines) {
    return processLines(lines, "/**", "*/");
  }

  public static List<String> processComment(Iterable<String> lines) {
    if (Sequence.fromIterable(lines).first().startsWith("//")) {
      return processLines(lines, "//", null);
    } else {
      return processLines(lines, "/*", "*/");
    }
  }
}
