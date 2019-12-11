package com.cf.carrecorder.bean;

import java.util.ArrayList;
import java.util.List;

import top.defaults.view.PickerView;

/**
 * @author chenxihu
 * @date 2019-12-11
 * @email androidhcx@163.com
 **/
public class Item implements PickerView.PickerItem {

    private String text;
    private int value;

    public Item(String s, int value) {
        this.text = s;
        this.value = value;
    }

    @Override
    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }

    public static  List<Item> getTypeItems() {
        List<Item> types = new ArrayList<>();
        types.add(new Item("违章掉头", 1));
        types.add(new Item("占用应急车道", 2));
        types.add(new Item("压双黄线", 3));
        return types;
    }

    public static List<Item> getCarTypeItems(){
        List<Item> types = new ArrayList<>();
        types.add(new Item("黄牌", 1));
        types.add(new Item("蓝牌", 2));
        types.add(new Item("黑牌", 3));
        return types;
    }

    public static List<Item> getReportTypeItems(){
        List<Item> types = new ArrayList<>();
        types.add(new Item("匿名", 1));
        types.add(new Item("实名", 2));
        return types;
    }

}