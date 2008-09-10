package jetbrains.mps.smodel.persistence.def;

import org.jdom.Document;
import org.jdom.Element;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUID;

/**
 * Igor Alshannikov
 * Oct 9, 2007
 */
public interface IModelReader {
  SModel readModel(Document document, String modelShortName, String stereotype);

  SNode readNode(Element nodeElement, SModel model);

   public SModelUID upgradeModelUID(SModelUID modelUID);
}
