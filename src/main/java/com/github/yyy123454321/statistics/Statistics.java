package com.github.yyy123454321.statistics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Statistics {
    public static JSONObject get(double[] num) {
        JSONObject returnJson = new JSONObject();
        double[] list = new Sort(num).get();

        returnJson.put(
                "median",
                "" + (
                        list.length % 2 == 0 ?
                                (list[list.length / 2] + list[list.length / 2 - 1]) / 2 :
                                list[(list.length - 1) / 2]
                )
        );

        double average = 0, standardDeviation = 0, variance = 0;
        HashMap<Double, Integer> mode = new HashMap<>();
        JSONArray modeArray = new JSONArray();

        for (double i : list) {
            average += i;

            if (!mode.containsKey(i)) {
                mode.put(i, 1);
            } else {
                mode.put(i, mode.get(i) + 1);
            }
        }

        average /= list.length;
        for (double i : list) variance += Math.pow((i - average), 2.0);
        standardDeviation = Math.pow(variance, 0.5);

        int maxAppear = 0;
        for (int i : mode.values()) {
            if (i > maxAppear) {
                maxAppear = i;
            }
        }

        for (Map.Entry i : mode.entrySet()) {
            if ((int) i.getValue() == maxAppear) {
                modeArray.add("" + i.getKey());
            }
        }

        if (modeArray.size() != mode.size()) {
            returnJson.put("mode", modeArray);
        } else {
            returnJson.put("mode", "none");
        }
        returnJson.put("average", "" + average);
        returnJson.put("variance", "" + variance);
        returnJson.put("standard_deviation", "" + standardDeviation);

        return returnJson;
    }
}
