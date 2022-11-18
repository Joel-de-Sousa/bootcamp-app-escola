package bootcamp.projeto.controller;

import bootcamp.projeto.entities.Disciplina;
import bootcamp.projeto.entities.Professor;
import bootcamp.projeto.service.DisciplinaService;
import bootcamp.projeto.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping(value = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;
    @Autowired
    private DisciplinaService disciplinaService;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @RequestMapping("/professor")
    public String viewHomePage(Model model) {
        List<Professor> listProfessors = service.listAll();
        model.addAttribute("listProfessors", listProfessors);

        return "professor/index_professor";
    }

    @RequestMapping("/professor/new_professor")
    public String showNewProfessorPage(Model model) {
        Professor professor = new Professor();
        model.addAttribute("professor", professor);

        List<Disciplina> listDisciplinas = disciplinaService.listAll();
        model.addAttribute("listDisciplinas", listDisciplinas);

        return "professor/new_professor";
    }

    @RequestMapping(value = "/saveProfessor", method = RequestMethod.POST)
    public String saveProfessor(@ModelAttribute("professor") Professor professor) {
        service.save(professor);

        return "redirect:/professor";
    }

    @RequestMapping("/professor/edit_professor/{cpf}")
    public ModelAndView showEditProfessorPage(@PathVariable(name = "cpf") String cpf) {
        ModelAndView mav = new ModelAndView("professor/edit_professor");
        Professor professor = service.findById(cpf);
        mav.addObject("professor", professor);
        
        return mav;
    }

    @RequestMapping("/professor/delete_professor/{cpf}")
    public String deleteProfessor(@PathVariable(name = "cpf") String cpf) {
        service.delete(cpf);
        return "redirect:/professor";
    }
}
