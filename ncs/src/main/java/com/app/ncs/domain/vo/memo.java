
//3. 아래 요구 사항에 따라 코드를 작성하세요.
//
//        1) ncs프로젝트를 구성하고, Spring boot, Mybatis를 활용한 Configuration 파일을 설정하세요.
//2) 컨트롤러 클래스는 com.app.ncs.controller 패키지에 있으며, 파일명은 MemberController.java입니다.
//3) Mapper는 인터페이스를 사용하고 패키지는 com.app.ncs.mapper에 둡니다.
//
//        4) resources 하위 폴더에 memberMapper.xml로 쿼리를 분리하고 유지보수성을 올려야합니다.

//[기능 요구 사항]
//        - Session을 활용한 회원 관리 서비스를 완성하세요.

//[공통 요구 사항]
//        -각 필드는 유효성 검사를 필히 진행해야한다(타임리프, 자바스크립트의 유효성 검사)
//        [Member 테이블]
//이름: TBL_MEMBER
//필드: 아이디(ID), 이메일(MEMBER_EMAIL), 비밀번호(MEMBER_PASSWORD), 이름(MEMBER_NAME)
//        - 각 속성에 알맞는 타입 부여한다.

//[세부 요구 사항]
//        1. 회원 가입(/members/join)
//- 각 회원 정보를 입력받고 요청경로(/members/join)를 처리하는 컨트롤러로 POST 요청을 통해 데이터를 전달하여
//members/join.html로 포워드 된다.
//- 회원의 정보를 입력하고 회원 가입 버튼을 누르면 DB에 회원의 정보가 추가된다.
//- 요청이 완료되면 /members/login로 리다이렉트로 응답한다.
//
//2. 로그인(/members/login)
//- 각 회원 정보를 입력받고 요청경로(/members/login)를 처리하는 컨트롤러로 POST 요청을 통해 데이터를 전달하여
//members/login.html로 포워드 된다.
//- 이메일과 패스워드가 일치하는 회원의 정보를 찾아 세션에 저장한다.
//        - 세션의 정보를 활용하여 로그인한 유저를 식별할 수 있어야 한다.
//- 요청이 완료되면 /members/my-page로 리다이렉트로 응답한다.
//
//3. 마이 페이지(/members/my-page)
//- 회원의 정보를 모두 출력한다.
//ex)
//이메일: OOO
//이름: OOO
//
//- 마이페이지는 회원 수정, 로그 아웃, 회원 탈퇴에 대한 버튼이 3개 존재해야하며
//각각 요청에 맞는 로직이 수행되어야 한다.
//
//        4. 회원 수정(/members/update)
//- /members/update.html로 포워드 된다.
//- 기존의 회원 정보들이 모두 input의 기존 value에 담기며,
//수정완료 버튼을 누르면 요청이 (/members/update)의 POST요청을 통해
//유저의 정보가 갱신되며, (/members/my-page)로 이동하고 마이페이지에서는 수정된 유저의 정보를 출력한다.
//
//5. 로그 아웃
//- 요청(/members/logout)의 경로로 POST 요청을 보내고
//기존의 로그인된 유저가 로그아웃 처리되며, 컨트롤러를 통해 (/members/login)으로 리다이렉트 된다.
//
//        6. 회원 탈퇴
//- 요청(/members/withdraw)의 경로로 POST 요청을 보내고
//기존의 회원의 정보가 삭제되며, 동시에 로그아웃 처리가 된다.
//        컨트롤러를 통해 (/members/join)으로 리다이렉트 된다.
//
//        ====================수고하셨습니다====================

