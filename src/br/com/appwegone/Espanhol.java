package br.com.appwegone;
import br.com.conexaobanco.*;
import java.sql.*;
import java.util.*;

public class Espanhol{

	public static void cadastrar_orientacoes_espanhol(Scanner leiaStr, Scanner leiaNum) {
		try (Connection conn = Conexao.getConexao()) {
			
			String titulo_orientacao = null;
			String conteudo_orientacao = null;
            String tipo = "";
            Thread.sleep(350);
            
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║           GUÍA DE REGISTRO            ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.println("  1 - 🗂️ Operación                    ");
            System.out.println("  2 - 🗂️ Procedimiento de seguridad                    ");
            System.out.println("  3 - 🗂️ Mantenimiento y Repareciones            ");
            System.out.println("  4 - 🗂️ Pruebas y diagnósticos               ");
            System.out.println("  5 - 🗂️ Manual de Conducta y Operaciones Sectoriales");
            System.out.println("═══════════════════════════════════════");
            System.out.print("  ? - Introduzca el tipo de orientación: ");
            int tipoLeitura = leiaNum.nextInt();
                
            switch(tipoLeitura){
                case 1:
                    tipo = "Manual de operación"; 
                    break;
                case 2:
                    tipo = "Procedimiento de seguridad"; 
                    break;
                case 3:
                    tipo = "Mantenimiento y Reparaciones"; 
                    break;
                case 4:
                    tipo = "Pruebas y diagnósticos"; 
                    break;
                case 5:
                    tipo = "Manual de Conducta y Operaciones"; 
                    break;
                default:
                    tipo = ""; 
                    break;
            }
            if(tipo.equals("")){
                Thread.sleep(350);
            	System.out.println("\n╔═════════════════════════════════════╗");
	            System.out.println("║         ORIENTACIÓN NO VÁLIDA         ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }else{
            	Thread.sleep(350);
            	System.out.print("  ? - Título de la orientación: ");
                titulo_orientacao = leiaStr.nextLine();

                Thread.sleep(350);
                // Verifica se já existe esse título no banco
                String sqlVerifica = "SELECT COUNT(*) FROM orientacoesEspanhol WHERE titulo_orientacaoES = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║   ¡ERROR! TÍTULO YA REGISTRADO        ║");
                    System.out.println("╚═════════════════════════════════════╝\n");
                } else {
                	System.out.print("  ? - Contenido de orientación: ");
	                conteudo_orientacao = leiaStr.nextLine();
	                
	                String sql2 = "INSERT INTO orientacoesEspanhol (titulo_orientacaoES, tipo_orientacaoES, conteudo_orientacaoES) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, titulo_orientacao);
	                stmt.setString(2, tipo);
	                stmt.setString(3, conteudo_orientacao);
	                stmt.executeUpdate();

                    Thread.sleep(350);
	                System.out.println("\n╔═══════════════════════════════════════╗");
		            System.out.println("║  ORIENTACIÓN REGISTRADA CON ÉXITO       ║");
		            System.out.println("╚═══════════════════════════════════════╝\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
//-------------------------------------------------------------------------------------------------------------
	
	
    public static void listar_todas_orientacoes_espanhol(){
    	try (Connection conn = Conexao.getConexao()) {
    		boolean encontrado = false;
            String sql = "SELECT * FROM orientacoesEspanhol";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("");
            while (rs.next()) {
                Thread.sleep(350);
            	encontrado = true;
            	System.out.println("╔══════════════════════════════════════════╗");
                System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoES"), rs.getString("titulo_orientacaoES"));
                System.out.println("   Tipo: " + rs.getString("tipo_orientacaoES") );
                System.out.println("   Contenido: " + rs.getString("conteudo_orientacaoES"));
                System.out.println("╚══════════════════════════════════════════╝");
                Thread.sleep(350);            
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
                Thread.sleep(350);
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║     NO SE ENCONTRÓ ORIENTACIÓN      ║");
	            System.out.println("╚══════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    public static void listar_orientacoes_espanhol_pelo_tipo(int tipoOrientacao) {
    	boolean encontrado = false;
    	try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoesEspanhol where tipo_orientacaoES = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           
            String tipoOrientacaoStr = "";
            
            switch(tipoOrientacao) {
            case 1:
            	tipoOrientacaoStr = "Manual de operacón"; 
                break;
            case 2:
            	tipoOrientacaoStr = "Procedimiento de seguridad"; 
                break;
            case 3:
            	tipoOrientacaoStr = "Mantenimiento y Reparaciones"; 
                break;
            case 4:
            	tipoOrientacaoStr = "Pruebas y diagnósticos"; 
                break;
            case 5:
            	tipoOrientacaoStr = "Manual de Conducta y Operaciones Sectoriales"; 
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
                System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoES"), rs.getString("titulo_orientacaoES"));
                System.out.println("   Tipo: " + rs.getString("tipo_orientacaoES") );
                System.out.println("   Contenido: " + rs.getString("conteudo_orientacaoES"));
                System.out.println("╚══════════════════════════════════════════╝");
            	
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║    NO SE ENCONTRÓ ORIENTACÓN        ║");
	            System.out.println("╚══════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 }
    
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    	public static void listar_orientacao_pelo_codigo_espanhol(int Codigo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesEspanhol where codigo_orientacaoES = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoES"), rs.getString("titulo_orientacaoES"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoES") );
                    System.out.println("   Contenido: " + rs.getString("conteudo_orientacaoES"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║  NO SE ENCONTRÓ ORIENTACIÓN         ║");
    	            System.out.println("╚══════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    		
    	public static void listar_orientacao_pelo_titulo_espanhol(String titulo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesEspanhol where titulo_orientacaoES = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoES"), rs.getString("titulo_orientacaoES"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoES") );
                    System.out.println("   Contenido: " + rs.getString("conteudo_orientacaoES"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║  NO SE ENCONTRÓ ORIENTACIÓN         ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    			
    	public static void editar_orientaçao_titulo_pelo_id_espanhol(Scanner leiaNum, Scanner leiaStr){
    		try (Connection conn = Conexao.getConexao()) {
    			boolean encontrado = false;
    			
    			String titulo_orientacao = null;
    			String conteudo_orientacao = null;
    			
    			System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║      ORIENTACIÓN DE EDICIÓN           ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.print("  ? - ID de orientación para actualizar: ");
                int codigo_orientacao = leiaNum.nextInt();
                
                String sql = "select * from orientacoesEspanhol where codigo_orientacaoES = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                	
                	String tituloAtual = rs.getString("titulo_orientacaoES");
                    String conteudoAtual = rs.getString("conteudo_orientacaoES");
                    
                	encontrado = true;
                	System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoES"), rs.getString("titulo_orientacaoES"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoES") );
                    System.out.println("   Contenido: " + rs.getString("conteudo_orientacaoES"));
                    System.out.println("╚══════════════════════════════════════════╝\n");
                    
                    System.out.print("  ? - Nuevo título (presione Enter para mantenerlo actualizado)): ");
                    titulo_orientacao = leiaStr.nextLine();
                    if (titulo_orientacao.trim().isEmpty()) {
                    	titulo_orientacao = tituloAtual;
                    }

                    System.out.print("  ? - Nuevo título (presione Enter para mantenerlo actualizado): ");
                    conteudo_orientacao = leiaStr.nextLine();
                    if (conteudo_orientacao.trim().isEmpty()) {
                    	conteudo_orientacao = conteudoAtual;
                    }
                   
                }
                if(encontrado != true) {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║    NO SE ENCONTRÓ ORIENTACIÓN         ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {

                String sql2 = "UPDATE orientacoesEspanhol SET titulo_orientacaoES = ?, conteudo_orientacaoES = ? WHERE codigo_orientacaoES = ?";
                PreparedStatement stmt = conn.prepareStatement(sql2);
                stmt.setString(1, titulo_orientacao);
                stmt.setString(2, conteudo_orientacao);
                stmt.setInt(3, codigo_orientacao);
                int linhasAfetadas = stmt.executeUpdate();

                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

                if (linhasAfetadas > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║ ACTUALIZACIÓN COMPLETADA EXITOSAMENTE  ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║            ID NO ENCONTRADO           ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
             }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
    	
//-------------------------------------------------------------------------------------------------------------
    	    		
    	    			
    	    	public static void deletar_orientação_espanhol(Scanner leiaNum){
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			boolean encontrado = false;
    	    			
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	                System.out.println("║      ELIMINAR LA ORIENTACIÓN        ║");
    	                System.out.println("╚═════════════════════════════════════╝");
    	                System.out.print("  ? - ID de orientación para eliminar: ");
    	                int codigo_orientacao = leiaNum.nextInt();   
    	                
    	                String sql = "select * from orientacoesEspanhol where codigo_orientacaoES = ?; ";
    	                PreparedStatement pstmt = conn.prepareStatement(sql);
    	                pstmt.setInt(1, codigo_orientacao);
    	                ResultSet rs = pstmt.executeQuery();
    	                
    	                if (rs.next()) {
          
    	                	encontrado = true;
    	                	Thread.sleep(300);
    	                	System.out.println("\n╔══════════════════════════════════════════╗");
    	                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoES"), rs.getString("titulo_orientacaoES"));
    	                    System.out.println("   Type: " + rs.getString("tipo_orientacaoES") );
    	                    System.out.println("   Content: " + rs.getString("conteudo_orientacaoES"));
    	                    System.out.println("╚══════════════════════════════════════════╝\n");
    	                    Thread.sleep(300);
    	                }
    	                if(encontrado != true) {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║    NO SE ENCONTRÓ ORIENTACIÓN         ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {

    	                String sql2 = "DELETE FROM orientacoesEspanhol WHERE codigo_orientacaoES = ?";
    	                PreparedStatement stmt = conn.prepareStatement(sql2);
    	                stmt.setInt(1, codigo_orientacao);
    	                int linhasAfetadas = stmt.executeUpdate();

    	                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

    	                if (linhasAfetadas > 0) {
    	                    System.out.println("╔═════════════════════════════════════╗");
    	    	            System.out.println("║  ELIMINACIÓN COMPLETADA CON ÉXITO   ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║          ID NO ENCONTRADO             ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	                }
    	             }
    	                
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	    	
    	    
//-------------------------------------------------------------------------------------------------------------

    	    	
    	    	public static void mensagem_sair_sistema_espanhol() {
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			Thread.sleep(300);
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	    			Thread.sleep(300);
	    	            System.out.println("     🌐  ¡SISTEMA WEGONE CERRADO!  🌐    ");
	    	            Thread.sleep(300);
	    	            System.out.println("        ✨ VUELVE EN CUALQUIER MOMENTO ✨       ");
	    	            Thread.sleep(300);
	    	            System.out.println("╚═════════════════════════════════════╝\n");

    	    		} catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	
    	
    	
    	
    	
    	
    	
    	
}