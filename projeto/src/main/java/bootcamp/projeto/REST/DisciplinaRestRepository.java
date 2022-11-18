package bootcamp.projeto.REST;

import bootcamp.projeto.dto.DisciplinaRestDTO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DisciplinaRestRepository {

    public Optional<DisciplinaRestDTO> findDisciplinaByID(int id) {

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8082")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8082"))
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection())))
                .build();


        DisciplinaRestDTO disciplinaRestDTO;
        try {
            disciplinaRestDTO = webClient
                    .get()
                    .uri("/disciplinas/" + id)
                    .retrieve()

                    .onStatus(HttpStatus::is4xxClientError, error -> {
                        return Mono.empty();
                    })

                    .bodyToMono(DisciplinaRestDTO.class)

                    .onErrorReturn(null)

                    .doOnError(throwable -> {
                        System.out.println(throwable.getMessage());
                    })
                    .block();
        } catch (Exception e) {

            disciplinaRestDTO = null;
        }

        if (disciplinaRestDTO != null)
            return java.util.Optional.of(disciplinaRestDTO);
        else
            return java.util.Optional.empty();
    }

    public Optional<List<DisciplinaRestDTO>> findAllDisciplinas() {

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8082")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8082"))
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection())))
                .build();


        List<DisciplinaRestDTO> listDisciplinas;
        try {
            listDisciplinas = (List<DisciplinaRestDTO>) webClient
                    .get()
                    .uri("/disciplinas/")
                    .retrieve()

                    .onStatus(HttpStatus::is4xxClientError, error -> {
                        return Mono.empty();
                    })

                    .bodyToMono(DisciplinaRestDTO.class)

                    .onErrorReturn(null)

                    .doOnError(throwable -> {
                        System.out.println(throwable.getMessage());
                    })
                    .block();
        } catch (Exception e) {

            listDisciplinas = null;
        }

        if (listDisciplinas != null)
            return java.util.Optional.of(listDisciplinas);
        else
            return java.util.Optional.empty();
    }
}

