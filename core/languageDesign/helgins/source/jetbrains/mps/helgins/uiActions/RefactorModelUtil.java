package jetbrains.mps.helgins.uiActions;

import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.INodeAdapter;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.bootstrap.helgins.structure.AbstractEquationStatement;
import jetbrains.mps.bootstrap.helgins.structure.NormalTypeClause;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.ide.IDEProjectFrame;

public class RefactorModelUtil {
  public static void refactorModel(SModelDescriptor modelDescriptor) {
    SModel model = modelDescriptor.getSModel();
    try {
      model.setLoading(true);
      boolean modified = false;
      for (AbstractEquationStatement equationStatement : model.allAdapters(AbstractEquationStatement.class)) {
        INodeAdapter left = equationStatement.getChild(AbstractEquationStatement.LEFT_EXPRESSION);
        INodeAdapter right = equationStatement.getChild(AbstractEquationStatement.RIGHT_EXPRESSION);
        if (left instanceof Expression) {
          NormalTypeClause normalTypeClause = NormalTypeClause.newInstance(model);
          equationStatement.replaceChild(left, normalTypeClause);
          normalTypeClause.setNormalType((Expression) left);
          modified = true;
        }
        if (right instanceof Expression) {
          NormalTypeClause normalTypeClause = NormalTypeClause.newInstance(model);
          equationStatement.replaceChild(right, normalTypeClause);
          normalTypeClause.setNormalType((Expression) right);
          modified = true;
        }
      }
      if (modified) {
        modelDescriptor.save();
      }
    } finally {
      model.setLoading(false);
    }
  }
}
