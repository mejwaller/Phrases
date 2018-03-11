package phrases;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhraseController {

		@RequestMapping("/phrases")
		public PhraseSearch ps(@RequestParam(value="text") String text) {
			  return new PhraseSearch(text);		
		}
 
}