package com.tracker.habbit.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "goals")
@Builder
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goal_id")
	private long goalId;
	
	@Column(nullable = false, name = "goal_title")
	private String goalTitle;
	
	@Column(nullable = false)
	private String emoji;
	
	@Column(nullable = false)
	private String colour;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "habit_type")
	private HabitType habitType = HabitType.BUILD;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "goal_period")
	private GoalPeriod goalPeriod = GoalPeriod.DAILY;
	
	@Column(nullable = false, name = "goal_value")
	private int goalValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "time_range")
	private TimeRange timeRange = TimeRange.ANYTIME;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	// 목표 진행 기록
	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<GoalProgress> progressRecords = new ArrayList<>();
	

}
