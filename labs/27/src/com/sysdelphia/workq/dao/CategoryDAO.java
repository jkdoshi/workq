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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sysdelphia.workq.domain.Category;

public class CategoryDAO {
	private static final Log log = LogFactory.getLog(CategoryDAO.class);

	private static final String DATASOURCE_JNDI_NAME = "java:comp/env/jdbc/WorkQDB";

	private static final String SQL_FINDALL = "SELECT id, name FROM category";

	private DataSource dataSource;

	public CategoryDAO() throws NamingException {
		dataSource = (DataSource) new InitialContext()
				.lookup(DATASOURCE_JNDI_NAME);
	}

	public List<Category> findAll() throws SQLException {
		List<Category> rows = new ArrayList<Category>();
		Connection db = dataSource.getConnection();
		try {
			log.debug("SQL: " + SQL_FINDALL);
			PreparedStatement st = db.prepareStatement(SQL_FINDALL);
			try {
				// no params to set
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Category row = new Category();
					row.setId(rs.getLong("id"));
					row.setName(rs.getString("name"));
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
