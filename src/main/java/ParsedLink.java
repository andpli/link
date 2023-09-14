
public class ParsedLink {
    private final int num;
    private final String link;
    private final String text;
    public ParsedLink(int num, String link, String text) {
        this.num = num;
        this.link = link;
        this.text = text;
    }
    public int getNum() {
        return num;
    }

    public String getLink() {
        return link;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "(" + this.num + "-" + this.link + "-" + this.text + ")";
    }
}
