package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.bean.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

	public Role findByAuthority(String authority);

}
