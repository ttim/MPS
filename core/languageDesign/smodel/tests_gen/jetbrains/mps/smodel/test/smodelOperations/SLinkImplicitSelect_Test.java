package jetbrains.mps.smodel.test.smodelOperations;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import junit.framework.Assert;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IVisitor;

@MPSLaunch
public class SLinkImplicitSelect_Test extends BaseTransformationTest {
  @Test
  public void test_empty() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkImplicitSelect_Test$TestBody", "test_empty", true);
  }

  @Test
  public void test_singleChild() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkImplicitSelect_Test$TestBody", "test_singleChild", true);
  }

  @Test
  public void test_multipleChildren() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkImplicitSelect_Test$TestBody", "test_multipleChildren", true);
  }

  @Test
  public void test_operationsOnList() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkImplicitSelect_Test$TestBody", "test_operationsOnList", true);
  }

  @Test
  public void test_specializedLinks() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkImplicitSelect_Test$TestBody", "test_specializedLinks", true);
  }

  @Test
  public void test_inheritedLinks() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:3526f944-06ad-48b3-a2a1-fffa752849ed(jetbrains.mps.smodel.test.smodelOperations)");
    this.runTest("jetbrains.mps.smodel.test.smodelOperations.SLinkImplicitSelect_Test$TestBody", "test_inheritedLinks", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_empty() throws Exception {
      this.addNodeById("278471160714368807");
      this.addNodeById("7551657168186489228");
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_0_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_0_1", true);
        }
      }).isEmpty());
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_0_n", true);
        }
      }).isEmpty());
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_1", true);
        }
      }).isEmpty());
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_1_n", true);
        }
      }).isEmpty());
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_0_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_0_1", true);
        }
      }).isEmpty());
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_0_n", true);
        }
      }).isEmpty());
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_1", true);
        }
      }).isEmpty());
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("278471160714368808"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_1_n", true);
        }
      }).isEmpty());
    }

    public void test_singleChild() throws Exception {
      this.addNodeById("278471160714368807");
      this.addNodeById("7551657168186489228");
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_0_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_0_1", true);
        }
      }).isEmpty());
      this.assertEquals(Sequence.<SNode>singleton(SNodeOperations.cast(this.getNodeById("7551657168186489235"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")), ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_1", true);
        }
      }));
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_0_n", true);
        }
      }).isEmpty());
      this.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("7551657168186489236"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("7551657168186489238"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")}), ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_0_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_1_n", true);
        }
      }));
    }

    public void test_multipleChildren() throws Exception {
      this.addNodeById("278471160714368807");
      this.addNodeById("7551657168186489228");
      Assert.assertTrue(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_0_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_0_1", true);
        }
      }).isEmpty());
      this.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("7551657168186489231"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("7551657168186611648"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")}), ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_1", true);
        }
      }));
      this.assertEquals(Sequence.<SNode>singleton(SNodeOperations.cast(this.getNodeById("7551657168186611659"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")), ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_0_n", true);
        }
      }));
      this.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("7551657168186489232"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("7551657168186611655"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("7551657168186611649"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("7551657168186611661"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")}), ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_1_n", true);
        }
      }));
    }

    public void test_operationsOnList() throws Exception {
      this.addNodeById("278471160714368807");
      this.addNodeById("7551657168186489228");
      List<SNode> list = ListSequence.<SNode>fromList(new ArrayList<SNode>());
      ListSequence.<SNode>fromList(list).addSequence(ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "child_1_n", true)));
      this.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("7551657168186489231"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("7551657168186611648"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")}), ListSequence.<SNode>fromList(list).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_1", true);
        }
      }));
    }

    public void test_specializedLinks() throws Exception {
      this.addNodeById("278471160714368807");
      this.addNodeById("7551657168186489228");
      this.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("34342663958911397"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("34342663958911401"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")}), ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "childSubConcept_0_n", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "grandChild_0_1", true) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "grandChild_0_1", true);
        }
      }));
    }

    public void test_inheritedLinks() throws Exception {
      this.addNodeById("278471160714368807");
      this.addNodeById("7551657168186489228");
      this.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("34342663959152983"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("34342663959152984"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SNodeOperations.cast(this.getNodeById("34342663959152985"), "jetbrains.mps.lang.smodelTests.structure.GrandChild")}), ListSequence.<SNode>fromList(SLinkOperations.getTargets(SNodeOperations.cast(this.getNodeById("7551657168186489229"), "jetbrains.mps.lang.smodelTests.structure.Root"), "childSubConcept_0_n", true)).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "grandChild_0_n", true);
        }
      }));
    }

    public void assertEquals(Iterable<SNode> expected, final Iterable<SNode> actual) {
      Assert.assertEquals(Sequence.<SNode>fromIterable(expected).count(), Sequence.<SNode>fromIterable(actual).count());
      Sequence.<SNode>fromIterable(expected).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          Assert.assertTrue(Sequence.<SNode>fromIterable(actual).contains(it));
        }
      });
    }
  }
}
