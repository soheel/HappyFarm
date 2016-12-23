<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="noo-sidebar col-md-3">
	<div class="noo-sidebar-wrap">
		<div class="widget commerce widget_product_search">
			<h3 class="widget-title">Search</h3>
			<form>
				<input type="search" class="search-field" placeholder="Search Products&hellip;" value="" name="s"/>
				<input type="submit" value="Search"/>
			</form>
		</div>
		<div class="widget commerce widget_products">
			<h3 class="widget-title">Certification mark</h3>
			<div>
				<a href="#"><img src='<c:url value="/resources/images/"/>Not_Select_aGricultural_Produce.jpg' alt="agricultural produce"></a>
			</div>
		</div>
	</div>
</div>