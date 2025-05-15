package br.com.appwegone;
import br.com.conexaobanco.*;
import java.sql.*;
import java.util.*;

public class Francais {

	public static void cadastrar_orientacoes_francais(Scanner leiaStr, Scanner leiaNum) {
		try (Connection conn = Conexao.getConexao()) {
			
			String titulo_orientacao = null;
			String conteudo_orientacao = null;
            String tipo = "";
            
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║          S'INSCRIRE        ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.println("  1 - 🗂️ Manuel d'utilisation             ");
            System.out.println("  2 - 🗂️ Procédure de sécurité        ");
            System.out.println("  3 - 🗂️ Entretien et réparations            ");
            System.out.println("  4 - 🗂️ Tests et diagnostics            ");
            System.out.println("  5 - 🗂️ Manuel de conduite et d'exploitation sectoriel ");
            System.out.println("═══════════════════════════════════════");
            System.out.print("  ? - Entrez le type: ");
            int tipoLeitura = leiaNum.nextInt();
                
            switch(tipoLeitura){
                case 1:
                    tipo = "Manuel d'utilisation"; 
                    break;
                case 2:
                    tipo = "Procédure de sécurité"; 
                    break;
                case 3:
                    tipo = "Entretien et réparations"; 
                    break;
                case 4:
                    tipo = "Tests et diagnostics"; 
                    break;
                case 5:
                    tipo = "Manuel de conduite et d'exploitation sectoriel"; 
                    break;
                default:
                    tipo = ""; 
                    break;
            }
            if(tipo.equals("")){
            	System.out.println("\n╔═════════════════════════════════════╗");
	            System.out.println("║        ORIENTATION INVALIDE         ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }else{
            	
            	System.out.print("  ? - Titre de l'orientation: ");
                titulo_orientacao = leiaStr.nextLine();

                // Verifica se já existe esse título no banco
                String sqlVerifica = "SELECT COUNT(*) FROM orientacoesFrances WHERE titulo_orientacaoFR = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║    ERREUR! TITRE DÉJÀ ENREGISTRÉ    ║");
                    System.out.println("╚═════════════════════════════════════╝\n");
                } else {
                	System.out.print("  ? - Contenu du guide: ");
	                conteudo_orientacao = leiaStr.nextLine();
	                
	                String sql2 = "INSERT INTO orientacoesFrances (titulo_orientacaoFR, tipo_orientacaoFR	, conteudo_orientacaoFR) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, titulo_orientacao);
	                stmt.setString(2, tipo);
	                stmt.setString(3, conteudo_orientacao);
	                stmt.executeUpdate();
	
	                System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║  GUIDANCE ENREGISTRÉ AVEC SUCCÈS  ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
//-------------------------------------------------------------------------------------------------------------
	
	
    public static void listar_todas_orientacoes_Francais(){
    	try (Connection conn = Conexao.getConexao()) {
    		boolean encontrado = false;
            String sql = "SELECT * FROM orientacoesFrances";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("");
            while (rs.next()) {
            	 encontrado = true;
            	 System.out.println("╔══════════════════════════════════════════╗");
                 System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoFR"), rs.getString("titulo_orientacaoFR"));
                 System.out.println("   Taper: " + rs.getString("tipo_orientacaoFR") );
                 System.out.println("   Contenu: " + rs.getString("conteudo_orientacaoFR"));
                 System.out.println("╚══════════════════════════════════════════╝");
                 Thread.sleep(350);            
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║      AUCUNE ORIENTATION TROUVÉE     ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    public static void listar_orientacoes_Francais_pelo_tipo(int tipoOrientacao) {
    	boolean encontrado = false;
    	try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoesFrances where tipo_orientacaoFR = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           
            String tipoOrientacaoStr = "";
            
            switch(tipoOrientacao) {
            case 1:
            	tipoOrientacaoStr = "Manuel d'utilisation"; 
                break;
            case 2:
            	tipoOrientacaoStr = "Procédure de sécurité"; 
                break;
            case 3:
            	tipoOrientacaoStr = "Entretien et réparations"; 
                break;
            case 4:
            	tipoOrientacaoStr = "Tests et diagnostics"; 
                break;
            case 5:
            	tipoOrientacaoStr = "Manuel de conduite et d'exploitation sectoriel"; 
                break;
            default:
            	tipoOrientacaoStr = ""; 
                break;
            }
            
            pstmt.setString(1, tipoOrientacaoStr);
            
            ResultSet rs = pstmt.executeQuery();
            
            System.out.println("");
            
            while (rs.next()) {
            	encontrado = true;
            	System.out.println("╔══════════════════════════════════════════╗");
                System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoFR"), rs.getString("titulo_orientacaoFR"));
                System.out.println("   Taper: " + rs.getString("tipo_orientacaoFR") );
                System.out.println("   Contenu: " + rs.getString("conteudo_orientacaoFR"));
                System.out.println("╚══════════════════════════════════════════╝");
            	
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║      AUCUNE ORIENTATION TROUVÉE     ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 }
    
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    	public static void listar_orientacao_pelo_codigo_Francais(int Codigo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesFrances where codigo_orientacaoFR = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoFR"), rs.getString("titulo_orientacaoFR"));
                    System.out.println("   Taper: " + rs.getString("tipo_orientacaoFR") );
                    System.out.println("   Contenu: " + rs.getString("conteudo_orientacaoFR"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║    AUCUNE ORIENTATION TROUVÉE       ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    		
    	public static void listar_orientacao_pelo_titulo_Francais(String titulo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesFrances where titulo_orientacaoFR = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoFR"), rs.getString("titulo_orientacaoFR"));
                    System.out.println("   Taper: " + rs.getString("tipo_orientacaoFR") );
                    System.out.println("   Contenu: " + rs.getString("conteudo_orientacaoFR"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║    AUCUNE ORIENTATION TROUVÉE       ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    			
    	public static void editar_orientaçao_titulo_pelo_id_Francais(Scanner leiaNum, Scanner leiaStr){
    		try (Connection conn = Conexao.getConexao()) {
    			boolean encontrado = false;
    			
    			String titulo_orientacao = null;
    			String conteudo_orientacao = null;
    			
    			System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║         GUIDE DE MODIFICATION       ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.print("  ? - ID de guidage à mettre à jour: ");
                int codigo_orientacao = leiaNum.nextInt();
                
                String sql = "select * from orientacoesFrances where codigo_orientacaoFR = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                	
                	String tituloAtual = rs.getString("titulo_orientacaoFR");
                    String conteudoAtual = rs.getString("conteudo_orientacaoFR");
                    
                	encontrado = true;
                	System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoFR"), rs.getString("titulo_orientacaoFR"));
                    System.out.println("   Taper: " + rs.getString("tipo_orientacaoFR") );
                    System.out.println("   Contenu: " + rs.getString("conteudo_orientacaoFR"));
                    System.out.println("╚══════════════════════════════════════════╝\n");
                    
                    System.out.print("  ? - Nouveau titre (appuyez sur Entrée pour conserver la mise à jour) : ");
                    titulo_orientacao = leiaStr.nextLine();
                    if (titulo_orientacao.trim().isEmFRy()) {
                    	titulo_orientacao = tituloAtual;
                    }

                    System.out.print("  ? - Nouveau titre (appuyez sur Entrée pour conserver la mise à jour) : ");
                    conteudo_orientacao = leiaStr.nextLine();
                    if (conteudo_orientacao.trim().isEmFRy()) {
                    	conteudo_orientacao = conteudoAtual;
                    }
                   
                }
                if(encontrado != true) {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║    AUCUNE ORIENTATION TROUVÉE       ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {

                String sql2 = "UPDATE orientacoesFrances SET titulo_orientacaoFR = ?, conteudo_orientacaoFR = ? WHERE codigo_orientacaoFR = ?";
                PreparedStatement stmt = conn.prepareStatement(sql2);
                stmt.setString(1, titulo_orientacao);
                stmt.setString(2, conteudo_orientacao);
                stmt.setInt(3, codigo_orientacao);
                int linhasAfetadas = stmt.executeUpdate();

                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

                if (linhasAfetadas > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║  MISE À JOUR TERMINÉE AVEC SUCCÈS   ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║             ID NON TROUVÉ           ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
             }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
    	
//-------------------------------------------------------------------------------------------------------------
    	    		
    	    			
    	    	public static void deletar_orientação_Francais(Scanner leiaNum){
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			boolean encontrado = false;
    	    			
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	                System.out.println("║        SUPPRIMER LE GUIDAGE         ║");
    	                System.out.println("╚═════════════════════════════════════╝");
    	                System.out.print("  ? - ID de guidage à supprimer: ");
    	                int codigo_orientacao = leiaNum.nextInt();   
    	                
    	                String sql = "select * from orientacoesFrances where codigo_orientacaoFR = ?; ";
    	                PreparedStatement pstmt = conn.prepareStatement(sql);
    	                pstmt.setInt(1, codigo_orientacao);
    	                ResultSet rs = pstmt.executeQuery();
    	                
    	                if (rs.next()) {
          
    	                	encontrado = true;
    	                	Thread.sleep(300);
    	                	System.out.println("\n╔══════════════════════════════════════════╗");
    	                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoFR"), rs.getString("titulo_orientacaoFR"));
    	                    System.out.println("   Taper: " + rs.getString("tipo_orientacaoFR") );
    	                    System.out.println("   Contenu: " + rs.getString("conteudo_orientacaoFR"));
    	                    System.out.println("╚══════════════════════════════════════════╝\n");
    	                    Thread.sleep(300);
    	                }
    	                if(encontrado != true) {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║    AUCUNE ORIENTATION TROUVÉE       ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {

    	                String sql2 = "DELETE FROM orientacoesFrances  WHERE codigo_orientacaoFR = ?";
    	                PreparedStatement stmt = conn.prepareStatement(sql2);
    	                stmt.setInt(1, codigo_orientacao);
    	                int linhasAfetadas = stmt.executeUpdate();

    	                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

    	                if (linhasAfetadas > 0) {
    	                    System.out.println("╔═════════════════════════════════════╗");
    	    	            System.out.println("║    RETRAIT TERMINÉ AVEC SUCCÈS      ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║            ID NON TROUVÉ            ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	                }
    	             }
    	                
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	    	
    	    
//-------------------------------------------------------------------------------------------------------------

    	    	
    	    	public static void mensagem_sair_sistema_Francais() {
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			Thread.sleep(300);
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	    			Thread.sleep(300);
	    	            System.out.println("    🌐 SYSTÈME WEGONE FERMÉ ! 🌐   ");
	    	            Thread.sleep(300);
	    	            System.out.println("           ✨ REVENEZ À TOUT MOMENT ✨         ");
	    	            Thread.sleep(300);
	    	            System.out.println("╚═════════════════════════════════════╝\n");

    	    		} catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	
    	
    	
    	
    	
    	
    	
    	
}