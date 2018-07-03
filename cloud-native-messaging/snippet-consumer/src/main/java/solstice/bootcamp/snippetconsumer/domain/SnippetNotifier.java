package solstice.bootcamp.snippetconsumer.domain;

import java.util.Date;

public class SnippetNotifier {

    private String title;
    private Date created;

    public SnippetNotifier(){}

    public String getTitle() {
        return title;
    }

    public Date getCreated() {
        return created;
    }
}