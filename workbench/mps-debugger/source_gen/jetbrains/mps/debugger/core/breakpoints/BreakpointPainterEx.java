package jetbrains.mps.debugger.core.breakpoints;

/*Generated by MPS */

import jetbrains.mps.debugger.core.DebuggerCellPainter;
import java.awt.Color;
import jetbrains.mps.nodeEditor.AdditionalPainter;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.debugger.core.CurrentLinePositionComponentEx;

public abstract class BreakpointPainterEx<B> extends DebuggerCellPainter<B> {
  private static final Color CELL_BACKGROUND_COLOR = new Color(255, 200, 200, 50);
  private static final Color STRIPE_BACKGROUND_COLOR = new Color(255, 200, 200);
  private static final Color FRAME_COLOR = new Color(255, 100, 100);

  protected final B myBreakpoint;

  public BreakpointPainterEx(B breakpoint) {
    myBreakpoint = breakpoint;
  }

  @Override
  protected Color getCellBackgroundColor() {
    return CELL_BACKGROUND_COLOR;
  }

  @Override
  protected Color getStripeBackgroundColor() {
    return STRIPE_BACKGROUND_COLOR;
  }

  @Override
  protected Color getFrameColor() {
    return FRAME_COLOR;
  }

  @Override
  public boolean isAbove(AdditionalPainter painter, EditorComponent component) {
    if (painter instanceof CurrentLinePositionComponentEx) {
      return false;
    }
    return super.isAbove(painter, component);
  }

  @Override
  public B getItem() {
    return myBreakpoint;
  }
}
