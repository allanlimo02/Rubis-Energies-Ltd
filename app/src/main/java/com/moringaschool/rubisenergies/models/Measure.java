
package com.moringaschool.rubisenergies.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.rubisenergies.models.Qualified;

@Generated("jsonschema2pojo")
public class Measure {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("qualified")
    @Expose
    private List<List<Qualified>> qualified = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Measure() {
    }

    /**
     * 
     * @param qualified
     * @param label
     * @param uri
     */
    public Measure(String uri, String label, List<List<Qualified>> qualified) {
        super();
        this.uri = uri;
        this.label = label;
        this.qualified = qualified;
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

    public List<List<Qualified>> getQualified() {
        return qualified;
    }

    public void setQualified(List<List<Qualified>> qualified) {
        this.qualified = qualified;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.qualified == null)? 0 :this.qualified.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Measure) == false) {
            return false;
        }
        Measure rhs = ((Measure) other);
        return ((((this.qualified == rhs.qualified)||((this.qualified!= null)&&this.qualified.equals(rhs.qualified)))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))));
    }

}
