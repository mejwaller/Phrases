package phrases;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhraseController {

    @RequestMapping("/phrases")
    public PhraseSearch ps(@RequestParam(value="text") String text) throws IOException {
        return new PhraseSearch(text);
    }
}