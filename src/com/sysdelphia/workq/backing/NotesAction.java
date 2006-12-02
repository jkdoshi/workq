package com.sysdelphia.workq.backing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.sysdelphia.workq.domain.Note;

public class NotesAction {
	private List<Note> rows = new ArrayList<Note>();

	public List getRows() {
		return rows;
	}

	public String fetchRows() {
		rows.clear();
		for (int i = 0; i < 10; i++) {
			rows.add(newNote(i));
		}
		return "";
	}

	private Note newNote(int index) {
		Note note = new Note();
		note.setId(index);
		note.setCreateTimestamp(new Timestamp(System.currentTimeMillis()));
		note.setCategory(index % 5);
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		note.setCreator(request.getRemoteUser());
		note.setBody("This is note number " + index);
		return note;
	}
}
