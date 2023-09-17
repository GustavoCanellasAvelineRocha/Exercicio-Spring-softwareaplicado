package br.pucrs.engswii.controllers;

import br.pucrs.engswii.domain.Student;
import br.pucrs.engswii.domain.StudentRegistrationReply;
import br.pucrs.engswii.services.StudentRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRegistration studentRegistration;

    @PostMapping("/register/student")
    @Transactional
    public StudentRegistrationReply registerStudent(@RequestBody Student student) {
        System.out.println("In registerStudent");
        return studentRegistration.add(student);
    }

    @DeleteMapping("/delete/student/{regdNum}")
    @Transactional
    public String deleteStudentRecord(@PathVariable("regdNum") Long regdNum) {
        System.out.println("In deleteStudentRecord");
        return studentRegistration.deleteStudent(regdNum);
    }

    @GetMapping("/student/allstudent")
    public List<Student> getAllStudents() {
        return studentRegistration.listAllStudents();
    }
    @GetMapping("/student/{code}")
    public Student findByCode(@PathVariable Long code){
        return studentRegistration.findByCode(code);
    }
    @GetMapping("/student/name/{name}")
    public List<Student> findByName(@PathVariable String name){
        List<Student> correspondencias = new ArrayList<>();
        for (Student stdnt : studentRegistration.listAllStudents()) {
            if (stdnt.getName().toLowerCase().contains(name.toLowerCase())) {
                correspondencias.add(stdnt);
            }
        }
        return correspondencias.size() > 1 ? correspondencias : correspondencias.isEmpty() ? null : correspondencias;
    }

    @PutMapping("/update/student")
    @Transactional
    public String updateStudentRecord(@RequestBody Student stdn) {
        System.out.println("In updateStudentRecord");
        return studentRegistration.upDateStudent(stdn);
    }
}
