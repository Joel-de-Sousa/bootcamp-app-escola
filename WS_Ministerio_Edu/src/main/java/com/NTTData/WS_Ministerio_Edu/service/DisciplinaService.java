package com.NTTData.WS_Ministerio_Edu.service;

import com.NTTData.WS_Ministerio_Edu.domain.Disciplina;
import com.NTTData.WS_Ministerio_Edu.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> listAll(){return repository.findAll();}

    public Disciplina findById(long id){return repository.findById(id).get();}
}
