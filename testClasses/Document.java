package testClasses;

import java.util.Calendar;

public class Document {
    private Calendar createDate;
    private String title;
    private String author;
    private Integer identifier;
    private boolean isShared;

    public Document(String title, String author, int identifier, boolean isShared) {
        this.createDate = Calendar.getInstance();
        this.title = title;
        this.author = author;
        this.identifier = identifier;
        this.isShared = isShared;
    }

    public Document() {
        this.createDate = Calendar.getInstance();
        this.title = "Empty";
        this.author ="Anonymous";
        this.identifier = 0;
        this.isShared = true;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    private void setShared(boolean shared) {
        isShared = shared;
    }
}
