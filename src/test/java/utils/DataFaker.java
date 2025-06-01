package utils;

import com.github.javafaker.Faker;

public class DataFaker {
        public Faker faker = new Faker();

        public String getRandomFirstName(){
            return faker.name().firstName();
        }
        public String getRandomLastName(){
            return faker.name().lastName();
        }
        public String getRandomEmail(){
            return faker.internet().emailAddress();
        }
        public String getRandomGender() {
            return faker.options().option("Male", "Female", "Other");
        }

        public String getRandomPhoneNumber() {
            return faker.phoneNumber().subscriberNumber(10);
        }

        public String getRandomBirthDay() {
            return String.valueOf(faker.number().numberBetween(1,31));
        }

        public String getRandomBirthMonth() {
            return faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        }

        public String getRandomBirthYear() {
            return String.valueOf(faker.number().numberBetween(1980,2025));
        }

        public String getRandomSubject() {
            return faker.options().option(
                    "Accounting", "Art", "Biology", "Chemistry",
                    "Computer Science", "Commerce", "Civics", "English", "Economics",
                    "Hindi", "Social Students");
        }

        public String getRandomHobbies() {
            return faker.options().option(
                "Sports", "Reading", "Music");
        }

        public String getRandomPhoto(){
            return faker.options().option(
                    "photofile.jpg", "retouch.jpg");
        }

        public String getRandomAddress(){
            return faker.address().streetAddress();
        }

        public String getRandomState() {
            return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        }

        public String getRandomCity(String state) {
            switch (state) {
               case "NCR": return faker.options().option("Delhi", "Gurgaon", "Noida");
               case "Uttar Pradesh": return faker.options().option("Agra", "Lucknow", "Merrut");
               case "Haryana": return faker.options().option("Karnal", "Panipat");
               case "Rajasthan": return faker.options().option("Jaipur", "Jaiselmer");
               default: return "";
        }
    }









}
