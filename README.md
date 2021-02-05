Springboot, JPA를 이용한 게시판 만들기
=======
목차
- [프로젝트 소개](#프로젝트-소개)
- [프로젝트 사용기술 및 계획](#프로젝트-사용기술-및-계획)
- [메인페이지](#메인페이지)
- [주요 기능 및 설명](#주요-기능-및-설명)
- [마치며](#마치며)


프로젝트 소개
--------
springboot 사용방법을 익히기 위해 만든 프로젝트입니다.


프로젝트 사용기술 및 계획
-------
- 프로그래밍 언어 : JAVA 1.8

- IDE : Spring tool suite 4

- 프레임워크 : Spring 

- 서버 : Apache Tomcat

- DB : MySQL

- API : KAKAO API

---------
- 계획
1. user정보와 게시판에 필요한 컬럼을 정하기
2. 어떤 기능을 추가할지 정하기
3. 디자인 만들기
4. 기능을 추가해 구현하기
5. 마무리로 코드를 가독성 좋게 정리하기 

메인페이지
------
![스크린샷(49)](https://user-images.githubusercontent.com/67408846/103733201-83813c00-502c-11eb-83fc-2f258253aaa4.png)
- 메뉴버튼(로그인) 
1. 글쓰기
2. 회원정보
3. 로그아웃

- 메뉴버튼(비로그인) 
1. 로그인
2. 회원가입

- 게시글
1. 비로그인 상태로 상세보기 클릭시 로그인 창으로 넘어가짐
2. 게시물을 한페이지에 3개까지만 보여짐(@PageableDefault) 

-------
주요 기능 및 설명
--------
![스크린샷(50)](https://user-images.githubusercontent.com/67408846/103733316-d4913000-502c-11eb-8f4d-3af0a0d25ce9.png)
-----
- 회원가입
 1. 이름, 비밀번호, 이메일을 입력해서 회원가입을 진행 할 수 있습니다.
 2. 아이디는 중복이 불가합니다.
 3. 3개 중에 하나라도 입력을 안하면 경고창이 뜬다.
-----
![스크린샷(51)](https://user-images.githubusercontent.com/67408846/103734091-8bda7680-502e-11eb-8497-7ca738fc8156.png)
-----
- 로그인
 1. 사용자 아이디와 비밀번호를 이용해 로그인이 가능합니다.
 2. 카카오 로그인이 가능합니다.(OAuth2.0 사용)

-----
![스크린샷(52)](https://user-images.githubusercontent.com/67408846/103735374-48353c00-5031-11eb-90da-9056e3bffb23.png)
-----
- 게시판 글등록(썸머노트라이브러리 사용)
 1. 게시글 제목과 내용을 등록 할 수 있습니다.
 2. 로그인이 되어있지 않으면 게시글을 등록할 수 없고 자동으로 로그인페이지로 이동합니다.

-----
![스크린샷(54)](https://user-images.githubusercontent.com/67408846/103735713-ffca4e00-5031-11eb-8af5-d7528b5958f1.png)
-----
- 게시판 상세페이지
 1. 게시글에 내용을 볼 수 있습니다.
 2. 돌아가기, 수정하기, 삭제하기, 댓글등록 버튼이 있습니다.
 3. 수정, 삭제, 댓글삭제 버튼은 자신이 작성한 글만 보여집니다.

-----
![스크린샷(52)](https://user-images.githubusercontent.com/67408846/103735374-48353c00-5031-11eb-90da-9056e3bffb23.png)
-----
- 게시판 글수정
 1. 게시글 제목과 내용을 수정할 수 있습니다.
 2. 본인이 작성하지 않은 글을 수정이 불가능 합니다.

-----
![스크린샷(54)](https://user-images.githubusercontent.com/67408846/103735713-ffca4e00-5031-11eb-8af5-d7528b5958f1.png)
-----
- 게시판 글삭제
 1. 게시글을 지울 수 있습니다.
 2. 본인이 작성하지 않은 글은 삭제가 불가능 합니다.
 

마치며
-----
스프링부트를 처음으로 사용해서 구현한 사이트라서 이것저것 해보고 싶은게 많았습니다.<br/>
아직 알아가는 단계라서 많은 기능을 추가 못해서 아쉬움이 남았습니다.<br/>

-----
