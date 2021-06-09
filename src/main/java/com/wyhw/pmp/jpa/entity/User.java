package com.wyhw.pmp.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "info")
@Table(name = "pmp_info")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "sex")
	private String sex;
	@Column(name = "birthday")
	private String birthday;
}
