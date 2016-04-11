package co.grability.test.bo;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class App implements Serializable{

    private String name;
    private ArrayList<Image> images;
    private String summary;
    private Price price;
    private ContentType contentType;
    private String rights;
    private String title;
    private Link link;
    private Id id;
    private Artist artist;
    private Category category;
    private ReleaseDate releaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Image> getImages() {
        return images;
    }
    public String getUrlImage(Integer position){
        if(this.images!=null && this.images.size()>position){
            Image i=this.images.get(position);
            if(i!=null){
                return i.getUrl();
            }
        }
        return null;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
    public void addImage(String url,Integer height) {
        if(this.images==null){
            this.images=new ArrayList<>();
        }
        this.images.add(new Image(url,height));
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
    public void setPrice(String label,Double amount,String currency) {
        this.price = new Price(label,amount, currency);
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }
    public void setContentType(String term,String label) {
        this.contentType = new ContentType(term,label);
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
    public void setLink(String rel,String type,String href) {
        this.link = new Link(rel, type, href);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
    public void setId(String label,String id,String bundel) {
        this.id = new Id(label, id, bundel);
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setArtist(String label, String href) {
        this.artist = new Artist(label, href);
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

    public void setReleaseDate(String label, String label2) {
        this.releaseDate = new ReleaseDate(label, label2);
    }

}

class ContentType implements Serializable{

    private String term;
    private String label;

    public ContentType() {
    }

    public ContentType(String term, String label) {
        this.term = term;
        this.label = label;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}

class Link implements Serializable {

    private String rel;
    private String type;
    private String href;

    public Link() {
    }

    public Link(String rel, String type, String href) {
        this.rel = rel;
        this.type = type;
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}

class ReleaseDate implements Serializable {

    private String label;
    private String label2;

    public ReleaseDate() {
    }

    public ReleaseDate(String label, String label2) {
        this.label = label;
        this.label2 = label2;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

}
