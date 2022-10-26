import javax.swing.JOptionPane;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class Atualizar {

	public static void main(String[] args) throws Exception {

		try {
			ProdutoDAO dao = new ProdutoDAO();

			Produto produto = new Produto(3, "Kevin", "Iphone 13 PRO MAX 128gb", 2);

			dao.atualizar(produto);

			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
