import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FresnoCityCollegeScraper {
    public static void main(String[] args) {
        String url = "https://www.fresnocitycollege.edu";

        try {
            // Connect to the website and get the HTML document
            Document document = Jsoup.connect(url).get();

            // Get the title of the webpage
            String title = document.title();
            System.out.println("Title: " + title);

            // Get all the links on the homepage
            Elements links = document.select("a[href]");

            System.out.println("Links on the homepage:");
            for (Element link : links) {
                String linkText = link.text();
                String linkHref = link.attr("href");
                System.out.println(linkText + " -> " + linkHref);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}