import testClasses.Document;
import testClasses.FieldSet;
import testClasses.Report;

public class Main {
    public static void main(String[] args) {
        Document doc1 = new Document("Year results", "Manager", 12, false);
        Document doc2 = new Document();
        Report doc3 = new Report();
        Report doc4 = new Report("testClasses.Report balance 2016", "Assistant", 10, false, "Economics", "result", doc3);

        BeanUtils.assign(doc2, doc1);

        System.out.println("====================================");
        System.out.println(doc1.getTitle() + " - " + doc2.getTitle());
        System.out.println(doc1.getAuthor() + " - " + doc2.getAuthor());
        System.out.println(doc1.getCreateDate().getTime() + " - " + doc2.getCreateDate().getTime());
        System.out.println(doc1.getIdentifier() + " - " + doc2.getIdentifier());
        System.out.println(doc1.isShared() + " - " + doc2.isShared());

        BeanUtils.assign(doc3, doc2);

        System.out.println("====================================");
        System.out.println(doc2.getTitle() + " - " + doc3.getTitle());
        System.out.println(doc2.getAuthor() + " - " + doc3.getAuthor());
        System.out.println(doc2.getCreateDate().getTime() + " - " + doc3.getCreateDate().getTime());
        System.out.println(doc2.getIdentifier() + " - " + doc3.getIdentifier());
        System.out.println(doc2.isShared() + " - " + doc3.isShared());

        FieldSet doc5 = new FieldSet();

        BeanUtils.assign(doc5, doc4);

        System.out.println("====================================");
        System.out.println(doc4.getTitle() + " - " + doc5.getTitle());
        System.out.println(doc4.getAuthor() + " - " + doc5.getAuthor());
        System.out.println(doc4.getIdentifier() + " - " + doc5.getIdentificator());
        System.out.println(doc4.getIncluded().getAuthor() + " - " + doc5.getInclude().getAuthor());
    }
}
