import java.util.ArrayList;

public class Lines {
ArrayList<String> lines = new ArrayList<>();
    Lines(String line){}

    public Lines(ArrayList<String> lines) {
        this.lines = lines;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}
