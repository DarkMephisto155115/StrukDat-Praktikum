package Modul1.codelab;

class Box<T> {
    private T value;

    public void setValue(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void display(){
        System.out.println(getValue());
    }
}

public class Main{
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();

        integerBox.setValue(42);
        integerBox.display();
        int intValue = integerBox.getValue();
        System.out.println("Integer value: " + intValue);

        Box<String> stringBox = new Box<>();

        stringBox.setValue("Hello, Generics!");
        String strValue = stringBox.getValue();
        stringBox.display();
        System.out.println("String value: " + strValue);
    }
}
