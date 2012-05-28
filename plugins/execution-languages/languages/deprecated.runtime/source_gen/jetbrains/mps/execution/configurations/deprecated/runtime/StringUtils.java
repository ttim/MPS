/*
 * Copyright 2003-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.execution.configurations.deprecated.runtime;

/*Generated by MPS */


/*package*/ class StringUtils {
  public StringUtils() {
  }

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

  /*package*/ static String stripEnd(String str, String chars) {
    int end;
    if (str == null || (end = str.length()) == 0) {
      return str;
    }
    while ((0 != end) && (chars.indexOf(str.charAt(end - 1)) != -1)) {
      end--;
    }
    return str.substring(0, end);
  }

  /*package*/ static String substring(String str, int start, int end) {
    if (str == null) {
      return null;
    }
    if (end < 0) {
      end = str.length() + end;
    }
    if (start < 0) {
      start = str.length() + start;
    }
    if (end > str.length()) {
      end = str.length();
    }
    if (start > end) {
      return "";
    }
    if (start < 0) {
      start = 0;
    }
    if (end < 0) {
      end = 0;
    }
    return str.substring(start, end);
  }

  /*package*/ static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }

  /*package*/ static boolean isNotEmpty(String str) {
    return str != null && str.length() > 0;
  }

  /*package*/ static String trimBoth(String str) {
    return (str == null ?
      null :
      str.trim()
    );
  }
}
