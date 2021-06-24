package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository("scoreServiceV1")
public class ScoreServiceImplV1 implements ScoreService{

	protected final ScoreDao scDao;
	
	@Override
	public List<ScoreVO> selectAll() {
		List<ScoreVO> scList = scDao.selectAll();
		log.debug(scList.toString());
		return scList;
	}
	
	@Override
	public List<ScoreDTO> selectViewAll() {
		List<ScoreDTO> scViewList = scDao.selectViewAll();
		log.debug(scViewList.toString());
		return scViewList;
	}

}
