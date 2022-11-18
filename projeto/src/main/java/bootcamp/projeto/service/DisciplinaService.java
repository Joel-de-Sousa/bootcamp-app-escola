package bootcamp.projeto.service;

import bootcamp.projeto.entities.Disciplina;
import bootcamp.projeto.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> listAll(){return repository.findAll();}

    public Disciplina findById(Integer id){return repository.findById(id).get();}

    public void delete(Integer id){repository.deleteById(id);}

    public void save(Disciplina disciplina){repository.save(disciplina);}
}

