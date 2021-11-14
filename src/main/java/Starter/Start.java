package Starter;


import org.apache.log4j.Logger;

import java.util.Scanner;


public class Start implements ParsingInitiator,LangInitiator,URLInitiator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(Start.class);
    private static String url;
    private static String lang;
    private static String tmpString;
    private static boolean isStarted = true;


    public static void start() {
        LOGGER.info("Начало работы");
        while (isStarted) {
            URLInitiator.getInput();
            LangInitiator.initiateLang();
            ParsingInitiator.initiateParsing();
            setIsStarted(false);
            close(getIsStarted());
        }
    }

    public static void close(Boolean isStarted) {
        if (!isStarted) {
            System.out.println();
            System.out.println("Введите N для выхода, эникей что бы продолжить");
            String answer = scanner.nextLine();
            System.out.println();
            if (answer != null && answer.equalsIgnoreCase("N")){
                setIsStarted(false);
                LOGGER.info("Завершение работы");
            }
            else {
                setIsStarted(true);
                start();
            }
        }
    }


    public static String getUrl() {
        return url;
    }

    public static String getLang() {
        return lang;
    }

    static void setUrl(String url) {
        Start.url = url;
    }

    static void setLang(String lang) {
        Start.lang = lang;
    }

    static boolean getIsStarted() {
        return isStarted;
    }

    static void setIsStarted(boolean isStarted) {
        Start.isStarted = isStarted;
    }

    static void setTmpString(String tmpString) {
        Start.tmpString = tmpString;
    }

    static String getTmpString() {
        return tmpString;
    }

}
