import Pages.Gender;
import Pages.Hobbies;
import Pages.RegistrationPage;
import Pages.components.CalendarComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParameterizedTestWithJunit5 {

    RegistrationPage registrationPage = new RegistrationPage();
    TestDataFaker testDataFaker = new TestDataFaker();
    CalendarComponent calendarComponent = new CalendarComponent();
    String pathFile = "img/testImg.png";


    @Test
    public void registrationWithPageObjectTestAndFaker() {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .clickMaleRadioBtn()
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(testDataFaker.subjects)
                .clickSportCheckBoxField()
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn()
                .checkSubmitFormIsDisplayed(testDataFaker.firstName)
                .checkSubmitFormIsDisplayed(testDataFaker.lastName);
    }

    @ValueSource(strings = {
            "Dmitriy",
            "Игорь",
            "Ann",
            "Kate"
    })
    @ParameterizedTest(name = "Registration test with ValueSource: {0}")
    public void registrationWithPageObjectTestAndValueSource(String name) {
        registrationPage
                .openPage()
                .setFirstName(name)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .clickMaleRadioBtn()
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(testDataFaker.subjects)
                .clickSportCheckBoxField()
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn()
                .checkSubmitFormIsDisplayed(name)
                .checkSubmitFormIsDisplayed(testDataFaker.lastName);
    }

    @CsvSource({
            "Dmitriy, Petrov",
            "Игорь, Иванов",
            "Ann, Rem",
            "Kate, Mercedes"
    })
    @ParameterizedTest(name = "Registration test with CsvSource: {1}")
    public void registrationWithPageObjectTestAndCsvCourse(String name, String surname) {
        registrationPage
                .openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(testDataFaker.email)
                .clickMaleRadioBtn()
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(testDataFaker.subjects)
                .clickSportCheckBoxField()
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn()
                .checkSubmitFormIsDisplayed(name)
                .checkSubmitFormIsDisplayed(surname);
    }

    @EnumSource(Gender.class)
    @ParameterizedTest(name = "Registration test with EnumSource")
    public void registrationWithPageObjectTestAndEnum(Gender gender) {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .selectGenderWithEnum(gender)
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(testDataFaker.subjects)
                .clickSportCheckBoxField()
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn()
                .checkSubmitFormIsDisplayed(testDataFaker.firstName)
                .checkSubmitFormIsDisplayed(testDataFaker.lastName);
    }

    @EnumSource(Hobbies.class)
    @ParameterizedTest(name = "Registration test with EnumSource (Hobbies)")
    public void registrationWithPageObjectTestAndEnumHobbies(Hobbies hobby) {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .clickMaleRadioBtn()
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(testDataFaker.subjects)
                .selectHobbiesWithEnum(hobby)
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn()
                .checkSubmitFormIsDisplayed(testDataFaker.firstName)
                .checkSubmitFormIsDisplayed(testDataFaker.lastName);
    }
    // The method with parameters has the same name as the test method has
    static Stream<Arguments> registrationWithPageObjectTestAndMethodSource() {
        return Stream.of(
                Arguments.of(
                        "Other", "Reading"
                ),
                Arguments.of(
                        "Female", "Music"
                )
        );
    }

    @MethodSource()
    @ParameterizedTest
    public void registrationWithPageObjectTestAndMethodSource(String gender, String hobby) {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .selectGender(gender)
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(testDataFaker.subjects)
                .selectHobby(hobby)
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn()
                .checkSubmitFormIsDisplayed(testDataFaker.firstName)
                .checkSubmitFormIsDisplayed(testDataFaker.lastName);
    }
    //ParameterizedTest with three options
    static Stream<Arguments> registrationMethodSource() {
        return Stream.of(
                Arguments.of(
                        "Other", "Music"
                ),
                Arguments.of(
                        "Female", "Reading"
                ),
                Arguments.of(
                        "Male", "Sports"
                )
        );
    }

    @MethodSource("registrationMethodSource")
    @ParameterizedTest
    public void registrationWithPageObjectTestAndMethodSource2(String gender, String hobby) {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .selectGender(gender)
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(testDataFaker.subjects)
                .selectHobby(hobby)
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn()
                .checkSubmitFormIsDisplayed(testDataFaker.firstName)
                .checkSubmitFormIsDisplayed(testDataFaker.lastName);
    }
}
