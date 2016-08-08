import java.util.Calendar;

class FieldSet {
    private Calendar date;
    private String title;
    private String author;
    private Number identificator;
    private boolean shareStatus;
    private String theme;
    private String rezult;
    private Document include;

    public FieldSet(String title, String author, Number identificator, boolean shareStatus, String theme, String rezult, Document include) {
        this.date = Calendar.getInstance();
        this.title = title;
        this.author = author;
        this.identificator = identificator;
        this.shareStatus = shareStatus;
        this.theme = theme;
        this.rezult = rezult;
        this.include = include;
    }

    FieldSet() {
        this.title = "";
        this.author = "";
        this.identificator = 0;
        this.shareStatus = true;
        this.theme = "";
        this.rezult = "";
        this.include = null;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
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

    public Number getIdentificator() {
        return identificator;
    }

    public void setIdentificator(Number identificator) {
        this.identificator = identificator;
    }

    public boolean isShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(boolean shareStatus) {
        this.shareStatus = shareStatus;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getRezult() {
        return rezult;
    }

    public void setRezult(String rezult) {
        this.rezult = rezult;
    }

    public Document getInclude() {
        if (this.include != null)
            return include;
        return null;
    }

    public void setInclude(Document include) {
        this.include = include;
    }
}
