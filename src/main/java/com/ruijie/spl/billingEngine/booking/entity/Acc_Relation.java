package com.ruijie.spl.billingEngine.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Acc_Relation")
public class Acc_Relation {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AccRel_ID")
    private long  accRelId;
	
	@Column(name = "sorucefee_id")
	private int sourceFeeID;
	
	@Column(name = "AccountTypeBook")
    private String accountTypeBook;

	@Column(name = "Priority")
    private int Priority;

	public long getAccRelId() {
		return accRelId;
	}

	public void setAccRelId(long accRelId) {
		this.accRelId = accRelId;
	}

	public int getSourceFeeID() {
		return sourceFeeID;
	}

	public void setSourceFeeID(int sourceFeeID) {
		this.sourceFeeID = sourceFeeID;
	}

	public String getAccountTypeBook() {
		return accountTypeBook;
	}

	public void setAccountTypeBook(String accountTypeBook) {
		this.accountTypeBook = accountTypeBook;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}
}
