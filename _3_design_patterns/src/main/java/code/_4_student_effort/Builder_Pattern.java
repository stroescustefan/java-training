package code._4_student_effort;

public class Builder_Pattern {
    public static void main(String[] args) {

        Person person01 = new Person.Builder("Popescu")
                .job("java developer")
                .university("FMI")
                .isMarried(false)
                .build();

        Person person02 = new Person.Builder("Ionescu")
                .drivingLicense("B")
                .isMarried(true)
                .build();

        System.out.println(person01);
        System.out.println(person02);
    }
}

class Person {
    private String name;
    private String job;
    private String university;
    private String drivingLicense;
    private boolean isMarried;

    public Person(Builder builder) {
        this.name = builder.name;
        this.job = builder.job;
        this.university = builder.university;
        this.drivingLicense = builder.drivingLicense;
        this.isMarried = builder.isMarried;
    }

    static class Builder {
        private String name;
        private String job;
        private String university;
        private String drivingLicense;
        private boolean isMarried;

        public Builder(String name) {
            this.name = name;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder university(String university) {
            this.university = university;
            return this;
        }

        public Builder drivingLicense(String drivingLicense) {
            this.drivingLicense = drivingLicense;
            return this;
        }

        public Builder isMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", university='" + university + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", isMarried=" + isMarried +
                '}';
    }
}
