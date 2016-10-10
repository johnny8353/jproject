<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" uri="http://tomcat.apache.org/jsp2-example-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>JSP 2.0 Expression Language - Functions</title>
  </head>
  <body>
    <h1>JSP 2.0 Expression Language - Functions</h1>
    <hr>
    An upgrade from the JSTL expression language, the JSP 2.0 EL also
    allows for simple function invocation.  Functions are defined
    by tag libraries and are implemented by a Java programmer as
    static methods.

    <blockquote>
      <u><b>Change Parameter</b></u>
      <form action="functions.jsp" method="GET">
          foo = <input type="text" name="foo" value="${fn:escapeXml(param["foo"])}">
          <input type="submit">
      </form>
      <br>
      <code>
        <table border="1">
          <thead>
            <td><b>EL Expression</b></td>
            <td><b>Result</b></td>
          </thead>
          <tr>
            <td>\${param["foo"]}</td>
            <td>${fn:escapeXml(param["foo"])}&nbsp;</td>
          </tr>
          <tr>
            <td>\${my:reverse(param["foo"])}</td>
            <td>${my:reverse(fn:escapeXml(param["foo"]))}&nbsp;</td>
          </tr>
          <tr>
            <td>\${my:reverse(my:reverse(param["foo"]))}</td>
            <td>${my:reverse(my:reverse(fn:escapeXml(param["foo"])))}&nbsp;</td>
          </tr>
          <tr>
            <td>\${my:countVowels(param["foo"])}</td>
            <td>${my:countVowels(fn:escapeXml(param["foo"]))}&nbsp;</td>
          </tr>
        </table>
      </code>
        <table border="1">
          <thead>
            <td><b>EL Expression</b></td>
            <td><b>Result</b></td>
          </thead>
          <tr>
            <td>\&nbsp; </td>
            <td>&nbsp;
                 *    & -> &amp;
			     *    < -> &lt;
			     *    > -> &gt;
			     *    " -> &#034;
			     *    ' -> &#039;
            </td>
          </tr>
        </table>
    </blockquote>
    <c:set var="str" value="stringStRiNg"/><br/>
	<c:set var="t" value="tr"/><br/>
	<c:out value="${str} = ${fn:length(str)}"/><br/>
	<c:out value="${fn:toLowerCase(str)}"/><br/>
	<c:out value="${fn:toUpperCase(str)}"/><br/>
	<c:out value="${fn:toUpperCase('AbCdEfg')}"/><br>
	<c:out value="${fn:substring('asdfefg',0,3)}"/><br>
	<c:out value="${fn:substringAfter('asdf','s')}"/><Br>
	<c:out value="${fn:substringBefore(str,'g')}"/><Br>
	<c:out value="${fn:trim(' sd dew e ')}"/><Br>
	<c:out value=" d sd dew e "/><Br>
	<c:out value="${fn:replace(str,'ing','IN')}"/><Br>
    
  </body>
</html>

