package jetbrains.mps.baseLanguage.money.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.baseLanguage.money.structure.MoneyCreator", "jetbrains.mps.baseLanguage.money.structure.MoneyGetAmountMethodCall", "jetbrains.mps.baseLanguage.money.structure.MoneyGetCurrencyMethodCall", "jetbrains.mps.baseLanguage.money.structure.MoneyIsZeroMethodCall", "jetbrains.mps.baseLanguage.money.structure.MoneyLiteral", "jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall", "jetbrains.mps.baseLanguage.money.structure.MoneyType"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.money.structure.MoneyCreator", "jetbrains.mps.baseLanguage.structure.AbstractCreator", false, new String[]{"jetbrains.mps.baseLanguage.structure.AbstractCreator"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.money.structure.MoneyGetAmountMethodCall", "jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall", false, new String[]{"jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.money.structure.MoneyGetCurrencyMethodCall", "jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall", false, new String[]{"jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.money.structure.MoneyIsZeroMethodCall", "jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall", false, new String[]{"jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.money.structure.MoneyLiteral", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"currency", "amount"}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.money.structure.MoneyMethodCall", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.money.structure.MoneyType", "jetbrains.mps.baseLanguage.structure.Type", false, new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
