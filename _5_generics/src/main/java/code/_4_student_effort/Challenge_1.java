package code._4_student_effort;


import java.lang.reflect.InvocationTargetException;

public class Challenge_1 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ExchangeDesk exchangeDesk = new ExchangeDesk();
        Ron lei = new Ron(100);
        Usd dollar = exchangeDesk.convert(lei, Usd.class, 0.20);
        System.out.println(dollar);
    }
}

class ExchangeDesk {
    public <T extends Currency, K extends Currency> T convert(K from, Class<T> toClass, double rate) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T toConv = toClass.getDeclaredConstructor().newInstance();
        toConv.setUnits(from.getUnits() * rate);
        return toConv;
    }
}


abstract class Currency {
    private double units;

    public Currency() {
        units = 0;
    }

    public Currency(double units) {
        this.units = units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public double getUnits() {
        return units;
    }
}

class Ron extends Currency {
    public Ron() {
        super();
    }

    public Ron(double value) {
        super(value);
    }

    public double getRon() {
        return super.getUnits();
    }

    @Override
    public String toString() {
        return "Ron: " +  getRon();
    }
}

class Usd extends Currency {
    public Usd() {
        super();
    }

    public Usd(double value) {
        super(value);
    }

    public double getUsd() {
        return super.getUnits();
    }

    public String toString() {
        return "Usd: " +  getUsd();
    }

}

