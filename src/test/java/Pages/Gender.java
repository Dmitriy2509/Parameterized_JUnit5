package Pages;

public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String option;

    Gender(String option) {
        this.option = option;
    }

    String getGenderOption(){
        return option;
    }
}
