package com.example.fractallab.model;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {

	private long companyId;

	private long bankId;

	private String accountId;

	private String transactionId;

	private String valueDate;

	private String bookingDate;

	private BigDecimal amount;

	private String currencyCode;

	private String flow;

	private String transactionType;

	private String status;

	private String description;

	private String category;

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Transaction {companyId=" + companyId + ", bankId=" + bankId + ", accountId=" + accountId
				+ ", transactionId=" + transactionId + ", valueDate=" + valueDate + ", bookingDate=" + bookingDate
				+ ", amount=" + amount + ", currencyCode=" + currencyCode + ", flow=" + flow + ", transactionType="
				+ transactionType + ", status=" + status + ", description=" + description + ", category=" + category
				+ '\'' + "}";
	}

}