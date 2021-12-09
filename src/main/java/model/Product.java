package model;

public class Product {
    private int id;
    private String name;
    private int soluong;
    private String color;
    private String mota;
    private int price;

    public Product() {
    }


    public Product(String name, int soluong, String color, String mota, int price) {
        this.name = name;
        this.soluong = soluong;
        this.color = color;
        this.mota = mota;
        this.price = price;
    }

    public Product(int id, String name, int soluong, String color, String mota) {
        this.id = id;
        this.name = name;
        this.soluong = soluong;
        this.color = color;
        this.mota = mota;
    }

    public Product(int id, String name, int soluong, String color, String mota, int price) {
        this.id = id;
        this.name = name;
        this.soluong = soluong;
        this.color = color;
        this.mota = mota;
        this.price = price;
    }

    public Product(String name, int soluong, String color, String mota) {
        this.name = name;
        this.soluong = soluong;
        this.color = color;
        this.mota = mota;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
