package com.company;

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.XXS, 100, "Красный"),
                new TShirt(Size.XS, 120, "Белый"),
                new Skirt(Size.S, 150, "Синий"),
                new Pants(Size.M, 200, "Чёрный"),
                new Tie(Size.L, 50, "Зелёный")
        };

        Atelier atelier = new Atelier();
        atelier.dressWoman(clothes);
        atelier.dressMan(clothes);
    }
}

enum Size {
    XXS(32), XS(34), S(36), M(38), L(40);

    private final int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        if (this == XXS) {
            return "Детский размер";
        } else {
            return "Взрослый размер";
        }
    }

    public int getEuroSize() {
        return euroSize;
    }
}

interface MaleClothes {
    void dressMan();
}

interface FemaleClothes {
    void dressWoman();
}

abstract class Clothes {
    private Size size;
    private double cost;
    private String color;

    Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public double getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }
}

class TShirt extends Clothes implements MaleClothes, FemaleClothes {
    TShirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка размера " + getSize() + ", стоимостью " + getCost() +
                ", цвета " + getColor());
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская футболка размера " + getSize()+ ", стоимостью " + getCost() +
                ", цвета " + getColor() );
    }
}

class Pants extends Clothes implements MaleClothes, FemaleClothes {
    Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны размера " + getSize()+ ", стоимостью " + getCost() +
                ", цвета " + getColor());
    }

    @Override
    public void dressWoman() {
        System.out.println("Женские штаны размера " + getSize() +
                ", цвета " + getColor() + ", стоимостью " + getCost());
    }
}

class Skirt extends Clothes implements FemaleClothes {
    Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская юбка размера " + getSize()  + ", стоимостью " + getCost() +
                ", цвета " + getColor());
    }
}

class Tie extends Clothes implements MaleClothes {
    Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужской галстук размера " + getSize() + ", стоимостью " + getCost() +
                ", цвета " + getColor()) ;
    }
}

class Atelier {
    public void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes a : clothes) {
            if (a instanceof MaleClothes) {
                ((MaleClothes) a).dressMan();
            }
        }
    }
    public void dressWoman(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes a : clothes) {
            if (a instanceof FemaleClothes) {
                ((FemaleClothes) a).dressWoman();
            }
        }
    }
}
