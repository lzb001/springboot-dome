package com.jk.service.Impl;

import com.jk.dao.ProductMapper;
import com.jk.model.Product;
import com.jk.service.ProductService;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductMapper ProductMapper;
    @Override
    public List<Product> queryp() {
        return ProductMapper.queryp();
    }
    public  void  Addproduct(Product product){
        if(product.getProductno()!=null){
            ProductMapper.updateproduct(product);
        }else {
        ProductMapper.addproduct(product);}
    }
    public  void  deleteproduct(Integer id){
        ProductMapper.deleteproduct(id);
    }
    public  Product querybyid(Integer id){
        return ProductMapper.querybyid(id);
    }
}
