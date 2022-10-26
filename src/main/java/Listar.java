import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class Listar {
	
	public static void main(String[] args) throws Exception {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			
			for (Produto p: dao.todosProdutos()) {
				System.out.println("Codigo = "+p.getCodigo() + " | Nome = "+p.getNome()+
						" | Descrição = "+p.getDescricao() + " | Quantidade = "+p.getQuantidade());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
