package jetbrains.mps.generator.impl;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.GenerationException;

public class DismissTopMappingRuleException extends GenerationException {
  private DismissTopMappingRuleException.MessageType myMessageType;

  public DismissTopMappingRuleException(DismissTopMappingRuleException.MessageType messageType) {
    myMessageType = messageType;
  }

  public boolean isLoggingNeeded() {
    return myMessageType != null;
  }

  public boolean isInfo() {
    return myMessageType != null && myMessageType == DismissTopMappingRuleException.MessageType.info;
  }

  public boolean isWarning() {
    return myMessageType != null && myMessageType == DismissTopMappingRuleException.MessageType.warning;
  }

  public boolean isError() {
    return myMessageType != null && myMessageType == DismissTopMappingRuleException.MessageType.error;
  }

  public static   enum MessageType {
    info(),
    warning(),
    error();

    MessageType() {
    }
  }
}
