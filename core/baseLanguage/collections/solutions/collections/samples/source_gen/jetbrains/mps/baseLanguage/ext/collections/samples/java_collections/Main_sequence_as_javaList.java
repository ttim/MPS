package jetbrains.mps.baseLanguage.ext.collections.samples.java_collections;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.ext.collections.internal.SequenceWithSupplier;
import java.util.List;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;

/* package */class Main_sequence_as_javaList {

  /* package */static void main(String[] args) {
    Iterable<Integer> sequence = new SequenceWithSupplier<Integer>(new zValueSupplier(null, null));
    List<Integer> list = SequenceOperations.toList(sequence);
    System.out.println("list: type cast -> java-list");
    List<Integer> javaList = list;
    for(Integer n : javaList) {
      System.out.println(n);
    }
  }

}
