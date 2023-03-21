import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> romanNumbers = Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "L", "C");
    private static final List<String> signs = Arrays.asList("+", "-", "*", "/");
    private static int integer1 = 0;
    private static int integer2 = 0;
    private static int roman1 = 0;
    private static int roman2 = 0;
    private static int result = 0;


    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            System.out.println(calc(answer));
        }
    }
    public static String calc(String input) throws Exception {
       String[] numbers = input.split(" ");
       if (numbers.length != 3) {
           throw new Exception("Не является математической операцией");
       }
       try {
           integer1 = Integer.parseInt(numbers[0]);
           if (integer1 < 1 || integer1 > 10) {
               throw new Exception("Не подходящее число");
           }
       }
       catch (NumberFormatException e) {
           if (!romanNumbers.contains(numbers[0])) {
               throw new Exception("Не подходящее число");
           }
           roman1 = romanNumbers.indexOf(numbers[0]);
       }
       try {
           integer2 = Integer.parseInt(numbers[2]);
           if (integer2 < 1 || integer2 > 10) {
               throw new Exception("Не подходящее число");
           }
       }
       catch (NumberFormatException e) {
           if (!romanNumbers.contains(numbers[2])) {
               throw new Exception("Не подходящее число");
           }
           roman2 = romanNumbers.indexOf(numbers[2]);
       }
       if (numbers[1].equals("-") && roman2 > roman1) {
           throw new Exception("В римской системе нет отрицательных чисел");
       }
       if (!(integer1 == 0 && integer2 == 0 || roman1 == 0 && roman2 == 0)) {
               throw new Exception("Используются одновременно разные системы счисления");
       }
       if (!signs.contains(numbers[1])) {
            throw new Exception("Не правильная операция");
       }
       switch (numbers[1])  {
           case ("-"):
               if (integer1 == 0 && integer2 == 0) {
                   result = roman1 - roman2;
               }
               else {
                   result = integer1 - integer2;
               }
               break;
           case ("+"):
               if (integer1 == 0 && integer2 == 0){
                   result = roman1 + roman2;
               }
               else {
                   result = integer1 + integer2;
               }
               break;
           case ("*"):
               if (integer1 == 0 && integer2 == 0){
                   result = roman1 * roman2;
               }
               else {
                   result = integer1 * integer2;
               }
               break;
           case ("/"):
               if (integer1 == 0 && integer2 == 0){
                   result = roman1 / roman2;
               }
               else {
                   result = integer1 / integer2;
               }
               break;
       }
       if (roman1 >= 1) {
           if (result > 10) {
               int temp = result / 10;
               int temp1 = result % 10;
               String res = "";
               if (temp <= 3) {
                   for(int i = 0; i < temp; i++) {
                       res+=(romanNumbers.get(10));
                   }
               }
               switch (temp) {
                   case 4:
                       res+=(romanNumbers.get(10));
                       res+=(romanNumbers.get(11));
                       break;
                   case 9:
                       res+=(romanNumbers.get(10));
                       res+=(romanNumbers.get(12));
                       break;
                   case 10:
                       res+=(romanNumbers.get(12));
                       break;
               }
               if (temp >= 5 && temp < 9){
                   res+=(romanNumbers.get(11));
                   for(int i = 0; i < temp-5; i++) {
                       res+=(romanNumbers.get(10));
                   }
               }
               res+=(romanNumbers.get(temp1));
               return res;
           }
           if (result == 0) {
               throw new Exception("В римской системе нет нуля");
           }
           return romanNumbers.get(result);
       }
       return String.valueOf(result);
    }
}