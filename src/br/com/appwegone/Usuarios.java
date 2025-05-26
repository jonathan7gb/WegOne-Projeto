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

            if(senha.length() >= 8 &&
            senha.matches(".*[a-zA-Z].*") &&
            senha.matches(".*[0-9].*") &&
            senha.matches(".*[!@$#%*.].*")){
                
                String sqlVerifica = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║    NOME DE USUÁRIO JÁ CADASTRADO!   ║");
                    System.out.println("╚═════════════════════════════════════╝");
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
		            System.out.println("╚═════════════════════════════════════╝");
                }
            }else{
                System.out.println("\n╔═════════════════════════════════════╗");
		        System.out.println("║ SENHA INVÁLIDA. SENHA DEVE POSSUIR: ║");
		        System.out.println("║ - 8 CARACTERES OU MAIS              ║");
		        System.out.println("║ - 1 LETRA NO MÍNIMO                 ║");
		        System.out.println("║ - 1 NÚMERO NO MÍNIMO                ║");
		        System.out.println("║ - 1 CARACTER ESPECIAL (!@$#%*.)     ║");
		        System.out.println("╚═════════════════════════════════════╝");
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
                    System.out.println("     LOGADO! BEM-VINDO AO WEGONE ");
                    System.out.println("        Usuário: " + usuario + " ");
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
            System.out.println("║            REGISTER USER            ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - User: ");
            String usuario = leiaStr.nextLine();
            System.out.print("  ? - Password: ");
            String senha = leiaStr.nextLine();
            Thread.sleep(300);

            if(senha.length() >= 8 &&
            senha.matches(".*[a-zA-Z].*") &&
            senha.matches(".*[0-9].*") &&
            senha.matches(".*[!@$#%*.].*")){

                String sqlVerifica = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║    USERNAME ALREADY REGISTERED!     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    USER REGISTERED SUCCESSFULLY     ║");
		            System.out.println("╚═════════════════════════════════════╝");
                }
            }else{
                System.out.println("\n╔═══════════════════════════════════════╗");
                System.out.println("║ INVALID PASSWORD. PASSWORD MUST HAVE: ║");
                System.out.println("║ - 8 CHARACTERS OR MORE                ║");
                System.out.println("║ - AT LEAST 1 LETTER                   ║"); 
                System.out.println("║ - AT LEAST 1 NUMBER                   ║");
                System.out.println("║ - 1 SPECIAL CHARACTER (!@$#%*.)       ║");
                System.out.println("╚═══════════════════════════════════════╝\n");
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
                System.out.println("║         LOGIN SYSTEM WEGONE         ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Login");
                System.out.println(" 2 - Register: ");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Choice: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_en(leiaStr);
                        if (tipoUsuario.equals("invalid") || tipoUsuario.equals("error")) {
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
                        System.out.println("║            INVALID CHOICE           ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                }    
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String fazer_login_en(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║            LOGIN WEGONE             ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - User: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Password: ");
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
                    System.out.println("     LOGGED IN! WELCOME TO WEGONE ");
                    System.out.println("          User: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║      INVALID USER OR PASSWORD !     ║");
                    System.out.println("╚═════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "invalid";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


//----------------------------------------------------------------------------------------------------


    //ALEMÃO

    public static void cadastrar_usuario_al(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {
        
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║        BENUTZER REGISTRIEREN        ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Benutzer: ");
            String usuario = leiaStr.nextLine();
            System.out.print("  ? - Passwort: ");
            String senha = leiaStr.nextLine();
            Thread.sleep(300);

            if(senha.length() >= 8 &&
            senha.matches(".*[a-zA-Z].*") &&
            senha.matches(".*[0-9].*") &&
            senha.matches(".*[!@$#%*.].*")){

                String sqlVerifica = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║   BENUTZERNAME BEREITS REGISTRIERT! ║");
                    System.out.println("╚═════════════════════════════════════╝");
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║    BENUTZER ERFOLGREICH REGISTRIERT ║");
		            System.out.println("╚═════════════════════════════════════╝");
                }
                }else{
                System.out.println("\n╔══════════════════════════════════════╗");
		        System.out.println("║  UNGÜLTIGES PASSWORT.                ║");
		        System.out.println("║  DAS PASSWORT MUSS FOLGENDES HABEN:  ║");
		        System.out.println("║  - 8 ZEICHEN ODER MEHR               ║");
		        System.out.println("║  - MINDESTENS 1 BUCHSTABE            ║");
		        System.out.println("║  - 1 ZAHL MINDESTENS                 ║");
		        System.out.println("║  - 1 SONDERZEICHEN (!@$#%*.)         ║");
		        System.out.println("╚══════════════════════════════════════╝");
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
                System.out.println("║         WEGONE SYSTEM LOGIN         ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Login");
                System.out.println(" 2 - Registrieren");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Wählen Sie: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_al(leiaStr);
                        if (tipoUsuario.equals("untultig") || tipoUsuario.equals("Fehler")) {
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
                        System.out.println("║          WÄHLEN SIE UNGÜLTIG        ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                    }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Fehler";
        }
    }

    public static String fazer_login_al(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║    BETRETEN SIE DAS WEGONE-SYSTEM   ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Benutzer: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Passwort: ");
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
                    System.out.println("   ANGEMELDET! WILLKOMMEN BEI WEGONE ");
                    System.out.println("          Benutzer: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔════════════════════════════════════════════════════════╗");
                    System.out.println("║   UNGÜLTIGER BENUTZERNAME ODER UNGÜLTIGES PASSWORT!    ║");
                    System.out.println("╚════════════════════════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "untultig";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "Fehler";
        }
    }


//----------------------------------------------------------------------------------------------------


    //FRANCÊS

    public static void cadastrar_usuario_fr(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {
        
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║      ENREGISTRER L'UTILISATEUR      ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Utilisateur: ");
            String usuario = leiaStr.nextLine();
            System.out.print("  ? - Mot de passe: ");
            String senha = leiaStr.nextLine();
            Thread.sleep(300);

            if(senha.length() >= 8 &&
            senha.matches(".*[a-zA-Z].*") &&
            senha.matches(".*[0-9].*") &&
            senha.matches(".*[!@$#%*.].*")){

                String sqlVerifica = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║  NOM D'UTILISATEUR DÉJÀ ENREGISTRÉ! ║");
                    System.out.println("╚═════════════════════════════════════╝");
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║  UTILISATEUR ENREGISTRÉ AVEC SUCCÈS ║");
		            System.out.println("╚═════════════════════════════════════╝");
                }
            }else{
                System.out.println("\n╔════════════════════════════════════╗");
		        System.out.println("║  MOT DE PASSE INVALIDE.            ║");
		        System.out.println("║  LE MOT DE PASSE DOIT AVOIR:       ║");
		        System.out.println("║  - 8 CARACTÈRES OU PLUS            ║");
		        System.out.println("║  - 1 LETTRE AU MOINS               ║");
		        System.out.println("║  - 1 NUMÉRO AU MOINS               ║");
		        System.out.println("║  - 1 CARACTÈRE SPÉCIAL (!@$#%*.)   ║");
		        System.out.println("╚════════════════════════════════════╝");
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
                System.out.println("║     CONNEXION AU SYSTÈME WEGONE     ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Se connecter");
                System.out.println(" 2 - Registre");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Choix: ");
                int escolha_menu_login = leiaNum.nextInt();
    
                switch (escolha_menu_login) {
                    case 1:
                        Thread.sleep(300);
                        String tipoUsuario = Usuarios.fazer_login_fr(leiaStr);
                        if (tipoUsuario.equals("invalide") || tipoUsuario.equals("erreur")) {
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
                        System.out.println("║           CHOIX INVALIDE            ║");
                        System.out.println("╚═════════════════════════════════════╝");
                        break;
                    }
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
    }

    public static String fazer_login_fr(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {

            String usuario = "";
            String senha = "";

            Thread.sleep(300);
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║       CONNECTEZ-VOUS À WEGONE       ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Utilisateur: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Mot de passe: ");
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
                    System.out.println("    CONNECTÉ! BIENVENUE CHEZ WEGONE ");
                    System.out.println("        Utilisateur: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║NOM D'UTILISATEUR OU MOT DE PASSE INVALIDE!║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    Thread.sleep(300);
                    return "invalide";
                }

        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
    }


//----------------------------------------------------------------------------------------------------


    //ESPANHOL

    public static void cadastrar_usuario_es(Scanner leiaStr){
        try (Connection conn = Conexao.getConexao()) {
        
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║          REGISTRAR USUARIO          ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuario: ");
            String usuario = leiaStr.nextLine();
            System.out.print("  ? - Contraseña: ");
            String senha = leiaStr.nextLine();
            Thread.sleep(300);

            if(senha.length() >= 8 &&
            senha.matches(".*[a-zA-Z].*") &&
            senha.matches(".*[0-9].*") &&
            senha.matches(".*[!@$#%*.].*")){

                String sqlVerifica = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, usuario);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║        ¡USUARIO YA REGISTRADO!      ║");
                    System.out.println("╚═════════════════════════════════════╝");
                }else{
                    String tipo_user = "usuario";
                    String sql2 = "INSERT INTO usuarios (nome_usuario, senha_usuario, tipo_usuario) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, usuario);
	                stmt.setString(2, senha);
	                stmt.setString(3, tipo_user);

	                stmt.executeUpdate();
                    System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║   USUARIO REGISTRADO EXITOSAMENTE   ║");
		            System.out.println("╚═════════════════════════════════════╝");
                }
            }else{
                System.out.println("\n╔═════════════════════════════════════╗");
		        System.out.println("║ CONTRASEÑA INVÁLIDA.                ║");
		        System.out.println("║ LA CONTRASEÑA ES NECESARIA:         ║");
		        System.out.println("║ - 8 PERSONAJES O MÁS                ║");
		        System.out.println("║ - 1 CARTAS AL MENOS                 ║");
		        System.out.println("║ - 1 NÚMERO MÍNIMO                   ║");
		        System.out.println("║ - 1 CARÁCTER ESPECIAL (!@$#%*.)     ║");
		        System.out.println("╚═════════════════════════════════════╝");
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
                System.out.println("║ INICIO DE SESIÓN DEL SISTEMA WEGONE ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.println(" 1 - Acceso");
                System.out.println(" 2 - Registro");
                System.out.println("═══════════════════════════════════════");
                Thread.sleep(300);
                System.out.print(" ? - Elección: ");
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
                        System.out.println("║            OPCIÓN INVÁLIDA          ║");
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
            System.out.println("║       INICIAR SESIÓN EN WEGONE      ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.print("  ? - Usuario: ");
            usuario = leiaStr.nextLine();
            System.out.print("  ? - Contraseña: ");
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
                    System.out.println("    ¡INICIÓ SESIÓN! BIENVENIDO A WEGONE ");
                    System.out.println("           Usuario: " + usuario + " ");
                    System.out.println("╚═════════════════════════════════════╝\n");
                    Thread.sleep(300);
        
                    return tipo;
                } else {
                    System.out.println("\n╔════════════════════════════════════════════╗");
                    System.out.println("║ ¡NOMBRE DE USUARIO O CONTRASEÑA INVÁLIDOS! ║");
                    System.out.println("╚════════════════════════════════════════════╝");
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