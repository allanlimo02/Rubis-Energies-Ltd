
package com.moringaschool.rubisenergies.models;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class YelpEventSearchResponse {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public YelpEventSearchResponse() {
    }

    /**
     * 
     * @param total
     * @param events
     */
    public YelpEventSearchResponse(Integer total, List<Event> events) {
        super();
        this.total = total;
        this.events = events;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.total == null)? 0 :this.total.hashCode()));
        result = ((result* 31)+((this.events == null)? 0 :this.events.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof YelpEventSearchResponse) == false) {
            return false;
        }
        YelpEventSearchResponse rhs = ((YelpEventSearchResponse) other);
        return (((this.total == rhs.total)||((this.total!= null)&&this.total.equals(rhs.total)))&&((this.events == rhs.events)||((this.events!= null)&&this.events.equals(rhs.events))));
    }

}
