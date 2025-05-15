package br.com.appwegone;
import br.com.conexaobanco.*;
import java.sql.*;
import java.util.*;

public class Alemao {

	public static void cadastrar_orientacoes_alemao(Scanner leiaStr, Scanner leiaNum) {
		try (Connection conn = Conexao.getConexao()) {
			
			String titulo_orientacao = null;
			String conteudo_orientacao = null;
            String tipo = "";
            
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         REGISTRIEREN ANWEISUNG        ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.println("  1 - 🗂️ Bedienungsanleitung");
            System.out.println("  2 - 🗂️ Sicherheitsverfahren");
            System.out.println("  3 - 🗂️ Wartung und Reparaturen");
            System.out.println("  4 - 🗂️ Tests und Diagnose");
            System.out.println("  5 - 🗂️ Verhaltenskodex und Industriebetriebe ");
            System.out.println("═══════════════════════════════════════");
            System.out.print("  ? - Geben Sie den Typ ein: ");
            int tipoLeitura = leiaNum.nextInt();
                
            switch(tipoLeitura){
                case 1:
                    tipo = "Bedienungsanleitung"; 
                    break;
                case 2:
                    tipo = "Sicherheitsverfahren"; 
                    break;
                case 3:
                    tipo = "Wartung und Reparaturen"; 
                    break;
                case 4:
                    tipo = "Tests und Diagnose"; 
                    break;
                case 5:
                    tipo = "Verhaltenskodex und Industriebetriebe"; 
                    break;
                default:
                    tipo = ""; 
                    break;
            }
            if(tipo.equals("")){
            	System.out.println("\n╔═════════════════════════════════════╗");
	            System.out.println("║         ANWEISUNG UNGÜLTIG         ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }else{
            	
            	System.out.print("  ? - Titel der Anleitung: ");
                titulo_orientacao = leiaStr.nextLine();

                // Verifica se já existe esse título no banco
                String sqlVerifica = "SELECT COUNT(*) FROM orientacoesAlemao WHERE titulo_orientacaoAL = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║   FEHLER! TITEL BEREITS REGISTRIERT   ║");
                    System.out.println("╚═════════════════════════════════════╝\n");
                } else {
                	System.out.print("  ? - Anleitung Inhalte: ");
	                conteudo_orientacao = leiaStr.nextLine();
	                
	                String sql2 = "INSERT INTO orientacoesAlemao (titulo_orientacaoAL, tipo_orientacaoAL	, conteudo_orientacaoAL) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, titulo_orientacao);
	                stmt.setString(2, tipo);
	                stmt.setString(3, conteudo_orientacao);
	                stmt.executeUpdate();
	
	                System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║  BERATUNG ERFOLGREICH REGISTRIERT     ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
//-------------------------------------------------------------------------------------------------------------
	
	
    public static void listar_todas_orientacoes_Alemao(){
    	try (Connection conn = Conexao.getConexao()) {
    		boolean encontrado = false;
            String sql = "SELECT * FROM orientacoesAlemao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("");
            while (rs.next()) {
            	 encontrado = true;
            	 System.out.println("╔══════════════════════════════════════════╗");
                 System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoAL"), rs.getString("titulo_orientacaoAL"));
                 System.out.println("   Typ: " + rs.getString("tipo_orientacaoAL") );
                 System.out.println("   Inhalt: " + rs.getString("conteudo_orientacaoAL"));
                 System.out.println("╚══════════════════════════════════════════╝");
                 Thread.sleep(350);            
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║    KEINE ANLEITUNG GEFUNDEN         ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    public static void listar_orientacoes_Alemao_pelo_tipo(int tipoOrientacao) {
    	boolean encontrado = false;
    	try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoesAlemao where tipo_orientacaoAL = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           
            String tipoOrientacaoStr = "";
            
            switch(tipoOrientacao) {
            case 1:
            	tipoOrientacaoStr = "Bedienungsanleitung"; 
                break;
            case 2:
            	tipoOrientacaoStr = "Sicherheitsverfahren"; 
                break;
            case 3:
            	tipoOrientacaoStr = "Wartung und Reparaturen"; 
                break;
            case 4:
            	tipoOrientacaoStr = "Tests und Diagnose"; 
                break;
            case 5:
            	tipoOrientacaoStr = "Verhaltenskodex und Industriebetriebe"; 
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
                System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoAL"), rs.getString("titulo_orientacaoAL"));
                System.out.println("   Typ: " + rs.getString("tipo_orientacaoAL") );
                System.out.println("   Inhalt: " + rs.getString("conteudo_orientacaoAL"));
                System.out.println("╚══════════════════════════════════════════╝");
            	
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║      KEINE ANLEITUNG GEFUNDEN       ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 }
    
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    	public static void listar_orientacao_pelo_codigo_Alemao(int Codigo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesAlemao where codigo_orientacaoAL = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoAL"), rs.getString("titulo_orientacaoAL"));
                    System.out.println("   Typ: " + rs.getString("tipo_orientacaoAL") );
                    System.out.println("   Inhalt: " + rs.getString("conteudo_orientacaoAL"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║      KEINE ANLEITUNG GEFUNDEN       ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    		
    	public static void listar_orientacao_pelo_titulo_Alemao(String titulo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesAlemao where titulo_orientacaoAL = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoAL"), rs.getString("titulo_orientacaoAL"));
                    System.out.println("   Typ: " + rs.getString("tipo_orientacaoAL") );
                    System.out.println("   Inhalt: " + rs.getString("conteudo_orientacaoAL"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║       KEINE ANLEITUNG GEFUNDEN      ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    			
    	public static void editar_orientaçao_titulo_pelo_id_Alemao(Scanner leiaNum, Scanner leiaStr){
    		try (Connection conn = Conexao.getConexao()) {
    			boolean encontrado = false;
    			
    			String titulo_orientacao = null;
    			String conteudo_orientacao = null;
    			
    			System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║      ZUM AKTUALISIEREN ANLEITUNG      ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.print("  ? - Zu aktualisierende Orientierungs-ID: ");
                int codigo_orientacao = leiaNum.nextInt();
                
                String sql = "select * from orientacoesAlemao where codigo_orientacaoAL = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                	
                	String tituloAtual = rs.getString("titulo_orientacaoAL");
                    String conteudoAtual = rs.getString("conteudo_orientacaoAL");
                    
                	encontrado = true;
                	System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoAL"), rs.getString("titulo_orientacaoAL"));
                    System.out.println("   Typ: " + rs.getString("tipo_orientacaoAL") );
                    System.out.println("   Inhalt: " + rs.getString("conteudo_orientacaoAL"));
                    System.out.println("╚══════════════════════════════════════════╝\n");
                    
                    System.out.print("  ? - Neuer titel (drücken Enter um den Strom aufrechtzuerhalten): ");
                    titulo_orientacao = leiaStr.nextLine();
                    if (titulo_orientacao.trim().isEmALy()) {
                    	titulo_orientacao = tituloAtual;
                    }

                    System.out.print("  ? - Neuer Inhalt (pressione Enter um den Strom aufrechtzuerhalten): ");
                    conteudo_orientacao = leiaStr.nextLine();
                    if (conteudo_orientacao.trim().isEmALy()) {
                    	conteudo_orientacao = conteudoAtual;
                    }
                   
                }
                if(encontrado != true) {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║      KEINE ANLEITUNG GEFUNDEN       ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {

                String sql2 = "UPDATE orientacoesAlemao SET titulo_orientacaoAL = ?, conteudo_orientacaoAL = ? WHERE codigo_orientacaoAL = ?";
                PreparedStatement stmt = conn.prepareStatement(sql2);
                stmt.setString(1, titulo_orientacao);
                stmt.setString(2, conteudo_orientacao);
                stmt.setInt(3, codigo_orientacao);
                int linhasAfetadas = stmt.executeUpdate();

                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

                if (linhasAfetadas > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║  UPDATE ERFOLGREICH ABGESCHLOSSEN   ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║          ID NICHT GEFUNDEN          ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
             }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
    	
//-------------------------------------------------------------------------------------------------------------
    	    		
    	    			
    	    	public static void deletar_orientação_Alemao(Scanner leiaNum){
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			boolean encontrado = false;
    	    			
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	                System.out.println("║         ANLEITUNG ENTFERNE          ║");
    	                System.out.println("╚═════════════════════════════════════╝");
    	                System.out.print("  ? - Zu entfernende Anleitungs-ID: ");
    	                int codigo_orientacao = leiaNum.nextInt();   
    	                
    	                String sql = "select * from orientacoesAlemao where codigo_orientacaoAL = ?; ";
    	                PreparedStatement pstmt = conn.prepareStatement(sql);
    	                pstmt.setInt(1, codigo_orientacao);
    	                ResultSet rs = pstmt.executeQuery();
    	                
    	                if (rs.next()) {
          
    	                	encontrado = true;
    	                	Thread.sleep(300);
    	                	System.out.println("\n╔══════════════════════════════════════════╗");
    	                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoAL"), rs.getString("titulo_orientacaoAL"));
    	                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoAL") );
    	                    System.out.println("   Inhalt: " + rs.getString("conteudo_orientacaoAL"));
    	                    System.out.println("╚══════════════════════════════════════════╝\n");
    	                    Thread.sleep(300);
    	                }
    	                if(encontrado != true) {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║     KEINE ANLEITUNG GEFUNDEN        ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {

    	                String sql2 = "DELETE FROM orientacoesAlemao  WHERE codigo_orientacaoAL = ?";
    	                PreparedStatement stmt = conn.prepareStatement(sql2);
    	                stmt.setInt(1, codigo_orientacao);
    	                int linhasAfetadas = stmt.executeUpdate();

    	                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

    	                if (linhasAfetadas > 0) {
    	                    System.out.println("╔═════════════════════════════════════╗");
    	    	            System.out.println("║ ENTFERNUNG ERFOLGREICH ABGESCHLOSSEN║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║          ID NICHT GEFUNDEN          ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	                }
    	             }
    	                
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	    	
    	    
//-------------------------------------------------------------------------------------------------------------

    	    	
    	    	public static void mensagem_sair_sistema_Alemao() {
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			Thread.sleep(300);
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	    			Thread.sleep(300);
	    	            System.out.println("    🌐 SYSTEM WEGONE GESCHLOSSEN! 🌐   ");
	    	            Thread.sleep(300);
	    	            System.out.println("    ✨ KOMMEN SIE JEDERZEIT WIEDER ✨         ");
	    	            Thread.sleep(300);
	    	            System.out.println("╚═════════════════════════════════════╝\n");

    	    		} catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	
    	
    	
    	
    	
    	
    	
    	
}