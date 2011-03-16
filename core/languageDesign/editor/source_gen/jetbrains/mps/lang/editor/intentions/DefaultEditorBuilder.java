package jetbrains.mps.lang.editor.intentions;

/*Generated by MPS */

import jetbrains.mps.internal.collections.runtime.backports.Deque;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.DequeSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.lang.editor.behavior.AbstractComponent_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.structure.behavior.LinkDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.NameUtil;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class DefaultEditorBuilder {
  private Deque<SNode> collectionsStack = DequeSequence.fromDeque(new LinkedList<SNode>());
  private SNode editorNode;
  private SNode conceptDeclaration;

  public DefaultEditorBuilder(SNode node) {
    editorNode = node;
    conceptDeclaration = AbstractComponent_Behavior.call_getConceptDeclaration_7055725856388417603(node);
  }

  public void buildStatementLike() {
    pushCollection();
    addLabel(camelToLabel(SPropertyOperations.getString(conceptDeclaration, "name")));
    final SNode nameProperty = getNameProperty(conceptDeclaration);
    if ((nameProperty != null)) {
      addProperty(nameProperty);
    }

    Iterable<SNode> props = ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(conceptDeclaration)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return it != nameProperty && SNodeOperations.getParent(it) != SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626");
      }
    });
    List<SNode> children = ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(conceptDeclaration)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.getParent(it) != SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626");
      }
    }).toListSequence();
    List<SNode> references = ListSequence.fromList(children).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.hasValue(it, "metaClass", "reference", "reference") || isSmartReference(it);
      }
    }).toListSequence();
    ListSequence.fromList(children).removeSequence(ListSequence.fromList(references));

    buildHeader(references);
    if (Sequence.fromIterable(props).count() > 0 || ListSequence.fromList(children).count() > 0) {
      addLabel("{");
      newLine();
      pushCollection();
      indent();
      boolean first = true;
      for (SNode property : Sequence.fromIterable(props)) {
        if (SNodeOperations.getParent(property) == SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626")) {
          continue;
        }

        addLabel(camelToLabel(SPropertyOperations.getString(property, "name")));
        addPunctuation(":");
        addProperty(property);
        newLine();
        first = false;
      }
      for (SNode linkDeclaration : ListSequence.fromList(children)) {
        if (!(first)) {
          addEmptyLine();
        }
        addLabel(camelToLabel(SPropertyOperations.getString(linkDeclaration, "role")));
        addPunctuation(":");
        newLine();
        if (LinkDeclaration_Behavior.call_isSingular_1213877254557(linkDeclaration)) {
          addRefNode(linkDeclaration);
        } else {
          addRefNodeList(linkDeclaration, null);
          setStyle(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutNewLineChildrenStyleClassItem"));
        }
        indent();
        newLine();
        first = false;
      }
      popCollection();
      addLabel("}");
    } else {
      addPunctuation(";");
    }
    popCollection();
  }

  public void buildExpressionLike() {
    pushCollection();
    addLabel(camelToLabel(SPropertyOperations.getString(conceptDeclaration, "name")));
    final SNode nameProperty = getNameProperty(conceptDeclaration);
    if ((nameProperty != null)) {
      addProperty(nameProperty);
    }

    Iterable<SNode> props = ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(conceptDeclaration)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return it != nameProperty && SNodeOperations.getParent(it) != SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626");
      }
    });
    List<SNode> children = ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(conceptDeclaration)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.getParent(it) != SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626");
      }
    }).toListSequence();
    List<SNode> references = ListSequence.fromList(children).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.hasValue(it, "metaClass", "reference", "reference") || isSmartReference(it);
      }
    }).toListSequence();
    ListSequence.fromList(children).removeSequence(ListSequence.fromList(references));

    buildHeader(references);
    addPunctuation("(");
    noSpace();
    boolean first = true;
    for (SNode property : Sequence.fromIterable(props)) {
      if (!(first)) {
        addPunctuation(",");
      }
      addLabel(camelToLabel(SPropertyOperations.getString(property, "name")));
      addPunctuation(":");
      addProperty(property);
      first = false;
    }
    for (SNode linkDeclaration : ListSequence.fromList(children).sort(new ISelector<SNode, Comparable<?>>() {
      public Comparable<?> select(SNode it) {
        return LinkDeclaration_Behavior.call_isSingular_1213877254557(it);
      }
    }, false)) {
      if (!(first)) {
        addPunctuation(",");
      }
      addLabel(camelToLabel(SPropertyOperations.getString(linkDeclaration, "role")));
      if (LinkDeclaration_Behavior.call_isSingular_1213877254557(linkDeclaration)) {
        addPunctuation(":");
        addRefNode(linkDeclaration);
      } else {
        addPunctuation("(");
        noSpace();
        addRefNodeList(linkDeclaration, null);
        addPunctuation(")");
      }
      noSpace();
      first = false;
    }
    addPunctuation(")");
    popCollection();
  }

  private void buildHeader(Iterable<SNode> references) {
    for (SNode linkDeclaration : Sequence.fromIterable(references)) {
      addLabel(camelToLabel(SPropertyOperations.getString(linkDeclaration, "role")));
      if (SPropertyOperations.hasValue(linkDeclaration, "metaClass", "aggregation", "reference")) {
        if (LinkDeclaration_Behavior.call_isSingular_1213877254557(linkDeclaration)) {
          addRefNode(linkDeclaration);
        } else {
          addRefNodeList(linkDeclaration, ",");
        }
      } else {
        if (LinkDeclaration_Behavior.call_isSingular_1213877254557(linkDeclaration)) {
          addRefCell(linkDeclaration);
        }
      }
    }
  }

  private void pushCollection() {
    SNode collection = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Collection", null);
    SLinkOperations.setTarget(collection, "cellLayout", SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellLayout_Indent", null), true);
    DequeSequence.fromDeque(collectionsStack).pushElement(collection);
  }

  private void popCollection() {
    SNode collection = DequeSequence.fromDeque(collectionsStack).popElement();
    if (DequeSequence.fromDeque(collectionsStack).isEmpty()) {
      SLinkOperations.setTarget(editorNode, "cellModel", collection, true);
    } else {
      ListSequence.fromList(SLinkOperations.getTargets(DequeSequence.fromDeque(collectionsStack).peekElement(), "childCellModel", true)).addElement(collection);
    }
  }

  private void addLabel(String text) {
    SNode nameCell = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Constant", null);
    SPropertyOperations.set(nameCell, "text", text);
    ListSequence.fromList(SLinkOperations.getTargets(DequeSequence.fromDeque(collectionsStack).peekElement(), "childCellModel", true)).addElement(nameCell);
  }

  private void addPunctuation(String text) {
    addLabel(text);
    setStyle(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.PunctuationLeftStyleClassItem"));
  }

  private void noSpace() {
    setStyle(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.PunctuationRightStyleClassItem"));
  }

  private void indent() {
    setStyle(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutIndentStyleClassItem"));
  }

  private void newLine() {
    setStyle(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutNewLineStyleClassItem"));
  }

  private void addEmptyLine() {
    addLabel(null);
    newLine();
  }

  private void setStyle(SNode concept) {
    SNode collection = DequeSequence.fromDeque(collectionsStack).peekElement();
    SNode cell = (ListSequence.fromList(SLinkOperations.getTargets(collection, "childCellModel", true)).isEmpty() ?
      collection :
      ListSequence.fromList(SLinkOperations.getTargets(collection, "childCellModel", true)).last()
    );
    SNode classItem = SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(concept), null);
    SPropertyOperations.set(classItem, "flag", "" + true);
    ListSequence.fromList(SLinkOperations.getTargets(cell, "styleItem", true)).addElement(classItem);
  }

  private void addProperty(SNode property) {
    SNode propertyCell = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Property", null);
    SLinkOperations.setTarget(propertyCell, "relationDeclaration", property, false);
    ListSequence.fromList(SLinkOperations.getTargets(DequeSequence.fromDeque(collectionsStack).peekElement(), "childCellModel", true)).addElement(propertyCell);
  }

  private void addRefNode(SNode link) {
    SNode linkCell = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_RefNode", null);
    SLinkOperations.setTarget(linkCell, "relationDeclaration", link, false);
    ListSequence.fromList(SLinkOperations.getTargets(DequeSequence.fromDeque(collectionsStack).peekElement(), "childCellModel", true)).addElement(linkCell);
  }

  private void addRefNodeList(SNode link, String separatorText) {
    SNode linkCell = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_RefNodeList", null);
    SLinkOperations.setTarget(linkCell, "relationDeclaration", link, false);
    SLinkOperations.setTarget(linkCell, "cellLayout", SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellLayout_Indent", null), true);
    if (separatorText != null) {
      SPropertyOperations.set(linkCell, "separatorText", separatorText);
    }
    ListSequence.fromList(SLinkOperations.getTargets(DequeSequence.fromDeque(collectionsStack).peekElement(), "childCellModel", true)).addElement(linkCell);
  }

  private void addRefCell(SNode link) {
    SNode linkCell = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_RefCell", null);
    SLinkOperations.setTarget(linkCell, "relationDeclaration", link, false);
    SLinkOperations.setTarget(linkCell, "editorComponent", createInlineEditorComponent(SLinkOperations.getTarget(link, "target", false)), true);
    ListSequence.fromList(SLinkOperations.getTargets(DequeSequence.fromDeque(collectionsStack).peekElement(), "childCellModel", true)).addElement(linkCell);
  }

  private SNode createInlineEditorComponent(SNode concept) {
    SNode inline = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.InlineEditorComponent", null);
    SNode propertyCell = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Property", null);
    SLinkOperations.setTarget(propertyCell, "relationDeclaration", getNameProperty(concept), false);
    SLinkOperations.setTarget(inline, "cellModel", propertyCell, true);
    return inline;
  }

  private String camelToLabel(String text) {
    StringBuilder sb = new StringBuilder();
    char[] cs = text.toCharArray();
    for (int i = 0; i < cs.length; i++) {
      if (Character.isUpperCase(cs[i])) {
        if (sb.length() > 0) {
          sb.append(' ');
        }
        if (i + 1 < cs.length && Character.isLowerCase(cs[i + 1])) {
          sb.append(Character.toLowerCase(cs[i]));
          continue;
        }
        while (i + 1 < cs.length && Character.isUpperCase(cs[i + 1])) {
          sb.append(cs[i]);
          i++;
        }
        if (i + 1 < cs.length) {
          i--;
          continue;
        }
      }
      sb.append(cs[i]);
    }
    return sb.toString();
  }

  public boolean isStringProperty(SNode property) {
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(property, "dataType", false), "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration"))) {
      return false;
    }
    if (!(eq_xgdobq_a0a1a81(SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(property, "dataType", false), "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration"), "name"), "string"))) {
      return false;
    }
    return true;
  }

  public boolean isBooleanProperty(SNode property) {
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(property, "dataType", false), "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration"))) {
      return false;
    }
    if (!(eq_xgdobq_a0a1a91(SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(property, "dataType", false), "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration"), "name"), "boolean"))) {
      return false;
    }
    return true;
  }

  private SNode getNameProperty(SNode concept) {
    final Map<SNode, Integer> idProperties = MapSequence.fromMap(new HashMap<SNode, Integer>());
    for (SNode property : ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(concept))) {
      if (SNodeOperations.getParent(property) == SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626")) {
        continue;
      }
      if (!(isStringProperty(property))) {
        continue;
      }
      String name = SPropertyOperations.getString(property, "name");
      int prio = (name.equals("name") ?
        10000 :
        0
      );
      prio += (name.toLowerCase().indexOf("identifier") >= 0 ?
        1700 :
        0
      );
      prio += (name.toLowerCase().indexOf("name") >= 0 ?
        1000 :
        0
      );
      prio += (name.toLowerCase().indexOf("qualified") >= 0 ?
        200 :
        0
      );
      MapSequence.fromMap(idProperties).put(property, prio);
    }
    return SetSequence.fromSet(MapSequence.fromMap(idProperties).keySet()).sort(new ISelector<SNode, Comparable<?>>() {
      public Comparable<?> select(SNode it) {
        return MapSequence.fromMap(idProperties).get(it);
      }
    }, false).first();
  }

  private boolean isSmartReference(SNode linkDeclaration) {
    if (SPropertyOperations.hasValue(linkDeclaration, "metaClass", "reference", "reference")) {
      return false;
    }
    SNode concept = SLinkOperations.getTarget(linkDeclaration, "target", false);
    if ((concept == null)) {
      return false;
    }
    for (SNode prop : ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(concept))) {
      if (SNodeOperations.getParent(prop) == SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626")) {
        continue;
      }
      return false;
    }

    int count = 0;
    for (SNode link : ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(concept))) {
      if (SNodeOperations.getParent(link) == SNodeOperations.getNode("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626")) {
        continue;
      }
      if (SPropertyOperations.hasValue(link, "sourceCardinality", "1", "0..1") && SPropertyOperations.hasValue(link, "metaClass", "reference", "reference") && (SLinkOperations.getTarget(link, "specializedLink", false) == null)) {
        count++;
        continue;
      }
      return false;
    }

    return count == 1;
  }

  private static boolean eq_xgdobq_a0a1a81(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_xgdobq_a0a1a91(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
