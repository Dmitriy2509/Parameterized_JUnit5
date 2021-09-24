package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public static final String URL_REGISTRATION = "https://demoqa.com/automation-practice-form";
    private SelenideElement
            firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            emailField = $("#userEmail"),
            maleRadioBtn = $(By.xpath("//*[contains(text(), 'Male')]")),
            mobilePhoneField = $("#userNumber"),
            subjectField = $("#subjectsInput"),
            sportCheckBoxField = $(By.xpath("//label[@class = 'custom-control-label'] [contains(text(), 'Sports')]")),
            uploadPictureField = $("#uploadPicture"),
            addressField = $("#currentAddress"),
            stateDropDownMenu = $("#stateCity-wrapper #state .css-1wa3eu0-placeholder"),
            ncrOption = $(By.xpath("//div[contains(@class, ' css-11unzgr')]//div[contains(text(), 'NCR')]")),
            cityDropDownMenu = $("#city"),
            delhiOption = $(By.xpath("//div[contains(@class, 'css-11unzgr')]//div[contains(text(), 'Delhi')]")),
            submitBtn = $("#submit");
    String form = "//tr/td[text()='Student Name']/following-sibling::td[contains(text(), '%s')]",
            radioCheckbox = "//*[contains(text(), '%s')]",
            radioCheckboxStrict = "//*[text()='%s']";

    public RegistrationPage openPage() {
        open(URL_REGISTRATION);
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameField.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public RegistrationPage clickMaleRadioBtn() {
        maleRadioBtn.click();
        return this;
    }

    public RegistrationPage setMobilePhone(String mobilePhone) {
        mobilePhoneField.setValue(mobilePhone);
        return this;
    }

    public RegistrationPage setSubjectField(String subjects) {
        subjectField.click();
        subjectField.sendKeys(subjects);
        subjectField.pressEnter();
        return this;
    }

    public RegistrationPage clickSportCheckBoxField() {
        sportCheckBoxField.click();
        return this;
    }

    public RegistrationPage uploadPicture(String pathToPicture) {
        uploadPictureField.uploadFromClasspath(pathToPicture);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        addressField.setValue(currentAddress);
        return this;
    }

    public RegistrationPage chooseNcrOption() {
        stateDropDownMenu.scrollIntoView(true);
        stateDropDownMenu.click();
        ncrOption.click();
        return this;
    }

    public RegistrationPage chooseDelhiOption() {
        cityDropDownMenu.click();
        delhiOption.click();
        return this;
    }

    public RegistrationPage clickSubmitBtn() {
        submitBtn.click();
        return this;
    }

    public RegistrationPage checkSubmitFormIsDisplayed(String textOnForm) {
        $(By.xpath(String.format(form, textOnForm))).shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage selectGenderWithEnum(Gender gender) {
//        this commented code like reminder for me We can use shorter version
//        if(gender == Gender.MALE) {
//            $(By.xpath(String.format(radioBtn, gender.getGenderOption()))).click();
//        } else if(gender == Gender.FEMALE){
//            $(By.xpath(String.format(radioBtn, gender.getGenderOption()))).click();
//        } else if(gender == Gender.OTHER){
//            $(By.xpath(String.format(radioBtn, gender.getGenderOption()))).click();
//        }
        $(By.xpath(String.format(radioCheckbox, gender.getGenderOption()))).click();
        return this;
    }

    public RegistrationPage selectHobbiesWithEnum(Hobbies hobby) {
        $(By.xpath(String.format(radioCheckbox, hobby.getOptionHobby()))).click();
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(By.xpath(String.format(radioCheckboxStrict, gender))).click();
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        $(By.xpath(String.format(radioCheckboxStrict, hobby))).click();
        return this;
    }
}
