package com.ohgiraffers.api.objcet.car;

import java.util.Objects;

public class Car {
    private String carName;
    private String carColor;
    private int engineCC;


    public Car(String carName, String carColor, int engineCC) {
        this.carName = carName;
        this.carColor = carColor;
        this.engineCC = engineCC;
    }

    // 복사생성자?
    public Car(Car other){

    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    @Override
    public boolean equals(Object obj) {
        // 비교에서 null이거나 클래스 타입이 다르면 비교자체가 무의미하기 때문
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(carColor, car.carColor);
    }
    // 그러니까 참조값을 먼저 비교, null값이 아닌지 비교, 클래스타입이 같은지 비교, 마지막으로 필드값을 비교
    // 모든게 같으면 동일객체 (Objects.equals가 null값도 안전하게 비교 / 정석적인 비교는 강사님 파일)

    @Override
    public int hashCode() {
        return Objects.hash(carName, carColor);
    }
}
