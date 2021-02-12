package cl.falabella.evaluation;

import cl.falabella.evaluation.model.ProductUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MsProductStoreApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;


    @Autowired
    MockMvc mockMvc;

    @Test
    public void testAdd() throws Exception {
        mockMvc
                .perform(
                        post("/api/v1/product/")
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
                        get("/api/v1/product/{id}", 1)
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

}
