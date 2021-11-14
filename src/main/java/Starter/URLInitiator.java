package Starter;

import Reader.SiteReader;
import org.apache.log4j.Logger;

import java.util.Scanner;

interface URLInitiator {

    Scanner scanner = new Scanner(System.in);
    Logger LOGGER = Logger.getLogger(Start.class);

    static void getInput() {
        System.out.println("Вставьте URL адрес");
        Start.setUrl(scanner.nextLine());
        initiateUrl();
    }

     static void initiateUrl() throws IllegalArgumentException {
        if (Start.getUrl() == " " || Start.getUrl() == "" || Start.getUrl() == null) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Пустой URL адрес");
                System.out.println();
                LOGGER.error("Ошибка! Пустой URL адрес " + e);
                getInput();
            }
        }
        SiteReader.getInstance().setCurUrl(Start.getUrl());
        LOGGER.info("Инициализация URL адреса, текущий URL адрес: " + Start.getUrl());
    }
}
