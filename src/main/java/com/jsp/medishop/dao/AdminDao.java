package com.jsp.medishop.dao;

import com.jsp.medishop.dto.Admin;

/**
 * @author Ahsan Alam
 */
public interface AdminDao {

	public Admin getAdminByEmailDao(String email);

}
