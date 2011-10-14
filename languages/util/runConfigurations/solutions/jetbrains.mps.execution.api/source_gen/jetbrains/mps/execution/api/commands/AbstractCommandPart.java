package jetbrains.mps.execution.api.commands;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.internal.collections.runtime.IterableUtils;

public abstract class AbstractCommandPart implements CommandPart {
  private final List<String> myCommand = ListSequence.fromList(new ArrayList<String>());

  public AbstractCommandPart(List<String> list) {
    addCommands(list);
  }

  public AbstractCommandPart(String... list) {
    addCommands(list);
  }

  public AbstractCommandPart() {
  }

  public List<String> getCommandList() {
    return myCommand;
  }

  protected final void addCommands(Iterable<String> list) {
    ListSequence.fromList(myCommand).addSequence(Sequence.fromIterable(list).where(new IWhereFilter<String>() {
      public boolean accept(String it) {
        return StringUtils.isNotEmpty(it);
      }
    }));
  }

  protected final void addCommands(String... list) {
    addCommands(Sequence.fromArray(list));
  }

  public int getLength() {
    return IterableUtils.join(ListSequence.fromList(myCommand), " ").length();
  }
}
