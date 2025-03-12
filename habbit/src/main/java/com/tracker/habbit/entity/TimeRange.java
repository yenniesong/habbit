package com.tracker.habbit.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum TimeRange {
	ANYTIME("00:00-23:59"),
	MORNING("06:00-11:59"),
	AFTERNOON("12:00-17:59"), 
	EVENING("18:00-23:59");
	
	private final String timeRange;
	
	TimeRange(String timeRange) {
		this.timeRange = timeRange;
	}
	
	// 대문자로 변환을 위한 메서드
	@JsonCreator
	public static TimeRange fromString(String value) {
		return TimeRange.valueOf(value.toUpperCase());
	}
}
