package data;

import com.github.javafaker.Faker;

public class DataHelper {
    private static Faker faker = new Faker();

    public static String getApprovedCardNumber() {
        return "1111 2222 3333 4444";
    }

    public static String getDeclinedCardNumber() {
        return "5555 6666 7777 8888";
    }

    public static String generateHolderName() {
        return faker.name().fullName();
    }

    public static String generateMonth() {
        return String.format("%02d", faker.number().numberBetween(1, 12));
    }

    public static String generateYear() {
        return String.valueOf(faker.number().numberBetween(2024, 2030));
    }

    public static String generateCVC() {
        return String.format("%03d", faker.number().numberBetween(100, 999));
    }

    public static String generateRandomCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            cardNumber.append(String.format("%04d", faker.number().numberBetween(1000, 9999)));
            if (i < 3) {
                cardNumber.append(" ");
            }
        }
        return cardNumber.toString();
    }

    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cardCVC;

        public CardInfo(String cardNumber, String month, String year, String owner, String cardCVC) {
            this.cardNumber = cardNumber;
            this.month = month;
            this.year = year;
            this.owner = owner;
            this.cardCVC = cardCVC;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public String getMonth() {
            return month;
        }

        public String getYear() {
            return year;
        }

        public String getOwner() {
            return owner;
        }

        public String getCardCVC() {
            return cardCVC;
        }
    }
}
