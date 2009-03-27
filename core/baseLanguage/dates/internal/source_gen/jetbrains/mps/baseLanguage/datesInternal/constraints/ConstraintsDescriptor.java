package jetbrains.mps.baseLanguage.datesInternal.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.datesInternal.constraints.DurationType_name_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.SchedulePeriod_alias_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.DateTimeZonePropertyFormatConfiguration_name_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.PredefinedDateFormat_isPublic_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.PredefinedDateFormat_name_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.Month_alias_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.DateTimePropertyConfiguration_shortDescription_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.DateTimeIntPropertyFormatConfiguration_name_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.DateTimePropertyFormatType_name_PropertyConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.DateTimeProperty_jodaPeriodType_ReferentConstraint;
import jetbrains.mps.baseLanguage.datesInternal.constraints.DateTimeProperty_jodaDateTimeFieldType_ReferentConstraint;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {

  private List<IModelConstraints> myConstraints = new ArrayList<IModelConstraints>();

  public ConstraintsDescriptor() {
    this.myConstraints.add(new DurationType_name_PropertyConstraint());
    this.myConstraints.add(new SchedulePeriod_alias_PropertyConstraint());
    this.myConstraints.add(new DateTimeZonePropertyFormatConfiguration_name_PropertyConstraint());
    this.myConstraints.add(new PredefinedDateFormat_isPublic_PropertyConstraint());
    this.myConstraints.add(new PredefinedDateFormat_name_PropertyConstraint());
    this.myConstraints.add(new Month_alias_PropertyConstraint());
    this.myConstraints.add(new DateTimePropertyConfiguration_shortDescription_PropertyConstraint());
    this.myConstraints.add(new DateTimeIntPropertyFormatConfiguration_name_PropertyConstraint());
    this.myConstraints.add(new DateTimePropertyFormatType_name_PropertyConstraint());
    this.myConstraints.add(new DateTimeProperty_jodaPeriodType_ReferentConstraint());
    this.myConstraints.add(new DateTimeProperty_jodaDateTimeFieldType_ReferentConstraint());
  }

  public void unRegisterSelf(ModelConstraintsManager p0) {
    for(IModelConstraints c : this.myConstraints) {
      c.unRegisterSelf(p0);
    }
  }

  public void registerSelf(ModelConstraintsManager p0) {
    for(IModelConstraints c : this.myConstraints) {
      c.registerSelf(p0);
    }
  }

}
