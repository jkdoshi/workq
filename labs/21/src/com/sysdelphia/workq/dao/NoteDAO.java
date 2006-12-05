package com.sysdelphia.workq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sysdelphia.workq.domain.Note;

public class NoteDAO {
	private static final String DATASOURCE_JNDI_NAME = "java:comp/env/jdbc/WorkQDB";

	private static final String SQL_SELECT = "SELECT id, creator, create_timestamp, category, body FROM note";

	private DataSource dataSource;

	public NoteDAO() throws NamingException {
		dataSource = (DataSource) new InitialContext()
				.lookup(DATASOURCE_JNDI_NAME);
	}

	public List<Note> findAll() throws SQLException {
		List<Note> rows = new ArrayList<Note>();
		Connection db = dataSource.getConnection();
		try {
			PreparedStatement st = db.prepareStatement(SQL_SELECT);
			try {
				// no params to set
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Note row = new Note();
					row.setId(rs.getLong("id"));
					row.setCreator(rs.getString("creator"));
					row.setCategory(rs.getInt("category"));
					row.setCreateTimestamp(rs.getTimestamp("create_timestamp"));
					row.setBody(rs.getString("body"));
					rows.add(row);
				}
				return rows;
			} finally {
				st.close();
			}
		} finally {
			db.close();
		}
	}
}
