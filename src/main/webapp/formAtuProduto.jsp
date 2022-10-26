<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>

<html>
<head>
<title>Alterar Produtos</title>
</head>
<body>
	<h3 align="center">Alterar Produtos</h3>
	<jsp:useBean id="produto" scope="session"
		class="br.edu.unicid.bean.Produto" />

	<form action="ServletProdutos?cmd=atualizar" method="post">
		<center>
			<table>
				<tr>
					<td>Código:</td>
					<td><input type="text" maxlength="60" size="60" name="txtCodigo"
						value="<%=produto.getCodigo()%>" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type="text" maxlength="60" size="60" name="txtNome"
						value="<%=produto.getNome()%>" /></td>
				</tr>
				<tr>
					<td>Descrição</td>
					<td><input type="text" maxlength="60" size="60"
						name="txtDescricao" value="<%=produto.getDescricao()%>" /></td>
				</tr>
				<tr>
					<td>Quantidade:</td>
					<td><input type="text" maxlength="60" size="60"
						name="txtQuantidade" value="<%=produto.getQuantidade()%>" /></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" name="btnAlterar"
						value="Confirma Alteração" /></th>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>