package com.example.gcsvcreator.csvtestdtos;

public class TestDto {
    private String text;
    private String text2;
    private int num1;


    public TestDto(String text, String text2, int num1) {
        this.text = text;
        this.text2 = text2;
        this.num1 = num1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "text='" + text + '\'' +
                ", text2='" + text2 + '\'' +
                ", num1=" + num1 +
                '}';
    }
}
