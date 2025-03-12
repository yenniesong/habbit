package com.tracker.habbit.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum HabitType {
	BUILD("BUILD"),
	QUIT("QUIT");
	
	private final String habitType;
	
	HabitType(String habitType) {
		this.habitType = habitType;
	}
	
	// 대문자로 변환을 위한 메서드
	@JsonCreator
	public static HabitType fromString(String value) {
		return HabitType.valueOf(value.toUpperCase());
	}
}
