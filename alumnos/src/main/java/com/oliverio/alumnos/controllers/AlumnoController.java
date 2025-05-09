package com.oliverio.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliverio.alumnos.model.Alumno;
import com.oliverio.alumnos.repository.AlumnoRepository;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
   private AlumnoRepository alumnoRepository;

   @GetMapping("/traer-alumnos")
   public List<Alumno> traerAlumnos() {
       return alumnoRepository.findAll();
   }

}
