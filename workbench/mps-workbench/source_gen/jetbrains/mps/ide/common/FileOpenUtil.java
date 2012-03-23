package jetbrains.mps.ide.common;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.project.Project;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.navigation.NavigationItem;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.MPSGoToFileContributor;
import jetbrains.mps.internal.collections.runtime.ISelector;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.ScrollType;

public class FileOpenUtil {
  public FileOpenUtil() {
  }

  @Nullable
  public static VirtualFile findFile(final Project project, String unitName, final String fileName) {
    final Wrappers._T<String> fullFileName = new Wrappers._T<String>(unitName.replace(".", "/"));
    if (!(unitName.endsWith(fileName))) {
      int lastDot = unitName.lastIndexOf(".");
      if (lastDot == -1) {
        fullFileName.value = fileName;
      } else {
        fullFileName.value = unitName.substring(0, lastDot).replace(".", "/") + "/" + fileName;
      }
    }
    ChooseByNameContributor[] extensions = Extensions.getExtensions(ChooseByNameContributor.FILE_EP_NAME);
    Iterable<NavigationItem> found = Sequence.fromIterable(Sequence.fromArray(extensions)).translate(new ITranslator2<ChooseByNameContributor, NavigationItem>() {
      public Iterable<NavigationItem> translate(ChooseByNameContributor it) {
        return Sequence.fromArray(it.getItemsByName(fileName, fileName, project, true));
      }
    });
    Iterable<VirtualFile> matching = Sequence.fromIterable(found).where(new IWhereFilter<NavigationItem>() {
      public boolean accept(NavigationItem it) {
        return it instanceof MPSGoToFileContributor.FileNavigationItem;
      }
    }).select(new ISelector<NavigationItem, VirtualFile>() {
      public VirtualFile select(NavigationItem it) {
        return ((MPSGoToFileContributor.FileNavigationItem) it).getVirtualFile();
      }
    }).where(new IWhereFilter<VirtualFile>() {
      public boolean accept(VirtualFile it) {
        return it.getPath().endsWith(fullFileName.value);
      }
    });
    if (Sequence.fromIterable(matching).isNotEmpty()) {
      return Sequence.fromIterable(matching).first();
    }
    return null;
  }

  public static void openFile(Project project, VirtualFile file, int lineNumber) {
    FileEditor[] result = FileEditorManager.getInstance(project).openFile(file, true);
    if (result.length == 1 && result[0] instanceof TextEditor) {
      TextEditor textEditor = (TextEditor) result[0];
      LogicalPosition position = new LogicalPosition(lineNumber - 1, 0);
      textEditor.getEditor().getCaretModel().moveToLogicalPosition(position);
      textEditor.getEditor().getScrollingModel().scrollToCaret(ScrollType.MAKE_VISIBLE);
    }
  }
}
