
package com.epam.task1.entity;


public class EntityArrayParameters {
 
    private int min;
    private int max;
    private double sum;
    private double average;
    
    public EntityArrayParameters(int min, int max, double sum, double average){
        this.min = min;
        this.max  = max;
        this.sum = sum ;
        this.average = average;
    } 
    
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
    
    @Override
    public boolean equals(Object obj) {
        
        // Рефлексивность
        if (this == obj){ 
            return true;
        }
        
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        EntityArrayParameters param = (EntityArrayParameters) obj;
       
        return sum == param.sum &&
               max == param.max &&
               min == param.min &&
               average == param.average;
    }

    @Override
    public int hashCode() {
        double result = min;
        result = result * 20 + max;
        result = result * 20 + sum;
        result = result * 20 + average;
        return (int)result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName());
        stringBuilder.append('{').
                append("max=").append(max).
                append(", min=").append(min).
                append(", sum=").append(sum).
                append(", average=").append(average).
                append('}');
        return stringBuilder.toString();
    }

    @Override
    public EntityArrayParameters clone() {
        return new EntityArrayParameters(max, min, sum, average);
    }
    
}
