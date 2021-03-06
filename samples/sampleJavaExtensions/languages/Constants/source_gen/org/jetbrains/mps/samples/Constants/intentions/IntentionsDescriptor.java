package org.jetbrains.mps.samples.Constants.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntentionsDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.SModelReference;

public class IntentionsDescriptor extends BaseIntentionsDescriptor {
  public IntentionsDescriptor() {
    super(new ModuleReference("org.jetbrains.mps.samples.Constants", "0d40d465-dded-40d0-8d4c-2c6d177f60d7"), SModelReference.fromString("r:42e1ac37-7eb5-465e-8f7a-fef5bc98a099(org.jetbrains.mps.samples.Constants.intentions)"));
  }

  public void init() {
    add(new InlineConstant_Intention(), "3986994675334573650");
    add(new IntroduceConstant_Intention(), "3986994675334574125");
    add(new SafeRemoveConstant_Intention(), "3986994675334573802");
  }
}
