package com.sysdelphia.workq.domain;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.sysdelphia.workq.dao.NoteDAO;

public class Category {
	private long id;

	private String name;

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
	
	public List<Note> getNotes() throws NamingException, SQLException {
		return new NoteDAO().findByCategory(id);
	}
}
