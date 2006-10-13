package postingrules;

import mf.Money;

public class TaxEvent extends MonetaryEvent {
  public TaxEvent(AccountingEvent base, Money taxableAmount) {
        super(taxableAmount, EventType.TAX, base.getWhenOccurred(), base.getWhenNoticed(), base.getSubject());
    base.friendAddSecondaryEvent(this);
        assert base.getEventType() != getEventType(): "Probable endless recursion";
    }

}
