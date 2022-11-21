package bootcamp.projeto.REST;

import bootcamp.projeto.dto.EscolaridadeRestDTO;
import bootcamp.projeto.dto.EscolaridadeRestDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EscolaridadeRestRepository {

    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8082")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8082"))
            .clientConnector(new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection())))
            .build();

    public List<EscolaridadeRestDTO> listAllAnosDisponiveisParaInscricao(int idade) {
        Mono<List<EscolaridadeRestDTO>> resposta;
        List<EscolaridadeRestDTO> novaLista;
        try {
            resposta = webClient.get().uri("/escolaridade/listaAnos/" + idade).retrieve()
                    .onStatus(HttpStatus::is4xxClientError, error -> {
                        return Mono.empty();
                    }).bodyToMono(new ParameterizedTypeReference<List<EscolaridadeRestDTO>>() {
                    });
            novaLista = resposta.block();
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return novaLista;
    }

    public EscolaridadeRestDTO verificaEscolaridade(int idade) {
        Mono<EscolaridadeRestDTO> resposta;
        EscolaridadeRestDTO novaLista;
        try {
            resposta = webClient.get().uri("/escolaridade/ano/" + idade).retrieve()
                    .onStatus(HttpStatus::is4xxClientError, error -> {
                        return Mono.empty();
                    }).bodyToMono(new ParameterizedTypeReference<EscolaridadeRestDTO>() {
                    });
            novaLista = resposta.block();
        } catch (Exception e) {
            return null;
        }
        return novaLista;
    }
}
