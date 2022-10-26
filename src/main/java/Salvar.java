import javax.swing.JOptionPane;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class Salvar {

	public static void main(String[] args) throws Exception {

		try {
			ProdutoDAO dao = new ProdutoDAO();

			Produto produto = new Produto(3, "Celular", "Iphone 12 PRO MAX 128gb", 3);

			dao.salvar(produto);

			JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
