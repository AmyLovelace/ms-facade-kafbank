package com.ppj.acl.adapter.jdbc.dao.sql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class GenericDAO {
    private static final String SQL_MESSAGE = "Se va a ejecutar el SQL {} con los parametros {}";

    private final NamedParameterJdbcTemplate template;

    @Autowired
    public GenericDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public <T> Optional<T> findOne(String sql, Object params, Class<T> tClass) {
        return doFind(sql, params, tClass).stream().findFirst();
    }

    public <T> Optional<T> findOne(String sql, Map<String, Object> params, Class<T> tClass) {
        return doFind(sql, params, tClass).stream().findFirst();
    }

    public <T> Optional<T> findOne(String sql, SqlParameterSource params, Class<T> tClass) {
        return doFind(sql, params, tClass).stream().findFirst();
    }

    public <T> List<T> findAll(String sql, Object params, Class<T> tClass) {
        return doFind(sql, params, tClass);
    }

    public <T> List<T> findAll(String sql, Map<String, Object> params, Class<T> tClass) {
        return doFind(sql, params, tClass);
    }

    private <T> List<T> doFind(String sql, SqlParameterSource params, Class<T> tClass) {
        log.info(SQL_MESSAGE, sql, params);
        return template.query(sql, params, new
                BeanPropertyRowMapper<>(tClass));
    }

    private <T> List<T> doFind(String sql, Object params, Class<T> tClass) {
        log.info(SQL_MESSAGE, sql, params);
        return template.query(sql, new BeanPropertySqlParameterSource(params), new
                BeanPropertyRowMapper<>(tClass));
    }

    private <T> List<T> doFind(String sql, Map<String, Object> params, Class<T> tClass) {
        log.info(SQL_MESSAGE, sql, params);
        return template.query(sql, params, new
                BeanPropertyRowMapper<>(tClass));
    }

    public Number insert(String sql, MapSqlParameterSource params, String[] keys) {
        log.info(SQL_MESSAGE, sql, params);
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(sql, params, holder, keys);
        return 0;
    }
}
