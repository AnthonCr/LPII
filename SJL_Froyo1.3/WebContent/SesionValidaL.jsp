<%
	if(session.getAttribute("USUARIO_LOGEADO") != null){;
		pageContext.forward("/index.jsp");
	}
%>