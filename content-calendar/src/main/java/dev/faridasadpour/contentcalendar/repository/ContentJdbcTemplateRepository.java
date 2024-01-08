package dev.faridasadpour.contentcalendar.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.faridasadpour.contentcalendar.model.Content;
import dev.faridasadpour.contentcalendar.model.Status;
import dev.faridasadpour.contentcalendar.model.Type;

/**
 * ContentJdbcTemplateRepository
 */
@Repository
public class ContentJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(rs.getInt("id"), 
            rs.getString("title"), 
            rs.getString("description"), 
            Status.valueOf(rs.getString("status")),
            Type.valueOf(rs.getString("content_type")), 
            rs.getObject("date_created", LocalDateTime.class), 
            rs.getObject("date_updated", LocalDateTime.class), 
            rs.getString("url")
            );
    }

    public List<Content> findAllContetnts() {
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return contents;
    }

    public void createContent(String title, String description, String status, String content_type, String url) {
        String sql = "INSERT INTO Content(title, description, status, content_type, date_created, url) VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, title, description, status, content_type, LocalDateTime.now(), url );
    }

    //  public void createContent(String title) {
    //     String sql = "INSERT INTO Content(title) VALUES(?)";
    //     jdbcTemplate.update(sql, title);
    // }
    
    public void updateContent(int id, String title, String description, String status, String content_type, String url) {
        String sql = "UPDATE Content SET title=?, description=?, status=?, content_type=?, date_updated=?, url=? WHERE id=?";
        jdbcTemplate.update(sql, title, description, status, content_type, LocalDateTime.now(), url, id );
    }

    public void deleteContent(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Content findById(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, ContentJdbcTemplateRepository::mapRow, new Object[]{id});
        return content;
    }
}