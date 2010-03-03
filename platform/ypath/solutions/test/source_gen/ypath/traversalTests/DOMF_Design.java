package ypath.traversalTests;

/*Generated by MPS */

import jetbrains.mps.ypath.design.IParameterizedFeatureDesign;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class DOMF_Design {
  public static class Design_Feature_child extends IParameterizedFeatureDesign.Stub<String> implements IParameterizedFeatureDesign<String> {
    public Iterable<String> getParameters(SNode nodeType) {
      return Sequence.fromClosure(new ISequenceClosure<String>() {
        public Iterable<String> iterable() {
          return new Iterable<String>() {
            public Iterator<String> iterator() {
              return new YieldingIterator<String>() {
                private int __CP__ = 0;

                protected boolean moveToNext() {
__loop__:
                  do {
__switch__:
                    switch (this.__CP__) {
                      case -1:
                        assert false : "Internal error";
                        return false;
                      case 2:
                        this.__CP__ = 3;
                        this.yield("foo");
                        return true;
                      case 3:
                        this.__CP__ = 4;
                        this.yield("bar");
                        return true;
                      case 4:
                        this.__CP__ = 1;
                        this.yield("baz");
                        return true;
                      case 0:
                        this.__CP__ = 2;
                        break;
                      default:
                        break __loop__;
                    }
                  } while(true);
                  return false;
                }
              };
            }
          };
        }
      });
    }

    public SNode getTargetType(String param, SNode nodeType) {
      return new DOMF_Design.Design_Feature_child.QuotationClass_1hzurw_a0a0b0().createNode();
    }

    public String parameterToString(String param) {
      return param;
    }

    public static class QuotationClass_1hzurw_a0a0b0 {
      public QuotationClass_1hzurw_a0a0b0() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#org.w3c.dom(org.w3c.dom@java_stub)"), SNodeId.fromString("~Node")));
          result = quotedNode1_2;
        }
        return result;
      }
    }
  }
}
