package com.jdc.mkt.listeners;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TimesListener {
	@PrePersist
	void createEntity(Object obj) {
		if (obj instanceof EnableTimesEntity entity) {
			Times times = entity.getTimes();
			if (null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreatTime(LocalDateTime.now());
		}
	}

	@PreUpdate
	void updateEntity(Object obj) {
		if (obj instanceof EnableTimesEntity entity) {
			Times times = entity.getTimes();
			if (null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateTime(LocalDateTime.now());
		}
	}
}