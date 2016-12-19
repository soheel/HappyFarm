<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="commerce commerce-page commerce-cart noo-shop-main">
						<div class="container">
							<h3 class="widget-title">총 매출</h3>
							<div class="row">
								<div class="noo-main col-md-12">
									<table class="shop_table cart">
										<thead>
											<tr>
												<th class="product-name">월별 총 매출액</th>
												<th class="product-count">판매 상품 비율</th>
											</tr>
										</thead>
										<tbody>
											<tr class="cart_item">
												<td class="product-count">
													<div id = "salesMonth" style = "width : 400px; height : 400px;">차트</div> 
												</td>
												<td class="product-sales">
													<div id = "salesProduct" style = "width : 400px; height : 400px;">차트</div> 
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<script type='text/javascript' src='<c:url value="/resources/js/"/>jquery.min.js'></script>
					<script src="https://code.highcharts.com/highcharts.js"></script>
					<script src="https://code.highcharts.com/modules/exporting.js"></script>
					<script type="text/javascript">
					$(function() {
						$.ajax({
							url : "<c:url value = '/manageController/salesMonthManage'/>",
							type : "post",
							dataType : "json",
							success : function(result) {
								/* 월별 매출액 */
								// 수입차트
										var chart = Highcharts.chart('salesMonth', {
												title : {
									    		text: '수입'
									    },
									    xAxis: {
									        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
									    },
									    yAxis: {
									    		title:{
									        		text: '단위 : 만원'
									        } 
									    },
									    series: [{
									        data: [result[0], result[1], result[2], result[3], result[4], result[5], result[6], result[7], result[8], result[9], result[10], result[11]] // DB로부터 가져오기
									    }]
									});
							},
							error : function(err) {
								alert("err : " + err);
							}
						})
						
						$.ajax({
							url : "<c:url value = '/manageController/salesProductManage'/>",
							type : "post",
							dataType : "json",
							success : function(result) {
								// 도넛
							    var colors = Highcharts.getOptions().colors,
							    categories = ['과일/견과', '채소', '쌀/잡곡'],
							    data = [{
							        y: 65, // DB로부터 가져오기
							        color: colors[0],
							        drilldown: {
							            name: '과일/견과',
							            categories: ['사과/배', '딸기/블루베리', '바나나/키위/토마토', '감/곶감', '감귤/한라봉', '땅콩/잣/호두', '복숭아/자두/포도', '건과/견과류', '수박/참외/매실'],
							            data: [1.06, 0.5, 17.2, 8.11, 5.33, 24.13], // DB로부터 가져오기
							            color: colors[0]
							        }
							    }, {
							        y: 15, // DB로부터 가져오기
							        color: colors[1],
							        drilldown: {
							            name: '채소',
							            categories: ['두부/콩나물', '고구마/감자/당근/연근', '상추/깻잎/쌈채소', '양파/마늘/생강/파', '배추/무/김장채소', '오이/호박/가지', '시금치/미나리/아욱/건나물', '브로콜리/양배추/샐러드/녹즙', '새송이/느타리/버섯', '파프리카/피망/고추'],
							            data: [0.33, 0.15, 0.22, 1.27, 2.76, 2.32, 2.31, 1.02], // DB로부터 가져오기
							            color: colors[1]
							        }
							    }, {
							        y: 20, // DB로부터 가져오기
							        color: colors[2],
							        drilldown: {
							            name: '쌀/잡곡',
							            categories: ['백미/현미/이유식', '찹쌀/흑미', '잡곡/콩/깨', '고춧가루/미숫가루/곡물가루'],
							            data: [0.14, 1.24, 0.55, 0.19, 0.14, 0.85, 2.53, 0.38, 0.6, 2.96, 5, 4.32, 3.68, 1.45],// DB로부터 가져오기
							            color: colors[2]
							        }
							    }],
							    browserData = [],
							    versionsData = [],
							    i,
							    j,
							    dataLen = data.length,
							    drillDataLen,
							    brightness;


							// Build the data arrays
							for (i = 0; i < dataLen; i += 1) {

							    // add browser data
							    browserData.push({
							        name: categories[i],
							        y: data[i].y,
							        color: data[i].color
							    });

							    // add version data
							    drillDataLen = data[i].drilldown.data.length;
							    for (j = 0; j < drillDataLen; j += 1) {
							        brightness = 0.2 - (j / drillDataLen) / 5;
							        versionsData.push({
							            name: data[i].drilldown.categories[j],
							            y: data[i].drilldown.data[j],
							            color: Highcharts.Color(data[i].color).brighten(brightness).get()
							        });
							    }
							}

							// Create the chart
							Highcharts.chart('salesProduct', {
							    chart: {
							        type: 'pie'
							    },
							    title: {
							        text: '해피팜 2016.12' // 날짜 불러오기
							    },
							    subtitle: {
							        text: 'Source: <a href="http://netmarketshare.com/">netmarketshare.com</a>'
							    },
							    yAxis: {
							        title: {
							            text: 'Total percent market share'
							        }
							    },
							    plotOptions: {
							        pie: {
							            shadow: false,
							            center: ['50%', '50%']
							        }
							    },
							    tooltip: {
							        valueSuffix: '%'
							    },
							    series: [{
							        name: 'Browsers',
							        data: browserData,
							        size: '60%',
							        dataLabels: {
							            formatter: function () {
							                return this.y > 5 ? this.point.name : null;
							            },
							            color: '#ffffff',
							            distance: -30
							        }
							    }, {
							        name: 'Versions',
							        data: versionsData,
							        size: '80%',
							        innerSize: '60%',
							        dataLabels: {
							            formatter: function () {
							                // display only if larger than 1
							                return this.y > 1 ? '<b>' + this.point.name + ':</b> ' + this.y + '%' : null;
							            }
							        }
							    }]
							});
							},
							error : function(err) {
								alert("err : " + err);
							}
						})
					})
					</script>
