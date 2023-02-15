<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jeansgram</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<body>

	<div class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="contents d-flex justify-content-center">
			<div class="timeline">
					<div class="upload mt-4">
						<div class="d-flex justify-content-between">
							<i class="bi bi-image my-5 ml-2"></i>
							<a href="/post/create/view" class="btn my-5 mr-2 text-white">업로드</a>
						</div>
					</div>
						<div class="namebox mt-3">
						yjjeans
						</div>
						<div>
							<img class="mt-3" src="https://cdn.pixabay.com/photo/2016/11/23/14/37/blur-1853262_960_720.jpg" width="400"><br>
							<i class="bi bi-heart-fill"></i> 좋아요 11개 <br>
							<textbox>yjjeans   안녕하세요. 오늘 추천해드릴 종목은 ... </textbox> <br>
						</div>
						<div class="comment">댓글</div>						
							<textbox>latte_1023 좋은정보 감사드려요^^ </textbox> <br>
							<textbox>latte_1023 좋은정보 감사드려요^^ </textbox> <br>
						<div class="d-flex justify-content-between">
							<input type="text" class="form-control" placeholder="">
							<a href="/post/timeline/view" class="btn text-white">게시</a>
						</div>
				
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			
		});
	</script>
</body>
</html>