package jetbrains.mps.xmlInternal.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.xml.structure.Content;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ContentStatement extends Statement {
  public static final String concept = "jetbrains.mps.xmlInternal.structure.ContentStatement";
  public static final String CONTENT = "content";

  public ContentStatement(SNode node) {
    super(node);
  }

  public Content getContent() {
    return (Content)this.getChild(Content.class, ContentStatement.CONTENT);
  }

  public void setContent(Content node) {
    super.setChild(ContentStatement.CONTENT, node);
  }

  public static ContentStatement newInstance(SModel sm, boolean init) {
    return (ContentStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlInternal.structure.ContentStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ContentStatement newInstance(SModel sm) {
    return ContentStatement.newInstance(sm, false);
  }
}
