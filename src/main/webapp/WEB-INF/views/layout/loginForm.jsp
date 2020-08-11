<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %> 

<div class="container">
   <form action="/auth/loginForm" method="POST" class="was-validated" >

     <div class="form-group">
       <label for="username">Username:</label>
       <input type="text" class="form-control" name="username" id="username" placeholder="Enter username" name="username" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>

     <div class="form-group">
       <label for="pwd">Password:</label>
       <input type="password" class="form-control" name="password" id="password" placeholder="Enter password" name="password" required>
       <div class="valid-feedback">Valid.</div>
       <div class="invalid-feedback">Please fill out this field.</div>
     </div>

     <button type="button" class="btn btn-primary">로그인</button>
   </form>
   
   <h1>Social Login</h1>
	<br />
	<!-- javascript:; 는 클릭해도 반응을 없게 하는 키워드 -->
	<a href="/oauth2/authorization/google"> <img
		src="https://pngimage.net/wp-content/uploads/2018/06/google-login-button-png-1.png" alt="google" width="357px"
		height="117px">
	</a>
	<br />
	<a href="/oauth2/authorization/facebook"> <img
		src="https://pngimage.net/wp-content/uploads/2018/06/login-with-facebook-button-png-transparent-1.png" alt="facebook"
		width="357px" height="117px">
	</a>
	<div></div>
	<a href="/oauth2/authorization/naver"> <img
		src="https://blogfiles.pstatic.net/MjAyMDA4MDRfMzMg/MDAxNTk2NTEyOTY4MDMx.vhXHCulffijGUnvlaBR2jW4__Lkz8R3ZTaEDcTeNV2gg.Wt_HNl_zktUJUMrYGkVmqJ-PhxKv_s4A7gG1uPKMZaQg.PNG.getinthere/naver_button.png"
		alt="naver" width="357px" height="50px">
	</a>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>