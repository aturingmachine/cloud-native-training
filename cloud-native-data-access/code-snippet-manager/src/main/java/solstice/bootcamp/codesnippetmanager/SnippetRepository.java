package solstice.bootcamp.codesnippetmanager;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
public class SnippetRepository {

    private List<SnippetRecord> snippets = new ArrayList<SnippetRecord>() {
        {
            add(buildRecord("JavaScript: Hello World", "console.log('Hello World!');"));
            add(buildRecord("HTML: Hello World", "<html><body><h1>Hello World</h1></body></html>"));
            add(buildRecord("Bash: Hello World", "echo \"Hello World\""));
            add(buildRecord("Python: Hello World", "print \"Hello World\""));
        }
    };

    public SnippetRecord save(NewSnippetFields snippetFields) {
        SnippetRecord snippetRecord = buildRecord(snippetFields.title, snippetFields.code);

        this.snippets.add(snippetRecord);
        return snippetRecord;
    }

    public List<SnippetRecord> findAll() {
        return snippets;
    }

    public SnippetRecord findById(String id) {
        return snippets.stream()
                .filter(snippet -> snippet.id.equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no snippet with id: "+id));
    }

    public SnippetRecord buildRecord(String title, String code) {
        String newId = randomUUID().toString();
        LocalDate now = LocalDate.now();

        return new SnippetRecord(newId, title, code, now, now);
    }
}
