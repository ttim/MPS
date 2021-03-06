package jetbrains.mps.ide.java.parser;

/*Generated by MPS */


/*package*/ class StringUtils {
  /*package*/ static String stripStart(String str, String chars) {
    int strLen;
    if (str == null || (strLen = str.length()) == 0) {
      return str;
    }
    int start = 0;
    while ((start != strLen) && (chars.indexOf(str.charAt(start)) != -1)) {
      start++;
    }
    return str.substring(start);
  }
}
