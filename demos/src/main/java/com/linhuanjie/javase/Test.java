package com.linhuanjie.javase;

class PerSon{
    public String name;
    public int age;

    void info(){
        System.out.println("name:"+name+",age:"+age);
    }
}

public class Test {
    public static void main(String[] args) {
        PerSon p = new PerSon();
        System.out.println(p);
        p.info();

        int [] nums = new int[3];
        nums [0] = 100 ;
        nums [1] = 1000 ;
        nums [2] = 10000 ;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
    }
}
