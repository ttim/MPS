package jetbrains.mps.baseLanguage.unitTest.execution.client;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.baseLanguage.execution.api.Java_Command;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;

public abstract class AbstractTestWrapper<N extends SNode> implements ITestNodeWrapper<N> {
  @NotNull
  protected final SNodePointer myNodePointer;
  private String myFqName;

  public AbstractTestWrapper(@NotNull N node) {
    myNodePointer = new SNodePointer(node);
  }

  public AbstractTestWrapper(@NotNull SNodePointer nodePointer) {
    myNodePointer = nodePointer;
  }

  @Nullable
  public N getNode() {
    return (N) myNodePointer.getNode();
  }

  @NotNull
  public SNodePointer getNodePointer() {
    return myNodePointer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    AbstractTestWrapper that = (AbstractTestWrapper) o;
    if ((this.myNodePointer != null ?
      !(((Object) this.myNodePointer).equals(that.myNodePointer)) :
      that.myNodePointer != null
    )) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = 0;
    result = 31 * result + ((this.myNodePointer != null ?
      ((Object) this.myNodePointer).hashCode() :
      0
    ));
    return result;
  }

  @Nullable
  public ITestNodeWrapper getTestCase() {
    return null;
  }

  @NotNull
  public Iterable<ITestNodeWrapper> getTestMethods() {
    return ListSequence.fromList(new ArrayList<ITestNodeWrapper>());
  }

  @NotNull
  public Tuples._3<String, List<String>, List<String>> getTestRunParameters() {
    return getDefaultRunParameters();
  }

  public String getName() {
    N node = getNode();
    if (node == null) {
      return null;
    }
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.core.structure.INamedConcept")) {
      return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.lang.core.structure.INamedConcept"), "name");
    } else {
      throw new UnsupportedOperationException("Should override getName for not INamedConcept: " + SNodeOperations.getConceptDeclaration(node));
    }
  }

  public String getFqName() {
    ITestNodeWrapper testCase = getTestCase();
    if (isTestCase() || testCase == null) {
      N node = getNode();
      if (node == null) {
        return null;
      }
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.core.structure.INamedConcept")) {
        return SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.lang.core.structure.INamedConcept"), "name");
      } else {
        throw new UnsupportedOperationException("Should override getFqName for not INamedConcept: " + SNodeOperations.getConceptDeclaration(node));
      }
    }
    return testCase.getFqName() + "." + getName();
  }

  public String getCachedFqName() {
    if (myFqName == null) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          myFqName = getFqName();
        }
      });
    }
    return myFqName;
  }

  public static Tuples._3<String, List<String>, List<String>> getDefaultRunParameters() {
    List<String> startupPath = Java_Command.getClasspath(MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("8b958198-128f-4136-80e5-ca9777caa869")), true);
    return MultiTuple.<String,List<String>,List<String>>from("jetbrains.mps.baseLanguage.unitTest.execution.server.TestRunner", ListSequence.fromList(new ArrayList<String>()), startupPath);
  }
}
