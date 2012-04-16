/*
 * Copyright 2003-2011 JetBrains s.r.o.
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
package jetbrains.mps.generator.impl.cache;

import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.DynamicReference.DynamicReferenceOrigin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public class NodesWriter {
  public static final int USER_NODE_POINTER = 0;
  public static final int USER_STRING = 1;
  public static final int USER_NULL = 2;
  public static final int USER_NODE_ID = 3;
  public static final int USER_MODEL_ID = 4;
  public static final int USER_MODEL_REFERENCE = 5;
  public static final int USER_SERIALIZABLE = 6;

  protected static final SModelReference LOCAL = SModelReference.fromString("$LOCAL$");
  protected final SModelReference myModelReference;

  public NodesWriter(@NotNull SModelReference modelReference) {
    this.myModelReference = modelReference;
  }

  protected void writeNodes(Collection<SNode> nodes, ModelOutputStream os) throws IOException {
    os.writeInt(nodes.size());
    for (SNode n : nodes) {
      writeNode(n, os);
    }
  }

  protected void writeNode(SNode node, ModelOutputStream os) throws IOException {
    os.writeString(node.getConceptFqName());
    os.writeNodeId(node.getSNodeId());
    os.writeString(node.getRole_());
    os.writeByte('{');

    writeProperties(node, os);

    writeReferences(node, os);

    writeChildren(node, os);

    writeUserObjects(node, os);

    os.writeByte('}');
  }

  protected void writeChildren(SNode node, ModelOutputStream os) throws IOException {
    writeNodes(node.getChildren(), os);
  }

  protected void writeReferences(SNode node, ModelOutputStream os) throws IOException {
    Collection<SReference> refs = node.getReferencesIterable();
    os.writeInt(refs.size());
    for (SReference reference : refs) {
      SModelReference targetModelReference = reference.getTargetSModelReference();
      if (reference instanceof StaticReference) {
        os.writeInt(1);
        os.writeNodeId(reference.getTargetNodeId());
      } else if (reference instanceof DynamicReference) {
        DynamicReferenceOrigin origin = ((DynamicReference) reference).getOrigin();
        if (origin != null) {
          os.writeInt(3);
          os.writeNodePointer(origin.getTemplate());
          os.writeNodePointer(origin.getInputNode());
        } else {
          os.writeInt(2);
        }
      } else {
        throw new IOException("cannot store reference: " + reference.toString());
      }
      os.writeString(reference.getRole());
      os.writeModelReference(targetModelReference != null && targetModelReference.equals(myModelReference) ? LOCAL : targetModelReference);
      os.writeString(reference.getResolveInfo());
    }
  }

  protected void writeProperties(SNode node, ModelOutputStream os) throws IOException {
    Map<String, String> properties = node.getProperties();
    os.writeInt(properties.size());
    for (Entry<String, String> entry : properties.entrySet()) {
      os.writeString(entry.getKey());
      os.writeString(entry.getValue());
    }
  }

  protected void writeUserObjects(SNode node, ModelOutputStream os) throws IOException {
    // write user objects here
    Map<Object, Object> userObjects = node.getUserObjects();
    ArrayList<Object> knownUserObject = new ArrayList<Object>();
    for (Object key : userObjects.keySet()) {
      Object value = userObjects.get(key);
      if (isKnownUserObject(key) && isKnownUserObject(value)) {
        knownUserObject.add(key);
        knownUserObject.add(value);
      }
    }

    os.writeInt(knownUserObject.size());
    for (int i = 0; i < knownUserObject.size(); i += 2) {
      writeUserObject(os, knownUserObject.get(i));
      writeUserObject(os, knownUserObject.get(i + 1));
    }
  }

  protected void writeUserObject(ModelOutputStream os, Object object) throws IOException {
    if (object == null) {
      os.writeInt(USER_NULL);
    } else if (object instanceof SNodePointer) {
      os.writeInt(USER_NODE_POINTER);
      os.writeNodePointer((SNodePointer) object);
    } else if (object instanceof String) {
      os.writeInt(USER_STRING);
      os.writeString((String) object);
    } else if (object instanceof SNodeId) {
      os.writeInt(USER_NODE_ID);
      os.writeNodeId((SNodeId) object);
    } else if (object instanceof SModelId) {
      os.writeInt(USER_MODEL_ID);
      os.writeModelID((SModelId) object);
    } else if (object instanceof SModelReference) {
      os.writeInt(USER_MODEL_REFERENCE);
      os.writeModelReference((SModelReference) object);
    } else if (object instanceof Serializable) {
      os.writeInt(USER_SERIALIZABLE);
      ObjectOutputStream objectOutput = new ObjectOutputStream(os);
      objectOutput.writeObject(object);
    }

  }

  protected boolean isKnownUserObject(Object object) {
    return object == null
      || object instanceof SNodePointer
      || object instanceof Serializable
      || object instanceof SNodeId
      || object instanceof SModelId
      || object instanceof SModelReference;
  }
}
