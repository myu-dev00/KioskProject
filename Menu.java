package v4_2;

import java.util.ArrayList;
import java.util.List;

public class Menu { //메뉴아이템을 관리할 메뉴 클래스(큰 카테고리 별로 묶인다)
    //
    private final String category;//메뉴를 묶을 카테고리
    private final List<MenuItem> menuItems = new ArrayList<>();//카테고리별 메뉴가 들어가도록 만들 메뉴아이템 리스트


    public Menu(String category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }

    //메뉴별 메서드를 만듦. Kiosk의 setMenu메서드를 통하여 각 카테고리 별로 menuItems리스트가 들어감.

    public void burgers() {
        menuItems.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

    }

    public void drinks() {
        menuItems.add(new MenuItem("drink1", "W 3.0", "description drink1"));
        menuItems.add(new MenuItem("drink2", "W 3.0", "description drink2"));
        menuItems.add(new MenuItem("drink3", "W 3.0", "description drink3"));
        menuItems.add(new MenuItem("drink4", "W 3.0", "description drink4"));
    }

    public void desserts() {
        menuItems.add(new MenuItem("dessert1", "W 4.0", "description dessert1"));
        menuItems.add(new MenuItem("dessert2", "W 5.0", "description dessert2"));
        menuItems.add(new MenuItem("dessert3", "W 6.0", "description dessert3"));
        menuItems.add(new MenuItem("dessert4", "W 7.0", "description dessert4"));
    }
}
