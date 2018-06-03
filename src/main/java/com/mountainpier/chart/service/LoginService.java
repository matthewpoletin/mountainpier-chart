package com.mountainpier.chart.service;

import com.mountainpier.chart.domain.Login;
import com.mountainpier.chart.web.model.LoginRequest;

import org.springframework.data.domain.Page;
import java.util.UUID;

public interface LoginService {
	
	Page<Login> getLatestLogins(Integer page, Integer size);
	Login createLogin(LoginRequest loginRequest);
	
	Page<Login> getLoginsOfUser(UUID userId, Integer page, Integer size);
	Login getLatestLoginOfUser(UUID userId);
	void deleteLoginsOfUser(UUID userId);
	
}
