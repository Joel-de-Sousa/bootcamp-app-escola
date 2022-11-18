package bootcamp.projeto.service;

import bootcamp.projeto.entities.Aluno;
import bootcamp.projeto.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService{

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> listAll(){return repository.findAll();}

    public Aluno findById(String matricula){return repository.findById(matricula).get();}

    public void delete(String matricula){repository.deleteById(matricula);}

    public void save(Aluno aluno){repository.save(aluno);}
}
