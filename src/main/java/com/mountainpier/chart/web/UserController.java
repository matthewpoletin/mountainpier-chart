package com.mountainpier.chart.web;

import com.mountainpier.chart.service.LoginService;
import com.mountainpier.chart.web.model.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(UserController.userBaseURI)
public class UserController {

	static final String userBaseURI = "/api/chart";

	private final LoginService loginService;
	
	@Autowired
	UserController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value = "/users/{userId}/logins", method = RequestMethod.GET)
	Page<LoginResponse> getLoginsOfUser(@PathVariable("userId") UUID userId,
										@RequestParam(name = "page", defaultValue = "0") Integer page,
										@RequestParam(name = "size", defaultValue = "25") Integer size) {
		return this.loginService.getLoginsOfUser(userId, page, size)
			.map(LoginResponse::new);
	}
	
	@RequestMapping(value = "/users/{userId}/logins/latest", method = RequestMethod.GET)
	LoginResponse getLatestLoginOfUser(@PathVariable("userId") UUID userId) {
		return new LoginResponse(this.loginService.getLatestLoginOfUser(userId));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(name="1", value = "/users/{userId}/logins", method = RequestMethod.DELETE)
	void deleteLoginsOfUser(@PathVariable("userId") UUID userId) {
		this.loginService.deleteLoginsOfUser(userId);
	}

}
