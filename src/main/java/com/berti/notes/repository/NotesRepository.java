package com.berti.notes.repository;

import com.berti.notes.model.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotesRepository {

    @Autowired
    JdbcTemplate template;

    /* Getting all */
    public List<Notes> getAllNotes() {
        List<Notes> items = template.query("select id,body from NOTES", (result,
                rowNum) -> new Notes(result.getLong("id"), result.getString("body")));
        return items;
    }

    /* Getting all name by query string */
    public List<Notes> getSearch(String search) {
        List<Notes> items = template.query("SELECT * FROM NOTES WHERE body LIKE ?", (result,
                rowNum) -> new Notes(result.getLong("id"), result.getString("body")),
                "%" + search + "%");
        return items;
    }

    /* Getting by id */
    public Notes getNote(int search) {
        Notes items = template.queryForObject("SELECT * FROM NOTES WHERE ID=?", (result,
                rowNum) -> new Notes(result.getLong("id"), result.getString("body")),
                search);
        return items;
    }

    /* Adding into database table */
    public int addNote(String body) {
        String query = "INSERT INTO NOTES (body) VALUES(?)";
        return template.update(query, body);
    }

    /** 
     * update a note or insert a note if tat ID doesn't exist
    */
    public int updateNote(int id, String body) {
        int q1 = 0;
        String checkid = "SELECT * FROM NOTES WHERE ID=?1";
        String query = "INSERT INTO NOTES (body) VALUES(?2)";
        String query2 = "UPDATE  NOTES SET body = ?2 WHERE ID = ?1";
        Notes items = template.queryForObject(checkid, (result, rowNum) -> new Notes(result.getLong("id"), result.getString("body")), id);
        System.out.println(items.getBody());

        if (items.getBody() != "") {
            System.out.println(items);

            q1 = template.update(query2, id, body);
        } else {

            q1 = template.update(query, body);
        }
        System.out.println(q1);
        return q1;
    }
    /**
     *  get the last note
     */
    public Notes lastNote() {
        Notes items = template.queryForObject("SELECT * from NOTES WHERE id=(SELECT max(id) FROM NOTES)", (result,
                rowNum) -> new Notes(result.getLong("id"), result.getString("body")));
        return items;
    }

    /* Delete an item */
    public int deleteItem(int id) {
        String query = "DELETE FROM NOTES WHERE ID =?";
        return template.update(query, id);
    }
}
