package com.mziuri.ServletClasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.AddClasses.*;
import com.mziuri.ServiceClasses.DatabaseManager;
import com.mziuri.ServiceClasses.StorageReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/store/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    String name=req.getParameter("name");
    DatabaseManager databaseManager=new DatabaseManager();
    if(databaseManager.checkname(name)){
        GetProductInfoResponse getProductInfoResponse=databaseManager.getbyname(name);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(getProductInfoResponse);
        resp.getWriter().write(jsonResponse);
    }else{
        resp.setStatus(405);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name=req.getParameter("name");
        String amount1=req.getParameter("amount");
        int amount=Integer.parseInt(amount1);

        DatabaseManager databaseManager=new DatabaseManager();
        if(databaseManager.checkamount(amount)){
            PurchaseResponse purchaseResponse= new PurchaseResponse(name,amount);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(purchaseResponse);
            resp.getWriter().write(jsonResponse);
        }else{
            resp.setStatus(405);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name=req.getParameter("name");
        String amount1=req.getParameter("amount");
        int amount=Integer.parseInt(amount1);

        String password=req.getParameter("password");
        DatabaseManager databaseManager=new DatabaseManager();
        StorageReader storageReader=new StorageReader();
        if(password.equals(storageReader.getpassowrd())){
            if(databaseManager.checkname(name)){
                AddProductResponse addProductResponse=new AddProductResponse(name,amount);
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonResponse = objectMapper.writeValueAsString(addProductResponse);
                resp.getWriter().write(jsonResponse);
            }else{
                resp.setStatus(405);
            }
        }else{
            resp.setStatus(403);
        }
    }
}
