package Analizer;

public class RussianAnalizer extends UniqueWordsAnalizer {

    private static RussianAnalizer instance;

    private RussianAnalizer() {
    }

    @Override
    public void parse(String rawString) {

        String[] parsedString = rawString.replaceAll("[^а-яА-Я ]", "")
                .toUpperCase()
                .split("\\s+");
        setParsedString(parsedString);
    }

    public static RussianAnalizer getInstance() {
        if (instance == null){
            instance = new RussianAnalizer();
        }
        return instance;
    }

}
