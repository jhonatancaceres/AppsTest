package co.grability.test.bo;

import java.io.Serializable;

public class Artist implements Serializable {

    private String label;
    private String href;

    public Artist() {
    }

    public Artist(String label, String href) {
        this.label = label;
        this.href = href;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}