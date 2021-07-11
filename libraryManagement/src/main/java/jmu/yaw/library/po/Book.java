package jmu.yaw.library.po;


public class Book {

  private int bId;
  private String isbn;
  private int lId;
  private String bPutTime;
  private String bOutTime;
  private String borrowStatus;
  private Library library;
  private BookInformation bookInformation;
  private BorrowType borrowType;

  public int getbId() {
    return bId;
  }

  public void setbId(int bId) {
    this.bId = bId;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getlId() {
    return lId;
  }

  public void setlId(int lId) {
    this.lId = lId;
  }

  public String getbPutTime() {
    return bPutTime;
  }

  public void setbPutTime(String bPutTime) {
    this.bPutTime = bPutTime;
  }

  public String getbOutTime() {
    return bOutTime;
  }

  public void setbOutTime(String bOutTime) {
    this.bOutTime = bOutTime;
  }

  public String getBorrowStatus() {
    return borrowStatus;
  }

  public void setBorrowStatus(String borrowStatus) {
    this.borrowStatus = borrowStatus;
  }

  public Library getLibrary() {
    return library;
  }

  public void setLibrary(Library library) {
    this.library = library;
  }

  public BookInformation getBookInformation() {
    return bookInformation;
  }

  public void setBookInformation(BookInformation bookInformation) {
    this.bookInformation = bookInformation;
  }

  public BorrowType getBorrowType() {
    return borrowType;
  }

  public void setBorrowType(BorrowType borrowType) {
    this.borrowType = borrowType;
  }
}
