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
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String menu_login_pt() {
        try (Connection conn = Conexao.getConexao()) {
            Scanner leiaNum = new Scanner(System.in);
            Scanner leiaStr = new Scanner(System.in);
    
            while (true) {
                Thread.sleep(300);
                System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║         LOGIN SISTEMA WEGONE        ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Fazer Login");
                System.out.println(" 2 - Fazer Cadastro");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Escolha: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_pt(leiaStr);
                        if (tipoUsuario.equals("invalido") || tipoUsuario.equals("erro")) {
                            break;
                        } else {
                            return tipoUsuario;
                        }
    
                    case 2:
                        Thread.sleep(300);
                        Usuarios.cadastrar_usuario_pt(leiaStr);
                        break;
    
                    default:
                        Thread.sleep(300);
                        System.out.println("\n╔═════════════════════════════════════╗");
                        System.out.println("║          ESCOLHA INVÁLIDA           ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                }
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public static String fazer_login_pt(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         FAZER LOGIN WEGONE          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuário: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Senha: ");
            senha = leiaStr.nextLine();
            Thread.sleep(300);
           
                String sqlVerifica = "SELECT tipo_usuario FROM usuarios WHERE nome_usuario = ? and senha_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                pstmt.setString(2, senha);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    String tipo = rs.getString("tipo_usuario");
        
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("      LOGADO! BEM-VINDO AO WEGONE ");
                    System.out.println("          Usuário: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║     USUÁRIO OU SENHA INVÁLIDOS!     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "invalido";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
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
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String menu_login_en() {
        try (Connection conn = Conexao.getConexao()) {
            Scanner leiaNum = new Scanner(System.in);
            Scanner leiaStr = new Scanner(System.in);
    
            while (true) {
                Thread.sleep(300);
                System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║         LOGIN SISTEMA WEGONE        ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Fazer Login");
                System.out.println(" 2 - Fazer Cadastro");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Escolha: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_en(leiaStr);
                        if (tipoUsuario.equals("invalido") || tipoUsuario.equals("erro")) {
                            break;
                        } else {
                            return tipoUsuario;
                        }
    
                    case 2:
                        Thread.sleep(300);
                        Usuarios.cadastrar_usuario_en(leiaStr);
                        break;
    
                    default:
                        Thread.sleep(300);
                        System.out.println("\n╔═════════════════════════════════════╗");
                        System.out.println("║          ESCOLHA INVÁLIDA           ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                }
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public static String fazer_login_en(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         FAZER LOGIN WEGONE          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuário: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Senha: ");
            senha = leiaStr.nextLine();
            Thread.sleep(300);
           
                String sqlVerifica = "SELECT tipo_usuario FROM usuarios WHERE nome_usuario = ? and senha_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                pstmt.setString(2, senha);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    String tipo = rs.getString("tipo_usuario");
        
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("      LOGADO! BEM-VINDO AO WEGONE ");
                    System.out.println("          Usuário: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║     USUÁRIO OU SENHA INVÁLIDOS!     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "invalido";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
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
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String menu_login_al() {
        try (Connection conn = Conexao.getConexao()) {
            Scanner leiaNum = new Scanner(System.in);
            Scanner leiaStr = new Scanner(System.in);
    
            while (true) {
                Thread.sleep(300);
                System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║         LOGIN SISTEMA WEGONE        ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Fazer Login");
                System.out.println(" 2 - Fazer Cadastro");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Escolha: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_al(leiaStr);
                        if (tipoUsuario.equals("invalido") || tipoUsuario.equals("erro")) {
                            break;
                        } else {
                            return tipoUsuario;
                        }
    
                    case 2:
                        Thread.sleep(300);
                        Usuarios.cadastrar_usuario_al(leiaStr);
                        break;
    
                    default:
                        Thread.sleep(300);
                        System.out.println("\n╔═════════════════════════════════════╗");
                        System.out.println("║          ESCOLHA INVÁLIDA           ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                }
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public static String fazer_login_al(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         FAZER LOGIN WEGONE          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuário: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Senha: ");
            senha = leiaStr.nextLine();
            Thread.sleep(300);
           
                String sqlVerifica = "SELECT tipo_usuario FROM usuarios WHERE nome_usuario = ? and senha_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                pstmt.setString(2, senha);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    String tipo = rs.getString("tipo_usuario");
        
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("      LOGADO! BEM-VINDO AO WEGONE ");
                    System.out.println("          Usuário: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║     USUÁRIO OU SENHA INVÁLIDOS!     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "invalido";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
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
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String menu_login_fr() {
        try (Connection conn = Conexao.getConexao()) {
            Scanner leiaNum = new Scanner(System.in);
            Scanner leiaStr = new Scanner(System.in);
    
            while (true) {
                Thread.sleep(300);
                System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║         LOGIN SISTEMA WEGONE        ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Fazer Login");
                System.out.println(" 2 - Fazer Cadastro");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Escolha: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_fr(leiaStr);
                        if (tipoUsuario.equals("invalido") || tipoUsuario.equals("erro")) {
                            break;
                        } else {
                            return tipoUsuario;
                        }
    
                    case 2:
                        Thread.sleep(300);
                        Usuarios.cadastrar_usuario_fr(leiaStr);
                        break;
    
                    default:
                        Thread.sleep(300);
                        System.out.println("\n╔═════════════════════════════════════╗");
                        System.out.println("║          ESCOLHA INVÁLIDA           ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                }
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public static String fazer_login_fr(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         FAZER LOGIN WEGONE          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuário: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Senha: ");
            senha = leiaStr.nextLine();
            Thread.sleep(300);
           
                String sqlVerifica = "SELECT tipo_usuario FROM usuarios WHERE nome_usuario = ? and senha_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                pstmt.setString(2, senha);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    String tipo = rs.getString("tipo_usuario");
        
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("      LOGADO! BEM-VINDO AO WEGONE ");
                    System.out.println("          Usuário: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║     USUÁRIO OU SENHA INVÁLIDOS!     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "invalido";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
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
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USUÁRIO CADASTRADO COM SUCESSO   ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String menu_login_es() {
        try (Connection conn = Conexao.getConexao()) {
            Scanner leiaNum = new Scanner(System.in);
            Scanner leiaStr = new Scanner(System.in);
    
            while (true) {
                Thread.sleep(300);
                System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║         LOGIN SISTEMA WEGONE        ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Fazer Login");
                System.out.println(" 2 - Fazer Cadastro");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Escolha: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_es(leiaStr);
                        if (tipoUsuario.equals("invalido") || tipoUsuario.equals("erro")) {
                            break;
                        } else {
                            return tipoUsuario;
                        }
    
                    case 2:
                        Thread.sleep(300);
                        Usuarios.cadastrar_usuario_es(leiaStr);
                        break;
    
                    default:
                        Thread.sleep(300);
                        System.out.println("\n╔═════════════════════════════════════╗");
                        System.out.println("║          ESCOLHA INVÁLIDA           ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                }
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public static String fazer_login_es(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         FAZER LOGIN WEGONE          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuário: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Senha: ");
            senha = leiaStr.nextLine();
            Thread.sleep(300);
           
                String sqlVerifica = "SELECT tipo_usuario FROM usuarios WHERE nome_usuario = ? and senha_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                pstmt.setString(2, senha);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    String tipo = rs.getString("tipo_usuario");
        
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("      LOGADO! BEM-VINDO AO WEGONE ");
                    System.out.println("          Usuário: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║     USUÁRIO OU SENHA INVÁLIDOS!     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "invalido";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }


//----------------------------------------------------------------------------------------------------


}