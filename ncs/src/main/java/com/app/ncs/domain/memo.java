//1. Query(원하는 데이터 조회)
//2. VO 또는 DTO를 설계 @Data @component
//3. Config 설정
//4. mapper.xml 정의
// parameterType = DB에 보낼 값 타입
// resultType = DB에서 받을 값 타입
//<!--    조회는 받는값이 중요
//SELECT 결과를 PostVO로 받겠다는 뜻-->
//5. Mapper 인터페이스(xml의 id와 메서드의 이름이 동일) @mapper
//6. DAO(단일객체는 <Optional>, 이름 준수) @Repository @RequierdArgue
//7. Service 인터페이스(확장성)
//8. Service Implements(트랜잭션, throw처리, 예외처리, 서비스이름이 들어나도록)@Service @RequierdArgue @Tran
//9. Test(단위 테스트) @Sl @Spring
//10. API(Rest) @RestCont @ReqieM @Req
//11. apiresponse<T> @data @noArgsC @allArgsC
//  게시판 관련 서비스
//12 exception @data HttpStatus
//13 customexceptionhandler @restController

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

//PostAPI와 MemberAPI를 모두 일관성있는 응답처리

//1. 각각 컨트롤러에 맞는 상태코드
//2. 각각에 알맞는 메세지 또는 데이터 응답처리

// api 설계원칙
// Swagger 문서 정의
// 파라미터
// 알맞는 response dto
// schema

// 정적팩토리 메서드 -> 없어도 됨

// 회원검증 추가제작 / selectkey 사용 / exception / 다 처리
