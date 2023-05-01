package com.global.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProjectDto {

	
	private int pid;
	private String pname;
	private String location;
	
	private List<EmployeeDto> employee;
}
