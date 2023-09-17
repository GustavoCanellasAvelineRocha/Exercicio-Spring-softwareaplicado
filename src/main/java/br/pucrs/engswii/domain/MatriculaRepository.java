package br.pucrs.engswii.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
    Long findDisciplineCodeByRegistrationNumber(Long registrationNumber);
}
