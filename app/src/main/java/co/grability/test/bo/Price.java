package co.grability.test.bo;

import java.io.Serializable;

public class Price implements Serializable {

    private String label;
    private Double amount;
    private String currency;

    public Price() {
    }

    public Price(String label, Double amount, String currency) {
        this.label = label;
        this.amount = amount;
        this.currency = currency;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}