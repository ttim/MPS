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

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.unitTest.structure.ITestCase;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.baseLanguage.classifiers.structure.IClassifier;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.baseLanguage.classifiers.structure.DefaultClassifierMethodDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NodesTestCase extends BaseConcept implements ITestCase, INamedConcept, IClassifier {
  public static final String concept = "jetbrains.mps.lang.test.structure.NodesTestCase";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String NODES_TO_CHECK = "nodesToCheck";
  public static final String TEST_METHODS = "testMethods";
  public static final String METHODS = "methods";

  public NodesTestCase(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(NodesTestCase.NAME);
  }

  public void setName(String value) {
    this.setProperty(NodesTestCase.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(NodesTestCase.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(NodesTestCase.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(NodesTestCase.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(NodesTestCase.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(NodesTestCase.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(NodesTestCase.VIRTUAL_PACKAGE, value);
  }

  public int getNodesToChecksCount() {
    return this.getChildCount(NodesTestCase.NODES_TO_CHECK);
  }

  public Iterator<TestNode> nodesToChecks() {
    return this.children(TestNode.class, NodesTestCase.NODES_TO_CHECK);
  }

  public List<TestNode> getNodesToChecks() {
    return this.getChildren(TestNode.class, NodesTestCase.NODES_TO_CHECK);
  }

  public void addNodesToCheck(TestNode node) {
    this.addChild(NodesTestCase.NODES_TO_CHECK, node);
  }

  public void insertNodesToCheck(TestNode prev, TestNode node) {
    this.insertChild(prev, NodesTestCase.NODES_TO_CHECK, node);
  }

  public int getTestMethodsesCount() {
    return this.getChildCount(NodesTestCase.TEST_METHODS);
  }

  public Iterator<NodesTestMethod> testMethodses() {
    return this.children(NodesTestMethod.class, NodesTestCase.TEST_METHODS);
  }

  public List<NodesTestMethod> getTestMethodses() {
    return this.getChildren(NodesTestMethod.class, NodesTestCase.TEST_METHODS);
  }

  public void addTestMethods(NodesTestMethod node) {
    this.addChild(NodesTestCase.TEST_METHODS, node);
  }

  public void insertTestMethods(NodesTestMethod prev, NodesTestMethod node) {
    this.insertChild(prev, NodesTestCase.TEST_METHODS, node);
  }

  public int getMethodsesCount() {
    return this.getChildCount(NodesTestCase.METHODS);
  }

  public Iterator<DefaultClassifierMethodDeclaration> methodses() {
    return this.children(DefaultClassifierMethodDeclaration.class, NodesTestCase.METHODS);
  }

  public List<DefaultClassifierMethodDeclaration> getMethodses() {
    return this.getChildren(DefaultClassifierMethodDeclaration.class, NodesTestCase.METHODS);
  }

  public void addMethods(DefaultClassifierMethodDeclaration node) {
    this.addChild(NodesTestCase.METHODS, node);
  }

  public void insertMethods(DefaultClassifierMethodDeclaration prev, DefaultClassifierMethodDeclaration node) {
    this.insertChild(prev, NodesTestCase.METHODS, node);
  }


  public static NodesTestCase newInstance(SModel sm, boolean init) {
    return (NodesTestCase)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.test.structure.NodesTestCase", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NodesTestCase newInstance(SModel sm) {
    return NodesTestCase.newInstance(sm, false);
  }

}
