package com.mziuri.ServiceClasses;

import com.mziuri.AddClasses.GetProductInfoResponse;
import com.mziuri.AddClasses.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("chemi-unit");
    private static DatabaseManager instance;


    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public DatabaseManager() {
    }

    public List<Product> read() {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        TypedQuery<Product> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Product> list = typedQuery.getResultList();
        return list;
    }

    public void write(Product product) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public void update(String name, int newamount) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, idbyname(name));
        if (product != null) {
            product.setProd_amount(newamount);
            entityManager.merge(product);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void decreaseamountbyone(String name) {
        int amount=getamountbyname(name)-1;
        update(name,amount);
    }

    public ArrayList<Product> check(ArrayList<Product> arrayList) {
        List<Product> list = read();
        ArrayList<Product> liststobeadded = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            boolean tf = false;
            for (int j = 0; j < list.size(); j++) {
                if (arrayList.get(i).equals(list.get(j))) {
                    tf = true;
                    break;
                }
            }
            if (!tf) {
                liststobeadded.add(arrayList.get(i));
            }
        }
        return liststobeadded;
    }
    public int getamountbyname(String name){
        int amount=0;
        List<Product> list=read();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getProd_name().equals(name)){
                amount=list.get(i).getProd_amount();
            }
        }
        return amount;
    }
    public int idbyname(String name){
        int id=0;
        List<Product> list=read();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getProd_name().equals(name)){
                id=list.get(i).getProd_id();
            }
        }
        return id;
    }
    public boolean checkname(String name) {
        List<Product> list = read();
        boolean tf = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProd_name().equals(name)) {
                tf = true;
            }
        }
        return tf;
    }

    public boolean checkamount(int amount) {
        List<Product> list = read();
        boolean tf = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProd_amount() == amount) {
                tf = true;
            }
        }
        return tf;
    }

    public GetProductInfoResponse getbyname(String name) {
        List<Product> list = read();
        GetProductInfoResponse getProductInfoResponse = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProd_name().equals(name)) {
                getProductInfoResponse = new GetProductInfoResponse(list.get(i).getProd_name(), list.get(i).getProd_price(), list.get(i).getProd_amount());
            }
        }
        return getProductInfoResponse;
    }
}
