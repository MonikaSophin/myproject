package com.thinkinginjava.generics.example.chapter15_6;

import com.thinkinginjava.generics.example.chapter15_4.ex15_4_3.Generators;
import com.thinkinginjava.util.Generator;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
class Product {// 商品
    private final int id;
    private String description;
    private double price;
    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        //System.out.println(toString());
    }
    @Override
    public String toString() { return id + ": " + description + ". price: $" + price; }
    public void priceChange(double change) { price += change; }
    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test",
                    Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}

class Shelf extends ArrayList<Product> {// 货架： 填充商品
    public Shelf(int nProduct) { Generators.fill(this, Product.generator, nProduct); }
}

class Aisle extends ArrayList<Shelf> {// 走廊： 填充货架
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++)
            add(new Shelf(nProducts));
    }
}

class CheckoutStand {} // 收银台
class Office {} // 办公室

public class Store extends ArrayList<Aisle> {// 商店： 填充收银台，办公室，走廊
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();
    private Office office = new Office();
    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++)
            add(new Aisle(nShelves, nProducts));
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle aisle : this)
            for (Shelf shelf : aisle)
                for (Product product : shelf)
                    result.append(product + "\n");
        return result.toString();
    }

    public static void main(String[] args) {
        // 每1个走廊有2个货架，每1个货架有3个商品
        System.out.println(new Store(2, 2, 3));
    }
}
/**output:
 * 258: Test. price: $400.99
 * 861: Test. price: $160.99
 * 868: Test. price: $417.99
 * 207: Test. price: $268.99
 * 551: Test. price: $114.99
 * 278: Test. price: $804.99
 * 520: Test. price: $554.99
 * 140: Test. price: $530.99
 * 704: Test. price: $250.99
 * 575: Test. price: $24.99
 * 674: Test. price: $440.99
 * 826: Test. price: $484.99
 */