package v4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    //
    private Scanner sc = new Scanner(System.in);
    private final List<Menu> menus = new ArrayList<>();
    boolean start = true;
    //category 만들기
    private final Menu burgers = new Menu("BURGERS");
    private final Menu drinks = new Menu("DRINKS");
    private final Menu desserts = new Menu("DESSERTS");

    //Menu 설정
    private void setMenu() {
        menus.add(burgers);
        menus.add(drinks);
        menus.add(desserts);

        burgers.burgers();
        drinks.drinks();
        desserts.desserts();
    }

    //시작 메서드 - 설정된 메뉴를 불러와 카테고리를 출력하고 유저가 원하는 카테고리를 입력받음.
    //입력받은 카테고리는 selectCategory 메서드에서 확인 후 카테고리에 맞는 메뉴 출력
    public void start() { //// 입출력
        setMenu();
        int intCategory;
        while (start) {
            String category = null;
            int idx = 0;
            while (category == null) {
                for (Menu menu : menus) {
                    System.out.printf("%d. %s\n", ++idx, menu.getCategory());
                }
                System.out.printf("0. %-14s  |  종료\n", "종료");
                category = sc.nextLine();
            }
            try {
                intCategory = Integer.parseInt(category);
            } catch (NumberFormatException e) {
                System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
                continue;
            }
            start = selectCategory(Integer.parseInt(category));
        }
    }

    //입력받은 카테고리를 바탕으로 유저가 옳게 입력시 메뉴 선택 시작 메서드 startItem으로 이동
    //0 입력시 종료, 그외 오류문 출력
    private boolean selectCategory(int category) { //입력받은 수가 범위 입력 받았을시, 그 사잇값 내에 있으면 true false를 반환.
        if (0 < category && category <= menus.size()) {
            System.out.println("[ " + menus.get(category - 1).getCategory() + " Menu ]");
            startItem(menus.get(category - 1));
            return true;
        } else if (category == 0) {
            return exit(1);
        } else {
            System.out.println("잘못입력하셨습니다. 카테고리에 맞는 번호를 입력 부탁드립니다.");
            return true;
        }
    }

    private void startItem(Menu menu) {

        int intmenu;
        while (start) {
            String item = null;
            int idx = 0;
            while (item == null) {
                for (MenuItem menuItem : menu.getMenuItems()) {
                    System.out.printf("%d. %-15s  |  %-4s  |  %s\n", ++idx, menuItem.getName(), menuItem.getPrice(),
                            menuItem.getDescription());
                }
                System.out.println("0. 뒤로가기");
                item = sc.nextLine();
            }
            try {
                intmenu = Integer.parseInt(item);
            } catch (NumberFormatException e) {
                System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
                continue;
            }
            start = selectItem(Integer.parseInt(item), menu);
        }
    }

    private boolean selectItem(int item, Menu menu) {
        if (0 < item && item <= menu.getMenuItems().size()) {
            System.out.println("선택한 메뉴: " + menu.getMenuItems().get(item - 1).getName() + " "
                    + menu.getMenuItems().get(item - 1).getPrice() + " " + menu.getMenuItems().get(item - 1).getDescription() + "\n");
            return false;
        } else if (item == 0) {
            return exit(2);
        } else {
            System.out.println("잘못 입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
            return true;
        }
    }

    private boolean exit(int exitNum) {
        if (exitNum == 1) System.out.println("키오스크를 종료 합니다.");
        else if (exitNum == 2) System.out.println("이전으로 돌아갑니다.");
        return false;
    }
}
