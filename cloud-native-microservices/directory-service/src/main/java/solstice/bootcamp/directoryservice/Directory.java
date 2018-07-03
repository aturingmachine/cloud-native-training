package solstice.bootcamp.directoryservice;

import javax.persistence.*;
import java.util.List;

@Entity
public class Directory {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Person> people;

    public Directory() {}

    public Directory(String name) {
        this.name = name;
    }

    public Directory(String name, List<Person> people) {
        this.name = name;
        this.people = people;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
