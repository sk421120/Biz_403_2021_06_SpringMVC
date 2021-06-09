package com.callor.jdbc.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.persistance.CompDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao{

	protected final JdbcTemplate jdbcTemplate;
	
	public CompDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<CompVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbl_company ";
		
		List<CompVO> comps = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<CompVO>(CompVO.class));
		log.debug("comp SELECT {}", comps.toString());
		return comps;
	}

	@Override
	public CompVO selectById(String pk) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		
		Object[] params = new Object[] {
			pk
		};
		
		CompVO vo = jdbcTemplate.query(sql, params,
				new BeanPropertyRowMapper<CompVO>(CompVO.class)).get(0);
		log.debug("comp SELECT ID {}",vo.toString());
		return vo;	

	}

	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String sql =" INSERT INTO tbl_company ";
		sql += "( cp_code, cp_title, cp_ceo, cp_tel, cp_addr, cp_genre ) ";
		sql += " VALUES ( ?,?,?,?,?,? )";
		
		Object[] params = new Object[] {
				vo.getCp_code(),
				vo.getCp_title(),
				vo.getCp_ceo(),
				vo.getCp_tel(),
				vo.getCp_addr(),
				vo.getCp_genre()
		};
		
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int update(CompVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CompVO> findByCName(String cname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompVO> findByCeo(String ceo) {
		// TODO Auto-generated method stub
		return null;
	}

}
