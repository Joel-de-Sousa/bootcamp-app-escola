package bootcamp.projeto.controller;

import bootcamp.projeto.entities.Aluno;
import bootcamp.projeto.entities.Aula;
import bootcamp.projeto.entities.Disciplina;
import bootcamp.projeto.entities.Professor;
import bootcamp.projeto.service.AlunoService;
import bootcamp.projeto.service.AulaService;
import bootcamp.projeto.service.DisciplinaService;
import bootcamp.projeto.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping(value = "/aula")
public class AulaController {

    @Autowired
    private AulaService service;
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private DisciplinaService disciplinaService;

    public AulaController(AulaService service) {
        this.service = service;
    }

    @RequestMapping("/aula")
    public String viewHomePage(Model model) {
        List<Aula> listAulas = service.listAll();
        model.addAttribute("listAulas", listAulas);

        return "aula/index_aula";
    }

    @RequestMapping("/aula/new_aula")
    public String showNewAulaPage(Model model) {
        Aula aula = new Aula();
        model.addAttribute("aula", aula);

        List<Professor> listProfessors = professorService.listAll();
        model.addAttribute("listProfessors", listProfessors);

        List<Aluno> listAlunos = alunoService.listAll();
        model.addAttribute("listAlunos", listAlunos);

        return "aula/new_aula";
    }

    @RequestMapping(value = "/saveAula", method = RequestMethod.POST)
    public String saveAula(@ModelAttribute(name = "aula") @Valid Aula aula, BindingResult result) {

        if(result.hasErrors()){return "aula/new_aula";}

        service.save(aula);

        return "redirect:/aula";
    }

    @RequestMapping("/aula/edit_aula/{id}")
    public ModelAndView showEditAulaPage(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("aula/edit_aula");
        Aula aula = service.findById(id);
        mav.addObject("aula", aula);

        List<Aluno> listAlunos = alunoService.listAll();
        mav.addObject("listAlunos", listAlunos);

        List<Professor> listProfessor = professorService.listAll();
        mav.addObject("listProfessors", listProfessor);

        return mav;
    }

    @RequestMapping("/aula/delete_aula/{id}")
    public String deleteAula(@PathVariable(name = "id") Integer id) {
        service.delete(id);
        return "redirect:/aula";
    }

}
