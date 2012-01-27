package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.baseLanguage.structure.AbstractClassifierReference", "jetbrains.mps.baseLanguage.structure.AbstractUnaryNumberOperation", "jetbrains.mps.baseLanguage.structure.AdditionalForLoopVariable", "jetbrains.mps.baseLanguage.structure.AndAssignmentExpression", "jetbrains.mps.baseLanguage.structure.AndExpression", "jetbrains.mps.baseLanguage.structure.Annotation", "jetbrains.mps.baseLanguage.structure.AnnotationInstance", "jetbrains.mps.baseLanguage.structure.AnnotationInstanceExpression", "jetbrains.mps.baseLanguage.structure.AnnotationInstanceValue", "jetbrains.mps.baseLanguage.structure.AnnotationMethodDeclaration", "jetbrains.mps.baseLanguage.structure.AnonymousClass", "jetbrains.mps.baseLanguage.structure.AnonymousClassCreator", "jetbrains.mps.baseLanguage.structure.ArrayAccessExpression", "jetbrains.mps.baseLanguage.structure.ArrayCloneOperation", "jetbrains.mps.baseLanguage.structure.ArrayCreator", "jetbrains.mps.baseLanguage.structure.ArrayCreatorWithInitializer", "jetbrains.mps.baseLanguage.structure.ArrayLengthOperation", "jetbrains.mps.baseLanguage.structure.ArrayLiteral", "jetbrains.mps.baseLanguage.structure.ArrayType", "jetbrains.mps.baseLanguage.structure.AsExpression", "jetbrains.mps.baseLanguage.structure.AssertStatement", "jetbrains.mps.baseLanguage.structure.AssignmentExpression", "jetbrains.mps.baseLanguage.structure.BLBottomType", "jetbrains.mps.baseLanguage.structure.BaseVariableDeclaration", "jetbrains.mps.baseLanguage.structure.BitwiseAndExpression", "jetbrains.mps.baseLanguage.structure.BitwiseNotExpression", "jetbrains.mps.baseLanguage.structure.BitwiseOrExpression", "jetbrains.mps.baseLanguage.structure.BitwiseXorExpression", "jetbrains.mps.baseLanguage.structure.BlockStatement", "jetbrains.mps.baseLanguage.structure.BooleanConstant", "jetbrains.mps.baseLanguage.structure.BooleanType", "jetbrains.mps.baseLanguage.structure.BreakStatement", "jetbrains.mps.baseLanguage.structure.ByteType", "jetbrains.mps.baseLanguage.structure.CastExpression", "jetbrains.mps.baseLanguage.structure.CatchClause", "jetbrains.mps.baseLanguage.structure.CharConstant", "jetbrains.mps.baseLanguage.structure.CharType", "jetbrains.mps.baseLanguage.structure.ClassConcept", "jetbrains.mps.baseLanguage.structure.ClassCreator", "jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", "jetbrains.mps.baseLanguage.structure.ClassifierType", "jetbrains.mps.baseLanguage.structure.ClosureParameterReference", "jetbrains.mps.baseLanguage.structure.CommentedStatement", "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration", "jetbrains.mps.baseLanguage.structure.ContinueStatement", "jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation", "jetbrains.mps.baseLanguage.structure.DefaultGetAccessor", "jetbrains.mps.baseLanguage.structure.DefaultPropertyImplementation", "jetbrains.mps.baseLanguage.structure.DefaultSetAccessor", "jetbrains.mps.baseLanguage.structure.DimensionExpression", "jetbrains.mps.baseLanguage.structure.DivAssignmentExpression", "jetbrains.mps.baseLanguage.structure.DivExpression", "jetbrains.mps.baseLanguage.structure.DoWhileStatement", "jetbrains.mps.baseLanguage.structure.DotExpression", "jetbrains.mps.baseLanguage.structure.DoubleType", "jetbrains.mps.baseLanguage.structure.ElsifClause", "jetbrains.mps.baseLanguage.structure.EnumClass", "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration", "jetbrains.mps.baseLanguage.structure.EnumConstantReference", "jetbrains.mps.baseLanguage.structure.EnumValueOfExpression", "jetbrains.mps.baseLanguage.structure.EnumValuesExpression", "jetbrains.mps.baseLanguage.structure.EqualsExpression", "jetbrains.mps.baseLanguage.structure.EscapeOperation", "jetbrains.mps.baseLanguage.structure.ExpressionStatement", "jetbrains.mps.baseLanguage.structure.FieldDeclaration", "jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", "jetbrains.mps.baseLanguage.structure.FloatType", "jetbrains.mps.baseLanguage.structure.FloatingPointConstant", "jetbrains.mps.baseLanguage.structure.FloatingPointFloatConstant", "jetbrains.mps.baseLanguage.structure.ForStatement", "jetbrains.mps.baseLanguage.structure.ForeachStatement", "jetbrains.mps.baseLanguage.structure.GenericNewExpression", "jetbrains.mps.baseLanguage.structure.GetAccessor", "jetbrains.mps.baseLanguage.structure.GreaterThanExpression", "jetbrains.mps.baseLanguage.structure.GreaterThanOrEqualsExpression", "jetbrains.mps.baseLanguage.structure.HexIntegerLiteral", "jetbrains.mps.baseLanguage.structure.IfStatement", "jetbrains.mps.baseLanguage.structure.ImplicitAnnotationInstanceValue", "jetbrains.mps.baseLanguage.structure.InstanceInitializer", "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation", "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration", "jetbrains.mps.baseLanguage.structure.InstanceOfExpression", "jetbrains.mps.baseLanguage.structure.IntegerConstant", "jetbrains.mps.baseLanguage.structure.IntegerType", "jetbrains.mps.baseLanguage.structure.Interface", "jetbrains.mps.baseLanguage.structure.IsEmptyOperation", "jetbrains.mps.baseLanguage.structure.IsNotEmptyOperation", "jetbrains.mps.baseLanguage.structure.LeftShiftAssignmentExpression", "jetbrains.mps.baseLanguage.structure.LessThanExpression", "jetbrains.mps.baseLanguage.structure.LessThanOrEqualsExpression", "jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference", "jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall", "jetbrains.mps.baseLanguage.structure.LocalPropertyReference", "jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference", "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall", "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration", "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement", "jetbrains.mps.baseLanguage.structure.LocalVariableReference", "jetbrains.mps.baseLanguage.structure.LongLiteral", "jetbrains.mps.baseLanguage.structure.LongType", "jetbrains.mps.baseLanguage.structure.LoopLabel", "jetbrains.mps.baseLanguage.structure.LoopLabelReference", "jetbrains.mps.baseLanguage.structure.LowerBoundType", "jetbrains.mps.baseLanguage.structure.MinusAssignmentExpression", "jetbrains.mps.baseLanguage.structure.MinusExpression", "jetbrains.mps.baseLanguage.structure.MulAssignmentExpression", "jetbrains.mps.baseLanguage.structure.MulExpression", "jetbrains.mps.baseLanguage.structure.NPEEqualsExpression", "jetbrains.mps.baseLanguage.structure.NPENotEqualsExpression", "jetbrains.mps.baseLanguage.structure.NotEqualsExpression", "jetbrains.mps.baseLanguage.structure.NotExpression", "jetbrains.mps.baseLanguage.structure.NullLiteral", "jetbrains.mps.baseLanguage.structure.NullType", "jetbrains.mps.baseLanguage.structure.Number", "jetbrains.mps.baseLanguage.structure.OperationAssignmentExpression", "jetbrains.mps.baseLanguage.structure.OrAssignmentExpression", "jetbrains.mps.baseLanguage.structure.OrExpression", "jetbrains.mps.baseLanguage.structure.ParameterDeclaration", "jetbrains.mps.baseLanguage.structure.ParameterReference", "jetbrains.mps.baseLanguage.structure.ParenthesizedExpression", "jetbrains.mps.baseLanguage.structure.PlaceholderMethodDeclaration", "jetbrains.mps.baseLanguage.structure.PlusAssignmentExpression", "jetbrains.mps.baseLanguage.structure.PlusExpression", "jetbrains.mps.baseLanguage.structure.PostfixDecrementExpression", "jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression", "jetbrains.mps.baseLanguage.structure.PrefixDecrementExpression", "jetbrains.mps.baseLanguage.structure.PrefixIncrementExpression", "jetbrains.mps.baseLanguage.structure.PrimitiveClassExpression", "jetbrains.mps.baseLanguage.structure.PrivateVisibility", "jetbrains.mps.baseLanguage.structure.Property", "jetbrains.mps.baseLanguage.structure.PropertyReference", "jetbrains.mps.baseLanguage.structure.ProtectedVisibility", "jetbrains.mps.baseLanguage.structure.PublicVisibility", "jetbrains.mps.baseLanguage.structure.RemAssignmentExpression", "jetbrains.mps.baseLanguage.structure.RemExpression", "jetbrains.mps.baseLanguage.structure.RemarkStatement", "jetbrains.mps.baseLanguage.structure.ReturnStatement", "jetbrains.mps.baseLanguage.structure.RightShiftAssignmentExpression", "jetbrains.mps.baseLanguage.structure.SetAccessor", "jetbrains.mps.baseLanguage.structure.ShiftLeftExpression", "jetbrains.mps.baseLanguage.structure.ShiftRightExpression", "jetbrains.mps.baseLanguage.structure.ShiftRightUnsignedExpression", "jetbrains.mps.baseLanguage.structure.ShortType", "jetbrains.mps.baseLanguage.structure.SingleLineComment", "jetbrains.mps.baseLanguage.structure.Statement", "jetbrains.mps.baseLanguage.structure.StatementCommentPart", "jetbrains.mps.baseLanguage.structure.StatementList", "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration", "jetbrains.mps.baseLanguage.structure.StaticFieldReference", "jetbrains.mps.baseLanguage.structure.StaticInitializer", "jetbrains.mps.baseLanguage.structure.StaticMethodCall", "jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration", "jetbrains.mps.baseLanguage.structure.StringLiteral", "jetbrains.mps.baseLanguage.structure.StringType", "jetbrains.mps.baseLanguage.structure.StubStatementList", "jetbrains.mps.baseLanguage.structure.SubstringExpression", "jetbrains.mps.baseLanguage.structure.SuperConstructorInvocation", "jetbrains.mps.baseLanguage.structure.SuperMethodCall", "jetbrains.mps.baseLanguage.structure.SwitchCase", "jetbrains.mps.baseLanguage.structure.SwitchStatement", "jetbrains.mps.baseLanguage.structure.SynchronizedStatement", "jetbrains.mps.baseLanguage.structure.TernaryOperatorExpression", "jetbrains.mps.baseLanguage.structure.TextCommentPart", "jetbrains.mps.baseLanguage.structure.ThisConstructorInvocation", "jetbrains.mps.baseLanguage.structure.ThisExpression", "jetbrains.mps.baseLanguage.structure.ThrowStatement", "jetbrains.mps.baseLanguage.structure.TrimOperation", "jetbrains.mps.baseLanguage.structure.TryCatchStatement", "jetbrains.mps.baseLanguage.structure.TryStatement", "jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration", "jetbrains.mps.baseLanguage.structure.TypeVariableReference", "jetbrains.mps.baseLanguage.structure.UnaryMinus", "jetbrains.mps.baseLanguage.structure.UndefinedType", "jetbrains.mps.baseLanguage.structure.UnresolvedNameReference", "jetbrains.mps.baseLanguage.structure.UnsignedRightShiftAssignmentExpression", "jetbrains.mps.baseLanguage.structure.UpperBoundType", "jetbrains.mps.baseLanguage.structure.UsingStatement", "jetbrains.mps.baseLanguage.structure.ValueParameter", "jetbrains.mps.baseLanguage.structure.VarType", "jetbrains.mps.baseLanguage.structure.VarVariableDeclaration", "jetbrains.mps.baseLanguage.structure.VarVariableReference", "jetbrains.mps.baseLanguage.structure.VariableArityType", "jetbrains.mps.baseLanguage.structure.VariableDeclaration", "jetbrains.mps.baseLanguage.structure.VoidType", "jetbrains.mps.baseLanguage.structure.WhileStatement", "jetbrains.mps.baseLanguage.structure.WildCardType", "jetbrains.mps.baseLanguage.structure.XorAssignmentExpression"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 21:
        return new AssignmentExpression_BehaviorDescriptor();
      case 65:
        return new FieldDeclaration_BehaviorDescriptor();
      case 37:
        return new ClassConcept_BehaviorDescriptor();
      case 118:
        return new ParameterDeclaration_BehaviorDescriptor();
      case 183:
        return new VariableDeclaration_BehaviorDescriptor();
      case 147:
        return new StatementList_BehaviorDescriptor();
      case 29:
        return new BooleanConstant_BehaviorDescriptor();
      case 44:
        return new ConstructorDeclaration_BehaviorDescriptor();
      case 62:
        return new EqualsExpression_BehaviorDescriptor();
      case 64:
        return new ExpressionStatement_BehaviorDescriptor();
      case 145:
        return new Statement_BehaviorDescriptor();
      case 77:
        return new IfStatement_BehaviorDescriptor();
      case 81:
        return new InstanceMethodDeclaration_BehaviorDescriptor();
      case 83:
        return new IntegerConstant_BehaviorDescriptor();
      case 96:
        return new LocalVariableDeclaration_BehaviorDescriptor();
      case 97:
        return new LocalVariableDeclarationStatement_BehaviorDescriptor();
      case 98:
        return new LocalVariableReference_BehaviorDescriptor();
      case 100:
        return new LongType_BehaviorDescriptor();
      case 105:
        return new MinusExpression_BehaviorDescriptor();
      case 119:
        return new ParameterReference_BehaviorDescriptor();
      case 123:
        return new PlusExpression_BehaviorDescriptor();
      case 137:
        return new ReturnStatement_BehaviorDescriptor();
      case 184:
        return new VoidType_BehaviorDescriptor();
      case 148:
        return new StaticFieldDeclaration_BehaviorDescriptor();
      case 157:
        return new SuperConstructorInvocation_BehaviorDescriptor();
      case 153:
        return new StringLiteral_BehaviorDescriptor();
      case 149:
        return new StaticFieldReference_BehaviorDescriptor();
      case 143:
        return new ShortType_BehaviorDescriptor();
      case 112:
        return new NullLiteral_BehaviorDescriptor();
      case 84:
        return new IntegerType_BehaviorDescriptor();
      case 67:
        return new FloatType_BehaviorDescriptor();
      case 55:
        return new DoubleType_BehaviorDescriptor();
      case 36:
        return new CharType_BehaviorDescriptor();
      case 32:
        return new ByteType_BehaviorDescriptor();
      case 30:
        return new BooleanType_BehaviorDescriptor();
      case 18:
        return new ArrayType_BehaviorDescriptor();
      case 33:
        return new CastExpression_BehaviorDescriptor();
      case 158:
        return new SuperMethodCall_BehaviorDescriptor();
      case 110:
        return new NotEqualsExpression_BehaviorDescriptor();
      case 185:
        return new WhileStatement_BehaviorDescriptor();
      case 120:
        return new ParenthesizedExpression_BehaviorDescriptor();
      case 4:
        return new AndExpression_BehaviorDescriptor();
      case 117:
        return new OrExpression_BehaviorDescriptor();
      case 151:
        return new StaticMethodCall_BehaviorDescriptor();
      case 152:
        return new StaticMethodDeclaration_BehaviorDescriptor();
      case 82:
        return new InstanceOfExpression_BehaviorDescriptor();
      case 74:
        return new GreaterThanExpression_BehaviorDescriptor();
      case 89:
        return new LessThanExpression_BehaviorDescriptor();
      case 111:
        return new NotExpression_BehaviorDescriptor();
      case 31:
        return new BreakStatement_BehaviorDescriptor();
      case 45:
        return new ContinueStatement_BehaviorDescriptor();
      case 28:
        return new BlockStatement_BehaviorDescriptor();
      case 57:
        return new EnumClass_BehaviorDescriptor();
      case 58:
        return new EnumConstantDeclaration_BehaviorDescriptor();
      case 59:
        return new EnumConstantReference_BehaviorDescriptor();
      case 107:
        return new MulExpression_BehaviorDescriptor();
      case 52:
        return new DivExpression_BehaviorDescriptor();
      case 40:
        return new ClassifierType_BehaviorDescriptor();
      case 85:
        return new Interface_BehaviorDescriptor();
      case 170:
        return new TypeVariableDeclaration_BehaviorDescriptor();
      case 171:
        return new TypeVariableReference_BehaviorDescriptor();
      case 68:
        return new FloatingPointConstant_BehaviorDescriptor();
      case 39:
        return new ClassifierClassExpression_BehaviorDescriptor();
      case 71:
        return new ForeachStatement_BehaviorDescriptor();
      case 70:
        return new ForStatement_BehaviorDescriptor();
      case 72:
        return new GenericNewExpression_BehaviorDescriptor();
      case 133:
        return new PublicVisibility_BehaviorDescriptor();
      case 129:
        return new PrivateVisibility_BehaviorDescriptor();
      case 132:
        return new ProtectedVisibility_BehaviorDescriptor();
      case 41:
        return new ClosureParameterReference_BehaviorDescriptor();
      case 75:
        return new GreaterThanOrEqualsExpression_BehaviorDescriptor();
      case 135:
        return new RemExpression_BehaviorDescriptor();
      case 90:
        return new LessThanOrEqualsExpression_BehaviorDescriptor();
      case 169:
        return new TryStatement_BehaviorDescriptor();
      case 15:
        return new ArrayCreatorWithInitializer_BehaviorDescriptor();
      case 114:
        return new Number_BehaviorDescriptor();
      case 20:
        return new AssertStatement_BehaviorDescriptor();
      case 165:
        return new ThisExpression_BehaviorDescriptor();
      case 162:
        return new TernaryOperatorExpression_BehaviorDescriptor();
      case 160:
        return new SwitchStatement_BehaviorDescriptor();
      case 159:
        return new SwitchCase_BehaviorDescriptor();
      case 168:
        return new TryCatchStatement_BehaviorDescriptor();
      case 34:
        return new CatchClause_BehaviorDescriptor();
      case 166:
        return new ThrowStatement_BehaviorDescriptor();
      case 136:
        return new RemarkStatement_BehaviorDescriptor();
      case 161:
        return new SynchronizedStatement_BehaviorDescriptor();
      case 10:
        return new AnonymousClass_BehaviorDescriptor();
      case 186:
        return new WildCardType_BehaviorDescriptor();
      case 103:
        return new LowerBoundType_BehaviorDescriptor();
      case 176:
        return new UpperBoundType_BehaviorDescriptor();
      case 94:
        return new LocalStaticFieldReference_BehaviorDescriptor();
      case 95:
        return new LocalStaticMethodCall_BehaviorDescriptor();
      case 12:
        return new ArrayAccessExpression_BehaviorDescriptor();
      case 43:
        return new CommentedStatementsBlock_BehaviorDescriptor();
      case 53:
        return new DoWhileStatement_BehaviorDescriptor();
      case 179:
        return new VarType_BehaviorDescriptor();
      case 164:
        return new ThisConstructorInvocation_BehaviorDescriptor();
      case 76:
        return new HexIntegerLiteral_BehaviorDescriptor();
      case 11:
        return new AnonymousClassCreator_BehaviorDescriptor();
      case 14:
        return new ArrayCreator_BehaviorDescriptor();
      case 50:
        return new DimensionExpression_BehaviorDescriptor();
      case 5:
        return new Annotation_BehaviorDescriptor();
      case 9:
        return new AnnotationMethodDeclaration_BehaviorDescriptor();
      case 6:
        return new AnnotationInstance_BehaviorDescriptor();
      case 7:
        return new AnnotationInstanceExpression_BehaviorDescriptor();
      case 8:
        return new AnnotationInstanceValue_BehaviorDescriptor();
      case 17:
        return new ArrayLiteral_BehaviorDescriptor();
      case 54:
        return new DotExpression_BehaviorDescriptor();
      case 66:
        return new FieldReferenceOperation_BehaviorDescriptor();
      case 35:
        return new CharConstant_BehaviorDescriptor();
      case 130:
        return new Property_BehaviorDescriptor();
      case 48:
        return new DefaultPropertyImplementation_BehaviorDescriptor();
      case 131:
        return new PropertyReference_BehaviorDescriptor();
      case 46:
        return new CustomPropertyImplementation_BehaviorDescriptor();
      case 73:
        return new GetAccessor_BehaviorDescriptor();
      case 139:
        return new SetAccessor_BehaviorDescriptor();
      case 178:
        return new ValueParameter_BehaviorDescriptor();
      case 47:
        return new DefaultGetAccessor_BehaviorDescriptor();
      case 49:
        return new DefaultSetAccessor_BehaviorDescriptor();
      case 80:
        return new InstanceMethodCallOperation_BehaviorDescriptor();
      case 113:
        return new NullType_BehaviorDescriptor();
      case 56:
        return new ElsifClause_BehaviorDescriptor();
      case 79:
        return new InstanceInitializer_BehaviorDescriptor();
      case 16:
        return new ArrayLengthOperation_BehaviorDescriptor();
      case 38:
        return new ClassCreator_BehaviorDescriptor();
      case 125:
        return new PostfixIncrementExpression_BehaviorDescriptor();
      case 124:
        return new PostfixDecrementExpression_BehaviorDescriptor();
      case 122:
        return new PlusAssignmentExpression_BehaviorDescriptor();
      case 104:
        return new MinusAssignmentExpression_BehaviorDescriptor();
      case 182:
        return new VariableArityType_BehaviorDescriptor();
      case 150:
        return new StaticInitializer_BehaviorDescriptor();
      case 19:
        return new AsExpression_BehaviorDescriptor();
      case 177:
        return new UsingStatement_BehaviorDescriptor();
      case 61:
        return new EnumValuesExpression_BehaviorDescriptor();
      case 27:
        return new BitwiseXorExpression_BehaviorDescriptor();
      case 60:
        return new EnumValueOfExpression_BehaviorDescriptor();
      case 26:
        return new BitwiseOrExpression_BehaviorDescriptor();
      case 24:
        return new BitwiseAndExpression_BehaviorDescriptor();
      case 154:
        return new StringType_BehaviorDescriptor();
      case 109:
        return new NPENotEqualsExpression_BehaviorDescriptor();
      case 108:
        return new NPEEqualsExpression_BehaviorDescriptor();
      case 86:
        return new IsEmptyOperation_BehaviorDescriptor();
      case 87:
        return new IsNotEmptyOperation_BehaviorDescriptor();
      case 156:
        return new SubstringExpression_BehaviorDescriptor();
      case 167:
        return new TrimOperation_BehaviorDescriptor();
      case 140:
        return new ShiftLeftExpression_BehaviorDescriptor();
      case 141:
        return new ShiftRightExpression_BehaviorDescriptor();
      case 25:
        return new BitwiseNotExpression_BehaviorDescriptor();
      case 42:
        return new CommentedStatement_BehaviorDescriptor();
      case 180:
        return new VarVariableDeclaration_BehaviorDescriptor();
      case 181:
        return new VarVariableReference_BehaviorDescriptor();
      case 127:
        return new PrefixIncrementExpression_BehaviorDescriptor();
      case 126:
        return new PrefixDecrementExpression_BehaviorDescriptor();
      case 1:
        return new AbstractUnaryNumberOperation_BehaviorDescriptor();
      case 22:
        return new BLBottomType_BehaviorDescriptor();
      case 99:
        return new LongLiteral_BehaviorDescriptor();
      case 69:
        return new FloatingPointFloatConstant_BehaviorDescriptor();
      case 172:
        return new UnaryMinus_BehaviorDescriptor();
      case 121:
        return new PlaceholderMethodDeclaration_BehaviorDescriptor();
      case 23:
        return new BaseVariableDeclaration_BehaviorDescriptor();
      case 101:
        return new LoopLabel_BehaviorDescriptor();
      case 102:
        return new LoopLabelReference_BehaviorDescriptor();
      case 144:
        return new SingleLineComment_BehaviorDescriptor();
      case 163:
        return new TextCommentPart_BehaviorDescriptor();
      case 146:
        return new StatementCommentPart_BehaviorDescriptor();
      case 106:
        return new MulAssignmentExpression_BehaviorDescriptor();
      case 51:
        return new DivAssignmentExpression_BehaviorDescriptor();
      case 134:
        return new RemAssignmentExpression_BehaviorDescriptor();
      case 116:
        return new OrAssignmentExpression_BehaviorDescriptor();
      case 3:
        return new AndAssignmentExpression_BehaviorDescriptor();
      case 187:
        return new XorAssignmentExpression_BehaviorDescriptor();
      case 88:
        return new LeftShiftAssignmentExpression_BehaviorDescriptor();
      case 138:
        return new RightShiftAssignmentExpression_BehaviorDescriptor();
      case 2:
        return new AdditionalForLoopVariable_BehaviorDescriptor();
      case 0:
        return new AbstractClassifierReference_BehaviorDescriptor();
      case 78:
        return new ImplicitAnnotationInstanceValue_BehaviorDescriptor();
      case 128:
        return new PrimitiveClassExpression_BehaviorDescriptor();
      case 92:
        return new LocalInstanceMethodCall_BehaviorDescriptor();
      case 91:
        return new LocalInstanceFieldReference_BehaviorDescriptor();
      case 13:
        return new ArrayCloneOperation_BehaviorDescriptor();
      case 174:
        return new UnresolvedNameReference_BehaviorDescriptor();
      case 155:
        return new StubStatementList_BehaviorDescriptor();
      case 115:
        return new OperationAssignmentExpression_BehaviorDescriptor();
      case 63:
        return new EscapeOperation_BehaviorDescriptor();
      case 173:
        return new UndefinedType_BehaviorDescriptor();
      case 142:
        return new ShiftRightUnsignedExpression_BehaviorDescriptor();
      case 175:
        return new UnsignedRightShiftAssignmentExpression_BehaviorDescriptor();
      case 93:
        return new LocalPropertyReference_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
