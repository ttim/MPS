package org.jetbrains.mps.samples.ParallelFor.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.AbstractLoopStatement_BehaviorDescriptor;
import jetbrains.mps.baseLanguage.behavior.IMethodLike_BehaviorDescriptor;
import jetbrains.mps.baseLanguage.behavior.IStatementListContainer_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.behavior.IStatementListContainer_Behavior;
import java.util.List;
import java.util.Set;
import jetbrains.mps.baseLanguage.behavior.IMethodLike_Behavior;
import jetbrains.mps.scope.Scope;

public class ParallelFor_BehaviorDescriptor extends AbstractLoopStatement_BehaviorDescriptor implements IMethodLike_BehaviorDescriptor, IStatementListContainer_BehaviorDescriptor {
  public ParallelFor_BehaviorDescriptor() {
  }

  public SNode virtual_getExpectedRetType_1239354342632(SNode thisNode) {
    return ParallelFor_Behavior.virtual_getExpectedRetType_1239354342632(thisNode);
  }

  public boolean virtual_isExecuteSynchronous_1230212745736(SNode thisNode) {
    return IStatementListContainer_Behavior.virtual_isExecuteSynchronous_1230212745736(thisNode);
  }

  public List<SNode> virtual_getThrowableTypes_6204026822016975623(SNode thisNode) {
    return ParallelFor_Behavior.virtual_getThrowableTypes_6204026822016975623(thisNode);
  }

  public boolean virtual_isClosure_3262277503800835439(SNode thisNode) {
    return IStatementListContainer_Behavior.virtual_isClosure_3262277503800835439(thisNode);
  }

  public boolean virtual_implicitThrows_4989157187872658723(SNode thisNode) {
    return ParallelFor_Behavior.virtual_implicitThrows_4989157187872658723(thisNode);
  }

  public void virtual_collectUncaughtMethodThrowables_5412515780383134223(SNode thisNode, Set<SNode> throwables, boolean ignoreMayBeThrowables) {
    ParallelFor_Behavior.virtual_collectUncaughtMethodThrowables_5412515780383134223(thisNode, throwables, ignoreMayBeThrowables);
  }

  public SNode virtual_getLastStatement_1239354409446(SNode thisNode) {
    return IMethodLike_Behavior.virtual_getLastStatement_1239354409446(thisNode);
  }

  public SNode virtual_getBody_1239354440022(SNode thisNode) {
    return ParallelFor_Behavior.virtual_getBody_1239354440022(thisNode);
  }

  public Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    return ParallelFor_Behavior.virtual_getScope_3734116213129936182(thisNode, kind, child);
  }

  @Override
  public String getConceptFqName() {
    return "org.jetbrains.mps.samples.ParallelFor.structure.ParallelFor";
  }
}
