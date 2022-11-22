package web.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model;
    private String color;
    private int number;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", number=" + number +
                '}';
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public Car(String model, String color, int number) {
        this.model = model;
        this.color = color;
        this.number = number;
    }
}
