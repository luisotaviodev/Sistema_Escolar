import edu.luis.InicializacaoSistema.InicializadorSistema;
import edu.luis.Operacoes.MenuOperacoes;

public class Main {
    public static void main(String[] args) throws Exception {
        
        InicializadorSistema oIniciarSistema = new InicializadorSistema(); 
        MenuOperacoes oMenuOperacoes    = new MenuOperacoes(); 
        oIniciarSistema.CriarTabelas();
        oMenuOperacoes.OperacoesMenu();
        
    }
}
