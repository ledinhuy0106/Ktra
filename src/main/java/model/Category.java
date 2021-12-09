package model;

public class Category {
private int categoryid;
private String danhmuc;

    public Category() {
    }

    public Category(int categoryid, String danhmuc) {
        this.categoryid = categoryid;
        this.danhmuc = danhmuc;
    }

    public Category(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }
}
