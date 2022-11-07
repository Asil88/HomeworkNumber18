import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sonnet {
    @XmlAttribute
    private String type;
   @XmlElement

    private String author;
    private String line;

    List<Author> authors;
    @XmlElement(name = "line")
    List<Lines> lines;

    public Sonnet() {
    }

    public Sonnet(String type, String author, String line, List<Author> authors) {
        this.type = type;
        this.author = author;
        this.line = line;
        this.authors = authors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("Sonnet:%s\n%s\n%s\n", type, author, line);
    }
}


