package co.grability.test.service.bean;

public class Entry {

    private Name name;
    private Image[] image;
    private Name summary;
    private Price price;
    private ContentType contentType;
    private Name rights;
    private Name title;
    private Link link;
    private Id id;
    private Artist artist;
    private Category category;
    private ReleaseDate releaseDate;

    public Entry() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Image[] getImage() {
        return image;
    }

    public void setImage(Image[] image) {
        this.image = image;
    }

    public Name getSummary() {
        return summary;
    }

    public void setSummary(Name summary) {
        this.summary = summary;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Name getRights() {
        return rights;
    }

    public void setRights(Name rights) {
        this.rights = rights;
    }

    public Name getTitle() {
        return title;
    }

    public void setTitle(Name title) {
        this.title = title;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(ReleaseDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    
}
