package ru.xpendence.auth.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@Service
public class CoursesService {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    public Set<String> getListUrl(String url, String query) throws IOException {
        Set<String> setUrls = new HashSet<>();
        String resultUrl = url + "search?query=" + query + "&";
        Document doc = Jsoup.connect(resultUrl).userAgent(USER_AGENT).referrer(REFERRER).get();
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String linkUrl = link.attr("href");
            if (linkUrl.contains(query) && !linkUrl.contains("?")) {
                setUrls.add(url + linkUrl);
            }
        }
        return setUrls;
    }
}
