package service;

public class B {
    public B() {

    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null || getClass() != obj.getClass()) return false;
        B b = (B) obj;
        return toString().equals(b.toString());
    }

    @Override
    public String toString() {
        return "B{}";
    }
}

    