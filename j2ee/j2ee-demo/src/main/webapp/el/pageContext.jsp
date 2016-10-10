<%@ page contentType="text/html;charset=GB2312"%>
<html>
	<head>
		<title>CH6 - pageContext.jsp</title>
	</head>
	<body>
		<h2>
			EL Òþº¬¶ÔÏó pageContext
		</h2>
		\${pageContext.request.queryString}:${pageContext.request.queryString}
		</br>
		\${pageContext.request.requestURL}:${pageContext.request.requestURL}
		</br>
		\${pageContext.request.contextPath}:${pageContext.request.contextPath}
		</br>
		\${pageContext.request.method}:${pageContext.request.method}
		</br>
		\${pageContext.request.protocol}:${pageContext.request.protocol}
		</br>
		\${pageContext.request.remoteUser}:${pageContext.request.remoteUser}
		</br>
		\${pageContext.request.remoteAddr }:${pageContext.request.remoteAddr}
		</br>
		\${pageContext.session.new}:
		<%-- 
		±¨´í${pageContext.session.new}
		 --%>
		
		</br>
		\${pageContext.session.id}:${pageContext.session.id}
		</br>
	</body>
</html>