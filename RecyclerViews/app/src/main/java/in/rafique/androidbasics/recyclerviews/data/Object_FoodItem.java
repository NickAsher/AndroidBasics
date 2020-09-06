package in.rafique.androidbasics.recyclerviews.data;

import java.util.ArrayList;
import java.util.List;

import in.rafique.androidbasics.recyclerviews.R;

public class Object_FoodItem {
    int id;
    String name ;
    int imageId ;

    static List<Object_FoodItem> listOfItems ;

    public Object_FoodItem(int id, String name, int imageId) {
        this.id = id;
        this.name = name;
        this.imageId = imageId;
    }


    public Object_FoodItem(int id, String name) {
        this.id = id;
        this.name = name;
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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<Object_FoodItem> getListOfFoodItems(){
        if (listOfItems == null){
            listOfItems = new ArrayList<>() ;
            listOfItems.add(new Object_FoodItem(1, "Pizza", R.drawable.pizza)) ;
            listOfItems.add(new Object_FoodItem(2, "Burger", R.drawable.burger)) ;
            listOfItems.add(new Object_FoodItem(3, "Mozarella Sticks", R.drawable.mozarella_sticks)) ;
            listOfItems.add(new Object_FoodItem(4, "Soup", R.drawable.soup)) ;
            listOfItems.add(new Object_FoodItem(5, "Pasta", R.drawable.pasta)) ;
            listOfItems.add(new Object_FoodItem(6, "lasagna Frittata", R.drawable.lasagna_frittta)) ;
            listOfItems.add(new Object_FoodItem(7, "lasagna", R.drawable.lasagna)) ;
            listOfItems.add(new Object_FoodItem(8, "olives", R.drawable.olives)) ;
            listOfItems.add(new Object_FoodItem(9, "soup", R.drawable.soup)) ;
            listOfItems.add(new Object_FoodItem(10, "Tomato", R.drawable.tomato)) ;
            listOfItems.add(new Object_FoodItem(11, "cheese bread", R.drawable.cheese_bread)) ;
            listOfItems.add(new Object_FoodItem(12, "cake", R.drawable.cake)) ;
            listOfItems.add(new Object_FoodItem(13, "coffee", R.drawable.coffee)) ;
        }
        return listOfItems;
    }
}
