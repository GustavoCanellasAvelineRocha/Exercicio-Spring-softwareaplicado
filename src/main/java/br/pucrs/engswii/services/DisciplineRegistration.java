package br.pucrs.engswii.services;

import br.pucrs.engswii.domain.Discipline;

import java.util.ArrayList;
import java.util.List;

public class DisciplineRegistration {

    private List<Discipline> disciplineRecords;
    private static DisciplineRegistration disciplineRegistration = null;
    private DisciplineRegistration(){
        disciplineRecords = new ArrayList<Discipline>();
    }

    public static DisciplineRegistration getInstance(){
        if(disciplineRegistration == null){
            disciplineRegistration = new DisciplineRegistration();
        }
        return disciplineRegistration;
    }

    public String add(Discipline disc){
        if(disc.getHorarioDaDisciplina() < 'A' || disc.getHorarioDaDisciplina() > 'G') return "Nao foi possivel cadastrar, horario deve ser entre A e G";

        for (Discipline discipline:disciplineRecords) {
            if(discipline.getTurmaDaDisciplina() == disc.getTurmaDaDisciplina()) return "Nao foi possivel cadastrar, codigo de turma ja utilizado";
        }

        disciplineRecords.add(disc);
        return "Cadastro feito com sucesso";
    }

    public String updateDiscipline(Discipline disc){
        for (int i = 0; i < disciplineRecords.size(); i++) {
            Discipline discipline = disciplineRecords.get(i);
            if(disc.getDisciplineCode().equals(discipline.getDisciplineCode())){
                disciplineRecords.set(i,discipline);
                return "Update succesful";
            }
        }
        return "Update un-successful";
    }
    public String deleteDiscipline(String disciplineCode){
        for (int i = 0; i < disciplineRecords.size(); i++) {
            Discipline discipline = disciplineRecords.get(i);
            if(discipline.getDisciplineCode().equals(disciplineCode)){
                disciplineRecords.remove(i);
                return "Delete succesful";
            }
        }
        return "Delete un-successful";
    }

    public List<Discipline> getDisciplineRecords() {
        return disciplineRecords;
    }
}
