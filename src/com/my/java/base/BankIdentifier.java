package com.my.java.base;

public class BankIdentifier {
    private String bankId;
    private String identifierId;
    private String identifierValue;

    public BankIdentifier(String bankId, String identifierId, String identifierValue) {
        this.bankId = bankId;
        this.identifierId = identifierId;
        this.identifierValue = identifierValue;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getIdentifierId() {
        return identifierId;
    }

    public void setIdentifierId(String identifierId) {
        this.identifierId = identifierId;
    }

    public String getIdentifierValue() {
        return identifierValue;
    }

    public void setIdentifierValue(String identifierValue) {
        this.identifierValue = identifierValue;
    }
}
