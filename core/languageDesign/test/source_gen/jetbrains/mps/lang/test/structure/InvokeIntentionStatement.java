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
package jetbrains.mps.lang.test.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.intentions.structure.IntentionDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InvokeIntentionStatement extends Statement {
  public static final String concept = "jetbrains.mps.lang.test.structure.InvokeIntentionStatement";
  public static final String INTENTION = "intention";

  public InvokeIntentionStatement(SNode node) {
    super(node);
  }

  public IntentionDeclaration getIntention() {
    return (IntentionDeclaration)this.getReferent(IntentionDeclaration.class, InvokeIntentionStatement.INTENTION);
  }

  public void setIntention(IntentionDeclaration node) {
    super.setReferent(InvokeIntentionStatement.INTENTION, node);
  }


  public static InvokeIntentionStatement newInstance(SModel sm, boolean init) {
    return (InvokeIntentionStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.test.structure.InvokeIntentionStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InvokeIntentionStatement newInstance(SModel sm) {
    return InvokeIntentionStatement.newInstance(sm, false);
  }

}
