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
package jetbrains.mps.newTypesystem.state;

import jetbrains.mps.lang.typesystem.structure.RuntimeTypeVariable;
import jetbrains.mps.smodel.SNode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 06.12.10
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
public enum ConditionKind {
  ANY {
    @Override
    public List<SNode> getUnresolvedInputs(SNode node, State state) {
      return Collections.EMPTY_LIST;
    }

    @Override
    public String getPresentation() {
      return "";
    }
  },
  SHALLOW {
    @Override
    public List<SNode> getUnresolvedInputs(SNode node, State state) {
      if (node != null) {
        SNode representative = state.getRepresentative(node);
        if (representative.getConceptFqName().equals(RuntimeTypeVariable.concept)) {
          return Arrays.asList(representative);
        }
      }
      return Collections.EMPTY_LIST;
    }

    @Override
    public String getPresentation() {
      return "shallow";
    }
  },
  CONCRETE {
    @Override
    public List<SNode> getUnresolvedInputs(SNode node, State state) {
      if (node == null) {
        return new LinkedList<SNode>();
      }
      SNode representative = state.getRepresentative(node);
      if (representative.getConceptFqName().equals(RuntimeTypeVariable.concept)) {
        return Arrays.asList(representative);
      }
      List<SNode> result = new ArrayList<SNode>();
      for (SNode referent : representative.getReferents()) {
        if (referent != null) {
          SNode refRepresentative = state.getRepresentative(referent);
          if (refRepresentative.getConceptFqName().equals(RuntimeTypeVariable.concept)) {
            result.add(refRepresentative);
          }
        }
      }
      for (SNode child : representative.getChildren(false)) {
        result.addAll(getUnresolvedInputs(child, state));
      }
      return result;
    }

    @Override
    public String getPresentation() {
      return "concrete";
    }
  };

  public abstract List<SNode> getUnresolvedInputs(SNode node, State state);

  public abstract String getPresentation();
}
