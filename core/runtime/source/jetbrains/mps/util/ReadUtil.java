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
package jetbrains.mps.util;

import gnu.trove.TByteArrayList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadUtil {

  public static void read(byte[] bytes, InputStream stream) throws IOException {
    int offset = 0;
    int len = bytes.length;

    while (true) {
      int number = stream.read(bytes, offset, len - offset);
      if (number == -1 || len == offset) break;
      offset += number;
    }

    if (offset != len) {
      throw new RuntimeException("This can't happen");
    }
  }

  public static byte[] read(InputStream is) throws IOException {
    TByteArrayList buf = new TByteArrayList();

    int baseSize = 4096;
    byte[] tmp = new byte[baseSize];
    int off = 0;
    while (true) {
      int res = is.read(tmp, off, baseSize);
      if (res == -1) break;
      buf.add(tmp, 0, res);
    }

    return buf.toNativeArray();
  }

  public static byte[] read(InputStream is, int size) throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream(size);
    byte[] buff = new byte[4096];
    while (true) {
      int read = is.read(buff, 0, buff.length);
      if (read == -1) break;
      os.write(buff, 0, read);
    }
    return os.toByteArray();
  }
}
