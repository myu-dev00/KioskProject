package v1;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
        System.out.println("[ SHAKESHACK MENU ]\n" +
                "1.    |  | \n" +
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                "4. Hamburger     | W 5.4 | c\n" +
                "0. 종료      | 종료");

            String Str = sc.nextLine();

            if(Str.isEmpty()) {
                System.out.println("빈칸을 입력하지 말란 말이다");
                continue;
            }

            switch (Str) {
                case "1":
                    System.out.println("쉑쉑 쉑버걸티비");
                    break;
                case "2":
                    System.out.println("쉑쉑 스모크버걸티비");
                    break;
                case "3":
                    System.out.println("쉑쉑 치즈버걸티비");
                    break;
                case "4":
                    System.out.println("쉑쉑 치즈버걸티비");
                    break;
                case "0":
                    System.out.println("종료한다? 빠빠");
                    flag = false;
                    break;
                default:
                    System.out.println("0~4으로 입력하라고 짜식아");
            }
        }
    }
}
