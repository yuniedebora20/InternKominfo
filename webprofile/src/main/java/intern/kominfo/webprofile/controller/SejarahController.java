package intern.kominfo.webprofile.controller;

import intern.kominfo.webprofile.model.SejarahModel;
import intern.kominfo.webprofile.service.SejarahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
public class SejarahController {
    @Autowired
    SejarahService sejarahService;

    @GetMapping("/sejarah-jambi/add")
    public String addSejarahFormPage(Model model) {
        model.addAttribute("hotel", new SejarahModel());
        return "form-add-sejarah";
    }

    @PostMapping("/sejarah-jambi/add")
    public String addSejarahSubmit(
            @ModelAttribute SejarahModel sejarah,
            Model model) {
        sejarahService.addSejarah(sejarah);
        model.addAttribute("id", sejarah.getId());
        return "add-sejarah";
    }

    @GetMapping("/sejarah-jambi/change/{id}")
    public String changeSejarahFormPage(
            @PathVariable Long id,
            Model model) {
        try {
            SejarahModel sejarah = sejarahService.getSejarahById(id);
            model.addAttribute("sejarah", sejarah);
            return "form-update-sejarah";
        } catch (NoSuchElementException e) {
            String message = "Proses update tidak dapat dilakukan karena id Sejarah tidak valid.";
            model.addAttribute("message", message);
            return "error-page";
        }
    }

    @PostMapping("/sejarah-jambi/change")
    public String changeSejarahFormSubmit(
            @ModelAttribute SejarahModel sejarah,
            Model model) {
        SejarahModel sejarahUpdated = sejarahService.updateSejarah(sejarah);
        model.addAttribute("sejarah", sejarah);
        return "update-sejarah";
    }

    @RequestMapping("/sejarah-jambi/view")
    public String viewDetailSejarah(
            @RequestParam(value = "id") Long id,
            Model model) {
        try {
            SejarahModel sejarah = sejarahService.getSejarahById(id);
            model.addAttribute("sejarah", sejarah);
            return "view-sejarah";
        } catch (NoSuchElementException e) {
            String message = "Proses view tidak dapat dilakukan karena id Sejarah tidak valid.";
            model.addAttribute("message", message);
            return "error-page";
        }
    }
}
