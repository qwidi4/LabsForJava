package programming.lab1;


import java.util.Scanner;
class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Food[] breakfast = new Food[20];
        for (int i = 0; i < 20; i++) {
            System.out.println("Введите блюдо");
            String food = scanner.nextLine();
            if (food.equals("сыр")) {
                breakfast[i] = new Cheese();
            } else if (food.equals("яблоко/большое")) {
                breakfast[i] = new Apple("большое");
            } else if (food.equals("яблоко/маленькое")) {
                breakfast[i] = new Apple("маленькое");
            } else if (food.equals("Пирог/Яблочный")) {
                breakfast[i] = new Pie("Яблочный");
            } else if (food.equals("Пирог/Вишнёвый")) {
                breakfast[i] = new Pie("Вишнёвый");
            }  else break;
        }

        int apple_counter=0;
        int cheese_counter=0;
        int pie_counter=0;
        for (int i = 0; i < 20; i++) {
            if(breakfast[i]  instanceof Apple) {
                apple_counter++;
            } else if(breakfast[i]  instanceof Cheese ) {
                cheese_counter++;
            } else if(breakfast[i]  instanceof Pie) {
                pie_counter++;
            }
        }
        System.out.println("CЫР - " +cheese_counter );
        System.out.println("ЯБЛОКО - " +apple_counter );
        System.out.println("ПИРОГ - " + pie_counter);
    }

}

