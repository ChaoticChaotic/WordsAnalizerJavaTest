package Analizer;


import Starter.Start;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;


public abstract class UniqueWordsAnalizer {

    private static final Logger LOGGER = Logger.getLogger(Start.class);
    private String rawString;
    private String[] parsedString;
    private LinkedHashMap<String,Integer> sortedString;

    abstract void parse(String rawString);

    public void sorting(String[] parsedString){
            LinkedHashMap<String,Integer> sortedString;
            HashMap<String, Integer> tmpMap = new LinkedHashMap<>();
            for (String t : parsedString) {
                if (tmpMap.containsKey(t)) {
                    tmpMap.put(t, tmpMap.get(t) + 1);
                } else {
                    tmpMap.put(t, 1);
                }
            }
            sortedString = tmpMap.entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2) -> e2,LinkedHashMap::new)
                    );
            setSortedString(sortedString);
            LOGGER.info("Подсчет уникальных слов для сайта " + Start.getUrl() + " окончен");
    }

    public void print(LinkedHashMap<String,Integer> sortedString) {
        LOGGER.info("Начат вывод статистики в консоль");
        for (String s: sortedString.keySet()) {
            if (s.length() >= 3 && sortedString.get(s) > 2) {
                System.out.println();
                System.out.printf("Уникальное слово %s ",s);
                System.out.printf("повторилось в тексте % d раз", sortedString.get(s));
            }
        }
        System.out.println();
        LOGGER.info("Вывод завершен");
    }

    public void startCounting() {
        parse(getRawString());
        sorting(getParsedString());
        print(getSortedString());
    }


    public String getRawString() { return rawString; }

    public void setRawString(String rawString) {
        this.rawString = rawString;
    }

    public String[] getParsedString() {
        return parsedString;
    }

    public void setParsedString(String[] parsedString) {
        this.parsedString = parsedString;
    }

    public LinkedHashMap<String,Integer> getSortedString() {
        return sortedString;
    }

    public void setSortedString(LinkedHashMap<String,Integer> sortedString) {
        this.sortedString = sortedString;
    }

}
