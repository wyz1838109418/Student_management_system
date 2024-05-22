package information;

public class student {
    private String id;
    private String name;
    private String gender;
    private String age;
    private String nationality;
    private String photo;
    private String phone;
    private String totalCredits;
    private String major;

    public student(String id, String name, String gender, String age, String nationality, String photo, String phone, String totalCredits, String major) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
        this.photo = photo;
        this.phone = phone;
        this.totalCredits = totalCredits;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhone() {
        return phone;
    }

    public String getTotalCredits() {
        return totalCredits;
    }

    public String getMajor() {
        return major;
    }
}
