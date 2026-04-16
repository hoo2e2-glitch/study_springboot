package com.app.controller.domain.vo;
//1. Query(원하는 데이터 조회) - db
//2. VO 또는 DTO를 설계
//3. Config 설정
//4. mapper.xml 정의
//5. Mapper 인터페이스(xml의 id와 메서드의 이름이 동일)
//6. DAO(단일객체는 Optional, 이름 준수)
//7. Service 인터페이스(확장성)
//8. Service Implements(트랜잭션, 예외처리, 서비스이름이 들어나도록)
//9. Test(단위 테스트)
//10. API(Rest)

//  게시판 관련 서비스

//- 게시글 목록 조회 서비스
//- 게시글 상세보기 조회 서비스
//- 게시글 작성 서비스
//- 게시글 수정 서비스
//- 게시글 삭제 서비스
//- 게시글 삭제(탈퇴시) 서비스

//* Swagger 문서 정의
//* RestController로 정의(RESTful)
//* Swagger 테스트 완료!
//* 적절한 Exception throw(Service단)
//* 적절한 Optional(Repository단)
//* 적절한 DTO를 설계