package jmu.yaw.library.po;


public class BorrowRecord {

  private int brId;
  private String uId;
  private int bId;
  private String borrowTime;
  private String returnTime;
  private double finePrice;
  private String recordStatus;
  private BorrowLimit borrowLimit;
  private Book book;
  private User user;

  public int getBrId() {
    return brId;
  }

  public void setBrId(int brId) {
    this.brId = brId;
  }

  public String getuId() {
    return uId;
  }

  public void setuId(String uId) {
    this.uId = uId;
  }

  public int getbId() {
    return bId;
  }

  public void setbId(int bId) {
    this.bId = bId;
  }

  public String getBorrowTime() {
    return borrowTime;
  }

  public void setBorrowTime(String borrowTime) {
    this.borrowTime = borrowTime;
  }

  public String getReturnTime() {
    return returnTime;
  }

  public void setReturnTime(String returnTime) {
    this.returnTime = returnTime;
  }

  public double getFinePrice() {
    return finePrice;
  }

  public void setFinePrice(double finePrice) {
    this.finePrice = finePrice;
  }

  public String getRecordStatus() {
    return recordStatus;
  }

  public void setRecordStatus(String recordStatus) {
    this.recordStatus = recordStatus;
  }

  public BorrowLimit getBorrowLimit() {
    return borrowLimit;
  }

  public void setBorrowLimit(BorrowLimit borrowLimit) {
    this.borrowLimit = borrowLimit;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
