package jmu.yaw.library.po;


import java.util.List;

public class Library {

  private int lId;
  private String lName;
  private String lLocation;
  private String lIntroduction;
  private List<Book> books;

  public int getlId() {
    return lId;
  }

  public void setlId(int lId) {
    this.lId = lId;
  }

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public String getlLocation() {
    return lLocation;
  }

  public void setlLocation(String lLocation) {
    this.lLocation = lLocation;
  }

  public String getlIntroduction() {
    return lIntroduction;
  }

  public void setlIntroduction(String lIntroduction) {
    this.lIntroduction = lIntroduction;
  }
}
