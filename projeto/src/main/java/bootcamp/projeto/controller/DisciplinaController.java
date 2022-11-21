package bootcamp.projeto.controller;

import bootcamp.projeto.dto.DisciplinaRestDTO;
import bootcamp.projeto.entities.Disciplina;
import bootcamp.projeto.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
//@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @RequestMapping("/disciplina")
    public String viewHomePage(Model model) {
        List<Disciplina> listDisciplinas = service.listAll();
        model.addAttribute("listDisciplinas", listDisciplinas);

        return "disciplina/index_disciplina";
    }

    @RequestMapping("/disciplina/new_disciplina")
    public String showNewDisciplinaPage(Model model) {
        Disciplina disciplina = new Disciplina();
        model.addAttribute("disciplina", disciplina);

        List<DisciplinaRestDTO> listDisciplinas = service.listAllDisciplinasMinisterio();
        model.addAttribute("listDisciplinas", listDisciplinas);

        return "disciplina/new_disciplina";
    }

    @RequestMapping(value = "/saveDisciplina",method = RequestMethod.POST)
    public String saveDisciplina(@ModelAttribute(name = "disciplina") Disciplina disciplina) {
        service.save(disciplina);

        return "redirect:/disciplina";
    }

    @RequestMapping("/disciplina/edit_disciplina/{id}")
    public ModelAndView showEditDisciplinaPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("disciplina/edit_disciplina");
        Disciplina disciplina = service.findById(id);
        mav.addObject("disciplina", disciplina);

        return mav;
    }

    @RequestMapping("/disciplina/delete_disciplina/{id}")
    public String deleteDisciplina(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/disciplina";
    }
}
