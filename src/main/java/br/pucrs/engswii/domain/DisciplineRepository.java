package br.pucrs.engswii.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline,Long> {

    boolean existsByTurmaDaDisciplina(int turmaDaDisciplina);
}
