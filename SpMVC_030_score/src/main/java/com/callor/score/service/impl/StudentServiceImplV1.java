package com.callor.score.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.dao.ext.StudentDao;
import com.callor.score.dao.ext.SubjectDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("studentServiceV1")
public class StudentServiceImplV1 implements StudentService{

	protected final StudentDao stDao;
	protected final ScoreDao scDao;
	protected final SubjectDao sbDao;
	
	@Override
	public List<StudentVO> selectAll() {
		List<StudentVO> stList = stDao.selectAll();
		log.debug(stList.toString());
		return stList;
	}

	@Override
	public Map<String, Object> selectMaps() {
		List<StudentVO> stList = stDao.selectAll();
		List<ScoreVO> scList = scDao.selectAll();
		List<SubjectVO> sbList = sbDao.selectAll();
		List<ScoreDTO> scViewList = scDao.selectViewAll();

		Map<String,Object> maps = new HashMap<String,Object>();

		maps.put("학생",stList);
		maps.put("점수",scList);
		maps.put("과목",sbList);
		maps.put("View",scViewList);
		return maps;
	}

	@Override
	public int insert(StudentVO vo) {
		/*
		 * insert를 수행하는 시점에서 학번을 만들고 싶으면
		 */
//		String newStNum = this.makeStNum();
//		vo.setSt_num(newStNum);
		return stDao.insert(vo);
	}

	@Override
	public int update(StudentVO vo) {
		return stDao.update(vo);
	}

	// 현재 날짜에서 연도를 추출하여 학번 만들기
	@Override
	public String makeStNum() {
		// 현재날짜에서 연도 문자열 생성하기
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		
		String curYear = sd.format(date);
		String newStNum = this.makeStNum(curYear);
		
		return newStNum;
	}

	@Override
	public String makeStNum(String prefix) {
		// TODO Auto-generated method stub
		String stNum = stDao.getMaxStNum();
		/*
		 * prefix 만큼 문자열을 건너뛰고 나머지 부분 추출하기
		 * stNum = "20210010"	prefix = "2021"
		 * stSeq = stNum.subString(4) 이런 형식의 코드가 생성되어
		 * stSeq에는 0010의 문자열만 남게 된다
		 */
		String stSeq = stNum.substring(prefix.length());
		log.debug("학번 {}", stSeq);
		Integer intSeq = Integer.valueOf(stSeq) + 1;
		
		String newStNum = String.format("%s%04d", prefix, intSeq);
		log.debug("new 학번 {}", newStNum);
		
		return newStNum;
	}

	@Override
	public StudentVO findById(String st_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
