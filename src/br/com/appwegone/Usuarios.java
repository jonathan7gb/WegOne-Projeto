package br.com.appwegone;
import br.com.conexaobanco.*;
import java.sql.*;
import java.util.*;

public class Usuarios {

    
    public static void cadastrar_usuario_pt(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {
        
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║          CADASTRAR USUÁRIO          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuário: ");
            String usuario = leiaStr.nextLine();
            System.out.print("  ? - Senha: ");
            String senha = leiaStr.nextLine();
            Thread.sleep(300);

                String sqlVerifica = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║    NOME DE USUÁRIO JÁ CADASTRADO!   ║");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Usuarios.menu_login_pt();
                }else{
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario) VALUES (?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                    Usuarios.menu_login_pt();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu_login_pt() {
        try (Connection conn = Conexao.getConexao()) {
        Scanner leiaNum = new Scanner(System.in);
        Scanner leiaStr = new Scanner(System.in);
            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║       REALIZAR LOGIN WEGONE         ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.println(" 1 - Fazer Login");
            System.out.println(" 1 - Fazer Cadastro");
            System.out.println("═══════════════════════════════════════");
            Thread.sleep(300);
            System.out.print("  ? - Escolha: ");
            int escolha_menu_login = leiaNum.nextInt();

            switch(escolha_menu_login) {
                case 1:
                    Thread.sleep(300);
                    Usuarios.fazer_login_pt(leiaStr);
                    break;
                case 2:
                    Thread.sleep(300);
                    Usuarios.cadastrar_usuario_pt(leiaStr);
                    break;
                default:
                    Thread.sleep(300);
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║          ESCOLHA INVÁLIDA           ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Usuarios.menu_login_pt();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazer_login_pt(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         FAZER LOGIN WEGONE          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuário: ");
            String usuario = leiaStr.nextLine();
            System.out.print("  ? - Senha: ");
            String senha = leiaStr.nextLine();

                String sqlVerifica = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ? and senha_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                pstmt.setString(2, senha);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade == 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║     USUÁRIO OU SENHA INVÁLIDOS!     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Usuarios.menu_login_pt();
               }else{
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("      LOGADO! BEM-VINDO AO WEGONE ");
                    System.out.println("          Usuário: "+usuario+" ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
