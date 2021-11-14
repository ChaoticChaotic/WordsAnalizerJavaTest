package Starter;

import LangDetector.LangDetector;
import Reader.SiteReader;
import com.cybozu.labs.langdetect.LangDetectException;
import org.apache.log4j.Logger;

interface LangInitiator {

    Logger LOGGER = Logger.getLogger(Start.class);

    static void initiateLang() {
        SiteReader reader = SiteReader.getInstance();
        reader.read();
        Start.setTmpString(reader.getTmp());
        try {
            LangDetector l = LangDetector.getInstance();
            l.detect(Start.getTmpString());
            Start.setLang(l.getLangDetectionResult());
        } catch (LangDetectException e) {
            LOGGER.error("Ошибка! Ошибка при попытке определения языка " + e);
        }
        LOGGER.info("Инициализация языка, язык сайта: " + Start.getLang());
    }
}
