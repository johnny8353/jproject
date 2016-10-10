package com.johnny.ui.xml.digester;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String        title;
    private String        author;
    private List<Chapter> chapters = new ArrayList<Chapter>();

    /**
     * 这个方法，用来演示xml的解析时用的另一种方式
     * @param title
     * @param author
     */
    public void setBookInfo(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}