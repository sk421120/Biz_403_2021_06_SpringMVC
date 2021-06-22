package com.callor.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor	// field 생성자
@NoArgsConstructor	// super 생성자
@ToString
public class BookVO {
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	/*
	 * VO(DTO)를 설계할때 숫자형 변수는
	 * PK나 특별히 조회할대 사용하는 칼럼은 class형 (Integer, Float)으로 선언하는 것이 좋다
	 * 이 칼럼이 null인 경우에 부여하여 연산하는데 유리하다
	 * 
	 * 일반적인 숫자형 변수는 primitive 형으로 선언하는 것이 좋다
	 * 
	 * VO(DTO)클래스의 변수를 primitive로 선언하면 자동으로 0으로 초기화된다
	 * 
	 * DB에 insert를 수행할때 해당칼럼이 not null로 되어있을 때
	 * 별도로 별다른 처리를 하지 않아도 SQL Exception이 발생하지 않는다.
	 */
	private int bk_price =0;
	private int bk_pages =0;
}
