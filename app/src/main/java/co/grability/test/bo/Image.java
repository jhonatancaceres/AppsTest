package co.grability.test.bo;

import java.io.Serializable;

public class Image implements Serializable{

    private String url;
    private Integer height;

    public Image() {
    }

    public Image(String url, Integer height) {
        this.url = url;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}