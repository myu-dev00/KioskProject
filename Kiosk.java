package v4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    //
    private Scanner sc = new Scanner(System.in); //사용자 입력 담당
    private final List<Menu> menus = new ArrayList<>(); //카테고리를 menus라는 리스트에 넣어 관리
    private boolean start = true; // 키오스크의 각 기능 시작 및 종료를 담당함.

    //category 만들기
    private final Menu burgers = new Menu("BURGERS"); //버거 메뉴 세팅
    private final Menu drinks = new Menu("DRINKS"); //음료 메뉴 세팅
    private final Menu desserts = new Menu("DESSERTS"); //디저트 메뉴 세팅

    //


    //

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
    //입력받은 카테고리는 selectCategory 메서드에서 확인
    //selectCategory에서 반환한 값을 통하여 메서드 종료 or 반복을 정함.
    public void start() { //// 입출력
        setMenu();
        int intCategory;
        while (start) {
            String category = null; //입력 받기 전임을 구분하기 위하여 null로 초기화
            int idx = 0; //메뉴 선택 항목을 만들기 위하여 인덱스 설정
            while (category == null) { // 입력 받기 전이라면, 반복문 반복
                for (Menu menu : menus) {
                    System.out.printf("%d. %s\n", ++idx, menu.getCategory()); //카테고리 출력
                }
                System.out.printf("0. %-14s  |  종료\n", "종료"); // 카테고리 전체 출력 후 종료문 출력
                category = sc.nextLine(); //사용자에게 입력 받음
            }
            try {
                intCategory = Integer.parseInt(category); //메뉴 입력은 1~n까지의 정수이므로 문자열을 정수로 변경
            } catch (NumberFormatException e) {//정수형이 아니면 예외처리
                //예외처리하고 while문 처음부터 다시시작
                System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
                continue;
            }
            start = selectCategory(Integer.parseInt(category)); //0 반환시 주문 종료, 아닐시 재출력
        }
    }

    //입력받은 카테고리를 바탕으로 유저가 옳게 입력시 메뉴 선택 시작 메서드 startItem으로 이동
    //0 입력시 종료, 그외 오류문 출력
    private boolean selectCategory(int category) { //입력받은 수가 카테고리 내에 있으면 메뉴를 받는 곳으로 이동하고 start메서드가 꺼지지 않고 반복됨.
        if (0 < category && category <= menus.size()) { //카테고리를 입력 받으면
            System.out.println("[ " + menus.get(category - 1).getCategory() + " Menu ]");
            startItem(menus.get(category - 1)); //아이템 관리 메서드로 이동
            return true; //
        } else if (category == 0) { //0 (종료) 입력받을시, start변수가 false가 되고 메서드 종료됨.
            return exit(1);
        } else { //잘못된 범위 입력 받을시 start메서드 재출력을 통해 다시 입력 받음.
            System.out.println("잘못입력하셨습니다. 카테고리에 맞는 번호를 입력 부탁드립니다.");
            return true;
        }
    }

    //메뉴아이템 고르기 시작 메서드 - 카테고리를 매게로 입력받아 카테고리에 맞는 메뉴 출력하고 유저가 원하는 메뉴를 입력받음.
    //입력받은 메뉴는 selectItem 메서드에서 확인
    //selectItem에서 반환한 값을 통하여 메서드 종료 or 반복을 정함.
    //start()와 구현이 같음
    private void startItem(Menu menu) {
        int intmenu;
        while (start) {
            String item = null;
            int idx = 0;
            while (item == null) {
                for (MenuItem menuItem : menu.getMenuItems()) { //메뉴아이템 출력
                    System.out.printf("%d. %-15s  |  %-4s  |  %s\n", ++idx, menuItem.getName(), menuItem.getPrice(),
                            menuItem.getDescription());
                }
                System.out.println("0. 뒤로가기"); //종료 대신 0을 입력 받으면 카테고리로 이동
                item = sc.nextLine();
            }
            try {
                intmenu = Integer.parseInt(item);
            } catch (NumberFormatException e) {
                System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
                continue;
            }
            start = selectItem(Integer.parseInt(item), menu); //메뉴 아이템이 들어간 list와 입력한 수가 들어감.
        }
    }

    // 입력받은 카테고리를 바탕으로 유저가 옳게 입력시 주문 메서드 order로 이동
    // 0 입력시 뒤로 가기, 그 외 오류문 출력
    // startCartegory와 구현이 같음
    private boolean selectItem(int item, Menu menu) {
        if (0 < item && item <= menu.getMenuItems().size()) { //메뉴
            System.out.println("선택한 메뉴: " + menu.getMenuItems().get(item - 1).getName() + " "
                    + menu.getMenuItems().get(item - 1).getPrice() + " " + menu.getMenuItems().get(item - 1).getDescription() + "\n");
            order(menu.getMenuItems().get(item-1)); //옳은 메뉴 선택시 주문 창으로 이동
            return true;
        } else if (item == 0) { //0 입력시 뒤로가기가 됨
            return exit(2); //뒤로가기 출력 및 false 반환문 (startItem메서드가 종료되고 상위인 selectCategory로 이동)
        } else {
            System.out.println("잘못 입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
            return true;
        }
    }

    //오더 메서드 - 메뉴아이템을 매게로 입력받아 오더를 할지 뒤로갈지를 입력받음.
    //입력받은 메뉴는 selectOrder 메서드에서 확인
    //selectOrder에서 반환한 값을 통하여 메서드 종료 or 반복을 정함.
    //start()와 구현이 같음
    private void order(MenuItem menuItem){
        int intorder;
        while (start) {
            String order = null;
            while (order == null) {
                System.out.println(menuItem.getName()+"을 주문하시겠습니까?");
                System.out.println("1. 주문 \t\t 0.뒤로가기");
                order = sc.nextLine();
            }
            try {
                intorder = Integer.parseInt(order);
            } catch (NumberFormatException e) {
                System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
                continue;
            }
            start = selectOrder(intorder);
        }
    }

    // 입력받은 카테고리를 바탕으로 유저가 옳게 입력시 주문되거나 주문 취소됨.
    // 0 입력시 뒤로 가기, 그 외 오류문 출력
    // startCartegory와 구현이 같음
    private boolean selectOrder(int order){
        if(order == 1) {
            System.out.println("주문완료되었습니다.\n");
            return false; //false가 입력되어 order가 종료되고 상위 메서드인 seletItem으로 이동
        }
        else if(order == 0)
            return exit(2); //뒤로가기 출력 및 order 종료
        else { //잘못된 입력시 order 재출력
            System.out.println("잘못입력하셨습니다. 메뉴에 맞는 번호를 입력 부탁드립니다.");
            return true;
        }
    }

    private boolean exit(int exitNum) {
        if (exitNum == 1) System.out.println("키오스크를 종료 합니다."); // 종료될시 필요한 출력문
        else if (exitNum == 2) System.out.println("이전으로 돌아갑니다."); //뒤로가기 시 필요한 출력문
        return false;
    }
}
