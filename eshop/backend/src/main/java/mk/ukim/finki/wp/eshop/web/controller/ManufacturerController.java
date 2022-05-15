package mk.ukim.finki.wp.eshop.web.controller;

import mk.ukim.finki.wp.eshop.model.Manufacturer;
import mk.ukim.finki.wp.eshop.service.ManufacturerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping("/add")
    public String saveManufacturer(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String address) {

        this.manufacturerService.save(name, address);
        return "redirect:/manufacturers";
    }


    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addManufacturerPage(Model model) {
        List<Manufacturer> manufacturers = this.manufacturerService.listManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("bodyContent", "add-manufacturer");
        return "master-template";
    }

    @GetMapping
    public String getManufacturerPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Manufacturer> manufacturers = this.manufacturerService.listManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("bodyContent", "manufacturers");
        return "master-template";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteManufacturer(@PathVariable Long id) {
        this.manufacturerService.deleteById(id);
        return "redirect:/manufacturers";
    }
}
