package com.mountainpier.chart.web;

import com.mountainpier.chart.service.LoginService;
import com.mountainpier.chart.web.model.LoginRequest;
import com.mountainpier.chart.web.model.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(LoginController.loginBaseUri)
public class LoginController {
	
	static final String loginBaseUri = "/api/chart";
	
	private final LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value = "/logins", method = RequestMethod.GET)
	Page<LoginResponse> getLogins(@RequestParam(name = "page", defaultValue = "0") Integer page,
								  @RequestParam(name = "size", defaultValue = "25") Integer size) {
		return this.loginService.getLatestLogins(page, size)
			.map(LoginResponse::new);
	}
	
	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	LoginResponse createLogin(@RequestBody @Valid LoginRequest loginRequest) {
		return new LoginResponse(this.loginService.createLogin(loginRequest));
	}
	
}
