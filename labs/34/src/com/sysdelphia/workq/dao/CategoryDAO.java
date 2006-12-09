package com.sysdelphia.workq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sysdelphia.workq.domain.Category;

public class CategoryDAO extends JdbcDaoSupport {
	private static final String SQL_FINDALL = "SELECT id, name FROM category";
	private NoteDAO noteDAO;

	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	private class CategoryRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getLong(1));
			category.setName(rs.getString(2));
			category.setNoteDAO(noteDAO);
			return category;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		return getJdbcTemplate().query(SQL_FINDALL, new Object[] {},
				new CategoryRowMapper());
	}
}
