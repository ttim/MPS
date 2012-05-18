package jetbrains.mps.ide.findusages.caches;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.psi.impl.cache.impl.id.IdTableBuilding;
import jetbrains.mps.ide.projectPane.fileSystem.MPSWorkbenchFileTypeFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.impl.cache.impl.id.FileTypeIdIndexer;
import java.util.Map;
import com.intellij.psi.impl.cache.impl.id.IdIndexEntry;
import com.intellij.util.indexing.FileContent;
import org.objectweb.asm.ClassReader;
import jetbrains.mps.baseLanguage.javastub.asm.ASMClass;
import com.intellij.util.text.CharArrayUtil;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.smodel.persistence.def.ModelReadException;
import java.util.Collections;
import java.util.HashMap;

public class StubModelsIndexer implements ApplicationComponent {
  public StubModelsIndexer() {
  }

  public void initComponent() {
    IdTableBuilding.registerIdIndexer(MPSWorkbenchFileTypeFactory.CLASS_FILE_TYPE, new StubModelsIndexer.MyFileTypeIdIndexer());
  }

  public void disposeComponent() {
  }

  @NotNull
  public String getComponentName() {
    return StubModelsIndexer.class.getSimpleName();
  }

  private static class MyFileTypeIdIndexer extends FileTypeIdIndexer {
    private MyFileTypeIdIndexer() {
    }

    @NotNull
    public Map<IdIndexEntry, Integer> map(FileContent inputData) {
      ClassReader reader = new ClassReader(inputData.getContent());
      ASMClass ac = new ASMClass(reader);


      CharSequence data = inputData.getContentAsText();
      char[] charsArray = CharArrayUtil.fromSequenceWithoutCopying(data);
      if (charsArray == null) {
        charsArray = CharArrayUtil.fromSequence(data);
      }
      final Map<ModelPersistence.IndexEntry, Integer> res;
      try {
        res = ModelPersistence.index(charsArray);
      } catch (ModelReadException e) {
        return Collections.emptyMap();
      }
      HashMap<IdIndexEntry, Integer> result = new HashMap<IdIndexEntry, Integer>();
      for (Map.Entry<ModelPersistence.IndexEntry, Integer> ie : res.entrySet()) {
        result.put(new IdIndexEntry(ie.getKey().data, ie.getKey().caseSensitive), ie.getValue());
      }
      return result;
    }
  }
}
