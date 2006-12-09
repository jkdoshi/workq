package com.sysdelphia.workq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sysdelphia.workq.domain.Note;

public class NoteDAO extends JdbcDaoSupport {
	private static final String SQL_FINDALL = "SELECT id, creator, create_timestamp, category, body FROM note";

	private static final String SQL_FINDBYCATEGORY = SQL_FINDALL
			+ " WHERE category = ?";

	private static class NoteRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Note note = new Note();
			note.setId(rs.getLong(1));
			note.setCreator(rs.getString(2));
			note.setCreateTimestamp(rs.getTimestamp(3));
			note.setCategory(rs.getInt(4));
			note.setBody(rs.getString(5));
			return note;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Note> findAll() {
		return getJdbcTemplate().query(SQL_FINDALL, new Object[] {},
				new NoteRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Note> findByCategory(long categoryId) {
		return getJdbcTemplate().query(SQL_FINDBYCATEGORY,
				new Object[] { categoryId }, new NoteRowMapper());
	}
}
