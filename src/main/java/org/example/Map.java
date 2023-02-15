package org.example;

import java.io.InputStream;
import java.util.*;

public class Map {
    public String[] level = new String[0];

    public void createMap(String path) {
        InputStream is = getClass().getResourceAsStream(path);
        Scanner sc = null;
        sc = new Scanner(is);
        String temp = "";
        while (sc.hasNextLine()) {
            temp = temp.concat(sc.nextLine() + " ");
        }
        level = temp.split(" ");
        System.out.println(level.length);
    }

    public void showMap() {
        for (int i = 0; i < level.length; i ++) {
            System.out.println(level[i] + " ");
        }
    }
}
