package com.example.trade.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRADE_TBL")
public class TradeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long tradeId;

	@Column(name = "Version")
	int version;
	@Column(name = "COUNTER_PARTY_ID")
	String counterPart;
	@Column(name = "Book_Id")
	String bookId;
	@Column(name = "Maturity_Date")
	Date maturityDate;
	@Column(name = "Create_Date")
	Date createdDate;
	@Column(name = "Expired")
	char expired;

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterPart() {
		return counterPart;
	}

	public void setCounterPart(String counterPart) {
		this.counterPart = counterPart;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public char getExpired() {
		return expired;
	}

	public void setExpired(char expired) {
		this.expired = expired;
	}

}
