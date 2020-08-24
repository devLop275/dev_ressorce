package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Holiday;
import com.example.jwt.dao.HolidayDao;

@Service
public class HolidayImpl {

	@Autowired
	private HolidayDao holidayDao;

	public Holiday save(Holiday holiday) {
		return holidayDao.save(holiday);
	}

	public List<Holiday> findAll() {
		return holidayDao.findAll();
	}

	public Holiday findByHolidayName(String name) {
		return holidayDao.findByHolidayName(name);
	}

	public void deleteById(Long id) {
		holidayDao.deleteById(id);
	}
	
	
}
