package jetbrains.mps.build.mps.runtime.anttask;

/*Generated by MPS */


public class ModuleXml {
  private String myModuleRef = "";
  private String myModuleXmlPath = "";

  public ModuleXml() {
  }

  public void setRef(String ref) {
    myModuleRef = ref;
  }

  public void setDest(String dest) {
    myModuleXmlPath = dest;
  }

  public String getRef() {
    return myModuleRef;
  }

  public String getDest() {
    return myModuleXmlPath;
  }
}
