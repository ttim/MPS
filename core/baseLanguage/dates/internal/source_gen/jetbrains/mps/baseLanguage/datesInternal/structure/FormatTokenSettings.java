package jetbrains.mps.baseLanguage.datesInternal.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.datesInternal.structure.PredefinedDateFormat;
import java.util.List;
import jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyCardinality;
import jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyConfiguration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FormatTokenSettings extends jetbrains.mps.lang.core.structure.BaseConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.datesInternal.structure.FormatTokenSettings";
  public static final String PREDEFINED_DATE_FORMAT = "predefinedDateFormat";
  public static final String DATE_TIME_PROPERTY_CARDINALITY = "dateTimePropertyCardinality";
  public static final String DATE_TIME_PROPERTY_FORMAT_CONFIGURATION = "dateTimePropertyFormatConfiguration";

  public FormatTokenSettings(SNode node) {
    super(node);
  }

  public int getPredefinedDateFormatsCount() {
    return this.getChildCount(FormatTokenSettings.PREDEFINED_DATE_FORMAT);
  }

  public Iterator<jetbrains.mps.baseLanguage.datesInternal.structure.PredefinedDateFormat> predefinedDateFormats() {
    return this.children(PredefinedDateFormat.class, FormatTokenSettings.PREDEFINED_DATE_FORMAT);
  }

  public List<jetbrains.mps.baseLanguage.datesInternal.structure.PredefinedDateFormat> getPredefinedDateFormats() {
    return this.getChildren(PredefinedDateFormat.class, FormatTokenSettings.PREDEFINED_DATE_FORMAT);
  }

  public void addPredefinedDateFormat(jetbrains.mps.baseLanguage.datesInternal.structure.PredefinedDateFormat node) {
    this.addChild(FormatTokenSettings.PREDEFINED_DATE_FORMAT, node);
  }

  public void insertPredefinedDateFormat(jetbrains.mps.baseLanguage.datesInternal.structure.PredefinedDateFormat prev, jetbrains.mps.baseLanguage.datesInternal.structure.PredefinedDateFormat node) {
    this.insertChild(prev, FormatTokenSettings.PREDEFINED_DATE_FORMAT, node);
  }

  public int getDateTimePropertyCardinalitiesCount() {
    return this.getChildCount(FormatTokenSettings.DATE_TIME_PROPERTY_CARDINALITY);
  }

  public Iterator<jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyCardinality> dateTimePropertyCardinalities() {
    return this.children(DateTimePropertyCardinality.class, FormatTokenSettings.DATE_TIME_PROPERTY_CARDINALITY);
  }

  public List<jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyCardinality> getDateTimePropertyCardinalities() {
    return this.getChildren(DateTimePropertyCardinality.class, FormatTokenSettings.DATE_TIME_PROPERTY_CARDINALITY);
  }

  public void addDateTimePropertyCardinality(jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyCardinality node) {
    this.addChild(FormatTokenSettings.DATE_TIME_PROPERTY_CARDINALITY, node);
  }

  public void insertDateTimePropertyCardinality(jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyCardinality prev, jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyCardinality node) {
    this.insertChild(prev, FormatTokenSettings.DATE_TIME_PROPERTY_CARDINALITY, node);
  }

  public int getDateTimePropertyFormatConfigurationsCount() {
    return this.getChildCount(FormatTokenSettings.DATE_TIME_PROPERTY_FORMAT_CONFIGURATION);
  }

  public Iterator<jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyConfiguration> dateTimePropertyFormatConfigurations() {
    return this.children(DateTimePropertyConfiguration.class, FormatTokenSettings.DATE_TIME_PROPERTY_FORMAT_CONFIGURATION);
  }

  public List<jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyConfiguration> getDateTimePropertyFormatConfigurations() {
    return this.getChildren(DateTimePropertyConfiguration.class, FormatTokenSettings.DATE_TIME_PROPERTY_FORMAT_CONFIGURATION);
  }

  public void addDateTimePropertyFormatConfiguration(jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyConfiguration node) {
    this.addChild(FormatTokenSettings.DATE_TIME_PROPERTY_FORMAT_CONFIGURATION, node);
  }

  public void insertDateTimePropertyFormatConfiguration(jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyConfiguration prev, jetbrains.mps.baseLanguage.datesInternal.structure.DateTimePropertyConfiguration node) {
    this.insertChild(prev, FormatTokenSettings.DATE_TIME_PROPERTY_FORMAT_CONFIGURATION, node);
  }


  public static FormatTokenSettings newInstance(SModel sm, boolean init) {
    return (FormatTokenSettings)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.datesInternal.structure.FormatTokenSettings", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static FormatTokenSettings newInstance(SModel sm) {
    return FormatTokenSettings.newInstance(sm, false);
  }

}
