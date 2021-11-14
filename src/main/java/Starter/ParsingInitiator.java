package Starter;

import Analizer.EnglishAnalizer;
import Analizer.GreekAnalizer;
import Analizer.RussianAnalizer;
import LangDetector.SupportedLanguages;
import Reader.SiteReader;
import org.apache.log4j.Logger;

public interface ParsingInitiator {

    Logger LOGGER = Logger.getLogger(Start.class);

    static void initiateParsing() {
        LOGGER.info("Старт парсинга и подсчета статистики уникальных слов");
        if (Start.getLang().equals(SupportedLanguages.RUSSIAN.getValue())) {
            RussianAnalizer r = RussianAnalizer.getInstance();
            r.setRawString(SiteReader.getInstance().getTmp());
            r.startCounting();
        }
        else if (Start.getLang().equals(SupportedLanguages.ENGLISH.getValue())) {
            EnglishAnalizer e = EnglishAnalizer.getInstance();
            e.setRawString(SiteReader.getInstance().getTmp());
            e.startCounting();
        }
        else if (Start.getLang().equals(SupportedLanguages.GREEK.getValue())) {
            GreekAnalizer g = GreekAnalizer.getInstance();
            g.setRawString(SiteReader.getInstance().getTmp());
            g.startCounting();
        }
        else {
            System.out.println("Язык пока не поддерживается! Введите данные повторно.");
            System.out.println();
            LOGGER.warn("Язык пока не поддерживается,перезапуск");
            Start.start();
        }
    }
}
