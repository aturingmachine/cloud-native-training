package solstice.bootcamp.codesnippetmanagerjdbc;

public class NewSnippetFields {

    public final String title;
    public final String code;

    public NewSnippetFields(String title, String code) {
        this.title = title;
        this.code = code;
    }

    // Make jackson happy when parsing JSON into this class
    private NewSnippetFields() {
        this(null, null);
    }
}
