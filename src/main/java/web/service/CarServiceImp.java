package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService {

    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("model1", "color1", 111));
        cars.add(new Car("model2", "color2", 222));
        cars.add(new Car("model3", "color3", 333));
        cars.add(new Car("model4", "color4", 444));
        cars.add(new Car("model5", "color5", 555));
    }

    public List<Car> index(){
        return cars;
    }

    public List<Car> listCount(int count) {
        return cars.subList(0, count);
    }

}
