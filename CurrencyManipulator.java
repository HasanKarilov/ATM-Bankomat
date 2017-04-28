package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс который будет хранить всю информацию про выбранную валюту
 */
public class CurrencyManipulator {
    private String currencyCode; //код валюты, например, USD. Состоит из трех букв.
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>(); // это Map<номинал, количество>.

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    /**
     * метод добавляет введенные номинал и количество банкнот
     * @param denomination - номинал
     * @param count - количество
     */
    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else denominations.put(denomination, count);
    }
    /**
     * посчитает общую сумму денег для выбранной валюты
     * @return
     */
    public int getTotalAmount(){
        int total = 0;
        for(Map.Entry<Integer, Integer> entry: denominations.entrySet())
        {
            total = total + ( entry.getKey() * entry.getValue());
        }
        return total;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }
}