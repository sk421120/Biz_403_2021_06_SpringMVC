package com.callor.jdbc.service.impl;

import org.springframework.stereotype.Repository;

import com.callor.jdbc.persistance.BookDao;
import com.callor.jdbc.persistance.CompDao;
import com.callor.jdbc.service.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("rentV1")
public class RentServiceImplV1 implements RentService {

	protected BookDao bookDao;
	protected CompDao compDao;
	
	public RentServiceImplV1(BookDao bookDao, CompDao compDao) {
		this.bookDao = bookDao;
		this.compDao = compDao;
	}
	@Override
	public void viewBookAndComp() {
		// TODO Auto-generated method stub
		bookDao.selectAll();
		compDao.selectAll();
	}

}
