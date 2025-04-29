package v2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();
        boolean start = true;
        menuItems.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (start) {
            String item = "";

            while (item.isEmpty()) { // 여쭤 볼것- null과 ""중에 어느게 더좋을까요?
                for (MenuItem menuItem : menuItems) {
                    System.out.printf("%-15s  |  %-4s  |  %s\n", menuItem.getName(), menuItem.getPrice(), menuItem.getExplain());
                }
                System.out.printf("%-14s  |  종료\n", "종료");
                item = sc.nextLine();
            }

            int itemNum = Integer.parseInt(item);
            if (0 < itemNum && itemNum <= menuItems.size()) {
                System.out.println("선택한 메뉴: " + menuItems.get(itemNum-1).getName() + " " + menuItems.get(itemNum-1).getPrice()
                        + " " + menuItems.get(itemNum-1).getExplain());
            } else if (itemNum == 0) {
                System.out.println("종료하겠습니다.");
                start = false;
            } else {
                System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
            }
        }
    }
}
