<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<body>
	<div class="site">
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
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<h2>Find Profile</h2>
									<form class="find-profile id">
										<div class="form-row form-row-wide">
											<label for="find_id">
												아이디 찾기
												<span class="required">*</span>
											</label>
											<input type="text" class="input-text" name="email" id="reg_email" value="" placeholder="NAME" />
											<input type="text" class="input-text" name="email" id="reg_email" value="" placeholder="PHONE NUMBER" />
										</div>
										<input type="submit" class="button" name="register" value="Find Account" />
									</form>

									<form class="find-profile pw">
										<div class="form-row form-row-wide">
											<label for="find_pw">
												비밀번호 찾기
												<span class="required">*</span>
											</label>
											<input type="email" class="input-text" name="email" id="reg_email" value="" placeholder="EMAIL" />
										</div>
										<input type="submit" class="button" name="register" value="Find Account" />
									</form>
								</div>
								<div class="col-md-1"></div>
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