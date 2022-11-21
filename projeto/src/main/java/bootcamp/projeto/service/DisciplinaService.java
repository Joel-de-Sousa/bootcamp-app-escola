package bootcamp.projeto.service;

import bootcamp.projeto.REST.DisciplinaRestRepository;
import bootcamp.projeto.dto.DisciplinaRestDTO;
import bootcamp.projeto.entities.Disciplina;
import bootcamp.projeto.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;
    @Autowired
    private DisciplinaRestRepository restRepository;

    public List<Disciplina> listAll() {
        return repository.findAll();
    }

    public Disciplina findById(Integer id) {
        return repository.findById(id).get();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void save(Disciplina disciplina) throws Exception {
        if (!repository.existsByTitulo(disciplina.getTitulo())) {
            repository.save(disciplina);
        } else
            throw new Exception("A disciplina já se encontra ativa");
    }

    public List<DisciplinaRestDTO> listAllDisciplinasMinisterio() {
        return restRepository.findAllDisciplinas();
    }
}

