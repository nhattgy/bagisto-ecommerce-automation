package utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataHelper {
    private Faker faker;

    public DataHelper() {
        faker = new Faker();
    }

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();

    public static DataHelper getDataHelper() {
        return new DataHelper();
    }
    public String getName() {
        return faker.name().name();
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

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    public static String randomNumber(int min, int max) {
        return String.valueOf(random.nextInt(max - min + 1) + min);
    }

    public static String randomCategoryName() {
        return "Category_" + randomString(6);
    }

    public static String randomDescription() {
        return "This is description for " + randomString(8);
    }

    public static String randomMetaTitle() {
        return "Meta_" + randomString(5);
    }

    public static String randomSlug() {
        return randomString(8).toLowerCase();
    }

    public String randomSKU() {
        return "SKU" + randomString(6);
    }

    public String randomProductName() {
        return "Product_" + randomString(8);
    }

    public String randomShortDescription() {
        return "Short description " + randomString(10);
    }

    public String randomLongDescription() {
        return "Long description " + randomString(15);
    }

    public String randomMetaKeyword() {
        return "keyword_" + randomString(6);
    }

    public String randomMetaDescription() {
        return "Description_" + randomString(10);
    }

    public String randomWeight() {
        return randomNumber(100, 500); // gram
    }

    public String randomPrice() {
        return randomNumber(50, 500);
    }

    public String randomInventory() {
        return randomNumber(10, 200);
    }
    public String generateCouponCode() {
        Faker faker = new Faker();
        String letters = faker.letterify("????").toUpperCase();
        String numbers = faker.numerify("####");
        return letters + numbers;
    }

}
