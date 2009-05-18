package jetbrains.mps.lang.test.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;

public class NodePropertiesMarker_AnnotationLink {
  public static final String NODE_PROPERTIES_MARKER = "nodePropertiesMarker";

  public static void setNodePropertiesMarker(BaseConcept source, NodePropertiesContainer target) {
    source.setAttribute(NodePropertiesMarker_AnnotationLink.NODE_PROPERTIES_MARKER, target);
  }

  public static NodePropertiesContainer getNodePropertiesMarker(BaseConcept source) {
    return (NodePropertiesContainer)source.getAttribute(NodePropertiesMarker_AnnotationLink.NODE_PROPERTIES_MARKER);
  }

}
