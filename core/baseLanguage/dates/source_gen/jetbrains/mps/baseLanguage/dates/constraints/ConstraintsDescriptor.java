package jetbrains.mps.baseLanguage.dates.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {
  private List<IModelConstraints> myConstraints = ListSequence.fromList(new ArrayList<IModelConstraints>());

  public ConstraintsDescriptor() {
    ListSequence.fromList(this.myConstraints).addElement(new DateFormat_isPublic_PropertyConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new TimeZoneIDExpression_timezone_id_PropertyConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new TokenConditionalPair_format_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new FormatExpression_dateFormat_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new DateTimePropertyFormatToken_dateTimePropertyFormatConfiguration_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new DateTimePropertyFormatToken_dateTimePropertyFormatType_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new FixedLocaleFormatToken_dateFormat_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new ReferenceFormatToken_dateFormat_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new FormatDateTimeExpression_dateFormat_ReferentConstraint());
  }

  public void unRegisterSelf(ModelConstraintsManager p0) {
    for (IModelConstraints c : this.myConstraints) {
      c.unRegisterSelf(p0);
    }
  }

  public void registerSelf(ModelConstraintsManager p0) {
    for (IModelConstraints c : this.myConstraints) {
      c.registerSelf(p0);
    }
  }
}
