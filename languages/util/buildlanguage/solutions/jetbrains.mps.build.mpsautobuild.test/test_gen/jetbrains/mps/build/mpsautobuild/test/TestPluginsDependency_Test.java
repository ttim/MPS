package jetbrains.mps.build.mpsautobuild.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.build.packaging.behavior.Layout_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.build.packaging.behavior.Module_Behavior;
import jetbrains.mps.build.packaging.generator.util.CheckFullDependencyUtil;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.Sequence;
import junit.framework.Assert;

@MPSLaunch
public class TestPluginsDependency_Test extends BaseTransformationTest {
  @Test
  public void test_pluginDependencyComplete() throws Throwable {
    this.initTest("${mps_home}/bin/MPS", "r:53c4b5ce-bc17-4454-a907-f9ec447f3644(jetbrains.mps.build.mpsautobuild.test@tests)");
    this.runTest("jetbrains.mps.build.mpsautobuild.test.TestPluginsDependency_Test$TestBody", "test_pluginDependencyComplete", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_pluginDependencyComplete() throws Exception {
      SNode layout = SNodeOperations.getNode("r:972ae1d5-2beb-44b3-a739-a548d8eb423d(jetbrains.mps.build.mpsautobuild)", "2235195415637073459");

      Map<IModule, SNode> modules = MapSequence.fromMap(new HashMap<IModule, SNode>());
      for (SNode m : ListSequence.fromList(Layout_Behavior.call_getModules_1213877228340(layout)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.packaging.structure.PluginModule"));
        }
      })) {
        MapSequence.fromMap(modules).put(Module_Behavior.call_getModule_1213877515148(m), m);
      }

      Map<SNode, Iterable<SNode>> missingPlugins = CheckFullDependencyUtil.checkFullPuginDependency(modules);
      StringBuffer sb = new StringBuffer();
      for (SNode plugin : SetSequence.fromSet(MapSequence.fromMap(missingPlugins).keySet())) {
        String id = CheckFullDependencyUtil.getId(plugin);
        for (SNode dependency : Sequence.fromIterable(MapSequence.fromMap(missingPlugins).get(plugin))) {
          sb.append("Plugin ");
          sb.append(id);
          sb.append(" should depend on plugin ");
          sb.append(CheckFullDependencyUtil.getId(dependency));
          sb.append(".");
          sb.append("\n");
        }
      }

      Assert.assertTrue(sb.toString(), sb.length() == 0);
    }
  }
}
