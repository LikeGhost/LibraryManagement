package jmu.yaw.library.po;


public class BorrowLimit {

  private int btId;
  private int rId;
  private int borrowNum;
  private int borrowDay;
  private int canBorrow;
  private int canBorrowDay;


  public int getBtId() {
    return btId;
  }

  public void setBtId(int btId) {
    this.btId = btId;
  }

  public int getrId() {
    return rId;
  }

  public void setrId(int rId) {
    this.rId = rId;
  }

  public int getBorrowNum() {
    return borrowNum;
  }

  public void setBorrowNum(int borrowNum) {
    this.borrowNum = borrowNum;
  }

  public int getBorrowDay() {
    return borrowDay;
  }

  public void setBorrowDay(int borrowDay) {
    this.borrowDay = borrowDay;
  }

  public int getCanBorrow() {
    return canBorrow;
  }

  public void setCanBorrow(int canBorrow) {
    this.canBorrow = canBorrow;
  }

  public int getCanBorrowDay() {
    return canBorrowDay;
  }

  public void setCanBorrowDay(int canBorrowDay) {
    this.canBorrowDay = canBorrowDay;
  }
}
