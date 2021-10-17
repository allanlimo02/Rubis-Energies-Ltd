package com.moringaschool.rubisenergies.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Qualified {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Qualified() {
    }

    /**
     * 
     * @param label
     * @param uri
     */
    public Qualified(String uri, String label) {
        super();
        this.uri = uri;
        this.label = label;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Qualified) == false) {
            return false;
        }
        Qualified rhs = ((Qualified) other);
        return (((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri)))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))));
    }

}
