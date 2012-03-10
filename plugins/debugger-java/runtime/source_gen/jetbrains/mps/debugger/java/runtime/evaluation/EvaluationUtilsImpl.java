package jetbrains.mps.debugger.java.runtime.evaluation;

/*Generated by MPS */

import jetbrains.mps.debug.evaluation.EvaluationUtils;
import com.sun.jdi.Value;
import com.sun.jdi.ArrayReference;
import org.jetbrains.annotations.NotNull;
import com.sun.jdi.ThreadReference;
import jetbrains.mps.debug.evaluation.EvaluationException;
import com.sun.jdi.ClassType;
import com.sun.jdi.Method;
import java.util.List;
import jetbrains.mps.debug.evaluation.proxies.MirrorUtil;
import com.sun.jdi.InvocationException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import jetbrains.mps.debug.evaluation.InvalidEvaluatedExpressionException;
import com.sun.jdi.Field;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import org.jetbrains.annotations.Nullable;
import com.sun.jdi.Type;
import com.sun.jdi.ArrayType;
import com.sun.jdi.InterfaceType;
import jetbrains.mps.debug.evaluation.proxies.IValueProxy;
import com.sun.jdi.StackFrame;
import com.sun.jdi.LocalVariable;
import com.sun.jdi.AbsentInformationException;
import jetbrains.mps.debug.evaluation.proxies.IObjectValueProxy;
import jetbrains.mps.debug.evaluation.proxies.IterableProxy;
import jetbrains.mps.debug.evaluation.proxies.IArrayValueProxy;
import jetbrains.mps.debug.evaluation.proxies.IterableArrayProxy;
import com.sun.jdi.ClassObjectReference;
import jetbrains.mps.debug.evaluation.proxies.PrimitiveValueProxy;
import com.sun.jdi.PrimitiveValue;
import com.sun.jdi.BooleanValue;
import com.sun.jdi.ShortValue;
import com.sun.jdi.ByteValue;
import com.sun.jdi.CharValue;
import com.sun.jdi.DoubleValue;
import com.sun.jdi.FloatValue;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.LongValue;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import com.sun.jdi.ObjectReference;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class EvaluationUtilsImpl extends EvaluationUtils {
  public EvaluationUtilsImpl() {
  }

  public void dispose() {
    synchronized (LOCK) {
      INSTANCE = null;
    }
  }

  public void init() {
    synchronized (LOCK) {
      INSTANCE = this;
    }
  }

  public Value getArrayElementAt(ArrayReference array, int index) {
    return array.getValue(index);
  }

  private Value invokeStaticInternal(String className, String methodName, String jniSignature, @NotNull final ThreadReference threadReference, Object... args) throws EvaluationException {
    final ClassType referenceType = (ClassType) findClassType(className, threadReference.virtualMachine());
    final Method method = findMethod(referenceType, methodName, jniSignature);
    final List<Value> argValues = MirrorUtil.getInstance().getValues(threadReference, args);
    return EvaluationUtils.handleInvocationExceptions(new EvaluationUtils.ThreadInvocatable<Value>(threadReference) {
      @Override
      public Value invoke() throws InvocationException, InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
        return referenceType.invokeMethod(threadReference, method, argValues, 0);
      }
    });
  }

  private Value getStaticFieldValueInternal(String className, String fieldName, @NotNull final ThreadReference threadReference) throws InvalidEvaluatedExpressionException {
    ClassType referenceType = (ClassType) findClassType(className, threadReference.virtualMachine());
    Field field = findField(referenceType, fieldName);
    assert field.isStatic();
    return referenceType.getValue(field);
  }

  private Value invokeConstructorInternal(String className, String jniSignature, @NotNull final ThreadReference threadReference, Object... args) throws EvaluationException {
    // TODO duplication in code 
    final ClassType referenceType = (ClassType) findClassType(className, threadReference.virtualMachine());
    final Method constructor = findConstructor(referenceType, jniSignature);
    final List<Value> argValues = MirrorUtil.getInstance().getValues(threadReference, args);
    return EvaluationUtils.handleInvocationExceptions(new EvaluationUtils.ThreadInvocatable<Value>(threadReference) {
      @Override
      public Value invoke() throws InvocationException, InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
        return referenceType.newInstance(threadReference, constructor, argValues, 0);
      }
    });
  }

  @NotNull
  public Field findField(ClassType referenceType, String fieldName) throws InvalidEvaluatedExpressionException {
    Field field = referenceType.fieldByName(fieldName);
    if (field == null) {
      throw new InvalidEvaluatedExpressionException("Could not find field " + fieldName + " in " + referenceType.name() + ".");
    }
    return field;
  }

  public List<Field> findFields(ClassType referenceType) {
    return referenceType.fields();
  }

  @NotNull
  public Method findConstructor(ClassType referenceType, String jniSignature) throws InvalidEvaluatedExpressionException {
    List<Method> methods = referenceType.methodsByName("<init>", jniSignature);
    if (methods.size() == 0) {
      throw new InvalidEvaluatedExpressionException("Could not find constructor  with signature " + jniSignature + " in " + referenceType.name() + ".");
    }
    Method constructor = null;
    for (Method m : methods) {
      if (m.isConstructor()) {
        constructor = m;
        break;
      }
    }
    if (constructor == null) {
      throw new InvalidEvaluatedExpressionException("Could not find constructor  with signature " + jniSignature + " in " + referenceType.name() + ".");
    }
    return constructor;
  }

  @NotNull
  public Method findMethod(ClassType referenceType, String methodsName, String jniSignature) throws InvalidEvaluatedExpressionException {
    List<Method> methods = referenceType.methodsByName(methodsName, jniSignature);
    if (methods.size() == 0) {
      throw new InvalidEvaluatedExpressionException("Could not find method " + methodsName + " with signature " + jniSignature + " in " + referenceType.name() + ".");
    }
    return methods.get(0);
  }

  @NotNull
  public ReferenceType findClassType(String className, VirtualMachine virtualMachine) throws InvalidEvaluatedExpressionException {
    ReferenceType classType = findClassTypeSilently(className, virtualMachine);
    if (classType == null) {
      throw new InvalidEvaluatedExpressionException("Could not find class " + className + ".");
    }
    return classType;
  }

  @Nullable
  public ReferenceType findClassTypeSilently(String className, VirtualMachine virtualMachine) throws InvalidEvaluatedExpressionException {
    // apparently, classesByName works for both dot and slash (ie for java.lang.String and for java/lang/String) 
    // even for java.lang/String 
    List<ReferenceType> classes = virtualMachine.classesByName(className);
    if (classes.size() == 0) {
      return null;
    }
    return classes.get(0);
  }

  public boolean instanceOf(final Type what, final String jniSignature, final VirtualMachine machine) throws EvaluationException {
    if (jniSignature.equals("Ljava/lang/Object;")) {
      return true;
    }
    if (what.signature().equals(jniSignature)) {
      return true;
    }
    return EvaluationUtils.handleInvocationExceptions(new EvaluationUtils.Invocatable<Boolean>() {
      @Override
      public Boolean invoke() throws InvocationException, InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException, EvaluationException {
        if (jniSignature.startsWith("[")) {
          if (!((what instanceof ArrayType))) {
            return false;
          }
          return EvaluationUtils.isInstanceOf(((ArrayType) what).componentType(), jniSignature.substring(1), machine);
        } else
        if (jniSignature.startsWith("L")) {
          if (!((what instanceof ClassType))) {
            return false;
          }
          ReferenceType type = findClassTypeSilently(jniSignature.substring(1, jniSignature.length() - 1), machine);
          if (type == null) {
            return false;
          }
          ClassType whatClassType = (ClassType) what;
          if (type instanceof InterfaceType) {
            return whatClassType.allInterfaces().contains((InterfaceType) type);
          }
          do {
            if (type.equals(whatClassType)) {
              return true;
            }
            whatClassType = whatClassType.superclass();
          } while (whatClassType != null);
          return false;
        }
        return false;
      }
    });
  }

  @NotNull
  public IValueProxy getVariableValue(String varName, StackFrame stackFrame, ThreadReference reference) throws EvaluationException {
    assert stackFrame != null;
    LocalVariable localVariable;
    try {
      localVariable = stackFrame.visibleVariableByName(varName);
    } catch (AbsentInformationException ex) {
      throw new EvaluationException(ex);
    }
    if (localVariable == null) {
      throw new EvaluationException("variable not found: " + varName);
    }
    Value v = stackFrame.getValue(localVariable);
    return MirrorUtil.getInstance().getValueProxy(v, reference);
  }

  @NotNull
  public <T extends IValueProxy> Iterable<T> toIterableProxy(IObjectValueProxy valueProxy) {
    return new IterableProxy<T>(valueProxy);
  }

  @NotNull
  public <T extends IValueProxy> Iterable<T> toIterableProxyFromArray(IArrayValueProxy valueProxy) {
    return new IterableArrayProxy<T>(valueProxy);
  }

  @NotNull
  public IValueProxy invokeStaticMethod(String className, String name, String jniSignature, ThreadReference threadReference, Object... args) throws EvaluationException {
    return MirrorUtil.getInstance().getValueProxy(invokeStaticInternal(className, name, jniSignature, threadReference, args), threadReference);
  }

  @NotNull
  public IValueProxy getStaticField(String className, String fieldName, ThreadReference threadReference) throws InvalidEvaluatedExpressionException {
    return MirrorUtil.getInstance().getValueProxy(getStaticFieldValueInternal(className, fieldName, threadReference), threadReference);
  }

  @NotNull
  public IObjectValueProxy invokeConstructorProxy(String className, String jniSignature, ThreadReference threadReference, Object... args) throws EvaluationException {
    return (IObjectValueProxy) MirrorUtil.getInstance().getValueProxy(invokeConstructorInternal(className, jniSignature, threadReference, args), threadReference);
  }

  public IArrayValueProxy createArrayProxy(String className, ThreadReference threadReference, int size) throws EvaluationException {
    List<ReferenceType> referenceTypes = threadReference.virtualMachine().classesByName(className + "[");
    if (referenceTypes.isEmpty()) {
      throw new EvaluationException("Could not find type " + className + "[]");
    }
    ArrayType arrayType = null;
    for (ReferenceType referenceType : referenceTypes) {
      if (referenceType instanceof ArrayType) {
        arrayType = (ArrayType) referenceType;
        break;
      }
    }
    if (arrayType == null) {
      throw new EvaluationException("Could not find type " + className + "[]");
    }
    ArrayReference arrayReference = arrayType.newInstance(size);
    return (IArrayValueProxy) MirrorUtil.getInstance().getValueProxy(arrayReference, threadReference);
  }

  public final IArrayValueProxy createArrayProxyFromValues(String className, ThreadReference threadReference, Object... args) throws EvaluationException {
    IArrayValueProxy array = EvaluationUtils.createArray(className, threadReference, args.length);
    List<Value> values = MirrorUtil.getInstance().getValues(threadReference, args);
    for (int i = 0; i < values.size(); i++) {
      array.setElement(values.get(i), i);
    }
    return array;
  }

  @NotNull
  public IValueProxy getClass(String className, ThreadReference threadReference) throws InvalidEvaluatedExpressionException {
    ClassType referenceType = (ClassType) findClassType(className, threadReference.virtualMachine());
    ClassObjectReference classObject = referenceType.classObject();
    return MirrorUtil.getInstance().getValueProxy(classObject, threadReference);
  }

  @NotNull
  public IObjectValueProxy boxValue(PrimitiveValueProxy primitiveValueProxy, ThreadReference threadReference) throws EvaluationException {
    PrimitiveValue primitiveValue = primitiveValueProxy.getPrimitiveValue();
    if (primitiveValue instanceof BooleanValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Boolean.class.getName(), "valueOf", "(Z)Ljava/lang/Boolean;", threadReference, primitiveValue.booleanValue());
    }
    if (primitiveValue instanceof ShortValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Short.class.getName(), "valueOf", "(S)Ljava/lang/Short;", threadReference, primitiveValue.shortValue());
    }
    if (primitiveValue instanceof ByteValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Byte.class.getName(), "valueOf", "(B)Ljava/lang/Byte;", threadReference, primitiveValue.byteValue());
    }
    if (primitiveValue instanceof CharValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Character.class.getName(), "valueOf", "(C)Ljava/lang/Character;", threadReference, primitiveValue.charValue());
    }
    if (primitiveValue instanceof DoubleValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Double.class.getName(), "valueOf", "(D)Ljava/lang/Double;", threadReference, primitiveValue.doubleValue());
    }
    if (primitiveValue instanceof FloatValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Float.class.getName(), "valueOf", "(F)Ljava/lang/Float;", threadReference, primitiveValue.floatValue());
    }
    if (primitiveValue instanceof IntegerValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Integer.class.getName(), "valueOf", "(I)Ljava/lang/Integer;", threadReference, primitiveValue.intValue());
    }
    if (primitiveValue instanceof LongValue) {
      return (IObjectValueProxy) EvaluationUtils.invokeStatic(Long.class.getName(), "valueOf", "(J)Ljava/lang/Long;", threadReference, primitiveValue.longValue());
    }
    throw new UnsupportedOperationException("Cant box " + primitiveValue);
  }

  public PrimitiveValueProxy unboxValue(IObjectValueProxy valueProxy) throws EvaluationException {
    Type type = valueProxy.getJDIValue().type();
    if (type.name().equals(Boolean.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("booleanValue", "()Z");
    }
    if (type.name().equals(Short.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("shortValue", "()S");
    }
    if (type.name().equals(Byte.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("byteValue", "()B");
    }
    if (type.name().equals(Character.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("charValue", "()C");
    }
    if (type.name().equals(Double.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("doubleValue", "()D");
    }
    if (type.name().equals(Float.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("floatValue", "()F");
    }
    if (type.name().equals(Integer.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("intValue", "()I");
    }
    if (type.name().equals(Long.class.getName())) {
      return (PrimitiveValueProxy) valueProxy.invokeMethod("longValue", "()J");
    }
    throw new UnsupportedOperationException("Cant unbox value of type" + type);
  }

  public String getStringPresentation(@NotNull final Value value, @NotNull final ThreadReference threadReference) {
    try {
      return MirrorUtil.getInstance().getJavaValue(value).toString();
    } catch (UnsupportedOperationException e) {
      if (value instanceof ArrayReference) {
        ArrayReference array = (ArrayReference) value;
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        int length = array.length();
        int i = 0;
        for (Value item : ListSequence.fromList(array.getValues())) {
          buffer.append(getStringPresentation(item, threadReference));
          if (i < length - 1) {
            buffer.append(", ");
          }
          i++;
        }
        buffer.append("]");
        return buffer.toString();
      } else {
        return EvaluationUtils.consumeEvaluationException(new EvaluationUtils.EvaluationInvocatable<String>() {
          public String invoke() throws EvaluationException {
            ObjectReference object = (ObjectReference) value;
            IObjectValueProxy valueProxy = (IObjectValueProxy) MirrorUtil.getInstance().getValueProxy(object, threadReference);
            SNode toString = new EvaluationUtilsImpl.QuotationClass_wi3cqi_a0a2a0a0a0a0a0a0a0y().createNode();
            IValueProxy result = valueProxy.invokeMethod(SPropertyOperations.getString(toString, "name"), ((String) BehaviorManager.getInstance().invoke(Object.class, toString, "virtual_jniSignature_8847328628797656446", new Class[]{SNode.class})));
            return getStringPresentation(result.getJDIValue(), threadReference);
          }
        }, null);
      }
    }
  }

  public static class QuotationClass_wi3cqi_a0a2a0a0a0a0a0a0a0y {
    public QuotationClass_wi3cqi_a0a2a0a0a0a0a0a0a0y() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_5 = quotedNode_1;
        quotedNode1_5.setProperty("name", "toString");
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.PublicVisibility", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_2;
          quotedNode_1.addChild("visibility", quotedNode1_6);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StatementList", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_7 = quotedNode_3;
          quotedNode_1.addChild("body", quotedNode1_7);
        }
        {
          quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_8 = quotedNode_4;
          quotedNode1_8.addReference(SReference.create("classifier", quotedNode1_8, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)"), SNodeId.fromString("~String")));
          quotedNode_1.addChild("returnType", quotedNode1_8);
        }
        result = quotedNode1_5;
      }
      return result;
    }
  }
}
