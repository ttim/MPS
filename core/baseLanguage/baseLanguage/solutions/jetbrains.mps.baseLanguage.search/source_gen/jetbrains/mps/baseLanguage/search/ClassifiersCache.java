package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import jetbrains.mps.cache.AbstractCache;
import jetbrains.mps.cache.KeyProducer;
import java.util.Map;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.Set;
import java.util.Collections;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.event.SModelRootEvent;
import jetbrains.mps.smodel.event.SModelChildEvent;
import jetbrains.mps.smodel.event.SModelPropertyEvent;
import jetbrains.mps.cache.CachesManager;

/*package*/ class ClassifiersCache extends AbstractCache {
  private static final KeyProducer keyProducer = new KeyProducer();

  private Map<String, List<SNode>> myClassifiersByName = MapSequence.fromMap(new HashMap<String, List<SNode>>());
  private Map<SNode, String> myNameByClassifier = MapSequence.fromMap(new HashMap<SNode, String>());

  protected ClassifiersCache(Object key, SModelDescriptor model) {
    super(key);
    for (SNode node : model.getSModel().roots()) {
      this.processNode(node, true);
    }
  }

  @Override
  public Set<SModelDescriptor> getDependsOnModels(Object element) {
    return Collections.singleton((SModelDescriptor) element);
  }

  private void processNode(SNode node, boolean put) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Classifier")) {
      SNode classifier = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier");
      if (put) {
        this.putClassifier(classifier);
      } else {
        this.removeClassifier(classifier);
      }
    } else {
      for (SNode child : SNodeOperations.getChildren(node)) {
        this.processNode(child, put);
      }
    }
  }

  private void putClassifier(SNode classifier) {
    String name = this.getRefName(classifier);
    if (!(MapSequence.fromMap(myClassifiersByName).containsKey(name))) {
      MapSequence.fromMap(myClassifiersByName).put(name, new ArrayList<SNode>());
    }
    ListSequence.fromList(MapSequence.fromMap(myClassifiersByName).get(name)).addElement(classifier);
    MapSequence.fromMap(myNameByClassifier).put(classifier, name);
    List<SNode> list = SLinkOperations.getTargets(classifier, "staticInnerClassifiers", true);
    for (SNode innerClassifier : list) {
      this.putClassifier(innerClassifier);
    }
  }

  private void removeClassifier(SNode classifier) {
    String name = this.getRefName(classifier);
    if (MapSequence.fromMap(myClassifiersByName).containsKey(name)) {
      List<SNode> nodes = MapSequence.fromMap(myClassifiersByName).get(name);
      nodes.remove(classifier);
      if (ListSequence.fromList(nodes).isEmpty()) {
        MapSequence.fromMap(myClassifiersByName).removeKey(name);
      }
    }
    MapSequence.fromMap(myNameByClassifier).removeKey(classifier);
    List<SNode> list = SLinkOperations.getTargets(classifier, "staticInnerClassifiers", true);
    for (SNode innerClassifier : list) {
      this.removeClassifier(innerClassifier);
    }
  }

  private String getRefName(SNode classifier) {
    String name = SPropertyOperations.getString(classifier, "name");
    if (name == null) {
      name = "";
    }
    SNode parent = SNodeOperations.getParent(classifier);
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.Classifier")) {
      return this.getRefName(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.Classifier")) + "." + name;
    }
    return name;
  }

  public List<SNode> getClassifiers() {
    return new ArrayList<SNode>(MapSequence.fromMap(this.myNameByClassifier).keySet());
  }

  public List<SNode> getClassifiersByRefName(String refName) {
    List<SNode> result = MapSequence.fromMap(myClassifiersByName).get(refName);
    if (result != null) {
      return result;
    }
    return new ArrayList<SNode>();
  }

  public void rootAdded(SModelRootEvent event) {
    this.processNode(event.getRoot(), true);
  }

  public void rootRemoved(SModelRootEvent event) {
    this.processNode(event.getRoot(), false);
  }

  public void childAdded(SModelChildEvent event) {
    SNode node = event.getChild();
    if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Classifier"))) {
      if (SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.Classifier", false, false) != null) {
        return;
      }
    }
    this.processNode(node, true);
  }

  public void beforeChildRemoved(SModelChildEvent event) {
    SNode node = event.getChild();
    if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Classifier"))) {
      if (SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.Classifier", false, false) != null) {
        return;
      }
    }
    this.processNode(node, true);
  }

  public void propertyChanged(SModelPropertyEvent event) {
    SNode node = event.getNode();
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Classifier") && "name".equals(event.getPropertyName())) {
      SNode classifier = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier");
      List<SNode> classifiersToUpdate = new ArrayList<SNode>();
      ListSequence.fromList(classifiersToUpdate).addElement(classifier);
      collectInnerClasses(classifier, classifiersToUpdate);
      for (SNode cl : classifiersToUpdate) {
        String oldRefName = MapSequence.fromMap(myNameByClassifier).get(cl);
        List<SNode> nodes = MapSequence.fromMap(myClassifiersByName).get(oldRefName);
        if (nodes != null) {
          nodes.remove(cl);
        }
        if (nodes == null || nodes.isEmpty()) {
          MapSequence.fromMap(myClassifiersByName).removeKey(oldRefName);
        }
        MapSequence.fromMap(myNameByClassifier).removeKey(cl);
      }
      this.putClassifier(classifier);
    }
  }

  private void collectInnerClasses(SNode classConcept, List<SNode> list) {
    List<SNode> inners = SLinkOperations.getTargets(classConcept, "staticInnerClassifiers", true);
    list.addAll(inners);
    for (SNode inner : inners) {
      this.collectInnerClasses(inner, list);
    }
  }

  public static ClassifiersCache getInstance(SModelDescriptor model) {
    String uid = model.getSModelReference().toString();
    Object key = keyProducer.createKey(uid);
    return (ClassifiersCache) CachesManager.getInstance().getCache(key, model, new CachesManager.CacheCreator<SModelDescriptor>() {
      public AbstractCache create(Object key, SModelDescriptor element) {
        return new ClassifiersCache(key, element);
      }
    });
  }
}
