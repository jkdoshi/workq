package com.sysdelphia.workq.domain;

import java.util.List;

import com.sysdelphia.workq.dao.NoteDAO;

public class Category {
	private long id;

	private String name;

	private NoteDAO noteDAO;

	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Note> getNotes() {
		return noteDAO.findByCategory(id);
	}
}
