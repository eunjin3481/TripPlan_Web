package com.myproject.web.domain;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	private String userId;
	private String userName;
	private String userEmail;
	private String userPasswd;
}
