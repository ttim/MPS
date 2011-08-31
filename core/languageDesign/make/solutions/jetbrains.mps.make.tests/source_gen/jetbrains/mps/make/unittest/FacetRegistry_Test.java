package jetbrains.mps.make.unittest;

/*Generated by MPS */

import org.junit.Test;
import jetbrains.mps.make.facet.IFacet;
import junit.framework.Assert;
import jetbrains.mps.make.facet.FacetRegistry;
import jetbrains.mps.internal.collections.runtime.MapSequence;

public class FacetRegistry_Test extends MockTestCase {
  @Test
  public void test_registerUnregister() throws Exception {
    final IFacet fct = Mockups.facet(context, "foobar");
    Assert.assertNotNull(fct);
    FacetRegistry reg = FacetRegistry.getInstance();
    Assert.assertNotNull(reg);
    reg.register(fct);
    Assert.assertSame(fct, MapSequence.<IFacet.Name,IFacet>fromMap(reg.allFacets()).get(new IFacet.Name("foobar")));
    Assert.assertSame(fct, reg.lookup(new IFacet.Name("foobar")));
    reg.unregister(fct);
    Assert.assertNull(MapSequence.<IFacet.Name,IFacet>fromMap(reg.allFacets()).get(new IFacet.Name("foobar")));
    Assert.assertNull(reg.lookup(new IFacet.Name("foobar")));
  }
}
