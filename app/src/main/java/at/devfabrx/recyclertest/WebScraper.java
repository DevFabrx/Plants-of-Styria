package at.devfabrx.recyclertest;

import android.provider.DocumentsContract;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Surface Book on 20.09.2017.
 */

public class WebScraper {
    private final static String BASE_URL = "http://plants-of-styria.uni-graz.at/plants-of-styria-list.html";


    public WebScraper(){

    }

    public Document getHtmlDocument(){
        try {
            Document doc = Jsoup.connect(BASE_URL).get();
            return doc;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getPlantList(){
        ArrayList<String> plantNames = new ArrayList<String>();
        Document doc = getHtmlDocument();
        Elements link = doc.select("a");
        String linkText = link.text();
        int counter = 0;
        for (Element text:link) {
            plantNames.add(text.text());
            counter++;
        }
        return plantNames;
    }

}
