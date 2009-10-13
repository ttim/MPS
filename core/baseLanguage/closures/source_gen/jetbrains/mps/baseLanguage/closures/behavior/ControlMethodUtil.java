package jetbrains.mps.baseLanguage.closures.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.ArrayList;
import jetbrains.mps.lang.pattern.util.MatchingUtil;

public class ControlMethodUtil {
  public static boolean isControlMethod(SNode smd) {
    return ControlMethodUtil.analyze(smd) != null;
  }

  public static ControlMethodUtil.Info analyze(SNode smd) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(smd, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType")) {
      List<SNode> params = SLinkOperations.getTargets(smd, "parameter", true);
      //  0..k-1 : control function parameters, k..l-1 : control closure parameter declarations (closures), l..m-1 : control closures
      ControlMethodUtil.Info inf = new ControlMethodUtil.Info();
      int functionParams = 0;
      int initClosures = 0;
      int controlClosures = 0;
      List<SNode> closureParamTypes = null;
      for (int idx = ListSequence.fromList(params).count() - 1; idx >= 0; idx-- ) {
        SNode p = ListSequence.fromList(params).getElement(idx);
        SNode ptype = SLinkOperations.getTarget(p, "type", true);
        if (SNodeOperations.isInstanceOf(ptype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")) {
          if (functionParams > 0) {
            return null;
          }
          if (SNodeOperations.getConceptDeclaration(ptype) == SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedFunctionType") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(ptype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"), "resultType", true), "jetbrains.mps.baseLanguage.structure.VoidType")) {
            if (initClosures > 0) {
              return null;
            }
            controlClosures++ ;
            inf.addControlClosureType(SNodeOperations.copyNode(ptype));
            if (closureParamTypes == null) {
              closureParamTypes = ListSequence.fromList(new ArrayList<SNode>());
              for (SNode pt : SLinkOperations.getTargets(SNodeOperations.cast(ptype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"), "parameterType", true)) {
                ListSequence.fromList(closureParamTypes).addElement(SNodeOperations.copyNode(pt));
              }
            } else if (closureParamTypes != null && ListSequence.fromList(closureParamTypes).count() == SLinkOperations.getCount(SNodeOperations.cast(ptype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"), "parameterType")) {
              int i = 0;
              for (SNode pt : SLinkOperations.getTargets(SNodeOperations.cast(ptype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"), "parameterType", true)) {
                if (!(MatchingUtil.matchNodes(pt, ListSequence.fromList(closureParamTypes).getElement(i++ )))) {
                  return null;
                }
              }
            } else {
              return null;
            }
          } else if (SLinkOperations.getCount(SNodeOperations.cast(ptype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"), "parameterType") == 0 && !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(ptype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"), "resultType", true), "jetbrains.mps.baseLanguage.structure.VoidType"))) {
            if (controlClosures == 0 || initClosures >= ListSequence.fromList(closureParamTypes).count()) {
              return null;
            }
            initClosures++ ;
            inf.addInitClosureType(SNodeOperations.copyNode(ptype));
            SNode rt = SLinkOperations.getTarget(SNodeOperations.cast(ptype, "jetbrains.mps.baseLanguage.closures.structure.UnrestrictedFunctionType"), "resultType", true);
            if (!(MatchingUtil.matchNodes(rt, ListSequence.fromList(closureParamTypes).getElement(ListSequence.fromList(closureParamTypes).count() - initClosures)))) {
              return null;
            }
          } else {
            return null;
          }
        } else if (controlClosures > 0) {
          functionParams++ ;
          inf.addFunctionParameterType(SNodeOperations.copyNode(ptype));
        } else {
          return null;
        }
      }
      return (inf.isInitialized() ?
        inf :
        null
      );
    }
    return null;
  }

  public static class Info {
    private List<SNode> controlClosures;
    private List<SNode> initClosures;
    private List<SNode> functionParams;
    private boolean initialized = false;

    public Info() {
    }

    public boolean isInitialized() {
      return this.initialized;
    }

    public void addControlClosureType(SNode cct) {
      this.init();
      ListSequence.fromList(this.controlClosures).addElement(cct);
    }

    public void addInitClosureType(SNode ict) {
      this.init();
      ListSequence.fromList(this.initClosures).addElement(ict);
    }

    public void addFunctionParameterType(SNode fpt) {
      this.init();
      ListSequence.fromList(this.functionParams).addElement(fpt);
    }

    public List<SNode> getControlClosureTypes() {
      return this.ensureNotNull(this.controlClosures);
    }

    public List<SNode> getInitClosureTypes() {
      return this.ensureNotNull(this.initClosures);
    }

    public List<SNode> getFunctionParamTypes() {
      return this.ensureNotNull(this.functionParams);
    }

    public List<SNode> ensureNotNull(List<SNode> list) {
      if (list == null) {
        return ListSequence.fromList(new ArrayList<SNode>());
      }
      return list;
    }

    private void init() {
      if (!(this.initialized)) {
        this.controlClosures = ListSequence.fromList(new ArrayList<SNode>());
        this.initClosures = ListSequence.fromList(new ArrayList<SNode>());
        this.functionParams = ListSequence.fromList(new ArrayList<SNode>());
        this.initialized = true;
      }
    }
  }
}
