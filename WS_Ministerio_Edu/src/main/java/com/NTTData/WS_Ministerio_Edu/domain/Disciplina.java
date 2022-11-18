package com.NTTData.WS_Ministerio_Edu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="disciplina")
@Table(name="disciplina")
public class Disciplina {

    @Id
    private long id;
    private String titulo;
    private String area;


}
