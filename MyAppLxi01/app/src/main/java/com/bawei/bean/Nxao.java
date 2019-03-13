package com.bawei.bean;

/**
 * @Author：DELL
 * @E-mail： 463211790@qq.com
 * @Date：2019/2/28 16:50
 * @Description：描述信息
 */
public class Nxao {

    private String book_cover;
    private String author_name;
    private String bookname;
    private String chapterid;
    private String bid;
    private String class_name;
    private String date_updated;

    @Override
    public String toString() {
        return "Nxao{" +
                "book_cover='" + book_cover + '\'' +
                ", author_name='" + author_name + '\'' +
                ", bookname='" + bookname + '\'' +
                ", chapterid='" + chapterid + '\'' +
                ", bid='" + bid + '\'' +
                ", class_name='" + class_name + '\'' +
                ", date_updated='" + date_updated + '\'' +
                '}';
    }

    public String getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public Nxao(String book_cover, String author_name, String bookname, String chapterid, String bid, String class_name, String date_updated) {
        this.book_cover = book_cover;
        this.author_name = author_name;
        this.bookname = bookname;
        this.chapterid = chapterid;
        this.bid = bid;
        this.class_name = class_name;
        this.date_updated = date_updated;
    }

    public Nxao() {
    }
}
