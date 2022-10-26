import javax.swing.JOptionPane;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class Procurar {

	
	public static void main(String[] args) throws Exception {

		try {
			ProdutoDAO dao = new ProdutoDAO();

			Produto produto = dao.procurarProdutos(1);

			JOptionPane.showMessageDialog(null, "Codigo " + produto.getCodigo() + " - Nome " + produto.getNome()
			+ " - Descrição " + produto.getDescricao() + " - Quantidade " + produto.getQuantidade());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
