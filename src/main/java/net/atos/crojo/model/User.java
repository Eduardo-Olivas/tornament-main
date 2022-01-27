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
@Table(name="Users")
public class User extends Base{

	@Column(name="name")
    private String name;
	@Column(name="lastname")
    private String lastname;
	@Column(name="surname")
    private String surname;
	@Column(name="email")
    private String email;
	@Column(name="role")
    private String role;
	@Column(name="username")
    private String username;
	@Column(name="password")
    private String password;
	@Column(name="status")
    private String status;
	
	
	
	@Column(name="usermodifier")
    private String usermodifier;
	@Column(name="usercreator")
    private String usercreator;
	
		
}
