package bootcamp.projeto.controller;

import bootcamp.projeto.dto.EscolaridadeRestDTO;
import bootcamp.projeto.entities.Aluno;
import bootcamp.projeto.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @RequestMapping("/aluno")
    public String viewAlunoHomePage(Model model) {
        List<Aluno> listAlunos = service.listAll();
        model.addAttribute("listAlunos", listAlunos);

        return "aluno/index_aluno";
    }

    @RequestMapping("/aluno/new_aluno")
    public String showNewAlunoPage(Model model) {
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);


        return "aluno/new_aluno";
    }

    @RequestMapping(value = "/saveAluno", method = RequestMethod.POST)
    public String saveAluno(@Valid @ModelAttribute("aluno") Aluno aluno) {

        EscolaridadeRestDTO verifica = service.verificaEscolaridade(aluno.getIdade());
        if (verifica.getAno() == aluno.getEscolaridade()) {
            service.save(aluno);
        }
        return "redirect:/aluno";
    }

    @RequestMapping("/aluno/edit_aluno/{matricula}")
    public ModelAndView showEditAlunoPage(@PathVariable(name = "matricula") String matricula) {
        ModelAndView mav = new ModelAndView("aluno/edit_aluno");
        Aluno aluno = service.findById(matricula);
        mav.addObject("aluno", aluno);


        return mav;
    }

    @RequestMapping("/aluno/delete_aluno/{matricula}")
    public String deleteAluno(@PathVariable(name = "matricula") String matricula, Model model) {

        if (service.delete(matricula)) {
            return "redirect:/aluno";
        } else {
            return "/error";
        }
    }


}
