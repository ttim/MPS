package jetbrains.mps.baseLanguage.regexp.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodePropertyGetter;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.BaseNodePropertyGetter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class RegexpDeclaration_Constraints extends ConstraintsDataHolder {
  public RegexpDeclaration_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.regexp.structure.RegexpDeclaration";
  }

  public Map<String, INodePropertyGetter> getNodePropertyGetters() {
    HashMap<String, INodePropertyGetter> result = new HashMap<String, INodePropertyGetter>();
    result.put("shortDescription", new BaseNodePropertyGetter() {
      public Object execPropertyGet(SNode node, String propertyName, IScope scope) {
        return (StringUtils.isNotEmpty(SPropertyOperations.getString(node, "description")) ?
          SPropertyOperations.getString(node, "description") :
          "regular expression"
        );
      }
    });
    return result;
  }
}
