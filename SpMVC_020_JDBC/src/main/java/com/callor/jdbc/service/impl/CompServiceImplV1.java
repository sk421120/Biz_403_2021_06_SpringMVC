package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.persistance.CompDao;
import com.callor.jdbc.service.CompService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("compServiceV1")
public class CompServiceImplV1 implements CompService{

	protected final CompDao compDao;
	
	public CompServiceImplV1(CompDao compDao) {
		this.compDao = compDao;
	}
	
	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String cp_code = compDao.findByMaxCode();
		// 트랜잭션 처리 넣을 예정 / 중복 입력 방지
		log.debug(" cp_code {} ", cp_code);
		Integer intCode = null;
		
		if(cp_code == null || cp_code.equals("")) {
//			cp_code = String.format("C%04d", intCode);
			intCode = 1;
		} else {
			// 영문 접두사 C를 자르고 숫자만 추출
			String _code = cp_code.substring(1);
			intCode = Integer.valueOf(_code) + 1;
//			cp_code = String.format("C%04d", intCode);
		}
		
		cp_code = String.format("C%04d", intCode);
		
		vo.setCp_code(cp_code);
		compDao.insert(vo);
		
		return 0;
	}

	@Override
	public List<CompVO> findByCName(String cp_name) {
		// 전달받은 출판사 이름에서 앞위의 빈칸을 제거하고
		// Dao에게 Toss한 후 출판사 리스트를 받아 다시 return
		return compDao.findByCName(cp_name);
	}

	@Override
	public List<CompVO> selectAll() {
		// TODO Auto-generated method stub
		return compDao.selectAll();
	}

	@Override
	public CompVO findByCCode(String cp_code) {
		return compDao.selectById(cp_code.trim());
	}

	@Override
	public List<CompVO> findByTitleAndCeoAndTel(String text) {
		List<CompVO> mainList = compDao.findByCName(text);
		List<CompVO> ceoList = compDao.findByCeo(text);
		List<CompVO> telList = compDao.findByTel(text);
		
		mainList.addAll(ceoList);
		mainList.addAll(telList);
		return mainList;
	}

}
