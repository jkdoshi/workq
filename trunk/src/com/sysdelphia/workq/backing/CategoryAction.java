package com.sysdelphia.workq.backing;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.sysdelphia.workq.dao.CategoryDAO;
import com.sysdelphia.workq.domain.Category;

public class CategoryAction {
	private List<Category> rows;

	private long selectedId = -1;

	private CategoryDAO dao;

	public void setDao(CategoryDAO dao) {
		this.dao = dao;
	}

	public String fetchRows() throws SQLException, NamingException {
		rows = dao.findAll();
		return "";
	}

	public List<Category> getRows() {
		return rows;
	}

	public long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(long selectedId) {
		this.selectedId = selectedId;
	}
}
