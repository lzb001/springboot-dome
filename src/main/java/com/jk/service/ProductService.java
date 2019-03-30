package com.jk.service;

import com.jk.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryp();

    void Addproduct(Product product);

    void deleteproduct(Integer id);

    Product querybyid(Integer id);
}
