package jetbrains.mps.debug;

/*Generated by MPS */

import jetbrains.mps.generator.fileGenerator.XmlBasedModelCache;
import jetbrains.mps.generator.fileGenerator.FileGenerationManager;
import jetbrains.mps.generator.fileGenerator.AllCaches;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jdom.Element;
import jetbrains.mps.generator.fileGenerator.CacheGenerationContext;
import com.intellij.openapi.application.ApplicationManager;

public class BLDebugInfoCache extends XmlBasedModelCache<DebugInfo> {
  public BLDebugInfoCache(FileGenerationManager fileGeneratorManager, AllCaches allCaches) {
    super(fileGeneratorManager, allCaches);
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "BL Debug Info Cache";
  }

  protected String getCacheFileName() {
    return ".debug";
  }

  protected Element toXml(DebugInfo di) {
    return di.toXml();
  }

  protected DebugInfo fromXml(Element e) {
    return DebugInfo.fromXml(e);
  }

  protected DebugInfo generateCache(CacheGenerationContext ctx) {
    return ctx.getDebugInfo();
  }

  public static BLDebugInfoCache getInstance() {
    return ApplicationManager.getApplication().getComponent(BLDebugInfoCache.class);
  }
}
