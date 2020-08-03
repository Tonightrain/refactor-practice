package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<LineItem> li;

    public Order(String name, String address, List<LineItem> li) {
        this.name = name;
        this.address = address;
        this.li = li;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LineItem> getLi() {
        return li;
    }

    public void setLi(List<LineItem> li) {
        this.li = li;
    }

    public List<LineItem> getLineItems() {
        return li;
    }

    public String toString(){
        return name+address;
    }
}
