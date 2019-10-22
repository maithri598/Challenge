package com.transaction.example.ServiceImpl;

public class SendMoneyServiceImpl {
	
	private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
    private String currency;
 
    public SendMoneyServiceImpl() {
 
    }
 
    public SendMoneyServiceImpl(Long fromAccountId, Long toAccountId, Double amount, String currency) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.currency=currency;
    }
 
    public Long getFromAccountId() {
        return fromAccountId;
    }
 
    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
 
    public Long getToAccountId() {
        return toAccountId;
    }
 
    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
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
