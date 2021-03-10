package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String name;
  private String middlename;
  private String lastname;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String ferstEmail;
  private String thirdEmail;
  private String bday;
  private String bmonth;
  private String byear;
  private String notesText;

//  public ContactData(String name, String middlename, String lastname, String address, String homePhone, String mobilePhone, String ferstEmail, String thirdEmail, String bday, String bmonth, String byear, String notesText) {
//    this.id = Integer.MAX_VALUE;
//    this.name = name;
//    this.middlename = middlename;
//    this.lastname = lastname;
//    this.address = address;
//    this.homePhone = homePhone;
//    this.mobilePhone = mobilePhone;
//    this.ferstEmail = ferstEmail;
//    this.thirdEmail = thirdEmail;
//    this.bday = bday;
//    this.bmonth = bmonth;
//    this.byear = byear;
//    this.notesText = notesText;
//  }
//
//  public ContactData(int id, String name, String middlename, String lastname, String address, String homePhone, String mobilePhone, String ferstEmail, String thirdEmail, String bday, String bmonth, String byear, String notesText) {
//    this.id = id;
//    this.name = name;
//    this.middlename = middlename;
//    this.lastname = lastname;
//    this.address = address;
//    this.homePhone = homePhone;
//    this.mobilePhone = mobilePhone;
//    this.ferstEmail = ferstEmail;
//    this.thirdEmail = thirdEmail;
//    this.bday = bday;
//    this.bmonth = bmonth;
//    this.byear = byear;
//    this.notesText = notesText;
//  }
//
//  public ContactData(int id, String name, String lastname) {
//    this.id = id;
//    this.name = name;
//    this.middlename = null;
//    this.lastname = lastname;
//    this.address = null;
//    this.homePhone = null;
//    this.mobilePhone = null;
//    this.ferstEmail = null;
//    this.thirdEmail = null;
//    this.bday = null;
//    this.bmonth = null;
//    this.byear = null;
//    this.notesText = null;
//  }

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

  public String getFerstEmail() {
    return ferstEmail;
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

  public ContactData withFerstEmail(String ferstEmail) {
    this.ferstEmail = ferstEmail;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastname);
  }

}

