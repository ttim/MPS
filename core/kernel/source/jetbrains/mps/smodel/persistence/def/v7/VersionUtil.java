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
package jetbrains.mps.smodel.persistence.def.v7;

import jetbrains.mps.lang.structure.structure.PropertyDeclaration;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.SModel.ImportElement;
import jetbrains.mps.smodel.persistence.def.v5.ModelUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class VersionUtil {
  private static final Logger LOG = Logger.getLogger(VersionUtil.class);

  private static final char VERSION_SEPARATOR_CHAR = ':';
  private static final char MODEL_SEPARATOR_CHAR = '.';

  // temporary here (while VersionUtil exists)

  private SModelReference myModelRef;
  private Map<SModelReference, ImportElement> myImports;
  private Map<SModelReference, String> myImportIndex;
  private Set<Integer> myUsedIndexes;
  private final static int HASH_BASE = 10 + 26;
  private final static int HASH_SIZE = HASH_BASE * HASH_BASE * HASH_BASE * HASH_BASE;

  public VersionUtil(SModel model) {
    myModelRef = model.getSModelReference();
    myImports = new HashMap<SModelReference, ImportElement>();
    myImportIndex = new HashMap<SModelReference, String>();
    myUsedIndexes = new HashSet<Integer>();

    for (ImportElement elem : model.importedModels()) {
      processImportElement(elem);
    }
    for (ImportElement elem : model.getAdditionalModelVersions()) {
      processImportElement(elem);
    }
  }

  private void processImportElement(ImportElement elem) {
    SModelReference modelRef = elem.getModelReference();
    int hash = (modelRef.hashCode() % HASH_SIZE + HASH_SIZE) % HASH_SIZE;
    //int hash = (modelRef.hashCode() >>> 1) % HASH_SIZE;
    while (myUsedIndexes.contains(hash))  hash = (hash + 1) % HASH_SIZE;
    myUsedIndexes.add(hash);
    myImportIndex.put(modelRef, Integer.toString(hash, HASH_BASE));
    myImports.put(modelRef, elem);
  }

  public String genImportIndex(ImportElement elem) {
    return myImportIndex.get(elem.getModelReference());
  }

  private static String encode(String s) {
    return s.replace("%", "%p").replace(":", "%c").replace(".", "%d");
  }
  private static String decode(String s) {
    return s.replace("%d", ".").replace("%c", ":").replace("%p", "%");
  }

  @NotNull
  public String genReferenceString(@NotNull SModelReference ref, @NotNull String text) {
    ImportElement impElem = myImports.get(ref);
    if (impElem == null) {
      LOG.error("model " + ref + " not found in imports");
      return encode(text);
    }
    StringBuilder result = new StringBuilder();
    if (!(myModelRef.equals(ref)))  result.append(myImportIndex.get(ref)).append(MODEL_SEPARATOR_CHAR);
    return result.append(encode(text)).toString();
  }
  @NotNull
  public String genConceptReferenceString(@Nullable SNode concept, @NotNull String fqName) {
    // return fqName prefixed with "." if we can't find model or name of concept
    fqName = MODEL_SEPARATOR_CHAR + fqName;   // to distinguish fqName from model + concept
    if (concept == null)  return fqName;
    SModelReference ref = concept.getModel().getSModelReference();
    ImportElement impElem = myImports.get(ref);
    if (impElem == null) {
      LOG.error("model " + ref + " not found in imports");
      return fqName;
    }
    String name = concept.getName();
    if (name == null)  return fqName;
    return new StringBuilder().append(myImportIndex.get(ref)).append(MODEL_SEPARATOR_CHAR).append(name).toString();
  }
  @NotNull
  public String genReferenceId(@NotNull SNode node) {
    return genReferenceString(node.getModel().getSModelReference(), node.getId());
  }
  @Nullable
  public String genReferenceId(@Nullable BaseAdapter adapter) {
    return adapter == null ? null : genReferenceId(adapter.getNode());
  }

  public String genType(@NotNull SNode node) {
    return genConceptReferenceString(node.getConceptDeclarationNode(), node.getConceptFqName());
  }
  public String genTypeId(@NotNull SNode node) {
    SNode concept = node.getConceptDeclarationNode();
    return concept == null ? null : genReferenceId(concept);
  }
  public String genRole(@NotNull SNode node) {
    return node.getRole_();
  }
  public String genRole(@NotNull SReference ref) {
    return ref.getRole();
  }
  public String genRoleId(@NotNull SNode node) {
    return genReferenceId(node.getRoleLink());
  }
  public String genRoleId(@NotNull SReference ref) {
    return genReferenceId(ref.getSourceNode().getLinkDeclaration(ref.getRole()));
  }
  public String genName(@NotNull SNode node, @NotNull String prop) {
    return prop;
  }
  public String genNameId(@NotNull SNode node, @NotNull String prop) {
    PropertyDeclaration propDecl = node.getPropertyDeclaration(prop);
    return propDecl == null ? null : genReferenceId(propDecl.getNode());
  }
  public String genTarget(@NotNull SReference ref) {
    String target = ref instanceof StaticReference ? String.valueOf(ref.getTargetNodeId()) : "^";
    SModelReference targetModel = ref.getTargetSModelReference();
    return targetModel == null ? target : genReferenceString(targetModel, target);
  }



  private Map<String, ImportElement> myImportByIx;
  private int myMaxImportIndex = 0;

  public VersionUtil(SModelReference modelRef) {
    myModelRef = modelRef;
    myImports = new HashMap<SModelReference, ImportElement>();
    myImportByIx = new HashMap<String, ImportElement>();
  }

  public void addImport(SModel model, String index, String modelUID, int version, boolean implicit) {
    if (modelUID == null) {
      LOG.error("Error loading import element for index " + index + " in " + myModelRef);
      return;
    }
    SModelReference modelRef = ModelUtil.upgradeModelUID(SModelReference.fromString(modelUID));
    ImportElement elem = new ImportElement(modelRef, ++myMaxImportIndex, version);
    model.setMaxImportIndex(myMaxImportIndex);
    myImports.put(modelRef, elem);
    myImportByIx.put(index, elem);
    if (implicit)
      model.addAdditionalModelVersion(elem);
    else
      model.addModelImport(elem);
  }

  public SModelReference getSModelReference(@NotNull String ix) {
    if (ix.isEmpty())  return myModelRef;
    ImportElement elem = myImportByIx.get(ix);
    return elem == null ? null : elem.getModelReference();
  }

  public SNodePointer readLinkId(String src) { // [modelID.]nodeID[:version] | [modelID.]^[:version]
    if (src == null)  return null;
    int i0 = src.indexOf(MODEL_SEPARATOR_CHAR), i1 = src.lastIndexOf(VERSION_SEPARATOR_CHAR);
    String text = decode(src.substring(i0 + 1, i1 < 0 ? src.length() : i1));
    SModelReference modelRef = i0 < 0 ? myModelRef : getSModelReference(src.substring(0, i0));
    SNodeId nodeId = text.equals("^") ? null : SNodeId.fromString(text);
    return new SNodePointer(modelRef, nodeId);
  }

  public String readType(String s) {
    int ix = s.indexOf(MODEL_SEPARATOR_CHAR);
    if (ix <= 0)  return s.substring(ix + 1);   // no model ID - fqName is here
    SModelReference modelRef = getSModelReference(s.substring(0, ix));
    if (modelRef == null) {
      LOG.error("couldn't create node '" + s.substring(ix + 1) + "' : import for index [" + s.substring(0, ix) + "] not found");
      return s.substring(ix + 1);
    } else {
      return modelRef.getSModelFqName().getLongName() + "." + s.substring(ix + 1);
    }
  }

  public String readRole(String s) {
    return s;
  }

  public String readName(String s) {
    return s;
  }
}
