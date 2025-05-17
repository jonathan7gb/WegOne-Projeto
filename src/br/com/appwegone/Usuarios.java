package br.com.appwegone;
import br.com.conexaobanco.*;
import java.sql.*;
import java.util.*;

public class Usuarios {

    //PORTUGUÊS

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
            System.out.println("║         LOGIN SISTEMA WEGONE        ║");
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


//----------------------------------------------------------------------------------------------------


    //ENGLISH

    public static void cadastrar_usuario_en(Scanner leiaStr){
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
                    Usuarios.menu_login_en();
                }else{
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario) VALUES (?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                    Usuarios.menu_login_en();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu_login_en() {
        try (Connection conn = Conexao.getConexao()) {
        Scanner leiaNum = new Scanner(System.in);
        Scanner leiaStr = new Scanner(System.in);
            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         LOGIN WEGONE SYSTEM         ║");
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
                    Usuarios.fazer_login_en(leiaStr);
                    break;
                case 2:
                    Thread.sleep(300);
                    Usuarios.cadastrar_usuario_en(leiaStr);
                    break;
                default:
                    Thread.sleep(300);
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║          ESCOLHA INVÁLIDA           ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Usuarios.menu_login_en();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazer_login_en(Scanner leiaStr){
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
                    Usuarios.menu_login_en();
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
    

//----------------------------------------------------------------------------------------------------


    //ALEMÃO

    public static void cadastrar_usuario_al(Scanner leiaStr){
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
                    Usuarios.menu_login_al();
                }else{
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario) VALUES (?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                    Usuarios.menu_login_al();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu_login_al() {
        try (Connection conn = Conexao.getConexao()) {
        Scanner leiaNum = new Scanner(System.in);
        Scanner leiaStr = new Scanner(System.in);
            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         WEGONE SYSTEM-LOGIN         ║");
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
                    Usuarios.fazer_login_al(leiaStr);
                    break;
                case 2:
                    Thread.sleep(300);
                    Usuarios.cadastrar_usuario_al(leiaStr);
                    break;
                default:
                    Thread.sleep(300);
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║          ESCOLHA INVÁLIDA           ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Usuarios.menu_login_al();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazer_login_al(Scanner leiaStr){
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
                    Usuarios.menu_login_al();
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
    

//----------------------------------------------------------------------------------------------------


    //FRANCÊS

    public static void cadastrar_usuario_fr(Scanner leiaStr){
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
                    Usuarios.menu_login_fr();
                }else{
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario) VALUES (?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                    Usuarios.menu_login_fr();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu_login_fr() {
        try (Connection conn = Conexao.getConexao()) {
        Scanner leiaNum = new Scanner(System.in);
        Scanner leiaStr = new Scanner(System.in);
            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║     CONNEXION AU SYSTÈME WEGONE     ║");
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
                    Usuarios.fazer_login_fr(leiaStr);
                    break;
                case 2:
                    Thread.sleep(300);
                    Usuarios.cadastrar_usuario_fr(leiaStr);
                    break;
                default:
                    Thread.sleep(300);
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║          ESCOLHA INVÁLIDA           ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Usuarios.menu_login_fr();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazer_login_fr(Scanner leiaStr){
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
                    Usuarios.menu_login_fr();
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
 

//----------------------------------------------------------------------------------------------------


    //ESPANHOL

    public static void cadastrar_usuario_es(Scanner leiaStr){
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
                    Usuarios.menu_login_es();
                }else{
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario) VALUES (?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                    Usuarios.menu_login_es();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu_login_es() {
        try (Connection conn = Conexao.getConexao()) {
        Scanner leiaNum = new Scanner(System.in);
        Scanner leiaStr = new Scanner(System.in);
            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║ INICIO DE SESIÓN DEL SISTEMA WEGONE ║");
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
                    Usuarios.fazer_login_es(leiaStr);
                    break;
                case 2:
                    Thread.sleep(300);
                    Usuarios.cadastrar_usuario_es(leiaStr);
                    break;
                default:
                    Thread.sleep(300);
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║          ESCOLHA INVÁLIDA           ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Usuarios.menu_login_es();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fazer_login_es(Scanner leiaStr){
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
                    Usuarios.menu_login_es();
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
