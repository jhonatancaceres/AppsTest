package co.grability.test.service.bean;

public class Feed {
    
    private Author author;
    private Entry[] entry;

    public Feed() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Entry[] getEntry() {
        return entry;
    }

    public void setEntry(Entry[] entry) {
        this.entry = entry;
    }

    
    
}
