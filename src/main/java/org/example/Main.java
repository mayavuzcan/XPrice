package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FindServiceImpl find = new FindServiceImpl();

        try {
            String url = "https://www.xprice.com/pc";
            Document document = Jsoup.connect(url)
                    .timeout(5000)
                    .get();
            Elements blogs = document.getElementsByAttribute("data-mk");
            find.findMinPrice(blogs,document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}