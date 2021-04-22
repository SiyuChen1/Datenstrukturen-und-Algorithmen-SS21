package de.unistuttgart.vis.dsass2021.ex00.p3;

import de.unistuttgart.vis.dsass2021.ex00.p2.VariableStorage;

import javax.lang.model.util.Elements;

public class TextStorage<T extends CharSequence> extends VariableStorage<T> implements ITextStorage<T> 
{
    @Override
    public int countMatchingCharacters(ITextStorage<?> other) {
        T original = this.get();
        T target = (T) other.get();
        int lengthOriginal = original.length();
        int lengthTarget = target.length();
        int len = lengthOriginal > lengthTarget ? lengthTarget : lengthOriginal;
        int res = 0;
        for(int i = 0; i < len; i ++){
            if(target.charAt(i) == original.charAt(i)){
                res += 1;
            }
        }
        return res;
    }
}
