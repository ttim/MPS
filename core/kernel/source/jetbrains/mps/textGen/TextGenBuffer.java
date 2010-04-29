/*
 * Copyright 2003-2010 JetBrains s.r.o.
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
package jetbrains.mps.textGen;

import java.util.HashMap;

/**
 * User: Dmitriev.
 * Date: Dec 22, 2003
 */
public final class TextGenBuffer {

  public static final int TOP = 0;
  public static final int DEFAULT = 1;

  public static final String LINE_SEPARATOR = System.getProperty("line.separator");
  public static final String SPACES = "                                ";

  private StringBuilder[] myBuffers = new StringBuilder[]{
    new StringBuilder(512),
    new StringBuilder(2048)
  };

  private int[] myPostions = new int[2];
  private int[] myLineNumbers = new int[2];
  private int myCurrBuffer = 1;
  private HashMap myUserObjects = new HashMap();

  private int myIndent = 2;
  private int myDepth = 0;
  private boolean myContainsErrors = false;

  TextGenBuffer() {
  }

  public String getText() {
    String topBufferText = myBuffers[TOP].toString();
    String defaultBufferText = myBuffers[DEFAULT].toString();
    return topBufferText.length() <= 0 ? defaultBufferText : topBufferText + LINE_SEPARATOR + LINE_SEPARATOR + defaultBufferText;
  }

  public String getLineSeparator() {
    return LINE_SEPARATOR;
  }

  public boolean hasErrors() {
    return myContainsErrors;
  }

  public void foundError() {
    myContainsErrors = true;
  }

  protected void increaseDepth() {
    myDepth++;
  }

  protected void decreaseDepth() {
    myDepth--;
  }

  protected void append(String s) {
    if (s == null) {
      return;
    }
    if (s.contains(LINE_SEPARATOR)) {
      myLineNumbers[myCurrBuffer] += s.split(LINE_SEPARATOR, -1).length - 1;
      myPostions[myCurrBuffer] = s.length() - s.lastIndexOf(LINE_SEPARATOR) - LINE_SEPARATOR.length();
    } else {
      myPostions[myCurrBuffer] += s.length();
    }
    myBuffers[myCurrBuffer].append(s);
  }

  protected void appendWithIndent(String s) {
    indentBuffer();
    append(s);
  }

  protected void indentBuffer() {
    int spaces = myIndent * myDepth;
    myPostions[myCurrBuffer] += spaces;

    while(spaces > 0) {
      int i = spaces > SPACES.length() ? SPACES.length() : spaces;
      myBuffers[myCurrBuffer].append(SPACES, 0, i);
      spaces -= i;
    }
  }

  public void putUserObject(Object key, Object o) {
    myUserObjects.put(key, o);
  }

  public Object getUserObject(Object key) {
    return myUserObjects.get(key);
  }

  public String getDefaultBufferText() {
    return myBuffers[DEFAULT].toString();
  }

  public String getTopBufferText() {
    return myBuffers[TOP].toString();
  }

  public int getDefaultBufferLength() {
    return getBufferLength(DEFAULT);
  }

  public int getTopBufferLength() {
    return getBufferLength(TOP);
  }

  public int getBufferLength(int partId) {
    return myBuffers[partId].length();
  }

  public int getLineNumber() {
    return myLineNumbers[DEFAULT];
  }

  public int getPosition() {
    return myPostions[DEFAULT];
  }

  public int selectPart(int partId) {
    int currPartId = myCurrBuffer;
    myCurrBuffer = partId;
    return currPartId;
  }
}
