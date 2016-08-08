import java.util.Calendar;

class Document {
    private Calendar createDate;
    private String title;
    private String author;
    private Integer identifier;
    private boolean isShared;

    Document(String title, String author, int identifier, boolean isShared) {
        this.createDate = Calendar.getInstance();
        this.title = title;
        this.author = author;
        this.identifier = identifier;
        this.isShared = isShared;
    }

    Document() {
        this.createDate = Calendar.getInstance();
        this.title = "Empty";
        this.author ="Anonymous";
        this.identifier = 0;
        this.isShared = true;
    }

    Calendar getCreateDate() {
        return createDate;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    Integer getIdentifier() {
        return identifier;
    }

    boolean isShared() {
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
