<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body>
		<div id="wrap">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			<section class="contents d-flex justify-content-center">
				<div class="bg-box">
					<div class="join-box my-5">
						<h2 class="text-center">로그인</h2>
						<form id="LoginForm">
							<input type="text" placeholder="ID" id="loginIdInput" class="form-control mt-2"> 
							<input type="password" placeholder="Password" id="passwordInput" class="form-control mt-2">
							<button type="submit" id="loginBtn" class="btn btn-block mt-2">로그인</button>
							<button type="button" id="signUpBtn" class="btn btn-block mt-2">가입하기</button>
						</form>
					</div>
				</div>
			</section>
			<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		</div>
		
		<script>
			$(document).ready(function() {
			
				$("#LoginForm").on("submit", function(e) {
			//	$("#loginBtn").on("click", function() {
				
					// 해당 이벤트의 기능을 모두 취소한다
					e.preventDefault();
				
					let loginId = $("#loginIdInput").val();
					let password = $("#passwordInput").val();
					
					if(loginId == "") {
						alert("아이디를 입력하세요");
						return ;
					}
					
					if(password == "") {
						alert("비밀번호를 입력하세요");
						return ;
						
					}
					
					$.ajax({
						type:"post"
						, url:"/user/signin"
						, data:{"loginId":loginId, "password":password}
						, success:function(data) {
							
							if(data.result == "success") {
								location.href = "/post/timeline/view";
							} else {
								alert("아이디/패스워드를 확인해주세요");
							}
							
						}
						, error:function() {
							alert("로그인 에러");
						}
					});
										
				});
				
			});
		</script>
</body>


</html>