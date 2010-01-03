package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.textGen.TextGenManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.textGen.TextGenBuffer;
import java.util.HashSet;
import jetbrains.mps.generator.JavaNameUtil;

public abstract class BaseLanguageTextGen {
  public static void typeParameters(List<SNode> types, final SNodeTextGen textGen) {
    if (ListSequence.fromList(types).isNotEmpty()) {
      textGen.append("<");
      if (ListSequence.fromList(types).isNotEmpty()) {
        for (SNode item : types) {
          TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
          if (item != ListSequence.fromList(types).last()) {
            textGen.append(", ");
          }
        }
      }
      textGen.append(">");
    }
  }

  public static void arguments(SNode methodCall, final SNodeTextGen textGen) {
    textGen.append("(");
    if (ListSequence.fromList(SLinkOperations.getTargets(methodCall, "actualArgument", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(methodCall, "actualArgument", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
        if (item != ListSequence.fromList(SLinkOperations.getTargets(methodCall, "actualArgument", true)).last()) {
          textGen.append(", ");
        }
      }
    }
    textGen.append(")");
  }

  public static void newLine(boolean need, final SNodeTextGen textGen) {
    if (need) {
      textGen.appendNewLine();
    }
  }

  public static void annotations(SNode annotable, final SNodeTextGen textGen) {
    if (ListSequence.fromList(SLinkOperations.getTargets(annotable, "annotation", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(annotable, "annotation", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
      }
    }
  }

  public static void visibility(SNode v, final SNodeTextGen textGen) {
    if ((v == null)) {
      textGen.append("/*package*/ ");
    } else {
      TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), v, textGen.getSNode());
    }
  }

  public static void visibilityWithIndent(SNode v, final SNodeTextGen textGen) {
    textGen.indentBuffer();
    BaseLanguageTextGen.visibility(v, textGen);
  }

  public static void importPart(SNode node, final SNodeTextGen textGen) {
    if ((node == null)) {
      textGen.append("???");
      textGen.foundError();
      return;
    }
    BaseLanguageTextGen.appendClsName(BaseLanguageTextGen.getPackageName(node, textGen), SPropertyOperations.getString(node, "nestedName"), false, textGen);
  }

  public static void internalClassifierName(SNode node, final SNodeTextGen textGen) {
    if ((node == null)) {
      textGen.append("???");
      textGen.foundError();
      return;
    }
    BaseLanguageTextGen.appendClsName(BaseLanguageTextGen.getPackageName(node, textGen), SPropertyOperations.getString(node, "nestedName"), true, textGen);
  }

  public static void internalClassName(String pack, String className, final SNodeTextGen textGen) {
    BaseLanguageTextGen.appendClsName(pack, className, true, textGen);
  }

  public static void extendedInterface(SNode interface1, final SNodeTextGen textGen) {
    Set<String> dependencies = (Set<String>) BaseLanguageTextGen.getUserObjects(TextGenManager.EXTENDS, textGen);
    SetSequence.fromSet(dependencies).addElement(NameUtil.nodeFQName(interface1));
  }

  public static void implementedInterface(SNode classConcept, final SNodeTextGen textGen) {
    for (SNode classifierType : SLinkOperations.getTargets(classConcept, "implementedInterface", true)) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(classifierType, "classifier", false), "jetbrains.mps.baseLanguage.structure.Interface")) {
        BaseLanguageTextGen.extendedInterface(SNodeOperations.cast(SLinkOperations.getTarget(classifierType, "classifier", false), "jetbrains.mps.baseLanguage.structure.Interface"), textGen);
      }
    }
  }

  public static void extendedClasses(SNode classConcept, final SNodeTextGen textGen) {
    Set<String> dependencies = (Set<String>) BaseLanguageTextGen.getUserObjects(TextGenManager.EXTENDS, textGen);
    SetSequence.fromSet(dependencies).addElement(NameUtil.nodeFQName(classConcept));
  }

  public static void variableDeclaration(SNode node, final SNodeTextGen textGen) {
    if (SPropertyOperations.getBoolean(node, "isFinal")) {
      textGen.append("final ");
    }
    TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), SLinkOperations.getTarget(node, "type", true), textGen.getSNode());
    textGen.append(" ");
    textGen.append(SPropertyOperations.getString(node, "name"));
    if ((SLinkOperations.getTarget(node, "initializer", true) != null)) {
      textGen.append(" = ");
      TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), SLinkOperations.getTarget(node, "initializer", true), textGen.getSNode());
    }
  }

  public static void fileHeader(SNode cls, final SNodeTextGen textGen) {
    Set<String> names = (Set<String>) BaseLanguageTextGen.getUserObjects(TextGenManager.IMPORT, textGen);
    String newImport = BaseLanguageTextGen.getPackageName(cls, textGen) + "." + SPropertyOperations.getString(cls, "name");
    SetSequence.fromSet(names).addElement(newImport);
    if (cls.isRoot()) {
      int wasPart = textGen.getBuffer().selectPart(TextGenBuffer.TOP);
      textGen.append("package " + BaseLanguageTextGen.getPackageName(cls, textGen) + ";");
      textGen.appendNewLine();
      textGen.appendNewLine();
      textGen.append("/*Generated by MPS */");
      textGen.appendNewLine();
      textGen.getBuffer().selectPart(wasPart);
    }
    if (SNodeOperations.isInstanceOf(cls, "jetbrains.mps.baseLanguage.structure.Interface") && ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(cls, "jetbrains.mps.baseLanguage.structure.Interface"), "extendedInterface", true)).isNotEmpty()) {
      for (SNode interface1 : SLinkOperations.getTargets(SNodeOperations.cast(cls, "jetbrains.mps.baseLanguage.structure.Interface"), "extendedInterface", true)) {
        BaseLanguageTextGen.extendedInterface(SNodeOperations.cast(SLinkOperations.getTarget(interface1, "classifier", false), "jetbrains.mps.baseLanguage.structure.Interface"), textGen);
      }
    } else if (SNodeOperations.isInstanceOf(cls, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
      BaseLanguageTextGen.implementedInterface(cls, textGen);
      BaseLanguageTextGen.extendedClasses(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(cls, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "superclass", true), "classifier", false), textGen);
    }
  }

  public static void methodCall(SNode methodCall, final SNodeTextGen textGen) {
    if (ListSequence.fromList(SLinkOperations.getTargets(methodCall, "typeArgument", true)).isNotEmpty()) {
      textGen.append("<");
      if (ListSequence.fromList(SLinkOperations.getTargets(methodCall, "typeArgument", true)).isNotEmpty()) {
        for (SNode item : SLinkOperations.getTargets(methodCall, "typeArgument", true)) {
          TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
          if (item != ListSequence.fromList(SLinkOperations.getTargets(methodCall, "typeArgument", true)).last()) {
            textGen.append(",");
          }
        }
      }
      textGen.append(">");
      textGen.append(textGen.getReferentPresentation(SNodeOperations.getReference(methodCall, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.IMethodCall", "baseMethodDeclaration"))));
      BaseLanguageTextGen.arguments(methodCall, textGen);
    } else {
      textGen.append(textGen.getReferentPresentation(SNodeOperations.getReference(methodCall, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.IMethodCall", "baseMethodDeclaration"))));
      BaseLanguageTextGen.arguments(methodCall, textGen);
    }
  }

  protected static Set<String> getUserObjects(String type, final SNodeTextGen textGen) {
    Set<String> names = (Set<String>) textGen.getBuffer().getUserObject(type);
    if (names == null) {
      names = SetSequence.fromSet(new HashSet<String>());
      textGen.getBuffer().putUserObject(type, names);
    }
    return names;
  }

  protected static void addDependency(String name, final SNodeTextGen textGen) {
    Set<String> dependencies = (Set<String>) BaseLanguageTextGen.getUserObjects(TextGenManager.DEPENDENCY, textGen);
    SetSequence.fromSet(dependencies).addElement(name);
  }

  protected static void addDependency(SNode node, final SNodeTextGen textGen) {
    BaseLanguageTextGen.addDependency(NameUtil.nodeFQName(node), textGen);
  }

  protected static String getPackageName(SNode cls, final SNodeTextGen textGen) {
    return cls.getModel().getSModelReference().getLongName();
  }

  protected static void appendClsName(String packageName, String className, boolean isInternal, final SNodeTextGen textGen) {
    if (className == null) {
      textGen.foundError("class name is NULL");
      textGen.append("???");
      return;
    }
    if (packageName.contains("@") || className.contains("@")) {
      textGen.foundError("class name not contain '@'");
    }
    String importedFqName;
    String importedShortName = className.split("\\.")[0];
    if (packageName.length() > 0) {
      importedFqName = packageName + "." + importedShortName;
    } else {
      importedFqName = importedShortName;
    }
    Set<String> importedNames = BaseLanguageTextGen.getUserObjects(TextGenManager.IMPORT, textGen);
    if (SetSequence.fromSet(importedNames).contains(importedFqName)) {
      if (isInternal) {
        textGen.append(className);
      }
      return;
    }
    for (String importedName : importedNames) {
      if (importedShortName.equals(JavaNameUtil.shortName(importedName))) {
        if (isInternal) {
          String fqName;
          if (packageName.length() > 0) {
            fqName = packageName + "." + className;
          } else {
            fqName = className;
          }
          textGen.append(fqName);
        }
        return;
      }
    }
    SetSequence.fromSet(importedNames).addElement(importedFqName);
    BaseLanguageTextGen.addDependency(importedFqName, textGen);
    if (!(packageName.equals("java.lang") || packageName.equals(textGen.getBuffer().getUserObject(TextGenManager.PACKAGE_NAME)))) {
      int currPartId = textGen.getBuffer().selectPart(TextGenBuffer.TOP);
      textGen.appendNewLine();
      textGen.append("import " + importedFqName + ";");
      textGen.getBuffer().selectPart(currPartId);
    }
    if (isInternal) {
      textGen.append(className);
    }
  }
}
