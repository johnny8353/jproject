<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/header.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bootstrap 附加导航（Affix）插件</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet"
		href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
			href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<style type="text/css">
	/* Custom Styles */
	ul.nav-tabs {
		width: 140px;
		margin-top: 20px;
		border-radius: 4px;
		border: 1px solid #ddd;
		box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
	}
	
	ul.nav-tabs li {
		margin: 0;
		border-top: 1px solid #ddd;
	}
	
	ul.nav-tabs li:first-child {
		border-top: none;
	}
	
	ul.nav-tabs li a {
		margin: 0;
		padding: 8px 16px;
		border-radius: 0;
	}
	
	ul.nav-tabs li.active a,ul.nav-tabs li.active a:hover {
		color: #fff;
		background: #0088cc;
		border: 1px solid #0088cc;
	}
	
	ul.nav-tabs li:first-child a {
		border-radius: 4px 4px 0 0;
	}
	
	ul.nav-tabs li:last-child a {
		border-radius: 0 0 4px 4px;
	}
	
	ul.nav-tabs.affix {
		top: 30px; /* Set the top position of pinned element */
	}
	</style>
</head>
	<!-- 
	附加导航（Affix）插件允许某个 <div> 固定在页面的某个位置。您也可以在打开或关闭使用该插件之间进行切换。一个常见的例子是社交图标。它们将在某个位置开始，但当页面点击某个标记，该 <div> 会锁定在某个位置，不会随着页面其他部分一起滚动。
	如果您想要单独引用该插件的功能，那么您需要引用 affix.js。或者，正如 Bootstrap 插件概览 一章中所提到，您可以引用 bootstrap.js 或压缩版的 bootstrap.min.js。
	用法
		您可以通过 data 属性或者通过 JavaScript 来使用附加导航（Affix）插件。
		通过 data 属性：如需向元素添加附加导航（Affix）行为，只需要向需要监听的元素添加 data-spy="affix" 即可。请使用偏移来定义何时切换元素的锁定和移动。
	实例
		下面的实例演示了通过 data 属性使用附加导航（Affix）插件的用法：
	 -->
<body data-spy="scroll" data-target="#myScrollspy">
	<div class="container">
		<div class="jumbotron">
			<h1>Bootstrap Affix</h1>
		</div>
		<div class="row">
			<div class="col-xs-3" id="myScrollspy">
				<ul class="nav nav-tabs nav-stacked" data-spy="affix"
					data-offset-top="125">
					<li class="active"><a href="#section-1">第一部分</a></li>
					<li><a href="#section-2">第二部分</a></li>
					<li><a href="#section-3">第三部分</a></li>
					<li><a href="#section-4">第四部分</a></li>
					<li><a href="#section-5">第五部分</a></li>
				</ul>
			</div>
			<div class="col-xs-9">
				<h2 id="section-1">第一部分</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					eu sem tempor, varius quam at, luctus dui. Mauris magna metus,
					dapibus nec turpis vel, semper malesuada ante. Vestibulum id metus
					ac nisl bibendum scelerisque non non purus. Suspendisse varius nibh
					non aliquet sagittis. In tincidunt orci sit amet elementum
					vestibulum. Vivamus fermentum in arcu in aliquam. Quisque aliquam
					porta odio in fringilla. Vivamus nisl leo, blandit at bibendum eu,
					tristique eget risus. Integer aliquet quam ut elit suscipit, id
					interdum neque porttitor. Integer faucibus ligula.</p>
				<p>Vestibulum quis quam ut magna consequat faucibus.
					Pellentesque eget nisi a mi suscipit tincidunt. Ut tempus dictum
					risus. Pellentesque viverra sagittis quam at mattis. Suspendisse
					potenti. Aliquam sit amet gravida nibh, facilisis gravida odio.
					Phasellus auctor velit at lacus blandit, commodo iaculis justo
					viverra. Etiam vitae est arcu. Mauris vel congue dolor. Aliquam
					eget mi mi. Fusce quam tortor, commodo ac dui quis, bibendum
					viverra erat. Maecenas mattis lectus enim, quis tincidunt dui
					molestie euismod. Curabitur et diam tristique, accumsan nunc eu,
					hendrerit tellus.</p>
				<hr>
				<h2 id="section-2">第二部分</h2>
				<p>Nullam hendrerit justo non leo aliquet imperdiet. Etiam in
					sagittis lectus. Suspendisse ultrices placerat accumsan. Mauris
					quis dapibus orci. In dapibus velit blandit pharetra tincidunt.
					Quisque non sapien nec lacus condimentum facilisis ut iaculis enim.
					Sed viverra interdum bibendum. Donec ac sollicitudin dolor. Sed
					fringilla vitae lacus at rutrum. Phasellus congue vestibulum ligula
					sed consequat.</p>
				<p>Vestibulum consectetur scelerisque lacus, ac fermentum lorem
					convallis sed. Nam odio tortor, dictum quis malesuada at,
					pellentesque vitae orci. Vivamus elementum, felis eu auctor
					lobortis, diam velit egestas lacus, quis fermentum metus ante quis
					urna. Sed at facilisis libero. Cum sociis natoque penatibus et
					magnis dis parturient montes, nascetur ridiculus mus. Vestibulum
					bibendum blandit dolor. Nunc orci dolor, molestie nec nibh in,
					hendrerit tincidunt ante. Vivamus sem augue, hendrerit non sapien
					in, mollis ornare augue.</p>
				<hr>
				<h2 id="section-3">第三部分</h2>
				<p>Integer pulvinar leo id risus pellentesque vestibulum. Sed
					diam libero, sodales eget sapien vel, porttitor bibendum enim.
					Donec sed nibh vitae lorem porttitor blandit in nec ante.
					Pellentesque vitae metus ipsum. Phasellus sed nunc ac sem malesuada
					condimentum. Etiam in aliquam lectus. Nam vel sapien diam. Donec
					pharetra id arcu eget blandit. Proin imperdiet mattis augue in
					porttitor. Quisque tempus enim id lobortis feugiat. Suspendisse
					tincidunt risus quis dolor fringilla blandit. Ut sed sapien at
					purus lacinia porttitor. Nullam iaculis, felis a pretium ornare,
					dolor nisl semper tortor, vel sagittis lacus est consequat eros.
					Sed id pretium nisl. Curabitur dolor nisl, laoreet vitae aliquam
					id, tincidunt sit amet mauris.</p>
				<p>Phasellus vitae suscipit justo. Mauris pharetra feugiat ante
					id lacinia. Etiam faucibus mauris id tempor egestas. Duis luctus
					turpis at accumsan tincidunt. Phasellus risus risus, volutpat vel
					tellus ac, tincidunt fringilla massa. Etiam hendrerit dolor eget
					ante rutrum adipiscing. Cras interdum ipsum mattis, tempus mauris
					vel, semper ipsum. Duis sed dolor ut enim lobortis pellentesque
					ultricies ac ligula. Pellentesque convallis elit nisi, id vulputate
					ipsum ullamcorper ut. Cras ac pulvinar purus, ac viverra est.
					Suspendisse potenti. Integer pellentesque neque et elementum
					tempus. Curabitur bibendum in ligula ut rhoncus.</p>
				<p>Quisque pharetra velit id velit iaculis pretium. Nullam a
					justo sed ligula porta semper eu quis enim. Pellentesque
					pellentesque, metus at facilisis hendrerit, lectus velit facilisis
					leo, quis volutpat turpis arcu quis enim. Nulla viverra lorem
					elementum interdum ultricies. Suspendisse accumsan quam nec ante
					mollis tempus. Morbi vel accumsan diam, eget convallis tellus.
					Suspendisse potenti.</p>
				<hr>
				<h2 id="section-4">第四部分</h2>
				<p>Suspendisse a orci facilisis, dignissim tortor vitae,
					ultrices mi. Vestibulum a iaculis lacus. Phasellus vitae convallis
					ligula, nec volutpat tellus. Vivamus scelerisque mollis nisl, nec
					vehicula elit egestas a. Sed luctus metus id mi gravida, faucibus
					convallis neque pretium. Maecenas quis sapien ut leo fringilla
					tempor vitae sit amet leo. Donec imperdiet tempus placerat.
					Pellentesque pulvinar ultrices nunc sed ultrices. Morbi vel mi
					pretium, fermentum lacus et, viverra tellus. Phasellus sodales
					libero nec dui convallis, sit amet fermentum sapien auctor.
					Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
					posuere cubilia Curae; Sed eu elementum nibh, quis varius libero.</p>
				<p>Vestibulum quis quam ut magna consequat faucibus.
					Pellentesque eget nisi a mi suscipit tincidunt. Ut tempus dictum
					risus. Pellentesque viverra sagittis quam at mattis. Suspendisse
					potenti. Aliquam sit amet gravida nibh, facilisis gravida odio.
					Phasellus auctor velit at lacus blandit, commodo iaculis justo
					viverra. Etiam vitae est arcu. Mauris vel congue dolor. Aliquam
					eget mi mi. Fusce quam tortor, commodo ac dui quis, bibendum
					viverra erat. Maecenas mattis lectus enim, quis tincidunt dui
					molestie euismod. Curabitur et diam tristique, accumsan nunc eu,
					hendrerit tellus.</p>
				<p>Phasellus fermentum, neque sit amet sodales tempor, enim ante
					interdum eros, eget luctus ipsum eros ut ligula. Nunc ornare erat
					quis faucibus molestie. Proin malesuada consequat commodo. Mauris
					iaculis, eros ut dapibus luctus, massa enim elementum purus, sit
					amet tristique purus purus nec felis. Morbi vestibulum sapien eget
					porta pulvinar. Nam at quam diam. Proin rhoncus, felis elementum
					accumsan dictum, felis nisi vestibulum tellus, et ultrices risus
					felis in orci. Quisque vestibulum sem nisl, vel congue leo dictum
					nec. Cras eget est at velit sagittis ullamcorper vel et lectus. In
					hac habitasse platea dictumst. Etiam interdum iaculis velit, vel
					sollicitudin lorem feugiat sit amet. Etiam luctus, quam sed sodales
					aliquam, lorem libero hendrerit urna, faucibus rhoncus massa nibh
					at felis. Curabitur ac tempus nulla, ut semper erat. Vivamus porta
					ullamcorper sem, ornare egestas mauris facilisis id.</p>
				<p>Ut ut risus nisl. Fusce porttitor eros at magna luctus, non
					congue nulla eleifend. Aenean porttitor feugiat dolor sit amet
					facilisis. Pellentesque venenatis magna et risus commodo, a commodo
					turpis gravida. Nam mollis massa dapibus urna aliquet, quis iaculis
					elit sodales. Sed eget ornare orci, eu malesuada justo. Nunc lacus
					augue, dictum quis dui id, lacinia congue quam. Nulla sem sem,
					aliquam nec dolor ac, tempus convallis nunc. Interdum et malesuada
					fames ac ante ipsum primis in faucibus. Nulla suscipit convallis
					iaculis. Quisque eget commodo ligula. Praesent leo dui, facilisis
					quis eleifend in, aliquet vitae nunc. Suspendisse fermentum odio ac
					massa ultricies pellentesque. Fusce eu suscipit massa.</p>
				<hr>
				<h2 id="section-5">第五部分</h2>
				<p>Nam eget purus nec est consectetur vehicula. Nullam ultrices
					nisl risus, in viverra libero egestas sit amet. Etiam porttitor
					dolor non eros pulvinar malesuada. Vestibulum sit amet est mollis
					nulla tempus aliquet. Praesent luctus hendrerit arcu non laoreet.
					Morbi consequat placerat magna, ac ornare odio sagittis sed. Donec
					vitae ullamcorper purus. Vivamus non metus ac justo porta volutpat.</p>
				<p>Vivamus mattis accumsan erat, vel convallis risus pretium
					nec. Integer nunc nulla, viverra ut sem non, scelerisque vehicula
					arcu. Fusce bibendum convallis augue sit amet lobortis. Cras porta
					urna turpis, sodales lobortis purus adipiscing id. Maecenas
					ullamcorper, turpis suscipit pellentesque fringilla, massa lacus
					pulvinar mi, nec dignissim velit arcu eget purus. Nam at dapibus
					tellus, eget euismod nisl. Ut eget venenatis sapien. Vivamus
					vulputate varius mauris, vel varius nisl facilisis ac. Nulla
					aliquet justo a nibh ornare, eu congue neque rutrum.</p>
				<p>Suspendisse a orci facilisis, dignissim tortor vitae,
					ultrices mi. Vestibulum a iaculis lacus. Phasellus vitae convallis
					ligula, nec volutpat tellus. Vivamus scelerisque mollis nisl, nec
					vehicula elit egestas a. Sed luctus metus id mi gravida, faucibus
					convallis neque pretium. Maecenas quis sapien ut leo fringilla
					tempor vitae sit amet leo. Donec imperdiet tempus placerat.
					Pellentesque pulvinar ultrices nunc sed ultrices. Morbi vel mi
					pretium, fermentum lacus et, viverra tellus. Phasellus sodales
					libero nec dui convallis, sit amet fermentum sapien auctor.
					Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
					posuere cubilia Curae; Sed eu elementum nibh, quis varius libero.</p>
				<p>Morbi sed fermentum ipsum. Morbi a orci vulputate tortor
					ornare blandit a quis orci. Donec aliquam sodales gravida. In ut
					ullamcorper nisi, ac pretium velit. Vestibulum vitae lectus
					volutpat, consequat lorem sit amet, pulvinar tellus. In tincidunt
					vel leo eget pulvinar. Curabitur a eros non lacus malesuada
					aliquam. Praesent et tempus odio. Integer a quam nunc. In hac
					habitasse platea dictumst. Aliquam porta nibh nulla, et mattis
					turpis placerat eget. Pellentesque dui diam, pellentesque vel
					gravida id, accumsan eu magna. Sed a semper arcu, ut dignissim leo.</p>
				<p>Sed vitae lobortis diam, id molestie magna. Aliquam consequat
					ipsum quis est dictum ultrices. Aenean nibh velit, fringilla in
					diam id, blandit hendrerit lacus. Donec vehicula rutrum tellus eget
					fermentum. Pellentesque ac erat et arcu ornare tincidunt. Aliquam
					erat volutpat. Vivamus lobortis urna quis gravida semper. In
					condimentum, est a faucibus luctus, mi dolor cursus mi, id vehicula
					arcu risus a nibh. Pellentesque blandit sapien lacus, vel vehicula
					nunc feugiat sit amet.</p>
			</div>
		</div>
	</div>
</body>
</html>