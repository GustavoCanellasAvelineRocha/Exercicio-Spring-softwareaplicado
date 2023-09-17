package br.pucrs.engswii.controllers;

import br.pucrs.engswii.domain.Discipline;
import br.pucrs.engswii.domain.Matricula;
import br.pucrs.engswii.services.MatriculaRegistration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentMatriculaController {

    @PostMapping("/student/matricula")
    public String matricular(@RequestBody Matricula informacoesMatricula){
        return MatriculaRegistration.getInstance().matricular(informacoesMatricula.getRegistrationNumber(),
                informacoesMatricula.getDisciplineCode(),
                informacoesMatricula.getTurmaDaDisciplina());
    }

    @GetMapping("/student/matricula/{id}")
    public List<Discipline> listarDisciplinasEstudante(@PathVariable("id") Long registroEstudante){
        return MatriculaRegistration.getInstance().listarDisciplinasEstudante(registroEstudante);
    }
}
