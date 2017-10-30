package com.scalderwood.pitest.testidentifying;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.cors.CorsConfigurationSource;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
public class SecurityConfigurationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private CorsConfigurationSource corsConfigurationSource;

  @Test
  public void verifyCors() throws Exception {
    MvcResult mvcResult = mockMvc.perform(post("/add")).andExpect(status().isOk()).andReturn();
    assertTrue(
        corsConfigurationSource.getCorsConfiguration(mvcResult.getRequest()).getExposedHeaders()
            .contains("Custom-Header"));
  }

}
