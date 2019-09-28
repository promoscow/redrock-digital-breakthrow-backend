package ru.xpendence.auth.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.xpendence.auth.dto.CoursesDto;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class CoursesService {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    public Set<CoursesDto> getListUrl(String url, String query) throws IOException {
        Set<CoursesDto> setUrls = new HashSet<>();
        String resultUrl = url + "search?query=" + query + "&";
        Document doc = Jsoup.connect(resultUrl).userAgent(USER_AGENT).referrer(REFERRER).get();
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String linkUrl = link.attr("href");
            if (linkUrl.contains(query) && !linkUrl.contains("?")) {
                String shortUrl = linkUrl.replaceFirst("/", "");
                int index = shortUrl.indexOf("/");
                int length = shortUrl.length();
                String name = shortUrl.substring(index + 1, length);
                setUrls.add(new CoursesDto(processingString(name), url + shortUrl));
            }
        }
        return setUrls;
    }


    public static String decapitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String processingString(String sourse) {
        String result = sourse.replaceAll("-", " ");
        String[] array = result.split(" ");
        List<String> preList = Arrays.asList(array);
        List<String> resultList = new ArrayList<>();
        for (String s : preList) {
            resultList.add(decapitalize(s));
        }
        return resultList.stream().collect(Collectors.joining(" "));
    }
}
