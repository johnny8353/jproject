package com.johnny.javase.collection;

class MyInteger
{
    private Integer value;
    
    public MyInteger(Integer value)
    {
        this.value = value;
    }
    
    public String toString()
    {
        return String.valueOf(value);
    }
    
    public int hashCode()
    {
        return 1;
    }
    
    public boolean equals(Object obj)
    {
        return false;
    }
}