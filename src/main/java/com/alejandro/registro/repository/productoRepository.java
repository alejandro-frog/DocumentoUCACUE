package com.alejandro.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandro.registro.models.producto;

public interface productoRepository extends JpaRepository<producto, Long> {
}
