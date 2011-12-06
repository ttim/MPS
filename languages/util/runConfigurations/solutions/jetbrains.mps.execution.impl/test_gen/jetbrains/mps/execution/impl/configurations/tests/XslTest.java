package jetbrains.mps.execution.impl.configurations.tests;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Element;
import java.io.StringWriter;
import org.jdom.Document;
import jetbrains.mps.util.JDOMUtil;
import java.io.IOException;
import org.jdom.transform.JDOMSource;
import org.jdom.transform.JDOMResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.util.List;
import junit.framework.Assert;
import org.jdom.JDOMException;
import javax.xml.transform.TransformerException;

public class XslTest {
  protected static Log log = LogFactory.getLog(XslTest.class);

  public XslTest() {
  }

  public static void main(String[] args) {
    Element element = readAndTransform("old.java.configuration.xml", "../java.transform.xml");
    if (element != null) {
      StringWriter writer = new StringWriter();
      Document resultDocument = new Document(element);
      try {
        JDOMUtil.writeDocument(resultDocument, writer);
        System.out.println(writer.toString());
      } catch (IOException e) {
      }
    }
  }

  public static Element readAndTransform(String resourceName, String xslFile) {
    try {
      Document document = JDOMUtil.loadDocument(XslTest.class.getResourceAsStream(resourceName));

      JDOMSource source = new JDOMSource(document);
      JDOMResult result = new JDOMResult();

      Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(XslTest.class.getResourceAsStream(xslFile)));
      transformer.transform(source, result);

      List resultList = result.getResult();
      Assert.assertEquals(1, resultList.size());
      return ((Element) resultList.get(0));
    } catch (IOException e) {
      if (log.isErrorEnabled()) {
        log.error("", e);
      }
    } catch (JDOMException e) {
      if (log.isErrorEnabled()) {
        log.error("", e);
      }
    } catch (TransformerException e) {
      if (log.isErrorEnabled()) {
        log.error("Cant transform", e);
      }
    }
    return null;
  }
}
