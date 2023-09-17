package br.pucrs.engswii.services;

import br.pucrs.engswii.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MatriculaRegistration {
    private MatriculaRepository matriculaRepository;
    private StudentRepository studentRepository;
    private DisciplineRepository disciplineRepository;
    @Autowired
    private MatriculaRegistration(MatriculaRepository matriculaRepository,StudentRepository studentRepository,DisciplineRepository disciplineRepository){
        this.matriculaRepository = matriculaRepository;
        this.studentRepository = studentRepository;
        this.disciplineRepository = disciplineRepository;
    }


    public String matricular(Long registrationNumber,Long disciplineCode,int turmaDaDisciplina){
        boolean estudante = false,disciplinaCodigo = false,turma = false;

        if(studentRepository.existsById(registrationNumber)){
            estudante = true;
        }

            if(disciplineRepository.existsById(registrationNumber)){
                disciplinaCodigo = true;
            }
            if(disciplineRepository.existsByTurmaDaDisciplina(turmaDaDisciplina)) {
                turma = true;
            }

        if(estudante && disciplinaCodigo && turma){
            matriculaRepository.save(new Matricula(registrationNumber,disciplineCode,turmaDaDisciplina));
            return "Aluno matriculado com sucesso";
        }else{
            System.out.println(estudante +" "+ disciplinaCodigo +" "+ turma);
            return "Nao foi possivel matricular o aluno";
        }

    }

    public List<Discipline> listarDisciplinasEstudante(Long id){
        ArrayList<Discipline> list = new ArrayList<>();

        for (Matricula matricula: matriculaRepository.findAll()) {
            if(Objects.equals(matricula.getRegistrationNumber(), id)){
                for (Discipline discipline: disciplineRepository.findAll()) {
                    if(Objects.equals(discipline.getDisciplineCode(), matricula.getDisciplineCode()) && discipline.getTurmaDaDisciplina() == matricula.getTurmaDaDisciplina())list.add(discipline);
                }
            }
        }

        return list;
    }

    public List<Student> listarEstudantesDisciplina(Long disciplineCode){
        ArrayList<Student> list = new ArrayList<>();
        for (Matricula matricula: matriculaRepository.findAll()) {
            if(Objects.equals(matricula.getDisciplineCode(), disciplineCode)){
                for (Student student : studentRepository.findAll()) {
                    if(Objects.equals(student.getRegistrationNumber(), matricula.getRegistrationNumber())) list.add(student);
                }
            }
        }

        return list;
    }

    public List<Student> listarEstudantesTurma(int turma){
        ArrayList<Student> list = new ArrayList<>();
        for (Matricula matricula: matriculaRepository.findAll()) {
            if(Objects.equals(matricula.getTurmaDaDisciplina(), turma)){
                for (Student student : studentRepository.findAll()) {
                    if(Objects.equals(student.getRegistrationNumber(), matricula.getRegistrationNumber())) list.add(student);
                }
            }
        }

        return list;
    }
}


