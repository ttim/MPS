package jetbrains.mps.debug.runtime.java.programState.watchables;

/*Generated by MPS */

import jetbrains.mps.debug.api.programState.IWatchable;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.ThreadReference;
import jetbrains.mps.debug.api.programState.WatchablesCategory;
import jetbrains.mps.debug.runtime.java.programState.JavaWatchablesCategory;
import jetbrains.mps.debug.api.programState.IValue;
import javax.swing.Icon;
import jetbrains.mps.debug.integration.ui.icons.Icons;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import com.sun.jdi.Field;

public class JavaStaticContext extends JavaWatchable implements IWatchable {
  private final ReferenceType myStaticType;

  public JavaStaticContext(ReferenceType staticType, String classFqName, ThreadReference threadReference) {
    super(classFqName, threadReference);
    myStaticType = staticType;
  }

  @Override
  public String getName() {
    return "static";
  }

  @Override
  public WatchablesCategory getCategory() {
    return JavaWatchablesCategory.STATIC_CONTEXT;
  }

  @Override
  public IValue getValue() {
    return new JavaStaticContext.StaticContextValue();
  }

  @Override
  public Icon getPresentationIcon() {
    return Icons.VARIABLE_OBJECT;
  }

  @Override
  public SNode getNode() {
    return null;
  }

  private class StaticContextValue implements IValue {
    private StaticContextValue() {
    }

    @Override
    public String getValuePresentation() {
      return myStaticType.name();
    }

    @Override
    public Icon getPresentationIcon() {
      return Icons.VARIABLE_OBJECT;
    }

    @Override
    public boolean isStructure() {
      return true;
    }

    @Override
    public List<IWatchable> getSubvalues() {
      List<IWatchable> result = new ArrayList<IWatchable>();
      for (Field field : myStaticType.fields()) {
        if (!(field.isStatic())) {
          continue;
        }
        result.add(new JavaStaticField(field, myClassFQName, myThreadReference));
      }
      return result;
    }
  }
}
