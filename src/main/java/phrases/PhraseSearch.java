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

    public PhraseSearch(String text) {
        this.text = text;
        this.phrases = new ArrayList<String>();
        
        try {
        	  InputStream is = this.getClass().getClassLoader().getResourceAsStream("phrases.txt");
          InputStreamReader isr = new InputStreamReader(is);
          BufferedReader br = new BufferedReader(isr);
          String line;
          while ((line = br.readLine()) != null) 
          {
            this.phrases.add(line);
          }
          br.close();
          isr.close();
          is.close(); 
          
        }
        catch(IOException e)//fatal - exit
        {
          System.out.println("There was an error opening the phrases dictionary:" + e.toString());
          System.exit(1);
        }
        
        matchedPhrases=matchPhrases();
          
    }
    
    //check to see if any of the phrases in dictionary are contained in the input 
    //(rather than the other way around to avoid matching parts of other dictionary entries)
    private final List<String> matchPhrases() {
    	
    		List<String> matching = new ArrayList<String>();
    		for( String phrase:phrases) {
    			if(this.text.contains(phrase))
    			{
    				matching.add(phrase);
    			}	
    		}
    		return matching;
    }
    
    public final List<String> getPhrases() {
    		return matchedPhrases;
    }
}
