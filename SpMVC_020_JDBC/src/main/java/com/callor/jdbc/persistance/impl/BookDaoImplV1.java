package com.callor.jdbc.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.persistance.BookDao;

import lombok.extern.slf4j.Slf4j;

// @Repository(XML에 등록할 id이름)
@Slf4j
@Repository("bookDaoV1")
public class BookDaoImplV1 implements BookDao{
	
	// Console로 log를 찍기 위하여 log 객체 생성
	// lombok의 Slf4j를 사용하여 아래 코드를 대신한다
//	private static Logger log = LoggerFactory.getLogger("SERVICE");
	
	// jdbc-context.xml에 선언된 jdbcTemplate bean 사용하기
	protected final JdbcTemplate jdbcTemplate;
	public BookDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT ";
		sql+=" bk_isbn,";
		sql+=" CONCAT( '(', bk_ccode, ')', CP.cp_title ) as bk_ccode, ";
		sql+=" CONCAT( '(', bk_acode, ')', AU.au_name ) as bk_acode,";
		sql+=" bk_title,";
		sql+=" bk_date,";
		sql+=" bk_pages,";
		sql+=" bk_price ";
		sql += " FROM tbl_books BK";
		sql += " LEFT JOIN tbl_author AU";
		sql += " ON BK.bk_acode = AU.au_code ";
		sql += " LEFT JOIN tbl_company CP";
		sql += " ON BK.bk_ccode = CP.cp_code ";
		/*
		 * jdbcTemplate.query(sql,return type)
		 * sql문을 실행한 후 return type형태로 데이터를 변환하여 return 해달라
		 */
		List<BookVO> books = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<BookVO>(BookVO.class));
		
		log.debug("book SELECT {} ",books.toString());
		return books;
	}

	@Override
	public BookVO selectById(String pk) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbl_books ";
		
		
//		BookVO books = jdbcTemplate.query(sql,BookVO());
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_books ";
		sql+="( bk_isbn,";
		sql+=" bk_ccode,";
		sql+=" bk_acode,";
		sql+=" bk_title,";
		sql+=" bk_date,";
		sql+=" bk_pages,";
		sql+=" bk_price )";
		sql+=" VALUES (?,?,?,?,?,?,?)";
		
		Object[] params = new Object[] {
				vo.getBk_isbn(),
				vo.getBk_ccode(),
				vo.getBk_acode(),
				vo.getBk_title(),
				vo.getBk_date(),
				vo.getBk_pages(),
				vo.getBk_price()
		};
		// insert, update, delete 모두 jdbcTemplate.update() method 사용
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
