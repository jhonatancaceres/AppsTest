package co.grability.test.bo;

import java.io.Serializable;

public class Id implements Serializable {

    private String label;
    private String id;
    private String bundleId;

    public Id() {
    }

    public Id(String label, String id, String bundleId) {
        this.label = label;
        this.id = id;
        this.bundleId = bundleId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

}