package com.sysdelphia.workq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sysdelphia.workq.domain.LoanInfo;

public class LoanInfoDAO extends JdbcDaoSupport {
	private static final String SQL_FINDALL = "SELECT id, loan_number, borr_name FROM loan_info";

	private static final String SQL_FINDBYID = SQL_FINDALL + " WHERE id = ?";

	private static final String SQL_FINDBYNUMBER = SQL_FINDALL
			+ " WHERE loan_number = ?";

	private static final String SQL_FINDBYQUEUE = SQL_FINDALL
			+ " l, user_loan_queue q WHERE l.id = q.loan_id AND q.user_id = ?";

	private class LoanInfoRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			LoanInfo loan = new LoanInfo();
			loan.setId(rs.getString(1));
			loan.setLoanNumber(rs.getString(2));
			loan.setBorrName(rs.getString(3));
			loan.setDocDAO(docDAO);
			return loan;
		}
	}

	private DocumentDAO docDAO;

	public void setDocDAO(DocumentDAO docDAO) {
		this.docDAO = docDAO;
	}

	public LoanInfo findById(String id) {
		return (LoanInfo) getJdbcTemplate().queryForObject(SQL_FINDBYID,
				new Object[] { id }, new LoanInfoRowMapper());
	}

	public LoanInfo findByLoanNumber(String loanNumber) {
		return (LoanInfo) getJdbcTemplate().queryForObject(SQL_FINDBYNUMBER,
				new Object[] { loanNumber }, new LoanInfoRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<LoanInfo> findByUserQueue(String userId) {
		return getJdbcTemplate().query(SQL_FINDBYQUEUE,
				new Object[] { userId }, new LoanInfoRowMapper());
	}
}
