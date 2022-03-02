
package com.epam.task1.entity;


public class EntityArrayParameters {
 
    private int min;
    private int max;
    private double sum;
    private double average;
    
    public void setMin(int min){
        this.min = min;
    }
    
    public void setMax(int max){
        this.max = max;
    }
    
    public void setSum(double sum){
        this.sum = sum;
    }
    
    public void setAverage(double average){
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }
    
}
