package com.Product;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

// Абстрактный класс для продукта
public abstract class Product {
    String name;
    double weight;

    public Product(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Product() {

    }

    public abstract String getDetails();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.weight, weight) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}
