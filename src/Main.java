import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParseConsole.ParseChoise();
    }
}

class ParseConsole {
    static Scanner in = new Scanner(System.in);

    static void ParseChoise() {
        System.out.println("Введите путь к файлу");
        File file = new File(in.nextLine());
        boolean isTrue = true;
        System.out.print("""
                Введите 1 для парсинга с помощью SAX
                Введите 2 для парсинга с помощью DOM
                """);
        try {
            while (isTrue) {
                int numberChoise = in.nextInt();
                if (numberChoise > 0 && numberChoise < 3) {
                    System.out.println("Вы ввели: " + numberChoise);
                    isTrue = false;
                } else {
                    System.out.println("Неправильно введено число");
                }
                switch (numberChoise) {
                    case 1:
                        MySaxHandler.readXML(String.valueOf(file));
                        break;
                    case 2:
                        MyDomHandler.readXml(String.valueOf(file));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка,проверьте данные и попробуйте еще раз");
        }
    }
}
