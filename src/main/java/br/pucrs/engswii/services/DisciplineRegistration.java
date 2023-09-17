package br.pucrs.engswii.services;

import br.pucrs.engswii.domain.Discipline;
import br.pucrs.engswii.domain.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplineRegistration {

    private DisciplineRepository disciplineRepository;
    @Autowired
    private DisciplineRegistration(DisciplineRepository disciplineRepository){
        this.disciplineRepository = disciplineRepository;
    }

    public String add(Discipline disc){
        if(disc.getHorarioDaDisciplina() < 'A' || disc.getHorarioDaDisciplina() > 'G') return "Nao foi possivel cadastrar, horario deve ser entre A e G";

        if(disciplineRepository.existsByTurmaDaDisciplina(disc.getTurmaDaDisciplina()))return "Nao foi possivel cadastrar, essa turma ja existe";

        disciplineRepository.save(disc);
        return "Cadastro feito com sucesso";
    }

    public String updateDiscipline(Discipline disc){

        return "Update un-successful";
    }
    public String deleteDiscipline(Long disciplineCode){
        if(!disciplineRepository.existsById(disciplineCode))return "Delete succesful";

        disciplineRepository.deleteById(disciplineCode);
        return "Delete un-successful";
    }

    public List<Discipline> getDisciplineRecords() {
        return disciplineRepository.findAll();
    }
}
