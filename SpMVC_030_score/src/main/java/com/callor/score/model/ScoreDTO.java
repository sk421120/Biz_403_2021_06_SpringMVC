package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {
	private Long sc_seq;
	private Long sc_stnum;
	private String sc_stname;
	private String sc_sbcode;
	private String sc_sbname;
	private int sc_score = 0;
}
