package de.unistuttgart.vis.dsass2021.ex00.p1;

public class Calculator implements ICalculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    @Override
    public int max(int a, int b) {
        return a > b? a : b;
    }

    @Override
    public int digitSum(int a) {
        int res = 0;
        while (a > 0){
            res += a % 10;
            a = a/10;
        }
        return res;
    }
}