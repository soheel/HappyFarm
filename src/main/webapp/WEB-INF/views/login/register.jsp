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
										<h2>Register</h2>
										<form action = "<c:url value = '/userInfoController/register'/>" method = "post" class="register">
											<div class="form-row form-row-wide">
												<label for="reg_email">
													Email address 
													<span class="required">*</span>
												</label>
												<input type="email" class="input-text" name="email" id="reg_email" value="" />
											</div>
											<div class="form-row form-row-wide">
												<label for="reg_password">
													Password 
													<span class="required">*</span>
												</label>
												<input type="password" class="input-text" name="pwd" id="reg_password" />
											</div>
											<div class="form-row form-row-wide">
												<label for="reg_password">
													Name
													<span class="required">*</span>
												</label>
												<input type="text" class="input-text" name="name" id="reg_name" />
											</div>
											<div class="form-row form-row-wide">
												<label for="reg_password">
													Phone 
													<span class="required">*</span>
												</label>
												<input type="text" class="input-text" name="phone" id="reg_phone" />
											</div>
											<div class="form-row form-row-wide">
												<label for="reg_password">
													추천인 (
													<span id = "recommandCheck" class="required">선택사항</span>)
												</label>
												<input type="text" class="input-text" name="recommand" id="reg_recommand" />
											</div>
											<div class="form-row">
												<input id = "recommandInput" type="submit" class="button" name="register" value="Register" />
											</div>
										</form>
									</div>
	
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
</body>
</html>