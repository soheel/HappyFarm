<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<section class="noo-page-heading eff">
				<div class="container">
					<div class="noo-heading-content">
						<h1 class="page-title eff">My Account</h1>
						<div class="noo-page-breadcrumb eff">
							<a href="./" class="home">Organici</a>/<span>My Account</span>
						</div>
					</div>
				</div>
			</section>
			<div class="main">
				<div class="commerce commerce-account noo-shop-main">
					<div class="container">
						<div class="row">
							<div class="noo-main col-md-12">
								<div id="customer_login">
									<div class="col-md-12">
										<h2>Login</h2>
										<form class="login">
											<div class="form-row form-row-wide">
												<label for="username">
													Username or email address 
													<span class="required">*</span>
												</label>
												<input type="text" class="input-text" name="username" id="username" value="" />
											</div>
											<div class="form-row form-row-wide">
												<label for="password">
													Password 
													<span class="required">*</span>
												</label>
												<input class="input-text" type="password" name="password" id="password" />
											</div>
											<div class="form-row">
												<input type="submit" class="button" name="login" value="Login" />
												
												<!-- Register의 클릭 액션은 register-btn.js에 -->
												<input type="button" class="button" name="Register" value="Register"/>
											</div>
											<div class="lost_password">
												<a href="#">Lost your password?</a>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="noo-footer-shop-now">
					<div class="container">
						<div class="col-md-7">
							<h4>- Every day fresh -</h4>
							<h3>organic food</h3>
						</div>
						<img src="images/organici-love-me.png" class="noo-image-footer" alt="" />
					</div>
				</div>
			</div>
</body>
</html>