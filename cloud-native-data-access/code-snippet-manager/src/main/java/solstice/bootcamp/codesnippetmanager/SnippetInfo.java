package solstice.bootcamp.codesnippetmanager;

public class SnippetInfo {

    public final String id;
    public final String title;
    public final String code;
    public final String created;
    public final String modified;

    public SnippetInfo(String id, String title, String code, String created, String modified) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.created = created;
        this.modified = modified;
    }
}
