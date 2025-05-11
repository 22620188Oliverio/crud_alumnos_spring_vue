package com.oliverio.alumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

   @PostMapping("/insertar-alumnos")
   public Alumno insertarAlumno(@RequestBody Alumno alumno) {
       return alumnoRepository.save(alumno);
   }

   @PutMapping("/editar-alumnos/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
         return alumnoRepository.findById(id)
           .map(existingAlumno -> {
               existingAlumno.setNumeroControl(alumno.getNumeroControl());
               existingAlumno.setNombre(alumno.getNombre());
               existingAlumno.setApellido(alumno.getApellido());
               existingAlumno.setTelefono(alumno.getTelefono());
               existingAlumno.setEmail(alumno.getEmail());
               existingAlumno.setCarrera(alumno.getCarrera());
               existingAlumno.setImagenURL(alumno.getImagenURL());
               Alumno updatedAlumno = alumnoRepository.save(existingAlumno);
               return ResponseEntity.ok(updatedAlumno);
           })
           .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar-alumnos/{id}")
    public void eliminarAlumno(@PathVariable Long id) {
        alumnoRepository.deleteById(id);
    }

}
