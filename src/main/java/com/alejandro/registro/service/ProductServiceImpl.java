package com.alejandro.registro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alejandro.registro.models.producto;
import com.alejandro.registro.repository.productoRepository;

@Service
public class ProductServiceImpl implements ProductService{
    private final productoRepository productoRepositoy;

    public ProductServiceImpl(productoRepository productoRepositoy) {
        this.productoRepositoy = productoRepositoy;
    }

    @Override
    public List<producto> listar() {
        return productoRepositoy.findAll();
    }

    @Override
    public Optional<producto> obtenerPorId(Long id) {
        return productoRepositoy.findById(id);
    }

    @Override
    public producto guardar(producto producto) {
        return productoRepositoy.save(producto);
    }

    @Override
    public producto actualizar(producto producto) {
        return productoRepositoy.save(producto);
    }

    @Override
    public void borrar(Long id) {
        productoRepositoy.deleteById(id);
    }
}