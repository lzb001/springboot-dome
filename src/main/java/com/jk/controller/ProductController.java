package com.jk.controller;

import com.jk.model.Product;
import com.jk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @RequestMapping("/productAdd")
    public String productAdd(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "productAdd";
    }

    @RequestMapping("/productList")
    public String productList(){
        return "productList";
    }

    @RequestMapping("/Addproduct")
    @ResponseBody
    public void Addproduct(Product product){
        System.out.print(product);
        ProductService.Addproduct(product);
    }
    @RequestMapping("/queryp")
    public String queryp(Map <String, Object> map){
        List<Product> list = ProductService.queryp();
        map.put("list",list);
        return "productList";
    }

    @RequestMapping("/deleteproduct")
    @ResponseBody
    public void deleteproduct(Integer id){
        ProductService.deleteproduct(id);
    }

    @RequestMapping("/updateproduct")
    public String updateproduct(Integer id, Model model){
        Product product = ProductService.querybyid(id);
        model.addAttribute("product",product);
        return "productAdd";
    }

    @RequestMapping("uploadPhotoFile")
    @ResponseBody
    public String upImg(MultipartFile myfile, HttpServletRequest req) throws Exception{
        //获取原文件名称
        String fileName = myfile.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String folderPath = req.getSession().getServletContext().getRealPath("/")+
                "upload/";
        File file = new File(folderPath);
        //	        该目录是否已经存在
        if(!file.exists()){
            //   创建文件夹
            file.mkdir();
        }
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(myfile.getBytes());
        fos.flush();
        fos.close();
        return  "/upload/"+onlyFileName;
    }

}
