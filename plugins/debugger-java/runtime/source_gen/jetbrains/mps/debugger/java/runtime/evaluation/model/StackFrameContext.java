package jetbrains.mps.debugger.java.runtime.evaluation.model;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.debug.runtime.JavaUiState;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaStackFrame;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaLocation;
import jetbrains.mps.generator.traceInfo.TraceInfoUtil;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.reloading.ClasspathStringCollector;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.util.CollectionUtil;
import java.util.Set;
import jetbrains.mps.reloading.CommonPaths;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Map;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.LinkedHashMap;
import jetbrains.mps.debug.runtime.java.programState.watchables.JavaLocalVariable;
import com.sun.jdi.Type;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.InvalidStackFrameException;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.debug.api.programState.IWatchable;
import jetbrains.mps.debug.runtime.java.programState.watchables.JavaThisObject;
import com.sun.jdi.PrimitiveType;
import com.sun.jdi.BooleanType;
import com.sun.jdi.ByteType;
import com.sun.jdi.ShortType;
import com.sun.jdi.LongType;
import com.sun.jdi.IntegerType;
import com.sun.jdi.DoubleType;
import com.sun.jdi.FloatType;
import com.sun.jdi.CharType;
import com.sun.jdi.ArrayType;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.debug.evaluation.transform.TransformatorBuilder;
import com.sun.jdi.ObjectReference;
import jetbrains.mps.smodel.SNodeId;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

/*package*/ class StackFrameContext extends EvaluationContext {
  protected static Log log = LogFactory.getLog(StackFrameContext.class);

  public StackFrameContext(JavaUiState uiState) {
    super(uiState);
  }

  @Nullable
  protected IModule getLocationModule() {
    SModel model = getLocationModel();
    if (model == null) {
      return null;
    }
    return model.getModelDescriptor().getModule();
  }

  @Nullable
  private SModel getLocationModel() {
    return SNodeOperations.getModel(getLocationNode());
  }

  @Nullable
  public SNode getLocationNode() {
    JavaStackFrame javaStackFrame = myUiState.getStackFrame();
    SNode locationNode = null;
    if (javaStackFrame != null) {
      JavaLocation location = javaStackFrame.getLocation();
      if (location != null) {
        return TraceInfoUtil.getJavaNode(location.getUnitName(), location.getFileName(), location.getLineNumber());
      }
    }
    return locationNode;
  }

  @NotNull
  public List<String> getClassPath() {
    final IModule locationModule = getLocationModule();
    if (locationModule == null) {
      return super.getClassPath();
    }

    // todo duplication between this method and java.getClasspath 
    // but this code is compiled in idea so we cant use Java_Command here:( 
    final ClasspathStringCollector visitor = new ClasspathStringCollector();
    locationModule.getClassPathItem().accept(visitor);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        AbstractModule.getDependenciesClasspath(CollectionUtil.set(locationModule), false).accept(visitor);
      }
    });

    Set<String> visited = visitor.getClasspath();
    visited.removeAll(CommonPaths.getJDKPath());
    return ListSequence.fromListWithValues(new ArrayList<String>(), visited);
  }

  @NotNull
  public Map<String, VariableDescription> getVariables(final _FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType) {
    final Map<String, VariableDescription> result = MapSequence.fromMap(new LinkedHashMap<String, VariableDescription>(16, (float) 0.75, false));

    foreachVariable(new _FunctionTypes._return_P1_E0<Boolean, JavaLocalVariable>() {
      public Boolean invoke(JavaLocalVariable variable) {
        String name = variable.getName();
        Type jdiType = null;
        try {
          jdiType = variable.getLocalVariable().type();
          SNode type = getMpsTypeFromJdiType(jdiType, createClassifierType);
          if (type == null) {
            if (log.isWarnEnabled()) {
              log.warn("Could not deduce type for a variable " + name);
            }
          } else {
            VariableDescription variableDescription = new VariableDescription(name, type);
            fillVariableDescription(name, variableDescription);
            MapSequence.fromMap(result).put(name, variableDescription);
          }
        } catch (ClassNotLoadedException cne) {
          if (jdiType == null) {
            SNode classifierType = createClassifierType.invoke(variable.getLocalVariable().typeName());
            if (classifierType == null) {
              if (log.isWarnEnabled()) {
                log.warn("Could not deduce type for a variable " + name);
              }
            } else {
              VariableDescription variableDescription = new VariableDescription(name, classifierType);
              fillVariableDescription(name, variableDescription);
              MapSequence.fromMap(result).put(name, variableDescription);
            }
          } else {
            if (log.isWarnEnabled()) {
              log.warn("Exception when creating variable " + name, cne);
            }
          }
        }
        return false;
      }
    });

    return result;
  }

  public void fillVariableDescription(String varName, VariableDescription description) {
    JavaStackFrame javaStackFrame = myUiState.getStackFrame();
    if (javaStackFrame != null) {
      JavaLocation javaLocation = javaStackFrame.getLocation();
      try {
        SNode node = TraceInfoUtil.getVar(getStaticContextTypeName(), javaLocation.getFileName(), javaLocation.getLineNumber(), varName);
        if ((node != null)) {
          description.setHighLevelNode(node);
        }
      } catch (InvalidStackFrameException e) {
        if (log.isWarnEnabled()) {
          log.warn("InvalidStackFrameException", e);
        }
      }
    }
  }

  private void foreachVariable(_FunctionTypes._return_P1_E0<? extends Boolean, ? super JavaLocalVariable> action) {
    JavaStackFrame javaStackFrame = myUiState.getStackFrame();
    if (javaStackFrame != null) {
      List<JavaLocalVariable> visibleVariables = javaStackFrame.getVisibleVariables();
      for (JavaLocalVariable variable : ListSequence.fromList(visibleVariables)) {
        if (action.invoke(variable)) {
          return;
        }
      }
    }
  }

  @Nullable
  public SNode getStaticContextType(_FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType) {
    final String unitType = getStaticContextTypeName();
    if (unitType == null) {
      return null;
    }
    SNode result = SConceptOperations.createNewNode("jetbrains.mps.debugger.java.evaluation.structure.UnitNode", null);
    SNode lowLevelType = createClassifierType.invoke(unitType);
    SNode highLevelNode = getStaticContextNode();
    if ((highLevelNode != null) && SNodeOperations.isInstanceOf(highLevelNode, "jetbrains.mps.baseLanguage.structure.Classifier")) {
      SLinkOperations.setTarget(result, "debuggedType", VariableDescription.createDebuggedType(lowLevelType, ((SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(highLevelNode, "jetbrains.mps.baseLanguage.structure.Classifier"), "virtual_getThisType_3305065273710880775", new Class[]{SNode.class}))), true);
    } else if ((highLevelNode != null) && SNodeOperations.isInstanceOf(highLevelNode, "jetbrains.mps.baseLanguage.classifiers.structure.IClassifier")) {
      SLinkOperations.setTarget(result, "debuggedType", VariableDescription.createDebuggedType(lowLevelType, ((SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(highLevelNode, "jetbrains.mps.baseLanguage.classifiers.structure.IClassifier"), "virtual_createType_1213877527970", new Class[]{SNode.class}))), true);
    } else {
      SLinkOperations.setTarget(result, "debuggedType", VariableDescription.createDebuggedType(lowLevelType, null), true);
    }
    SPropertyOperations.set(result, "highLevelNodeId", check_4zsmpx_a0a0g0h(highLevelNode).toString());
    return result;
  }

  private String getStaticContextTypeName() {
    JavaStackFrame frame = myUiState.getStackFrame();
    if (frame != null) {
      JavaLocation location = frame.getLocation();
      if (location != null) {
        return TraceInfoUtil.getUnitName(location.getUnitName(), location.getFileName(), location.getLineNumber());
      }
    }
    return null;
  }

  private SNode getStaticContextNode() {
    JavaStackFrame frame = myUiState.getStackFrame();
    if (frame != null) {
      JavaLocation location = frame.getLocation();
      if (location != null) {
        return TraceInfoUtil.getUnitNode(location.getUnitName(), location.getFileName(), location.getLineNumber());
      }
    }
    return null;
  }

  @Nullable
  public SNode getThisClassifierType(_FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType) {
    IWatchable contextWatchable = myUiState.getStackFrame().getContextWatchable();
    // todo 
    if (contextWatchable == null || !(contextWatchable instanceof JavaThisObject)) {
      return null;
    }

    return getStaticContextType(createClassifierType);
  }

  @Nullable
  private SNode getMpsTypeFromJdiType(Type type, _FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType) throws ClassNotLoadedException {
    // TODO generics 
    if (type instanceof PrimitiveType) {
      if (type instanceof BooleanType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0a0b0l().createNode();
      }
      if (type instanceof ByteType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0b0b0l().createNode();
      }
      if (type instanceof ShortType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0c0b0l().createNode();
      }
      if (type instanceof LongType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0d0b0l().createNode();
      }
      if (type instanceof IntegerType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0e0b0l().createNode();
      }
      if (type instanceof DoubleType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0f0b0l().createNode();
      }
      if (type instanceof FloatType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0g0b0l().createNode();
      }
      if (type instanceof CharType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0h0b0l().createNode();
      }
    } else if (type instanceof ArrayType) {
      return new StackFrameContext.QuotationClass_4zsmpx_a0a0a1a11().createNode(getMpsTypeFromJdiType(((ArrayType) type).componentType(), createClassifierType));
    }
    return createClassifierType.invoke(type.name());
  }

  public boolean isVariableVisible(final String variableName, final SNode variableType) {
    final Wrappers._boolean visible = new Wrappers._boolean(false);
    foreachVariable(new _FunctionTypes._return_P1_E0<Boolean, JavaLocalVariable>() {
      public Boolean invoke(JavaLocalVariable variable) {
        if (eq_4zsmpx_a0a0a0a0a1a21(variable.getName(), variableName)) {
          try {
            String variableTypeSignature = TransformatorBuilder.getInstance().getJniSignatureFromType(variableType);
            if (eq_4zsmpx_a0b0a0a0a0a0a1a21(variableTypeSignature, variable.getLocalVariable().type().signature())) {
              visible.value = true;
              return true;
            }
          } catch (ClassNotLoadedException ex) {
            if (log.isWarnEnabled()) {
              log.warn("Exception when checking variable " + variable, ex);
            }
          }
        }
        return false;
      }
    });
    return visible.value;
  }

  public boolean isThisTypeValid(SNode thisType) {
    ObjectReference thisObject = myUiState.getThisObject();
    if (thisObject == null) {
      return false;
    }
    return eq_4zsmpx_a0c0n(thisObject.referenceType().signature(), TransformatorBuilder.getInstance().getJniSignatureFromType(thisType));
  }

  public boolean isStaticContextTypeValid(SNode staticContextType) {
    if (!(SNodeOperations.isInstanceOf(staticContextType, "jetbrains.mps.baseLanguage.structure.ClassifierType"))) {
      return false;
    }
    String staticContextTypeName = getStaticContextTypeName();
    if ((staticContextTypeName == null || staticContextTypeName.length() == 0)) {
      return false;
    }
    return staticContextTypeName.equals(((String) BehaviorManager.getInstance().invoke(Object.class, SLinkOperations.getTarget(SNodeOperations.cast(staticContextType, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false), "virtual_getFqName_1213877404258", new Class[]{SNode.class})));
  }

  private static SNodeId check_4zsmpx_a0a0g0h(SNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getSNodeId();
    }
    return null;
  }

  private static boolean eq_4zsmpx_a0a0a0a0a1a21(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_4zsmpx_a0b0a0a0a0a0a1a21(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_4zsmpx_a0c0n(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  public static class QuotationClass_4zsmpx_a0a0a0b0l {
    public QuotationClass_4zsmpx_a0a0a0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0b0b0l {
    public QuotationClass_4zsmpx_a0a0b0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ByteType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0c0b0l {
    public QuotationClass_4zsmpx_a0a0c0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ShortType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0d0b0l {
    public QuotationClass_4zsmpx_a0a0d0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LongType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0e0b0l {
    public QuotationClass_4zsmpx_a0a0e0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0f0b0l {
    public QuotationClass_4zsmpx_a0a0f0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0g0b0l {
    public QuotationClass_4zsmpx_a0a0g0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.FloatType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0h0b0l {
    public QuotationClass_4zsmpx_a0a0h0b0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.CharType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_4zsmpx_a0a0a1a11 {
    public QuotationClass_4zsmpx_a0a0a1a11() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ArrayType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("componentType", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
