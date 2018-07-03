package solstice.bootcamp.codesnippetmanagerjdbc;

import java.time.LocalDate;

public class SnippetRecord {

    public final String id;
    public final String title;
    public final String code;
    public final LocalDate created;
    public final LocalDate modified;

    public SnippetRecord(String id, String title, String code, LocalDate created, LocalDate modified) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.created = created;
        this.modified = modified;
    }
}
