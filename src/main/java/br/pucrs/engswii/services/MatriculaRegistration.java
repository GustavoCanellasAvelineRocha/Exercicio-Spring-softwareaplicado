package br.pucrs.engswii.services;

import br.pucrs.engswii.domain.Discipline;
import br.pucrs.engswii.domain.Matricula;
import br.pucrs.engswii.domain.Student;
import br.pucrs.engswii.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MatriculaRegistration {
    private List<Matricula> matriculaRecords;
    private static MatriculaRegistration matriculaRegistration = null;

    private MatriculaRegistration(){
        matriculaRecords = new ArrayList<Matricula>();
    }

    public static MatriculaRegistration getInstance(){
        if(matriculaRegistration == null){
            matriculaRegistration = new MatriculaRegistration();
        }
        return matriculaRegistration;
    }

    @Autowired
    private StudentRepository studentRepository;

    public String matricular(Long registrationNumber,Long disciplineCode,int turmaDaDisciplina){
        boolean estudante = false,disciplinaCodigo = false,turma = false;

        if(studentRepository.existsById(registrationNumber)){
            estudante = true;
        }

        for (Discipline discipline: DisciplineRegistration.getInstance().getDisciplineRecords()) {
            if(Objects.equals(discipline.getDisciplineCode(), disciplineCode)){
                disciplinaCodigo = true;
            }
            if(discipline.getTurmaDaDisciplina() == turmaDaDisciplina){
                turma = true;
            }
        }

        if(estudante && disciplinaCodigo && turma){
            matriculaRecords.add(new Matricula(registrationNumber,disciplineCode,turmaDaDisciplina));
            return "Aluno matriculado com sucesso";
        }else{
            System.out.println(estudante +" "+ disciplinaCodigo +" "+ turma);
            return "Nao foi possivel matricular o aluno";
        }
    }

    public List<Discipline> listarDisciplinasEstudante(Long id){
        ArrayList<Discipline> list = new ArrayList<>();
        for (Matricula matricula: matriculaRecords) {
            if(Objects.equals(matricula.getRegistrationNumber(), id)){
                for (Discipline discipline: DisciplineRegistration.getInstance().getDisciplineRecords()) {
                    if(Objects.equals(discipline.getDisciplineCode(), matricula.getDisciplineCode()) && discipline.getTurmaDaDisciplina() == matricula.getTurmaDaDisciplina())list.add(discipline);
                }
            }
        }

        return list;
    }

    public List<Student> listarEstudantesDisciplina(String disciplineCode){
        ArrayList<Student> list = new ArrayList<>();
//        for (Matricula matricula: matriculaRecords) {
//            if(Objects.equals(matricula.getDisciplineCode(), disciplineCode)){
//                for (Student student : StudentRegistration.getInstance().getStudentRecords()) {
//                    if(student.getRegistrationNumber().equalsIgnoreCase(matricula.getRegistrationNumber())) list.add(student);
//                }
//            }
//        }

        return list;
    }

    public List<Student> listarEstudantesTurma(int turma){
        ArrayList<Student> list = new ArrayList<>();
//        for (Matricula matricula: matriculaRecords) {
//            if(Objects.equals(matricula.getTurmaDaDisciplina(), turma)){
//                for (Student student : StudentRegistration.getInstance().getStudentRecords()) {
//                    if(student.getRegistrationNumber().equalsIgnoreCase(matricula.getRegistrationNumber())) list.add(student);
//                }
//            }
//        }

        return list;
    }
}
