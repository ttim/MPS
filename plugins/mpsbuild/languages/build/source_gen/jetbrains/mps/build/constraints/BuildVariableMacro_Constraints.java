package jetbrains.mps.build.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import java.util.regex.Pattern;
import java.util.Map;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BuildVariableMacro_Constraints extends BaseConstraintsDescriptor {
  private static Pattern REGEXP_xr7ei4_a0a0a1a1a0b0a1a0 = Pattern.compile("[^=\\$/]*", 0);

  public BuildVariableMacro_Constraints() {
    super("jetbrains.mps.build.structure.BuildVariableMacro");
  }

  @Override
  protected Map<String, PropertyConstraintsDescriptor> getNotDefaultProperties() {
    Map<String, PropertyConstraintsDescriptor> properties = new HashMap();
    properties.put("name", new BasePropertyConstraintsDescriptor("name", this) {
      @Override
      public boolean hasOwnValidator() {
        return true;
      }

      @Override
      public boolean validateValue(SNode node, String propertyValue, IScope scope) {
        String propertyName = "name";
        return REGEXP_xr7ei4_a0a0a1a1a0b0a1a0.matcher((SPropertyOperations.getString(propertyValue))).matches();
      }
    });
    return properties;
  }
}
