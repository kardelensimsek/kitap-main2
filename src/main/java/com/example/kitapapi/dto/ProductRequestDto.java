package com.example.kitapapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDto {

    @NotBlank(message = "Ürün adı boş olamaz")
    private String name;

    @PositiveOrZero(message = "Fiyat negatif olamaz")
    private double price;

    @PositiveOrZero(message = "Stok negatif olamaz")
    private int stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

