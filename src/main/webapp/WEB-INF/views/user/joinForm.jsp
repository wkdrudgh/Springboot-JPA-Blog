<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="username">username</label> <input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>

		<div class="form-group">
			<label for="password">password</label> <input type="email" class="form-control" placeholder="Enter password" id="password">
		</div>

		<div class="form-group">
			<label for="email">email</label> <input type="password" class="form-control" placeholder="Enter Email" id="email">
		</div>

		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>