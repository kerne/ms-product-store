package cl.falabella.evaluation;

import cl.falabella.evaluation.model.ProductUtil;
import cl.falabella.evaluation.services.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MsProductStoreApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;


    @Mock
    IProductService service;


    @Autowired
    MockMvc mockMvc;

    @Test
    public void testAdd() throws Exception {
        Mockito.when(service.add(Mockito.any())).thenReturn(ProductUtil.getProduct());
        mockMvc
                .perform(
                        post("/api/v1/product/")
                                .accept(MediaType.APPLICATION_JSON_UTF8)
                                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                                .content(ProductUtil.getProductJson())

                )

                .andExpect(status().is2xxSuccessful());

    }


    @Test
    public void testGetById() throws Exception {
        Mockito.when(service.get(Mockito.any())).thenReturn(ProductUtil.getProduct());

        mockMvc
                .perform(
                        get("/api/v1/product/{id}", 1)
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());

    }

}
