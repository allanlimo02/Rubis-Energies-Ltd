
package com.moringaschool.rubisenergies.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.rubisenergies.models.Nutrients;

@Generated("jsonschema2pojo")
public class Food {

    @SerializedName("foodId")
    @Expose
    private String foodId;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("nutrients")
    @Expose
    private Nutrients nutrients;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("categoryLabel")
    @Expose
    private String categoryLabel;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Food() {
    }

    /**
     * 
     * @param image
     * @param foodId
     * @param categoryLabel
     * @param label
     * @param category
     * @param uri
     * @param nutrients
     */
    public Food(String foodId, String uri, String label, Nutrients nutrients, String category, String categoryLabel, String image) {
        super();
        this.foodId = foodId;
        this.uri = uri;
        this.label = label;
        this.nutrients = nutrients;
        this.category = category;
        this.categoryLabel = categoryLabel;
        this.image = image;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
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

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.foodId == null)? 0 :this.foodId.hashCode()));
        result = ((result* 31)+((this.categoryLabel == null)? 0 :this.categoryLabel.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.category == null)? 0 :this.category.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.nutrients == null)? 0 :this.nutrients.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Food) == false) {
            return false;
        }
        Food rhs = ((Food) other);
        return ((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this.foodId == rhs.foodId)||((this.foodId!= null)&&this.foodId.equals(rhs.foodId))))&&((this.categoryLabel == rhs.categoryLabel)||((this.categoryLabel!= null)&&this.categoryLabel.equals(rhs.categoryLabel))))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.category == rhs.category)||((this.category!= null)&&this.category.equals(rhs.category))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))))&&((this.nutrients == rhs.nutrients)||((this.nutrients!= null)&&this.nutrients.equals(rhs.nutrients))));
    }

}
