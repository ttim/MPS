package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.build.packaging.behavior.Layout_Behavior;
import jetbrains.mps.build.packaging.behavior.Configuration_Behavior;
import java.io.File;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import com.intellij.openapi.project.Project;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.ide.generator.GeneratorUIFacade;
import jetbrains.mps.project.ProjectOperationContext;
import java.util.ArrayList;
import jetbrains.mps.generator.GenerationFacade;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.ide.messages.DefaultMessageHandler;
import jetbrains.mps.generator.GenerationOptions;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;

public class GenerateBuildUtil {
  public GenerateBuildUtil() {
  }

  public static String getFolderToGenerateInto(final SNode configuration) {
    final Wrappers._T<String> folder = new Wrappers._T<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        folder.value = Layout_Behavior.call_getFolderToGenerate_1229522949966(Configuration_Behavior.call_getLayout_1213877261819(configuration));
      }
    });
    return folder.value;
  }

  public static String getGeneratedFilePath(final SNode configuration) {
    final Wrappers._T<String> fileName = new Wrappers._T<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        fileName.value = Layout_Behavior.call_getFolderToGenerate_1229522949966(Configuration_Behavior.call_getLayout_1213877261819(configuration)) + File.separator + Configuration_Behavior.call_getBuildFileName_1230217425313(configuration) + ".xml";
      }
    });
    return fileName.value;
  }

  public static SNode getLayout(final SModelDescriptor descriptor) {
    final Wrappers._T<SNode> layout = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        SModel model = descriptor.getSModel();
        layout.value = ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.build.packaging.structure.Layout")).first();
      }
    });
    return layout.value;
  }

  public static boolean generate(final SNode layout, final Project project, final boolean showWindow) {
    final Wrappers._T<String> baseFolder = new Wrappers._T<String>();
    final Wrappers._T<SModelDescriptor> descriptor = new Wrappers._T<SModelDescriptor>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        baseFolder.value = Layout_Behavior.call_getFolderToGenerate_1229522949966(layout);
        descriptor.value = SNodeOperations.getModel(layout).getModelDescriptor();
      }
    });

    final Wrappers._boolean result = new Wrappers._boolean();
    final _FunctionTypes._void_P0_E0 generate = new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        if (showWindow) {
          result.value = GeneratorUIFacade.getInstance().generateModels(ProjectOperationContext.get(project), ListSequence.fromListAndArray(new ArrayList<SModelDescriptor>(), descriptor.value), new BuildGenerationHandler(baseFolder.value), true, true);
        } else {
          result.value = GenerationFacade.generateModels(project, ListSequence.fromListAndArray(new ArrayList<SModelDescriptor>(), descriptor.value), ProjectOperationContext.get(project), new BuildGenerationHandler(baseFolder.value), new EmptyProgressIndicator(), new DefaultMessageHandler(project), GenerationOptions.getDefaults().create());
        }
      }
    };
    if (ApplicationManager.getApplication().isDispatchThread()) {
      generate.invoke();
    } else {
      ApplicationManager.getApplication().invokeAndWait(new Runnable() {
        public void run() {
          generate.invoke();
        }
      }, ModalityState.NON_MODAL);
    }
    return result.value;
  }
}
