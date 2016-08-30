package com.project.sepon.informationproject;

/**
 * Created by SEPOn on 8/30/2016.
 */
public class Personinformation {

    public String personName;
    public String fatherName;
    public String ocupation;
    public String education;
    public String location;

    public Personinformation(String personName, String fatherName, String ocupation, String education, String location, String mobile, String email) {
        this.personName = personName;
        this.fatherName = fatherName;
        this.ocupation = ocupation;
        this.education = education;
        this.location = location;
        this.mobile = mobile;
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String mobile;
    public String email;
}
