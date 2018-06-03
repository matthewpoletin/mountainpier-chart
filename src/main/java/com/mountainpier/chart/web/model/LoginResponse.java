package com.mountainpier.chart.web.model;

import com.mountainpier.chart.domain.Login;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class LoginResponse {
	
	private Integer id;
	private String userId;
	private Date date;
	
	public LoginResponse(Login login) {
		this.id = login.getId();
		this.userId = login.getUserId().toString();
		this.date = login.getDate();
	}
	
}
