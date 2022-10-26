package co.edu.unicauca.coordinacion.core.services.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class EstudianteDTO {
    private Integer codigo;
	private Integer id;
	private String nombre;	
	private String apellido;	
	private String email;	
	private String ciudad;		
	private String tituloUniv;	
	private Integer telefono;	
	private String genero;
	private Date createAt; 

	public EstudianteDTO()
	{
		
	}
}
