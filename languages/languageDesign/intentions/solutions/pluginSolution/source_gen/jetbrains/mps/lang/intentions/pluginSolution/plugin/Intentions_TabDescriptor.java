package jetbrains.mps.lang.intentions.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.ide.editorTabs.EditorTabDescriptor;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.pluginSolution.plugin.ConceptEditorOpenHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.structure.pluginSolution.plugin.ConceptEditorHelper;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.URLUtil;
import java.io.IOException;

public class Intentions_TabDescriptor extends EditorTabDescriptor {
  private static final Icon ICON = loadIcon();
  protected static Log log = LogFactory.getLog(Intentions_TabDescriptor.class);

  public Intentions_TabDescriptor() {
  }

  public String getTitle() {
    return "Intentions";
  }

  public Character getShortcutChar() {
    return 'I';
  }

  public int compareTo(EditorTabDescriptor descriptor) {
    return new Intentions_Order().compare(this, descriptor);
  }

  public void startListening() {
  }

  public SNode getBaseNode(SNode node) {
    return ConceptEditorOpenHelper.getBaseNode(node);
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration");
  }

  @Nullable
  public Icon getIcon() {
    return ICON;
  }

  public List<SNode> getNodes(SNode node) {
    return AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, LanguageAspect.INTENTIONS);
  }

  public boolean isSingle() {
    return false;
  }

  public List<SNode> getConcepts(final SNode node) {
    return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.INTENTIONS, node);
  }

  public SNode createNode(final SNode node, final SNode concept) {
    return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.INTENTIONS, node, concept);
  }

  private static Icon loadIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(URLUtil.openStream(Intentions_TabDescriptor.class.getResource("intention.png"))));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for Intentions", e);
      }
      return null;
    }
  }
}
