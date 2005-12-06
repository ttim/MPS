package jetbrains.mps.smodel;

import jetbrains.mps.baseLanguage.*;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.util.NameUtil;

import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Jun 28, 2005
 * Time: 5:35:18 PM
 * <p/>
 * <p/>
 * Todo: refactor this utility
 */
public class SNodePresentationUtil {
  public static String matchingText(SNode node, SNode referenceNode, IScope scope) {
    return matchingText(node, referenceNode, null, scope);
  }

  public static String matchingText(SNode node, SNode referenceNode, String referenceRole, IScope scope) {
    String result = null;
    if (node instanceof BaseMethodDeclaration) {
      result = matchingText_BaseMethodDeclaration((BaseMethodDeclaration) node, referenceNode, referenceRole);
    } else if (node instanceof Type) {
      result = matchingText_Type((Type) node);
    } else if (node instanceof VariableDeclaration) {
      result = matchingText_VariableDeclaration((VariableDeclaration) node, referenceNode);
    }

    if (result != null) {
      return result;
    }

    // default
    if (node instanceof LinkDeclaration) {
      return ((LinkDeclaration) node).getRole();
    }

    // todo: alias or name ????
    if (!isNamedElement(node)) {
      String alias = SModelUtil.getConceptProperty(node, "alias", scope);
      if (alias != null) {
        return alias;
      }
    }
    String name = node.getName();
    if (name != null) {
      return name;
    }
    return NameUtil.shortNameFromLongName(node.getClass().getName());
  }

  public static boolean isNamedElement(SNode node) {
    if (node instanceof Classifier ||
            node instanceof VariableDeclaration) {
      return true;
    }
    return false;
  }

  public static String descriptionText(SNode node, SNode referenceContext, IScope scope) {
    String result = null;
    if (node instanceof BaseMethodDeclaration) {
      result = descriptionText_BaseMethodDeclaration((BaseMethodDeclaration) node, referenceContext, scope);
    } else if (node instanceof VariableDeclaration) {
      result = descriptionText_VariableDeclaration((VariableDeclaration) node, referenceContext, scope);
    } else if (node instanceof Classifier) {
      result = descriptionText_Classifier((Classifier) node, scope);
    }
    if (result != null) {
      return result;
    }

    // default
    if (node instanceof LinkDeclaration) {
      SNode containingRoot = node.getContainingRoot();
      return containingRoot.getName() + " (" + containingRoot.getModel().getUID() + ")";
    }
    String description = SModelUtil.getConceptProperty(node, "short_description", scope);
    if (description != null) {
      return description;
    }
    return "";
  }

  private static String matchingText_BaseMethodDeclaration(BaseMethodDeclaration method, SNode referenceNode, String referenceRole) {
    String result = matchingText_BaseMethodDeclaration_raw(method);
    if (referenceNode instanceof BaseMethodCall &&
            (referenceRole == null || BaseMethodCall.BASE_METHOD_DECLARATION.equals(referenceRole))) {
      return result;
    }

    if (method instanceof StaticMethodDeclaration) {
      Classifier parent = SModelUtil.findParent(method, Classifier.class);
      if (!isReferenceContext(parent, referenceNode)) {
        result = parent.getName() + '.' + result;
      }
    }
    return result;
  }

  private static String matchingText_BaseMethodDeclaration_raw(BaseMethodDeclaration method) {
    StringBuffer sb = new StringBuffer();
    Iterator<ParameterDeclaration> parms = method.parameters();
    while (parms.hasNext()) {
      ParameterDeclaration parm = parms.next();
      sb.append(matchingText_Type(parm.getType()));
      if (parms.hasNext()) {
        sb.append(',');
      }
    }
    sb.insert(0, '(');
    sb.append(')');

    if (!(method instanceof ConstructorDeclaration)) {
      sb.append(':');
      Type returnType = method.getReturnType();
      sb.append(matchingText_Type(returnType));
    }

    return method.getName() + sb.toString();
  }

  private static String matchingText_VariableDeclaration(VariableDeclaration variable, SNode referenceContext) {
    String result = variable.getName();
    if (referenceContext instanceof VariableReference) {
      return result;
    }

    if (variable instanceof StaticFieldDeclaration) {
      Classifier parent = SModelUtil.findParent(variable, Classifier.class);
      if (!isReferenceContext(parent, referenceContext)) {
        result = parent.getName() + '.' + result;
      }
    }
    return result;
  }

  private static boolean isReferenceContext(Classifier declaringClassifier, SNode referenceContext) {
    if (referenceContext == null) {
      return false;
    }
    if (declaringClassifier == referenceContext ||
            declaringClassifier == SModelUtil.findParent(referenceContext, Classifier.class)) {
      return true;
    }
    return false;
  }

  private static String matchingText_Type(Type type) {
    if (type == null) {
      return "?no type?";
    }
    if (type instanceof ClassifierType) {
      ClassifierType classifierType = (ClassifierType) type;
      StringBuffer parmsSB = new StringBuffer();
      if (classifierType.getParametersCount() > 0) {
        Iterator<Type> parms = classifierType.parameters();
        while (parms.hasNext()) {
          Type parm = parms.next();
          parmsSB.append(matchingText_Type(parm));
          if (parms.hasNext()) {
            parmsSB.append(',');
          }
        }
        parmsSB.insert(0, '<');
        parmsSB.append('>');
      }
      return NameUtil.shortNameFromLongName(type.getName()) + parmsSB.toString();
    }
    return type.getName();
  }

  private static String descriptionText_BaseMethodDeclaration(BaseMethodDeclaration method, SNode referenceContext, IScope scope) {
    String prefix = getAliasOrConceptName(method, scope) + " in ";
    if (method instanceof MethodDeclaration) {
      // freestanding method: model fqname
      return prefix + method.getModel().getUID().getLongName();
    }

    Classifier parent = SModelUtil.findParent(method, Classifier.class);
    if (parent == null) {
      return prefix + "?declaring classifer?";
    }
    if (isReferenceContext(parent, referenceContext)) {
      return prefix + "this " + parent.getName();
    }
    return prefix + NameUtil.nodeFQName(parent);
  }

  private static String descriptionText_VariableDeclaration(VariableDeclaration variable, SNode referenceContext, IScope scope) {
    if (variable instanceof ParameterDeclaration) {
      return "parameter";
    }
    if (variable instanceof LocalVariableDeclaration) {
      return "local variable";
    }

    String prefix = getAliasOrConceptName(variable, scope) + " in ";
    if (variable instanceof FieldDeclaration ||
            variable instanceof StaticFieldDeclaration) {
      Classifier parent = SModelUtil.findParent(variable, Classifier.class);
      if (parent == null) {
        return prefix + "?declaring classifer?";
      }
      if (isReferenceContext(parent, referenceContext)) {
        return prefix + "this " + parent.getName();
      }

      return prefix + NameUtil.nodeFQName(parent);
    }

    return null;
  }

  private static String descriptionText_Classifier(Classifier classifier, IScope scope) {
    return getAliasOrConceptName(classifier, scope) + " in " + classifier.getModel().getUID();
  }

  private static String getAliasOrConceptName(SNode node, IScope scope) {
    String alias = SModelUtil.getConceptProperty(node, "alias", scope);
    if (alias != null) {
      return alias;
    }
    return NameUtil.shortNameFromLongName(node.getClass().getName());
  }

  public static String getPathToRoot(SNode node) {
    if (node.isRoot()) return node.getName();
    return getPathToRoot(node.getParent()) + " > " + node.getName();
  }
}
