package jetbrains.mps.smodel.persistence.def.v7;

/*Generated by MPS */

import jetbrains.mps.smodel.SModel;
import jetbrains.mps.xmlQuery.runtime.XMLSAXHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Stack;
import org.xml.sax.Locator;
import jetbrains.mps.smodel.ModelLoadingState;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.xmlQuery.runtime.BreakParseSAXException;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.DynamicReference;
import jetbrains.mps.smodel.StaticReference;

public class ModelReader7Handler extends XMLSAXHandler<SModel> {
  private static String[] EMPTY_ARRAY = new String[0];
  protected static Log log = LogFactory.getLog(ModelReader7Handler.class);

  private ModelReader7Handler.modelElementHandler modelhandler = new ModelReader7Handler.modelElementHandler();
  private ModelReader7Handler.persistenceElementHandler persistencehandler = new ModelReader7Handler.persistenceElementHandler();
  private ModelReader7Handler.module_referenceElementHandler module_referencehandler = new ModelReader7Handler.module_referenceElementHandler();
  private ModelReader7Handler.importElementHandler importhandler = new ModelReader7Handler.importElementHandler();
  private ModelReader7Handler.rootsElementHandler rootshandler = new ModelReader7Handler.rootsElementHandler();
  private ModelReader7Handler.rootContentElementHandler rootContenthandler = new ModelReader7Handler.rootContentElementHandler();
  private ModelReader7Handler.nodeElementHandler nodehandler = new ModelReader7Handler.nodeElementHandler();
  private ModelReader7Handler.propertyElementHandler propertyhandler = new ModelReader7Handler.propertyElementHandler();
  private ModelReader7Handler.linkElementHandler linkhandler = new ModelReader7Handler.linkElementHandler();
  private Stack<ModelReader7Handler.ElementHandler> myHandlersStack = new Stack<ModelReader7Handler.ElementHandler>();
  private Stack<Object> myValues = new Stack<Object>();
  private Locator myLocator;
  private SModel myResult;
  private ModelLoadingState fieldstate;
  private SModel fieldmodel;
  private VersionUtil fieldhelper;

  public ModelReader7Handler(ModelLoadingState state) {
    fieldstate = state;
  }

  public SModel getResult() {
    return myResult;
  }

  @Override
  public void setDocumentLocator(Locator locator) {
    myLocator = locator;
  }

  @Override
  public void characters(char[] array, int start, int len) throws SAXException {
    ModelReader7Handler.ElementHandler current = (myHandlersStack.empty() ?
      (ModelReader7Handler.ElementHandler) null :
      myHandlersStack.peek()
    );
    if (current != null) {
      current.handleText(myValues.peek(), new String(array, start, len));
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    ModelReader7Handler.ElementHandler current = myHandlersStack.pop();
    Object childValue = myValues.pop();
    if (current != null) {
      current.validate(childValue);
      if (myHandlersStack.empty()) {
        myResult = (SModel) childValue;
      } else {
        myHandlersStack.peek().handleChild(myValues.peek(), qName, childValue);
      }
    }
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    ModelReader7Handler.ElementHandler current = (myHandlersStack.empty() ?
      (ModelReader7Handler.ElementHandler) null :
      myHandlersStack.peek()
    );
    if (current == null) {
      // root 
      current = modelhandler;
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
      myResult = (SModel) result;
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

    protected ModelReader7Handler.ElementHandler createChild(String tagName) throws SAXException {
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
      return ModelReader7Handler.EMPTY_ARRAY;
    }

    protected void validate(Object resultObject) throws SAXException {
    }
  }

  public class modelElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"modelUID"};

    public modelElementHandler() {
    }

    @Override
    protected SModel createObject(Attributes attrs) {
      fieldmodel = new SModel(SModelReference.fromString(attrs.getValue("modelUID")));
      fieldmodel.setPersistenceVersion(7);
      fieldmodel.setLoading(true);
      fieldhelper = new VersionUtil(fieldmodel.getSModelReference());
      return fieldmodel;
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      SModel result = (SModel) resultObject;
      if ("modelUID".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }

    @Override
    protected ModelReader7Handler.ElementHandler createChild(String tagName) throws SAXException {
      if ("persistence".equals(tagName)) {
        return persistencehandler;
      }
      if ("language".equals(tagName)) {
        return module_referencehandler;
      }
      if ("language-engaged-on-generation".equals(tagName)) {
        return module_referencehandler;
      }
      if ("devkit".equals(tagName)) {
        return module_referencehandler;
      }
      if ("import".equals(tagName)) {
        return importhandler;
      }
      if ("roots".equals(tagName)) {
        return rootshandler;
      }
      if ("root".equals(tagName)) {
        return rootContenthandler;
      }
      return super.createChild(tagName);
    }

    @Override
    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      SModel result = (SModel) resultObject;
      if ("persistence".equals(tagName)) {
        return;
      }
      if ("language".equals(tagName)) {
        ModuleReference child = (ModuleReference) value;
        fieldmodel.addLanguage(child);
        return;
      }
      if ("language-engaged-on-generation".equals(tagName)) {
        ModuleReference child = (ModuleReference) value;
        fieldmodel.addEngagedOnGenerationLanguage(child);
        return;
      }
      if ("devkit".equals(tagName)) {
        ModuleReference child = (ModuleReference) value;
        fieldmodel.addDevKit(child);
        return;
      }
      if ("import".equals(tagName)) {
        String[] child = (String[]) value;
        fieldhelper.addImport(fieldmodel, child[0], child[1], Integer.parseInt(child[2]), child[3] != null);
        return;
      }
      if ("roots".equals(tagName)) {
        Object child = (Object) value;
        if (fieldstate == ModelLoadingState.ROOTS_LOADED) {
          fieldmodel.setLoading(false);
          throw new BreakParseSAXException();
        }
        return;
      }
      if ("root".equals(tagName)) {
        return;
      }
      super.handleChild(resultObject, tagName, value);
    }

    @Override
    protected void validate(Object resultObject) throws SAXException {
      if (!(validateInternal((SModel) resultObject))) {
        throw new SAXParseException("missing tags", null);
      }
    }

    private boolean validateInternal(SModel result) throws SAXException {
      fieldmodel.setLoading(false);
      return true;
    }
  }

  public class persistenceElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"version"};

    public persistenceElementHandler() {
    }

    @Override
    protected Integer createObject(Attributes attrs) {
      return Integer.parseInt(attrs.getValue("version"));
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      Integer result = (Integer) resultObject;
      if ("version".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }

  public class module_referenceElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"namespace"};

    public module_referenceElementHandler() {
    }

    @Override
    protected ModuleReference createObject(Attributes attrs) {
      return ModuleReference.fromString(attrs.getValue("namespace"));
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      ModuleReference result = (ModuleReference) resultObject;
      if ("namespace".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }

  public class importElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"index", "version", "modelUID"};

    public importElementHandler() {
    }

    @Override
    protected String[] createObject(Attributes attrs) {
      return new String[]{attrs.getValue("index"), attrs.getValue("modelUID"), attrs.getValue("version"), null};
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
      if ("version".equals(name)) {
        return;
      }
      if ("modelUID".equals(name)) {
        return;
      }
      if ("implicit".equals(name)) {
        result[3] = value;
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }

  public class rootsElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{};

    public rootsElementHandler() {
    }

    @Override
    protected ModelReader7Handler.ElementHandler createChild(String tagName) throws SAXException {
      if ("node".equals(tagName)) {
        return nodehandler;
      }
      return super.createChild(tagName);
    }

    @Override
    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      Object result = (Object) resultObject;
      if ("node".equals(tagName)) {
        SNode child = (SNode) value;
        if (child != null) {
          fieldmodel.addRoot(child);
        }
        return;
      }
      super.handleChild(resultObject, tagName, value);
    }
  }

  public class rootContentElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"id"};

    public rootContentElementHandler() {
    }

    @Override
    protected SNode createObject(Attributes attrs) {
      return fieldmodel.getNodeById(attrs.getValue("id"));
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      SNode result = (SNode) resultObject;
      if ("id".equals(name)) {
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }

    @Override
    protected ModelReader7Handler.ElementHandler createChild(String tagName) throws SAXException {
      if ("node".equals(tagName)) {
        return nodehandler;
      }
      return super.createChild(tagName);
    }

    @Override
    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      SNode result = (SNode) resultObject;
      if ("node".equals(tagName)) {
        SNode child = (SNode) value;
        if (child != null) {
          result.addChild(child.getRole_(), child);
        }
        return;
      }
      super.handleChild(resultObject, tagName, value);
    }
  }

  public class nodeElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"type"};

    public nodeElementHandler() {
    }

    @Override
    protected SNode createObject(Attributes attrs) {
      return new SNode(fieldmodel, fieldhelper.readType(attrs.getValue("type")));
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      SNode result = (SNode) resultObject;
      if ("type".equals(name)) {
        return;
      }
      if ("typeId".equals(name)) {
        // helper.addNodeType(value, result) 
        return;
      }
      if ("role".equals(name)) {
        result.setRoleInParent(fieldhelper.readRole(value));
        return;
      }
      if ("roleId".equals(name)) {
        // helper.addNodeRole(value, result) 
        return;
      }
      if ("id".equals(name)) {
        SNodeId id = SNodeId.fromString(value);
        if (id == null) {
          throw new SAXParseException("bad node ID", null);
        }
        result.setId(id);
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }

    @Override
    protected ModelReader7Handler.ElementHandler createChild(String tagName) throws SAXException {
      if ("property".equals(tagName)) {
        return propertyhandler;
      }
      if ("link".equals(tagName)) {
        return linkhandler;
      }
      if ("node".equals(tagName)) {
        return nodehandler;
      }
      return super.createChild(tagName);
    }

    @Override
    protected void handleChild(Object resultObject, String tagName, Object value) throws SAXException {
      SNode result = (SNode) resultObject;
      if ("property".equals(tagName)) {
        String[] child = (String[]) value;
        if (child[1] != null) {
          result.setProperty(fieldhelper.readName(child[0]), child[1], false);
          // helper.addPropName(child[2], result, child[0]) 
        }
        return;
      }
      if ("link".equals(tagName)) {
        String[] child = (String[]) value;
        SNodePointer ptr = fieldhelper.readLinkId(child[1]);
        if (ptr == null || ptr.getModelReference() == null) {
          if (log.isErrorEnabled()) {
            log.error("couldn't create reference '" + child[0] + "' from " + child[1]);
          }
          return;
        }
        SReference ref;
        if (ptr.getNodeId() == null) {
          ref = new DynamicReference(fieldhelper.readRole(child[0]), result, ptr.getModelReference(), child[2]);
          // helper.addDynamicRef(ptr.getModelReference(), ref) 
        } else {
          ref = new StaticReference(fieldhelper.readRole(child[0]), result, ptr.getModelReference(), ptr.getNodeId(), child[2]);
          // helper.addTarget(ptr, ref) 
        }
        result.addReference(ref);
        // helper.addRole(child[3], result) 
        return;
      }
      if ("node".equals(tagName)) {
        SNode child = (SNode) value;
        result.addChild(child.getRole_(), child);
        return;
      }
      super.handleChild(resultObject, tagName, value);
    }
  }

  public class propertyElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"name"};

    public propertyElementHandler() {
    }

    @Override
    protected String[] createObject(Attributes attrs) {
      return new String[]{attrs.getValue("name"), null};
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      String[] result = (String[]) resultObject;
      if ("name".equals(name)) {
        return;
      }
      if ("nameId".equals(name)) {
        // result[2] = value 
        return;
      }
      if ("value".equals(name)) {
        result[1] = value;
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }

  public class linkElementHandler extends ModelReader7Handler.ElementHandler {
    private String[] requiredAttributes = new String[]{"role", "targetNodeId"};

    public linkElementHandler() {
    }

    @Override
    protected String[] createObject(Attributes attrs) {
      return new String[]{attrs.getValue("role"), attrs.getValue("targetNodeId"), null, null};
    }

    @Override
    protected String[] requiredAttributes() {
      return requiredAttributes;
    }

    @Override
    protected void handleAttribute(Object resultObject, String name, String value) throws SAXException {
      String[] result = (String[]) resultObject;
      if ("role".equals(name)) {
        return;
      }
      if ("roleId".equals(name)) {
        result[3] = value;
        return;
      }
      if ("targetNodeId".equals(name)) {
        return;
      }
      if ("resolveInfo".equals(name)) {
        result[2] = value;
        return;
      }
      super.handleAttribute(resultObject, name, value);
    }
  }
}
