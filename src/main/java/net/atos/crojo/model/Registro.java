package net.atos.crojo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Registros")
public class Registro extends Base{

	@Column(name="status")
    private String status;
	@Column(name="lugar")
    private String lugar;
	@Column(name="formato")
    private String formato;
	@Column(name="name")
    private String name;
	@Column(name="organisador")
    private String organisador;
	@Column(name="hora")
    private String hora;
	@Column(name="inscritos")
    private String inscritos;
	@Column(name="fecha")
    private String fecha;
	@Column(name="baja")
    private String baja;
	@Column(name="categoria")
    private String categoria;
	@Column(name="owner")
    private String owner;
	
	
	@Column(name="registromodifier")
    private String registromodifier;
	@Column(name="registrocreator")
    private String registrocreator;
	
		
}
