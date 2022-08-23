package com.kuki.Practice_Mk1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String subCableList() {
        return "subCableList";
    }
}
