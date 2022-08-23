package com.kuki.Practice_Mk1.controller;

import com.kuki.Practice_Mk1.domain.SubCable;
import com.kuki.Practice_Mk1.service.SubCableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubCableController {

    private final SubCableService subCableService;

    @Autowired
    public SubCableController(SubCableService subCableService) {
        this.subCableService = subCableService;
    }

    @GetMapping("/subCableRegist")
    public String subCableRegist(){
        return "subCableRegist";
    }

    @PostMapping("/subCableRegist")
    public String create(SubCableForm form) {
        SubCable subCable = new SubCable();
        subCable.setSubCableName(form.getSubCableName());

        subCableService.join(subCable);

        return "redirect:/subCableList";
    }

    @GetMapping("/subCableList")
    public String list(Model model){
        List<SubCable> subCableList = subCableService.findSubCables();
        model.addAttribute("subCableList", subCableList);
        return "subCableList";
    }

}
