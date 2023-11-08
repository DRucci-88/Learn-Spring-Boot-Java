package com.lerucco.thymeleafdemo.model;

public class Student {
    public Student() {

    }

    private String firstName;
    private String lastName;
    private Integer countryId;
    private Integer cityId;
    private Integer programmingLanguageId;

    public Integer getProgrammingLanguageId() {
        return programmingLanguageId;
    }

    public void setProgrammingLanguageId(Integer programmingLanguageId) {
        this.programmingLanguageId = programmingLanguageId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", countryId=" + countryId + ", cityId="
                + cityId + ", programmingLanguageId=" + programmingLanguageId + "]";
    }

}
