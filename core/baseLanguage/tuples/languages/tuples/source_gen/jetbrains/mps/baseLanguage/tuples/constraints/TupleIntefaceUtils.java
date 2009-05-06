package jetbrains.mps.baseLanguage.tuples.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.pattern.util.MatchingUtil;
import jetbrains.mps.internal.collections.runtime.IEnumerator;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;

public class TupleIntefaceUtils {

  public TupleIntefaceUtils() {
  }

  public static boolean isTupleInterface(SNode ifc) {
    if (ListSequence.fromList(analyzeTupleInterface(ifc)).isNotEmpty()) {
      System.out.println("*** Found tuple interface: " + SPropertyOperations.getString(ifc, "name") + ": " + String.valueOf(analyzeTupleInterface(ifc)));
    }
    return ListSequence.fromList(analyzeTupleInterface(ifc)).isNotEmpty();
  }

  public static List<TupleIntefaceUtils.Property> analyzeTupleInterface(SNode ifc) {
    List<TupleIntefaceUtils.Property> accessors = ListSequence.fromList(new ArrayList<TupleIntefaceUtils.Property>());
    List<TupleIntefaceUtils.Property> mutators = ListSequence.fromList(new ArrayList<TupleIntefaceUtils.Property>());
    int ignored = 0;
    for(SNode method : ListSequence.fromList(SLinkOperations.getTargets(ifc, "method", true))) {
      if (SLinkOperations.getCount(method, "parameter") == 0 && !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType"))) {
        ListSequence.fromList(accessors).addElement(new TupleIntefaceUtils.Property(true, SPropertyOperations.getString(method, "name"), SLinkOperations.getTarget(method, "returnType", true)));
      } else if (SLinkOperations.getCount(method, "parameter") == 1 && MatchingUtil.matchNodes(SLinkOperations.getTarget(method, "returnType", true), ListSequence.fromList(ListSequence.fromList(SLinkOperations.getTargets(method, "parameter", true)).toListSequence()).getElement(0))) {
        ListSequence.fromList(mutators).addElement(new TupleIntefaceUtils.Property(true, SPropertyOperations.getString(method, "name"), SLinkOperations.getTarget(method, "returnType", true)));
      } else if ("equals".equals(SPropertyOperations.getString(method, "name")) && SLinkOperations.getCount(method, "parameter") == 1 && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "returnType", true), "jetbrains.mps.baseLanguage.structure.BooleanType")) {
        ignored++ ;
      } else if ("hashCode".equals(SPropertyOperations.getString(method, "name")) && SLinkOperations.getCount(method, "parameter") == 0 && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "returnType", true), "jetbrains.mps.baseLanguage.structure.IntegerType")) {
        ignored++ ;
      }
    }
    List<TupleIntefaceUtils.Property> result = null;
    IEnumerator<TupleIntefaceUtils.Property> ait = ListSequence.fromList(accessors).sort(new ISelector <TupleIntefaceUtils.Property, Comparable<?>>() {

      public Comparable<?> select(TupleIntefaceUtils.Property p) {
        return p.name();
      }
    }, true).enumerator();
    IEnumerator<TupleIntefaceUtils.Property> mit = ListSequence.fromList(mutators).sort(new ISelector <TupleIntefaceUtils.Property, Comparable<?>>() {

      public Comparable<?> select(TupleIntefaceUtils.Property p) {
        return p.name();
      }
    }, true).enumerator();
    boolean hasMutators = mit.moveNext();
    while (ait.moveNext()) {
      if (result == null) {
        result = ListSequence.fromList(new ArrayList<TupleIntefaceUtils.Property>());
      }
      while (hasMutators && ait.current().name().compareTo(mit.current().name()) < 0) {
        hasMutators = mit.moveNext();
      }
      if (hasMutators && ait.current().name().equals(mit.current().name())) {
        if (!(MatchingUtil.matchNodes(ait.current().type(), mit.current().type()))) {
          return null;
        }
        ait.current().isfinal(false);
      }
      ListSequence.fromList(result).addElement(ait.current());
    }
    if (mit.moveNext()) {
      return null;
    }
    return result;
  }

  public static class Property extends MultiTuple._3<Boolean, String, SNode> {

    public Property() {
      super();
    }
    public Property(Boolean isfinal, String name, SNode type) {
      super(isfinal, name, type);
    }

    public Boolean isfinal(Boolean value) {
      return super._0(value);
    }

    public String name(String value) {
      return super._1(value);
    }

    public SNode type(SNode value) {
      return super._2(value);
    }

    public Boolean isfinal() {
      return super._0();
    }

    public String name() {
      return super._1();
    }

    public SNode type() {
      return super._2();
    }

    @SuppressWarnings(value = "unchecked")
    public TupleIntefaceUtils.Property assignFrom(Tuples._3<Boolean, String, SNode> from) {
      return (TupleIntefaceUtils.Property)super.assign(from);
    }

}

}
