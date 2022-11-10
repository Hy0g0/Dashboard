package com.example.application.data.widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetList {
   static private List<Widget> lists = new ArrayList<Widget>();

    public WidgetList() {
        
    }

    public static List<Widget> getLists() {
        return lists;
    }

    public static void add(Widget list) {
        lists .add(list);
    }

    public static void refresh(){
        for (Widget list : lists) {
            list.refresh();
        }
    }
}
