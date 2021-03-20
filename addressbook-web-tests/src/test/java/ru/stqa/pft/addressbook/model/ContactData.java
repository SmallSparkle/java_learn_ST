package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id;
  @Expose
  private String name;
  @Expose
  private String middlename;
  @Expose
  private String lastname;
  @Expose
  private String address;
  @Expose
  private String homePhone;
  @Expose
  private String mobilePhone;
  private String workPhone;
  private String secondHomePhone;
  @Expose
  private String ferstEmail;
  private String secondEmail;
  @Expose
  private String thirdEmail;
  @Expose
  private String bday;
  @Expose
  private String bmonth;
  @Expose
  private String byear;
  @Expose
  private String notesText;

  private String allPhones;
  private String allEmails;
  @Expose
  private File photo;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getSecondHomePhone() {
    return secondHomePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFerstEmail() {
    return ferstEmail;
  }

  public String getSecondEmail() {
    return secondEmail;
  }

  public String getThirdEmail() {
    return thirdEmail;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getNotesText() {
    return notesText;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getallEmails() {
    return allEmails;
  }

  public File getPhoto() {
    return photo;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withSecondHomePhone(String secondHomePhone) {
    this.secondHomePhone = secondHomePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withFerstEmail(String ferstEmail) {
    this.ferstEmail = ferstEmail;
    return this;
  }

  public ContactData withSecondEmail(String secondEmail) {
    this.secondEmail = secondEmail;
    return this;
  }

  public ContactData withThirdEmail(String thirdEmail) {
    this.thirdEmail = thirdEmail;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withNotesText(String notesText) {
    this.notesText = notesText;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String withPhoto(String photoPath) {
    return photoPath;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}

