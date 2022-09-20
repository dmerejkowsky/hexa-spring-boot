package fr.arolla.hexa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest()
@Import(TestConfig.class)
class FactsControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private FakeRepository fakeRepository;

  @Test
  void contextLoads() {
  }

  @BeforeEach
  void resetRepository() {
    fakeRepository.reset();
  }

  @Test
  void canGetFact() throws Exception {
    fakeRepository.addFact(1, "toto");

    final ResultActions result = mockMvc.perform(
      get("/fact/1"));
    result.andExpect(status().isOk());
    String response = result.andReturn().getResponse().getContentAsString();

    assertEquals("toto", response);
  }

  @Test
  void returns404WhenFactNotFound() throws Exception {
    final ResultActions result = mockMvc.perform(
      get("/fact/1"));
    result.andExpect(status().is4xxClientError());
  }
}
