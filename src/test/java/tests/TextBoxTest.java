package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxTestPage;


public class TextBoxTest extends TestBase {
    private final String fullName = "Alex M";
    private final String email = "alex123@abc.com";
    private final String currentAddress = "Porta Nuova Isola, Building C, Via Federico Confalonieri 4\n" +
            "20124 Milan\n" +
            "Italy";
    private final String permanentAddress = "6 Pancras Square\n" +
            "London N1C 4AG\n" +
            "United Kingdom";

    TextBoxTestPage textBoxTest = new TextBoxTestPage();

    // успешное заполнение формы
    @Test
    @DisplayName("Successful fill form Text Box")
    void successfulFillTextBoxFormTest() {
        textBoxTest.openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        // check
        textBoxTest.checkForm("Name:", fullName)
                .checkForm("Email:", email)
                .checkForm("Current Address :", currentAddress)
                .checkForm("Permananet Address :", permanentAddress);
    }

    // отправка пустой формы
    @Test
    @DisplayName("Submitting an empty form - Negative")
    void sendEmptyTextBoxFormTest() {
        textBoxTest.openPage()
                .clickSubmit();

        // check
        textBoxTest.checkFormEmpty();
    }

    // отправка формы с незаполненными полями
    @Test
    @DisplayName("Submitting a form with empty fields - Negative")
    void sendTextBoxFormWithEmptyFieldsTest() {
        textBoxTest.openPage()
                .setFullName(fullName)
                .setCurrentAddress(currentAddress)
                .clickSubmit();

        // check
        textBoxTest.checkForm("Name:", fullName)
                .checkForm("Current Address :", currentAddress);
    }

}
