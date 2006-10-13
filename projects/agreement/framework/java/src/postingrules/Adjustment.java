package postingrules;

import mf.MfDate;

import java.util.ArrayList;
import java.util.List;

abstract public class Adjustment extends AccountingEvent{
    protected List<AccountingEvent> myNewEvents = new ArrayList<AccountingEvent>();
    protected List<AccountingEvent> myOldEvents = new ArrayList<AccountingEvent>();

    public Adjustment(AccountingEvent replacement, AccountingEvent adjustedEvent) {
        this(replacement.getWhenNoticed(), replacement.getWhenNoticed(), replacement.getSubject());
        addOld(adjustedEvent);
        addNew(replacement);
    }
    public Adjustment(MfDate whenOccurred, MfDate whenNoticed, Subject subject) {
        super(null, whenOccurred, whenNoticed, subject);
    }
    public void addNew(AccountingEvent arg) {
        myNewEvents.add(arg);
    }
    public void addOld(AccountingEvent arg) {
        if (arg.hasBeenAdjusted())
            throw new IllegalArgumentException("Cannot create " + this + ". " + arg + " is already adjusted");
        myOldEvents.add(arg);
        arg.setReplacementEvent(this);
    }
}
