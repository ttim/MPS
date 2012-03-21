package jetbrains.mps.project.foreign;

/*Generated by MPS */

import java.util.Set;
import jetbrains.mps.project.structure.model.ModelRoot;
import org.jdom.Element;
import java.util.Map;
import java.lang.reflect.Method;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.lang.reflect.Modifier;
import jetbrains.mps.xmlQuery.runtime.AttributeUtils;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.lang.reflect.InvocationTargetException;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class MPSFacetConfiguration {
  private String myUUID;
  private String myGeneratorOutputPath;
  private Set<ModelRoot> myModelRoots;
  private boolean myUseModuleSourceFolder;
  private boolean myUseTransientOutputFolder;
  private String[] myUsedLanguages;

  public MPSFacetConfiguration() {
  }

  public void readFromXml(Element config) throws FacetConfigurationFormatException {
    Map<String, Method> props = MapSequence.fromMap(new HashMap<String, Method>());
    for (Method mth : MPSFacetConfiguration.class.getMethods()) {
      if (mth.getName().startsWith("set") && Modifier.isPublic(mth.getModifiers()) && mth.getParameterTypes().length == 1) {
        MapSequence.fromMap(props).put(mth.getName().substring(3), mth);
      }
    }
    for (Element ch : AttributeUtils.elementChildren(config, "option")) {
      Method pr = MapSequence.fromMap(props).get(NameUtil.capitalize(ch.getAttributeValue("name")));
      if (pr != null) {
        Object value;
        if (Set.class.isAssignableFrom(pr.getParameterTypes()[0])) {
          value = readModelRoots(ListSequence.fromList(AttributeUtils.elementChildren(ch, "set")).first());
        } else
        if (pr.getParameterTypes()[0].isArray()) {
          value = readArray(ListSequence.fromList(AttributeUtils.elementChildren(ch, "array")).first());
        } else if (pr.getParameterTypes()[0].isPrimitive()) {
          value = Boolean.valueOf(ch.getAttributeValue("value"));
        } else {
          value = ch.getAttributeValue("value");
        }
        setPropertyValue(pr, value);
      }
    }
    MapSequence.fromMap(props).clear();
  }

  private void setPropertyValue(Method pr, Object value) throws FacetConfigurationFormatException {
    try {
      pr.invoke(this, value);
    } catch (InvocationTargetException e) {
      throw new FacetConfigurationFormatException(e);
    } catch (IllegalAccessException e) {
      throw new FacetConfigurationFormatException(e);
    } catch (IllegalArgumentException e) {
      throw new FacetConfigurationFormatException(e);
    }
  }

  private Set<ModelRoot> readModelRoots(Element array) {
    Set<ModelRoot> res = SetSequence.fromSet(new HashSet<ModelRoot>());
    for (Element o : AttributeUtils.elementChildren(array, "ModelRoot")) {
      String path = getPath(o);
      if (path != null) {
        SetSequence.fromSet(res).addElement(new ModelRoot(path, null));
      }
    }
    return res;
  }

  private String getPath(Element modelRootElement) {
    for (Element optionChild : ListSequence.fromList(AttributeUtils.elementChildren(modelRootElement, "option"))) {
      if ("path".equals(optionChild.getAttributeValue("name")) && optionChild.getAttributeValue("value") != null) {
        return optionChild.getAttributeValue("value");
      }
    }
    return null;
  }

  private String[] readArray(Element array) {
    List<String> res = ListSequence.fromList(new ArrayList<String>());
    for (Element o : AttributeUtils.elementChildren(array, "option")) {
      ListSequence.fromList(res).addElement(o.getAttributeValue("value"));
    }
    return ListSequence.fromList(res).toGenericArray(String.class);
  }

  public String getUUID() {
    return this.myUUID;
  }

  public void setUUID(String value) {
    this.myUUID = value;
  }

  public String getGeneratorOutputPath() {
    return this.myGeneratorOutputPath;
  }

  public void setGeneratorOutputPath(String value) {
    this.myGeneratorOutputPath = value;
  }

  public Set<ModelRoot> getModelRoots() {
    return this.myModelRoots;
  }

  public void setModelRoots(Set<ModelRoot> value) {
    this.myModelRoots = value;
  }

  public boolean getUseModuleSourceFolder() {
    return this.myUseModuleSourceFolder;
  }

  public void setUseModuleSourceFolder(boolean value) {
    this.myUseModuleSourceFolder = value;
  }

  public boolean getUseTransientOutputFolder() {
    return this.myUseTransientOutputFolder;
  }

  public void setUseTransientOutputFolder(boolean value) {
    this.myUseTransientOutputFolder = value;
  }

  public String[] getUsedLanguages() {
    return this.myUsedLanguages;
  }

  public void setUsedLanguages(String[] value) {
    this.myUsedLanguages = value;
  }
}
