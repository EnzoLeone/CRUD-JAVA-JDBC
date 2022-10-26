<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.edu.unicid.bean.Produto"%>

<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>


<html>
<head>
<title>Listar Produtos</title>
</head>
<body>
	<center>
		<table width="100%" border="1" cellpadding="2" cellspacing="0">
			<tr>
				<th colspan="6"><h3>Lista de Produtos</h3></th>

			</tr>
			<tr>
				<th>Código do Produto</th>
				<th>Nome do Produto</th>
				<th>Descrição do Produto</th>
				<th>Quantidade do Produto</th>
			</tr>
			<%
			List<Produto> listar = new ArrayList<Produto>();
			listar = (ArrayList) request.getAttribute("ProdutoList");
			for (Produto p : listar) {
			%>
			<tr>
				<td><%=p.getCodigo()%></td>
				<td><%=p.getNome()%></td>
				<td><%=p.getDescricao()%></td>
				<td><%=p.getQuantidade()%></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="6" align="center"><a href="index.jsp">Página
						Principal</a></td>
			</tr>
		</table>
	</center>
</body>
</html>