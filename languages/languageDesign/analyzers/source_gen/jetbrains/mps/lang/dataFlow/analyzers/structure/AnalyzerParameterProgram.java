package jetbrains.mps.lang.dataFlow.analyzers.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AnalyzerParameterProgram extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.dataFlow.analyzers.structure.AnalyzerParameterProgram";

  public AnalyzerParameterProgram(SNode node) {
    super(node);
  }

  public static AnalyzerParameterProgram newInstance(SModel sm, boolean init) {
    return (AnalyzerParameterProgram) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.dataFlow.analyzers.structure.AnalyzerParameterProgram", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AnalyzerParameterProgram newInstance(SModel sm) {
    return AnalyzerParameterProgram.newInstance(sm, false);
  }
}
