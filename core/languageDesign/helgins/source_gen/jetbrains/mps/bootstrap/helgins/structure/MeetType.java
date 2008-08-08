package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MeetType extends BaseConcept {
  public static final String concept = "jetbrains.mps.bootstrap.helgins.structure.MeetType";
  public static String ARGUMENT = "argument";

  public MeetType(SNode node) {
    super(node);
  }

  public int getArgumentsCount() {
    return this.getChildCount(MeetType.ARGUMENT);
  }

  public Iterator<BaseConcept> arguments() {
    return this.children(MeetType.ARGUMENT);
  }

  public List<BaseConcept> getArguments() {
    return this.getChildren(MeetType.ARGUMENT);
  }

  public void addArgument(BaseConcept node) {
    this.addChild(MeetType.ARGUMENT, node);
  }

  public void insertArgument(BaseConcept prev, BaseConcept node) {
    this.insertChild(prev, MeetType.ARGUMENT, node);
  }


  public static MeetType newInstance(SModel sm, boolean init) {
    return (MeetType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.structure.MeetType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MeetType newInstance(SModel sm) {
    return MeetType.newInstance(sm, false);
  }

}
