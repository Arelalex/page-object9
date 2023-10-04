package pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $x("//*[@id='dateOfBirthInput']").click();
        $x("//option[text()='" + month + "']").click();
        $x("//option[@value='" + year + "']").click();
        $x("//*[@aria-label='Choose Sunday, August " + day + "th, 1989']").click();
    }
}
