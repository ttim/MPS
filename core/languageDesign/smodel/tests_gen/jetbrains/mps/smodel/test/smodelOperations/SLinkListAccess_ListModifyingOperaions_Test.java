package jetbrains.mps.smodel.test.smodelOperations;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import junit.framework.Assert;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

@MPSLaunch
public class SLinkListAccess_ListModifyingOperaions_Test extends BaseTransformationTest {
  @Test
  public void test_add() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_add", true);
  }

  @Test
  public void test_addAll() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_addAll", true);
  }

  @Test
  public void test_addFirst() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_addFirst", true);
  }

  @Test
  public void test_addLast() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_addLast", true);
  }

  @Test
  public void test_removeFromOriginalContainerOnAdd() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_removeFromOriginalContainerOnAdd", true);
  }

  @Test
  public void test_remove() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_remove", true);
  }

  @Test
  public void test_removeAll() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_removeAll", true);
  }

  @Test
  public void test_removeFirst() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_removeFirst", true);
  }

  @Test
  public void test_removeLast() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_removeLast", true);
  }

  @Test
  public void test_removeAt() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_removeAt", true);
  }

  @Test
  public void test_removeWhere() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_removeWhere", true);
  }

  @Test
  public void test_insert() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_insert", true);
  }

  @Test
  public void test_set() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_set", true);
  }

  @Test
  public void test_clear() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkListAccess_ListModifyingOperaions_Test$TestBody", "test_clear", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_add() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      SNode newChild = SConceptOperations.createNewNode("jetbrains.mps.lang.smodelTests.structure.Child", null);
      Assert.assertNull(SNodeOperations.getParent(newChild));
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).addElement(newChild);
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).contains(newChild));
      Assert.assertEquals(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), SNodeOperations.getParent(newChild));
    }

    public void test_addAll() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      List<SNode> addition = ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.createNewNode("jetbrains.mps.lang.smodelTests.structure.Child", null), SConceptOperations.createNewNode("jetbrains.mps.lang.smodelTests.structure.Child", null));
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).addSequence(ListSequence.fromList(addition));
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).containsSequence(ListSequence.fromList(addition)));
    }

    public void test_addFirst() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      SNode added = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).insertElement(0, SConceptOperations.createNewNode("jetbrains.mps.lang.smodelTests.structure.Child", null));
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(added));
      Assert.assertEquals(0, ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).indexOf(added));
      Assert.assertEquals(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), SNodeOperations.getParent(added));
    }

    public void test_addLast() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      SNode added = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).addElement(SConceptOperations.createNewNode("jetbrains.mps.lang.smodelTests.structure.Child", null));
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(added));
      Assert.assertEquals(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() - 1, ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).indexOf(added));
      Assert.assertEquals(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), SNodeOperations.getParent(added));
    }

    public void test_removeFromOriginalContainerOnAdd() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806423212"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 0);
      SNode toBeMoved = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806423212"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).first();
      Assert.assertEquals(SNodeOperations.cast(this.getNodeById("2282909602806423212"), "jetbrains.mps.lang.smodelTests.structure.Root"), SNodeOperations.getParent(toBeMoved));
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).addElement(toBeMoved);
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).contains(toBeMoved));
      Assert.assertEquals(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), SNodeOperations.getParent(toBeMoved));
      Assert.assertFalse(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806423212"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(toBeMoved));
    }

    public void test_remove() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 0);
      SNode toBeRemoved = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).first();
      Assert.assertNotNull(toBeRemoved);
      Assert.assertEquals(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), SNodeOperations.getParent(toBeRemoved));
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).removeElement(toBeRemoved);
      Assert.assertFalse(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(toBeRemoved));
      Assert.assertNull(SNodeOperations.getParent(toBeRemoved));
    }

    public void test_removeAll() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Iterable<SNode> existingChildren = Sequence.fromArray(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).toGenericArray(SNode.class));
      Assert.assertTrue(Sequence.fromIterable(existingChildren).count() > 1);
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).removeSequence(Sequence.fromIterable(existingChildren));
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).isEmpty());
    }

    public void test_removeFirst() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 1);
      SNode toBeRemoved = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).first();
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).removeElementAt(0);
      Assert.assertFalse(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(toBeRemoved));
    }

    public void test_removeLast() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 1);
      SNode toBeRemoved = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).last();
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).removeLastElement();
      Assert.assertFalse(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(toBeRemoved));
    }

    public void test_removeAt() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 1);
      int index = 1;
      SNode elementAt_1 = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).getElement(index);
      SNode removed = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).removeElementAt(index);
      Assert.assertFalse(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(removed));
      Assert.assertEquals(elementAt_1, removed);
    }

    public void test_removeWhere() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      int initialSize = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count();
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(SNodeOperations.cast(this.getNodeById("2282909602806391310"), "jetbrains.mps.lang.smodelTests.structure.Child")));
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).removeWhere(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SPropertyOperations.getString(it, "name").equals(SPropertyOperations.getString(SNodeOperations.cast(TestBody.this.getNodeById("2282909602806391310"), "jetbrains.mps.lang.smodelTests.structure.Child"), "name"));
        }
      });
      Assert.assertEquals(initialSize - 1, ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count());
      Assert.assertFalse(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(SNodeOperations.cast(this.getNodeById("2282909602806391310"), "jetbrains.mps.lang.smodelTests.structure.Child")));
      Assert.assertNull(SNodeOperations.getParent(SNodeOperations.cast(this.getNodeById("2282909602806391310"), "jetbrains.mps.lang.smodelTests.structure.Child")));
    }

    public void test_insert() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 1);
      int initialSize = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count();
      SNode toInsert = SConceptOperations.createNewNode("jetbrains.mps.lang.smodelTests.structure.Child", null);
      int index = 1;
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).insertElement(index, toInsert);
      Assert.assertEquals(initialSize + 1, ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count());
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(toInsert));
      Assert.assertEquals(index, ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).indexOf(toInsert));
    }

    public void test_set() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 1);
      int index = 1;
      SNode oldChild = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).getElement(index);
      SNode newChild = SConceptOperations.createNewNode("jetbrains.mps.lang.smodelTests.structure.Child", null);
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).setElement(index, newChild);
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(newChild));
      Assert.assertEquals(index, ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).indexOf(newChild));
      Assert.assertFalse(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).contains(oldChild));
      Assert.assertNull(SNodeOperations.getParent(oldChild));
    }

    public void test_clear() throws Exception {
      this.addNodeById("2282909602806268543");
      this.addNodeById("2282909602806423211");
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).count() > 0);
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).clear();
      Assert.assertTrue(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("2282909602806268544"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).isEmpty());
    }
  }
}
