public class Calculator {
    //складываем
    public void addition(String a, String b) {
        String result = String.format("\"%s%s\"", a, b);
        System.out.println(result);
    }

    public void subtract(String a, String b) {
        String result;
        if (a.contains(b)) {
            result = a.replace(b, "");
        } else {
            result = a;
        }
        System.out.println(String.format("\"%s\"", result));
    }

    public void multiplication(String a, String b) {

        int Multiplicator = (int) Double.parseDouble(b);
        if (Multiplicator > 10 || Multiplicator < 1) try {
            throw new NumberMoreOrLessThen10();

        } catch (NumberMoreOrLessThen10 e) {
            System.out.println("Второй аргумент должен быть числом от ноля до 10");
            System.exit(1);
        }
        String result = a.repeat(Multiplicator);
        if (result.length() > 40) {
            result = result.substring(0, 40);
            result = String.format("\"%s...\"", result);
            System.out.println(result);
        } else {
            System.out.println(String.format("\"%s\"", result));
        }

    }

    public void division(String a, String b) {
        int divider = (int) Double.parseDouble(b);
        if (divider > 10 || divider < 1) try {
            throw new NumberMoreOrLessThen10();

        } catch (NumberMoreOrLessThen10 e) {
            System.out.println("Второй аргумент должен быть числом от ноля до 10");
            System.exit(1);
        }
        int resultDivision = a.length() / divider;
        String result = a.substring(0, resultDivision);
        System.out.println(String.format("\"%s\"", result));


    }


    public void calculate(char c) {

        switch (c) {
            case '+':
                addition(Main.firstPart, Main.secondPart);
                break;
            case '-':
                subtract(Main.firstPart, Main.secondPart);
                break;

            case '*':
                multiplication(Main.firstPart, Main.secondPart);
                break;

            case '/':
                division(Main.firstPart, Main.secondPart);
                break;
        }
    }
}
