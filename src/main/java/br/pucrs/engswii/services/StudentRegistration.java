package br.pucrs.engswii.services;

import br.pucrs.engswii.domain.Student;
import br.pucrs.engswii.domain.StudentRegistrationReply;
import br.pucrs.engswii.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentRegistration {

	private StudentRepository studentRecords;


	public void setStudentRecords(StudentRepository studentRecords) {
		this.studentRecords = studentRecords;
	}


	private static StudentRegistration stdregd = null;

	@Transactional
	public StudentRegistrationReply add(Student student) {
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();

		if(studentRecords.existsById(student.getRegistrationNumber())){
			System.out.println( "Student already registered");
			stdregreply.setName(student.getName());
			stdregreply.setAge(student.getAge());
			stdregreply.setRegistrationNumber(student.getRegistrationNumber());
			stdregreply.setDocument(student.getDocument());
			stdregreply.setAdress(student.getAddress());
			stdregreply.setRegistrationStatus("un-Successful");
			return stdregreply;
		}

		studentRecords.save(student);
		//We are setting the below value just to reply a message back to the caller
		stdregreply.setName(student.getName());
		stdregreply.setAge(student.getAge());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setDocument(student.getDocument());
		stdregreply.setAdress(student.getAddress());
		stdregreply.setRegistrationStatus("Successful");

		return stdregreply;
	}
	@Transactional
	public String upDateStudent(Student std) {
		if(!studentRecords.existsById(std.getRegistrationNumber())) {
			var student = studentRecords.findById(std.getRegistrationNumber());
			Student studentUpp = new Student();
			studentUpp.setRegistrationNumber(student.get().getRegistrationNumber());
			studentUpp.setAge(std.getAge());
			studentUpp.setAddress(std.getAddress());
			studentUpp.setName(std.getName());
			studentUpp.setDocument(std.getDocument());
			return "Update successful";
		}
		return "Update un-successful";
	}

	@Transactional
	public String deleteStudent(Long registrationNumber) {
		if(studentRecords.existsById(registrationNumber)){
			studentRecords.deleteById(registrationNumber);
			return "Delete successful";
		}

		return "Delete un-successful";
	}

	public List<Student> listAllStudents(){
		return studentRecords.findAll();
	}

	public Student findByCode(Long code){
		if(studentRecords.findById(code).isPresent())return studentRecords.findById(code).get();
		else return null;
	}

}