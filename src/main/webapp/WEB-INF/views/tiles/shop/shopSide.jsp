<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="noo-sidebar col-md-3">
	<div class="noo-sidebar-wrap">
		<div class="widget commerce widget_product_search">
			<h3 class="widget-title">Search</h3>
			<form action = "<c:url value = "/userProductController/search"/>" method="get" >
				<input type="search" class="search-field" placeholder="Search Products&hellip;" name="keyword"/>
				<input type="submit" value="Search"/>
			</form>
		</div>
		<div class="widget commerce widget_product_categories shop_side">
			<div id="categories-title" class="relative">
				<h3 class="widget-title">Categories</h3>
				<div id="triangle-down" class="right absolute shop_categories_btn"></div>
			</div>
			<ul class="product-categories">
				<li><a href="#" style = "font-weight : bold;">과일/견과</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=4"/>">-&nbsp;&nbsp;감, 곶감</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=5"/>">-&nbsp;&nbsp;감귤, 한라봉</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=8"/>">-&nbsp;&nbsp;건과, 견과류</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=2"/>">-&nbsp;&nbsp;딸기, 블루베리</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=6"/>">-&nbsp;&nbsp;땅콩, 잣, 호두</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=3"/>">-&nbsp;&nbsp;바나나, 키위, 토마토</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=1"/>">-&nbsp;&nbsp;사과, 배</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=9"/>">-&nbsp;&nbsp;수박, 참외, 매실</a></li>
				<li><a href="#" style = "font-weight : bold;">쌀/잡곡</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=23"/>">-&nbsp;&nbsp;고춧가루, 미숫가루, 곡물가루</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=20"/>">-&nbsp;&nbsp;백미, 현미</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=22"/>">-&nbsp;&nbsp;잡곡, 콩, 깨</a></li>	
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=21"/>">-&nbsp;&nbsp;찹쌀, 흑미</a></li>
				<li><a href="#" style = "font-weight : bold;">채소</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=11"/>">-&nbsp;&nbsp;고구마, 감자, 당근, 연근</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=14"/>">-&nbsp;&nbsp;배추, 무, 김장채소</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=17"/>">-&nbsp;&nbsp;브로콜리, 양배추, 샐러드, 녹즙</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=12"/>">-&nbsp;&nbsp;상추, 깻잎, 쌈채소</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=18"/>">-&nbsp;&nbsp;새송이, 느타리, 버섯</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=16"/>">-&nbsp;&nbsp;시금치, 미나리, 아욱, 건나물</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=13"/>">-&nbsp;&nbsp;양파, 마늘, 생강, 파</a></li>
				<li><a href="<c:url value="/userProductController/shopMenuListLoading?categoryNo=5"/>">-&nbsp;&nbsp;오이, 호박, 가지</a></li>
				<li><a href="#">-&nbsp;&nbsp;파프리카, 피망, 고추</a></li>
			</ul>
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
		
	
		<div class="widget commerce widget_products certification_img">
			<h3 class="widget-title">Certification mark</h3>
			<div>
				<img src='<c:url value="/resources/images/"/>Not_Select_aGricultural_Produce.jpg' alt="agricultural produce" data-toggle="modal" data-target="#certification" id="certi">
			</div>
		</div>
			
		<div style="margin: 25px 25px 15px 0px; padding: 20px; font-weight: bold; text-decoration:underline">
			<a href="http://www.enviagro.go.kr/portal/info/Info_certifi_spe.do" target="_blank"> 유기농 인증 정보 검색하러 가기</a>
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
		<img src="<c:url value="/resources/img/footer/"/>organici-love-me.png" class="noo-image-footer" alt="" />
	</div>
</div>

<!-- centigication 클릭했을때 나오는 영역 -->
<div class="modal fade" id="certification" role="dialog">
	<div class="modal-dialog">
		<form name="regCommunity" action="" method = "post" enctype="multipart/form-data">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">유기농 인증 정보</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="certification_form">
							<div class="cetication_content">
								<img src='<c:url value="/resources/img/certification/certificationKind.jpg"/>' alt="agricultural produce" width="400" height="600">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</form>
	</div>
</div>
</div>
<script type="text/javascript">
$(function(){
	
	
})


</script>