package tests;

import com.github.javafaker.Faker;
import pages.RegistrationPage;

import java.util.Locale;

public class TestData {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            mobile = faker.phoneNumber().subscriberNumber(10),
            month = faker.options().option("January", "February", "March",
                    "April", "May", "June", "July", "August", "September", "October",
                    "November", "December"),
            symbol = faker.options().option("A", "B", "C", "E", "I", "O", "U", "Y",
                    "D", "G", "H", "L", "M", "N", "P", "R", "S", "T", "V"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = "10.jpg",
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    int year = faker.number().numberBetween(1900, 2010);
}
