package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.AttestationEmployee;
import com.example.jwt.bean.Employee;


@Repository
public interface AttestationEmployeeDao extends JpaRepository<AttestationEmployee, Long> {

	 public AttestationEmployee findByEmployee(Employee employee);

	 public void deleteById(Long id);
}
