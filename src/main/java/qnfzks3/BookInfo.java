package qnfzks3;

import java.util.StringJoiner;

public class BookInfo {
    private String ISBN;
    private String bookname;
    private int price;
    private String writer;
    private String explain;
    private String field;
    private String publish;

    public BookInfo() {
    }

    public BookInfo(String ISBN, String bookname, int price, String writer, String explain, String publish,String field) {
        this.ISBN = ISBN;
        this.bookname = bookname;
        this.price = price;
        this.writer = writer;
        this.explain = explain;
        this.field=field;
        this.publish = publish;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookname() {
        return bookname;
    }

    public int getPrice() {
        return price;
    }

    public String getWriter() {
        return writer;
    }

    public String getExplain() {
        return explain;
    }
    public String getfield() {
        return ISBN;
    }

    public String getPublish() {
        return publish;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
    public void setField(String field) {
        this.field =field ;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        String fmt="도서넘버:%s , 도서명:%s , 가격:%d , 저자:%s \n도서설명:%s , 도서 분야:%s , 출간일:%S ";
        return String.format(fmt,ISBN,bookname,price,writer,explain,field,publish);
    }
}

