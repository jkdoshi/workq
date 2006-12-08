package com.sysdelphia.workq.backing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.sysdelphia.workq.dao.LoanInfoDAO;
import com.sysdelphia.workq.domain.Document;
import com.sysdelphia.workq.domain.LoanInfo;

public class LoanInfoAction {
	private List<LoanInfo> rows = new ArrayList<LoanInfo>();

	private LoanInfoDAO dao;

	private String selectedId;

	private LoanInfo selected;

	private Document selectedDoc;
	
	private String listMode = "queued";

	public List getRows() {
		return rows;
	}

	public String fetchRows() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx
				.getExternalContext().getRequest();
		if("queued".equals(listMode)) {
			rows = dao.findByUserQueue(request.getRemoteUser());
		} else {
			// pending
			// rows = dao.findByUserPending(request.getRemoteUser());
			rows = null;
		}
		return "";
	}

	public String getSelectedId() {
		return selectedId;
	}

	public void setDao(LoanInfoDAO dao) {
		this.dao = dao;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
		if (selectedId == null) {
			this.selected = null;
		} else {
			this.selected = dao.findById(selectedId);
		}
	}

	public LoanInfo getSelected() {
		return selected;
	}

	public Document getSelectedDoc() {
		return selectedDoc;
	}

	public void setSelectedDoc(Document doc) {
		this.selectedDoc = doc;
	}

	public String getListMode() {
		return listMode;
	}

	public void setListMode(String listMode) {
		this.listMode = listMode;
	}
}
