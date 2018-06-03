package com.mountainpier.chart.web.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

@Data
@Accessors(chain = true)
public class LoginRequest {
	
	@Length(min = 36, max = 36, message = "Property userId is not of UUID type")
	private String userId;
	
	private Date date;
	
}
