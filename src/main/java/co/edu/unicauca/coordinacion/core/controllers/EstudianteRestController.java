package co.edu.unicauca.coordinacion.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.coordinacion.core.services.DTO.EstudianteDTO;
import co.edu.unicauca.coordinacion.core.services.services.IEstudianteService;

@RestController
@RequestMapping("/api")
public class EstudianteRestController {
    @Autowired
	private IEstudianteService EstudianteService;
	
	@GetMapping("/estudiantes")
	public List<EstudianteDTO> index() {
		return EstudianteService.findAll();
	}

	@GetMapping("/estudiante/{code}")
	public EstudianteDTO show(@PathVariable Integer code) {
		EstudianteDTO objEstudiante = null;		
		objEstudiante = EstudianteService.findByCode(code);		
		return objEstudiante;
	}

	@PostMapping("/estudiante")
	public EstudianteDTO create(@RequestBody EstudianteDTO estudiante) {
		EstudianteDTO objEstudiante = null;		
		objEstudiante = EstudianteService.save(estudiante);		
		return objEstudiante;
	}

	@PutMapping("/estudiante/{code}")
	public EstudianteDTO update(@RequestBody EstudianteDTO estudiante, @PathVariable Integer code) {
		EstudianteDTO objEstudiante = null;
		EstudianteDTO estudianteActual = EstudianteService.findByCode(code);
		if(estudianteActual!=null)	
		{
			objEstudiante = EstudianteService.update(code,estudiante);
		}
		return objEstudiante;
	}

	@DeleteMapping("/estudiante")
	public boolean delete(@RequestParam Integer code) {
		return EstudianteService.delete(code);
	}
}
