package com.tracker.habbit.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum GoalPeriod {
	DAILY("DAILY"), 
	WEEKELY("WEEKELY"), 
	MONTHLY("MONTHLY");
	
	private final String goalPeriod;
	
	private GoalPeriod(String goalPeriod) {
		this.goalPeriod = goalPeriod;
	}
	
	@JsonCreator
	public static GoalPeriod fromString(String value) {
		return GoalPeriod.valueOf(value.toUpperCase());
	}
	
//	@JsonCreator
//	public static GoalPeriod fromString(String value) {
//		for(GoalPeriod goal : GoalPeriod.values()) {
//			if (goal.goalPeriod.equalsIgnoreCase(value)) {
//				return goal;
//			}
//		}
//		return null;
//	}
	
}
