package com.jk.dao;

import com.jk.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from product")
    public List<Product> queryp();
    @Insert("INSERT INTO product(productname,productprice,grounddate,imagepath,attentionnumber) VALUES(#{productname},#{productprice},#{grounddate},#{imagepath},#{attentionnumber}) ")
    void addproduct(Product product);
    @Delete("delete from product where productno=#{id}")
    void deleteproduct(Integer id);
    @Select("select * from product where productno=#{id}")
    Product querybyid(Integer id);

    @Update("update product set productname=#{productname},productprice=#{productprice},grounddate=#{grounddate},imagepath=#{imagepath},attentionnumber=#{attentionnumber} where  productno=#{productno}")
    void updateproduct(Product product);
}
