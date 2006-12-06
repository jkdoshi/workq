package com.sysdelphia.workq.backing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.sysdelphia.workq.dao.NoteDAO;
import com.sysdelphia.workq.domain.Note;

public class NotesAction {
	private List<Note> rows = new ArrayList<Note>();

	private NoteDAO dao;

	private Long selectedId;

	private Note selected;

	public List getRows() {
		return rows;
	}

	public String fetchRows() {
		rows = dao.findAll();
		return "";
	}

	public Long getSelectedId() {
		return selectedId;
	}

	public void setDao(NoteDAO dao) {
		this.dao = dao;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
		if (selectedId == null) {
			this.selected = null;
		} else {
			this.selected = dao.findById(selectedId);
		}
	}

	public Note getSelected() {
		return selected;
	}

	public void saveSelected() {
		dao.save(selected);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Saved Successfully", "Note ID " + selected.getId()
						+ " was saved");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		setSelectedId(null);
	}

	public void createNew() {
		setSelectedId(null);
		this.selected = new Note();
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx
				.getExternalContext().getRequest();
		this.selected.setCreator(request.getRemoteUser());
	}
}
