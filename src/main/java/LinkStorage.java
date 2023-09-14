import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkStorage {
    public List<ParsedLink> links;
    public LinkStorage() {
        links = new ArrayList<>();
    }
    public List<ParsedLink> getLinks() {
        return links;
    }
    public void resetLinks(){
        links.clear();
    }
    public void addLinks(String path) throws IOException {
        int lj = 0;
        resetLinks();
        Document doc = Jsoup.connect(path).get();
        Elements links = doc.select("a");
        for (Element link : links) {
            String href = link.attr("href");
            String text = link.text();
            lj++;
            newLink(lj, href, text);
        }
    }
    private void newLink(int lj, String href, String text) {
        links.add(new ParsedLink(lj, href, text));
    }
}