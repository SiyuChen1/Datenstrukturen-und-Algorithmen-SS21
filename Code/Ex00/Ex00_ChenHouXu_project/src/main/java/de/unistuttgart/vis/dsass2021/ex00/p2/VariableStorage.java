package de.unistuttgart.vis.dsass2021.ex00.p2;

public class VariableStorage<T> implements IVariableStorage<T> {
    private T val;

    @Override
    public void set(T val) {
        this.val = val;
    }

    @Override
    public T get(){
        return this.val;
    }
}
