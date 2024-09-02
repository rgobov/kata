import java.security.PublicKey;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Принимаем строку
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll(" ", "");

        return input;
    }

    // Присваиваем переменной array, массив символов
    public static void getChars(String string) {
        array = string.toCharArray();
    }

    // Объявляем массив char
    public static char[] array;
    // Объявляем переменную для знака операции
    public static char operation;

    // Объявляем строку для первой части сложения-вычитания
    public static String firstPart;
    // Объявляем строку для второй части сложения-вычитания
    public static String secondPart;

    // Определяем знак операации.
    public static void getOperation() {
        for (char c : array) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operation = c;
            }
        }
    }

    // получаем превую и вторую часть строки
    public static void getParts(String phrase) throws NoSuchOperationException, StringMoreThen10 {
        String[] simbolsOfOperation = {"+",
                "-", "*", "/"};
        boolean isoperation = false;
        for (String c : simbolsOfOperation) {
            if (phrase.contains(c)) {
                if (c.equals(simbolsOfOperation[0]) || c.equals(simbolsOfOperation[1])) {
                    int index = phrase.indexOf(c);
                    firstPart = phrase.substring(1, index - 1);
                    secondPart = phrase.substring(index + 2, phrase.length() - 1);
                    isoperation = true;
                    break;
                }
                if (c.equals(simbolsOfOperation[2]) || c.equals(simbolsOfOperation[3])) {
                    int index = phrase.indexOf(c);
                    firstPart = phrase.substring(1, index - 1);
                    secondPart = phrase.substring(index + 1);
                    isoperation = true;
                    break;
                }
            }


        }

        if (!isoperation) {
            throw new NoSuchOperationException("Нет допустимой операции");
        }
        if (firstPart.length() + secondPart.length() > 20) {
            throw new StringMoreThen10("Длинна аргумента больше 10знаков");
        }
        if (firstPart.length()>10 || secondPart.length()>10){
            throw new StringMoreThen10("строка не может быть длинее 10 знаков ");
        }

    }

    public static void IsDigit(String a) throws FirstStringMustBeString {
        boolean digit = false;
        for (char c : a.toCharArray()) {
            if (Character.isDigit(c)) {
                digit = true;
            } else {
                digit = false;
            }
        }
        if (digit) throw new FirstStringMustBeString("Первый аргумент должен быть строкой");
    }

    public static void main(String[] args) throws NoSuchOperationException, StringMoreThen10, FirstStringMustBeString {
        Calculator calculator = new Calculator();
        String inputSting = getString();
        getChars(inputSting);
        getOperation();
        getParts(inputSting);
        IsDigit(firstPart);

        calculator.calculate(operation);


    }
}
