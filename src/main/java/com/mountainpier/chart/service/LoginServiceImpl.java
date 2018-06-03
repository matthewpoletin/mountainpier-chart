package com.mountainpier.chart.service;

import com.mountainpier.chart.domain.Login;
import com.mountainpier.chart.repository.LoginRepository;
import com.mountainpier.chart.web.model.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class LoginServiceImpl
		implements LoginService {
	
	private final LoginRepository loginRepository;
	
	@Autowired
	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Login> getLatestLogins(Integer page, Integer size) {
		return this.loginRepository.getAllByOrderByDateDesc(PageRequest.of(page, size));
	}
	
	@Override
	@Transactional
	public Login createLogin(LoginRequest loginRequest) {
		Login login = new Login()
			.setUserId(UUID.fromString(loginRequest.getUserId()))
			.setDate(loginRequest.getDate());
		return this.loginRepository.save(login);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Login> getLoginsOfUser(UUID userId, Integer page, Integer size) {
		return this.loginRepository.getLoginsByUserIdOrderByDateDesc(userId, PageRequest.of(page, size));
	}
	
	@Override
	@Transactional(readOnly = true)
	public Login getLatestLoginOfUser(UUID userId) {
		return this.loginRepository.getTopByUserIdOrderByDateDesc(userId);
	}
	
	@Override
	@Transactional
	public void deleteLoginsOfUser(UUID userId) {
		this.loginRepository.deleteByUserId(userId);
	}
	
}
