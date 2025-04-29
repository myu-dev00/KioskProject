package v3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//- [ ]  키오스크 프로그램을 시작하는 메서드가 구현되어야 합니다.
//        - [ ]  콘솔에 햄버거 메뉴를 출력합니다.
//        - [ ]  사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료합니다.
//        - [ ]  유효하지 않은 입력에 대해 오류 메시지를 출력합니다.
//        - [ ]  `0`을 입력하면 프로그램이 ‘뒤로가기’되거나 ‘종료’됩니다.


public class Kiosk {
    //
    private Scanner sc = new Scanner(System.in);
    private List<MenuItem> menuItems = new ArrayList<>();
    private MenuItem menuItem;
    //

    //
    private void items() {
        menuItems.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start(boolean start) { //입출력
        items();
        while (start) {
            String item = "";
            int idx = 0;
            while (item.isEmpty()) { // 여쭤 볼것- null과 ""중에 어느게 더좋을까요?
                for (MenuItem menuItem : menuItems) {
                    System.out.printf("%d. %-15s  |  %-4s  |  %s\n", ++idx, menuItem.getName(), menuItem.getPrice(), menuItem.getExplain());
                }
                System.out.printf("0. %-14s  |  종료\n", "종료");
                item = sc.nextLine();
            }
            int itemNum = Integer.parseInt(item);
            start = selectMenu(itemNum);
        }
    }

    private boolean selectMenu(int itemNum) {
        if (0 < itemNum && itemNum <= menuItems.size()) {
            System.out.println("선택한 메뉴: " + menuItems.get(itemNum - 1).getName() + " " + menuItems.get(itemNum - 1).getPrice()
                    + " " + menuItems.get(itemNum - 1).getExplain());
            return true;
        } else if (itemNum == 0) {
            return exit();
        } else {
            System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
            return true;
        }
    }

    private boolean exit() {
        System.out.println("종료 혹은, 이전으로 돌아갑니다.");
        return false;
    }
}
