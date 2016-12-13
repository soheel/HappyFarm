<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<body>
	<div class="noo-sidebar col-md-3">
								<div class="noo-sidebar-wrap">
								<div class="widget commerce widget_product_search">
									<h3 class="widget-title">Search</h3>
									<form>
										<input type="search" class="search-field" placeholder="Search Products&hellip;" value="" name="s"/>
										<input type="submit" value="Search"/>
									</form>
								</div>
								
								<div class="widget commerce widget_price_filter">
									<h3 class="widget-title">Filter by price</h3>
									<form>
										<div class="price_slider_wrapper">
											<div class="price_slider" style="display:none;"></div>
											<div class="price_slider_amount">
												<input type="text" id="min_price" name="min_price" value="" data-min="0" placeholder="Min price"/>
												<input type="text" id="max_price" name="max_price" value="" data-max="15" placeholder="Max price"/>
												<button type="submit" class="button">Filter</button>
												<div class="price_label" style="display:none;">
														Price: <span class="from"></span> &mdash; <span class="to"></span>
												</div>
												<div class="clear"></div>
											</div>
										</div>
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
</body>
</html>