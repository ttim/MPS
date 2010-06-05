package jetbrains.mps.ide.embeddableEditor;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.generationTypes.InMemoryJavaGenerationHandler;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;

public class GenerationResult {
  private SNode myNode;
  private InMemoryJavaGenerationHandler myHandler;
  private IOperationContext myContext;
  private SModelDescriptor myDescriptor;
  private boolean mySuccesful = true;

  /*package*/ GenerationResult(SNode node, IOperationContext context, SModelDescriptor modelDescriptor, InMemoryJavaGenerationHandler handler, boolean succesful) {
    myContext = context;
    myNode = node;
    myDescriptor = modelDescriptor;
    myHandler = handler;
    mySuccesful = succesful;
  }

  /*package*/ GenerationResult(SNode node, IOperationContext context) {
    myContext = context;
    myNode = node;
  }

  public SNode getSNode() {
    return myNode;
  }

  public IOperationContext getOperationContext() {
    return myContext;
  }

  public SModelDescriptor getModelDescriptor() {
    return myDescriptor;
  }

  public boolean isSuccessful() {
    return mySuccesful;
  }

  public ClassLoader getLoader(ClassLoader parentLoader) {
    if (myHandler == null) {
      return null;
    }
    return myHandler.getCompiler().getClassLoader(parentLoader);
  }
}
