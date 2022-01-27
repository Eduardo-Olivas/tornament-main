package net.atos.crojo.dto;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroReqDTO extends BaseDTO{

	//http://localhost:8185/Crud/Registro
	
    private String status;
    private String lugar;
    private String formato;
    private String name;
    private String organisador;
    private String hora;
    private String inscritos;
    private String fecha;
    private String baja;
    private String categoria;
    private String owner;
   
	
		
}
