package br.pucrs.engswii.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Discipline {
    @Id
    private Long disciplineCode;
    private String nomeDaDisciplina;

    private int turmaDaDisciplina;
    private char horarioDaDisciplina;

    public Long getDisciplineCode() {
        return disciplineCode;
    }

    public void setDisciplineCode(Long disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    public void setNomeDaDisciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
    }

    public int getTurmaDaDisciplina() {
        return turmaDaDisciplina;
    }

    public void setTurmaDaDisciplina(int turmaDaDisciplina) {
        this.turmaDaDisciplina = turmaDaDisciplina;
    }

    public char getHorarioDaDisciplina() {
        return horarioDaDisciplina;
    }

    public void setHorarioDaDisciplina(char horarioDaDisciplina) {
        this.horarioDaDisciplina = horarioDaDisciplina;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "disciplineCode='" + disciplineCode + '\'' +
                ", description='" + nomeDaDisciplina + '\'' +
                ", classCode='" + turmaDaDisciplina + '\'' +
                '}';
    }
}


