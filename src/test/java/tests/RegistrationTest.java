package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {

    private final String firstName = "Alexandra";
    private final String secondName = "M";
    private final String email = "alex123@abc.com";
    private final String emailInvalid = "alex123"; // невалидный email
    private final String gender = "Female";
    private final String mobile = "1234567890";
    private final String day = "1";
    private final String month = "August";
    private final String year = "1989";
    private final String symbol1 = "M";
    private final String symbol2 = "C";
    private final String subject1 = "Computer Science";
    private final String subject2 = "Civics";
    private final String hobbies1 = "Reading";
    private final String hobbies2 = "Music";
    private final String picture = "10.jpg";
    private final String address = "Russia, Saint Petersburg, Admiralteyskaya Street 15";
    private final String state = "Uttar Pradesh";
    private final String city = "Merrut";
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Successful fill form registration")
    void successfulFillFormTest() {
        //заполнение формы
        registrationPage.openPage()
                .deleteBanners()
                .setFirstName(firstName)
                .setLastName(secondName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(mobile)
                .setDateOfBirth(day, month, year)
                .setSubjects(symbol1, subject1)
                .setSubjects(symbol2, subject2)
                .setHobbies(hobbies1)
                .setHobbies(hobbies2)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .setStateSelect(state)
                .setCitySelect(city)
                .submit();

        // check
        registrationPage.checkTitle()
                .checkResult("Student Name", firstName + " " + secondName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", registrationPage.addZeroWithDateWithOneChar(day) + " " + month + "," + year)
                .checkResult("Subjects", subject1 + ", " + subject2)
                .checkResult("Hobbies", hobbies1 + ", " + hobbies2)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Submitting an empty form - Negative")
    void emptyFillFormTest() {
        //отправить пустую форму
        registrationPage.openPage()
                .deleteBanners()
                .submit();

        // check
        registrationPage.checkNotTitle();
    }

    @Test
    @DisplayName("Fill form with invalid email - Negative")
    void invalidFillFormTest() {
        // заполнение формы
        registrationPage.openPage()
                .deleteBanners()
                .setFirstName(firstName)
                .setLastName(secondName)
                .setUserEmail(emailInvalid)
                .setGender(gender)
                .setUserNumber(mobile)
                .setDateOfBirth(day, month, year)
                .setSubjects(symbol1, subject1)
                .setSubjects(symbol2, subject2)
                .setHobbies(hobbies1)
                .setHobbies(hobbies2)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .setStateSelect(state)
                .setCitySelect(city)
                .submit();

        // check
        registrationPage.checkInvalidUserEmail(emailInvalid)
                .checkNotTitle();
    }
}
