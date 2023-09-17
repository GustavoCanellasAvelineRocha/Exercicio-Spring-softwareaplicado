package br.pucrs.engswii.domain;

import jakarta.persistence.*;
import java.util.Random;

@Entity
public class Student {

    private String name;
    private int age;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationNumber;
	private String document;
	@Embedded
	private Address address;
	private Random r = new Random();

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student(){
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(Long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
}
