package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import javax.swing.Icon;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.scope.EmptyScope;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.baseLanguage.scopes.ClassifierScopeUtils;
import jetbrains.mps.lang.scopes.runtime.NamedElementsScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.baseLanguage.scopes.Scopes;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.scopes.runtime.LazyScope;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;

public class Property_Behavior {
  private static Class[] PARAMETERS_8884554759541381539 = {SNode.class};

  public static void init(SNode thisNode) {
    SLinkOperations.setNewChild(thisNode, "visibility", "jetbrains.mps.baseLanguage.structure.PublicVisibility");
  }

  public static boolean call_isDefaultImplementation_1213877383134(SNode thisNode) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "propertyImplementation", true), "jetbrains.mps.baseLanguage.structure.DefaultPropertyImplementation");
  }

  public static boolean call_isCustomImplementation_1213877383144(SNode thisNode) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "propertyImplementation", true), "jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation");
  }

  public static SNode call_getCustomPropertyImplementation_1213877383154(SNode thisNode) {
    return SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "propertyImplementation", true), "jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation");
  }

  public static String call_getPropertyNameWithId_1213877383162(SNode thisNode) {
    return NameUtil.capitalize(SPropertyOperations.getString(thisNode, "propertyName"));
  }

  public static String call_getGetterMethodName_1213877383170(SNode thisNode) {
    return "get" + Property_Behavior.call_getPropertyNameWithId_1213877383162(thisNode);
  }

  public static String call_getSetterMethodName_1213877383179(SNode thisNode) {
    return "set" + Property_Behavior.call_getPropertyNameWithId_1213877383162(thisNode);
  }

  public static SNode call_getSetterVisibility_1213877383188(SNode thisNode) {
    SNode visibility = SLinkOperations.getTarget(thisNode, "visibility", true);
    if (Property_Behavior.call_isDefaultImplementation_1213877383134(thisNode)) {
      SNode setterVisibility = SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "propertyImplementation", true), "jetbrains.mps.baseLanguage.structure.DefaultPropertyImplementation"), "defaultSetAccessor", true), "visibility", true);
      if ((setterVisibility != null)) {
        visibility = setterVisibility;
      }
    }
    return visibility;
  }

  public static boolean call_hasSetter_1213877383224(SNode thisNode) {
    return PropertyImplementation_Behavior.call_hasSetter_1213877430658(SLinkOperations.getTarget(thisNode, "propertyImplementation", true));
  }

  public static Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return IVisible_Behavior.call_getVisibilityIcon_5017341185733869581(thisNode);
  }

  public static Scope virtual_getScopeForInterface_1251851371723365208(SNode thisNode, SNode interfaceNode, SNode[] extendsInterfaces) {
    return new EmptyScope();
  }

  public static Scope virtual_getScopeForClass_1251851371723365193(SNode thisNode, final SNode classNode, @Nullable final SNode extendsClass, SNode[] implementsInterfaces) {
    if (ClassifierScopeUtils.isHierarchyCyclic(classNode)) {
      return new EmptyScope();
    }

    Scope properties = new NamedElementsScope(ListSequence.fromList(SNodeOperations.getChildren(classNode)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.Property");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.Property");
      }
    }));
    if ((extendsClass != null)) {
      // hiding based on name 
      return Scopes.defaultWithNameHiding(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Property"), properties, new LazyScope(new _FunctionTypes._return_P0_E0<Scope>() {
        public Scope invoke() {
          return ((Scope) BehaviorManager.getInstance().invoke(Object.class, extendsClass, "virtual_getVisibleMembers_8083692786967356611", new Class[]{SNode.class, SNode.class, SNode.class}, classNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Property")));
        }
      }));
    } else {
      return properties;
    }
  }

  public static Icon call_getAdditionalIcon_8884554759541381539(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Icon) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Property"), "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541381539, new Object[]{});
  }

  public static Icon callSuper_getAdditionalIcon_8884554759541381539(SNode thisNode, String callerConceptFqName) {
    return (Icon) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Property"), callerConceptFqName, "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541381539, new Object[]{});
  }
}
