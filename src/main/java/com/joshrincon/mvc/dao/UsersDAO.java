package com.joshrincon.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("usersDAO")
public class UsersDAO {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Transactional
    public boolean create(User user) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
        jdbcTemplate.update("insert into users (username, password, email, enabled) values (:username, :password, :email, :enabled)", params);
        return jdbcTemplate.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
    }


    public boolean exists(String username) {
        return jdbcTemplate.queryForObject("select count(*) from users where username=:username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;
    }
}