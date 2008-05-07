package jetbrains.mps.buildlanguage.tasksfromjar;

/*Generated by MPS */

import jetbrains.mps.buildlanguage.tasksfromjar.ClassInfo.Attribute;
import jetbrains.mps.buildlanguage.tasksfromjar.ClassInfo.Nested;
import jetbrains.mps.buildlanguage.tasksfromjar.Importer.IBuilder;
import jetbrains.mps.buildlanguage.tasksfromjar.Importer.IClassInfoProvider;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Exec;
import org.apache.tools.ant.taskdefs.Zip;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.jar.JarFile;

public class TaskImporterTestCase extends TestCase {
  private static final String ANT_PATH = System.getProperty("user.dir")+"/lib/ant-1.7.0";
  private static final String TEST_FOLDER = "platform/buildlanguage/tests";

  public void testTestTask1(){
     try {
      ClassLoader loader = Scanner.createClassLoader(ANT_PATH, TEST_FOLDER);
      ClassInfo classInfo = new ClassInfo(loader.loadClass("jetbrains.mps.buildlanguage.resource.TestTask"));
      Set<Attribute> attrs = classInfo.getAttributes();
      assertTrue(attrs.contains(new Attribute("booleanattribute")));
      assertTrue(attrs.contains(new Attribute("booleanattribute")));
      assertTrue(attrs.contains(new Attribute("stringattribute")));
      // TODO check types
      assertEquals(3, attrs.size());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void testGetTaskClasses(){
    try {
      ClassLoader loader = Scanner.createClassLoader(ANT_PATH, TEST_FOLDER);
      Set<ClassInfo<? extends Task>> taskClasses = Scanner.getTaskClasses(new JarFile("platform/buildlanguage/tests/testTasks.jar"), loader, Task.class);
      assertEquals(2, taskClasses.size());
      ClassInfo[] classInfos = taskClasses.toArray(new ClassInfo[0]);
      Set<String> set = new LinkedHashSet<String>();
      set.add(classInfos[0].getShortName());
      set.add(classInfos[1].getShortName());

      assertTrue(set.contains("parent"));
      assertTrue(set.contains("child"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void testGenerateTasks1(){
    try {
      TestBuilder testBuilder = testImporting("platform/buildlanguage/tests/testTasks.jar");

      assertEquals("declarations {child=false, datatype=true, parent=false, task=true}\n" +
                   "interfaces {}\n" +
                   "nesteds {}\n" +
                   "parents {child=parent, parent=task}\n" +
                   "attributes {intattribute=int, stringattribute=class java.lang.String}", testBuilder.toString());
    } catch (IOException e) {
      fail(e);
    } catch (ClassNotFoundException e) {
      fail(e);
    }
  }

  private TestBuilder testImporting(String srcJar) throws IOException, ClassNotFoundException {
    TestBuilder testBuilder = new TestBuilder();
    Scanner scanner = new Scanner(ANT_PATH, srcJar);
    List<ClassInfo> toImport = scanner.scan();
    IClassInfoProvider provider = scanner.createClassInfoProvider();

    Importer<String> importer = new Importer<String>(toImport, Collections.EMPTY_MAP, provider);

    for (ClassInfo cl : scanner.getRoots()){
      importer.createDeclaration(testBuilder, cl);
    }
    importer.importAll(testBuilder);
    return testBuilder;
  }

  public void testGenerateTasks2NestedElements(){
    try {
      TestBuilder testBuilder = testImporting("platform/buildlanguage/tests/testNested.jar");

      assertEquals("declarations {bigtask=false, datatype=true, inner1=false, inner2=false, inner3=false, task=true}\n" +
                   "interfaces {}\n" +
                   "nesteds {bigtask=[inner1, inner2, inner3]}\n" +
                   "parents {bigtask=task, inner1=datatype, inner2=datatype, inner3=datatype}\n" +
                   "attributes {}", testBuilder.toString());
    } catch (IOException e) {
      fail(e);
    } catch (ClassNotFoundException e) {
      fail(e);
    }
  }

  private static void fail(Exception e) {
    StringWriter writer = new StringWriter();
    e.printStackTrace(new PrintWriter(writer));
    Assert.fail(writer.toString());
  }

  public void testDeprecated() throws IOException {
    ClassInfo ci = Scanner.getClassInfo(Exec.class, new JarFile[]{new JarFile(ANT_PATH + Scanner.LIB_ANT_JAR)});
    assertTrue(ci.isDeprecated());
  }

  public void testNotDeprecated() throws IOException {
    ClassInfo ci = Scanner.getClassInfo(Zip.class, new JarFile[]{new JarFile(ANT_PATH + Scanner.LIB_ANT_JAR)});
    assertFalse(ci.isDeprecated());
  }

  private class TestBuilder implements IBuilder<String> {
    private Map<String, Boolean> myDecls = new TreeMap<String, Boolean>();
    private Map<String, Boolean> myInterfaces = new TreeMap<String, Boolean>();
    private Map<String, SortedSet<String>> myNesteds = new TreeMap<String, SortedSet<String>>();
    private Map<String, String> myParents = new TreeMap<String, String>();
    private Map<String, Class<?>> myAttributes = new TreeMap<String, Class<?>>();

    @Override
    public String toString(){
      StringBuffer sb = new StringBuffer();
      sb.append("declarations ");
      sb.append(myDecls);
      sb.append("\n");
      sb.append("interfaces ");
      sb.append(myInterfaces);
      sb.append("\n");
      sb.append("nesteds ");
      sb.append(myNesteds);
      sb.append("\n");
      sb.append("parents ");
      sb.append(myParents);
      sb.append("\n");
      sb.append("attributes ");
      sb.append(myAttributes);
      return sb.toString();
    }

    public String createDeclaration(ClassInfo ci) {
      myDecls.put(ci.getShortName(), ci.isAbstract());
      return ci.getShortName();
    }

    public void addParent(String declaration, String parent) {
      assertTrue(declaration, myDecls.containsKey(declaration));
      assertTrue(parent, myDecls.containsKey(parent));
      myParents.put(declaration, parent);
    }

    public void addInterface(String declaration, String interfaceDeclaration) {
      assertTrue(declaration, myDecls.containsKey(declaration));
      assertTrue(interfaceDeclaration, myDecls.containsKey(interfaceDeclaration));
    }

    public void addAttribute(String declaration, Attribute attribute) {
      assertTrue(declaration, myDecls.containsKey(declaration));
      myAttributes.put(attribute.getName(), attribute.getType());
    }

    public void addNested(String declaration, String nestedDeclaration, Nested nested) {
      assertTrue(declaration, myDecls.containsKey(declaration));
      assertTrue(nestedDeclaration, myDecls.containsKey(nestedDeclaration));
      SortedSet<String> nesteds = myNesteds.get(declaration);
      if (nesteds == null){
        nesteds = new TreeSet<String>();
        myNesteds.put(declaration, nesteds);
      }
      nesteds.add(nested.getShortName());
    }

    public void updateDeclaration(String declaration, ClassInfo ci) {
      assertTrue(declaration, myDecls.containsKey(declaration));
      assertEquals(declaration, ci.getShortName());
    }
  }
}
