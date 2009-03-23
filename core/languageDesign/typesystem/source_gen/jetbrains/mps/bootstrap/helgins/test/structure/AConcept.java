/*
 * Copyright 2003-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.bootstrap.helgins.test.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AConcept extends BaseConcept {
  public static final String concept = "jetbrains.mps.bootstrap.helgins.test.structure.AConcept";
  public static final String EXPRESSION = "expression";

  public AConcept(SNode node) {
    super(node);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(Expression.class, AConcept.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(AConcept.EXPRESSION, node);
  }


  public static AConcept newInstance(SModel sm, boolean init) {
    return (AConcept)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.test.structure.AConcept", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AConcept newInstance(SModel sm) {
    return AConcept.newInstance(sm, false);
  }

}
