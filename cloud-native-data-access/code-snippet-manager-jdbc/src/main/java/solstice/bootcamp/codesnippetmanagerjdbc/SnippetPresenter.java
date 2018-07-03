package solstice.bootcamp.codesnippetmanagerjdbc;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class SnippetPresenter {

    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

    public SnippetInfo present(SnippetRecord record) {
        return new SnippetInfo(
                record.id,
                record.title,
                record.code,
                record.created.format(formatter),
                record.modified.format(formatter)
        );
    }
}
