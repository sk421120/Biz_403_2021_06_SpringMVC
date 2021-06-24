package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.callor.score.dao.ext.SubjectDao;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.SubjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository("subjectServiceV1")
public class SubjectServiceImplV1 implements SubjectService{
	
	protected final SubjectDao sbDao;
	
	@Override
	public List<SubjectVO> selectAll() {
		List<SubjectVO> sbList = sbDao.selectAll();
		log.debug(sbList.toString());
		return sbList;
	}
	
}
