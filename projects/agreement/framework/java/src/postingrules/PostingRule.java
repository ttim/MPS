package postingrules;

import mf.Money;

public abstract class PostingRule {
//<codeFragment name = "data">
    private AccountType myType;
    private boolean myTaxable;
    protected PostingRule(AccountType type, boolean isTaxable) {
        this.myType = type;
        this.myTaxable = isTaxable;
    }
//</codeFragment>

//<codeFragment name = "process">
    public void process(AccountingEvent evt) {
        makeEntry(evt, calculateAmount(evt));
        if (myTaxable) generateTax(evt);
    }
    abstract protected Money calculateAmount(AccountingEvent evt);
    private void makeEntry(AccountingEvent evt, Money amount) {
        Entry newEntry = new Entry(amount, evt.getWhenNoticed());
        evt.getSubject().addEntry(newEntry, myType);
        evt.addResultingEntry(newEntry);
    }
//</codeFragment>
    private void generateTax(AccountingEvent evt) {
        new TaxEvent(evt, calculateAmount(evt)).process();
    }

}
