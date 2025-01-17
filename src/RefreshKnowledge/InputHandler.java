package RefreshKnowledge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    public static void main(String[] args) {
        /*LocalDate birthDate = InputHandler.userInputLocalDate("Enter your birth date (dd-MM-yyyy): ", "dd-MM-yyyy");
        System.out.println("Your birth date is: " + birthDate);

        LocalTime meetingTime = InputHandler.userInputLocalTime("Enter the meeting time (HH:mm): ", "HH:mm");
        System.out.println("Your meeting time is: " + meetingTime);
*/
        LocalDateTime eventDateTime = InputHandler.userInputLocalDateTime("Enter event date and time (dd-MM-yyyy HH:mm): ", "dd-MM-yyyy HH:mm");
        System.out.println("Event date and time: " + eventDateTime);
        LocalDateTime localDateTime = LocalDateTime.of(2004,4,23,12,23,2,2);


       /* String email = InputHandler.userInputMail("Enter your email: ");
        System.out.println("Your email is: " + email);

        */



        /*String phoneNumber = InputHandler.userInputPhoneNumber("Enter your phone number (8 digits): ");
        System.out.println("Your phone number is: " + phoneNumber);

         */

    }
    private static final Scanner sc = new Scanner(System.in);

    // Primitive Input Methods
    public static int userInputInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            sc.next(); // Discard invalid input
        }
        return sc.nextInt();
    }

    public static long userInputLong(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextLong()) {
            System.out.print("Invalid input. " + prompt);
            sc.next(); // Discard invalid input
        }
        return sc.nextLong();
    }

    public static short userInputShort(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextShort()) {
            System.out.print("Invalid input. " + prompt);
            sc.next(); // Discard invalid input
        }
        return sc.nextShort();
    }

    public static byte userInputByte(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextByte()) {
            System.out.print("Invalid input. " + prompt);
            sc.next(); // Discard invalid input
        }
        return sc.nextByte();
    }

    public static double userInputDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            sc.next(); // Discard invalid input
        }
        return sc.nextDouble();
    }

    public static float userInputFloat(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextFloat()) {
            System.out.print("Invalid input. " + prompt);
            sc.next(); // Discard invalid input
        }
        return sc.nextFloat();
    }

    public static boolean userInputBoolean(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextBoolean()) {
            System.out.print("Invalid input. " + prompt);
            sc.next(); // Discard invalid input
        }
        return sc.nextBoolean();
    }

    public static char userInputChar(String prompt) {
        System.out.print(prompt);
        String input = sc.next();
        while (input.length() != 1) {
            System.out.print("Invalid input. " + prompt);
            input = sc.next();
        }
        return input.charAt(0);
    }

    public static String userInputString(String prompt) {
        System.out.print(prompt);
        sc.nextLine(); // Consume any leftover newline
        return sc.nextLine();
    }

    // Array Methods
    public static int[] userInputIntArray(String prompt, int size) {
        int[] array = new int[size];
        System.out.println(prompt);
        for (int i = 0; i < size; i++) {
            array[i] = userInputInt("Enter integer for index " + i + ": ");
        }

        return array;
    }

    public static double[] userInputDoubleArray(String prompt, int size) {
        double[] array = new double[size];
        System.out.println(prompt);
        for (int i = 0; i < size; i++) {
            array[i] = userInputDouble("Enter double for index " + i + ": ");
        }
        return array;
    }

    public static String[] userInputStringArray(String prompt, int size) {
        String[] array = new String[size];
        System.out.println(prompt);
        for (int i = 0; i < size; i++) {
            array[i] = userInputString("Enter string for index " + i + ": ");
        }
        return array;
    }

    // ArrayList Methods, better to use Arrays.asList()
    public static List<Integer> userInputIntArrayList(String prompt, int size) {
        List<Integer> list = new ArrayList<>();
        System.out.println(prompt);
        for (int i = 0; i < size; i++) {
            list.add(userInputInt("Enter integer for index " + i + ": "));
        }
        return list;
    }

    public static List<Double> userInputDoubleArrayList(String prompt, int size) {
        List<Double> list = new ArrayList<>();
        System.out.println(prompt);
        for (int i = 0; i < size; i++) {
            list.add(userInputDouble("Enter double for index " + i + ": "));
        }
        return list;
    }

    public static List<String> userInputStringArrayList(String prompt, int size) {
        List<String> list = new ArrayList<>();
        System.out.println(prompt);
        for (int i = 0; i < size; i++) {
            list.add(userInputString("Enter string for index " + i + ": "));
        }
        return list;
    }

    public static boolean confirm(String prompt) {
        System.out.print(prompt);
        String input = sc.next().trim().toLowerCase();
        while (!input.equals("y") && !input.equals("n")) {
            System.out.print("Invalid input. " + prompt);
            input = sc.next().trim().toLowerCase();
        }
        return input.equals("y");
    }

    public static LocalDate userInputLocalDate(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Enter your birth date (dd-MM-yyyy): ");
        System.out.print(prompt+"\n");
        while (true) {
            String input = sc.nextLine();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. " + prompt);
            }
        }
    }
    // Method to handle LocalTime input with validation
    public static LocalTime userInputLocalTime(String prompt, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format); // Define time format
        System.out.print(prompt);
        while (true) {
            String input = sc.nextLine(); // Read user input
            try {
                return LocalTime.parse(input, formatter); // Parse input to LocalTime
            } catch (DateTimeParseException e) {
                System.out.print("Invalid time format. " + prompt); // Re-prompt on invalid input
            }
        }
        }

    public static LocalDateTime userInputLocalDateTime(String prompt, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        System.out.print(prompt);
        while (true) {
            String input = sc.nextLine();
            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.print("Invalid datetime format. " + prompt);
            }
        }


    }
    public static String userInputMail(String prompt) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        String localMail;

        // First input attempt
        while (true) {
            localMail = InputHandler.userInputString(prompt); // e.g., "Input Mail: "
            Matcher matcher = pattern.matcher(localMail);
            boolean isValid = matcher.matches();

            if (isValid) {
                return localMail; // Return the valid email
            } else {
                System.out.println("Invalid email. Please try again."); // Optional message for invalid input
            }
        }
    }
    public static String userInputPhoneNumber(String prompt) {
        Pattern pattern = Pattern.compile("[0-9]{8}");
        String localPhoneNumber;

        // First input attempt
        while (true) {
            localPhoneNumber = InputHandler.userInputString(prompt); // e.g., "Input Mail: "
            Matcher matcher = pattern.matcher(localPhoneNumber);
            boolean isValid = matcher.matches();

            if (isValid) {
                return localPhoneNumber; // Return the valid email
            } else {
                System.out.println("Invalid number. Please try again."); // Optional message for invalid input
            }
        }
    }



}

