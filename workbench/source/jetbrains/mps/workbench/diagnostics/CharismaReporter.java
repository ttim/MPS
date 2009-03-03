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
package jetbrains.mps.workbench.diagnostics;

import com.intellij.openapi.diagnostic.ErrorReportSubmitter;
import com.intellij.openapi.diagnostic.IdeaLoggingEvent;
import com.intellij.openapi.diagnostic.SubmittedReportInfo;
import com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.ide.blame.dialog.BlameDialog;
import jetbrains.mps.ide.blame.dialog.BlameDialogComponent;
import jetbrains.mps.ide.blame.perform.Response;
import jetbrains.mps.logging.Logger;

import java.awt.Component;

public class CharismaReporter extends ErrorReportSubmitter {
  private static final Logger LOG = Logger.getLogger(CharismaReporter.class);

  public String getReportActionText() {
    return "Report To JetBrains MPS Tracker";
  }

  public SubmittedReportInfo submit(IdeaLoggingEvent[] events, final Component parentComponent) {
    assert ThreadUtils.isEventDispatchThread();

    if (events.length == 0) {
      return new SubmittedReportInfo(null, null, SubmissionStatus.FAILED);
    }

    BlameDialog blameDialog = BlameDialogComponent.getInstance().createDialog(parentComponent);
    blameDialog.setEx(events[0].getThrowable());
    blameDialog.setIssueTitle(events[0].getMessage());

    blameDialog.showDialog();

    if (blameDialog.isCancelled()) {
      return new SubmittedReportInfo(null, "Cancelled issue submit", SubmissionStatus.FAILED);
    } else {
      Response response = blameDialog.getResult();
      assert response != null : "Response must not be null";
      if (response.isSuccess()) {
        return new SubmittedReportInfo(null, "", SubmissionStatus.NEW_ISSUE);
      } else {
        LOG.error("Submit failed: " + response.getMessage(), response.getThrowable());
        return new SubmittedReportInfo(null, "Submit failed: " + response.getMessage(), SubmissionStatus.FAILED);
      }
    }
  }
}
