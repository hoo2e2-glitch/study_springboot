package com.app.dependency.qualifier;


//Resturant
//Outback
//Vips
//
//1. 세 객체를 선언한 뒤 상속 관계를 판단하여 하나의 객체를 인터페이스로 선언한다.
//2. 각 레스토랑에 샐러드바 이용 가능 여부와 스테이크 가격을 필드로 구성한다.
//        3. 스테이크 가격은 항상 똑같지만, 각 레스토랑에서 변경이 가능하다.
//
//
//*4. 기본 레스토랑은 아웃백으로 설정한다.
public interface  Resturant {
    public boolean isSaladbar();
    public int steakPrice();
//    public int steakPrice = 50000;

}
