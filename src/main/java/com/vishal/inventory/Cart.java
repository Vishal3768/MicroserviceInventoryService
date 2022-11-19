package com.vishal.inventory;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/cart")
public class Cart {

    List<String> items=new ArrayList<>();

    @GetMapping(value = "/addToCart/{item}")
    public String addToCart(@PathVariable String item){
        if(item.contains(item)) {
            items.add(item);
            return "Item added Successfully";
        }
        return "Item Already Existed";
    }

    @GetMapping(value = "/deleteItem/{item}")
    public String deleteFromCart(@PathVariable String item){
        if(items.contains(item)) {
            items.remove(item);
            return "Item deleted Successfully";
        }
        return "Item does not exist";
    }

    @GetMapping(value = "/allItems")
    public List<String> getItems(){
        return items;
    }
}
