package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    public List<Car> index();

    public List<Car> listCount(int count);

}
