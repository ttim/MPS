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
package jetbrains.mps.nodeEditor.cellLayout;

import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.cells.EditorCell_Indent;
import jetbrains.mps.nodeEditor.text.TextBuilder;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.EditorSettings;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.*;

public class CellLayout_Indent extends AbstractCellLayout {
  static boolean isOnNewLine(EditorCell root, EditorCell cell) {
    EditorCell current = cell;

    while (current != root) {
      if (current.getStyle().get(StyleAttributes.INDENT_LAYOUT_ON_NEW_LINE)) return true;

      if (current.isFirstChild()) {
        current = current.getParent();
      } else {
        return false;
      }
    }

    return false;
  }

  private static int getIndent(EditorCell root, EditorCell cell, boolean overflow) {
    int result = 0;

    if (overflow) {
      result+=2;
    }

    while (cell != root) {
      if (cell.getStyle().get(StyleAttributes.INDENT_LAYOUT_INDENT)) {
        result++;
      }

      cell = cell.getParent();
    }

    return result;
  }

  static boolean isNewLineAfter(EditorCell root, EditorCell cell) {
    EditorCell current = cell;

    while (current != root) {
      if (current.getStyle().get(StyleAttributes.INDENT_LAYOUT_NEW_LINE)) return true;

      if (current.getParent() != null &&
        current.getParent().getStyle().get(StyleAttributes.INDENT_LAYOUT_CHILDREN_NEWLINE)) return true;

      if (current.isLastChild()) {
        current = current.getParent();
      } else {
        return false;
      }
    }

    return false;
  }


  public void doLayout(EditorCell_Collection editorCells) {
    if (editorCells.getParent() != null && editorCells.getParent().getCellLayout() instanceof CellLayout_Indent) {
      return;
    }

    new CellLayouter(editorCells).layout();
  }

  public TextBuilder doLayoutText(Iterable<EditorCell> editorCells) {
    TextBuilder result = TextBuilder.getEmptyTextBuilder();
    Iterator<EditorCell> iterator = editorCells.iterator();
    if (iterator.hasNext()) {
      boolean newLineAfter = false;
      EditorCell_Collection rootCell = iterator.next().getParent();
      for (EditorCell current : getIndentLeafs(rootCell)) {
        if (isOnNewLine(rootCell, current) || newLineAfter) {
          newLineAfter = false;
          result = result.appendToTheRight(TextBuilder.fromString("\n"));
          for (int i = 0; i < getIndent(rootCell, current, false); i++) {
            result = result.appendToTheRight(TextBuilder.fromString(EditorCell_Indent.getIndentText()), false);
          }
        }

        result = result.appendToTheRight(current.renderText(), PunctuationUtil.hasLeftGap(current));

        if (isNewLineAfter(rootCell, current)) {
          newLineAfter = true;
        }
      }
    }
    return result;
  }

  @Override
  public List<Rectangle> getSelectionBounds(EditorCell_Collection editorCells) {
    List<Rectangle> result = new ArrayList<Rectangle>();
    List<EditorCell> indentLeafs = getIndentLeafs(editorCells);
    for (EditorCell leaf : indentLeafs) {
      result.add(leaf.getBounds());
    }
    return result;
  }

  private List<EditorCell> getIndentLeafs(EditorCell_Collection current) {
    List<EditorCell> result = new ArrayList<EditorCell>();
    collectFrontier(current, result);
    return result;
  }

  private List<EditorCell_Collection> getInternalIndentCollections(EditorCell_Collection current) {
    List<EditorCell_Collection> result = new ArrayList<EditorCell_Collection>();
    collectCollections(current, result);
    return result;
  }

  private void collectFrontier(EditorCell_Collection current, List<EditorCell> frontier) {
    for (EditorCell child : current) {
      if (child instanceof EditorCell_Collection) {
        EditorCell_Collection collection = (EditorCell_Collection) child;
        if (isIndentCollection(collection)) {
          collectFrontier(collection, frontier);
        } else {
          frontier.add(child);
        }
      } else {
        frontier.add(child);
      }
    }
  }

  private void collectCollections(EditorCell_Collection current, List<EditorCell_Collection> result) {
    for (EditorCell child : current) {
      if (child instanceof EditorCell_Collection) {
        EditorCell_Collection collection = (EditorCell_Collection) child;
        if (isIndentCollection(collection)) {
          collectCollections(collection, result);
        }
      }
    }

    result.add(current);
  }

  private boolean isIndentCollection(EditorCell_Collection collection) {
    return collection.getCellLayout() instanceof CellLayout_Indent && collection.getChildCount() > 0;
  }

  private class CellLayouter {
    private EditorCell_Collection myCell;

    private int myX;
    private int myWidth;
    private int myHeight;
    private int myMaxWidth;

    private int myLineWidth;
    private int myLineAscent;
    private int myLineDescent;
    private int myTopInset;
    private int myBottomInset;
    private boolean myOverflow;
    private List<EditorCell> myLineContent = new ArrayList<EditorCell>();

    private CellLayouter(EditorCell_Collection cell) {
      myCell = cell;

      myX = myCell.getX();

      myWidth = 0;
      myHeight = 0;

      myLineWidth = 0;
      myLineAscent = 0;
      myLineDescent = 0;
      myTopInset = 0;
      myBottomInset = 0;

      EditorSettings settings = EditorSettings.getInstance();
      myMaxWidth = cell.getRootParent().getX() + settings.getVerticalBoundWith();
    }

    public void layout() {
      layoutLeafs();
      fixupCollections();
    }

    private void layoutLeafs() {
      for (EditorCell current : getIndentLeafs(myCell)) {
        if (isOnNewLine(myCell, current)) {
          newLine();
        }

        appendCell(current);

        if (haveToSplit()) {
          splitLineAt(findSplitPoint());
        }

        if (isNewLineAfter(myCell, current)) {
          newLine();
        }
      }
      newLine();
    }

    private void fixupCollections() {
      for (EditorCell_Collection collection : getInternalIndentCollections(myCell)) {
        int x0 = Integer.MAX_VALUE;
        int y0 = Integer.MAX_VALUE;
        int x1 = Integer.MIN_VALUE;
        int y1 = Integer.MIN_VALUE;

        for (EditorCell child : collection) {
          x0 = Math.min(x0, child.getX());
          y0 = Math.min(y0, child.getY());
          x1 = Math.max(x1, child.getX() + child.getWidth());
          y1 = Math.max(y1, child.getY() + child.getHeight());
        }

        collection.setX(x0);
        collection.setY(y0);
        collection.setWidth(x1 - x0);
        collection.setHeight(y1 - y0);

        if (collection != myCell) {
          collection.setAscent(getAscent(collection));
          collection.setDescent(getDescent(collection));
        }
      }
    }

    private void appendCell(EditorCell cell) {
      if (myLineContent.isEmpty()) {
        myLineWidth += getIndent(cell) * getIndentWidth();
      }

      PunctuationUtil.addGaps(cell.getParent(), cell);

      cell.setX(myX + myLineWidth);
      cell.relayout();

      myLineAscent = Math.max(myLineAscent, cell.getAscent());
      myLineDescent = Math.max(myLineDescent, cell.getDescent());
      myTopInset = Math.max(myTopInset, cell.getTopInset());
      myBottomInset = Math.max(myBottomInset, cell.getBottomInset());

      myLineWidth += cell.getWidth();

      myLineContent.add(cell);
    }

    private void newLine() {
      newLine(false);
    }

    private void newLine(boolean overflow) {
      int baseLine = myCell.getY() + myHeight + myTopInset + myLineAscent;

      for (EditorCell cell : myLineContent) {
        cell.setBaseline(baseLine);
      }

      myWidth = Math.max(myWidth, myLineWidth);
      myHeight += myTopInset + myBottomInset + myLineAscent + myLineDescent;
      myOverflow = overflow;

      resetLine();
    }

    private void resetLine() {
      myLineWidth = 0;
      myLineWidth = 0;
      myLineAscent = 0;
      myLineDescent = 0;
      myTopInset = 0;
      myBottomInset = 0;
      myLineContent.clear();
    }

    private boolean haveToSplit() {
      return myX + myLineWidth > myMaxWidth && myLineContent.size() > 1;
    }

    private EditorCell findSplitPoint() {
      EditorCell lastCell = myLineContent.get(myLineContent.size() - 1);
      EditorCell result = lastCell;

      EditorCell current = result;

      while (true) {
        if (!isIndentCollection(current.getParent())) break;

        EditorCell indentLeaf = getFirstIndentLeaf(current.getParent());
        EditorCell unitStart = expandToUnitStart(indentLeaf);

        if (myLineContent.contains(unitStart) && isOnRightSide(unitStart) &&
          cellRangeFitsOnOneLine(unitStart, lastCell)) {

          result = indentLeaf;
          current = current.getParent();
        } else {
          break;
        }
      }

      return expandToUnitStart(result);
    }

    private EditorCell expandToUnitStart(EditorCell cell) {
      EditorCell result = cell;

      while (true) {
        EditorCell prevLeaf = result.getPrevLeaf();

        if (!myCell.isAncestorOf(prevLeaf)) break;
        if (!myLineContent.contains(prevLeaf)) break;

        if (isNoWrap(result) || result.getStyle().get(StyleAttributes.PUNCTUATION_LEFT) ||
          prevLeaf.getStyle().get(StyleAttributes.PUNCTUATION_RIGHT)) {

          result = prevLeaf;
        } else {
          break;
        }
      }

      return result;
    }

    private Boolean isNoWrap(EditorCell current) {
      while (current != null) {
        if (current.getStyle().get(StyleAttributes.INDENT_LAYOUT_NO_WRAP)) {
          return true;
        }
        if (current.getParent().getFirstChild() == current) {
          current = current.getParent();
        } else {
          return false;
        }
      }
      return false;
    }

    private boolean cellRangeFitsOnOneLine(EditorCell firstCell, EditorCell lastCell) {
      return lastCell.getX() + lastCell.getWidth() - firstCell.getX() <
        myMaxWidth - myX - (getIndent(firstCell) + 1) * getIndentWidth();
    }

    private boolean isOnRightSide(EditorCell cell) {
      return cell.getX() + cell.getWidth() - myX > myMaxWidth / 2;
    }

    private EditorCell getFirstIndentLeaf(EditorCell_Collection collection) {
      if (!isIndentCollection(collection)) return collection;

      EditorCell firstChild = collection.getFirstChild();
      if (firstChild instanceof EditorCell_Collection) {
        return getFirstIndentLeaf((EditorCell_Collection) firstChild);
      }

      return firstChild;
    }

    private void splitLineAt(EditorCell splitAt) {
      int index = myLineContent.indexOf(splitAt);
      if (index == -1) throw new IllegalStateException();

      List<EditorCell> oldLine = new ArrayList<EditorCell>(myLineContent.subList(0, index));
      List<EditorCell> newLine = new ArrayList<EditorCell>(myLineContent.subList(index, myLineContent.size()));

      resetLine();

      for (EditorCell cell : oldLine) {
        appendCell(cell);
      }

      if (!oldLine.isEmpty()) {
        newLine(true);
      }

      for (EditorCell cell : newLine) {
        appendCell(cell);
      }
    }

    private int getIndentWidth() {
      EditorSettings settings = EditorSettings.getInstance();
      return settings.getSpacesWidth(settings.getIndentSize());
    }

    private int getIndent(EditorCell cell) {
      return CellLayout_Indent.getIndent(myCell, cell, myOverflow);
    }

  }

}
