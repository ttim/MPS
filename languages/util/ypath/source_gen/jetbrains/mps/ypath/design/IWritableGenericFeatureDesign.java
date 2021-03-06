package jetbrains.mps.ypath.design;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.ITemplateGenerator;

public interface IWritableGenericFeatureDesign extends IGenericFeatureDesign {
  public SNode replaceStatement(SNode srcExpr, SNode range, SNode replaceExpr, ITemplateGenerator generator);
  public SNode removeStatement(SNode srcExpr, SNode range, ITemplateGenerator generator);
  public SNode insertStatement(SNode srcExpr, SNode range, SNode insertExpr, ITemplateGenerator generator);
  public static class Stub extends IGenericFeatureDesign.Stub implements IWritableGenericFeatureDesign {
    public Stub() {
    }

    public SNode insertStatement(SNode srcExpr, SNode range, SNode insertExpr, ITemplateGenerator generator) {
      return null;
    }

    public SNode removeStatement(SNode srcExpr, SNode range, ITemplateGenerator generator) {
      return null;
    }

    public SNode replaceStatement(SNode srcExpr, SNode range, SNode replaceExpr, ITemplateGenerator generator) {
      return null;
    }
  }

}
