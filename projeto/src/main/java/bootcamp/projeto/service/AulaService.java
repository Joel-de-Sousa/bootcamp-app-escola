package bootcamp.projeto.service;

import bootcamp.projeto.entities.Aula;
import bootcamp.projeto.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AulaRepository repository;

    public List<Aula> listAll(){return repository.findAll();}

    public Aula findById(Integer id){return repository.findById(id).get();}

    public void delete(Integer id){repository.deleteById(id);}

    public void save(Aula aula){repository.save(aula);}
}

