package com.app.apitest.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PanDetails {

    @SerializedName("status")
    @Expose
    String status;

    @SerializedName("panHolderName")
    @Expose
    String panHolderName;

    @SerializedName("dateOfBirth")
    @Expose
    String dateOfBirth;

    @SerializedName("gender")
    @Expose
    String gender;

    @SerializedName("residence")
    @Expose
    String residence;

    @SerializedName("occupation")
    @Expose
    String occupation;

    @SerializedName("address")
    @Expose
    String address;

    @SerializedName("pincode")
    @Expose
    String pincode;

    public PanDetails(String status, String panHolderName, String dateOfBirth, String gender, String residence,
                      String occupation, String address, String pincode) {
        this.status = status;
        this.panHolderName = panHolderName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.residence = residence;
        this.occupation = occupation;
        this.address = address;
        this.pincode = pincode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPanHolderName() {
        return panHolderName;
    }

    public void setPanHolderName(String panHolderName) {
        this.panHolderName = panHolderName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
