package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {


    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            mobile = faker.phoneNumber().subscriberNumber(10),
            month = faker.options().option("January", "February", "March",
                    "April", "May", "June", "July", "August", "September", "October",
                    "November", "December"),
            subject = faker.options().option("Maths", "Chemistry", "Computer Science", "Commerce", "Economics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = "10.jpg",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = faker.options().option("Delhi", "Gurgaon", "Noida");

    int day = faker.number().numberBetween(1, 28);
    String daystr = String.valueOf(day);
    int year = faker.number().numberBetween(1900, 2010);
}
