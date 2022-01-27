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

import net.atos.crojo.model.User;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> list() {
		String sql = "SELECT * FROM users";

		List<User> listUser = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(User.class));

		return listUser;
	}

	
	public void save(User User) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("users").usingColumns("id", "name", "surname","email","role","username","password","status");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(User);
		
		insertActor.execute(param);		
	}
	
	public User get(String id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		Object[] args = {id};
		User User = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(User.class));
		return User;
	}
	

	public User getByEmail(String MemberEmail) {
		String sql = "SELECT * FROM users WHERE email = ?";
		Object[] args = {MemberEmail};
		User User = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(User.class));
		return User;
	}
	
	public void update(User User) {
		String sql = "UPDATE users SET id=:id, name=:name, surname=:surname, email=:email, role=:role, username=:username, password=:password, status=:status WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(User);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(String id) {
		String sql = "DELETE FROM users WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
