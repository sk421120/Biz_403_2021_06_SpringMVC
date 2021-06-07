package com.callor.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompVO {
	private String cp_code;
	private String cp_name;
	private String cp_ceo;
	private String cp_tel;
	private String cp_addr;
}
