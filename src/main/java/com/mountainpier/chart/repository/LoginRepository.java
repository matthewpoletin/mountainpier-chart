package com.mountainpier.chart.repository;

import com.mountainpier.chart.domain.Login;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface LoginRepository
		extends JpaRepository<Login, Integer> {
	
	Page<Login> getAllByOrderByDateDesc(Pageable pageable);
	
	Page<Login> getLoginsByUserIdOrderByDateDesc(UUID userId, Pageable pageable);
	Login getTopByUserIdOrderByDateDesc(UUID userId);
	void deleteByUserId(UUID userId);
	
}
