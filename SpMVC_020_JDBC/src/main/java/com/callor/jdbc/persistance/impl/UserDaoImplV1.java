package com.callor.jdbc.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.persistance.UserDao;

@Repository
public class UserDaoImplV1 implements UserDao{
	
	// 생성자에서 주입받는 객체
	// 생성자에서 주입받아 초기화 하는 객체는 @Component로 선언된 클래스만 가능
	protected final JdbcTemplate jdbcTemplate;
	
	public UserDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO selectById(String username) {
		// TODO Auto-generated method stub
		String sql =" SELECT * FROM tbl_member ";
		sql += " WHERE mb_username = ? ";
		
		Object[] params = new Object[] {
				username
		};
		
		UserVO vo = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<UserVO>(UserVO.class)).get(0);
		
		return vo;
	}

	@Override
	public int insert(UserVO vo) {
		String sql = " INSERT INTO tbl_memeber ( username , password ) ";
		sql += " VALUES( ?, ? )";
	
		// jdbcTemplate으로 query를 전송할때 전달할 값이 몇개 안될때는 Object[] 배열로 만들지 않아도 된다
		return jdbcTemplate.update(sql, vo.getUsername(), vo.getPassword());
		
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
