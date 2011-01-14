package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import java.util.Map;
import jetbrains.mps.baseLanguage.structure.Classifier;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.SModelSearchUtil;
import java.util.ArrayList;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.INodeAdapter;
import jetbrains.mps.baseLanguage.structure.ClassConcept;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import jetbrains.mps.baseLanguage.structure.Interface;

public class AllSubclassifiersScope extends AbstractClassifiersScope {
  private final SModel model;
  private final IScope scope;
  private Map<Classifier, Boolean> visitedClassifiersMap = null;
  private final Classifier rootClassifier;
  private List<Classifier> foundClassifiers;

  public AllSubclassifiersScope(Classifier classifier, SModel model, int constraint, IScope scope) {
    super(constraint);
    this.rootClassifier = classifier;
    this.model = model;
    this.scope = scope;
  }

  @Override
  @NotNull
  public List<Classifier> getClassifiers() {
    this.init();
    return this.foundClassifiers;
  }

  @SuppressWarnings(value = {"unchecked"})
  private void init() {
    if (this.foundClassifiers == null) {
      this.visitedClassifiersMap = new HashMap<Classifier, Boolean>();
      this.visitedClassifiersMap.put(this.rootClassifier, true);
      ISearchScope searchScope = SModelSearchUtil.createModelAndImportedModelsScope(this.model, false, this.scope);
      this.foundClassifiers = new ArrayList<Classifier>((List) searchScope.getAdapters(new Condition<INodeAdapter>() {
        public boolean met(INodeAdapter adapter) {
          return adapter instanceof Classifier && AllSubclassifiersScope.this.checkSubclassifier((Classifier) adapter);
        }
      }));
      this.visitedClassifiersMap.clear();
    }
  }

  private boolean checkSubclassifier(Classifier cls) {
    if (this.visitedClassifiersMap.containsKey(cls)) {
      return this.visitedClassifiersMap.get(cls);
    }
    boolean result = false;
    if (cls instanceof ClassConcept) {
      ClassConcept extendedClass = BaseLanguageUtil.getSuperclass((ClassConcept) cls);
      if (extendedClass != null && this.checkSubclassifier(extendedClass)) {
        result = true;
      }
      if (!(result)) {
        for (Iterator<ClassifierType> it = ((ClassConcept) cls).implementedInterfaces(); it.hasNext();) {
          if (this.checkSubclassifier(it.next().getClassifier())) {
            result = true;
            break;
          }
        }
      }
    } else
    if (cls instanceof Interface) {
      for (Iterator<ClassifierType> it = ((Interface) cls).extendedInterfaces(); it.hasNext();) {
        if (this.checkSubclassifier(it.next().getClassifier())) {
          result = true;
          break;
        }
      }
    }
    this.visitedClassifiersMap.put(cls, result);
    return result;
  }
}
