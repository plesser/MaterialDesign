package ru.plesser.materialdesign;

import java.io.Serializable;

public class Calculator implements Serializable {
    String display = "0";

    float numberOne = 0;
    float numberTwo = 0;

    String operator = "empty";

    Boolean isNewNumber = false;

    public Calculator() {

    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public float getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(float numberOne) {
        this.numberOne = numberOne;
    }

    public float getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(float numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getIsNewNumber() {
        return isNewNumber;
    }

    public void setIsNewNumber(Boolean isNewNumber) {
        this.isNewNumber = isNewNumber;
    }
}
