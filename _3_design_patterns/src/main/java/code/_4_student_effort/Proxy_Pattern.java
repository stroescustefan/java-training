package code._4_student_effort;

import java.util.ArrayList;

public class Proxy_Pattern {
	public static void main(String[] args) {
		Apartment app01 = new Apartment("Crangasi01", 300);
		Apartment app02 = new Apartment("Crangasi01", 600);
		Apartment app03 = new Apartment("Crangasi01", 350);
		Apartment app04 = new Apartment("Crangasi01", 400);
		Apartment app05 = new Apartment("Crangasi01", 200);

		RealEstateAgentProxy proxy = new RealEstateAgentProxy();
		proxy.represent(app01);
		proxy.represent(app02);
		proxy.represent(app03);
		proxy.represent(app04);
		proxy.represent(app05);

		Student student01 = new Student("Ionescu", 500);
		Student student02 = new Student("Popescu", 330);

		Apartment apartmentForStudent01 = proxy.rent(student01);
		System.out.println(student01 + " rented " + apartmentForStudent01);
		Apartment apartmentForStudent02 = proxy.rent(student02);
		System.out.println(student02 + " rented " + apartmentForStudent02);
	}
}

class Apartment {
	private String location;
	private int monthlyRentCost;

	public Apartment(String location, int monthlyRentCost) {
		this.location = location;
		this.monthlyRentCost = monthlyRentCost;
	}

	public String getLocation() {
		return location;
	}

	public int getMonthlyRentCost() {
		return monthlyRentCost;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setMonthlyRentCost(int monthlyRentCost) {
		this.monthlyRentCost = monthlyRentCost;
	}

	@Override
	public String toString() {
		return "Apartment{" +
				"location='" + location + '\'' +
				", monthlyRentCost=" + monthlyRentCost +
				'}';
	}
}

class Student {
	private String name;
	private int money;

	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", money=" + money +
				'}';
	}
}

class RealEstateAgentProxy {
    private ArrayList<Apartment> appartments;

    public RealEstateAgentProxy() {
        appartments = new ArrayList<>();
    }

    public void represent(Apartment apartment) {
        appartments.add(apartment);
    }

    public Apartment rent (Student student) {
        Apartment rental = null;
        if (student.getName().startsWith("P")) {
            return null;
        }
        for (Apartment ap : appartments) {
            if (ap.getMonthlyRentCost() <= student.getMoney()) {
                rental = ap;
            }
        }
        return rental;
    }

    public ArrayList<Apartment> getAppartments() {
        return appartments;
    }

    public void setAppartments(ArrayList<Apartment> appartments) {
        this.appartments = appartments;
    }
}
