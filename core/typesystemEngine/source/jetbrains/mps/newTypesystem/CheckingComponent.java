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
package jetbrains.mps.newTypesystem;

import gnu.trove.THashSet;
import jetbrains.mps.smodel.AbstractNodesReadListener;
import jetbrains.mps.smodel.LanguageHierarchyCache;
import jetbrains.mps.smodel.LanguageHierarchyCache.CacheChangeListener;
import jetbrains.mps.smodel.LanguageHierarchyCache.CacheReadAccessListener;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.util.Pair;
import jetbrains.mps.util.annotation.UseCarefully;

import java.util.Set;

public abstract class CheckingComponent {
  protected boolean myInvalidationWasPerformed = false;
  protected boolean myCacheWasRebuilt = false;
  protected TypeChecker myTypeChecker;
  protected NodeTypesComponent myNodeTypesComponent;
  protected boolean myIsChecked = false;
  protected MyLanguageCacheListener myLanguageCacheListener = new MyLanguageCacheListener();

  protected Set<SNode> myCurrentNodesToInvalidate = new THashSet<SNode>();

  @UseCarefully
  public void setChecked() {
    myIsChecked = true;
  }

  public boolean isChecked() {
    return myIsChecked && !doInvalidate();
  }

  protected abstract boolean doInvalidate();

  public void setInvalidationWasPerformed(boolean invalidationWasPerformed) {
    myInvalidationWasPerformed = invalidationWasPerformed;
  }

  public void setCacheWasRebuild(boolean cacheWasRebuild) {
    myCacheWasRebuilt = cacheWasRebuild;
  }

  public void addNodeToInvalidate(SNode node) {
    myCurrentNodesToInvalidate.add(node);
    setInvalidationWasPerformed(false);
  }

  protected boolean isIncrementalMode() {
    return myNodeTypesComponent.getTypeCheckingContext().isIncrementalMode();
  }

  public void dispose() {
    LanguageHierarchyCache.getInstance().removeCacheChangeListener(myLanguageCacheListener);
  }

  /*
   *  Single-threaded
   */
  protected class MyEventsReadListener extends AbstractNodesReadListener {
    private Set<SNode> myAccessedNodes = new THashSet<SNode>(1);
    private Set<Pair<SNode, String>> myAccessedProperties = new THashSet<Pair<SNode, String>>(1);
    private boolean myIsSetAccessReport = false;

    public MyEventsReadListener() {
    }

    public void setAccessReport(boolean accessReport) {
      myIsSetAccessReport = accessReport;
    }

    private void reportAccess() {
      if (myIsSetAccessReport) {
        new Throwable().printStackTrace();
      }
    }

    public void nodeChildReadAccess(SNode node, String childRole, SNode child) {
      reportAccess();
      myAccessedNodes.add(node);
      if (child != null) {
        myAccessedNodes.add(child);
      }
    }

    public void nodePropertyReadAccess(SNode node, String propertyName, String value) {
      reportAccess();
      myAccessedProperties.add(new Pair<SNode, String>(node, propertyName));
    }

    public void nodeReferentReadAccess(SNode node, String referentRole, SNode referent) {
      reportAccess();
      myAccessedNodes.add(node);
      if (referent != null) {
        myAccessedNodes.add(referent);
      }
    }

    public void nodeUnclassifiedReadAccess(SNode node) {
      reportAccess();
      myAccessedNodes.add(node);
    }

    public Set<SNode> getAccessedNodes() {
      return myAccessedNodes;
    }

    public void clear() {
      reportAccess();
      myAccessedNodes = new THashSet<SNode>();
      myAccessedProperties = new THashSet<Pair<SNode, String>>();
    }

    public Set<Pair<SNode, String>> getAccessedProperties() {
      return myAccessedProperties;
    }
  }

  /*
   *  Single-threaded.
   */
  class MyLanguageCachesReadListener implements CacheReadAccessListener {
    private boolean myIsCacheAccessed = false;
    private boolean myIsSetAccessReport = false;

    MyLanguageCachesReadListener() {
    }

    public void setAccessReport(boolean accessReport) {
      myIsSetAccessReport = accessReport;
    }

    public void languageCacheRead() {
      if (myIsSetAccessReport) {
        new Throwable().printStackTrace();
      }
      myIsCacheAccessed = true;
    }

    public boolean isCacheAccessed() {
      return myIsCacheAccessed;
    }
  }

  private class MyLanguageCacheListener implements CacheChangeListener {
    public void languageCacheChanged() {
      setCacheWasRebuild(true);
      setInvalidationWasPerformed(false);
    }
  }
}
