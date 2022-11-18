package com.NTTData.WS_Ministerio_Edu.controller;

import com.NTTData.WS_Ministerio_Edu.domain.Disciplina;
import com.NTTData.WS_Ministerio_Edu.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping(path = "/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> getDisciplinaByID(@PathVariable long id){
        Disciplina disciplina = service.findById(id);
        if(disciplina != null) {
            return new ResponseEntity<>(disciplina, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Object> getAllDisciplinas(){
        List<Disciplina> listDisciplina = service.listAll();

            return new ResponseEntity<>(listDisciplina, HttpStatus.OK);
    }

}
