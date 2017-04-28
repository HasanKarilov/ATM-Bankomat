package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс фабрика, которая будет создавать и хранить манипуляторы.
 */
public class CurrencyManipulatorFactory {
    private static final Map<String, CurrencyManipulator> map = new HashMap<String, CurrencyManipulator>();

    private CurrencyManipulatorFactory() {

    }

    /**
     * В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
     */
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        for (Map.Entry<String, CurrencyManipulator> pair : map.entrySet()) {
            if (pair.getKey().equals(currencyCode)) {
                return pair.getValue();
            }
        }
        CurrencyManipulator newCM = new CurrencyManipulator(currencyCode);
        map.put(currencyCode, newCM);
        return newCM;
    }
}