package springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springpetclinic.model.Owner;
import springpetclinic.services.OwnerService;

import java.util.List;


@RequestMapping("/owners")
@Controller
public class OwnerController
{
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService)
    {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }

//    @RequestMapping({"","/","/index","/index.html"})
//    public String listOwners(Model model)
//   {
//        model.addAttribute("owners",ownerService.findAll());
//
//        return "owners/index";
//    }

    @RequestMapping("/find")
    public String findOwner(Model model)
    {
        model.addAttribute("owner", Owner.builder().build());
        return "owner/findOwner";
    }

    @GetMapping
    public String processFindForm(Owner owner , BindingResult result, Model model)
    {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null)
        {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (results.isEmpty())
            {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
            }
        else
            if (results.size() == 1)
            {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
            }
        else
            {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
            }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId)
    {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
}
