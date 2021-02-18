package cl.falabella.evaluation;

import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.model.Product;
import cl.falabella.evaluation.model.ProductUtil;
import cl.falabella.evaluation.respository.IProductRepo;
import cl.falabella.evaluation.services.IProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {


    @Mock
    IProductRepo repository;

    @Autowired
    IProductService service;

    @Test
    public void testAdd() throws Exception {
        Mockito.when(repository.save(Mockito.any())).thenReturn(ProductUtil.getProductEntity().get());
        Mockito.when(repository.findProduct(Mockito.anyInt())).thenReturn(ProductUtil.getProductEntity().get());
        Product entity = (Product) service.add(ProductUtil.getProduct());
        Assert.assertEquals(Integer.valueOf(1000000), entity.getSku());

    }


    @Test(expected = Exception.class)
    public void testGet() {
        Mockito.when(repository.findProduct(Mockito.anyInt())).thenReturn(ProductUtil.getProductEntity().get());
        Product entity = (Product) service.get(123123);
    }


}
