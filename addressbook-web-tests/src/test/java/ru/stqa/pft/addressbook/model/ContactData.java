package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import org.hibernate.annotations.Type;
import ru.stqa.pft.addressbook.generators.FileJsonAdapter;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {

  @Id
  @Column(name = "id")
  private int id;

  @Expose
  @Column(name = "firstname")
  private String name;

  @Expose
  @Transient
  private String middlename;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Column(name = "phone2")
  @Type(type = "text")
  private String secondHomePhone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String ferstEmail;

  @Column(name = "email2")
  @Type(type = "text")
  private String secondEmail;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String thirdEmail;

  @Expose
  @Transient
  private String bday;

  @Expose
  @Transient
  private String bmonth;

  @Expose
  @Transient
  private String byear;

  @Expose
  @Column(name = "notes")
  @Type(type = "text")
  private String notesText;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;


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
    return new File(photo);
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
    this.photo = photo.getPath();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address) && Objects.equals(homePhone, that.homePhone) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(secondHomePhone, that.secondHomePhone) && Objects.equals(ferstEmail, that.ferstEmail) && Objects.equals(secondEmail, that.secondEmail) && Objects.equals(thirdEmail, that.thirdEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname, address, homePhone, mobilePhone, workPhone, secondHomePhone, ferstEmail, secondEmail, thirdEmail);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", secondHomePhone='" + secondHomePhone + '\'' +
            ", ferstEmail='" + ferstEmail + '\'' +
            ", secondEmail='" + secondEmail + '\'' +
            ", thirdEmail='" + thirdEmail + '\'' +
            '}';
  }

}

