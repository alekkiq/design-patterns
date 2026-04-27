package facade;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        // case 1: chucknorris jokes
        try {
            String joke = facade.getAttributeValueFromJson(
                "https://api.chucknorris.io/jokes/random",
                "value"
            );

            System.out.println("Random Chuck Norris joke: " + joke);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // case 2: fxrates
        try {
            String rate = facade.getAttributeValueFromJson(
                "https://api.fxratesapi.com/latest?base=EUR",
                "rates"
            );

            System.out.println("Exchange rates to EUR: " + rate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
