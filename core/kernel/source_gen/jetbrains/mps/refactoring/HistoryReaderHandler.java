package jetbrains.mps.refactoring;

/*Generated by MPS */

import jetbrains.mps.xmlQuery.runtime.XMLSAXHandler;
import java.util.Stack;
import org.xml.sax.Locator;
import jetbrains.mps.smodel.persistence.def.v7.ReadHelper;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.Map;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;

public class HistoryReaderHandler extends XMLSAXHandler<StructureModificationHistory0> {
  private static String[] EMPTY_ARRAY = new String[0];

  private HistoryReaderHandler.historyElementHandler historyhandler = new HistoryReaderHandler.historyElementHandler();
  private HistoryReaderHandler.elementElementHandler elementhandler = new HistoryReaderHandler.elementElementHandler();
  private HistoryReaderHandler.dependenciesElementHandler dependencieshandler = new HistoryReaderHandler.dependenciesElementHandler();
  private HistoryReaderHandler.modelElementHandler modelhandler = new HistoryReaderHandler.modelElementHandler();
  private HistoryReaderHandler.MoveNodeElementHandler MoveNodehandler = new HistoryReaderHandler.MoveNodeElementHandler();
  private HistoryReaderHandler.RenameNodeElementHandler RenameNodehandler = new HistoryReaderHandler.RenameNodeElementHandler();
  private HistoryReaderHandler.RenameModelElementHandler RenameModelhandler = new HistoryReaderHandler.RenameModelElementHandler();
  private Stack<HistoryReaderHandler.ElementHandler> myHandlersStack = new Stack<HistoryReaderHandler.ElementHandler>();
  private Stack<Object> myValues = new Stack<Object>();
  private Locator myLocator;
  private StructureModificationHistory0 myResult;
  private ReadHelper fieldhelper;

  public HistoryReaderHandler() {
  }

  public StructureModificationHistory0 getResult() {
    return myResult;
  }

  @Override
  public void setDocumentLocator(Locator locator) {
    myLocator = locator;
  }

  @Override
  public void characters(char[] array, int start, int len) throws SAXException {
    HistoryReaderHandler.ElementHandler current = (myHandlersStack.empty() ?
      (HistoryReaderHandler.ElementHandler) null :
      myHandlersStack.peek()
    );
    if (current != null) {
      current.handleText(myValues.peek(), new String(array, start, len));
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    HistoryReaderHandler.ElementHandler current = myHandlersStack.pop();
    Object childValue = myValues.pop();
    if (current != null) {
      current.validate(childValue);
      if (myHandlersStack.empty()) {
        myResult = (StructureModificationHistory0) childValue;
      } else {
        myHandlersStack.peek().handleChild(myValues.peek(), qName, childValue);
      }
    }
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    HistoryReaderHandler.ElementHandler current = (myHandlersStack.empty() ?
      (HistoryReaderHandler.ElementHandler) null :
      myHandlersStack.peek()
    );
    if (current == null) {
      // root 
      current = historyhandler;
    } else {
      current = current.createChild(qName);
    }

    // check required 
    for (String attr : current.requiredAttributes()) {
      if (attributes.getValue(attr) == null) {
        throw new SAXParseException("attribute " + attr + " is absent", null);
      }
    }

    Object result = current.createObject(attributes);
    if (myHandlersStack.empty()) {
      myResult = (StructureModificationHistory0) result;
    }

    // handle attributes 
    for (int i = 0; i < attributes.getLength(); i++) {
      String name = attributes.getQName(i);
      String value = attributes.getValue(i);
      current.handleAttribute(result, name, value);
    }
    myHandlersStack.push(current);
    myValues.push(result);
  }

  private class ElementHandler {
    private ElementHandler() {
    }

    protected Object createObject(Attributes attrs) {
      return null;
    }

    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
    }

    protected HistoryReaderHandler.ElementHandler createChild(String tagName) throws SAXException {
      throw new SAXParseException("unknown tag: " + tagName, null);
    }

    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      throw new SAXParseException("unknown child: " + tagName, null);
    }

    protected void handleText(Object resultObject, String value) throws SAXException {
      if (value.trim().length() == 0) {
        return;
      }
      throw new SAXParseException("text is not accepted", null);
    }

    protected String[] requiredAttributes() {
      return HistoryReaderHandler.EMPTY_ARRAY;
    }

    protected void validate(Object resultObject) throws SAXException {
    }
  }

  public class historyElementHandler extends HistoryReaderHandler.ElementHandler {
    private String[] requiredAttributes = new String[]{};

    public historyElementHandler() {
    }

    @Override
    protected StructureModificationHistory0 createObject(Attributes attrs) {
      return new StructureModificationHistory0();
    }

    @Override
    protected HistoryReaderHandler.ElementHandler createChild(String tagName) throws SAXException {
      if ("StructureModification".equals(tagName)) {
        return elementhandler;
      }
      return super.createChild(tagName);
    }

    @Override
    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      StructureModificationHistory0 result = (StructureModificationHistory0) resultObject;
      if ("StructureModification".equals(tagName)) {
        StructureModification child = (StructureModification) value;
        ListSequence.fromList(result.getHistory()).addElement(child);
        return;
      }
      super.handleChild(resultObject, tagName, value);
    }
  }

  public class elementElementHandler extends HistoryReaderHandler.ElementHandler {
    private String[] requiredAttributes = new String[]{};

    public elementElementHandler() {
    }

    @Override
    protected StructureModification createObject(Attributes attrs) {
      fieldhelper = new ReadHelper(null);
      return new StructureModification();
    }

    @Override
    protected HistoryReaderHandler.ElementHandler createChild(String tagName) throws SAXException {
      if ("dependencies".equals(tagName)) {
        return dependencieshandler;
      }
      if ("move".equals(tagName)) {
        return MoveNodehandler;
      }
      if ("rename".equals(tagName)) {
        return RenameNodehandler;
      }
      if ("RenameModel".equals(tagName)) {
        return RenameModelhandler;
      }
      return super.createChild(tagName);
    }

    @Override
    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      StructureModification result = (StructureModification) resultObject;
      if ("dependencies".equals(tagName)) {
        Map<SModelReference, Integer> child = (Map<SModelReference, Integer>) value;
        result.setDependencies(child);
        return;
      }
      if ("move".equals(tagName)) {
        StructureModification.MoveNode child = (StructureModification.MoveNode) value;
        ListSequence.fromList(result.getData()).addElement(child);
        return;
      }
      if ("rename".equals(tagName)) {
        StructureModification.RenameNode child = (StructureModification.RenameNode) value;
        ListSequence.fromList(result.getData()).addElement(child);
        return;
      }
      if ("RenameModel".equals(tagName)) {
        StructureModification.RenameModel child = (StructureModification.RenameModel) value;
        ListSequence.fromList(result.getData()).addElement(child);
        return;
      }
      super.handleChild(resultObject, tagName, value);
    }
  }

  public class dependenciesElementHandler extends HistoryReaderHandler.ElementHandler {
    private String[] requiredAttributes = new String[]{};

    public dependenciesElementHandler() {
    }

    @Override
    protected Map<SModelReference, Integer> createObject(Attributes attrs) {
      return MapSequence.fromMap(new HashMap<SModelReference, Integer>());
    }

    @Override
    protected HistoryReaderHandler.ElementHandler createChild(String tagName) throws SAXException {
      if ("model".equals(tagName)) {
        return modelhandler;
      }
      return super.createChild(tagName);
    }

    @Override
    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      Map<SModelReference, Integer> result = (Map<SModelReference, Integer>) resultObject;
      if ("model".equals(tagName)) {
        String[] child = (String[]) value;
        SModelReference modelRef = SModelReference.fromString(child[1]);
        MapSequence.fromMap(result).put(modelRef, Integer.parseInt(child[2]));
        fieldhelper.addModelRef(child[0], modelRef);
        return;
      }
      super.handleChild(resultObject, tagName, value);
    }
  }

  public class modelElementHandler extends HistoryReaderHandler.ElementHandler {
    private String[] requiredAttributes = new String[]{"index", "modelUID", "version"};

    public modelElementHandler() {
    }

    @Override
    protected String[] createObject(Attributes attrs) {
      return new String[]{attrs.getValue("index"), attrs.getValue("modelUID"), attrs.getValue("version")};
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      String[] result = (String[]) resultObject;
      if ("index".equals(name)) {
        return;
      }
      if ("modelUID".equals(name)) {
        return;
      }
      if ("version".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }

  public class MoveNodeElementHandler extends HistoryReaderHandler.ElementHandler {
    private String[] requiredAttributes = new String[]{"id", "to"};

    public MoveNodeElementHandler() {
    }

    @Override
    protected StructureModification.MoveNode createObject(Attributes attrs) {
      return new StructureModification.MoveNode(fieldhelper.readLinkId(attrs.getValue("id")), fieldhelper.readLinkId(attrs.getValue("to")));
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      StructureModification.MoveNode result = (StructureModification.MoveNode) resultObject;
      if ("id".equals(name)) {
        return;
      }
      if ("to".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }

  public class RenameNodeElementHandler extends HistoryReaderHandler.ElementHandler {
    private String[] requiredAttributes = new String[]{"id", "type", "to"};

    public RenameNodeElementHandler() {
    }

    @Override
    protected StructureModification.RenameNode createObject(Attributes attrs) {
      return new StructureModification.RenameNode(fieldhelper.readLinkId(attrs.getValue("id")), StructureModification.RenameNode.RenameType.valueOf(attrs.getValue("type")), attrs.getValue("to"), null);
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      StructureModification.RenameNode result = (StructureModification.RenameNode) resultObject;
      if ("id".equals(name)) {
        return;
      }
      if ("type".equals(name)) {
        return;
      }
      if ("from".equals(name)) {
        result.oldValue = value;
        return;
      }
      if ("to".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }

  public class RenameModelElementHandler extends HistoryReaderHandler.ElementHandler {
    private String[] requiredAttributes = new String[]{"oldModel", "newModel"};

    public RenameModelElementHandler() {
    }

    @Override
    protected StructureModification.RenameModel createObject(Attributes attrs) {
      return new StructureModification.RenameModel();
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      StructureModification.RenameModel result = (StructureModification.RenameModel) resultObject;
      if ("oldModel".equals(name)) {
        return;
      }
      if ("newModel".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }
}
