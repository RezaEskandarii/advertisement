package com.tutorialpro.tutorialpro.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Date;

@Entity
@Table(name = "houses_ads")
public class HouseAd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "house_type")
    private String houseType;

    private String neighbourhood;

    private float price;

    @Column(name = "city_name")
    private String cityName;


    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "year_of_construction")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date yearOfConstruction;

    private String purpose;

    private float area;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    @CreatedBy
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Date getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Date yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "HouseAd{" +
                "id=" + id +
                ", houseType='" + houseType + '\'' +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", price=" + price +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", yearOfConstruction=" + yearOfConstruction +
                ", purpose='" + purpose + '\'' +
                ", area=" + area +
                ", imagePath='" + imagePath + '\'' +
                ", user=" + user +
                '}';
    }
}
