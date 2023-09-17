package br.pucrs.engswii.controllers;

import br.pucrs.engswii.domain.Discipline;
import br.pucrs.engswii.services.DisciplineRegistration;
import br.pucrs.engswii.services.MatriculaRegistration;
import br.pucrs.engswii.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplineController {

    @PostMapping("/register/discipline")
    public String create(@RequestBody Discipline discipline){
        for (int i = 0; i < DisciplineRegistration.getInstance().getDisciplineRecords().size(); i++) {
            if(discipline.getDisciplineCode().equals(DisciplineRegistration.getInstance().getDisciplineRecords().get(i).getDisciplineCode())){
                return "Discipline Code already used";
            }
        }

        System.out.println("In registerDiscipline");
        System.out.println(discipline);
        return DisciplineRegistration.getInstance().add(discipline);
    }

    @GetMapping("/discipline/alldiscipline")
    public List<Discipline> findAll(){
        return DisciplineRegistration.getInstance().getDisciplineRecords();
    }

    @GetMapping("/discipline/allstudent/{id}")
    public List<Student> listarEstudantesDisciplina(@PathVariable("id") String disciplineCode){
        return MatriculaRegistration.getInstance().listarEstudantesDisciplina(disciplineCode);
    }

    @GetMapping("/turma/allstudent/{id}")
    public List<Student> listarDisciplinasEstudante(@PathVariable("id") int turma){
        return MatriculaRegistration.getInstance().listarEstudantesTurma(turma);
    }

}
