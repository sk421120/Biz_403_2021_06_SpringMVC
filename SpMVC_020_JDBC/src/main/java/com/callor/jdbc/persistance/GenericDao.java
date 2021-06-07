package com.callor.jdbc.persistance;

import java.util.List;

/*
 * 제네릭
 * 인터페이스의 부모역할을 하는 super interface
 * Dao와 같은 인터페이스를 설계할때 Table마다 Dao 인터페이스를 만들고
 * 인터페이스를 상속받아 클래스를 선언하는데
 * 이때 대부분의 Dao에는 같은 이름의 method가 존재
 * 
 * 그런데 이 method 들이 return type과 매개변수가 달라서
 * 어쩔수 없이 비슷하거나 거의 같은 method를 같은 interface를 중복 작성해야함
 * 
 * 제네릭( <> )을 interface에 설정하고 임의의 이름을 지정해준다
 * 여기에서는 VO PK라는 이름을 임의로 지정하였다
 * 그리고 method를 선언할때 제네릭으로 지정된 이름을 사용하여 
 * 공통매개변수를 사용하였다
 * 
 * 이렇게 제네릭을 갖는 interface를 만들어두고 또다른 interface를 만들 때
 * 이 Generic interface를 상속받아서 사용한다
 * 
 * 상속받는 interface는 상속되는 곳에 자신의 VO나 PK 칼럼에 PK type을 지정해주면
 * 공통된 type을 다시 만들 필요가 없어진다
 */
public interface GenericDao<VO,PK> {
	
	public List<VO> selectAll();

	public VO selectById(PK pk);

	public int insert(VO vo);

	public int update(VO vo);

	public int delete(PK pk);
}
