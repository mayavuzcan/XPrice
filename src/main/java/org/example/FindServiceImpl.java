package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.util.Objects;

public class FindServiceImpl{

    public void findMinPrice(Elements blogs, Document document){

        double minPrice = 0.0;
        String minLink = null;
        String minImage = null;


        for (Element blog : blogs) {

            if (blog.select("li").attr("data-mk").equals("Apple")
                    && blog.select("a").attr("title").equals("Macbook Air M2")) {
                Elements blogsPriceSection = blog.getElementsByClass("pt_v8");

                for (Element priceSection : blogsPriceSection) {

                        if (minPrice == 0.0) {
                            minPrice = Double.parseDouble(String.valueOf(priceSection.childNodes().get(0)));
                            minLink = blog.select("a").attr("href");
                            minImage = Objects.requireNonNull(blog.selectFirst("img")).attr("src");
                        }

                        if (minPrice > Double.parseDouble(String.valueOf(priceSection.childNodes().get(0)))) {
                            minPrice = Double.parseDouble(String.valueOf(priceSection.childNodes().get(0)));
                            minLink = blog.select("a").attr("href");
                            minImage = Objects.requireNonNull(priceSection.selectFirst("img")).attr("src");
                        }

                }
            }
        }
        System.out.println("En Ucuz Macbook Air M2 Linki : " + minLink);
        System.out.println("En Ucuz Macbook Air M2 Görüntü : " + minImage);
        System.out.println("En Ucuz Macbook Air M2 Fiyatı : " + minPrice);
    }




}
