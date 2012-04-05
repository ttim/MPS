package jetbrains.mps.baseLanguage.scopes;

/*Generated by MPS */

import jetbrains.mps.scope.DelegatingScope;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.scope.ModelPlusImportedScope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public class ClassifiersScope extends DelegatingScope {
  protected static Log log = LogFactory.getLog(ClassifiersScope.class);

  public ClassifiersScope(SModel model, IScope scope, String conceptFqName) {
    super(new ModelPlusImportedScope(model, false, scope, conceptFqName));
  }

  @Override
  public SNode resolve(SNode contextNode, final String refText) {
    String className = refText;
    int dotIndex = className.lastIndexOf(".");
    final String simpleName = (dotIndex == -1 ?
      className :
      className.substring(dotIndex + 1)
    );
    Iterable<SNode> possibleClassifiers = ListSequence.fromList(getAvailableElements(simpleName)).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.Classifier");
      }
    }).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.getString(it, "name").equals(simpleName);
      }
    });

    if (dotIndex == -1) {
      if ((int) Sequence.fromIterable(possibleClassifiers).count() == 1) {
        return Sequence.fromIterable(possibleClassifiers).first();
      } else {
        if (log.isWarnEnabled()) {
          log.warn("Cannot resolve class at " + contextNode + " with refText " + refText);
        }
        return null;
      }
    } else {
      Iterable<SNode> possibleWithEqualFqName = Sequence.fromIterable(possibleClassifiers).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return INamedConcept_Behavior.call_getFqName_1213877404258(it).endsWith(refText);
        }
      });
      if (Sequence.fromIterable(possibleWithEqualFqName).isNotEmpty()) {
        if ((int) Sequence.fromIterable(possibleWithEqualFqName).count() == 1) {
          return Sequence.fromIterable(possibleWithEqualFqName).first();
        } else {
          if (log.isWarnEnabled()) {
            log.warn("Cannot resolve class at " + contextNode + " with refText " + refText);
          }
          return null;
        }
      } else {
        if ((int) Sequence.fromIterable(possibleClassifiers).count() == 1) {
          return Sequence.fromIterable(possibleClassifiers).first();
        } else {
          if (log.isWarnEnabled()) {
            log.warn("Cannot resolve class at " + contextNode + " with refText " + refText);
          }
          return null;
        }
      }
    }
  }

  @Override
  public String getReferenceText(SNode contextNode, SNode node) {
    // <node> 
    // todo: should use fqName 
    return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier"), "name");
  }
}
