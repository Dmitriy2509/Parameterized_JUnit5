package Pages;

public enum Hobbies {

    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private String option;

    Hobbies (String option){
        this.option = option;
    }

    public String getOptionHobby(){
      return option;
    }
}
