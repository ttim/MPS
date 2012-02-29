package jetbrains.mps.ide.java.parser;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import java.util.Map;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import java.util.HashSet;
import java.util.List;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import java.util.ArrayList;
import jetbrains.mps.reloading.CompositeClassPathItem;
import jetbrains.mps.project.IModule;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import java.io.File;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.reloading.CommonPaths;
import jetbrains.mps.util.FileUtil;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.project.MPSExtentions;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.project.Solution;
import jetbrains.mps.ide.messages.MessagesViewTool;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Computable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.eclipse.jdt.internal.compiler.Compiler;
import java.util.LinkedHashSet;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.core.compiler.IProblem;
import javax.swing.JOptionPane;
import jetbrains.mps.reloading.IClassPathItem;
import jetbrains.mps.project.structure.modules.ClassPathEntry;
import jetbrains.mps.reloading.FileClassPathItem;
import jetbrains.mps.reloading.JarFileClassPathItem;
import jetbrains.mps.project.structure.model.ModelRootUtil;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Comparator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.compiler.MPSNameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;

public class JavaCompiler {
  private static final Logger LOG = Logger.getLogger(JavaCompiler.class);

  private Map<String, CompilationUnit> myCompilationUnits = new HashMap<String, CompilationUnit>();
  private Set<ICompilationUnit> myProcessedCompilationUnits = new HashSet<ICompilationUnit>();
  private List<CompilationUnitDeclaration> myCompilationUnitDeclarations = new ArrayList<CompilationUnitDeclaration>();
  private CompositeClassPathItem myClassPathItem;
  private IModule myModule;
  private List<CompilationResult> myCompilationResults = new ArrayList<CompilationResult>();
  private List<File> mySourceDirs;
  private Map<String, SModel> myPackageFQNamesToModels = new HashMap<String, SModel>();
  private Set<String> myModelsToCreate = new HashSet<String>();
  private SModel myBaseModelToAddSource;
  private String myPrefix = null;
  private IOperationContext myContext;
  private Project myProject;
  /*package*/ boolean mySetOutputPath;

  public JavaCompiler(IOperationContext context, IModule module, File sourceDir, boolean setOutputPath, Project project) {
    this(context, module, sourceDir, setOutputPath, null, project);
  }

  public JavaCompiler(IOperationContext context, IModule module, File sourceDir, boolean setOutputPath, SModel model, Project project) {
    this(context, module, Sequence.<File>singleton(sourceDir), setOutputPath, model, project);
  }

  public JavaCompiler(IOperationContext context, IModule module, Iterable<File> sourceDirs, boolean setOutputPath, Project project) {
    this(context, module, sourceDirs, setOutputPath, null, project);
  }

  public JavaCompiler(IOperationContext context, IModule module, Iterable<File> sourceDirs, boolean setOutputPath, SModel model, Project project) {
    myContext = context;
    myModule = module;
    mySourceDirs = ListSequence.fromListWithValues(new ArrayList<File>(), sourceDirs);
    myBaseModelToAddSource = model;
    mySetOutputPath = setOutputPath;
    myProject = project;
  }

  private File getGeneralSourceDirectory() {
    if (myPrefix == null) {
      return null;
    }
    String prefixPath = NameUtil.pathFromNamespace(myPrefix);
    String sourcePath = ListSequence.fromList(mySourceDirs).first().getPath();
    if (!(sourcePath.endsWith(prefixPath))) {
      LOG.warning("source directory " + sourcePath + " does not match package structure (" + myPrefix + ")");
      return null;
    }
    int index = sourcePath.length() - prefixPath.length();
    String generalSourcePath = sourcePath.substring(0, index);
    return new File(generalSourcePath);
  }

  private void initClassPathItem(final IModule module) {
    ModelAccess.instance().runReadAction(new Runnable() {
      @Override
      public void run() {
        CompositeClassPathItem compositeClassPathItem = new CompositeClassPathItem();
        compositeClassPathItem.add(module.getModuleWithDependenciesClassPathItem());
        compositeClassPathItem.add(CommonPaths.getJDKClassPath());
        compositeClassPathItem.add(CommonPaths.getMPSClassPath());
        myClassPathItem = compositeClassPathItem;
      }
    });
  }

  public void addSourceFromFile(File file, String packageNameWithoutPrefix) {
    try {
      final String str = "package ";
      String fileContents = FileUtil.read(file);
      StringBuilder classFQName = new StringBuilder();
      for (int i = fileContents.indexOf(str) + str.length(); i < fileContents.length(); i++) {
        char c = fileContents.charAt(i);
        if (Character.isWhitespace(c) || c == ';') {
          break;
        }
        classFQName.append(c);
      }
      String packageNameFromFile = classFQName.toString();
      if (myPrefix != null) {
        String pattern;
        if ("".equals(packageNameWithoutPrefix) || "".equals(myPrefix)) {
          pattern = myPrefix + packageNameWithoutPrefix;
        } else {
          pattern = myPrefix + "." + packageNameWithoutPrefix;
        }
        if (!(pattern.equals(packageNameFromFile))) {
          LOG.error("package " + packageNameFromFile + " in a source file " + file.getName() + " does not correspond to file path: " + pattern);
          return;
        }
      } else {
        if (packageNameFromFile.endsWith(packageNameWithoutPrefix)) {
          int index = packageNameFromFile.length() - packageNameWithoutPrefix.length();
          myPrefix = packageNameFromFile.substring(0, index);
          if (myPrefix.endsWith(".")) {
            myPrefix = myPrefix.substring(0, myPrefix.length() - 1);
          }
        } else {
          LOG.error("package " + packageNameFromFile + " in a source file " + file.getName() + " does not correspond to file path: " + packageNameWithoutPrefix);
          return;
        }
      }
      String fileName;
      String nameAndExtension = file.getName();
      int offset = nameAndExtension.lastIndexOf('.');
      if (offset < 0) {
        fileName = nameAndExtension;
      } else {
        fileName = nameAndExtension.substring(0, offset);
      }
      classFQName.append(".");
      classFQName.append(fileName);
      registerModelForPackage(packageNameFromFile);
      addSource(classFQName.toString(), fileContents);
    } catch (Throwable t) {
      LOG.error(t);
    }
  }

  public void addSourceFromDirectory(File dir, String packageNameWithoutPrefix) {
    assert dir.isDirectory();
    for (File file : dir.listFiles()) {
      if (file.isDirectory()) {
        addSourceFromDirectory(file, packageNameWithoutPrefix + ((StringUtils.isEmpty(packageNameWithoutPrefix) ?
          "" :
          "."
        )) + file.getName());
      } else if (file.getName().endsWith(".java")) {
        addSourceFromFile(file, packageNameWithoutPrefix);
      }
    }
  }

  private void registerModelForPackage(String fqName) {
    SModelFqName sModelFqName = SModelFqName.fromString(fqName);
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(sModelFqName);
    if (modelDescriptor != null) {
      if (!(myModule.getOwnModelDescriptors().contains(modelDescriptor))) {
        LOG.error("model descriptor with fq name " + fqName + " is not owned by module " + myModule.getModuleFqName());
        return;
      }
      myPackageFQNamesToModels.put(fqName, modelDescriptor.getSModel());
    } else {
      myModelsToCreate.add(fqName);
    }
  }

  private void createModels() {
    for (String packageFqName : myModelsToCreate) {
      SModel model = createModel(SModelFqName.fromString(packageFqName));
      myPackageFQNamesToModels.put(packageFqName, model);
    }
  }

  private SModel createModel(SModelFqName modelFqName) {
    SModelDescriptor modelDescriptor = myModule.createModel(modelFqName, myModule.getSModelRoots().iterator().next(), null);
    return modelDescriptor.getSModel();
  }

  public void addSource(String classFqName, String text) {
    CompilationUnit compilationUnit = new CompilationUnit(text.toCharArray(), classFqName.replace(".", File.separator) + MPSExtentions.DOT_JAVAFILE, FileUtil.DEFAULT_CHARSET_NAME);
    myCompilationUnits.put(classFqName, compilationUnit);
  }

  private CompilerOptions getCompilerOptions() {
    CompilerOptions options = new CompilerOptions();
    options.sourceLevel = ClassFileConstants.JDK1_5;
    options.targetJDK = ClassFileConstants.JDK1_5;
    options.produceDebugAttributes = 0;
    options.docCommentSupport = true;
    return options;
  }

  public void compile() {
    if (myBaseModelToAddSource != null) {
      if (!(JavaCompiler.checkBaseModelMatchesSourceDirectory(myBaseModelToAddSource, ListSequence.fromList(mySourceDirs).first()))) {
        LOG.error("model fq name " + SModelOperations.getModelName(myBaseModelToAddSource) + " does not match source directory " + ListSequence.fromList(mySourceDirs).first().getAbsolutePath());
        return;
      }
    }
    initClassPathItem(myModule);
    for (File sourceDir : ListSequence.fromList(mySourceDirs)) {
      myPrefix = null;
      addSourceFromDirectory(sourceDir, "");
    }
    File generalSourceDirectory = getGeneralSourceDirectory();
    if (generalSourceDirectory != null) {
      if (myModule instanceof Solution && mySetOutputPath) {
      }
    }
    boolean needsRecompilation = true;
    while (needsRecompilation) {
      recompile();
      needsRecompilation = addClassPathsAndBuildAst();
    }
  }

  private void showMessageView() {
    if (myContext == null) {
      return;
    }
    MessagesViewTool messagesView = myContext.getComponent(MessagesViewTool.class);
    if (messagesView == null) {
      return;
    }
    messagesView.openToolLater(false);
  }

  private void recompile() {
    showMessageView();
    compileOnce();
  }

  public List<SNode> compileIsolated(String source, FeatureKind featureKind) {
    initClassPathItem(myModule);
    SourceWrapper wrapper = SourceWrapper.wrapSource(source, myBaseModelToAddSource, featureKind);
    addSource(SModelOperations.getModelName(myBaseModelToAddSource) + "." + wrapper.getShortClassName(), wrapper.getWrappedSource());
    myPackageFQNamesToModels.put(SModelOperations.getModelName(myBaseModelToAddSource), myBaseModelToAddSource);
    compileOnce();
    List<SNode> classifierList = ModelAccess.instance().runWriteAction(new Computable<List<SNode>>() {
      @Override
      public List<SNode> compute() {
        return buildAST(true);
      }
    });
    if (classifierList.isEmpty()) {
      return new ArrayList<SNode>();
    }
    List<SNode> sNodeList = wrapper.getOurNodesFromClassifier(ListSequence.fromList(classifierList).first());
    for (SNode node : sNodeList) {
      if ((SNodeOperations.getParent(node) != null)) {
        SNodeOperations.detachNode(node);
        SNodeOperations.getParent(node).removeChild(node);
      }
    }
    return sNodeList;
  }

  private void compileOnce() {
    myCompilationUnitDeclarations = new ArrayList<CompilationUnitDeclaration>();
    myProcessedCompilationUnits = new HashSet<ICompilationUnit>();
    Compiler c = new JavaCompiler.CompilerImpl();
    c.compile(myCompilationUnits.values().toArray(new CompilationUnit[0]));
  }

  private boolean addClassPathsAndBuildAst() {
    boolean hasErrors = false;
    Set<String> fqNames = new LinkedHashSet<String>();
    for (CompilationUnitDeclaration decl : myCompilationUnitDeclarations) {
      if (decl.hasErrors()) {
        hasErrors = true;
        for (CategorizedProblem problem : decl.compilationResult().getErrors()) {
          int id = problem.getID();
          if (id == IProblem.ImportNotFound || id == IProblem.IsClassPathCorrect) {
            fqNames.add(problem.getArguments()[0]);
          } else {
            String message = problem.getMessage();
            LOG.warning(message + " (line: " + problem.getSourceLineNumber() + ")");
          }
        }
      }
    }
    boolean buildAstNow = true;
    if (!(fqNames.isEmpty()) && myContext != null) {
      int option = JOptionPane.showConfirmDialog(null, "Some imports in source code were not resolved.\nDo you want to specify classpaths for unresolved imports?");
      if (option == JOptionPane.YES_OPTION) {
        ClassPathDialog dialog = new ClassPathDialog(myProject, mySourceDirs, ListSequence.fromListWithValues(new ArrayList<String>(), fqNames));
        dialog.show();

        List<IClassPathItem> list = dialog.getChoosenClassPath();
        if (!(list.isEmpty())) {
          for (IClassPathItem classpath : list) {
            myClassPathItem.add(classpath);
            ClassPathEntry cpe = new ClassPathEntry();
            if (classpath instanceof FileClassPathItem) {
              cpe.setPath(((FileClassPathItem) classpath).getPath());
            } else
            if (classpath instanceof JarFileClassPathItem) {
              cpe.setPath(((JarFileClassPathItem) classpath).getFile().getAbsolutePath());
            } else {
              cpe = null;
            }
            if (cpe != null) {
              myModule.getModuleDescriptor().getStubModelEntries().add(ModelRootUtil.fromClassPathEntry(cpe));
              ModelAccess.instance().runWriteInEDT(new Runnable() {
                public void run() {
                  myModule.save();
                }
              });
            }
          }
          return true;
        }
      }
    }
    if (hasErrors) {
      int option = JOptionPane.showConfirmDialog(null, "Errors were found during compilation. Are you sure you want to build MPS model?");
      if (option != JOptionPane.YES_OPTION) {
        buildAstNow = false;
      }
    }
    if (buildAstNow) {
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          createModelsAndBuildAST();
        }
      });
      addRequiredLanguagesToModule();
      return false;
    }
    return false;
  }

  private void addRequiredLanguagesToModule() {
  }

  private void createModelsAndBuildAST() {
    createModels();
    buildAST(false);
  }

  private List<SNode> buildAST(boolean isolated) {
    ReferentsCreator referentsCreator = new ReferentsCreator(new HashMap<String, SModel>(myPackageFQNamesToModels));
    referentsCreator.exec(myCompilationUnitDeclarations.toArray(new CompilationUnitDeclaration[myCompilationUnitDeclarations.size()]));
    JavaConverterTreeBuilder treeBuilder = new JavaConverterTreeBuilder();
    List<SNode> result = treeBuilder.exec(referentsCreator, myPackageFQNamesToModels, isolated);
    // insert comments from each compilation unit 
    for (final CompilationUnitDeclaration cud : ListSequence.fromList(myCompilationUnitDeclarations)) {
      char[] content = cud.compilationResult().getCompilationUnit().getContents();
      int[][] comments = cud.comments;
      int[] lineends = cud.compilationResult().lineSeparatorPositions;
      final Map<SNode, Integer> positions = treeBuilder.myPositions;
      Iterable<Tuples._4<SNode, CompilationUnitDeclaration, Integer, Integer>> blocks = ListSequence.fromList(treeBuilder.myBlocks).where(new IWhereFilter<Tuples._4<SNode, CompilationUnitDeclaration, Integer, Integer>>() {
        public boolean accept(Tuples._4<SNode, CompilationUnitDeclaration, Integer, Integer> it) {
          return it._1() == cud;
        }
      }).sort(new Comparator<Tuples._4<SNode, CompilationUnitDeclaration, Integer, Integer>>() {
        public int compare(Tuples._4<SNode, CompilationUnitDeclaration, Integer, Integer> a, Tuples._4<SNode, CompilationUnitDeclaration, Integer, Integer> b) {
          return (int) a._3() - (int) b._3();
        }
      }, true);
      for (int[] comment : comments) {
        // skip javadoc 
        if (comment[1] > 0) {
          continue;
        }
        final int linestart = Math.abs(comment[0]);
        // find appropriate block 
        SNode block = null;
        for (Tuples._4<SNode, CompilationUnitDeclaration, Integer, Integer> blk : Sequence.fromIterable(blocks)) {
          if ((int) blk._2() <= linestart && linestart <= (int) blk._3()) {
            block = blk._0();
            break;
          }
        }
        if ((block != null)) {
          int pos = ListSequence.fromList(SLinkOperations.getTargets(block, "statement", true)).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return !(MapSequence.fromMap(positions).containsKey(it)) || Math.abs(MapSequence.fromMap(positions).get(it)) <= linestart;
            }
          }).count();
          for (String line : ListSequence.fromList(CommentHelper.processComment(CommentHelper.splitString(content, lineends, linestart, Math.abs(comment[1]))))) {
            SNode commentText = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.TextCommentPart", null);
            SPropertyOperations.set(commentText, "text", line);
            SNode commentLine = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.SingleLineComment", null);
            ListSequence.fromList(SLinkOperations.getTargets(commentLine, "commentPart", true)).addElement(commentText);
            ListSequence.fromList(SLinkOperations.getTargets(block, "statement", true)).insertElement(pos++, commentLine);
          }
        } else {
          LOG.warning("cannot find a place to import comment from " + new String(cud.getMainTypeName()) + ":\n" + new String(content, linestart, Math.abs(comment[1]) - linestart));
        }
      }
    }
    return result;
  }

  public List<CompilationResult> getCompilationResults() {
    return myCompilationResults;
  }

  public Iterable<SModel> getAffectedModels() {
    return myPackageFQNamesToModels.values();
  }

  public static boolean checkBaseModelMatchesSourceDirectory(SModel model, File sourceDir) {
    String pathPostfix = NameUtil.pathFromNamespace(SModelOperations.getModelName(model));
    return sourceDir.getAbsolutePath().endsWith(pathPostfix);
  }

  public static String packageNameFromCompoundName(char[][] name) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < name.length - 1; i++) {
      char[] namePart = name[i];
      result.append(namePart);
      if (i < name.length - 2) {
        result.append('.');
      }
    }
    return result.toString();
  }

  public static String classNameFromCompoundName(char[][] name) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < name.length; i++) {
      char[] namePart = name[i];
      result.append(namePart);
      if (i < name.length - 1) {
        result.append('.');
      }
    }
    return result.toString();
  }

  private class MyNameEnvironment extends MPSNameEnvironment {
    private MyNameEnvironment() {
    }

    protected IClassPathItem getClassPathItem() {
      return myClassPathItem;
    }

    protected NameEnvironmentAnswer findType(String fqName) {
      if (myCompilationUnits.containsKey(fqName)) {
        return new NameEnvironmentAnswer(myCompilationUnits.get(fqName), null);
      }
      return super.findType(fqName);
    }
  }

  private static class MyErrorHandlingPolicy implements IErrorHandlingPolicy {
    private MyErrorHandlingPolicy() {
    }

    public boolean proceedOnErrors() {
      return true;
    }

    public boolean stopOnFirstError() {
      return false;
    }
  }

  private class MyCompilerRequestor implements ICompilerRequestor {
    private MyCompilerRequestor() {
    }

    public void acceptResult(CompilationResult result) {
      myCompilationResults.add(result);
    }
  }

  private class MyProblemFactory extends DefaultProblemFactory {
    private MyProblemFactory() {
    }

    public CategorizedProblem createProblem(char[] originatingFileName, int problemId, String[] problemArguments, String[] messageArguments, int severity, int startPosition, int endPosition, int lineNumber, int columnNumber) {
      CategorizedProblem problem = super.createProblem(originatingFileName, problemId, problemArguments, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber);
      return problem;
    }

    public CategorizedProblem createProblem(char[] originatingFileName, int problemId, String[] problemArguments, int elaborationId, String[] messageArguments, int severity, int startPosition, int endPosition, int lineNumber, int columnNumber) {
      CategorizedProblem problem = super.createProblem(originatingFileName, problemId, problemArguments, elaborationId, messageArguments, severity, startPosition, endPosition, lineNumber, columnNumber);
      String message = problem.getMessage();
      return problem;
    }
  }

  private class CompilerImpl extends Compiler {
    public CompilerImpl() {
      super(new JavaCompiler.MyNameEnvironment(), new JavaCompiler.MyErrorHandlingPolicy(), getCompilerOptions(), new JavaCompiler.MyCompilerRequestor(), new JavaCompiler.MyProblemFactory(), null, null);
    }

    @Override
    public void process(CompilationUnitDeclaration cud, int i) {
      super.process(cud, i);
      ICompilationUnit icu = cud.compilationResult().compilationUnit;
      if (!(myProcessedCompilationUnits.contains(icu))) {
        myCompilationUnitDeclarations.add(cud);
        myProcessedCompilationUnits.add(icu);
      }
    }

    @Override
    public void initializeParser() {
      this.parser = new CommentRecorderParser(this.problemReporter, this.options.parseLiteralExpressionsAsConstants);
    }
  }
}
