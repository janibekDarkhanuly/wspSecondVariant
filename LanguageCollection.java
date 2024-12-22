package system;
import java.util.Vector;
import java.util.Map;
import java.io.Serializable;
import java.util.List;

import employee.*;
import researcher.*;
import student.*;
import system.*;


public class LanguageCollection  implements Serializable{
    private Map<String, String> englishData;
    private Map<String, String> russianData;
    private Map<String, String> kazakhData;
    
    public Map<String, String> getEnglishData() {
        return this.englishData;
    }
    
    public void setEnglishData(Map<String, String> englishData) {
        this.englishData = englishData;
    }
    
    public Map<String, String> getRussianData() {
        return this.russianData;
    }
    
    public void setRussianData(Map<String, String> russianData) {
        this.russianData = russianData;
    }

    public Map<String, String> getKazakhData() {
        return this.kazakhData;
    }

    public void setKazakhData(Map<String, String> kazakhData) {
        this.kazakhData = kazakhData;
    }
    
    
    
    
}
