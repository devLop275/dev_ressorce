package com.example.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Role;
import com.example.jwt.dao.RoleDao;

@Service
public class RoleServiceImpl {

	@Autowired
	private RoleDao roleDao;

	public Role save(Role role) {
		Role loadedRole = roleDao.findByAuthority(role.getAuthority());
		if (loadedRole == null) {
			roleDao.save(role);
			return role;
		}
		return loadedRole;
	}

	public Role findByName(String name) {
		return roleDao.findByAuthority(name);
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
}
