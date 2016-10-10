package com.johnny.javase.collection;

class MyInteger2 implements Comparable
{
    public int value;
    
    public MyInteger2(int value)
    {
        this.value = value;
    }
    
    public int compareTo(Object arg0) 
    {
        MyInteger2 temp = (MyInteger2)arg0;
        if (temp == null) return -1;
        if (temp.value > this.value)
        {
            return 1;
        }
        else if (temp.value < this.value)
        {
            return -1;
        }
        return 0;
    }
    
    public boolean equals(Object obj)
    {
        return compareTo(obj) == 0;
    }
    
    public String toString()
    {
        return String.valueOf(value);
    }
}