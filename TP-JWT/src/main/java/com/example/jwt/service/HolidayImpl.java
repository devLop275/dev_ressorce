package com.example.jwt.service;

import java.util.List;

import org.jfree.data.time.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Holiday;
import com.example.jwt.dao.HolidayDao;

@Service
public class HolidayImpl {

	@Autowired
	private HolidayDao holidayDao;

	public List<Holiday> findAll() {
		return holidayDao.findAll();
	}

	public Holiday findByHolidayName(String name) {
		return holidayDao.findByHolidayName(name);
	}

	public Holiday save(Holiday holiday) {
		long diff = holiday.getToDate().getTime() - holiday.getFromDate().getTime();
		float res = (diff / (1000 * 60 * 60 * 24));
		holiday.setNumberDay(res);
		return holidayDao.save(holiday);
	}
	
	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		}
		else {
			holidayDao.deleteById(id);
			return 1;
		}
		
	}
	
	public int update(Holiday holiday) {
		if (holidayDao.findByHolidayNameAndIdNot(holiday.getHolidayName() , holiday.getId()) != null) {
			return -1;
		} else {
			holidayDao.save(holiday);
			return 1;
		}
	}
	
	
}
