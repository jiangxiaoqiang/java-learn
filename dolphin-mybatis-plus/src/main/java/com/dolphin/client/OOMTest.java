package com.dolphin.client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqiangjiang
 */
public class OOMTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add("test");
        }
    }
}
