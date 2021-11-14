package Analizer;

public class GreekAnalizer extends UniqueWordsAnalizer {

    private static GreekAnalizer instance;

    private GreekAnalizer() {
    }

    @Override
    public void parse(String rawString) {

        String[] parsedString = rawString.replaceAll("^[^\\u1F00 through \\u1FFF]+$", "")
                .toUpperCase()
                .split("\\s+");
        setParsedString(parsedString);
    }

    public static GreekAnalizer getInstance() {
        if (instance == null){
            instance = new GreekAnalizer();
        }
        return instance;
    }

}
