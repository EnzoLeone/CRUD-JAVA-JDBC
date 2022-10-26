import br.edu.unicid.dao.ProdutoDAO;

public class teste {
	
	public static void main(String[] args) throws Exception {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			
				System.out.println(dao.todosProdutos());
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
