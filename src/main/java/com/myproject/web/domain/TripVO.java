package com.myproject.web.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TripVO {
	private int tripId;
	private String userId;
	private String tripTitle;
	private String state;
}
