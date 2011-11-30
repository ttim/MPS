package jetbrains.mps.build.ant.util;

/*Generated by MPS */

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*package*/ class StringUtil {
  public StringUtil() {
  }

  public static boolean endsWithIgnoreCase(@NonNls @NotNull String str, @NonNls @NotNull String suffix) {
    final int stringLength = str.length();
    final int suffixLength = suffix.length();
    return stringLength >= suffixLength && str.regionMatches(true, stringLength - suffixLength, suffix, 0, suffixLength);
  }

  public static boolean startsWithChar(@Nullable CharSequence s, char prefix) {
    return s != null && s.length() != 0 && s.charAt(0) == prefix;
  }

  public static boolean endsWithChar(@Nullable CharSequence s, char suffix) {
    return s != null && s.length() != 0 && s.charAt(s.length() - 1) == suffix;
  }

  public static boolean startsWithConcatenationOf(String testee, String firstPrefix, String secondPrefix) {
    int l1 = firstPrefix.length();
    int l2 = secondPrefix.length();
    if (testee.length() < l1 + l2) {
      return false;
    }
    return testee.startsWith(firstPrefix) && testee.regionMatches(l1, secondPrefix, 0, l2);
  }

  @NotNull
  public static String trimEnd(@NotNull String s, @NonNls @NotNull String suffix) {
    if (s.endsWith(suffix)) {
      return s.substring(0, s.length() - suffix.length());
    }
    return s;
  }

  public static boolean isEmptyOrSpaces(@Nullable final String s) {
    return s == null || s.trim().length() == 0;
  }

  public static String replace(@NotNull final String text, @NotNull final String oldS, @Nullable final String newS, boolean ignoreCase) {
    if (text.length() < oldS.length()) {
      return text;
    }
    final String text1 = (ignoreCase ?
      text.toLowerCase() :
      text
    );
    final String oldS1 = (ignoreCase ?
      oldS.toLowerCase() :
      oldS
    );
    final StringBuilder newText = new StringBuilder();
    int i = 0;
    while (i < text1.length()) {
      int i1 = text1.indexOf(oldS1, i);
      if (i1 < 0) {
        if (i == 0) {
          return text;
        }
        newText.append(text, i, text.length());
        break;
      } else {
        if (newS == null) {
          return null;
        }
        newText.append(text, i, i1);
        newText.append(newS);
        i = i1 + oldS.length();
      }
    }
    return newText.toString();
  }

  public static String replace(@NonNls @NotNull String text, @NonNls @NotNull String oldS, @NonNls @Nullable String newS) {
    return StringUtil.replace(text, oldS, newS, false);
  }

  public static int compareVersionNumbers(String v1, String v2) {
    if (v1 == null && v2 == null) {
      return 0;
    } else
    if (v1 == null) {
      return -1;
    } else
    if (v2 == null) {
      return 1;
    }
    String[] part1 = v1.split("[\\.\\_\\-]");
    String[] part2 = v2.split("[\\.\\_\\-]");
    int idx = 0;
    for (; idx < part1.length && idx < part2.length; idx++) {
      String p1 = part1[idx];
      String p2 = part2[idx];
      int cmp;
      if (p1.matches("\\d+") && p2.matches("\\d+")) {
        cmp = new Integer(p1).compareTo(new Integer(p2));
      } else {
        cmp = part1[idx].compareTo(part2[idx]);
      }
      if (cmp != 0) {
        return cmp;
      }
    }
    if (part1.length == part2.length) {
      return 0;
    } else
    if (part1.length > idx) {
      return 1;
    } else {
      return -1;
    }
  }
}
