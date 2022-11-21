package com.NTTData.WS_Ministerio_Edu.controller;

import com.NTTData.WS_Ministerio_Edu.domain.Escolaridade;
import com.NTTData.WS_Ministerio_Edu.service.EscolaridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping(path = "/escolaridade")
public class EscolaridadeController {

    @Autowired
    private EscolaridadeService service;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> getEscolaridadeByID(@PathVariable long id){
        Escolaridade escolaridade = service.findById(id);
        if(escolaridade != null) {
            return new ResponseEntity<>(escolaridade, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listAnos/{idade}")
    @ResponseBody
    public ResponseEntity<Object> getEscolaridadeByIdade(@PathVariable int idade){
        List<Escolaridade> listAnosDisponiveis = service.anosDisponiveis(idade);
        //if(listAnosDisponiveis != null) {
            return new ResponseEntity<>(listAnosDisponiveis, HttpStatus.OK);
        //} else
          //  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ano/{idade}")
    @ResponseBody
    public ResponseEntity<Object> getEscolaridadeDoAno(@PathVariable int idade){
        Escolaridade anoescolar = service.anoDisponivel(idade);
        //if(listAnosDisponiveis != null) {
        return new ResponseEntity<>(anoescolar, HttpStatus.OK);
        //} else
        //  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Object> getAllEscolaridades(){
        List<Escolaridade> listEscolaridade = service.listAll();

        return new ResponseEntity<>(listEscolaridade, HttpStatus.OK);
    }
}
