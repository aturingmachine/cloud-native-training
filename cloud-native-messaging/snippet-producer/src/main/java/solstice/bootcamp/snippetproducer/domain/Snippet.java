package solstice.bootcamp.snippetproducer.domain;

import java.util.Date;

public class Snippet {

    private String id;
    private String title;
    private String code;
    private Date created;
    private Date modified;

    public Snippet(String title, String code) {
        this.id = java.util.UUID.randomUUID().toString();
        this.title = title;
        this.code = code;
        this.created = new Date();
        this.modified = new Date();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }
}
