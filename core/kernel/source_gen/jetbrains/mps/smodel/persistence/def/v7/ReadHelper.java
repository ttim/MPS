package jetbrains.mps.smodel.persistence.def.v7;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SModelReference;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.persistence.def.v5.ModelUtil;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Pair;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SNodeId;

public class ReadHelper {
  protected static Log log = LogFactory.getLog(ReadHelper.class);

  private SModelReference myModelRef;
  private Map<String, SModelReference> myModelByIx;
  private int myMaxImportIndex = 0;

  public ReadHelper(SModelReference modelRef) {
    myModelByIx = MapSequence.fromMap(new HashMap<String, SModelReference>());
    myModelRef = modelRef;
  }

  public void addModelRef(String index, SModelReference modelRef) {
    MapSequence.fromMap(myModelByIx).put(index, modelRef);
  }

  public void addImportToModel(SModel model, String index, String modelUID, int version, boolean implicit) {
    if (modelUID == null) {
      if (log.isErrorEnabled()) {
        log.error("Error loading import element for index " + index + " in " + myModelRef);
      }
      return;
    }
    SModelReference modelRef = ModelUtil.upgradeModelUID(SModelReference.fromString(modelUID));
    SModel.ImportElement elem = new SModel.ImportElement(modelRef, ++myMaxImportIndex, version);
    model.setMaxImportIndex(myMaxImportIndex);
    if (implicit) {
      model.addAdditionalModelVersion(elem);
    } else {
      model.addModelImport(elem);
    }
    addModelRef(index, modelRef);
  }

  public SModelReference getSModelReference(@NotNull String ix) {
    return (StringUtils.isEmpty(ix) ?
      myModelRef :
      MapSequence.fromMap(myModelByIx).get(ix)
    );
  }

  @NotNull
  public Pair<Boolean, SNodePointer> readLink_internal(String src) {
    // returns <true, xxx> - if src is Dynamic Reference 
    // [modelID.]nodeID[:version] | [modelID.]^[:version] 
    Pair<Boolean, SNodePointer> result = new Pair<Boolean, SNodePointer>(false, null);
    if (src == null) {
      return result;
    }
    int i0 = src.indexOf(WriteHelper.MODEL_SEPARATOR_CHAR);
    int i1 = src.lastIndexOf(WriteHelper.VERSION_SEPARATOR_CHAR);
    String text = WriteHelper.decode(src.substring(i0 + 1, (i1 < 0 ?
      src.length() :
      i1
    )));
    result.o1 = WriteHelper.DYNAMIC_REFERENCE_ID.equals(text);
    SModelReference modelRef = getSModelReference((i0 < 0 ?
      "" :
      src.substring(0, i0)
    ));
    SNodeId nodeId = (result.o1 ?
      null :
      SNodeId.fromString(text)
    );
    result.o2 = new SNodePointer(modelRef, nodeId);
    return result;
  }

  public SNodePointer readLinkId(String src) {
    // [modelID.]nodeID[:version] | [modelID.]^[:version] 
    return readLink_internal(src).o2;
  }

  public String readType(String s) {
    int ix = s.indexOf(WriteHelper.MODEL_SEPARATOR_CHAR);
    if (ix <= 0) {
      // no model ID - fqName is here 
      return s.substring(ix + 1);
    }
    SModelReference modelRef = getSModelReference(s.substring(0, ix));
    if (modelRef == null) {
      if (log.isErrorEnabled()) {
        log.error("couldn't create node '" + s.substring(ix + 1) + "' : import for index [" + s.substring(0, ix) + "] not found");
      }
      return s.substring(ix + 1);
    } else {
      return modelRef.getSModelFqName().getLongName() + "." + s.substring(ix + 1);
    }
  }

  public String readRole(String s) {
    return s;
  }

  public String readName(String s) {
    return s;
  }
}
