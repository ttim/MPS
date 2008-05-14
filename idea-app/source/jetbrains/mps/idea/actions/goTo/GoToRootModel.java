/*
 * Copyright (c) 2004 JetBrains s.r.o. All  Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * -Redistributions of source code must retain the above copyright
 *  notice, this list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduct the above copyright
 *  notice, this list of conditions and the following disclaimer in
 *  the documentation and/or other materials provided with the distribution.
 *
 * Neither the name of JetBrains or IntelliJ IDEA
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. JETBRAINS AND ITS LICENSORS SHALL NOT
 * BE LIABLE FOR ANY DAMAGES OR LIABILITIES SUFFERED BY LICENSEE AS A RESULT
 * OF OR RELATING TO USE, MODIFICATION OR DISTRIBUTION OF THE SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL JETBRAINS OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE, EVEN
 * IF JETBRAINS HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 */
package jetbrains.mps.idea.actions.goTo;

import com.intellij.ide.util.NavigationItemListCellRenderer;
import com.intellij.ide.util.gotoByName.ChooseByNameModel;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.util.SystemInfo;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Calculable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.ListCellRenderer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoToRootModel implements ChooseByNameModel {
  private static final Logger LOG = Logger.getInstance("#com.intellij.ide.util.gotoByName.ContributorsBasedGotoByModel");

  private MPSProject myProject;
  private IOperationContext myContext;
  private SNode[] myNodes;

  public GoToRootModel(MPSProject project, IOperationContext context) {
    myProject = project;
    myContext = context;
    myNodes = loadItems();
  }

  public SNode[] loadItems() {
    final List<SNode> nodes = new ArrayList<SNode>();
    CommandProcessor.instance().executeLightweightCommand(new Runnable() {
      public void run() {
        List<SModelDescriptor> modelDescriptors = GlobalScope.getInstance().getModelDescriptors();

        for (SModelDescriptor modelDescriptor : modelDescriptors) {
          if (SModelStereotype.JAVA_STUB.equals(modelDescriptor.getStereotype())) continue;
          for (SNode node : modelDescriptor.getSModel().getRoots()) {
            nodes.add(node);
          }
        }
      }
    });
    return nodes.toArray(new SNode[0]);
  }

  public String[] getNames(boolean checkBoxState) {
    final Set<String> names = new HashSet<String>();

    CommandProcessor.instance().executeLightweightCommand(new Runnable() {
      public void run() {
        for (SNode node : myNodes) {
          try {
            names.add(node.getName());
          } catch (ProcessCanceledException ex) {
            // index corruption detected, ignore
          } catch (Exception ex) {
            LOG.error(ex);
          }
        }
      }
    });

    return names.toArray(new String[names.size()]);
  }

  public Object[] getElementsByName(final String name, boolean checkBoxState, final String pattern) {
    final List<NodeNavigationItem> items = new ArrayList<NodeNavigationItem>();

    CommandProcessor.instance().executeLightweightCommand(new Runnable() {
      public void run() {
        for (SNode node : myNodes) {
          try {
            if (node.getName() != null && node.getName().equals(name)) {
              items.add(new NodeNavigationItem(myContext, node));
            }
          } catch (ProcessCanceledException ex) {
            // index corruption detected, ignore
          } catch (Exception ex) {
            LOG.error(ex);
          }
        }
      }
    });
    return items.toArray();
  }

  public String getElementName(final Object element) {
    return CommandProcessor.instance().executeLightweightCommand(new Calculable<String>() {
      public String calculate() {
        return ((NodeNavigationItem) element).getName();
      }
    });
  }

  public char getCheckBoxMnemonic() {
    // Some combination like Alt+N, Ant+O, etc are a dead symbols, therefore
    // we have to change mnemonics for Mac users.
    return SystemInfo.isMac ? 'P' : 'n';
  }

  public boolean loadInitialCheckBoxState() {
    //PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(myProject);
    //return Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToClass.toSaveIncludeLibraries")) &&
    //  Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToClass.includeLibraries"));
    return false;
  }

  public void saveInitialCheckBoxState(boolean state) {
    //PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(myProject);
    //if (Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToClass.toSaveIncludeLibraries"))) {
    //  propertiesComponent.setValue("GoToClass.includeLibraries", Boolean.toString(state));
    //}
  }

  public String getFullName(final Object element) {
    /*for (ChooseByNameContributor c : getContributors()) {
      if (c instanceof GotoClassContributor) {
        String result = ((GotoClassContributor) c).getQualifiedName((NavigationItem) element);
        if (result != null) return result;
      }
    }

    return getElementName(element);
    */
    return CommandProcessor.instance().executeLightweightCommand(new Calculable<String>() {
      public String calculate() {
        return ((NodeNavigationItem) element).getName();
      }
    });
  }

  @NotNull
  public String[] getSeparators() {
    return new String[]{"."};
  }

  @Nullable
  public String getPromptText() {
    //return IdeBundle.message("prompt.gotoclass.enter.class.name");
    return "prompt";
  }

  public String getCheckBoxName() {
    //return IdeBundle.message("checkbox.include.non.project.classes");
    return "temp trash";
  }

  public String getNotInMessage() {
    //return IdeBundle.message("label.no.matches.found.in.project");
    return "not in message";
  }

  public String getNotFoundMessage() {
    //return IdeBundle.message("label.no.matches.found");
    return "not found";
  }

  public ListCellRenderer getListCellRenderer() {
    /*return new ListCellRenderer() {
      public Component getListCellRendererComponent(JList list, final Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String name = CommandProcessor.instance().executeLightweightCommand(new Calculable<String>() {
          public String calculate() {
            String name1 = ((NodeNavigationItem) value).getName();
            return (name1 == null) ? "" : name1;
          }
        });
        return new JLabel(name);
      }
    };
    */
    return new NavigationItemListCellRenderer();
  }
}