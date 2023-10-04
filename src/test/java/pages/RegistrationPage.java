package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    //SelenideElements
    CalendarComponent calendar = new CalendarComponent();
    CheckResultComponent results = new CheckResultComponent();
    String stateAndCity = "//*[text()='%s']";
    SelenideElement titleLabel = $x("//*[contains(text(),'Student Registration Form')]"),
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            userEmailInput = $x("//*[@id='userEmail']"),
            genderLabel = $x("//label[@for='gender-radio-2']"),
            userNumberInput = $x("//*[@id='userNumber']"),
            subjectInput = $x("//*[@id='subjectsInput']"),
            subjectSelectFirst = $x("//*[@id='react-select-2-option-2']"),
            subjectSelectSecond = $x("//*[@id='react-select-2-option-7']"),
            hobbiesCheckboxFirst = $x("//label[@for='hobbies-checkbox-2']"),
            hobbiesCheckboxSecond = $x("//label[@for='hobbies-checkbox-3']"),
            uploadPicture = $x("//input[@id='uploadPicture']"),
            currentAddressTextarea = $x("//textarea[@id='currentAddress']"),
            stateSelect = $x("//*[@id='state']"),
            citySelect = $x("//div[@class=' css-1wa3eu0-placeholder']"),
            submitButton = $x("//button[@id='submit']");

    //Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderLabel.click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String subjectFirst, String subjectSecond) {
        subjectInput.click();
        subjectInput.setValue("M");
        subjectSelectFirst.click();
        subjectInput.setValue("C");
        subjectSelectSecond.click();

        return this;
    }

    public RegistrationPage setHobbies() {
        hobbiesCheckboxFirst.click();
        hobbiesCheckboxSecond.click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);

        return this;
    }

    public RegistrationPage setStateSelect(String value) {
        stateSelect.click();
        $x(String.format(stateAndCity, value)).click();

        return this;
    }

    public RegistrationPage setCitySelect(String value) {
        citySelect.click();
        $x(String.format(stateAndCity, value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkTitle() {
        results.checkLabel("Thanks for submitting the form");

        return this;
    }

    public RegistrationPage checkNotTitle() {
        results.checkNotLabel("Thanks for submitting the form");

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        results.checkData(key, value);

        return this;
    }

    public RegistrationPage checkInvalidUserEmail(String email) {
        userEmailInput.shouldHave(value(email));

        return this;
    }

}