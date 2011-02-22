package jetbrains.mps.platform.conf.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class BeanExtensionPoint_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Iterable<BeanProperty> call_properties_6121364846593790733(SNode thisNode) {
    return BeanUtil.properties(SLinkOperations.getTarget(thisNode, "beanClass", false));
  }

  public static Iterable<String> call_propertyNames_618741292999315209(SNode thisNode) {
    return Sequence.fromIterable(BeanUtil.properties(SLinkOperations.getTarget(thisNode, "beanClass", false))).<String>select(new ISelector<BeanProperty, String>() {
      public String select(BeanProperty p) {
        return p.name();
      }
    });
  }

  public static BeanProperty call_property_6121364846593790761(SNode thisNode, final String name) {
    return Sequence.fromIterable(BeanUtil.properties(SLinkOperations.getTarget(thisNode, "beanClass", false))).findFirst(new IWhereFilter<BeanProperty>() {
      public boolean accept(BeanProperty p) {
        return eq_esf6t4_a0a0a0a0a0a0d(p.name(), name);
      }
    });
  }

  private static boolean eq_esf6t4_a0a0a0a0a0a0d(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
