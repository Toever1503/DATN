package com.service.impl;

import com.entities.Product;
import com.entities.dtos.ProductDto;
import com.entities.models.ProductModel;
import com.repository.ProductRepository;
import com.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable page) {
        return this.productRepository.findAll(page);
    }

    @Override
    public Page<Product> findAll(Pageable page, Specification<Product> specifications) {
        return this.productRepository.findAll(specifications, page);
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found product id: " + id));
    }

    @Override
    public Product add(ProductModel model) {
        Product entity = ProductModel.toEntity(model);
        return this.productRepository.save(entity);
    }

    @Override
    public Product update(ProductModel model) {
        return add(model);
    }

    @Override
    public boolean deleteById(Long id) {
        this.productRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }

    @Override
    public List<ProductDto> getAllByCategory(Long categoryId) {
        return this.productRepository.getAllByCategory(categoryId);
    }
}
