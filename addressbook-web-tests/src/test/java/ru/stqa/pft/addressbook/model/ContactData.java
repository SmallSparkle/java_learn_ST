package ru.stqa.pft.addressbook.model;

public class ContactData {
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
  private final String addGroup;
  private final String notesText;

  public ContactData(String name, String middlename, String lastname, String address, String homePhone, String mobilePhone, String ferstEmail, String thirdEmail, String bday, String bmonth, String byear, String addGroup, String notesText) {
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
    this.addGroup = addGroup;
    this.notesText = notesText;
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

  public String getAddGroup() {
    return addGroup;
  }

  public String getNotesText() {
    return notesText;
  }
}
