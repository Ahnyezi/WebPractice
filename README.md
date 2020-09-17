
# 쇼핑몰 웹사이트

## 사용한 skill 및 지식
- Java
- Spring Framework
- MyBatis Framework
- jQuery
- HTML
- JSP
- Oracle DB
- Apache Tomcat

<br>

## 목차
1. [서비스 개요](#1-서비스-개요)
2. [주요 기능](#2-주요-기능)
3. [판매자 기능](#3-판매자-기능)
4. [구매자 기능](#4-구매자-기능)

<br><br>


## 1. 서비스 개요
 Spring과 MyBatis를 이용해서 쇼핑몰 웹사이트 기능을 구현해보았습니다. <br>
 클라이언트를 판매자와 구매자로 나누어, 클라이언트 종류별로 기능을 달리하였습니다. <br>
 상세 기능은 아래와 같습니다.
 <br>


## 2. 주요 기능

#### 판매자 기능
- 회원가입
- 로그인
- 판매물품 등록
- 내 물품 목록 보기
- 내 물품 수정/삭제 

#### 구매자 기능
- 회원가입
- 로그인
- 판매 물품 목록 보기
- 주문하기
- 주문목록 확인(즉시구매, 장바구니)


<br>

## 3. 판매자 기능
#### 1) 회원가입 <br>
<img src="https://user-images.githubusercontent.com/62331803/93437331-d06ac680-f906-11ea-9cbb-3232dada8dce.png" width="70%"> <br>

- ajax 요청을 통해 아이디 중복여부 즉시 출력
- SELLER로 회원가입
<br>

#### 2) 판매자로 로그인<br>
<img src="https://user-images.githubusercontent.com/62331803/93447943-fa73b700-f90d-11ea-973b-a361b8f3d6e5.png" width="70%">
<br>

#### 3) 상품 등록<br>
<img src="https://user-images.githubusercontent.com/62331803/93450264-bafa9a00-f910-11ea-99f7-db5935caa74e.png" width="70%"><br>

- 상품이름, 가격 , 수량, 상세설명, 사진 등록 

<br>

#### 4) 나의 판매물품 목록 보기<br>
<img src="https://user-images.githubusercontent.com/62331803/93450317-cb127980-f910-11ea-80ee-f2149f6e2292.png" width="70%">
<br>

####  5) 물품 상세페이지<br>
<img src="https://user-images.githubusercontent.com/62331803/93450406-e5e4ee00-f910-11ea-8b5a-119770e23a34.png" width="50%">
<br>

####  6) 내 물품 수정 <br>
<img src="https://user-images.githubusercontent.com/62331803/93450744-4a07b200-f911-11ea-836c-95bd058c7284.png" width="50%"><br>
- 상품 가격과 상세설명 수정
<br>

####  6) 삭제 후 확인<br>
<img src="https://user-images.githubusercontent.com/62331803/93450868-702d5200-f911-11ea-8910-7f880b0d651b.png" width="70%">

<br><br>

## 4. 구매자 기능
#### 1) 구매자로 회원가입 <br>
<img src="https://user-images.githubusercontent.com/62331803/93453645-e3849300-f914-11ea-8b83-963efad6a76c.png" width="70%"><br>

- CONSUMER로 회원가입

 <br>
 
#### 2) 로그인 <br>
<img src="https://user-images.githubusercontent.com/62331803/93453701-f72ff980-f914-11ea-97f3-1171271f4e41.png" width="70%"><br>
 <br>

#### 3) 현재 판매되고 있는 목록 보기<br>
<img src="https://user-images.githubusercontent.com/62331803/93453776-1038aa80-f915-11ea-9f91-4e938dab87ba.png" width="70%"><br>
<br>

#### 4) 판매자명으로 검색<br>
<img src="https://user-images.githubusercontent.com/62331803/93453990-4ece6500-f915-11ea-8b0b-51eda0f57bbd.png" width="70%"><br>

- 판매자명 yeji1220으로 검색

<br>

#### 5) 상품명으로 검색<br>
<img src="https://user-images.githubusercontent.com/62331803/93453896-352d1d80-f915-11ea-8d63-d8788f22a5c9.png" width="70%"><br>

- 상품명  ipad로 검색

<br>

#### 6) 주문하기<br>
<img src="https://user-images.githubusercontent.com/62331803/93454509-12e7cf80-f916-11ea-8178-ebc8ba09ffdf.png" width="50%"><br>

- 구매 수량, 결제 유형 선택하여 주문


#### 7) 내 주문목록 확인
- 즉시결제 목록<br>
<img src="https://user-images.githubusercontent.com/62331803/93454609-2e52da80-f916-11ea-9f96-e902b4de82cf.png" width="70%"><br>


- 장바구니 목록<br>
<img src="https://user-images.githubusercontent.com/62331803/93454680-432f6e00-f916-11ea-8196-82350edbe62c.png" width="70%"><br>



<br>
