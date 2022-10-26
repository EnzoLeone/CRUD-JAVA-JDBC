import javax.swing.JOptionPane;

import br.edu.unicid.dao.ProdutoDAO;

public class Excluir {
	
	public static void main(String[] args) throws Exception {

		try {
			ProdutoDAO dao = new ProdutoDAO();

			dao.excluir(3);

			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
