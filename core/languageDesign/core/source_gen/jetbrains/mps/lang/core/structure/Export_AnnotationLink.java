package jetbrains.mps.lang.core.structure;

/*Generated by MPS */


public class Export_AnnotationLink {
  public static final String EXPORT = "export";

  public static void setExport(BaseConcept source, ExportScope target) {
    source.setAttribute(Export_AnnotationLink.EXPORT, target);
  }

  public static ExportScope getExport(BaseConcept source) {
    return (ExportScope) source.getAttribute(Export_AnnotationLink.EXPORT);
  }
}
