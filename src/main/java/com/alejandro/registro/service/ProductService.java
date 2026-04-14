package com.alejandro.registro.service;


import com.alejandro.registro.models.producto;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<producto> listar();

    Optional<producto> obtenerPorId(Long id);

    producto guardar(producto producto);

    producto actualizar(producto producto);

    void borrar(Long id);
}
