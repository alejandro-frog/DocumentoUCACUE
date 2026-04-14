package com.alejandro.registro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alejandro.registro.models.producto;
import com.alejandro.registro.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private ProductService productoService;

    public ProductoController(ProductService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new producto());
        model.addAttribute("titulo", "Nuevo Producto");
        return "producto/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarProducto(producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping
    public String listarProductos(Model model) {
        List<producto> productos = productoService.listar();
        model.addAttribute("productos", productos);
        model.addAttribute("titulo", "Listado de Productos");
        return "producto/index";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model) {
        producto prod = productoService.obtenerPorId(id).orElse(null);
        if (prod != null) {
            model.addAttribute("producto", prod);
            model.addAttribute("titulo", "Editar Producto");
            return "producto/editar";
        }
        return "redirect:/productos";
    }

    @PostMapping("/actualizar")
    public String actualizarProducto(producto producto) {
        productoService.actualizar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.borrar(id);
        return "redirect:/productos";
    }
}