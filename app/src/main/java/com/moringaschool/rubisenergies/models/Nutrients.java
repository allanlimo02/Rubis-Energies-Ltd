package com.moringaschool.rubisenergies.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Nutrients {

    @SerializedName("ENERC_KCAL")
    @Expose
    private Double enercKcal;
    @SerializedName("PROCNT")
    @Expose
    private Double procnt;
    @SerializedName("FAT")
    @Expose
    private Double fat;
    @SerializedName("CHOCDF")
    @Expose
    private Double chocdf;
    @SerializedName("FIBTG")
    @Expose
    private Double fibtg;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Nutrients() {
    }

    /**
     * 
     * @param enercKcal
     * @param procnt
     * @param chocdf
     * @param fat
     * @param fibtg
     */
    public Nutrients(Double enercKcal, Double procnt, Double fat, Double chocdf, Double fibtg) {
        super();
        this.enercKcal = enercKcal;
        this.procnt = procnt;
        this.fat = fat;
        this.chocdf = chocdf;
        this.fibtg = fibtg;
    }

    public Double getEnercKcal() {
        return enercKcal;
    }

    public void setEnercKcal(Double enercKcal) {
        this.enercKcal = enercKcal;
    }

    public Double getProcnt() {
        return procnt;
    }

    public void setProcnt(Double procnt) {
        this.procnt = procnt;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getChocdf() {
        return chocdf;
    }

    public void setChocdf(Double chocdf) {
        this.chocdf = chocdf;
    }

    public Double getFibtg() {
        return fibtg;
    }

    public void setFibtg(Double fibtg) {
        this.fibtg = fibtg;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.fat == null)? 0 :this.fat.hashCode()));
        result = ((result* 31)+((this.fibtg == null)? 0 :this.fibtg.hashCode()));
        result = ((result* 31)+((this.enercKcal == null)? 0 :this.enercKcal.hashCode()));
        result = ((result* 31)+((this.procnt == null)? 0 :this.procnt.hashCode()));
        result = ((result* 31)+((this.chocdf == null)? 0 :this.chocdf.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Nutrients) == false) {
            return false;
        }
        Nutrients rhs = ((Nutrients) other);
        return ((((((this.fat == rhs.fat)||((this.fat!= null)&&this.fat.equals(rhs.fat)))&&((this.fibtg == rhs.fibtg)||((this.fibtg!= null)&&this.fibtg.equals(rhs.fibtg))))&&((this.enercKcal == rhs.enercKcal)||((this.enercKcal!= null)&&this.enercKcal.equals(rhs.enercKcal))))&&((this.procnt == rhs.procnt)||((this.procnt!= null)&&this.procnt.equals(rhs.procnt))))&&((this.chocdf == rhs.chocdf)||((this.chocdf!= null)&&this.chocdf.equals(rhs.chocdf))));
    }

}
