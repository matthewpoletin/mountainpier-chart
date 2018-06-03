package com.mountainpier.chart.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "logins", schema = "public")
public class Login {
	
	@Id
	@Column(name = "logins_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "logins_user_id")
	private UUID userId;
	
	@Column(name = "logins_date")
	private Date date;
	
}
