package Analizer;

public class EnglishAnalizer extends UniqueWordsAnalizer {

    private static EnglishAnalizer instance;

    @Override
    public void parse(String rawString) {

        String[] parsedString = rawString.toUpperCase()
                .replaceAll("[^a-zA-Z ]", "")
                .split("\\s+");
        setParsedString(parsedString);
    }

    public static EnglishAnalizer getInstance() {
        if (instance == null){
            instance = new EnglishAnalizer();
        }
        return instance;
    }
}

