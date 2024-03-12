package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

/* 필기.
 *   Controller 의 역할
 *   view 즉 현재는 Application 에서 사용자가 입력한 정보를 파라미터 형태로 전달을 받으면
 *   전달 받은 값들을 검증하거나 추가적인 정보가 필요한 경우 가공을 한 뒤,
 *   service 쪽으로 전달하기 위한 인스턴스를 담고 서비스의 비즈니스 로직을 담당하는 method 를 호출한다.
 *   또한 호출한 수행 결과를 반환 받아 어떠한 뷰를 다시 사용자에게 보여줄 것인지를 결정하는 역할을 한다.
 * */
public class MenuController {

    private final MenuService menuService;       // 생성자를 통한 초기화. 혼용을 막기 위한 final
    private final PrintResult printResult;

    public MenuController() {
        this.menuService = new MenuService();       // 클래스 초기화
        this.printResult = new PrintResult();
    }

    public void deleteMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        if (menuService.deleteMenu(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }

    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();       // MenuDTO 로 자료형을 맞춰 줌.

        if (menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void selectMenuByCode(Map<String, String> parameter) {

        // 사용자가 String 타입으로 입력 한 값을 서버 측에서 int 로 파싱
        int code = Integer.parseInt(parameter.get("code"));     // 키 값 "code" 입력

        MenuDTO menu = menuService.selectMenuByCode(code);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void registMenu(Map<String, String> parameter) {     // 키 값, 밸류값

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public void modifyMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }

    }

}
