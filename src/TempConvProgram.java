import java.util.Scanner;

/**
 * A simple temperature conversion program that:
 * 1. Converts Celsius to Fahrenheit
 * 2. Converts Fahrenheit to Celsius
 * 3. Converts Celsius to Kelvin
 *
 * The program shows a text-based menu, validates user input,
 * and keeps running until the user chooses to exit.
 */
public class TempConvProgram {

    private static final double KELVIN_OFFSET = 273.15;

    private static final int OPTION_CELSIUS_TO_FAHRENHEIT = 1;
    private static final int OPTION_FAHRENHEIT_TO_CELSIUS = 2;
    private static final int OPTION_CELSIUS_TO_KELVIN = 3;
    private static final int OPTION_EXIT = 4;

    private static final String PROMPT_MENU_CHOICE = "Enter your choice (1-4): ";
    private static final String PROMPT_CELSIUS = "Enter temperature in Celsius: ";
    private static final String PROMPT_FAHRENHEIT = "Enter temperature in Fahrenheit: ";


    /**
     * Converts Celsius to Fahrenheit.
     */
    public static double convertCelsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    /**
     * Converts Fahrenheit to Celsius.
     */
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    /**
     * Converts Celsius to Kelvin.
     */
    public static double convertCelsiusToKelvin(double celsius) {
        return celsius + KELVIN_OFFSET;
    }



    public static double CtoF(double t) {
        return convertCelsiusToFahrenheit(t);
    }

    public static double f_to_c(double temp) {
        return convertFahrenheitToCelsius(temp);
    }

    public static double CtoK(double x) {
        return convertCelsiusToKelvin(x);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Temperature Conversion Menu");
        System.out.println("----------------------------");
        System.out.println(OPTION_CELSIUS_TO_FAHRENHEIT + ". Celsius to Fahrenheit");
        System.out.println(OPTION_FAHRENHEIT_TO_CELSIUS + ". Fahrenheit to Celsius");
        System.out.println(OPTION_CELSIUS_TO_KELVIN + ". Celsius to Kelvin");
        System.out.println(OPTION_EXIT + ". Exit");
    }

    /**
     * Reads a valid menu choice from the user (1–4).
     * Keeps asking until the user enters a valid integer in range.
     */
    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print(PROMPT_MENU_CHOICE);

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice >= OPTION_CELSIUS_TO_FAHRENHEIT && choice <= OPTION_EXIT) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } else {
                // Not an int at all
                System.out.println("Invalid input. Please enter a whole number between 1 and 4.");
                scanner.nextLine(); // discard invalid token
            }
        }
    }

    /**
     * Reads a temperature value from the user with a custom prompt.
     * Validates that the input is numeric.
     */
    private static double readTemperature(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                return value;
            } else {
                System.out.println("Invalid temperature. Please enter a numeric value.");
                scanner.nextLine(); // discard invalid token
            }
        }
    }

    // --- Main program loop ---

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            boolean exitSelected = false;

            while (!exitSelected) {
                printMenu();
                int userChoice = readMenuChoice(scanner);

                switch (userChoice) {
                    case OPTION_CELSIUS_TO_FAHRENHEIT: {
                        double celsius = readTemperature(scanner, PROMPT_CELSIUS);
                        double fahrenheit = convertCelsiusToFahrenheit(celsius);
                        System.out.println("Result: " + fahrenheit + " °F");
                        break;
                    }
                    case OPTION_FAHRENHEIT_TO_CELSIUS: {
                        double fahrenheit = readTemperature(scanner, PROMPT_FAHRENHEIT);
                        double celsius = convertFahrenheitToCelsius(fahrenheit);
                        System.out.println("Result: " + celsius + " °C");
                        break;
                    }
                    case OPTION_CELSIUS_TO_KELVIN: {
                        double celsius = readTemperature(scanner, PROMPT_CELSIUS);
                        double kelvin = convertCelsiusToKelvin(celsius);
                        System.out.println("Result: " + kelvin + " K");
                        break;
                    }
                    case OPTION_EXIT: {
                        System.out.println("Goodbye!");
                        exitSelected = true;
                        break;
                    }
                    default:
                        // This should never happen because readMenuChoice validates the input,
                        // but we keep it for safety.
                        System.out.println("Unexpected error with menu choice.");
                        break;
                }
            }
        }
    }
}
