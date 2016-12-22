<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<body>
					<div class="row">
						<div class="noo-main col-md-12">
							<div id="customer_login" class="myInfo">
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<h2>Info Modify</h2>
									<form class="find-profile id" action="<c:url value='/userInfoController/updateUserInfo' />">
										<div class="form-row form-row-wide">
				
											<label for="find_id">
												아이디(이메일)
												<span class="required">*</span>
											</label>
											<input type="text" class="input-text" name="email" id="reg_id" value="${memberDto.email}"  readonly="readonly"/>
											
											<label for="find_id">
												이름
												<span class="required">*</span>
											</label>
											<input type="text" class="input-text" name="name" id="reg_name" value="${memberDto.name}"  readonly="readonly"/>
											
											<label for="find_pw">
												비밀번호
												<span class="required">*</span>
											</label>
											<input type="password" class="input-text" name="pwd" id="reg_name" value=""/>
											
											<label for="find_pw_re">
												비밀번호 확인
												<span class="required">*</span>
											</label>
											<input type="password" class="input-text" name="pwdCheck" id="reg_name" value=""/>
											
											<label for="find_phone">
												연락처
												<span class="required">*</span>
											</label>
											<input type="text" class="input-text" name="phone" id="reg_name" value=""/>
											
										</div>
										<input type="submit" class="button" name="register" value="수정하기" />
									</form>
								</div>
								<div class="col-md-1"></div>
							</div>
						</div>
					</div>
