package solstice.bootcamp.codesnippetmanagerjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
public class SnippetRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<SnippetRecord> rowMapper = (ResultSet rs, int row) ->
            new SnippetRecord(
                    rs.getString("id"),
                    rs.getString("title"),
                    rs.getString("code"),
                    rs.getDate("created").toLocalDate(),
                    rs.getDate("modified").toLocalDate()
            );

    //Constructor
    public SnippetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Insert String for DB
    private final String SQL_INSERT = "insert into snippet (id, title, code, created, modified)" +
            " values(?, ?, ?, now(), now())";

    //Create a New Snippet in the DB
    public SnippetRecord save(NewSnippetFields newSnippetFields) {
        String newUUID = randomUUID().toString();

        jdbcTemplate.update(SQL_INSERT, newUUID, newSnippetFields.title, newSnippetFields.code);

        return findOne(newUUID);
    }


    //Get all SQL Query
    private final String SQL_QUERY_ALL = "select * from snippet";

    //Return all snippets
    public List<SnippetRecord> findAll() {
        return jdbcTemplate.query(SQL_QUERY_ALL, rowMapper);
    }

    private final String SQL_GET_ONE = "select * from snippet where id = ?";

    public SnippetRecord findOne(String id) {
        return jdbcTemplate.queryForObject(SQL_GET_ONE, new Object[]{id}, rowMapper);
    }


}
