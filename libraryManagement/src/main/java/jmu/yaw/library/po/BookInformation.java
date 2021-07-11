package jmu.yaw.library.po;


import java.util.List;

public class BookInformation {

    private String isbn;
    private String clcId;
    private int btId;
    private int quantity;
    private String bookName;
    private String author;
    private String publishArea;
    private String publishHouse;
    private String publishTime;
    private int wordCount;
    private double price;
    private String biIntroduction;
    private String biPutTime;
    private String realBtId;
    private List<Book> books;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getClcId() {
        return clcId;
    }

    public void setClcId(String clcId) {
        this.clcId = clcId;
    }

    public int getBtId() {
        return btId;
    }

    public void setBtId(int btId) {
        this.btId = btId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishArea() {
        return publishArea;
    }

    public void setPublishArea(String publishArea) {
        this.publishArea = publishArea;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBiIntroduction() {
        return biIntroduction;
    }

    public void setBiIntroduction(String biIntroduction) {
        this.biIntroduction = biIntroduction;
    }

    public String getBiPutTime() {
        return biPutTime;
    }

    public void setBiPutTime(String biPutTime) {
        this.biPutTime = biPutTime;
    }

    public String getRealBtId() {
        return realBtId;
    }

    public void setRealBtId(String realBtId) {
        this.realBtId = realBtId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
