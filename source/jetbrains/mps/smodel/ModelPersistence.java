package jetbrains.mps.smodel;

import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.util.JDOMUtil;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import java.io.File;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


/**
 * Author: Sergey Dmitriev
 * Created Oct 28, 2003
 */
public class ModelPersistence {
  private static final Logger LOG = Logger.getLogger(ModelPersistence.class);

  private static final String TARGET_NODE_ID = "targetNodeId";
//  private static final String META_CLASS = "metaClass";
  private static final String LINK = "link";
  private static final String ROLE = "role";
  public static final String BAD = "bad";
  public static final String NAME = "name";
  public static final String NAMESPACE = "namespace";
  public static final String NODE = "node";
  private static final String TYPE = "type";
  public static final String ID = "id";
  public static final String NO_ID = "noId";
  public static final String RESOLVE_INFO = "resolveInfo";
  public static final String TARGET_CLASS_RESOLVE_INFO = "targetClassResolveInfo";
  public static final String MODEL = "model";
  private static final String PROPERTY = "property";
  private static final String VALUE = "value";
  private static final String IMPORT_ELEMENT = "import";
  private static final String MODEL_REFERENCE_ID = "referenceID";
  private static final String MAX_REFERENCE_ID = "maxReferenceID";
  private static final String LANGUAGE = "language";
  private static final String STEREOTYPE = "stereotype";


  private static Document loadModelDocument(File file) {
    Document document = null;
    try {
      document = JDOMUtil.loadDocument(file);
    } catch (JDOMException e) {
      LOG.error(e);
    } catch (IOException e) {
      LOG.error(e);
    }
    return document;
  }

  private static Document loadModelDocument(byte[] bytes) {
    Document document = null;
    try {
      document = JDOMUtil.loadDocument(new ByteArrayInputStream(bytes));
    } catch (JDOMException e) {
      LOG.error(e);
    } catch (IOException e) {
      LOG.error(e);
    }
    return document;
  }

  public static SModel readModel(byte[] bytes) {
    Document document = loadModelDocument(bytes);
    return readModel(document, "");
  }

  public static SModel readModel(File file) {
    LOG.debug("ModelPersistence readModel from :" + file.getAbsolutePath());

    // the model FQ name ...
    String fileName = file.getName();
    int index = fileName.lastIndexOf('.');
    String modelName = (index >= 0) ? fileName.substring(0, index) : fileName;

    Document document = loadModelDocument(file);

    if (document == null) {
      LOG.debug("Couldn't load model file:" + file.getAbsolutePath());
      return null;
    }

    return readModel(document, modelName);
  }

  public static SModel copyModel(SModel model) {
    return readModel(saveModel(model), model.getName());
  }

  private static SModel readModel(Document document, String modelName) {
    Element rootElement = document.getRootElement();
    String modelNamespace = rootElement.getAttributeValue(NAMESPACE, "");
    String modelFqName = NameUtil.fqNameFromNamespaceAndName(modelNamespace, modelName);
    SModel semanticModel = new SModel(modelFqName);

    semanticModel.setStereotype(rootElement.getAttributeValue(STEREOTYPE));
    semanticModel.setLoading(true);
    try {
      Element maxRefID = rootElement.getChild(MAX_REFERENCE_ID);
      semanticModel.setMaxReferenceID(readIntAttributeValue(maxRefID, VALUE));
    } catch (Throwable e) {
      LOG.error(e);
    }

    // languages
    List languages = rootElement.getChildren(LANGUAGE);
    for (Iterator iterator = languages.iterator(); iterator.hasNext();) {
      Element element = (Element) iterator.next();
      String languageNamespace = element.getAttributeValue(NAMESPACE);
      semanticModel.addLanguage(languageNamespace);
    }

    // imports
    List imports = rootElement.getChildren(IMPORT_ELEMENT);
    for (Iterator iterator = imports.iterator(); iterator.hasNext();) {
      Element element = (Element) iterator.next();
      String importedModelFQName = NameUtil.fqNameFromNamespaceAndName(element.getAttributeValue(NAMESPACE),
              element.getAttributeValue(NAME));
      int referenceID = readIntAttributeValue(element, MODEL_REFERENCE_ID);
      semanticModel.addImportElement(importedModelFQName, referenceID);
    }

    ArrayList<ReferenceDescriptor> referenceDescriptors = new ArrayList<ReferenceDescriptor>();
    List children = rootElement.getChildren(NODE);
    for (Iterator iterator = children.iterator(); iterator.hasNext();) {
      Element element = (Element) iterator.next();
      SNode semanticNode = readNode(element, semanticModel, referenceDescriptors);
      semanticModel.addRoot(semanticNode);
    }


    for (ReferenceDescriptor referenceDescriptor : referenceDescriptors) {
      SReference semanticReference = null;
      semanticReference = SReference.newInstance(referenceDescriptor.role,
              referenceDescriptor.sourceNode,
              referenceDescriptor.targetId,
              referenceDescriptor.isBad,
              referenceDescriptor.resolveInfo,
              referenceDescriptor.targetClassResolveInfo);
      if (semanticReference != null) referenceDescriptor.sourceNode.addSemanticReference(semanticReference);
    }



    semanticModel.setLoading(false);
    return semanticModel;
  }

  public static SNode readNode(Element nodeElement, SModel semanticModel, ArrayList<ReferenceDescriptor> referenceDescriptors)
  {
    return readNode(nodeElement, semanticModel, referenceDescriptors, true, null);
  }

  public static SNode readNode(Element nodeElement, SModel semanticModel, ArrayList<ReferenceDescriptor> referenceDescriptors, boolean setID, HashMap<String, SNode> oldIdsToNodes)
  {
    String type = nodeElement.getAttributeValue(TYPE);
    SNode semanticNode = createNodeInstance(type, semanticModel);
    if (semanticNode == null) {
      String error = "Error reading model " + semanticModel.getFQName() + ": couldn't create instance of node id=" + nodeElement.getAttributeValue(ID);
      LOG.errorWithTrace(error);
      firePersisteneceError();
      return null;
    }

    String myOldId = nodeElement.getAttributeValue(ID);

    if (setID) {
      semanticNode.setId(myOldId);
    }

    if (oldIdsToNodes != null) {
      oldIdsToNodes.put(myOldId, semanticNode);
    }

    List properties = nodeElement.getChildren(PROPERTY);
    for (Iterator iterator = properties.iterator(); iterator.hasNext();) {
      Element propertyElement = (Element) iterator.next();
      String propertyName = propertyElement.getAttributeValue(NAME);
      String propertyValue = propertyElement.getAttributeValue(VALUE);
      if (propertyValue != null) {
        semanticNode.setProperty(propertyName, propertyValue);
      }
    }

    List links = nodeElement.getChildren(LINK);
    for (Iterator iterator = links.iterator(); iterator.hasNext();) {
      Element linkElement = (Element) iterator.next();
      String role = linkElement.getAttributeValue(ROLE);
      String bad = linkElement.getAttributeValue(BAD, "false");
      String resolveInfo = linkElement.getAttributeValue(RESOLVE_INFO);
      String targetClassResolveInfo = linkElement.getAttributeValue(TARGET_CLASS_RESOLVE_INFO);
      boolean isBad = ("true".equals(bad));
//      LinkMetaclass metaclass = LinkMetaclass.parseValue(linkElement.getAttributeValue(META_CLASS));
//      if (metaclass == LinkMetaclass.aggregation) {
//        // old style of children saving (keep this for a while)
//        Element targetElement = linkElement.getChild(NODE);
//        SNode targetNode = readNode(targetElement, semanticModel, referenceDescriptors, setID);
//        if (targetNode != null) {
//          semanticNode.addChild(role, targetNode);
//        } else {
//          (new RuntimeException("Error reading child node in node " + semanticNode.getDebugText())).printStackTrace();
//          firePersisteneceError();
//        }
//      } else {
      String targetNodeId = linkElement.getAttributeValue(TARGET_NODE_ID);
      if (resolveInfo == null || resolveInfo.equals("") || targetClassResolveInfo == null || targetClassResolveInfo.equals("")) {
        referenceDescriptors.add(new ReferenceDescriptor(semanticNode, role, targetNodeId, isBad));
      } else {
        referenceDescriptors.add(new ReferenceDescriptor(semanticNode, role, targetNodeId, isBad, resolveInfo, targetClassResolveInfo));
      }
//      }
    }

    List childNodes = nodeElement.getChildren(NODE);
    for (Iterator iterator = childNodes.iterator(); iterator.hasNext();) {
      Element childNodeElement = (Element) iterator.next();
      String role = childNodeElement.getAttributeValue(ROLE);
      SNode childNode = readNode(childNodeElement, semanticModel, referenceDescriptors, setID, oldIdsToNodes);
      if (childNode != null) {
        semanticNode.addChild(role, childNode);
      } else {
        LOG.errorWithTrace("Error reading child node in node " + semanticNode.getDebugText());
        firePersisteneceError();
      }
    }

    return semanticNode;
  }


  public static SNode createNodeInstance(String type, SModel semanticModel) {
    try {
      Class nodeClass = Class.forName(type, true, ClassLoaderManager.getInstance().getClassLoader());
      Method method = nodeClass.getMethod("newInstance", new Class[]{SModel.class});
      SNode semanticNode = (SNode) method.invoke(nodeClass, new Object[]{semanticModel});
      return semanticNode;
    } catch (ClassNotFoundException e) {
      LOG.warning("I can't find class for node type " + type);
      return new SNode(semanticModel) { }; //this hack is required to make diff work correctly event if no such class
    } catch (NoSuchMethodException e) {
      LOG.error(e);
    } catch (SecurityException e) {
      LOG.error(e);
    } catch (IllegalAccessException e) {
      LOG.error(e);
    } catch (IllegalArgumentException e) {
      LOG.error(e);
    } catch (InvocationTargetException e) {
      LOG.error(e);
    }
    return null;
  }

  public static SModel refreshModel(SModel model) {
    String name = model.getName();
    return readModel(saveModel(model), name);
  }

  public static void saveModel(SModel sourceModel, File file) {
    LOG.debug("Save model " + sourceModel.getFQName() + " to file " + file.getAbsolutePath());
    Document document = saveModel(sourceModel);

    try {
      JDOMUtil.writeDocument(document, file);
    } catch (IOException e) {
      LOG.error(e);
    }
  }

  private static Document saveModel(SModel sourceModel) {
    Element rootElement = new Element(MODEL);
    rootElement.setAttribute(NAMESPACE, sourceModel.getNamespace());
    setNotNullAttribute(rootElement, STEREOTYPE, sourceModel.getStereotype());

    Document document = new Document();
    document.setRootElement(rootElement);

    Element maxRefID = new Element(MAX_REFERENCE_ID);
    maxRefID.setAttribute(VALUE, "" + sourceModel.getMaxReferenceID());
    rootElement.addContent(maxRefID);

    // languages
    for (String languageNamespace : sourceModel.getLanguageNamespaces()) {
      Element languageElem = new Element(LANGUAGE);
      languageElem.setAttribute(NAMESPACE, languageNamespace);
      rootElement.addContent(languageElem);
    }

    // imports
    Iterator<SModel.ImportElement> imports = sourceModel.importElements();
    while (imports.hasNext()) {
      SModel.ImportElement importElement = imports.next();
      Element importElem = new Element(IMPORT_ELEMENT);
      importElem.setAttribute(MODEL_REFERENCE_ID, "" + importElement.getReferenceID());
      String fqName = importElement.getModelFQName();
      importElem.setAttribute(NAME, NameUtil.nameFromFQName(fqName));
      importElem.setAttribute(NAMESPACE, NameUtil.namespaceFromFQName(fqName));
      rootElement.addContent(importElem);
    }

    Iterator<SNode> iterator = sourceModel.roots();
    while (iterator.hasNext()) {
      SNode semanticNode = iterator.next();
      saveNode(rootElement, semanticNode);
    }

    return document;
  }

  public static void saveNode(Element parentElement, SNode semanticNode) {
    saveNode(parentElement, semanticNode, false);
  }

  public static void saveNode(Element parentElement, SNode semanticNode, boolean saveResolveInfo) {
    Element element = new Element(NODE);
    setNotNullAttribute(element, ROLE, semanticNode.getRole_());
    element.setAttribute(TYPE, semanticNode.getClass().getName());
    element.setAttribute(ID, semanticNode.getId());

    // properties ...
    Map<String, String> properties = semanticNode.getProperties();
    Set<String> keys = properties.keySet();
    for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
      String propertyName = iterator.next();
      Element propertyElement = new Element(PROPERTY);
      element.addContent(propertyElement);
      propertyElement.setAttribute(NAME, propertyName);
      setNotNullAttribute(propertyElement, VALUE, semanticNode.getProperty(propertyName));
    }

    // references ...
    List<SReference> references = semanticNode.getReferences();
    for (Iterator<SReference> iterator = references.iterator(); iterator.hasNext();) {
      SReference semanticReference = iterator.next();
      Element linkElement = new Element(LINK);
      element.addContent(linkElement);
      linkElement.setAttribute(ROLE, semanticReference.getRole());
//      setNotNullAttribute(linkElement, META_CLASS, null);
      linkElement.setAttribute(TARGET_NODE_ID, semanticReference.createReferencedNodeId());
      if(!semanticReference.isGood()) {
        linkElement.setAttribute(BAD, "true");
      }
      String resolveInfo = semanticReference.getResolveInfo();
      if (!semanticReference.isGood() || (saveResolveInfo && resolveInfo != null)) linkElement.setAttribute(RESOLVE_INFO, resolveInfo);
      String targetClassResolveInfo = semanticReference.getTargetClassResolveInfo();
      if (!semanticReference.isGood() || saveResolveInfo && targetClassResolveInfo != null) linkElement.setAttribute(TARGET_CLASS_RESOLVE_INFO, targetClassResolveInfo);
    }

    // children ...
    List<SNode> children = semanticNode.getChildren();
    for (SNode childNode : children) {
      saveNode(element, childNode, saveResolveInfo);
    }

    parentElement.addContent(element);
  }


  private static void setNotNullAttribute(Element element, String attrName, String attrValue) {
    if (attrValue != null) {
      element.setAttribute(attrName, attrValue);
    }
  }

  private static int readIntAttributeValue(Element element, String attrName) throws NumberFormatException {
    return Integer.parseInt(element.getAttributeValue(attrName));
  }

  private static List<PersistenceErrorListener> ourListeners = new ArrayList<PersistenceErrorListener>();

  public static void addPersistenceListener(PersistenceErrorListener listener) {
    ourListeners.add(listener);
  }

  private static void firePersisteneceError() {
    for (PersistenceErrorListener listener : ourListeners) {
      listener.onError();
    }
  }

  public static interface PersistenceErrorListener {
    void onError();
  }

  public static class ReferenceDescriptor {
    public SNode sourceNode;
    public String role;
    public String targetId;
    public boolean isBad;
    public String resolveInfo;
    public String targetClassResolveInfo;

    public ReferenceDescriptor(SNode sourceNode, String role, String targetId, boolean isBad) {
      this.sourceNode = sourceNode;
      this.role = role;
      this.targetId = targetId;
      this.isBad = isBad;
    }

    public ReferenceDescriptor(SNode sourceNode, String role, String targetId, boolean isBad, String resolveInfo, String targetClassResolveInfo) {
      this(sourceNode, role, targetId, isBad);
      this.resolveInfo = resolveInfo;
      this.targetClassResolveInfo = targetClassResolveInfo;
    }

    public ReferenceDescriptor(SNode sourceNode, String role, String targetId) {
      this(sourceNode, role, targetId, false);
    }
  }
}
