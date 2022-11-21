package bootcamp.projeto.controller;

import bootcamp.projeto.entities.Aluno;
import bootcamp.projeto.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
class AlunoControllerTest {

    @MockBean
    AlunoService service;
    @InjectMocks
    AlunoController controller;
    @MockBean
    Aluno aluno;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void listarTodosOsAlunos() throws Exception {
        when(service.listAll()).thenReturn(List.of(aluno));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/aluno"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("/aluno"));
    }


    @Test
    void showNewAlunoPage() {
    }

    @Test
    void saveAluno() {
    }

    @Test
    void showEditAlunoPage() {
    }

    @Test
    void deleteAluno() {
    }
}