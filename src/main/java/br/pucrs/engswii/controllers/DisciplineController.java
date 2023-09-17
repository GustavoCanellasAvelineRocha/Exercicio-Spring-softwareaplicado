package br.pucrs.engswii.controllers;

import br.pucrs.engswii.domain.Discipline;
import br.pucrs.engswii.services.DisciplineRegistration;
import br.pucrs.engswii.services.MatriculaRegistration;
import br.pucrs.engswii.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplineController {

    @Autowired
    private DisciplineRegistration disciplineRegistration;

    @Autowired
    private MatriculaRegistration matriculaRegistration;

    @PostMapping("/register/discipline")
    public String create(@RequestBody Discipline discipline){

        System.out.println("In registerDiscipline");
        System.out.println(discipline);
        return disciplineRegistration.add(discipline);
    }

    @GetMapping("/discipline/alldiscipline")
    public List<Discipline> findAll(){
        return disciplineRegistration.getDisciplineRecords();
    }

    @GetMapping("/discipline/allstudent/{id}")
    public List<Student> listarEstudantesDisciplina(@PathVariable("id") Long disciplineCode){
        return matriculaRegistration.listarEstudantesDisciplina(disciplineCode);
    }

    @GetMapping("/turma/allstudent/{id}")
    public List<Student> listarDisciplinasEstudante(@PathVariable("id") int turma){
        return matriculaRegistration.listarEstudantesTurma(turma);
    }

}
