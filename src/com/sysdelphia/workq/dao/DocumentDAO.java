package com.sysdelphia.workq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sysdelphia.workq.domain.Document;

public class DocumentDAO extends JdbcDaoSupport {
	private static final String SQL_FINDBYID = "SELECT id, name FROM document WHERE id = ?";

	private static final String SQL_FINDBYLOANID = "SELECT id, name FROM document WHERE loan_id = ?";

	private static final class DocumentInfoRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Document doc = new Document();
			doc.setId(rs.getString(1));
			doc.setName(rs.getString(2));
			return doc;
		}
	}

	public Document findById(String id) {
		return (Document) getJdbcTemplate().queryForObject(SQL_FINDBYID,
				new Object[] { id }, new DocumentInfoRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Document> findByLoanId(String loanId) {
		return getJdbcTemplate().query(SQL_FINDBYLOANID,
				new Object[] { loanId }, new DocumentInfoRowMapper());
	}
}
