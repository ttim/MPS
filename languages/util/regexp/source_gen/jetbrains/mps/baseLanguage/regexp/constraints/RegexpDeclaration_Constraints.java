package jetbrains.mps.baseLanguage.regexp.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import java.util.Map;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class RegexpDeclaration_Constraints extends BaseConstraintsDescriptor {
  public RegexpDeclaration_Constraints() {
    super("jetbrains.mps.baseLanguage.regexp.structure.RegexpDeclaration");
  }

  @Override
  protected Map<String, PropertyConstraintsDescriptor> getNotDefaultProperties() {
    Map<String, PropertyConstraintsDescriptor> properties = new HashMap();
    properties.put("shortDescription", new BasePropertyConstraintsDescriptor("shortDescription", this) {
      @Override
      public boolean hasOwnGetter() {
        return true;
      }

      @Override
      public Object getValue(SNode node, IScope scope) {
        String propertyName = "shortDescription";
        return (isNotEmpty_5k14k_a0a0a1a1a0b0a1a0(SPropertyOperations.getString(node, "description")) ?
          SPropertyOperations.getString(node, "description") :
          "regular expression"
        );
      }
    });
    return properties;
  }

  public static boolean isNotEmpty_5k14k_a0a0a1a1a0b0a1a0(String str) {
    return str != null && str.length() > 0;
  }
}
