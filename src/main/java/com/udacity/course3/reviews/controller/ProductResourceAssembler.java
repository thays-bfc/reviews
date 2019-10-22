package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.Product;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductResourceAssembler implements ResourceAssembler<Product, Resource<Product>> {

    @Override
    public Resource<Product> toResource(Product product) {
        return new Resource<>(product,
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProductsController.class)
                        .findById(product.getProd_id())).withSelfRel(),
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProductsController.class)
                        .listProducts()).withRel("products"),
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ReviewsController.class)
                        .listReviewsForProduct(product.getProd_id())).withRel("reviews"));

    }

}
