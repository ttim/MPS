package jetbrains.mps.analyzers.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InstructionReference extends BaseConcept {
  public static final String concept = "jetbrains.mps.analyzers.structure.InstructionReference";
  public static final String INSTRUCTION = "instruction";
  public static final String ARGUMENT = "argument";

  public InstructionReference(SNode node) {
    super(node);
  }

  public Instruction getInstruction() {
    return (Instruction) this.getReferent(Instruction.class, InstructionReference.INSTRUCTION);
  }

  public void setInstruction(Instruction node) {
    super.setReferent(InstructionReference.INSTRUCTION, node);
  }

  public int getArgumentsCount() {
    return this.getChildCount(InstructionReference.ARGUMENT);
  }

  public Iterator<Expression> arguments() {
    return this.children(Expression.class, InstructionReference.ARGUMENT);
  }

  public List<Expression> getArguments() {
    return this.getChildren(Expression.class, InstructionReference.ARGUMENT);
  }

  public void addArgument(Expression node) {
    this.addChild(InstructionReference.ARGUMENT, node);
  }

  public void insertArgument(Expression prev, Expression node) {
    this.insertChild(prev, InstructionReference.ARGUMENT, node);
  }

  public static InstructionReference newInstance(SModel sm, boolean init) {
    return (InstructionReference) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.analyzers.structure.InstructionReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InstructionReference newInstance(SModel sm) {
    return InstructionReference.newInstance(sm, false);
  }
}
