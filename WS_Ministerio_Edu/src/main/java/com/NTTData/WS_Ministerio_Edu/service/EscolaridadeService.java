package com.NTTData.WS_Ministerio_Edu.service;

import com.NTTData.WS_Ministerio_Edu.domain.Escolaridade;
import com.NTTData.WS_Ministerio_Edu.repository.EscolaridadeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EscolaridadeService {

    @Autowired
    private EscolaridadeRepository repository;

    public List<Escolaridade> listAll(){return repository.findAll();}

    public Escolaridade findById(long id){return repository.findById(id).get();}

    public List<Escolaridade> anosDisponiveis(int idade){
        List<Escolaridade> listEscolaridade = repository.findAll();
        List<Escolaridade> anosDisponiveis = new ArrayList<>();
        for (Escolaridade ano:listEscolaridade) {
            if(ano.getIdade() <= idade){
                anosDisponiveis.add(ano);
            }
        }
        return anosDisponiveis;
    }

    public Escolaridade anoDisponivel(int idade){
        Escolaridade anoDisponivel = repository.getEscolaridadeByIdade(idade);

        return anoDisponivel;
    }


}
