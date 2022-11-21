package bootcamp.projeto.service;

import bootcamp.projeto.REST.EscolaridadeRestRepository;
import bootcamp.projeto.dto.EscolaridadeRestDTO;
import bootcamp.projeto.entities.Aluno;
import bootcamp.projeto.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private EscolaridadeRestRepository restRepository;

    public List<Aluno> listAll(){return repository.findAll();}

    public Aluno findById(String matricula){return repository.findById(matricula).get();}

    public boolean delete(String matricula){
        try{
            repository.deleteById(matricula);
            return true;
        } catch (Exception e){
        return false;}
    }

    public void save(Aluno aluno){

        repository.save(aluno);
    }

    public List<EscolaridadeRestDTO> listAllAnosDisponiveisParaInscricao(int idade){
        return restRepository.listAllAnosDisponiveisParaInscricao(idade);}

    public EscolaridadeRestDTO verificaEscolaridade(int idade){
        return restRepository.verificaEscolaridade(idade);
    }
}
