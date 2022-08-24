package com.kuki.Practice_Mk1.repository;

import com.kuki.Practice_Mk1.domain.SubCable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateSubCableRepository implements SubCableRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateSubCableRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SubCable save(SubCable subCable) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("subcable").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("subCableName", subCable.getSubCableName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        subCable.setId(key.longValue());
        return subCable;
    }

    @Override
    public Optional<SubCable> findById(Long id) {
        List<SubCable> result = jdbcTemplate.query("select * from subcable where id = ?", subCableRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<SubCable> findBySubCableName(String subCableName) {
        List<SubCable> result = jdbcTemplate.query("select * from subcable where subCableName = ?", subCableRowMapper(), subCableName);
        return result.stream().findAny();
    }

    @Override
    public List<SubCable> findAll() {
        return jdbcTemplate.query("select * from subcable", subCableRowMapper());
    }

    private RowMapper<SubCable> subCableRowMapper() {
        return (rs, rowNum) -> {
            SubCable subCable = new SubCable();
            subCable.setId(rs.getLong("id"));
            subCable.setSubCableName(rs.getString("subCableName"));
            return subCable;
        };
    }
}
