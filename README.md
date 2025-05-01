# 🛒 `Java` Kiosk Project

## 📌 프로젝트 개요

- Java로 작성된 **콘솔 기반 키오스크**입니다.
- 사용자는 버거, 음료, 디저트 카테고리에서 메뉴를 선택하고 주문할 수 있습니다.
- 각 단계에서 잘못된 입력에 대한 예외 처리를 포함하여 사용자의 흐름을 안내합니다.

---

## 📁 프로젝트 구조

```
v4_2/
├── Main.java         // 프로그램 시작 지점
├── Kiosk.java        // 전체 키오스크 흐름 관리
├── Menu.java         // 카테고리별 메뉴 관리
├── MenuItem.java     // 개별 메뉴 아이템 정보 정의
```

---

## 🔧 클래스 설명

### `Main`
- `main()` 메서드를 통해 `Kiosk` 인스턴스를 실행

### `Kiosk`
- 프로그램의 주요 흐름 제어 클래스입니다.
- 사용자 입력을 통해 카테고리 → 메뉴 아이템 → 주문까지 이동하며, 잘못된 입력에 대한 처리 포함
- 주요 메서드:
  - `start()`: 키오스크 시작 및 카테고리 선택
  - `selectCategory()`: 선택된 카테고리에 따라 메뉴 출력/ 종료/ 예외처리
  - `startItem()`: 아이템 목록 출력 및 선택
  - `selectItem()`: 선택된 메뉴 아이템따라 아이템 주문 / 뒤로가기 /예외처리
  - `order()`: 주문 여부 선택
  - `selectOrder()`: 주문 확정 또는 뒤로가기 처리
  - `exit()`: 종료 또는 뒤로가기 처리

### `Menu`
- 메뉴를 **카테고리별**로 그룹화
- `burgers()`, `drinks()`, `desserts()` 메서드를 통해 각각의 메뉴아이템을 세팅

### `MenuItem`
- 개별 메뉴에 대한 정보를 관리
  - 이름 (`name`)
  - 가격 (`price`)
  - 설명 (`description`)

---

## ▶️ 실행 방법

1. `Main` 실행
2. 콘솔에 출력되는 카테고리 중 하나를 선택
3. 선택한 카테고리에서 메뉴를 선택
4. 메뉴를 주문하거나 뒤로가기 옵션을 선택
5. 종료를 원할 경우 카테고리로 돌아가 "0" 입력

```
1. BURGERS
2. DRINKS
3. DESSERTS
0. 종료              |  종료
1
[ BURGERS Menu ]
1. ShackBurger      |  W 6.9  |  토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack       |  W 8.9  |  베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger     |  W 6.9  |  포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger        |  W 5.4  |  비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
3
선택한 메뉴: Cheeseburger W 6.9 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거

Cheeseburger을 주문하시겠습니까?
1. 주문 		 0.뒤로가기
1
주문완료되었습니다.

1. ShackBurger      |  W 6.9  |  토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack       |  W 8.9  |  베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger     |  W 6.9  |  포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger        |  W 5.4  |  비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
0
이전으로 돌아갑니다.
1. BURGERS
2. DRINKS
3. DESSERTS
0. 종료              |  종료
3
[ DESSERTS Menu ]
1. dessert1         |  W 4.0  |  description dessert1
2. dessert2         |  W 5.0  |  description dessert2
3. dessert3         |  W 6.0  |  description dessert3
4. dessert4         |  W 7.0  |  description dessert4
0. 뒤로가기
4
선택한 메뉴: dessert4 W 7.0 description dessert4

dessert4을 주문하시겠습니까?
1. 주문 		 0.뒤로가기
1
주문완료되었습니다.

1. dessert1         |  W 4.0  |  description dessert1
2. dessert2         |  W 5.0  |  description dessert2
3. dessert3         |  W 6.0  |  description dessert3
4. dessert4         |  W 7.0  |  description dessert4
0. 뒤로가기
0
이전으로 돌아갑니다.
1. BURGERS
2. DRINKS
3. DESSERTS
0. 종료              |  종료
0
키오스크를 종료 합니다.
```

---

## 💡 주요 특징

- **입력 예외처리**: 숫자가 아닌 값을 입력하면 예외 처리하여 다시 입력 유도
- **뒤로가기 및 종료 지원**: 각 단계에서 ‘0’ 입력 시 이전 단계 또는 종료
- **수정 용이**: 새로운 메뉴 카테고리 추가 시 `Menu` 클래스에 메서드만 추가하면 됨

---

## ✅ 향후 개선 아이디어

- 장바구니 -> 주문으로 한꺼번에 주문하기 기능 만들기
