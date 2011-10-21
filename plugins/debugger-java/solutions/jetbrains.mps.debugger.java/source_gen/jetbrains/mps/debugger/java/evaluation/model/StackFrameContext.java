package jetbrains.mps.debugger.java.evaluation.model;

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
import com.sun.jdi.StackFrame;
import com.sun.jdi.Location;
import jetbrains.mps.generator.traceInfo.TraceInfoUtil;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.execution.lib.Java_Command;
import java.util.Map;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.LinkedHashMap;
import com.sun.jdi.LocalVariable;
import com.sun.jdi.Type;
import com.sun.jdi.ClassNotLoadedException;
import jetbrains.mps.typesystem.inference.TypeChecker;
import com.sun.jdi.InvalidStackFrameException;
import com.sun.jdi.AbsentInformationException;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import com.sun.jdi.ObjectReference;
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
import jetbrains.mps.debug.evaluation.transform.TransformationUtil;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class StackFrameContext extends EvaluationContext {
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
      StackFrame stackFrame = javaStackFrame.getStackFrame();
      if (stackFrame != null) {
        try {
          Location location = stackFrame.location();
          locationNode = TraceInfoUtil.getNode(location.declaringType().name(), location.sourceName(), location.lineNumber());
        } catch (Throwable t) {
          if (log.isErrorEnabled()) {
            log.error("", t);
          }
        }
      }
    }
    return locationNode;
  }

  @NotNull
  public List<String> getClassPath() {
    IModule locationModule = getLocationModule();
    if (locationModule == null) {
      return super.getClassPath();
    }
    return Java_Command.getClasspath(locationModule, true);
  }

  @NotNull
  public Map<String, SNode> getVariables(final _FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType) {
    final Map<String, SNode> result = MapSequence.fromMap(new LinkedHashMap<String, SNode>(16, (float) 0.75, false));

    foreachVariable(new _FunctionTypes._return_P1_E0<Boolean, LocalVariable>() {
      public Boolean invoke(LocalVariable variable) {
        String name = variable.name();
        Type jdiType = null;
        try {
          jdiType = variable.type();
          SNode type = getMpsTypeFromJdiType(jdiType, createClassifierType);
          if (type == null) {
            if (log.isWarnEnabled()) {
              log.warn("Could not deduce type for a variable " + name);
            }
          } else {
            SNode highLevelType = getHighLevelTypeForVariable(name);
            if ((highLevelType != null)) {
              MapSequence.fromMap(result).put(name, highLevelType);
            } else {
              MapSequence.fromMap(result).put(name, type);
            }
          }
        } catch (ClassNotLoadedException cne) {
          if (jdiType == null) {
            SNode classifierType = createClassifierType.invoke(variable.typeName());
            if (classifierType == null) {
              if (log.isWarnEnabled()) {
                log.warn("Could not deduce type for a variable " + name);
              }
            } else {
              MapSequence.fromMap(result).put(name, classifierType);
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

  @Nullable
  public SNode getHighLevelTypeForVariable(String varName) {
    JavaStackFrame javaStackFrame = myUiState.getStackFrame();
    if (javaStackFrame != null) {
      Location location = javaStackFrame.getLocation().getLocation();
      if (location != null) {
        try {
          SNode node = TraceInfoUtil.getVar(getStaticContextTypeName(), location.sourceName(), location.lineNumber(), varName);
          if ((node != null)) {
            return SNodeOperations.copyNode(SNodeOperations.cast(TypeChecker.getInstance().getTypeOf(node), "jetbrains.mps.baseLanguage.structure.Type"));
          }
        } catch (InvalidStackFrameException e) {
          if (log.isWarnEnabled()) {
            log.warn("InvalidStackFrameException", e);
          }
        } catch (AbsentInformationException e) {
          if (log.isErrorEnabled()) {
            log.error("", e);
          }
        }
      }
    }
    return null;
  }

  private void foreachVariable(_FunctionTypes._return_P1_E0<? extends Boolean, ? super LocalVariable> action) {
    JavaStackFrame javaStackFrame = myUiState.getStackFrame();
    if (javaStackFrame != null) {
      StackFrame stackFrame = javaStackFrame.getStackFrame();
      if (stackFrame != null) {
        try {
          List<LocalVariable> variables = stackFrame.visibleVariables();
          for (LocalVariable variable : ListSequence.fromList(variables)) {
            if (action.invoke(variable)) {
              return;
            }
          }
        } catch (InvalidStackFrameException e) {
          if (log.isWarnEnabled()) {
            log.warn("InvalidStackFrameException", e);
          }
        } catch (AbsentInformationException e) {
          if (log.isErrorEnabled()) {
            log.error("", e);
          }
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
    return createClassifierType.invoke(unitType);
  }

  private String getStaticContextTypeName() {
    JavaStackFrame frame = myUiState.getStackFrame();
    if (frame != null) {
      Location location = frame.getLocation().getLocation();
      try {
        return TraceInfoUtil.getUnitName(location.declaringType().name(), location.sourceName(), location.lineNumber());
      } catch (AbsentInformationException e) {
        if (log.isErrorEnabled()) {
          log.error("", e);
        }
      }
    }
    return null;
  }

  @Nullable
  public SNode getThisClassifierType(_FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType) {
    ObjectReference thisObject = myUiState.getThisObject();
    if (thisObject == null) {
      return null;
    }

    return getStaticContextType(createClassifierType);
  }

  @Nullable
  private SNode getMpsTypeFromJdiType(Type type, _FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType) throws ClassNotLoadedException {
    // TODO generics 
    if (type instanceof PrimitiveType) {
      if (type instanceof BooleanType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0a0b0k().createNode();
      }
      if (type instanceof ByteType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0b0b0k().createNode();
      }
      if (type instanceof ShortType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0c0b0k().createNode();
      }
      if (type instanceof LongType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0d0b0k().createNode();
      }
      if (type instanceof IntegerType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0e0b0k().createNode();
      }
      if (type instanceof DoubleType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0f0b0k().createNode();
      }
      if (type instanceof FloatType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0g0b0k().createNode();
      }
      if (type instanceof CharType) {
        return new StackFrameContext.QuotationClass_4zsmpx_a0a0h0b0k().createNode();
      }
    } else if (type instanceof ArrayType) {
      return new StackFrameContext.QuotationClass_4zsmpx_a0a0a1a01().createNode(getMpsTypeFromJdiType(((ArrayType) type).componentType(), createClassifierType));
    }
    return createClassifierType.invoke(type.name());
  }

  public boolean isVariableVisible(final String variableName, final SNode variableType) {
    final Wrappers._boolean visible = new Wrappers._boolean(false);
    foreachVariable(new _FunctionTypes._return_P1_E0<Boolean, LocalVariable>() {
      public Boolean invoke(LocalVariable variable) {
        if (eq_4zsmpx_a0a0a0a0a1a11(variable.name(), variableName)) {
          try {
            String variableTypeSignature = TransformationUtil.getJniSignatureFromType(variableType);
            if (eq_4zsmpx_a0b0a0a0a0a0a1a11(variableTypeSignature, variable.type().signature())) {
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
    return eq_4zsmpx_a0c0m(thisObject.referenceType().signature(), TransformationUtil.getJniSignatureFromType(thisType));
  }

  public boolean isStaticContextTypeValid(SNode staticContextType) {
    if (!(SNodeOperations.isInstanceOf(staticContextType, "jetbrains.mps.baseLanguage.structure.ClassifierType"))) {
      return false;
    }
    String staticContextTypeName = getStaticContextTypeName();
    if (StringUtils.isEmpty(staticContextTypeName)) {
      return false;
    }
    return staticContextTypeName.equals(((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SLinkOperations.getTarget(SNodeOperations.cast(staticContextType, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false), "jetbrains.mps.lang.core.structure.INamedConcept"), "virtual_getFqName_1213877404258", new Class[]{SNode.class})));
  }

  private static boolean eq_4zsmpx_a0a0a0a0a1a11(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_4zsmpx_a0b0a0a0a0a0a1a11(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_4zsmpx_a0c0m(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  public static class QuotationClass_4zsmpx_a0a0a0b0k {
    public QuotationClass_4zsmpx_a0a0a0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0b0b0k {
    public QuotationClass_4zsmpx_a0a0b0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0c0b0k {
    public QuotationClass_4zsmpx_a0a0c0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0d0b0k {
    public QuotationClass_4zsmpx_a0a0d0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0e0b0k {
    public QuotationClass_4zsmpx_a0a0e0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0f0b0k {
    public QuotationClass_4zsmpx_a0a0f0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0g0b0k {
    public QuotationClass_4zsmpx_a0a0g0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0h0b0k {
    public QuotationClass_4zsmpx_a0a0h0b0k() {
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

  public static class QuotationClass_4zsmpx_a0a0a1a01 {
    public QuotationClass_4zsmpx_a0a0a1a01() {
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
