
package com.moringaschool.rubisenergies.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Location {

    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("address3")
    @Expose
    private String address3;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("display_address")
    @Expose
    private List<String> displayAddress = null;
    @SerializedName("cross_streets")
    @Expose
    private String crossStreets;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param zipCode
     * @param country
     * @param address3
     * @param crossStreets
     * @param address2
     * @param city
     * @param address1
     * @param displayAddress
     * @param state
     */
    public Location(String address1, String address2, String address3, String city, String zipCode, String country, String state, List<String> displayAddress, String crossStreets) {
        super();
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
        this.displayAddress = displayAddress;
        this.crossStreets = crossStreets;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(List<String> displayAddress) {
        this.displayAddress = displayAddress;
    }

    public String getCrossStreets() {
        return crossStreets;
    }

    public void setCrossStreets(String crossStreets) {
        this.crossStreets = crossStreets;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.zipCode == null)? 0 :this.zipCode.hashCode()));
        result = ((result* 31)+((this.country == null)? 0 :this.country.hashCode()));
        result = ((result* 31)+((this.address3 == null)? 0 :this.address3 .hashCode()));
        result = ((result* 31)+((this.crossStreets == null)? 0 :this.crossStreets.hashCode()));
        result = ((result* 31)+((this.address2 == null)? 0 :this.address2 .hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.address1 == null)? 0 :this.address1 .hashCode()));
        result = ((result* 31)+((this.displayAddress == null)? 0 :this.displayAddress.hashCode()));
        result = ((result* 31)+((this.state == null)? 0 :this.state.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Location) == false) {
            return false;
        }
        Location rhs = ((Location) other);
        return ((((((((((this.zipCode == rhs.zipCode)||((this.zipCode!= null)&&this.zipCode.equals(rhs.zipCode)))&&((this.country == rhs.country)||((this.country!= null)&&this.country.equals(rhs.country))))&&((this.address3 == rhs.address3)||((this.address3 != null)&&this.address3 .equals(rhs.address3))))&&((this.crossStreets == rhs.crossStreets)||((this.crossStreets!= null)&&this.crossStreets.equals(rhs.crossStreets))))&&((this.address2 == rhs.address2)||((this.address2 != null)&&this.address2 .equals(rhs.address2))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.address1 == rhs.address1)||((this.address1 != null)&&this.address1 .equals(rhs.address1))))&&((this.displayAddress == rhs.displayAddress)||((this.displayAddress!= null)&&this.displayAddress.equals(rhs.displayAddress))))&&((this.state == rhs.state)||((this.state!= null)&&this.state.equals(rhs.state))));
    }

}
