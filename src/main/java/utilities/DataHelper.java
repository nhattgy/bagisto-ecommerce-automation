package utilities;

import com.github.javafaker.Faker;

public class DataHelper {
    private Faker faker;

    public DataHelper() {
        faker = new Faker();
    }

    public static DataHelper getDataHelper() {
        return new DataHelper();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password();
    }

    public String getCompany() {
        return faker.company().name();
    }

    // --- Các hàm bổ sung cho checkout ---
    public String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getState() {
        return faker.address().state();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getPhoneNumber() {
        return faker.numerify("09########");
    }

}
