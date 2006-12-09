package com.sysdelphia.workq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import com.sysdelphia.workq.domain.Note;

public class NoteDAO extends JdbcDaoSupport {
	private static final String SQL_FINDALL = "SELECT id, creator, create_timestamp, category, body FROM note";

	private static final String SQL_FINDBYCATEGORY = SQL_FINDALL
			+ " WHERE category = ?";

	private static final String SQL_FINDBYID = SQL_FINDALL + " WHERE id = ?";

	private static final String SQL_UPDATE = "UPDATE note SET category, body WHERE id = ?";

	private static final String SQL_INSERT = "INSERT INTO note (id, creator, category, body) VALUES (?, ?, ?, ?)";

	private DataFieldMaxValueIncrementer incrementer;

	private class NoteRowMapper implements RowMapper {
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

	public void setIncrementer(DataFieldMaxValueIncrementer incrementer) {
		this.incrementer = incrementer;
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

	public Note findById(long id) {
		return (Note) getJdbcTemplate().queryForObject(SQL_FINDBYID,
				new Object[] { id }, new NoteRowMapper());
	}

	public void save(Note note) {
		if (note.getId() == null) {
			insert(note);
		} else {
			update(note);
		}
	}

	public void update(Note note) {
		Object[] args = new Object[] { note.getCategory(), note.getBody(),
				note.getId() };
		getJdbcTemplate().update(SQL_UPDATE, args);
	}

	public void insert(Note note) {
		Long id = incrementer.nextLongValue();
		Object[] args = new Object[] { id, note.getCreator(),
				note.getCategory(), note.getBody() };
		getJdbcTemplate().update(SQL_INSERT, args);
		note.setId(id);
	}
}
