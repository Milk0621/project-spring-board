# Spring Board Project

Spring Framework의 **MVC 아키텍처 실습**을 목적으로 제작한 게시판 프로젝트입니다.  
Controller–Service–DAO 계층을 명확히 나누고, JSP 기반의 View 처리 및 Oracle 데이터베이스 연동을 직접 구성하여  
Spring 기반 웹 애플리케이션의 전체 흐름을 이해하는 데 초점을 맞췄습니다.


---


## 🛠 기술 스택

- **프레임워크**: Spring Framework (Spring MVC)
- **뷰(View)**: JSP + JSTL
- **언어**: Java 11+
- **데이터베이스**: Oracle
- **빌드 도구**: Maven
- **서버**: Apache Tomcat
- **기타**: JDBC, Oracle SQL Developer


---


## 🎯 프로젝트 목표

- Spring MVC 아키텍처의 구조적 이해
- 요청 흐름: `요청 → Controller → Service → DAO → DB → 결과 → View`
- JSP와 세션 객체를 활용한 사용자 인증 및 화면 처리
- Oracle과의 연동을 통해 실무 환경 유사 경험 확보


---


## 📌 핵심 기능

### 📂 게시판 CRUD
- 게시글 **작성 / 조회 / 수정 / 삭제**
- HTTP Method (`GET`, `POST`, `PUT`, `DELETE`)에 따른 컨트롤러 메서드 분리
- JSP 폼과 Controller 간의 데이터 전송 실습

### 🔐 로그인 및 세션 처리
- `session` 객체를 통한 로그인 상태 유지
- 로그인 성공 시 사용자 역할에 따른 접근 제어


---


## 🧱 구조 설계 특징

### ✅ 역할 기반 컨트롤러 분리

- **공통 기능**: 로그인, 로그아웃, 회원가입
- **사용자 기능**: 게시판 열람, 공지사항 확인, 마이페이지
- **관리자 기능**: 사용자 관리, 게시글 전체 관리

> 각 기능은 컨트롤러 및 JSP를 계층적으로 분리하여 관리하며, URL 매핑 전략 설계도 함께 실습


---


## 🗄 Oracle DB 연동

- **테이블 설계**: `USERS`, `BOARD`, `NOTICE`
- **관계형 제약조건**: 기본 키, 외래 키 설계 및 적용
- **JDBC 활용**: Oracle JDBC 드라이버 등록 후 SQL 실행
- **Maven 설정**: 외부 드라이버 의존성 수동 추가


---


## 🎨 JSP 연동 및 뷰 처리

- Controller → JSP 간 데이터 전달 (`request.setAttribute`, `ModelAttribute`)
- JSP 내 데이터 접근: `${param}`, `${sessionScope}`, JSTL `c:forEach` 등
- 게시판 목록 및 상세 페이지 구성 실습


---


## 📝 정리

본 프로젝트는 실무에 자주 등장하는 구조(Oracle + Spring MVC + JSP)를 직접 구성하며  
Spring 기반 웹 시스템의 작동 원리를 **처음부터 끝까지 체험**하는 것을 목표로 합니다.  
단순한 코드 작성보다도 **구조 설계와 흐름 이해에 중점**을 두고 진행하였습니다.
