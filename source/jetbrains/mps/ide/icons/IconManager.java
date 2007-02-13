package jetbrains.mps.ide.icons;

import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.ide.action.MPSAction;
import jetbrains.mps.ide.projectPane.Icons;
import jetbrains.mps.ide.BootstrapLanguages;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.Macros;
import jetbrains.mps.util.NameUtil;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kostik
 */
public class IconManager {

  public static final Logger LOG = Logger.getLogger(IconManager.class);

  private static Map<String, Icon> ourPathsToIcons = new HashMap<String, Icon>();

  public static Icon getIconFor(SNode node) {
    if (node == null) return Icons.DEFAULT_ICON;
    return getIconFor(node.getConceptDeclarationAdapter());
  }

  public static Icon getIconFor(ConceptDeclaration conceptDeclaration) {
    GlobalScope scope = GlobalScope.getInstance();
    while (conceptDeclaration != null) {
      Language language = SModelUtil_new.getDeclaringLanguage(conceptDeclaration, scope);
      if (language != null) {
        String iconPath = Macros.languageDescriptor().expandPath(conceptDeclaration.getIconPath(), language.getDescriptorFile());
        if (iconPath != null) {
          Icon icon = ourPathsToIcons.get(iconPath);
          if (icon != null) return icon;
          File file = new File(iconPath);
          if (file.exists()) {
            icon = new ImageIcon(iconPath);
            ourPathsToIcons.put(iconPath, icon);
            return icon;
          }
        }
      }
      conceptDeclaration = conceptDeclaration.getExtends();
    }

    return Icons.DEFAULT_ICON;
  }

  public static Icon getIconForConceptFQName(String conceptFQName) {
    ConceptDeclaration cd = SModelUtil_new.findConceptDeclaration(NameUtil.conceptFQNameByClassName(conceptFQName), GlobalScope.getInstance());
    return getIconFor(cd);
  }

  public static Icon getIconFor(String namespace) {
    String className = namespace + ".icons.Icons";
    try {
      Class icons = Class.forName(className, true, ClassLoaderManager.getInstance().getClassLoader());
      Icon icon = (Icon) icons.getMethod("getLanguageIcon").invoke(null);
      if (icon != null) return icon;
    } catch (Exception e) {
      LOG.error(e);
    }

    return MPSAction.EMPTY_ICON;

  }

  public static Icon getIconFor(SModelDescriptor modelDescriptor) {
    Language.LanguageAspectStatus languageAspectStatus = Language.getLanguageAspectStatus(modelDescriptor);
    if (languageAspectStatus.isLanguageAspect()) {
      if (languageAspectStatus.isEditor()) {
        return Icons.EDITOR_MODEL_ICON;
      } else if (languageAspectStatus.isStructure()) {
        return Icons.STRUCTURE_MODEL_ICON;
      } else if (languageAspectStatus.isActions()) {
        return Icons.ACTIONS_MODEL_ICON;
      } else if (languageAspectStatus.isTypesystem()) {
        return Icons.TYPESYSTEM_MODEL_ICON;
      } else if (languageAspectStatus.isHelginsTypesystem()) {
        return Icons.TYPESYSTEM_MODEL_ICON;
      } else if (languageAspectStatus.isConstraintsModel()) {
        return Icons.CONSTRAINTS_MODEL_ICON;
      }
    } else if (modelDescriptor.getStereotype() != null &&
            modelDescriptor.getStereotype().equals(SModelStereotype.TEMPLATES)) {
      return Icons.TEMPLATES_MODEL_ICON;
    } else if (languageAspectStatus.isAccessoryModel()) {
      return Icons.ACCESSORY_MODEL_ICON;
    }
    return Icons.MODEL_ICON;
  }

  public static Icon getIconFor(MPSModuleOwner owner) {
    if (owner instanceof Generator) {
      return Icons.GENERATOR_ICON;
    }
    if (owner instanceof Language) {
      return Icons.LANGUAGE_ICON;
    }
    if (owner instanceof MPSProject) {
      return Icons.PROJECT_ICON;
    }
    if (owner instanceof BootstrapLanguages) {
      return Icons.PROJECT_LANGUAGE_ICON;
    }
    if (owner instanceof Solution) {
      return Icons.SOLUTION_ICON;
    }
    if (owner instanceof DevKit) {
      return Icons.DEVKIT_ICON;
    }
    return Icons.DEFAULT_ICON;
  }
}
