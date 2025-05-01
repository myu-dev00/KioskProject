package v4_2;

public class MenuItem { //각 메뉴 아이템의 정보가 담겨있음
    //속성
    private final String name;
    private final String price;
    private final String description;

    //생성자
    public MenuItem(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //기능 (getter)
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}