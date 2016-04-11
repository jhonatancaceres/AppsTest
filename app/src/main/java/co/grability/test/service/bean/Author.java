package co.grability.test.service.bean;

public class Author {

    private Name name;
    private Name uri;

    public Author() {
    }
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Name getUri() {
        return uri;
    }

    public void setUri(Name uri) {
        this.uri = uri;
    }
    
}
