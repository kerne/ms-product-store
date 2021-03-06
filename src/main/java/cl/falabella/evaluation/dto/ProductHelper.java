package cl.falabella.evaluation.dto;

import cl.falabella.evaluation.entity.ImageEntity;
import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.model.Images;
import cl.falabella.evaluation.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
public class ProductHelper {


    public static ProductEntity toEntity(Product product) {
        Optional<Product> opProduct = Optional.of(product);
        List<ImageEntity> images = new ArrayList<>();
        if (opProduct.isPresent() && opProduct.get().getOtherUrls() != null) {
            images = opProduct.get().getOtherUrls().stream().map(e -> {
                return ImageEntity.builder().name(e.getName()).build();

            }).collect(Collectors.toList());
        }
        return ProductEntity.builder()
                .sku(product.getSku())
                .name(product.getName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .size(product.getSize())
                .principalUrl(product.getPrincipalUrl())
                .images(images).build();
    }

    public static Product toProduct(ProductEntity product) {
        Optional<ProductEntity> opProduct = Optional.of(product);
        List<Images> images = new ArrayList<>();
        if (opProduct.isPresent() && opProduct.get().getImages() != null) {
            images = opProduct.get().getImages().stream().map(e -> {
                return Images.builder().name(e.getName()).build();

            }).collect(Collectors.toList());
        }
        return Product.builder()
                .sku(product.getSku())
                .name(product.getName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .size(product.getSize())
                .principalUrl(product.getPrincipalUrl())
                .otherUrls(images).build();
    }
}
