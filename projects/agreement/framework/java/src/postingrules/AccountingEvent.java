package postingrules;

import mf.*;

import java.util.*;

public class AccountingEvent {
  //<codeFragment name = "data">
  private EventType type;
  private MfDate whenOccurred;
  private MfDate whenNoticed;
  private Subject subject;
//</codeFragment>

  protected List secondaryEvents = new ArrayList();
  protected Collection<Entry> resultingEntries = new HashSet<Entry>();
  protected boolean isProcessed = false;
  private AccountingEvent replacementEvent;

  public AccountingEvent(EventType type, MfDate whenOccurred, MfDate whenNoticed, Subject subject) {
    this.type = type;
    this.whenOccurred = whenOccurred;
    this.whenNoticed = whenNoticed;
    this.subject = subject;
  }

  void addResultingEntry(Entry arg) {
    resultingEntries.add(arg);
  }

  void friendAddSecondaryEvent(AccountingEvent arg) {
    // only to be called by the secondary event's setting method
    secondaryEvents.add(arg);
  }

  /**
   * returns all entries, both directly caused by this event,
   * and all entries caused by any secondary events
   */
  public Set<Entry> getAllResultingEntries() {
    Set<Entry> result = new HashSet<Entry>();
    result.addAll(resultingEntries);
    for (Object secondaryEvent : secondaryEvents) {
      AccountingEvent each = (AccountingEvent) secondaryEvent;
      result.addAll(each.getAllResultingEntries());
    }
    return result;
  }

  EventType getEventType() {
    return type;
  }

  AccountingEvent getReplacementEvent() {
    return replacementEvent;
  }

  /**
   * entries caused directly by this event.
   */
  public Collection<Entry> getResultingEntries() {
    return Collections.unmodifiableCollection(resultingEntries);
  }

  List getSecondaryEvents() {
    return Collections.unmodifiableList(secondaryEvents);
  }

  public Subject getSubject() {
    return subject;
  }

  public MfDate getWhenNoticed() {
    return whenNoticed;
  }

  public MfDate getWhenOccurred() {
    return whenOccurred;
  }

  public boolean hasBeenAdjusted() {
    return (replacementEvent != null);
  }

  public boolean isProcessed() {
    return isProcessed;
  }

  public void markProcessed() {
    isProcessed = true;
  }

  //<codeFragment name = "process">
  public void process() {
    assert!isProcessed;
    if (adjustedEvent != null) adjustedEvent.reverse();
    subject.process(this);
    markProcessed();
  }
//</codeFragment>

  public void reverse() {
    assert isProcessed();
    Entry[] entries = (Entry[]) getResultingEntries().toArray(new Entry[0]);
    for (Entry entry : entries) {
      subject.reverseEntry(entry);
    }
    reverseSecondaryEvents();
  }

  private void reverseSecondaryEvents() {
    for (Object o : getSecondaryEvents()) {
      AccountingEvent each = (AccountingEvent) o;
      each.reverse();
    }
  }

  void setIsProcessed(boolean newIsProcessed) {
    isProcessed = newIsProcessed;
  }

  public void setReplacementEvent(AccountingEvent newReplacementEvent) {
    replacementEvent = newReplacementEvent;
  }

  //    --------------------- direct reversing example support --------------------------------
  private AccountingEvent adjustedEvent;

  public AccountingEvent(EventType type, MfDate whenOccurred, MfDate whenNoticed, Subject subject, AccountingEvent adjustedEvent) {
    this(type, whenOccurred, whenNoticed, subject);
    this.adjustedEvent = adjustedEvent;
    adjustedEvent.setReplacementEvent(this);
  }

  public ServiceAgreement getAgreement() {
    return ((Customer) getSubject()).getServiceAgreement();
  }
}
