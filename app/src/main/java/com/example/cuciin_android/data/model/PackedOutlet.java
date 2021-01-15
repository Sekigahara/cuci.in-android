package com.example.cuciin_android.data.model;

import java.io.Serializable;

public class PackedOutlet implements Serializable {
    private Double distance;
    private String name;
    private Float rating;
    private Boolean isOpen;
    private Double lat;
    private Double lng;
    private String photo;
    private String idGoogle;
    private String id;

    public void setLat(Double lat){
        this.lat = lat;
    }

    public Double getLat(){
        return lat;
    }

    public void setLng(Double lng){
        this.lng = lng;
    }

    public Double getLng(){
        return lng;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(String idGoogle) {
        this.idGoogle = idGoogle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
