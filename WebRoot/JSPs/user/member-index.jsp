<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">

<title>Member Index</title>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
<!--jQuery (necessary for Bootstrap's JavaScript plugins)-->
<script src="../js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/component.css" rel="stylesheet" type="text/css" />
<!--Custom Theme files-->
<meta content="width=device-width, initial-scale=1" name="viewport">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</script>
<!--webfonts-->
<link
	href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800"
	rel="stylesheet" type="text/css">
<!--webfonts-->
<!--start-smoth-scrolling-->
<script src="../js/move-top.js" type="text/javascript"></script>
<script src="../js/easing.js" type="text/javascript"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
<!--start-smoth-scrolling-->
<link href="../css/Navigation.css" rel="stylesheet" type="text/css">
<link href="../css/Registro.css" rel="stylesheet" type="text/css">

</head>

<body>

	<!--header-->
	<div class="header">
		<jsp:include page="member-navigation.jsp"></jsp:include>
	</div>
	<section class="color ss-style-bigtriangle ">
		<div id="service" class="Services">
			<div class="service-grids">
				<div class="container">
					<div class="clearfix"></div>
				</div>
			</div>
		</div>

	</section>
	<svg id="bigTriangleColor" xmlns="http://www.w3.org/2000/svg"
		version="1.1" width="100%" height="100" viewBox="0 0 100 102"
		preserveAspectRatio="none">
				<path d="M0 0 L50 100 L100 0 Z" />
			</svg>
	<!--/End-banner-->
	<div id="portfolio" class="portfolio">
		<div class="container">
			<div class="port-section">
				<h3>所有电影</h3>
				<lable> </lable>
			</div>
			<div class="portfolio">
				<ul id="filters" class="clearfix">
					<li><span class="filter" data-filter="app card icon logo web">所有</span></li>
					<li><span class="filter" data-filter="card">悬疑</span></li>
					<li><span class="filter" data-filter="app">温情</span></li>
					<li><span class="filter" data-filter="logo">动作</span></li>
				</ul>
				<div id="portfoliolist">
					<div class="portfolio app mix_all" data-cat="app"
						style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a
								class="b-link-stripe b-animate-go  thickbox popup-with-zoom-anim"
								href="#small-dialog"> <img src="../images/pic1.png" />
							<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img alt="" src="../images/icon-eye.png" />
									</h2>
									<p class="b-animate b-from-right  b-delay03 ">
										<span class="m_4">一天</span><br>《一天》是一部美丽的电影，而且不是电影式的美丽，是生活式的美丽。
									</p>
								</div>
							</a>
						</div>
					</div>
					<div class="portfolio logo mix_all" data-cat="logo"
						style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a
								class="b-link-stripe b-animate-go  thickbox popup-with-zoom-anim"
								href="#small-dialog1"> <img src="../images/pic2.png" />
							<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img alt="" src="../images/icon-eye.png" />
									</h2>
									<p class="b-animate b-from-right  b-delay03 ">
										<span class="m_4">特种部队</span><br>影片是典型正义战胜邪恶、英雄拯救世界的好莱坞大片，不过在故事设置上充满意外。与《变形金刚》等科幻片相比更显人情味更浓。除了正邪双方的针锋相对外，人物复杂的感情纠葛也牵动着观众的心。
									</p>
								</div>
							</a>
						</div>
					</div>
					<div class="portfolio card mix_all" data-cat="card"
						style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a
								class="b-link-stripe b-animate-go  thickbox popup-with-zoom-anim"
								href="#small-dialog2"> <img src="../images/pic3.png" />
							<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img alt="" src="../images/icon-eye.png" />
									</h2>
									<p class="b-animate b-from-right    b-delay03 ">
										<span class="m_4">变形金刚</span><br>经典致死的东西 哪怕首映的是一堆海报
										也会有狂热的追捧者激动休克 所以这周开始连AMC影院的时间表上都显示几乎所有的影片都让道给了Transformers
										我本来还故作镇静状 但是影片一开场就失去理智了
									</p>
								</div>
							</a>
						</div>
					</div>
					<div class="portfolio logo mix_all" data-cat="logo"
						style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a
								class="b-link-stripe b-animate-go  thickbox popup-with-zoom-anim"
								href="#small-dialog3"> <img src="../images/pic4.png" />
							<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img alt="" src="../images/icon-eye.png" />
									</h2>
									<p class="b-animate b-from-right    b-delay03 ">
										<span class="m_4">无耻混蛋</span><br>《无耻的混蛋》会让观众分化？这是已知的事实。但任何一个真正的职业影迷都无法抗拒它。
									</p>
								</div>
							</a>
						</div>
					</div>
					<div class="portfolio card mix_all" data-cat="card"
						style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a
								class="b-link-stripe b-animate-go  thickbox popup-with-zoom-anim"
								href="#small-dialog4"> <img src="../images/pic5.png" />
							<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img alt="" src="../images/icon-eye.png" />
									</h2>
									<p class="b-animate b-from-right    b-delay03 ">
										<span class="m_4">大侦探福尔摩斯</span><br>《大侦探福尔摩斯》其实是一部福尔摩斯同人作品，这部完全颠覆版福尔摩斯，实在也很好看。虽然片尾决战一段有点虎头蛇尾略显孱弱之外，再现了维多利亚时代伦敦的阴郁风貌，而唐尼和裘德・洛则联手献出一对“形散神不散”的完美拍档
									</p>
								</div>
							</a>
						</div>
					</div>
					<div class="portfolio app mix_all" data-cat="app"
						style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a
								class="b-link-stripe b-animate-go  thickbox popup-with-zoom-anim"
								href="#small-dialog5"> <img src="../images/pic6.png" />
							<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img alt="" src="../images/icon-eye.png" />
									</h2>
									<p class="b-animate b-from-right    b-delay03 ">
										<span class="m_4">南极大冒险</span><br>影片中冰雪覆盖的南极大陆巍为壮观，科学家掉进冰层裂缝的场景，雪橇犬在茫茫冰雪中孤独行走的场景，它们在南极极光里好奇仰望的场景，以及营救狗狗的破冰船破冰前进的镜头等等，这些镜头和段落都让观众感叹影片中的南极大陆逼真而有气势
									</p>
								</div>
							</a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!---pop-up-box---->
			<script src="../js/modernizr.custom.min.js" type="text/javascript"></script>
			<link href="../css/popuo-box.css" media="all" rel="stylesheet"
				type="text/css" />
			<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
			<script src="../js/jquery.mixitup.min.js" type="text/javascript"></script>
			<script type="text/javascript">
	$(function () {
		
		var filterList = {
		
			init: function () {
			
				// MixItUp plugin
				// http://mixitup.io
				$('#portfoliolist').mixitup({
					targetSelector: '.portfolio',
					filterSelector: '.filter',
					effects: ['fade'],
					easing: 'snap',
					// call the hover effect
					onMixEnd: filterList.hoverEffect()
				});				
			
			},
			
			hoverEffect: function () {
			
				// Simple parallax effect
				$('#portfoliolist .portfolio').hover(
					function () {
						$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
						$(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');				
					},
					function () {
						$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
						$(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');								
					}		
				);				
			
			}

		};
		
		// Run the show!
		filterList.init();
		
		
	});	
	</script>
			<!---//pop-up-box---->
			<div id="small-dialog" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up1.png" />
					<p>1988年7月15号，艾玛和德斯特在毕业晚会上一见钟情，一夜缠绵之后，他们即将踏上新的人生旅途。临行之际，他们约定成为好朋友，并在之后每年的7月15日那天见面。20年中，曾经朝气蓬勃、怀揣理想的他们也不得不向残酷的现实低头。艾玛的工作际遇和感情生活都不理想，德斯特成了一个小众的电视名人，终日沉溺在酒精、毒品中，婚姻也岌岌可危。当他们的人生道路不断交汇时，他们的关系也随之改变，友情和争吵，希望和失落，泪水和欢笑。在这段人生的旅途中，两人蓦然回首，终于发现一直寻寻觅觅，最好的其实早在身边。</p>
				</div>
			</div>
			<div id="small-dialog1" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up2.png" />
					<p>一枚前所未见的大规模杀伤性弹头，以迅雷不及掩耳之势向埃菲尔铁塔飞去。短短数十秒，庞大的钢铁建筑催枯拉朽般倒下，围观者除了呆若木鸡，只能四散逃命。到底是谁，竟拥有如此惊世骇俗的武力？世界各大国，无不岌岌自危。为了追查来龙去脉、维护世界和平，一支隶属北大西洋公约组织的极机密特种部队，火速出动！
						由霍克将军（丹尼斯·奎德）率领的这支政府秘密武器，总部设在布鲁塞尔，云集来自全球各地的顶尖高手。无论是经历战地敢死考验的副指挥官“公爵”（钱宁·塔图姆）、精通武术和计算的“红发女郎”斯...</p>
				</div>
			</div>
			<div id="small-dialog2" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up3.png" />
					<p>“霸天虎”的先遣部队旋风和毒蝎袭击了美军位于卡塔尔的军事基地，与此同时，路障帮助他的搭档迷乱潜入了美国总统的座机空中一号，通过电脑获悉，要想找到威震天就必须找到维特维奇家族的那副眼镜，上面有威震天关于能量块的信息扫描，而它现在的拥有者萨姆•维特维奇（希安•拉博夫饰）成为了“霸天虎”攻击的目标。
						萨姆是名高中生，学校里没有人相信他讲述的关于这副眼镜的历史，失望之余，萨姆把眼镜放到网上拍卖，然而从未引起买家的兴趣。这时父亲送了一辆破车给他，这辆车恰好就是“汽车人”大黄蜂的变形。大黄蜂帮助萨姆交上了漂亮的女朋友（梅甘•福克斯饰），但很快就遭遇了“霸天虎”的袭击，擎天柱带着其他“汽车人”赶到，一场机器人大战由此拉开了序幕。</p>
				</div>
			</div>
			<div id="small-dialog3" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up4.png" />
					<p>《无耻混蛋》是一部由昆汀·塔伦蒂诺和伊莱·罗斯共同执导的战争电影，梅拉尼·罗兰、布拉德·皮特、黛安·克鲁格、克里斯托弗·瓦尔兹和迈克尔·法斯宾德等联袂出演。影片于2009年5月20日在法国戛纳电影节率先放映[1]
						。
						电影的故事发生在二战期间，一群犯了罪的美国士兵原本将要被处以死刑，但是非常时期采取非常政策，他们被允许戴罪立功——深入已被纳粹占领的法国去执行一项危险任务，此项任务代号为“基诺行动”。</p>
				</div>
			</div>
			<div id="small-dialog4" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up5.png" />
					<p>影片根据莱昂纳尔·威格拉姆（Lionel
						Wigram）的同名漫画改编，故事原型来自英国小说家阿瑟·柯南道尔经典破案侦探系列小说的主人公。《大侦探福尔摩斯》注定是一次里程碑式的颠覆，还因为片中的福尔摩斯与华生有着超越友情的羁绊。而且，在以前所有版本的福尔摩斯影视作品中，华生都是万年大绿叶，在盖·里奇导筒下，默默陪伴福尔摩斯的华生医生终于迎来了百年以来的首次扶正，当起了主角。</p>
				</div>
			</div>
			<div id="small-dialog5" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up6.png" />
					<p>为了搜寻一块坠落在南极岛上的神秘陨石，一支由三个科学家组成的探险队开始了他们的南极探险之旅。探险小组包括杰里·夏洛德（保罗·沃克饰），他最好的朋友库珀（贾森·比格斯饰）以及一个性格古怪的美国地质学家（布鲁斯·格林伍德饰）。去南极考察探险，当然离不了在雪地上行走的特殊工具——雪橇，以及人们的忠实伙伴，雪橇犬。并且，这八条“精明能干”的雪橇犬都像他们的人类同伴一样，都各自拥有自己的头衔和称号：领头的“玛雅”、忠实的“矮子”、老实“老杰克”、力气大的“杜鲁门”以及奔跑速度极快的“影子”等等。</p>
				</div>
			</div>
			<div id="small-dialog6" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up3.png" />
					<p>Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry&#39;s
						standard dummy text ever since the 1500s, when an unknown printer
						took a galley of type and scrambled it to make a type specimen
						book. It has survived not only five centuries, but also the leap
						into electronic typesetting, remaining essentially unchanged. It
						was popularised in the 1960s with the release of Letraset sheets
						containing Lorem Ipsum passages, and more recently with desktop
						publishing software like Aldus PageMaker including versions of
						Lorem Ipsum.</p>
				</div>
			</div>
			<div id="small-dialog7" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up1.png" />
					<p>Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry&#39;s
						standard dummy text ever since the 1500s, when an unknown printer
						took a galley of type and scrambled it to make a type specimen
						book. It has survived not only five centuries, but also the leap
						into electronic typesetting, remaining essentially unchanged. It
						was popularised in the 1960s with the release of Letraset sheets
						containing Lorem Ipsum passages, and more recently with desktop
						publishing software like Aldus PageMaker including versions of
						Lorem Ipsum.</p>
				</div>
			</div>


			<div id="small-dialog8" class="mfp-hide">
				<div class="image-top">
					<img alt="" src="../images/pop-up.png" />
					<p>Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry&#39;s
						standard dummy text ever since the 1500s, when an unknown printer
						took a galley of type and scrambled it to make a type specimen
						book. It has survived not only five centuries, but also the leap
						into electronic typesetting, remaining essentially unchanged. It
						was popularised in the 1960s with the release of Letraset sheets
						containing Lorem Ipsum passages, and more recently with desktop
						publishing software like Aldus PageMaker including versions of
						Lorem Ipsum.</p>
				</div>
			</div>
			<script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>
		</div>
	</div>
	<section class="color ss-style-bigtriangle">
		<div id="team" class="Team">
			<div class="container">
				<div class="team-section">
					<h3>OUR FRIENDS</h3>
					<lable> </lable>
					<p>Assaic is the most amasizing cineplex in the world! Come and
						join us.</p>
				</div>
				<div class="row text-center teams">
					<div class="col-md-3 team_grid1">
						<div class="view second-effect">
							<img src="../images/t1.png" />
							<div class="mask">
								<a class="info" href="#">Read More</a>
							</div>
						</div>
						<h3>&nbsp;&nbsp;&nbsp;&nbsp;黄晓明&nbsp;&nbsp;&nbsp;&nbsp;</h3>
						<h4>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
					</div>
					<div class="col-md-3 team_grid2">
						<div class="view second-effect">
							<img src="../images/t2.png" />
							<div class="mask">
								<a class="info" href="#">Read More</a>
							</div>
						</div>
						<h3>&nbsp;&nbsp;&nbsp;&nbsp;保罗·沃克&nbsp;&nbsp;&nbsp;&nbsp;</h3>
						<h4>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
					</div>
					<div class="col-md-3 team_grid3">
						<div class="view second-effect">
							<img src="../images/t3.png" />
							<div class="mask">
								<a class="info" href="#">Read More</a>
							</div>
						</div>
						<h3>&nbsp;&nbsp;&nbsp;&nbsp;小唐尼罗伯特&nbsp;&nbsp;&nbsp;&nbsp;</h3>
						<h4>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
					</div>
					<div class="col-md-3 team_grid4">
						<div class="view second-effect">
							<img src="../images/t4.png" />
							<div class="mask">
								<a class="info" href="#">Read More</a>
							</div>
						</div>
						<h3>&nbsp;&nbsp;&nbsp;&nbsp;刘亦菲&nbsp;&nbsp;&nbsp;&nbsp;</h3>
						<h4>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>

	</section>
	<svg id="bigTriangleColor3" xmlns="http://www.w3.org/2000/svg"
		version="1.1" width="100%" height="100" viewBox="0 0 100 102"
		preserveAspectRatio="none">
				<path d="M0 0 L50 100 L100 0 Z" />
			</svg>
	<!-----clients---->
	<div id="offices" class="offices">
		<div class="container">
			<div class="offices-section">
				<h3></h3>
				<lable> </lable>
				<p></p>
			</div>
			<div class="map"></div>
		</div>
	</div>
	<section class="color ss-style-bigtriangle">
		<div id="client" class="Clients">
			<div class="container">
				<div class="client-section">
					<h3>OUR CLIENTS</h3>
					<lable> </lable>
					<p></p>
				</div>
				<div class="client-grids">
					<div class="clients-icons">
						<ul>
							<li></li>
							<li></li>
							<li class="box"></li>
							<li class="man"></li>
							<br>
							<li class="facebook"></li>
							<li class="sony"></li> &nbsp;
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!---/start-text-slider----->
		<!----sreen-gallery-cursual---->
		<div class="sreen-gallery-cursual">
			<link href="../css/owl.carousel.css" rel="stylesheet">
			<script src="../js/owl.carousel.js"></script>
			<script>
							    $(document).ready(function() {
							      $("#owl-demo").owlCarousel({
							        items :1,
							        lazyLoad : true,
							        autoPlay : true,
							        navigation : true,
							        navigationText :  false,
							        pagination : true,
							      });
							    });
							    </script>
			<!-- //requried-jsfiles-for owl -->
			<!-- start content_slider -->
			<div id="owl-demo" class="owl-carousel text-center">
				<div class="item">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Pellentesque eu erat lacus, vel congue mauris. Fusce velit justo,
						faucibus eu sagittis.Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Pellentesque eu erat lacus, vel congue mauris.
						Fusce velit justo, faucibus eu sagittis.</p>
					<h4>Virgin Mega Store</h4>
				</div>
				<div class="item">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Pellentesque eu erat lacus, vel congue mauris. Fusce velit justo,
						faucibus eu sagittis.Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Pellentesque eu erat lacus, vel congue mauris.
						Fusce velit justo, faucibus eu sagittis.</p>
					<h4>Virgin Mega Store</h4>
				</div>
				<div class="item">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Pellentesque eu erat lacus, vel congue mauris. Fusce velit justo,
						faucibus eu sagittis.Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Pellentesque eu erat lacus, vel congue mauris.
						Fusce velit justo, faucibus eu sagittis.</p>
					<h4>Virgin Mega Store</h4>
				</div>
			</div>
		</div>
	</section>
	<svg id="bigTriangleColor3" xmlns="http://www.w3.org/2000/svg"
		version="1.1" width="100%" height="100" viewBox="0 0 100 102"
		preserveAspectRatio="none">
				<path d="M0 0 L50 100 L100 0 Z" />
			</svg>
	<!-----contact---->
	<div id="contact" class="Contact">
		<div class="container">
			<div class="contact-section">
				<h3>Contact US</h3>
				<lable> </lable>
			</div>
			<div class="contact-content">
				<ul class="contact-grids">
					<li class="contact-grid phone"><i class="icon11"></i>
						<h4>Customer Care</h4>
						<h5>(+00) 123456789</h5></li>
					<li class="contact-grid"><i class="icon12"></i>
						<h4>Mail</h4>
						<h5>Support@Assaic.com</h5></li>
					<li class="contact-grid"><i class="icon13"></i>
						<h4>Twitter</h4>
						<h5>@Assaic</h5></li>
					<li class="contact-grid fb"><i class="icon14"></i>
						<h4>Facebook</h4>
						<h5>Assaic.Agency</h5></li>
					<div class="clearfix"></div>
				</ul>
			</div>
		</div>
	</div>
	<!----- /start-footer---->
	<div class="footer">
		<div class="container">
			<div class="foter-bottom">
				<div class="copy-right">
					<p>
						© 2014 All rights Reserved | Template by&nbsp; <a
							href="http://w3layouts.com">W3Layouts</a>
					</p>
				</div>
				<div class="logo-2">
					<img src="../images/logo.png" />
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!----- //End-footer---->
	<!----- //End-footer---->
	<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
	<a id="toTop" href="#" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"></span></a>

</body>

</html>
