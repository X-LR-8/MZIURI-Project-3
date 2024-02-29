package com.mziuri.ServletClasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.AddClasses.GetProductsResponse;
import com.mziuri.AddClasses.Product;
import com.mziuri.ServiceClasses.DatabaseManager;
import com.mziuri.ServiceClasses.StorageReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StorageReader storageReader=new StorageReader();
        DatabaseManager databaseManager=new DatabaseManager();
        List<Product> arrayList=databaseManager.read();
        String[] namelist=new String[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            namelist[i]=arrayList.get(i).getProd_name();
        }
        GetProductsResponse getProductsResponse=new GetProductsResponse(namelist);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(getProductsResponse);
       // resp.getWriter().write(jsonResponse);
    }
}

