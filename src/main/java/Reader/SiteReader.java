package Reader;

import Starter.Start;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class SiteReader {


    private static final Logger LOGGER = Logger.getLogger(SiteReader.class);
    private static SiteReader instance;
    private String curUrl;
    private String defAgent = "Chrome/95.0.4638.69";
    private String defReferrer = "http://www.google.com";
    private String userAgent;
    private String userReferrer;
    private Document document;
    private String tmp;


    public void read() {
        try {
            document = Jsoup.connect(curUrl)
                    .userAgent(defAgent)
                    .referrer(defReferrer)
                    .get();
            tmp = document.text();
            LOGGER.info("Текст с сайта " + curUrl +  " прочитан");
        } catch (IOException e) {
            LOGGER.warn("Ошибка входящего потока, перезапуск " + e);
            System.out.println("Ошибка входящего потока, перезапуск");
            System.out.println();
            Start.start();
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Некорректный формат адреса, перезапуск " + e);
            System.out.println("Некорректный формат адреса, перезапуск");
            System.out.println();
            Start.start();
        }
    }

    public static SiteReader getInstance() {
        if (instance == null){
            instance = new SiteReader();
        }
        return instance;
    }

    private SiteReader() {}

    public void setCurUrl(String curUrl) {
        this.curUrl = curUrl;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setUserReferrer(String userReferrer) {
        this.userReferrer = userReferrer;
    }

    public String getTmp() {
        return tmp;
    }
}
