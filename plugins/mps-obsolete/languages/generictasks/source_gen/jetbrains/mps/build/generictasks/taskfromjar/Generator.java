package jetbrains.mps.build.generictasks.taskfromjar;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.util.PathManager;
import jetbrains.mps.smodel.SModel;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.io.IOException;
import java.util.Map;
import java.util.LinkedHashMap;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.build.generictasks.behavior.AttributeDeclaration_Behavior;
import jetbrains.mps.buildlanguage.behavior.PropertyValueExpression_Behavior;
import java.io.File;
import org.apache.tools.ant.types.Reference;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Generator {
  private static final Logger LOG = Logger.getLogger(Generator.class);
  /*package*/ static final String ANT_PATH = PathManager.getHomePath() + "/lib/ant";
  private static final BuildLanguageGenerator GENERATOR = BuildLanguageGenerator.getInstance();

  public Generator() {
  }

  private String getPath(Generator.Modes m) {
    switch (m) {
      case CORE:
        return Generator.ANT_PATH + Scanner.LIB_ANT_JAR;
      case JUNIT:
        return Generator.ANT_PATH + Scanner.LIB_ANT_JUNIT_JAR;
      default:
    }
    throw new IllegalArgumentException("Unknown mode " + m);
  }

  public void generateTasks(SModel model, Generator.Modes m, SModel[] allModels) {
    try {
      Scanner scanner = new Scanner(Generator.ANT_PATH, getPath(m));
      List<ClassInfo> toImport = scanner.scan();
      Importer.IClassInfoProvider provider = scanner.createClassInfoProvider();
      NamesMap namesMap = scanner.getNamesMap();
      Importer<SNode> importer = new Importer<SNode>(toImport, this.getExistingDeclarations(allModels), provider);
      Generator.Builder builder = new Generator.Builder(model, namesMap);
      for (ClassInfo cl : scanner.getRoots()) {
        importer.createDeclaration(builder, cl);
      }
      importer.importAll(builder);
    } catch (IOException e) {
      Generator.LOG.error(e);
    } catch (ClassNotFoundException e) {
      Generator.LOG.error(e);
    }
  }

  private Map<String, SNode> getExistingDeclarations(SModel[] models) {
    Map<String, SNode> declarations = new LinkedHashMap<String, SNode>();
    for (SModel model : models) {
      List<SNode> roots = SModelOperations.getRoots(model, "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration");
      for (SNode decl : roots) {
        this.cleanDeclaration(decl);
        declarations.put(SPropertyOperations.getString(decl, "classname"), decl);
      }
    }
    return declarations;
  }

  private void cleanDeclaration(final SNode decl) {
    Set<SNode> toRemoveNestedReference = SetSequence.fromSet(new HashSet());
    for (SNode nref : SLinkOperations.getTargets(decl, "nested", true)) {
      for (SNode ref : SLinkOperations.getTargets(decl, "nested", true)) {
        if (eq_ixz87t_a0a0a0b0d(ref, nref)) {
          continue;
        }
        if (eq_ixz87t_a0b0a0b0d(SPropertyOperations.getString(SLinkOperations.getTarget(ref, "declaration", false), "classname"), SPropertyOperations.getString(SLinkOperations.getTarget(nref, "declaration", false), "classname"))) {
          SetSequence.fromSet(toRemoveNestedReference).addElement(ref);
        }
      }
    }
    SetSequence.fromSet(toRemoveNestedReference).visitAll(new IVisitor<SNode>() {
      public void visit(SNode it) {
        ListSequence.fromList(SNodeOperations.getChildren(decl)).removeElement(it);
        ListSequence.fromList(SLinkOperations.getTargets(it, "role", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode roleRef) {
            return SPropertyOperations.getBoolean(SNodeOperations.cast(SLinkOperations.getTarget(roleRef, "declaration", false), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration"), "fake");
          }
        }).visitAll(new IVisitor<SNode>() {
          public void visit(SNode child) {
            ListSequence.fromList(SNodeOperations.getChildren(decl)).removeElement(SLinkOperations.getTarget(child, "declaration", false));
          }
        });
      }
    });
    ListSequence.fromList(SLinkOperations.getTargets(decl, "fakeDeclaration", true)).visitAll(new IVisitor<SNode>() {
      public void visit(SNode it) {
        SPropertyOperations.set(it, "fake", "" + true);
      }
    });

    Set<SNode> toRemoveFakeDeclaration = SetSequence.fromSet(new HashSet());
    SetSequence.fromSet(toRemoveFakeDeclaration).addSequence(ListSequence.fromList(SLinkOperations.getTargets(decl, "fakeDeclaration", true)));
    for (SNode nref : SLinkOperations.getTargets(decl, "nested", true)) {
      List<SNode> notRemove = ListSequence.fromList(SLinkOperations.getTargets(nref, "role", true)).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SNodeOperations.cast(SLinkOperations.getTarget(it, "declaration", false), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration");
        }
      }).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SPropertyOperations.getBoolean(it, "fake");
        }
      }).toListSequence();
      SetSequence.fromSet(toRemoveFakeDeclaration).removeSequence(ListSequence.fromList(notRemove));
    }
    SetSequence.fromSet(toRemoveFakeDeclaration).visitAll(new IVisitor<SNode>() {
      public void visit(SNode it) {
        ListSequence.fromList(SNodeOperations.getChildren(decl)).removeElement(it);
      }
    });
    for (final SNode nref : SLinkOperations.getTargets(decl, "nested", true)) {
      SNode node = ListSequence.fromList(SLinkOperations.getTargets(nref, "role", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          SNode biDecl = SNodeOperations.cast(SLinkOperations.getTarget(it, "declaration", false), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration");
          return SPropertyOperations.getBoolean(biDecl, "fake") && eq_ixz87t_a0a1a0a0a0a0a0a9a3(SPropertyOperations.getString(biDecl, "name"), SPropertyOperations.getString(SLinkOperations.getTarget(nref, "declaration", false), "name"));
        }
      }).first();
      ListSequence.fromList(SNodeOperations.getChildren(nref)).removeElement(node);
      ListSequence.fromList(SNodeOperations.getChildren(decl)).removeElement(SLinkOperations.getTarget(node, "declaration", false));
    }
  }

  private static boolean eq_ixz87t_a0a0a0b0d(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_ixz87t_a0b0a0b0d(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_ixz87t_a0a1a0a0a0a0a0a9a3(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  public static   enum Modes {
    CORE(),
    JUNIT();

    Modes() {
    }
  }

  public static class Builder implements Importer.IBuilder<SNode> {
    protected final SModel myModel;
    private final NamesMap myNamesMap;

    public Builder(SModel model, NamesMap namesMap) {
      this.myModel = model;
      this.myNamesMap = namesMap;
    }

    public SNode createDeclaration(ClassInfo ci) {
      String classname = ci.getDeclarationClass().getName();
      String name = this.myNamesMap.getNameForClass(ci.getDeclarationClass());
      if (ci.isInterface()) {
        SNode decl = Generator.GENERATOR.createInterfaceDeclaration(name, classname, ci.isDeprecated());
        myModel.addRoot(decl);
        return decl;
      }
      SNode decl = Generator.GENERATOR.createDeclaration(name, classname, ci.isAbstract(), ci.canHaveInternalText(), ci.isDeprecated());
      myModel.addRoot(decl);
      return decl;
    }

    public void addParent(SNode declaration, SNode parent) {
      SLinkOperations.setTarget(declaration, "parentRef", Generator.GENERATOR.createDeclarationReference(parent), true);
    }

    public void addInterface(SNode declaration, SNode interfaceDeclaration) {
      for (SNode in : SLinkOperations.getTargets(declaration, "interfaces", true)) {
        if (eq_ixz87t_a0a0a0c1(SPropertyOperations.getString(SLinkOperations.getTarget(in, "declaration", false), "name"), SPropertyOperations.getString(interfaceDeclaration, "name"))) {
          return;
        }
      }
      SNode ref = Generator.GENERATOR.createDeclarationReference(interfaceDeclaration);
      ListSequence.fromList(SLinkOperations.getTargets(declaration, "interfaces", true)).addElement(ref);
    }

    public void addAttribute(SNode declaration, final ClassInfo.MyAttribute attribute) {
      SNode node = ListSequence.fromList(SLinkOperations.getTargets(declaration, "attributesDecl", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return eq_ixz87t_a0a0a0a0a0a0a0d1(SPropertyOperations.getString(it, "name"), attribute.getName());
        }
      }).first();
      if ((node == null)) {
        createAttribute(declaration, attribute);
      } else if (ImportOptions.getInstance().isNeedUpdateAttributes()) {
        this.updateAttribute(node, attribute);
      }
    }

    private void updateAttribute(SNode ad, ClassInfo.MyAttribute att) {
      SLinkOperations.setTarget(ad, "attributeType", Generator.Builder.getType(att.getType()), true);
      if (att.getEnumValues() != null) {
        SNode anEnum = SLinkOperations.getTarget(ad, "enum", true);
        if ((anEnum != null) && (SNodeOperations.isInstanceOf(anEnum, "jetbrains.mps.buildlanguage.structure.StringEnum"))) {
          this.updateEnum(SNodeOperations.cast(anEnum, "jetbrains.mps.buildlanguage.structure.StringEnum"), att.getEnumValues());
        } else {
          this.addEnum(ad, att.getEnumValues());
        }
      }
      if (!(AttributeDeclaration_Behavior.call_isDeprecated_353793545802643819(ad)) && att.isDeprecated()) {
        SPropertyOperations.set(ad, "deprecated", "" + att.isDeprecated());
      }
    }

    private void createAttribute(SNode decl, ClassInfo.MyAttribute att) {
      SNode attrDecl = Generator.GENERATOR.createAttributeDeclaration(att.getName(), Generator.Builder.getType(att.getType()));
      SPropertyOperations.set(attrDecl, "deprecated", "" + att.isDeprecated());
      this.addEnum(attrDecl, att.getEnumValues());
      ListSequence.fromList(SLinkOperations.getTargets(decl, "attributesDecl", true)).addElement(attrDecl);
    }

    private void addEnum(SNode attrDecl, String[] enumValues) {
      if (enumValues == null) {
        return;
      }
      SNode senum = new Generator.Builder.QuotationClass_ixz87t_a0a1a6b().createNode();
      this.updateEnum(senum, enumValues);
      SLinkOperations.setTarget(attrDecl, "enum", senum, true);
    }

    private void updateEnum(SNode sEnum, String[] enumValues) {
      Set<String> set = SetSequence.fromSetWithValues(new HashSet(), ListSequence.fromList(SLinkOperations.getTargets(sEnum, "constants", true)).select(new ISelector<SNode, String>() {
        public String select(SNode it) {
          return PropertyValueExpression_Behavior.call_toString_1213877472569(it);
        }
      }));
      for (String str : enumValues) {
        if (SetSequence.fromSet(set).contains(str)) {
          continue;
        }
        ListSequence.fromList(SLinkOperations.getTargets(sEnum, "constants", true)).addElement(new Generator.Builder.QuotationClass_ixz87t_a0a0b0b0h1().createNode(str));
      }
    }

    public void addNested(SNode decl, final SNode nestedDecl, ClassInfo.Nested nested) {
      SNode node = ListSequence.fromList(SLinkOperations.getTargets(decl, "nested", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return eq_ixz87t_a0a0a0a0a0a0a0i1(SLinkOperations.getTarget(it, "declaration", false), nestedDecl);
        }
      }).first();
      if ((node != null)) {
        for (String name : nested.getNames()) {
          this.addNestedName(decl, node, name);
        }
        return;
      }

      SNode nref = new Generator.Builder.QuotationClass_ixz87t_a0a3a8b().createNode(nestedDecl);
      if (eq_ixz87t_a0e0i1(SLinkOperations.getTarget(nref, "declaration", false), nestedDecl)) {
        for (String name : nested.getNames()) {
          this.addNestedName(decl, nref, name);
        }
      }
      ListSequence.fromList(SLinkOperations.getTargets(decl, "nested", true)).addElement(nref);
    }

    private void addNestedName(SNode declaration, SNode nref, String name) {
      for (SNode ref : SLinkOperations.getTargets(nref, "role", true)) {
        if (eq_ixz87t_a0a0a0j1(SPropertyOperations.getString(SLinkOperations.getTarget(ref, "declaration", false), "name"), name)) {
          return;
        }
      }

      if (eq_ixz87t_a0c0j1(SPropertyOperations.getString(SLinkOperations.getTarget(nref, "declaration", false), "name"), name)) {
        ListSequence.fromList(SLinkOperations.getTargets(nref, "role", true)).addElement(Generator.GENERATOR.createDeclarationReference(SNodeOperations.cast(SLinkOperations.getTarget(nref, "declaration", false), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration")));
        return;
      }

      SNode parentDeclaration = SNodeOperations.cast(SLinkOperations.getTarget(nref, "declaration", false), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration");
      SNode parentRef = Generator.GENERATOR.createDeclarationReference(parentDeclaration);
      SNode fake;
      if (SNodeOperations.isInstanceOf(parentDeclaration, "jetbrains.mps.build.generictasks.structure.TaskInterfaceDeclaration")) {
        fake = Generator.GENERATOR.createInterfaceDeclaration(name, SPropertyOperations.getString(parentDeclaration, "classname"), SPropertyOperations.getBoolean(parentDeclaration, "depracated"));
        ListSequence.fromList(SLinkOperations.getTargets(fake, "interfaces", true)).addElement(parentRef);
      } else {
        fake = Generator.GENERATOR.createDeclaration(name, SPropertyOperations.getString(parentDeclaration, "classname"), SPropertyOperations.getBoolean(parentDeclaration, "abstract"), SPropertyOperations.getBoolean(parentDeclaration, "canHaveInternalText"), SPropertyOperations.getBoolean(parentDeclaration, "depracated"));
        SLinkOperations.setTarget(fake, "parentRef", parentRef, true);
      }
      SPropertyOperations.set(fake, "fake", "" + true);
      ListSequence.fromList(SLinkOperations.getTargets(nref, "role", true)).addElement(Generator.GENERATOR.createDeclarationReference(fake));
      ListSequence.fromList(SLinkOperations.getTargets(declaration, "fakeDeclaration", true)).addElement(fake);
    }

    public void updateDeclaration(SNode decl, ClassInfo ci) {
      if (ImportOptions.getInstance().isNeedUpdateDeclarations()) {
        String name = this.myNamesMap.getNameForClass(ci.getDeclarationClass());
        if ((isEmpty_ixz87t_a0a0b0a0k1(SPropertyOperations.getString(decl, "name"))) || neq_ixz87t_a0a1a0a01b(SPropertyOperations.getString(decl, "name"), name)) {
          SPropertyOperations.set(decl, "name", name);
          System.out.format("Declaration %s name has been set to %s.\n", ci.getDeclarationClass().getName(), name);
        }
        if (isEmpty_ixz87t_a0c0a0k1(SPropertyOperations.getString(decl, "classname"))) {
          SPropertyOperations.set(decl, "classname", ci.getDeclarationClass().getName());
        }
        if (SPropertyOperations.getBoolean(decl, "abstract") != ci.isAbstract()) {
          System.out.format("Declaration %s abstract proprety has been set to %b.\n", ci.getDeclarationClass().getName(), ci.isAbstract());
          SPropertyOperations.set(decl, "abstract", "" + ci.isAbstract());
        }
        if (SPropertyOperations.getBoolean(decl, "canHaveInternalText") != ci.canHaveInternalText()) {
          System.out.format("Declaration %s can have internal name proprety has been set to %b.\n", ci.getDeclarationClass().getName(), ci.canHaveInternalText());
          SPropertyOperations.set(decl, "canHaveInternalText", "" + ci.canHaveInternalText());
        }
        if (!(SPropertyOperations.getBoolean(decl, "depracated")) && ci.isDeprecated()) {
          SPropertyOperations.set(decl, "depracated", "" + ci.isDeprecated());
          System.out.format("Declaration %s has been set deprecated.\n", ci.getDeclarationClass().getName());
        }
      }
    }

    private static SNode getType(Class<?> clazz) {
      if (clazz.equals(int.class)) {
        return new Generator.Builder.QuotationClass_ixz87t_a0a0a0a1().createNode();
      } else
      if (clazz.equals(boolean.class)) {
        return new Generator.Builder.QuotationClass_ixz87t_a0a0a0a0b().createNode();
      } else
      if (clazz.equals(File.class)) {
        return new Generator.Builder.QuotationClass_ixz87t_a0a0a0a0a1().createNode();
      } else
      if (clazz.getName().equals(Reference.class.getName())) {
        return new Generator.Builder.QuotationClass_ixz87t_a0a0a0a0a0b().createNode();
      } else {
        return new Generator.Builder.QuotationClass_ixz87t_a0a0a0a0a0a1().createNode();
      }
    }

    private static boolean eq_ixz87t_a0a0a0c1(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }

    private static boolean eq_ixz87t_a0a0a0a0a0a0a0d1(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }

    private static boolean eq_ixz87t_a0a0a0a0a0a0a0i1(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }

    private static boolean eq_ixz87t_a0e0i1(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }

    private static boolean eq_ixz87t_a0a0a0j1(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }

    private static boolean eq_ixz87t_a0c0j1(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }

    public static boolean isEmpty_ixz87t_a0a0b0a0k1(String str) {
      return str == null || str.length() == 0;
    }

    private static boolean neq_ixz87t_a0a1a0a01b(Object a, Object b) {
      return !((a != null ?
        a.equals(b) :
        a == b
      ));
    }

    public static boolean isEmpty_ixz87t_a0c0a0k1(String str) {
      return str == null || str.length() == 0;
    }

    public static class QuotationClass_ixz87t_a0a1a6b {
      public QuotationClass_ixz87t_a0a1a6b() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.StringEnum", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_ixz87t_a0a0b0b0h1 {
      public QuotationClass_ixz87t_a0a0b0b0h1() {
      }

      public SNode createNode(Object parameter_3) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.StringLiteral", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          quotedNode1_2.setProperty("value", (String) parameter_3);
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_ixz87t_a0a3a8b {
      public QuotationClass_ixz87t_a0a3a8b() {
      }

      public SNode createNode(Object parameter_3) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.generictasks.structure.NestedDeclaration", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          quotedNode1_2.setReferent("declaration", (SNode) parameter_3);
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_ixz87t_a0a0a0a0a0a1 {
      public QuotationClass_ixz87t_a0a0a0a0a0a1() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.StringType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_ixz87t_a0a0a0a0a0b {
      public QuotationClass_ixz87t_a0a0a0a0a0b() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.CallReferenceType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_ixz87t_a0a0a0a0a1 {
      public QuotationClass_ixz87t_a0a0a0a0a1() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.FileType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_ixz87t_a0a0a0a0b {
      public QuotationClass_ixz87t_a0a0a0a0b() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.BooleanType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_ixz87t_a0a0a0a1 {
      public QuotationClass_ixz87t_a0a0a0a1() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.IntegerType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }
  }
}
