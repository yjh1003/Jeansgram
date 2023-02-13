<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<header class="d-flex justify-content-between align-items-center">
			<h1 class="text-white pt-2 pl-2">Jeansgram</h1>
			<%-- 세션에 "userId" 값이 저장되어 있으면 로그인된 상태 --%>
			<c:if test="${not empty userId }">
				<div class="mr-3">${userName }님 <a href="/user/signout">로그아웃</a></div>
			</c:if>
		</header>