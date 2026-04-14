| 주제 | 아주 쉬운 뜻 | 오늘 겪은 증상 | 어떻게 해결했는지 |
|---|---|---|---|
| GET / POST | GET은 화면 보기, POST는 처리(저장/수정/삭제) | 405 Method Not Allowed | URL은 맞는데 메서드가 틀렸던 것. 화면은 GET, 처리 URL은 POST로 분리 |
| 404 / 405 차이 | 404는 주소 없음, 405는 메서드 틀림 | /members/delete 404, 로그인 URL 405 | 컨트롤러 매핑 확인 + 폼 method="post" 맞춤 |
| 매핑 충돌 | 같은 URL+같은 메서드 2개 만들면 충돌 | Ambiguous mapping | join/delete 경로를 다르게 분리 |
| Redirect | 처리 후 다른 주소로 이동 | 로그인/회원가입 후 화면 전환 필요 | return "redirect:/members/login" 사용 |
| Thymeleaf 출력 | 서버 데이터를 HTML에 보여주는 템플릿 | 리스트가 테이블에 안 나옴 | model.addAttribute + th:each를 tr에 적용 |
| parameterType | DB에 보내는 값 타입 | SELECT에서 헷갈림 | INSERT/UPDATE에서 주로 사용 |
| resultType | DB에서 받는 값 타입 | SELECT 결과 매핑 안 됨 | SELECT에 resultType="...PostVO" 지정 |
| Optional | 값이 있을 수도/없을 수도 안전하게 표현 | 로그인 조회 결과 처리 | isPresent()로 확인 후 세션 저장 |
| Session | 로그인 사용자 정보를 잠깐 저장 | 마이페이지에서 사용자 정보 필요 | session.setAttribute("member", found) / 로그아웃 시 invalidate() |
| ORA-00001 | 중복 금지 값 중복(UNIQUE/PK) | 테스트 INSERT 실패 | 중복 안 나는 값 사용 |
| ORA-02291 | 부모키 없음(FK 위반) | 게시글 등록 시 회원 FK 에러 | 존재하는 member_id로 insert (로그인 사용자 id 사용) |
| 리스트/상세 분리 | 목록과 단건 조회는 URL 분리 | list에서 단건 조회함 | GET /posts/list(목록), GET /posts/detail?id=(단건) |
