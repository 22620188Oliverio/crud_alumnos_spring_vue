package com.oliverio.alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliverio.alumnos.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    // No additional methods are needed for basic CRUD operations
 
}
