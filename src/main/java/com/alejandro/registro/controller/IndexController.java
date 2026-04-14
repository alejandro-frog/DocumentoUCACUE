package com.alejandro.registro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alejandro.registro.service.ProductService;

@Controller
public class IndexController {

    private ProductService productService;

    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalProductos", productService.listar().size());
        return "index";
    }
}
