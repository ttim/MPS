package jetbrains.mps.smodel.test.reflection;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import junit.framework.Assert;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.IVisitor;

@MPSLaunch
public class SNodeGetReferencesOperation_Test extends BaseTransformationTest {
  @Test
  public void test_size() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_size", true);
  }

  @Test
  public void test_target() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_target", true);
  }

  @Test
  public void test_linkDeclaration() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_linkDeclaration", true);
  }

  @Test
  public void test_forSpecializedLink() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_forSpecializedLink", true);
  }

  @Test
  public void test_roles() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_roles", true);
  }

  @Test
  public void test_resolveInfo() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_resolveInfo", true);
  }

  @Test
  public void test_unspecifiedReferences() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_unspecifiedReferences", true);
  }

  @Test
  public void test_unresolvedReference() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_unresolvedReference", true);
  }

  @Test
  public void test_forNull() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8ac706c2-cfd2-4da3-8b63-a741ed2733d4(jetbrains.mps.smodel.test.reflection)");
    this.runTest("jetbrains.mps.smodel.test.reflection.SNodeGetReferencesOperation_Test$TestBody", "test_forNull", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_size() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      Assert.assertTrue(Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022219808"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).isEmpty());
      Assert.assertEquals(3, Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022219844"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).count());
    }

    public void test_target() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      TestUtilities.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("2906110183022219847"), "jetbrains.mps.lang.smodelTests.structure.Root"), SNodeOperations.cast(this.getNodeById("2906110183022219848"), "jetbrains.mps.lang.smodelTests.structure.Child"), SNodeOperations.cast(this.getNodeById("2906110183022311236"), "jetbrains.mps.lang.smodelTests.structure.ChildSubConcept")}), Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022219844"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).<SNode>select(new ISelector<SReference, SNode>() {
        public SNode select(SReference it) {
          return SLinkOperations.getTargetNode(it);
        }
      }));
    }

    public void test_linkDeclaration() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      TestUtilities.assertEquals(Sequence.fromArray(new SNode[]{SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "root"), SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "leftChild"), SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "rightChild")}), Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022219844"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).<SNode>select(new ISelector<SReference, SNode>() {
        public SNode select(SReference it) {
          return SLinkOperations.findLinkDeclaration(it);
        }
      }));
    }

    public void test_forSpecializedLink() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      TestUtilities.assertEquals(Sequence.fromArray(new SNode[]{SNodeOperations.cast(this.getNodeById("2906110183022311236"), "jetbrains.mps.lang.smodelTests.structure.ChildSubConcept")}), Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022354866"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainerSubConcept"))).where(new IWhereFilter<SReference>() {
        public boolean accept(SReference it) {
          return SLinkOperations.findLinkDeclaration(it) == SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "rightChild");
        }
      }).<SNode>select(new ISelector<SReference, SNode>() {
        public SNode select(SReference it) {
          return SLinkOperations.getTargetNode(it);
        }
      }));
      Assert.assertTrue(Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022354866"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainerSubConcept"))).where(new IWhereFilter<SReference>() {
        public boolean accept(SReference it) {
          return SLinkOperations.findLinkDeclaration(it) == SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainerSubConcept", "specializedRightChild");
        }
      }).isEmpty());
    }

    public void test_roles() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      TestUtilities.assertEquals(Sequence.fromArray(new String[]{SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "root"), "role"), SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "leftChild"), "role"), SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "rightChild"), "role")}), Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022219844"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).<String>select(new ISelector<SReference, String>() {
        public String select(SReference it) {
          return SLinkOperations.getRole(it);
        }
      }));
    }

    public void test_resolveInfo() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      // Resolving references by accessing .target node: 
      Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022219844"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).visitAll(new IVisitor<SReference>() {
        public void visit(SReference it) {
          SLinkOperations.getTargetNode(it);
        }
      });
      Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022219844"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).<String>select(new ISelector<SReference, String>() {
        public String select(SReference it) {
          return SLinkOperations.getResolveInfo(it);
        }
      }).visitAll(new IVisitor<String>() {
        public void visit(String it) {
          Assert.assertNotNull(it);
        }
      });
    }

    public void test_unspecifiedReferences() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      // Adding one unspecified reference and checking if it was added properly 
      int initialSize = Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).count();
      String unspecifiedReferenceName = this.addUnspecifiedReference(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"), SNodeOperations.cast(this.getNodeById("2906110183022219849"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"));
      Assert.assertEquals(initialSize + 1, Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).count());
      // Checking if unspecified reference is working properly 
      Iterable<SReference> unspecifiedReferences = Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).where(new IWhereFilter<SReference>() {
        public boolean accept(SReference it) {
          return (SLinkOperations.findLinkDeclaration(it) == null);
        }
      });
      Assert.assertEquals(1, Sequence.fromIterable(unspecifiedReferences).count());
      SReference theReference = Sequence.fromIterable(unspecifiedReferences).first();
      Assert.assertEquals(unspecifiedReferenceName, SLinkOperations.getRole(theReference));
      Assert.assertEquals(SNodeOperations.cast(this.getNodeById("2906110183022219849"), "jetbrains.mps.lang.smodelTests.structure.GrandChild"), SLinkOperations.getTargetNode(theReference));
    }

    public void test_unresolvedReference() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      int initialSize = Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).count();
      Assert.assertTrue(Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).where(new IWhereFilter<SReference>() {
        public boolean accept(SReference it) {
          return (SLinkOperations.getTargetNode(it) == null);
        }
      }).isEmpty());
      SLinkOperations.getTarget(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"), "root", false).delete();
      Assert.assertEquals(initialSize, Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).count());
      Iterable<SReference> brokenReferences = Sequence.fromIterable(SNodeOperations.getReferences(SNodeOperations.cast(this.getNodeById("2906110183022432277"), "jetbrains.mps.lang.smodelTests.structure.ReferenceContainer"))).where(new IWhereFilter<SReference>() {
        public boolean accept(SReference it) {
          return it.getTargetNodeSilently() == null;
        }
      });
      Assert.assertEquals(1, Sequence.fromIterable(brokenReferences).count());
      SReference theReference = Sequence.fromIterable(brokenReferences).first();
      Assert.assertEquals(SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "root"), "role"), SLinkOperations.getRole(theReference));
      Assert.assertEquals(SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.smodelTests.structure.ReferenceContainer", "root"), SLinkOperations.findLinkDeclaration(theReference));
      Assert.assertNotNull(SLinkOperations.getResolveInfo(theReference));
    }

    public void test_forNull() throws Exception {
      this.addNodeById("2906110183022219846");
      this.addNodeById("2906110183022219807");
      this.addNodeById("2906110183022219843");
      this.addNodeById("2906110183022354865");
      this.addNodeById("2906110183022432276");
      SNode nullNode = null;
      Assert.assertTrue(Sequence.fromIterable(SNodeOperations.getReferences(nullNode)).isEmpty());
      SReference nullReference = null;
      Assert.assertNull(SLinkOperations.findLinkDeclaration(nullReference));
      Assert.assertNull(SLinkOperations.getRole(nullReference));
      Assert.assertNull(SLinkOperations.getTargetNode(nullReference));
      Assert.assertNull(SLinkOperations.getResolveInfo(nullReference));
    }

    public String addUnspecifiedReference(SNode input, SNode referenceTarget) {
      String referenceName = "unspecifiedReference";
      input.setReferent(referenceName, referenceTarget);
      return referenceName;
    }
  }
}
