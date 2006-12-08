package com.sysdelphia.workq.domain;

import java.util.List;

import com.sysdelphia.workq.dao.DocumentDAO;

public class LoanInfo {
	private String id;

	private String loanNumber;

	private String borrName;

	private DocumentDAO docDAO;

	public void setDocDAO(DocumentDAO docDao) {
		this.docDAO = docDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getBorrName() {
		return borrName;
	}

	public void setBorrName(String borrName) {
		this.borrName = borrName;
	}

	public List<Document> getDocuments() {
		return docDAO.findByLoanId(this.id);
	}
}
