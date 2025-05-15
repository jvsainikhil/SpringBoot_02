package com.example.demo;

import com.example.demo.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
public class DemoApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testHelloEndpoint() throws Exception {
    mockMvc.perform(get("/hello"))
           .andExpect(status().isOk())
           .andExpect(content().string("Hello, World!"));
  }

  // Bonus: Test controller directly (unit test)
  @Test
  public void testHelloControllerDirect() {
    HelloController controller = new HelloController();
    assert(controller.sayHello().equals("Hello, World!"));
  }
}
