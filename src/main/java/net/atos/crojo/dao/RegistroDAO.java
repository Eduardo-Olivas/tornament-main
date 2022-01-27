package net.atos.crojo.dao;

import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import net.atos.crojo.model.Registro;

@Repository
public class RegistroDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Registro> list() {
		String sql = "SELECT * FROM registros";

		List<Registro> listRegistro = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Registro.class));

		return listRegistro;
	}

	
	public void save(Registro registro) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("registros").usingColumns("id", "status", "lugar","formato","name","organisador","hora","inscritos","fecha","baja","categoria","owner");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(registro);
		
		insertActor.execute(param);		
	}
	
	public Registro get(String id) {
		String sql = "SELECT * FROM registros WHERE id = ?";
		Object[] args = {id};
		Registro Registro = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Registro.class));
		return Registro;
	}
	
	
	public void update(Registro Registro) {
		String sql = "UPDATE registros SET id=:id, status=:status, lugar=:lugar, formato=:formato, name=:name, organisador=:organisador, hora=:hora, inscritos=:inscritos, fecha=:fecha, baja=:baja, categoria=:categoria, owner=:owner WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Registro);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String id) {
		String sql = "DELETE FROM registros WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
