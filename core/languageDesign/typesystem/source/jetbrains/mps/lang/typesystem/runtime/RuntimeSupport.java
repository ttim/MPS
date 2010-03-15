/*
 * Copyright 2003-2010 JetBrains s.r.o.
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
package jetbrains.mps.lang.typesystem.runtime;

import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationManager;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;

public class RuntimeSupport {

  private TypeChecker myTypeChecker;

  public RuntimeSupport(TypeChecker typeChecker) {
    myTypeChecker = typeChecker;
  }

  public SNode coerce_(SNode subtype, IMatchingPattern pattern, boolean isWeak) {
    synchronized (myTypeChecker) {
      return myTypeChecker.getSubtypingManager().coerceSubtyping(subtype, pattern, isWeak, null);
    }
  }

  public SNode coerce_(SNode subtype, IMatchingPattern pattern) {
    synchronized (myTypeChecker) {
      return myTypeChecker.getSubtypingManager().coerceSubtyping(subtype, pattern, null);
    }
  }

  public SNode coerce_(SNode subtype, IMatchingPattern pattern, boolean isWeak, TypeCheckingContext typeCheckingContext) {
    synchronized (myTypeChecker) {
      EquationManager equationManager = typeCheckingContext == null ? null : typeCheckingContext.getEquationManager();
      return myTypeChecker.getSubtypingManager().coerceSubtyping(subtype, pattern, isWeak, equationManager);
    }
  }

  public SNode coerce_(SNode subtype, IMatchingPattern pattern, TypeCheckingContext typeCheckingContext) {
    synchronized (myTypeChecker) {
      EquationManager equationManager = typeCheckingContext == null ? null : typeCheckingContext.getEquationManager();
      return myTypeChecker.getSubtypingManager().coerceSubtyping(subtype, pattern, equationManager);
    }
  }

}
