package com.mziuri.ServiceClasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.AddClasses.AddClass;
import com.mziuri.AddClasses.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorageReader {
    private static StorageReader instance;

    public StorageReader() throws JsonProcessingException {
        fill();
    }

    public static StorageReader getInstance() throws JsonProcessingException {
        if(instance == null){
            instance=new StorageReader();
        }
        return instance;
    }
    public void fill() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        AddClass addClass;
        try {
            addClass =objectMapper.readValue(new File("src/main/resources/storage.json"), new TypeReference<AddClass>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Product> productList=addClass.getArrayList();
        DatabaseManager databaseManager=new DatabaseManager();
        ArrayList<Product> newaddedlist=databaseManager.check(productList);
        if(newaddedlist.isEmpty()){
            for(int i=0; i<newaddedlist.size(); i++){
                databaseManager.write(newaddedlist.get(i));
            }
        }
    }
    public String getpassowrd(){
        ObjectMapper objectMapper=new ObjectMapper();
        AddClass addClass;
        try {
            addClass =objectMapper.readValue(new File("src/main/resources/storage.json"), new TypeReference<AddClass>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return addClass.getPass();
    }
}
