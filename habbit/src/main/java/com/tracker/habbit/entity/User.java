package com.tracker.habbit.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 기본 생성자 보호
//@AllArgsConstructor
@Getter
@Table(name = "users")
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	
	@Column(nullable = false, length = 255) // 해싱을 고려한 길이 조정
	private String password;	// 해싱 필수!
	
	@Column(nullable = false, unique = true)
	private String nickname;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false) // 생성 시에만 값 설정
	private LocalDateTime createdAt;
	
	// 사용자의 목표들
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Goal> goals = new ArrayList<>();
	
	// 목표 진행 기록
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<GoalProgress> progressRecords = new ArrayList<>();
		
}
