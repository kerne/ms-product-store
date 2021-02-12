package cl.falabella.evaluation;

import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.model.ProductUtil;
import cl.falabella.evaluation.respository.IProductRepo;
import cl.falabella.evaluation.services.IProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {


    @Mock
    IProductRepo repository;

    @InjectMocks
    IProductService service;

    @Test
    public void testAdd() throws Exception {

        Mockito.when(repository.save(Mockito.any())).thenReturn(ProductUtil.getProductEntity().get());

        ProductEntity entity = (ProductEntity) service.add(ProductUtil.getProduct());

        Assert.assertEquals(Integer.valueOf(1), entity.getId());

    }


    @Test
    public void testGet() {

        Mockito.when(repository.findById(Mockito.any())).thenReturn(ProductUtil.getProductEntity());

        ProductEntity entity = (ProductEntity) service.get(1);

        Assert.assertNotNull(entity);

    }


}
