package LangDetector;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

public class LangDetector {

    private final String PROFILE_DIRECTORY = "profiles";
    private static LangDetector instance;
    private static String langDetectionResult;



    public LangDetector() throws LangDetectException{
            DetectorFactory.loadProfile(PROFILE_DIRECTORY);
    }

    public static LangDetector getInstance() throws LangDetectException {
        if (instance == null){
            instance = new LangDetector();
        }
        return instance;
    }

    public void detect(String text) throws LangDetectException {
        Detector detector = DetectorFactory.create();
        detector.append(text);
        setLangDetectionResult(detector.detect());
    }

    public String getLangDetectionResult() {
        return langDetectionResult;
    }

    public void setLangDetectionResult(String langDetectionResult) {
        this.langDetectionResult = langDetectionResult;
    }

}
