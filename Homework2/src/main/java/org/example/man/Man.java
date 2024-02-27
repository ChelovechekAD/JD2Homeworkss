package org.example.man;

public class Man {
    protected String name = "default name";
    private int age = 20;
    public double height = 170;

    public Man(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    private Man() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}