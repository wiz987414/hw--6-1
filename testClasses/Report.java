package testClasses;

public class Report extends Document {
    private String reportTheme;
    private String reportResult;
    private Document included;

    public Report(String title, String author, int identifier, boolean isShared, String reportTheme, String reportResult, Document included) {
        super(title, author, identifier, isShared);
        this.reportTheme = reportTheme;
        this.reportResult = reportResult;
        this.included = included;
    }

    public Report() {
        super();
        this.reportTheme = "empty";
        this.reportResult = "none";
        this.included = null;
    }

    public Document getIncluded() {
        if (this.included != null)
            return included;
        return null;
    }

    public void setIncluded(Document included) {
        this.included = included;
    }

    public String getReportTheme() {
        return reportTheme;
    }

    public String getReportResult() {
        return reportResult;
    }

    public void setReportTheme(String reportTheme) {
        this.reportTheme = reportTheme;
    }

    public void setReportResult(String reportResult) {
        this.reportResult = reportResult;
    }


}
