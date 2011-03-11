package jetbrains.mps.baseLanguage.collections.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntentionsDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.SModelReference;

public class IntentionsDescriptor extends BaseIntentionsDescriptor {
  public IntentionsDescriptor() {
    super(new ModuleReference("jetbrains.mps.baseLanguage.collections", "83888646-71ce-4f1c-9c53-c54016f6ad4f"), SModelReference.fromString("r:00000000-0000-4000-0000-011c8959032c(jetbrains.mps.baseLanguage.collections.intentions)"));
  }

  public void init() {
    add(new Add_Comparator_Intention(), "2261417478149151571");
    add(new ConvertForEachStatementToForeachStatement_Intention(), "1193396656620");
    add(new CreateInitializer_Intention(), "1206658014161");
    add(new IterateOverSequence_Intention(), "309173295241374789");
    add(new add_copy_from_Intention(), "1237739246401");
    add(new add_init_values_Intention(), "1237739140549");
    add(new add_sequence_initializer_Intention(), "2826767102480497650");
  }
}
