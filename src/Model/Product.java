package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private int price;

    public Product(){

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
