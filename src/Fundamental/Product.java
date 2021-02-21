package Fundamental;

public class Product {
    private int pid;
    private String name;
    private Double price;
    private int stock;
    
    public Product () {       
    }
    
    public Product (int pid, String name, Double price, int stock) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPid() {
        return pid;
    }
    
    public void setPid(int pid) {
        this.pid = pid;
    }   
}
