package code._4_student_effort;

public class Database {
	public static void main(String[] args) {
		Premiu oscar1990 = new Premiu("oscar", 1990);
		Premiu oscar2000 = new Premiu("oscar", 2000);
		Premiu oscar2010 = new Premiu("oscar", 2010);
		Premiu oscar2018 = new Premiu("oscar", 2018);

		Actor actorOscar1990 = new Actor("actor cu 2 oscaruri", 35, new Premiu[]{oscar1990, oscar2000});
		Actor actorOscar2010 = new Actor("actor cu oscar din 2000", 55, new Premiu[]{oscar2010});
		Actor actorOscar2018 = new Actor("actor cu oscar din 2018", 23, new Premiu[]{oscar2018});
		Actor actorFaraPremii01 = new Actor("actor fara oscar 01", 33, new Premiu[]{});
		Actor actorFaraPremii02 = new Actor("actor fara oscar 02", 60, new Premiu[]{});
		Actor actorFaraPremii03 = new Actor("actor fara oscar 02", 20, new Premiu[]{});

		Film film1 = new Film(1990, "film cu actori de oscar", new Actor[]{actorOscar1990, actorFaraPremii01});
		Film film2 = new Film(2010, "film cu actori fara premii2", new Actor[]{actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
		Film film3 = new Film(2010, "film cu actori fara premii3", new Actor[]{actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
		Film film4 = new Film(2018, "film cu actori de oscar", new Actor[]{actorOscar2010, actorOscar2018, actorFaraPremii02});
		Film film5 = new Film(2018, "film cu actori fara premii5", new Actor[]{actorFaraPremii02, actorFaraPremii03});

		Studio studio1 = new Studio("MGM", new Film[]{film1, film2});
		Studio studio2 = new Studio("Disney", new Film[]{film3, film4, film5});
		Studio[] studioDatabase = new Studio[]{studio1, studio2};

		// requirments
		firstRequirment(studioDatabase, 2);
		secondRequirment(studioDatabase, "actor cu 2 oscaruri");
		thirdRequirment(studioDatabase, 50);
	}

	public static void firstRequirment(Studio[] studioDatabase, int moreThan) {
		for (Studio studio : studioDatabase) {
			if (studio.filme.length > moreThan) {
				System.out.println(studio.nume);
			}
		}
	}

	public static void secondRequirment(Studio[] studioDatabase, String actorName) {
		for (Studio studio : studioDatabase) {
			for (Film film : studio.filme) {
				for (Actor actor : film.actori) {
					if (actor.nume.equals(actorName)) {
						System.out.println(studio.nume);
					}
				}
			}
		}
	}

	public static void thirdRequirment(Studio[] studioDatabase, int age) {
		for (Studio studio : studioDatabase) {
			for (Film film : studio.filme) {
				for (Actor actor : film.actori) {
					if (actor.varsta > age) {
						System.out.println(film.nume);
					}
				}
			}
		}
	}
}

class Premiu {
	public String nume;
	public Integer an;

	public Premiu(String nume, Integer an) {
		this.nume = nume;
		this.an = an;
	}

	public Premiu() {
		this("", 0);
	}
}

class Actor {
	public String nume;
	public Integer varsta;
	public Premiu[] premii;

	public Actor(String nume, Integer varsta, Premiu[] premii) {
		this.nume = nume;
		this.varsta = varsta;
		this.premii = premii;
	}
}

class Film {
	public Integer anAparitie;
	public String nume;
	public Actor[] actori;

	public Film(Integer anAparitie, String nume, Actor[] actori) {
		this.anAparitie = anAparitie;
		this.nume = nume;
		this.actori = actori;
	}
}

class Studio {
	public String nume;
	public Film[] filme;

	public Studio(String nume, Film[] filme) {
		this.nume = nume;
		this.filme = filme;
	}
}