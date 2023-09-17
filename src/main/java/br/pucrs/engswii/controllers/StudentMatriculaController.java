package br.pucrs.engswii.controllers;

import br.pucrs.engswii.domain.Discipline;
import br.pucrs.engswii.domain.Matricula;
import br.pucrs.engswii.domain.MatriculaRepository;
import br.pucrs.engswii.services.MatriculaRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentMatriculaController {

    @Autowired
    private MatriculaRegistration matriculaRegistration;

    @PostMapping("/student/matricula")
    public String matricular(@RequestBody Matricula informacoesMatricula){
        return matriculaRegistration.matricular(informacoesMatricula.getRegistrationNumber(),
                informacoesMatricula.getDisciplineCode(),
                informacoesMatricula.getTurmaDaDisciplina());
    }

    @GetMapping("/student/matricula/{id}")
    public List<Discipline> listarDisciplinasEstudante(@PathVariable("id") Long registroEstudante){
        return matriculaRegistration.listarDisciplinasEstudante(registroEstudante);
    }
}
