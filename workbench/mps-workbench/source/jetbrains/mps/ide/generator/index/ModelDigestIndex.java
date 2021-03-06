/*
 * Copyright 2003-2011 JetBrains s.r.o.
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
package jetbrains.mps.ide.generator.index;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.indexing.FileBasedIndex.InputFilter;
import com.intellij.util.indexing.FileContent;
import com.intellij.util.indexing.ID;
import com.intellij.util.indexing.SingleEntryFileBasedIndexExtension;
import com.intellij.util.indexing.SingleEntryIndexer;
import com.intellij.util.io.DataExternalizer;
import com.intellij.util.io.EnumeratorStringDescriptor;
import jetbrains.mps.fileTypes.MPSFileTypeFactory;
import jetbrains.mps.generator.ModelDigestUtil;
import org.jetbrains.annotations.NotNull;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelDigestIndex extends BaseModelDigestIndex {
  public static final ID<Integer, Map<String, String>> NAME = ID.create("ModelDigest");

  public ID<Integer, Map<String, String>> getName() {
    return NAME;
  }

  public InputFilter getInputFilter() {
    return new InputFilter() {
      public boolean acceptInput(VirtualFile file) {
        return file.getFileType().equals(MPSFileTypeFactory.MODEL_FILE_TYPE);
      }
    };
  }

  public int getVersion() {
    return 7;
  }
}
