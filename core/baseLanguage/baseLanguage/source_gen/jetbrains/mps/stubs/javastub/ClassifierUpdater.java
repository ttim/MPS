package jetbrains.mps.stubs.javastub;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.baseLanguage.structure.Classifier;
import jetbrains.mps.stubs.javastub.asm.ASMClass;
import jetbrains.mps.baseLanguage.structure.Annotation;
import jetbrains.mps.baseLanguage.structure.PublicVisibility;
import jetbrains.mps.baseLanguage.structure.ClassConcept;
import jetbrains.mps.baseLanguage.structure.Interface;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.stubs.javastub.asm.ASMTypeVariable;
import jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration;
import jetbrains.mps.stubs.javastub.asm.ASMFormalTypeParameter;
import jetbrains.mps.stubs.javastub.asm.ASMType;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import jetbrains.mps.stubs.javastub.asm.ASMMethod;
import jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration;
import java.util.Map;
import java.util.HashMap;
import jetbrains.mps.baseLanguage.structure.GenericDeclaration;
import jetbrains.mps.util.IterableUtil;
import jetbrains.mps.baseLanguage.structure.TypeVariableReference;
import jetbrains.mps.stubs.javastub.asm.ASMAnnotation;
import jetbrains.mps.stubs.javastub.asm.ASMField;
import jetbrains.mps.baseLanguage.structure.FieldDeclaration;
import jetbrains.mps.baseLanguage.structure.EnumClass;
import jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration;
import jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration;
import jetbrains.mps.baseLanguage.structure.AnnotationMethodDeclaration;
import jetbrains.mps.baseLanguage.structure.ConstructorDeclaration;
import jetbrains.mps.baseLanguage.structure.StatementList;
import jetbrains.mps.baseLanguage.structure.StubStatementList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.List;
import jetbrains.mps.baseLanguage.structure.ParameterDeclaration;
import jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration;
import jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration;
import jetbrains.mps.stubs.javastub.asm.ASMClassType;
import jetbrains.mps.baseLanguage.structure.Visibility;
import jetbrains.mps.baseLanguage.structure.PrivateVisibility;
import jetbrains.mps.baseLanguage.structure.ProtectedVisibility;
import jetbrains.mps.baseLanguage.structure.AnnotationInstance;
import jetbrains.mps.baseLanguage.structure.AnnotationInstanceValue;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.baseLanguage.structure.IntegerConstant;
import jetbrains.mps.baseLanguage.structure.BooleanConstant;
import jetbrains.mps.baseLanguage.structure.FloatingPointConstant;
import jetbrains.mps.baseLanguage.structure.StringLiteral;
import jetbrains.mps.baseLanguage.structure.ArrayLiteral;
import jetbrains.mps.stubs.javastub.asm.ASMEnumValue;
import jetbrains.mps.baseLanguage.structure.EnumConstantReference;
import jetbrains.mps.baseLanguage.structure.AnnotationInstanceExpression;
import jetbrains.mps.baseLanguage.structure.ClassifierClassExpression;
import jetbrains.mps.stubs.javastub.asm.ASMPrimitiveType;
import jetbrains.mps.baseLanguage.structure.PrimitiveClassExpression;
import jetbrains.mps.baseLanguage.structure.PrimitiveType;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.baseLanguage.structure.BooleanType;
import jetbrains.mps.baseLanguage.structure.ByteType;
import jetbrains.mps.baseLanguage.structure.ShortType;
import jetbrains.mps.baseLanguage.structure.IntegerType;
import jetbrains.mps.baseLanguage.structure.LongType;
import jetbrains.mps.baseLanguage.structure.FloatType;
import jetbrains.mps.baseLanguage.structure.DoubleType;
import jetbrains.mps.baseLanguage.structure.VoidType;
import jetbrains.mps.baseLanguage.structure.CharType;
import jetbrains.mps.stubs.javastub.asm.ASMArrayType;
import jetbrains.mps.baseLanguage.structure.ArrayType;
import jetbrains.mps.stubs.javastub.asm.ASMVarArgType;
import jetbrains.mps.baseLanguage.structure.VariableArityType;
import jetbrains.mps.stubs.javastub.asm.ASMParameterizedType;
import jetbrains.mps.stubs.javastub.asm.ASMExtendsType;
import jetbrains.mps.baseLanguage.structure.WildCardType;
import jetbrains.mps.baseLanguage.structure.UpperBoundType;
import jetbrains.mps.stubs.javastub.asm.ASMSuperType;
import jetbrains.mps.baseLanguage.structure.LowerBoundType;
import jetbrains.mps.stubs.javastub.asm.ASMUnboundedType;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.util.NodeNameUtil;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.stubs.javastub.classpath.StubHelper;

public class ClassifierUpdater {
  private static final Logger LOG = Logger.getLogger(ClassifierUpdater.class);

  public ClassifierUpdater() {
  }

  public void updateClassifier(final Classifier clsfr, ASMClass ac) {
    if (clsfr instanceof Annotation) {
      final Annotation annotation = (Annotation) clsfr;
      if (ac.isPublic()) {
        annotation.setVisibility(PublicVisibility.newInstance(clsfr.getModel()));
      } else {
        annotation.setVisibility(null);
      }
      updateAnnotationMethods(ac, annotation);
      updateAnnotations(ac, annotation);
    } else if (clsfr instanceof ClassConcept) {
      final ClassConcept cls = (ClassConcept) clsfr;
      if (ac.isPublic()) {
        cls.setVisibility(PublicVisibility.newInstance(clsfr.getModel()));
      } else {
        cls.setVisibility(null);
      }
      cls.setAbstractClass(ac.isAbstract());
      cls.setIsDeprecated(ac.isDeprecated());
      updateAnnotations(ac, cls);
      updateTypeVariables(ac, cls.getModel(), cls);
      updateExtendsAndImplements(ac, cls);
      updateInstanceFields(ac, cls);
      updateStaticFields(ac, cls);
      updateConstructors(ac, cls);
      updateInstanceMethods(ac, cls);
      updateStaticMethods(ac, cls);
      cls.setIsFinal(ac.isFinal());
    } else if (clsfr instanceof Interface) {
      final Interface intfc = (Interface) clsfr;
      if (ac.isPublic()) {
        intfc.setVisibility(PublicVisibility.newInstance(clsfr.getModel()));
      } else {
        intfc.setVisibility(null);
      }
      intfc.setIsDeprecated(ac.isDeprecated());
      updateAnnotations(ac, intfc);
      updateTypeVariables(ac, intfc.getModel(), intfc);
      updateExtendsForInterface(ac, intfc);
      updateStaticFields(ac, intfc);
      updateInstanceMethods(ac, intfc);
    }
  }

  private void updateTypeVariables(ASMClass cls, SModel model, Classifier result) {
    for (ASMTypeVariable tv : cls.getTypeParameters()) {
      TypeVariableDeclaration typeVariableDeclaration = TypeVariableDeclaration.newInstance(model);
      typeVariableDeclaration.setName(tv.getName());
      result.addTypeVariableDeclaration(typeVariableDeclaration);
      if (tv instanceof ASMFormalTypeParameter) {
        ASMFormalTypeParameter tp = (ASMFormalTypeParameter) tv;
        if (tp.getClassBound() != null) {
          typeVariableDeclaration.setBound(getTypeByASMType(tp.getClassBound(), null, result, model));
        }
        for (ASMType act : tp.getInterfaceBounds()) {
          typeVariableDeclaration.addAuxBounds((ClassifierType) getTypeByASMType(act, null, result, model));
        }
      }
    }
  }

  private void updateTypeVariables(ASMMethod method, SModel model, BaseMethodDeclaration result, Classifier cls) {
    Map<ASMTypeVariable, TypeVariableDeclaration> typeVars = new HashMap<ASMTypeVariable, TypeVariableDeclaration>();
    for (ASMTypeVariable tv : method.getTypeParameters()) {
      TypeVariableDeclaration typeVariableDeclaration = TypeVariableDeclaration.newInstance(model);
      typeVariableDeclaration.setName(tv.getName());
      result.addTypeVariableDeclaration(typeVariableDeclaration);
      typeVars.put(tv, typeVariableDeclaration);
    }
    for (ASMTypeVariable tv : method.getTypeParameters()) {
      TypeVariableDeclaration typeVariableDeclaration = typeVars.get(tv);
      if (tv instanceof ASMFormalTypeParameter) {
        ASMFormalTypeParameter tp = (ASMFormalTypeParameter) tv;
        if (tp.getClassBound() != null) {
          typeVariableDeclaration.setBound(getTypeByASMType(tp.getClassBound(), result, cls, model));
        }
        for (ASMType act : tp.getInterfaceBounds()) {
          typeVariableDeclaration.addAuxBounds((ClassifierType) getTypeByASMType(act, result, cls, model));
        }
      }
    }
  }

  private TypeVariableDeclaration findTypeVariableDeclaration(GenericDeclaration genDecl, String name) {
    for (TypeVariableDeclaration tvd : IterableUtil.asIterable(genDecl.typeVariableDeclarations())) {
      if (name.equals(tvd.getName())) {
        return tvd;
      }
    }
    return null;
  }

  private TypeVariableReference createTypeVariableReference(GenericDeclaration genDecl, String name) {
    TypeVariableReference result = TypeVariableReference.newInstance(genDecl.getModel());
    result.setTypeVariableDeclaration(findTypeVariableDeclaration(genDecl, name));
    return result;
  }

  private void updateAnnotations(ASMClass ac, Classifier cls) {
    for (ASMAnnotation annotation : ac.getAnnotations()) {
      cls.addAnnotation(createAnnotation(annotation, cls.getModel()));
    }
  }

  private void updateExtendsForInterface(ASMClass ac, Interface intfc) {
    SModel model = intfc.getModel();
    for (ASMType type : ac.getGenericInterfaces()) {
      ClassifierType classifierType = (ClassifierType) getTypeByASMType(type, null, intfc, model);
      intfc.addExtendedInterface(classifierType);
    }
  }

  private void updateExtendsAndImplements(ASMClass ac, ClassConcept cls) {
    SModel model = cls.getModel();
    ASMType refSuperclass = ac.getGenericSuperclass();
    if (refSuperclass != null) {
      ClassifierType classifierType = (ClassifierType) getTypeByASMType(refSuperclass, null, cls, model);
      cls.setSuperclass(classifierType);
    }
    for (ClassifierType itype : cls.getImplementedInterfaces()) {
      itype.delete();
    }
    for (ASMType type : ac.getGenericInterfaces()) {
      ClassifierType classifierType = (ClassifierType) getTypeByASMType(type, null, cls, model);
      cls.addImplementedInterface(classifierType);
    }
  }

  private void updateInstanceFields(ASMClass refCls, ClassConcept cls) {
    SModel model = cls.getModel();
    for (ASMField field : refCls.getDeclaredFields()) {
      if (field.isPrivate() && ASMModelLoader.SKIP_PRIVATE) {
        continue;
      }
      if (field.isStatic()) {
        continue;
      }
      if (field.isCompilerGenerated()) {
        continue;
      }
      FieldDeclaration decl = FieldDeclaration.newInstance(model);
      decl.getNode().setId(ASMNodeId.createId(refCls, field));
      decl.setVisibility(createVisibility(field, model));
      decl.setName(field.getName());
      decl.setType(getTypeByASMType(field.getGenericType(), null, cls, model));
      decl.setIsDeprecated(field.isDeprecated());
      for (ASMAnnotation annotation : field.getAnnotations()) {
        decl.addAnnotation(createAnnotation(annotation, model));
      }
      cls.addField(decl);
    }
  }

  private void updateStaticFields(ASMClass ac, Classifier cls) {
    SModel model = cls.getModel();
    for (ASMField field : ac.getDeclaredFields()) {
      if (field.isPrivate() && ASMModelLoader.SKIP_PRIVATE) {
        continue;
      }
      if (!(field.isStatic())) {
        continue;
      }
      if (field.isCompilerGenerated()) {
        continue;
      }
      if (field.isEnumConstant()) {
        EnumClass enumClass = (EnumClass) cls;
        EnumConstantDeclaration enumConstantDeclaration = EnumConstantDeclaration.newInstance(model);
        enumConstantDeclaration.getNode().setId(ASMNodeId.createId(ac, field));
        enumConstantDeclaration.setName(field.getName());
        enumClass.addEnumConstant(enumConstantDeclaration);
      } else {
        StaticFieldDeclaration decl = StaticFieldDeclaration.newInstance(model);
        decl.getNode().setId(ASMNodeId.createId(ac, field));
        decl.setVisibility(createVisibility(field, model));
        decl.setName(field.getName());
        decl.setType(getTypeByASMType(field.getGenericType(), null, cls, model));
        decl.setIsDeprecated(field.isDeprecated());
        for (ASMAnnotation annotation : field.getAnnotations()) {
          decl.addAnnotation(createAnnotation(annotation, model));
        }
        cls.addStaticField(decl);
      }
    }
  }

  private void updateAnnotationMethods(ASMClass refCls, Annotation annotation) {
    SModel model = annotation.getModel();
    for (ASMMethod m : refCls.getDeclaredMethods()) {
      AnnotationMethodDeclaration methodDeclaration = AnnotationMethodDeclaration.newInstance(model);
      methodDeclaration.getNode().setId(ASMNodeId.createId(refCls, m));
      methodDeclaration.setVisibility(PublicVisibility.newInstance(model));
      methodDeclaration.setName(m.getName());
      methodDeclaration.setReturnType(getTypeByASMType(m.getGenericReturnType(), null, annotation, model));
      methodDeclaration.getNode().setId(ASMNodeId.createAnnotationMethodId(refCls.getFqName(), m.getName()));
      if (m.getAnnotationDefault() != null) {
        methodDeclaration.setDefaultValue(getAnnotationValue(m.getAnnotationDefault(), model));
      }
      annotation.addMethod(methodDeclaration);
    }
  }

  private void updateConstructors(ASMClass ac, ClassConcept cls) {
    SModel model = cls.getModel();
    for (ASMMethod c : ac.getDeclaredConstructors()) {
      if (c.isPrivate() && ASMModelLoader.SKIP_PRIVATE) {
        continue;
      }
      ConstructorDeclaration constructor = ConstructorDeclaration.newInstance(model);
      constructor.getNode().setId(ASMNodeId.createId(ac, c));
      constructor.setBody(((StatementList) ((StubStatementList) SNodeOperations.getAdapter((SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.StubStatementList", null))))));

      constructor.setVisibility(createVisibility(c, model));
      constructor.setIsDeprecated(c.isDeprecated());
      for (ASMTypeVariable tv : c.getTypeParameters()) {
        TypeVariableDeclaration typeVariableDeclaration = TypeVariableDeclaration.newInstance(cls.getModel());
        typeVariableDeclaration.setName(tv.getName());
        constructor.addTypeVariableDeclaration(typeVariableDeclaration);
      }
      constructor.setName(cls.getName());
      List<ASMType> parameterType = c.getGenericParameterTypes();
      List<String> parameterNames = c.getParameterNames();
      for (int i = 0; i < parameterType.size(); i++) {
        ASMType pt = parameterType.get(i);
        ParameterDeclaration pd = ParameterDeclaration.newInstance(model);
        pd.setName(parameterNames.get(i));
        pd.setType(getTypeByASMType(pt, constructor, cls, model));
        addAnnotationsToParameter(pd, c.getParameterAnnotations().get(i));
        constructor.addParameter(pd);
      }
      for (ASMAnnotation annotation : c.getAnnotations()) {
        constructor.addAnnotation(createAnnotation(annotation, model));
      }
      for (ASMType exception : c.getExceptionTypes()) {
        constructor.addThrowsItem(getTypeByASMType(exception, constructor, cls, model));
      }
      cls.addConstructor(constructor);
    }
  }

  private void updateInstanceMethods(ASMClass ac, Classifier cls) {
    SModel model = cls.getModel();
    for (ASMMethod m : ac.getDeclaredMethods()) {
      if (m.isPrivate() && ASMModelLoader.SKIP_PRIVATE) {
        continue;
      }
      if (m.isStatic()) {
        continue;
      }
      if (m.isBridge()) {
        continue;
      }
      if (m.isCompilerGenerated()) {
        continue;
      }
      InstanceMethodDeclaration methodDeclaration = InstanceMethodDeclaration.newInstance(model);
      methodDeclaration.getNode().setId(ASMNodeId.createId(ac, m));
      methodDeclaration.setBody(((StatementList) ((StubStatementList) SNodeOperations.getAdapter((SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.StubStatementList", null))))));
      methodDeclaration.setVisibility(createVisibility(m, model));
      methodDeclaration.setIsFinal(m.isFinal());
      methodDeclaration.setIsAbstract(m.isAbstract());
      methodDeclaration.setIsDeprecated(m.isDeprecated());
      updateTypeVariables(m, model, methodDeclaration, cls);
      methodDeclaration.setName(m.getName());
      methodDeclaration.setReturnType(getTypeByASMType(m.getGenericReturnType(), methodDeclaration, cls, model));
      List<ASMType> parameterTypes = m.getGenericParameterTypes();
      List<String> parameterNames = m.getParameterNames();
      for (int i = 0; i < parameterTypes.size(); i++) {
        ASMType paramType = parameterTypes.get(i);
        ParameterDeclaration parameterDeclaration = ParameterDeclaration.newInstance(model);
        parameterDeclaration.setName(parameterNames.get(i));
        parameterDeclaration.setType(getTypeByASMType(paramType, methodDeclaration, cls, model));
        addAnnotationsToParameter(parameterDeclaration, m.getParameterAnnotations().get(i));
        methodDeclaration.addParameter(parameterDeclaration);
      }
      for (ASMType exception : m.getExceptionTypes()) {
        methodDeclaration.addThrowsItem(getTypeByASMType(exception, methodDeclaration, cls, model));
      }
      for (ASMAnnotation annotation : m.getAnnotations()) {
        methodDeclaration.addAnnotation(createAnnotation(annotation, model));
      }
      cls.addMethod(methodDeclaration);
    }
  }

  private void updateStaticMethods(ASMClass ac, ClassConcept cls) {
    SModel model = cls.getModel();
    for (ASMMethod m : ac.getDeclaredMethods()) {
      if (m.isPrivate() && ASMModelLoader.SKIP_PRIVATE) {
        continue;
      }
      if (!(m.isStatic())) {
        continue;
      }
      if (m.isCompilerGenerated()) {
        continue;
      }
      if (cls instanceof EnumClass && isGeneratedEnumMethod(m)) {
        continue;
      }
      StaticMethodDeclaration methodDeclaration = StaticMethodDeclaration.newInstance(model);
      methodDeclaration.getNode().setId(ASMNodeId.createId(ac, m));
      methodDeclaration.setBody(((StatementList) ((StubStatementList) SNodeOperations.getAdapter((SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.StubStatementList", null))))));
      methodDeclaration.setVisibility(createVisibility(m, model));
      methodDeclaration.setIsDeprecated(m.isDeprecated());
      if (m.isFinal()) {
        methodDeclaration.setIsFinal(true);
      }
      updateTypeVariables(m, model, methodDeclaration, cls);
      methodDeclaration.setName(m.getName());
      methodDeclaration.setReturnType(getTypeByASMType(m.getGenericReturnType(), methodDeclaration, cls, model));
      List<ASMType> parameterTypes = m.getGenericParameterTypes();
      List<String> parameterNames = m.getParameterNames();
      for (int i = 0; i < parameterTypes.size(); i++) {
        ASMType paramType = parameterTypes.get(i);
        ParameterDeclaration parameterDeclaration = ParameterDeclaration.newInstance(model);
        parameterDeclaration.setName(parameterNames.get(i));
        parameterDeclaration.setType(getTypeByASMType(paramType, methodDeclaration, cls, model));
        addAnnotationsToParameter(parameterDeclaration, m.getParameterAnnotations().get(i));
        methodDeclaration.addParameter(parameterDeclaration);
      }
      for (ASMAnnotation annotation : m.getAnnotations()) {
        methodDeclaration.addAnnotation(createAnnotation(annotation, model));
      }
      for (ASMType exception : m.getExceptionTypes()) {
        methodDeclaration.addThrowsItem(getTypeByASMType(exception, methodDeclaration, cls, model));
      }
      cls.addStaticMethod(methodDeclaration);
    }
  }

  private boolean isGeneratedEnumMethod(ASMMethod m) {
    if (m.getName().equals("values") && m.getParameterTypes().isEmpty()) {
      return true;
    }
    if (m.getName().equals("valueOf") && m.getParameterTypes().size() == 1 && m.getParameterTypes().get(0) instanceof ASMClassType) {
      ASMClassType type = (ASMClassType) m.getParameterTypes().get(0);
      return type.getName().equals("java.lang.String");
    }
    return false;
  }

  protected Visibility createVisibility(ASMMethod m, SModel model) {
    if (m.isPublic()) {
      return PublicVisibility.newInstance(model);
    }
    if (m.isPrivate()) {
      return PrivateVisibility.newInstance(model);
    }
    if (m.isProtected()) {
      return ProtectedVisibility.newInstance(model);
    }
    return null;
  }

  protected Visibility createVisibility(ASMField f, SModel model) {
    if (f.isPublic()) {
      return PublicVisibility.newInstance(model);
    }
    if (f.isPrivate()) {
      return PrivateVisibility.newInstance(model);
    }
    if (f.isProtected()) {
      return ProtectedVisibility.newInstance(model);
    }
    return null;
  }

  private void addAnnotationsToParameter(ParameterDeclaration pd, List<ASMAnnotation> annotations) {
    for (ASMAnnotation a : annotations) {
      pd.addAnnotation(createAnnotation(a, pd.getModel()));
    }
  }

  private AnnotationInstance createAnnotation(ASMAnnotation annotation, SModel model) {
    AnnotationInstance result = AnnotationInstance.newInstance(model);
    ASMClassType c = (ASMClassType) annotation.getType();
    addClassifierReference(result.getNode(), AnnotationInstance.ANNOTATION, c);
    Map<String, Object> values = annotation.getValues();
    for (String key : values.keySet()) {
      AnnotationInstanceValue value = AnnotationInstanceValue.newInstance(model);
      addAnnotationMethodReference(value.getNode(), AnnotationInstanceValue.KEY, c, key);
      value.setValue(getAnnotationValue(values.get(key), model));
      result.addValue(value);
    }
    return result;
  }

  private Expression getAnnotationValue(Object value, SModel model) {
    if (value instanceof Byte) {
      Byte b = (Byte) value;
      IntegerConstant res = IntegerConstant.newInstance(model);
      res.setValue(b);
      return res;
    }
    if (value instanceof Boolean) {
      Boolean b = (Boolean) value;
      BooleanConstant res = BooleanConstant.newInstance(model);
      res.setValue(b);
      return res;
    }
    if (value instanceof Character) {
      return null;
    }
    if (value instanceof Short) {
      Short s = (Short) value;
      IntegerConstant res = IntegerConstant.newInstance(model);
      res.setValue(s);
      return res;
    }
    if (value instanceof Integer) {
      Integer i = (Integer) value;
      IntegerConstant res = IntegerConstant.newInstance(model);
      res.setValue(i);
      return res;
    }
    if (value instanceof Long) {
      return null;
    }
    if (value instanceof Float) {
      Float f = (Float) value;
      FloatingPointConstant res = FloatingPointConstant.newInstance(model);
      res.setValue("" + f);
      return res;
    }
    if (value instanceof Double) {
      Double d = (Double) value;
      FloatingPointConstant res = FloatingPointConstant.newInstance(model);
      res.setValue("" + d);
      return res;
    }
    if (value instanceof String) {
      String s = (String) value;
      StringLiteral res = StringLiteral.newInstance(model);
      res.setValue(s);
      return res;
    }
    if (value instanceof List) {
      List<Object> list = (List) value;
      ArrayLiteral res = ArrayLiteral.newInstance(model);
      for (Object o : list) {
        Expression annotationValue = getAnnotationValue(o, model);
        if (annotationValue != null) {
          res.addItem(annotationValue);
        }
      }
      return res;
    }
    if (value instanceof ASMEnumValue) {
      ASMEnumValue enumValue = (ASMEnumValue) value;
      EnumConstantReference res = EnumConstantReference.newInstance(model);
      ASMClassType c = (ASMClassType) enumValue.getType();
      addClassifierReference(res.getNode(), EnumConstantReference.ENUM_CLASS, c);
      addEnumConstReference(res.getNode(), EnumConstantReference.ENUM_CONSTANT_DECLARATION, enumValue);
      return res;
    }
    if (value instanceof ASMAnnotation) {
      ASMAnnotation annotation = (ASMAnnotation) value;
      AnnotationInstanceExpression res = AnnotationInstanceExpression.newInstance(model);
      res.setAnnotationInstance(createAnnotation(annotation, model));
      return res;
    }
    if (value instanceof ASMClassType) {
      ASMClassType classType = (ASMClassType) value;
      ClassifierClassExpression res = ClassifierClassExpression.newInstance(model);
      addClassifierReference(res.getNode(), ClassifierClassExpression.CLASSIFIER, classType);
      return res;
    }
    if (value instanceof ASMPrimitiveType) {
      ASMPrimitiveType primitiveType = (ASMPrimitiveType) value;
      PrimitiveClassExpression res = PrimitiveClassExpression.newInstance(model);
      res.setPrimitiveType((PrimitiveType) getTypeByASMType(primitiveType, null, null, model));
      return res;
    }
    LOG.error("couldn't create annotation value from " + ((value == null ?
      "" :
      value.getClass().getName()
    )) + " : " + value);
    return null;
  }

  private Type getTypeByASMType(ASMType type, BaseMethodDeclaration method, Classifier classifier, SModel model) {
    if (type == ASMPrimitiveType.BOOLEAN) {
      return BooleanType.newInstance(model);
    }
    if (type == ASMPrimitiveType.BYTE) {
      return ByteType.newInstance(model);
    }
    if (type == ASMPrimitiveType.SHORT) {
      return ShortType.newInstance(model);
    }
    if (type == ASMPrimitiveType.INT) {
      return IntegerType.newInstance(model);
    }
    if (type == ASMPrimitiveType.LONG) {
      return LongType.newInstance(model);
    }
    if (type == ASMPrimitiveType.FLOAT) {
      return FloatType.newInstance(model);
    }
    if (type == ASMPrimitiveType.DOUBLE) {
      return DoubleType.newInstance(model);
    }
    if (type == ASMPrimitiveType.VOID) {
      return VoidType.newInstance(model);
    }
    if (type == ASMPrimitiveType.CHAR) {
      return CharType.newInstance(model);
    }
    if (type instanceof ASMArrayType) {
      ASMArrayType array = (ASMArrayType) type;
      Type componentType = getTypeByASMType(array.getElementType(), method, classifier, model);
      ArrayType result = ArrayType.newInstance(model);
      result.setComponentType(componentType);
      return result;
    }
    if (type instanceof ASMVarArgType) {
      ASMVarArgType varArgType = (ASMVarArgType) type;
      Type componentType = getTypeByASMType(varArgType.getElementType(), method, classifier, model);
      VariableArityType result = VariableArityType.newInstance(model);
      result.setComponentType(componentType);
      return result;
    }
    if (type instanceof ASMTypeVariable) {
      ASMTypeVariable tv = (ASMTypeVariable) type;
      if (method != null && findTypeVariableDeclaration(method, tv.getName()) != null) {
        return createTypeVariableReference(method, tv.getName());
      } else
      if (findTypeVariableDeclaration(classifier, tv.getName()) != null) {
        return createTypeVariableReference(classifier, tv.getName());
      } else {
        return getTypeByASMType(ASMClassType.OBJECT, method, classifier, model);
      }
    }
    if (type instanceof ASMClassType) {
      ASMClassType c = (ASMClassType) type;
      ClassifierType classifierType = ClassifierType.newInstance(model);
      addClassifierReference(classifierType.getNode(), ClassifierType.CLASSIFIER, c);
      return classifierType;
    }
    if (type instanceof ASMParameterizedType) {
      ASMParameterizedType pt = (ASMParameterizedType) type;
      ClassifierType rawType = (ClassifierType) getTypeByASMType(pt.getRawType(), method, classifier, model);
      addTypeParameters(pt.getActualTypeArguments(), method, classifier, rawType);
      return rawType;
    }
    if (type instanceof ASMExtendsType) {
      ASMExtendsType e = (ASMExtendsType) type;
      if (e.getBase() instanceof ASMClassType) {
        ASMClassType ct = (ASMClassType) e.getBase();
        if (ct.getName().equals("java.lang.Object")) {
          return WildCardType.newInstance(model);
        }
      }
      UpperBoundType r = UpperBoundType.newInstance(model);
      r.setBound(getTypeByASMType(e.getBase(), method, classifier, model));
      return r;
    }
    if (type instanceof ASMSuperType) {
      ASMSuperType e = (ASMSuperType) type;
      LowerBoundType r = LowerBoundType.newInstance(model);
      r.setBound(getTypeByASMType(e.getBase(), method, classifier, model));
      return r;
    }
    if (type instanceof ASMUnboundedType) {
      WildCardType w = WildCardType.newInstance(model);
      return w;
    }
    Type result = Type.newInstance(model);
    LOG.error("Can't convert type " + type + " class : ", result);
    return result;
  }

  private void addTypeParameters(List<? extends ASMType> typeParameters, BaseMethodDeclaration method, Classifier classifier, ClassifierType result) {
    List<Type> toAdd = new ArrayList<Type>();
    for (ASMType tv : typeParameters) {
      Type type = getTypeByASMType(tv, method, classifier, result.getModel());
      if (type == null) {
        toAdd.clear();
        break;
      }
      toAdd.add(type);
    }
    for (Type tvr : toAdd) {
      result.addParameter(tvr);
    }
  }

  private void addClassifierReference(SNode sourceNode, String role, ASMClassType clsType) {
    if (sourceNode.getReferent(role) != null) {
      return;
    }

    SModelReference targetModelRef = getModelReferenceFor(NodeNameUtil.getNamespace(clsType.getName()));
    SNodeId nodeId = ASMNodeId.createId(clsType.getName());

    sourceNode.addReference(SReference.create(role, sourceNode, targetModelRef, nodeId));
  }

  private void addAnnotationMethodReference(SNode sourceNode, String role, ASMClassType annotationType, String method) {
    if (sourceNode.getReferent(role) != null) {
      return;
    }

    SModelReference targetRef = getModelReferenceFor(NodeNameUtil.getNamespace(annotationType.getName()));
    SNodeId nodeId = ASMNodeId.createAnnotationMethodId(annotationType.getName(), method);
    sourceNode.addReference(SReference.create(role, sourceNode, targetRef, nodeId));
  }

  private void addEnumConstReference(SNode sourceNode, String role, ASMEnumValue enumValue) {
    if (sourceNode.getReferent(role) != null) {
      return;
    }

    ASMClassType classType = (ASMClassType) enumValue.getType();
    SModelReference targetRef = getModelReferenceFor(NodeNameUtil.getNamespace(classType.getName()));
    SNodeId nodeId = ASMNodeId.createFieldId(classType.getName(), enumValue.getConstant());
    sourceNode.addReference(SReference.create(role, sourceNode, targetRef, nodeId));
  }

  public SModelReference getModelReferenceFor(String packageName) {
    return StubHelper.uidForPackageInStubs(packageName);
  }
}
