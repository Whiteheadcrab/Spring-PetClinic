package springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springpetclinic.model.Vet;
import springpetclinic.services.VetService;

import java.util.Set;

@Controller
public class VetController
{
    private final VetService vetService;

    public VetController(VetService vetService)
    {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets" , "/vets/index" , "/vets/index.html","/vets.html"})
    public String listVets(Model model)
    {
        model.addAttribute("vets",vetService.findAll());
        return  "vets/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody
    Set<Vet> getVetsJson(){

        return vetService.findAll();
    }
}
