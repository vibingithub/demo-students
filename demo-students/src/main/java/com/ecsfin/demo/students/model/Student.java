package com.ecsfin.demo.students.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private String id;
	private String name;
	private String studyingClass;
	private int age;
	private String sex;
}
