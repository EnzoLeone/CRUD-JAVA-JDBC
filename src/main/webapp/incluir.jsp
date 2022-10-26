<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Produtos</title>
</head>
<body>
	<center>
		<table border="1" width="42%">
			<form action="ServletProdutos" method="post">
				<input type="hidden" name="cmd" value="incluir"> <br />
				<tr>
					<th colspan="2"><h1>Cadastro de produtos</h1></th>
				</tr>
				<tr>
					<td>Codigo:</td>
					<td><input type="text" name="txtCodigo" size="60" maxlength="60"></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="txtNome" size="60" maxlength="60"></td>
				</tr>
				<tr>
					<td>Descrição:</td>
					<td><input type="text" name="txtDescricao" size="60"
						maxlength="60"></td>
				</tr>
				<tr>
					<td>Quantidade:</td>
					<td><input type="text" name="txtQuantidade" size="60"
						maxlength="60"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Enviar"></td>
				</tr>
			</form>
		</table>
	</center>
</body>
</html>