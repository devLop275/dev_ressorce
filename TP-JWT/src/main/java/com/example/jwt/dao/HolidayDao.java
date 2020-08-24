package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.jwt.bean.Holiday;

@Repository
public interface HolidayDao extends JpaRepository<Holiday, Long> {

	 public Holiday findByHolidayName(String name);

	 public void deleteById(Long id);
}

