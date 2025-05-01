package v4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {
    //
    private final String category;
    private final List<MenuItem> menuItems = new ArrayList<>();
//    private MenuItem menuItem;

    public Menu(String category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }


    public String getCategory() {
        return category;
    }

    public void burgers() {
        menuItems.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

    }

    public void drinks() {
        menuItems.add(new MenuItem("drink1", "W 0.0", "description"));
        menuItems.add(new MenuItem("drink2", "W 0.0", "description"));
        menuItems.add(new MenuItem("drink3", "W 0.0", "description"));
        menuItems.add(new MenuItem("drink4", "W 0.0", "description"));
    }

    public void desserts() {
        menuItems.add(new MenuItem("dessert1", "W 0.0", ""));
        menuItems.add(new MenuItem("dessert2", "W 0.0", ""));
        menuItems.add(new MenuItem("dessert3", "W 0.0", ""));
        menuItems.add(new MenuItem("dessert4", "W 0.0", ""));
    }
}
