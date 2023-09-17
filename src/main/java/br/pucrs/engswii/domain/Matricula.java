package br.pucrs.engswii.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationNumber;
    private Long disciplineCode;
    private int turmaDaDisciplina;

    public Matricula(Long registrationNumber, Long disciplineCode, int turmaDaDisciplina) {
        this.registrationNumber = registrationNumber;
        this.disciplineCode = disciplineCode;
        this.turmaDaDisciplina = turmaDaDisciplina;
    }

    public Matricula() {
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Long getDisciplineCode() {
        return disciplineCode;
    }

    public void setDisciplineCode(Long disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public int getTurmaDaDisciplina() {
        return turmaDaDisciplina;
    }

    public void setTurmaDaDisciplina(int turmaDaDisciplina) {
        this.turmaDaDisciplina = turmaDaDisciplina;
    }
}
