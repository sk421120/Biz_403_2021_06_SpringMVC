package com.callor.score.service;

import java.util.List;
import java.util.Map;

import com.callor.score.model.StudentVO;

public interface StudentService {
	public List<StudentVO> selectAll();

	public Map<String, Object> selectMaps();

	public int insert(StudentVO vo);
	public int update(StudentVO vo);
	
	public String makeStNum();
	public String makeStNum(String prefix);

	public StudentVO findById(String st_num);
}
