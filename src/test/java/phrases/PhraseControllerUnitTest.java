package phrases;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class PhraseControllerUnitTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private PhraseSearch ps;
	
	@InjectMocks
	private PhraseController pc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(pc).build();
	}
	
	@Test
	public void testGetPhrasesSuccess() throws Exception {
		List<String> phrases = Arrays.asList(
				"sore throat",
				"headache");
				
		when(ps.getPhrases()).thenReturn(phrases);
		mockMvc.perform(get("/phrases?text=I have a sore throat and a headache"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
	}
	
}