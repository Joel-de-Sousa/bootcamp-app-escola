package com.NTTData.WS_Ministerio_Edu.repository;

import com.NTTData.WS_Ministerio_Edu.domain.Escolaridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Long> {

    Escolaridade getEscolaridadeByIdade(int idade);
}
