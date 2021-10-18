
package com.moringaschool.rubisenergies.models;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Event {

    @SerializedName("attending_count")
    @Expose
    private Integer attendingCount;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("cost")
    @Expose
    private Object cost;
    @SerializedName("cost_max")
    @Expose
    private Object costMax;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("event_site_url")
    @Expose
    private String eventSiteUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("interested_count")
    @Expose
    private Integer interestedCount;
    @SerializedName("is_canceled")
    @Expose
    private Boolean isCanceled;
    @SerializedName("is_free")
    @Expose
    private Boolean isFree;
    @SerializedName("is_official")
    @Expose
    private Boolean isOfficial;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tickets_url")
    @Expose
    private String ticketsUrl;
    @SerializedName("time_end")
    @Expose
    private String timeEnd;
    @SerializedName("time_start")
    @Expose
    private String timeStart;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("business_id")
    @Expose
    private String businessId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Event() {
    }

    /**
     * 
     * @param eventSiteUrl
     * @param timeEnd
     * @param cost
     * @param isCanceled
     * @param latitude
     * @param businessId
     * @param description
     * @param costMax
     * @param isOfficial
     * @param interestedCount
     * @param ticketsUrl
     * @param timeStart
     * @param isFree
     * @param imageUrl
     * @param name
     * @param location
     * @param attendingCount
     * @param id
     * @param category
     * @param longitude
     */
    public Event(Integer attendingCount, String category, Object cost, Object costMax, String description, String eventSiteUrl, String id, String imageUrl, Integer interestedCount, Boolean isCanceled, Boolean isFree, Boolean isOfficial, Double latitude, Double longitude, String name, String ticketsUrl, String timeEnd, String timeStart, Location location, String businessId) {
        super();
        this.attendingCount = attendingCount;
        this.category = category;
        this.cost = cost;
        this.costMax = costMax;
        this.description = description;
        this.eventSiteUrl = eventSiteUrl;
        this.id = id;
        this.imageUrl = imageUrl;
        this.interestedCount = interestedCount;
        this.isCanceled = isCanceled;
        this.isFree = isFree;
        this.isOfficial = isOfficial;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.ticketsUrl = ticketsUrl;
        this.timeEnd = timeEnd;
        this.timeStart = timeStart;
        this.location = location;
        this.businessId = businessId;
    }

    public Integer getAttendingCount() {
        return attendingCount;
    }

    public void setAttendingCount(Integer attendingCount) {
        this.attendingCount = attendingCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Object getCost() {
        return cost;
    }

    public void setCost(Object cost) {
        this.cost = cost;
    }

    public Object getCostMax() {
        return costMax;
    }

    public void setCostMax(Object costMax) {
        this.costMax = costMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventSiteUrl() {
        return eventSiteUrl;
    }

    public void setEventSiteUrl(String eventSiteUrl) {
        this.eventSiteUrl = eventSiteUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getInterestedCount() {
        return interestedCount;
    }

    public void setInterestedCount(Integer interestedCount) {
        this.interestedCount = interestedCount;
    }

    public Boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Boolean getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketsUrl() {
        return ticketsUrl;
    }

    public void setTicketsUrl(String ticketsUrl) {
        this.ticketsUrl = ticketsUrl;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.eventSiteUrl == null)? 0 :this.eventSiteUrl.hashCode()));
        result = ((result* 31)+((this.timeEnd == null)? 0 :this.timeEnd.hashCode()));
        result = ((result* 31)+((this.cost == null)? 0 :this.cost.hashCode()));
        result = ((result* 31)+((this.isCanceled == null)? 0 :this.isCanceled.hashCode()));
        result = ((result* 31)+((this.latitude == null)? 0 :this.latitude.hashCode()));
        result = ((result* 31)+((this.businessId == null)? 0 :this.businessId.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.costMax == null)? 0 :this.costMax.hashCode()));
        result = ((result* 31)+((this.isOfficial == null)? 0 :this.isOfficial.hashCode()));
        result = ((result* 31)+((this.interestedCount == null)? 0 :this.interestedCount.hashCode()));
        result = ((result* 31)+((this.ticketsUrl == null)? 0 :this.ticketsUrl.hashCode()));
        result = ((result* 31)+((this.timeStart == null)? 0 :this.timeStart.hashCode()));
        result = ((result* 31)+((this.isFree == null)? 0 :this.isFree.hashCode()));
        result = ((result* 31)+((this.imageUrl == null)? 0 :this.imageUrl.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.attendingCount == null)? 0 :this.attendingCount.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.category == null)? 0 :this.category.hashCode()));
        result = ((result* 31)+((this.longitude == null)? 0 :this.longitude.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Event) == false) {
            return false;
        }
        Event rhs = ((Event) other);
        return (((((((((((((((((((((this.eventSiteUrl == rhs.eventSiteUrl)||((this.eventSiteUrl!= null)&&this.eventSiteUrl.equals(rhs.eventSiteUrl)))&&((this.timeEnd == rhs.timeEnd)||((this.timeEnd!= null)&&this.timeEnd.equals(rhs.timeEnd))))&&((this.cost == rhs.cost)||((this.cost!= null)&&this.cost.equals(rhs.cost))))&&((this.isCanceled == rhs.isCanceled)||((this.isCanceled!= null)&&this.isCanceled.equals(rhs.isCanceled))))&&((this.latitude == rhs.latitude)||((this.latitude!= null)&&this.latitude.equals(rhs.latitude))))&&((this.businessId == rhs.businessId)||((this.businessId!= null)&&this.businessId.equals(rhs.businessId))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.costMax == rhs.costMax)||((this.costMax!= null)&&this.costMax.equals(rhs.costMax))))&&((this.isOfficial == rhs.isOfficial)||((this.isOfficial!= null)&&this.isOfficial.equals(rhs.isOfficial))))&&((this.interestedCount == rhs.interestedCount)||((this.interestedCount!= null)&&this.interestedCount.equals(rhs.interestedCount))))&&((this.ticketsUrl == rhs.ticketsUrl)||((this.ticketsUrl!= null)&&this.ticketsUrl.equals(rhs.ticketsUrl))))&&((this.timeStart == rhs.timeStart)||((this.timeStart!= null)&&this.timeStart.equals(rhs.timeStart))))&&((this.isFree == rhs.isFree)||((this.isFree!= null)&&this.isFree.equals(rhs.isFree))))&&((this.imageUrl == rhs.imageUrl)||((this.imageUrl!= null)&&this.imageUrl.equals(rhs.imageUrl))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.attendingCount == rhs.attendingCount)||((this.attendingCount!= null)&&this.attendingCount.equals(rhs.attendingCount))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.category == rhs.category)||((this.category!= null)&&this.category.equals(rhs.category))))&&((this.longitude == rhs.longitude)||((this.longitude!= null)&&this.longitude.equals(rhs.longitude))));
    }

}
