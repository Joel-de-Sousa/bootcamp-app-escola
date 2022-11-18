package bootcamp.projeto.controller;

import bootcamp.projeto.entities.Aluno;
import bootcamp.projeto.entities.Professor;
import bootcamp.projeto.service.AlunoService;
import bootcamp.projeto.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
//@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @RequestMapping("/aluno")
    public String viewHomePage(Model model) {
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
    public String saveAluno(@ModelAttribute("aluno") Aluno aluno) {
        service.save(aluno);

        return "redirect:/aluno";
    }

    @RequestMapping("/aluno/edit_aluno/{matricula}")
    public ModelAndView showEditAlunoPage(@PathVariable (name = "matricula") String matricula) {
        ModelAndView mav = new ModelAndView("aluno/edit_aluno");
        Aluno aluno = service.findById(matricula);
        mav.addObject("aluno", aluno);

        return mav;
    }

    @RequestMapping("/aluno/delete_aluno/{matricula}")
    public String deleteAluno(@PathVariable(name = "matricula") String matricula) {
        service.delete(matricula);
        return "redirect:/aluno";
    }



}
