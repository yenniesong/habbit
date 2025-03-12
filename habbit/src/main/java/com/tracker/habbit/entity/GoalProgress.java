package com.tracker.habbit.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 기본 생성자 보호
@Getter
@Table(name = "goalProgress")
@Builder
public class GoalProgress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "progress_id")
	private long progressId;
	
	@ManyToOne
	@JoinColumn(name = "goal_id", nullable = false)
	private Goal goal;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "chk_date", nullable = false)
	private LocalDate chkDate;
	
	@Column(name = "completion_cnt", nullable = false)
	private int completionCnt;
	
	@Column(nullable = false)
	private boolean completed;

}
