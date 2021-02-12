package cl.falabella.evaluation;

import cl.falabella.evaluation.model.ProductUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class MsProductStoreApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;


    MockMvc mockMvc;

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testAdd() throws Exception {
        mockMvc
                .perform(
                        post("/api/v1/")
                                .accept(MediaType.APPLICATION_JSON_UTF8)
                                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                                .content(ProductUtil.getProductJson())

                )

                .andExpect(status().isOk());

    }

    @Test
    public void testGetById() throws Exception {

        mockMvc
                .perform(
                        get("/api/v1/{id}", 1)
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

}
