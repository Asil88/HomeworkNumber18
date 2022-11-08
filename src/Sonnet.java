import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sonnet {
    @XmlAttribute
    private String type;
    @XmlElement(name = "author")
    Author authors;
    @XmlElementWrapper(name = "lines")
    @XmlElement(name="line")
    List<String> lines;

    public Sonnet() {
    }

    public Sonnet(String type, String author, Author authors) {
        this.type = type;
        this.authors = authors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Sonnet{" +
                "type='" + type + '\'' +
                ", authors=" + authors +
                ", lines=" + lines +
                '}';
    }
}


