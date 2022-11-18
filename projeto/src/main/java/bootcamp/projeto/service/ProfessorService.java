package bootcamp.projeto.service;

import bootcamp.projeto.entities.Professor;
import bootcamp.projeto.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<Professor> listAll(){return repository.findAll();}

    public Professor findById(String cpf){return repository.findById(cpf).get();}

    public void delete(String cpf){repository.deleteById(cpf);}

    public void save(Professor professor){repository.save(professor);}
}

