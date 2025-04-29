package v1_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        int intItem = -1;
        while (start) {
            String item = null;

            while (item == null) {
                System.out.println("[ SHAKESHACK MENU ]");
                System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                        "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                        "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                        "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                        "0. 종료      | 종료");
                item = sc.nextLine();
            }
            //숫자 외 다른 것 입력시 NumberFormatException 발생
            //try-catch문으로 예외처리 완료
            try {
                intItem = Integer.parseInt(item);
            } catch (NumberFormatException e){
                System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
                continue;
            }


            switch (intItem) {
                case 1:
                    System.out.println("ShackBurger를 고르셨습니다.");
                    break;
                case 2:
                    System.out.println("SmokeShack을 고르셨습니다.");
                    break;
                case 3:
                    System.out.println("Cheeseburger를 고르셨습니다.");
                    break;
                case 4:
                    System.out.println("Hamburger를 고르셨습니다.");
                    break;
                case 0:
                    System.out.println("프로그램이 종료됩니다.");
                    start = false;
                    break;
                default:
                    System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
            }
        }
    }
}