package org.example;

import dao.IDao;
import entities.Product;
import entities.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

import java.util.List;

public class Presentation2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean("productDaoImpl", IDao.class);
        IDao<Category> categoryDao = context.getBean("categoryDaoImpl", IDao.class);

        // Création de catégories
        Category cat1 = new Category("Technologies");
        categoryDao.create(cat1);

        Category cat2 = new Category("ecole");
        categoryDao.create(cat2);

        // Création de produits avec liaison ManyToOne
        Product p1 = new Product();
        p1.setName("Télévision");
        p1.setPrice(500.0);
        p1.setCategory(cat1);
        productDao.create(p1);

        Product p2 = new Product();
        p2.setName("Réfrigérateur");
        p2.setPrice(800.0);
        p2.setCategory(cat2);
        productDao.create(p2);

        Product p3 = new Product();
        p3.setName("Smartphone");
        p3.setPrice(300.0);
        p3.setCategory(cat1);
        productDao.create(p3);

        // Affichage de tous les produits avec leur catégorie
        List<Product> allProducts = productDao.findAll();
        System.out.println("Produits sauvegardés avec leur catégorie :");
        for (Product p : allProducts) {
            System.out.println("- " + p.getName() + " (" + p.getCategory().getName() + ")");
        }
    }
}