package br.edu.unicid.web;

import java.io.IOException;
import java.util.List;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAlunos
 */
@WebServlet("/ServletProdutos")
public class ServletProdutos extends HttpServlet {


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
		String cmd = request.getParameter("cmd");
		// cria um objeto dao - CRUD
		ProdutoDAO dao;
		// cria um objeto do tipo produto
		Produto produto = new Produto();
		if (cmd != null) {
			try {
				// inicializa os atributos da classe Produtos
				produto.setCodigo(Integer.parseInt(request.getParameter("txtCodigo")));
				produto.setNome(request.getParameter("txtNome"));
				produto.setDescricao(request.getParameter("txtDescricao"));
				produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		try {
			// cria a instancia do objeto dao
			dao = new ProdutoDAO();
			RequestDispatcher rd = null;
			// lista todos os Produtos
			if (cmd.equalsIgnoreCase("listar")) {
				List ProdutoList = dao.todosProdutos();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("ProdutoList", ProdutoList);
				// redireciona para a JSP mostraProdutos
				rd = request.getRequestDispatcher("/mostrarProdutos.jsp");
			}

			// incluir produto
			else if (cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(produto);
				rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");

				// consulta produto para exclusão
			} else if (cmd.equalsIgnoreCase("exc")) {
				produto = dao.procurarProdutos(produto.getCodigo());
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);
				rd = request.getRequestDispatcher("/formExcProduto.jsp");

				// exclui produto
			} else if (cmd.equalsIgnoreCase("excluir")) {
				dao.excluir(produto.getCodigo());
				rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");

				// consulta produto para alteração
			} else if (cmd.equalsIgnoreCase("atu")) {
				produto = dao.procurarProdutos(produto.getCodigo());
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);
				rd = request.getRequestDispatcher("/formAtuProduto.jsp");

				// consulta produto
			} else if (cmd.equalsIgnoreCase("con")) {
				produto = dao.procurarProdutos(produto.getCodigo());
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);
				rd = request.getRequestDispatcher("/formConProduto.jsp");

				// altera produto
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(produto);
				rd = request.getRequestDispatcher("ServletProdutos?cmd=listar");

				// direciona para a página principal
			} else if (cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");
			}
			// executa a ação de direcionar para a página JSP
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
