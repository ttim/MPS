package jetbrains.mps.baseLanguage.scopes;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.scopes.runtime.HidingByNameScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.scopes.runtime.NamedElementsScope;

public class Scopes {
  private Scopes() {
  }

  public static Scope forVariables(SNode kind, Scope variablesScope, @Nullable Scope parentScope) {
    if (parentScope == null) {
      return variablesScope;
    }
    // hiding for variables only name based. so I can use SimpleScope and HidingByNameScope 
    return new HidingByNameScope(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BaseVariableDeclaration"), kind, variablesScope, parentScope);
  }

  public static Scope forVariables(SNode kind, Iterable<SNode> variables, Scope parentScope) {
    return forVariables(kind, new NamedElementsScope(variables), parentScope);
  }

  public static Scope forVariables(SNode kind, SNode variable, Scope parentScope) {
    return forVariables(kind, new NamedElementsScope(variable), parentScope);
  }

  public static Scope forMethods(SNode kind, Scope methodsScope, @Nullable Scope parentScope) {
    if (parentScope == null) {
      return methodsScope;
    }
    // should be used for methods in getScope() 
    return new HidingByNameScope(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), kind, methodsScope, parentScope);
  }

  public static Scope defaultWithNameHiding(SNode kind, Scope scope, @Nullable Scope parentScope) {
    if (parentScope == null) {
      return scope;
    }
    // hide anything by name 
    return new HidingByNameScope(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.INamedConcept"), kind, scope, parentScope);
  }

  public static Scope forLoopLabels(Iterable<SNode> labels, Scope parentScope) {
    // Hiding only other LoopLabels 
    return new HidingByNameScope(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.LoopLabel"), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.LoopLabel"), new NamedElementsScope(labels), parentScope);
  }
}
