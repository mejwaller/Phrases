package phrases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PhraseSearch {

    private final String text;
	private final List<String> phrases;
	private final List<String> matchedPhrases;

    public PhraseSearch(String text) throws IOException{
        this.text = text;
        this.phrases = new ArrayList<String>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("phrases.txt");
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        //StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) 
        {
          //sb.append(line);
          //System.out.println(line);
          this.phrases.add(line);
        }
        br.close();
        isr.close();
        is.close();  
        
        matchedPhrases=matchPhrases();
        
    }
    
    //check to see if any of the phrases in dictonary are comtained in the input 
    //(rather than the other around which would be much harder!)
    ArrayList<String> matchPhrases() {
    	
    		ArrayList<String> matching = new ArrayList<String>();
    		for( String phrase:phrases) {
    			if(this.text.contains(phrase))
    			{
    				matching.add(phrase);
    			}	
    		}
    		return matching;
    }
    
    public List<String> getPhrases() {
    		return matchedPhrases;
    }
}
