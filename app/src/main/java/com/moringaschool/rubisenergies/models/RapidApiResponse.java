
package com.moringaschool.rubisenergies.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RapidApiResponse {

    @SerializedName("food")
    @Expose
    private Food food;
    @SerializedName("measures")
    @Expose
    private List<Measure> measures = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RapidApiResponse() {
    }

    /**
     * 
     * @param measures
     * @param food
     */
    public RapidApiResponse(Food food, List<Measure> measures) {
        super();
        this.food = food;
        this.measures = measures;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.food == null)? 0 :this.food.hashCode()));
        result = ((result* 31)+((this.measures == null)? 0 :this.measures.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RapidApiResponse) == false) {
            return false;
        }
        RapidApiResponse rhs = ((RapidApiResponse) other);
        return (((this.food == rhs.food)||((this.food!= null)&&this.food.equals(rhs.food)))&&((this.measures == rhs.measures)||((this.measures!= null)&&this.measures.equals(rhs.measures))));
    }

}
