package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String name;
  private final String middlename;
  private final String lastname;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String ferstEmail;
  private final String thirdEmail;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String notesText;

  public ContactData(String name, String middlename, String lastname, String address, String homePhone, String mobilePhone, String ferstEmail, String thirdEmail, String bday, String bmonth, String byear, String notesText) {
    this.id = null;
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.ferstEmail = ferstEmail;
    this.thirdEmail = thirdEmail;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.notesText = notesText;
  }
  public ContactData(String id, String name, String middlename, String lastname, String address, String homePhone, String mobilePhone, String ferstEmail, String thirdEmail, String bday, String bmonth, String byear, String notesText) {
    this.id = id;
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.ferstEmail = ferstEmail;
    this.thirdEmail = thirdEmail;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.notesText = notesText;
  }

  public ContactData(String id, String name, String lastname) {
    this.id = id;
    this.name = name;
    this.middlename = null;
    this.lastname = lastname;
    this.address = null;
    this.homePhone = null;
    this.mobilePhone = null;
    this.ferstEmail = null;
    this.thirdEmail = null;
    this.bday = null;
    this.bmonth = null;
    this.byear = null;
    this.notesText = null;
  }

//  public ContactData(String mobilePhone, String address) {
//    this.mobilePhone = mobilePhone;
//    this.address = address;
//  }

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
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public String getId() {
    return id;
  }
}
