package utilities;

import com.github.javafaker.Faker;

public class DataHelper {
    private Faker faker;
    public DataHelper(){
        faker = new Faker();
    }
    public static DataHelper getDataHelper() {
        return new DataHelper();
    }
    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName() {
        return faker.name().lastName();
    }
    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }
    public String getPassword(){
        return faker.internet().password();
    }
}
