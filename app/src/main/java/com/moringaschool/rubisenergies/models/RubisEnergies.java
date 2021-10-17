
package com.moringaschool.rubisenergies.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RubisEnergies {

    @SerializedName("food")
    @Expose
    private com.moringaschool.rubisenergies.models.Food food;
    @SerializedName("measures")
    @Expose
    private List<com.moringaschool.rubisenergies.models.Measure> measures = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RubisEnergies() {
    }

    /**
     * 
     * @param measures
     * @param food
     */
    public RubisEnergies(com.moringaschool.rubisenergies.models.Food food, List<com.moringaschool.rubisenergies.models.Measure> measures) {
        super();
        this.food = food;
        this.measures = measures;
    }

    public com.moringaschool.rubisenergies.models.Food getFood() {
        return food;
    }

    public void setFood(com.moringaschool.rubisenergies.models.Food food) {
        this.food = food;
    }

    public List<com.moringaschool.rubisenergies.models.Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<com.moringaschool.rubisenergies.models.Measure> measures) {
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
        if ((other instanceof RubisEnergies) == false) {
            return false;
        }
        RubisEnergies rhs = ((RubisEnergies) other);
        return (((this.food == rhs.food)||((this.food!= null)&&this.food.equals(rhs.food)))&&((this.measures == rhs.measures)||((this.measures!= null)&&this.measures.equals(rhs.measures))));
    }

}
