package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTestPage {

    // elements
    SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressTextarea = $("#currentAddress"),
            permanentAddressTextarea = $("#permanentAddress"),
            submitButton = $("#submit");

    // actions
    public TextBoxTestPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxTestPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxTestPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxTestPage setCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);

        return this;
    }

    public TextBoxTestPage setPermanentAddress(String value) {
        permanentAddressTextarea.setValue(value);

        return this;
    }

    public TextBoxTestPage clickSubmit() {
        submitButton.click();

        return this;
    }

   public TextBoxTestPage checkForm(String key, String value) {
       $("#output").$(byText(key)).parent().shouldHave(text(value));

       return this;
   }

    public TextBoxTestPage checkFormEmpty() {
        $("#output").$(byText("Name:")).parent().should(hidden);

        return this;
    }
}
