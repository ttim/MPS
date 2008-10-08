package jetbrains.mps.baseLanguage.dates.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;

public class ScheduleLiteral_Behavior {

  public static void init(SNode thisNode) {
  }

  public static boolean call_hasDay_1213877270117(SNode thisNode) {
    return (SLinkOperations.getTarget(thisNode, "schedulePeriod", false) != null) && (SPropertyOperations.getBoolean(SLinkOperations.getTarget(thisNode, "schedulePeriod", false), "dayOfMonth") || SPropertyOperations.getBoolean(SLinkOperations.getTarget(thisNode, "schedulePeriod", false), "dayOfWeek"));
  }

  public static boolean call_hasTime_1213877270139(SNode thisNode) {
    return (SLinkOperations.getTarget(thisNode, "schedulePeriod", false) != null) && (SPropertyOperations.getBoolean(SLinkOperations.getTarget(thisNode, "schedulePeriod", false), "hour") || SPropertyOperations.getBoolean(SLinkOperations.getTarget(thisNode, "schedulePeriod", false), "minute") || SPropertyOperations.getBoolean(SLinkOperations.getTarget(thisNode, "schedulePeriod", false), "second"));
  }

  public static String call_toCronExpression_1213877270167(SNode thisNode) {
    SNode period = SLinkOperations.getTarget(thisNode, "schedulePeriod", false);
    String second = (SPropertyOperations.getBoolean(period, "second") ?
      ScheduleLiteral_Behavior.call_cutLeadingZero_1213877270281(thisNode, SPropertyOperations.getString(thisNode, "second")) :
      "0"
    );
    String minute = (SPropertyOperations.getBoolean(period, "minute") ?
      ScheduleLiteral_Behavior.call_cutLeadingZero_1213877270281(thisNode, SPropertyOperations.getString(thisNode, "minute")) :
      "*"
    );
    String hour = (SPropertyOperations.getBoolean(period, "hour") ?
      ScheduleLiteral_Behavior.call_cutLeadingZero_1213877270281(thisNode, SPropertyOperations.getString(thisNode, "hour")) :
      "*"
    );
    String dayOfMonth = (SPropertyOperations.getBoolean(period, "dayOfMonth") ?
      SPropertyOperations.getString(thisNode, "dayOfMonth") :
      ((SPropertyOperations.getBoolean(period, "dayOfWeek") ?
        "?" :
        "*"
      ))
    );
    String month = (SPropertyOperations.getBoolean(period, "month") ?
      SPropertyOperations.getString(SLinkOperations.getTarget(thisNode, "month", false), "shortName") :
      "*"
    );
    String dayOfWeek = (SPropertyOperations.getBoolean(period, "dayOfWeek") ?
      SPropertyOperations.getString_def(thisNode, "dayOfWeek", "SUN") :
      "?"
    );
    return second + " " + minute + " " + hour + " " + dayOfMonth + " " + month + " " + dayOfWeek;
  }

  public static String call_cutLeadingZero_1213877270281(SNode thisNode, String s) {
    return ((s.length() == 2 && s.startsWith("0")) ?
      s.substring(1) :
      s
    );
  }

}
