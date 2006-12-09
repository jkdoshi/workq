package com.sysdelphia.workq.backing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.sysdelphia.workq.dao.NoteDAO;
import com.sysdelphia.workq.domain.Note;

public class NotesAction {
	private List<Note> rows = new ArrayList<Note>();

	private long selectedId;

	public List getRows() {
		return rows;
	}

	public String fetchRows() throws SQLException, NamingException {
		rows = new NoteDAO().findAll();
		return "";
	}

	public long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(long selectedId) {
		this.selectedId = selectedId;
	}
}
