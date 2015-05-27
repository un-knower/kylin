package com.kylin.dorm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylin.dorm.data.dao.DormentryDao;
import com.kylin.dorm.data.model.Dormentry;

@Service
public class DormentryService {
	@Autowired
	private DormentryDao dormentryDao;
	
	public void setDormentryDao(DormentryDao dormentryDao){
		this.dormentryDao = dormentryDao;
	}

	public List<Dormentry> getDormentryList(int dormId) {
		return dormentryDao.getDormEntryList(dormId);
	}

}
