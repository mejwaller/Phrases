package phrases;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;//status(),content()
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//get()
import static org.hamcrest.Matchers.*;

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
		
		mockMvc.perform(get("/phrases?text=I have a sore throat and a headache"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$.phrases",hasSize(2)))
			.andExpect(jsonPath("$.phrases",hasItem("sore throat")))
			.andExpect(jsonPath("$.phrases",hasItem("headache")));
		
	}
	
	@Test
	public void testGetPhrasesWrongURIGives404() throws Exception {
		
		mockMvc.perform(get("/"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void testGetPhrasesBlankURI() throws Exception {
		
		mockMvc.perform(get("/phrases?text="))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$.phrases",hasSize(0)));
	}	
	
}