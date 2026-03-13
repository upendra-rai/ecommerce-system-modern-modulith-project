package com.upendra.ecommerce.util;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "created", nullable = false, updatable = false)
	@JsonFormat(pattern = "d MMMM yyyy hh:mm a", timezone = "Asia/Kolkata")
	private LocalDateTime created;

	@Column(name = "updated", nullable = false)
	@JsonFormat(pattern = "d MMMM yyyy hh:mm a", timezone = "Asia/Kolkata")
	private LocalDateTime updated;

	@Column(name = "is_active")
	private boolean isActive = true;

	@PrePersist
	protected void onCreate() {
		this.created = LocalDateTime.now();
		this.updated = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updated = LocalDateTime.now();
	}

}