package br.com.appwegone;
import br.com.conexaobanco.*;
import java.sql.*;
import java.util.*;

public class English{

	public static void cadastrar_orientacoes_english(Scanner leiaStr, Scanner leiaNum) {
		try (Connection conn = Conexao.getConexao()) {
			
			String titulo_orientacao = null;
			String conteudo_orientacao = null;
            String tipo = "";
            
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║           REGISTER GUIDANCE         ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.println("  1 - 🗂️ Operation manual                    ");
            System.out.println("  2 - 🗂️ Safety procedure                    ");
            System.out.println("  3 - 🗂️ Maintenance and Repairs             ");
            System.out.println("  4 - 🗂️ Tests and Diagnostics               ");
            System.out.println("  5 - 🗂️ Sectoral Conduct and Operations Manual");
            System.out.println("═══════════════════════════════════════");
            System.out.print("  ? - Insira o Tipo: ");
            int tipoLeitura = leiaNum.nextInt();
                
            switch(tipoLeitura){
                case 1:
                    tipo = "Operation manual"; 
                    break;
                case 2:
                    tipo = "Safety procedure"; 
                    break;
                case 3:
                    tipo = "Maintenance and Repairs"; 
                    break;
                case 4:
                    tipo = "Tests and Diagnostics"; 
                    break;
                case 5:
                    tipo = "Sectoral Conduct and Operations Manual"; 
                    break;
                default:
                    tipo = ""; 
                    break;
            }
            if(tipo.equals("")){
            	System.out.println("\n╔═════════════════════════════════════╗");
	            System.out.println("║         ORIENTAÇÃO INVÁLIDA         ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }else{
            	
            	System.out.print("  ? - Título da Orientação: ");
                titulo_orientacao = leiaStr.nextLine();

                // Verifica se já existe esse título no banco
                String sqlVerifica = "SELECT COUNT(*) FROM orientacoesEnglish WHERE titulo_orientacaoEN = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlVerifica);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                int quantidade = rs.getInt(1);
                
                if (quantidade > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
                    System.out.println("║      ERRO! TÍTULO JÁ CADASTRADO     ║");
                    System.out.println("╚═════════════════════════════════════╝\n");
                } else {
                	System.out.print("  ? - Conteúdo da Orientação: ");
	                conteudo_orientacao = leiaStr.nextLine();
	                
	                String sql2 = "INSERT INTO orientacoesEnglish (titulo_orientacaoEN, tipo_orientacaoEN, conteudo_orientacaoEN) VALUES (?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql2);
	                stmt.setString(1, titulo_orientacao);
	                stmt.setString(2, tipo);
	                stmt.setString(3, conteudo_orientacao);
	                stmt.executeUpdate();
	
	                System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║  ORIENTAÇÃO CADASTRADA COM SUCESSO  ║");
		            System.out.println("╚═════════════════════════════════════╝\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
//-------------------------------------------------------------------------------------------------------------
	
	
    public static void listar_todas_orientacoes_english(){
    	try (Connection conn = Conexao.getConexao()) {
    		boolean encontrado = false;
            String sql = "SELECT * FROM orientacoesEnglish";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("");
            while (rs.next()) {
            	 encontrado = true;
            	 System.out.println("╔══════════════════════════════════════════╗");
                 System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoEN"), rs.getString("titulo_orientacaoEN"));
                 System.out.println("   Tipo: " + rs.getString("tipo_orientacaoEN") );
                 System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoEN"));
                 System.out.println("╚══════════════════════════════════════════╝");
                 Thread.sleep(350);            
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║    NENHUMA ORIENTAÇÃO ENCONTRADA    ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    public static void listar_orientacoes_english_pelo_tipo(int tipoOrientacao) {
    	boolean encontrado = false;
    	try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoesEnglish where tipo_orientacaoEN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           
            String tipoOrientacaoStr = "";
            
            switch(tipoOrientacao) {
            case 1:
            	tipoOrientacaoStr = "Manual de operação"; 
                break;
            case 2:
            	tipoOrientacaoStr = "Procedimento de segurança"; 
                break;
            case 3:
            	tipoOrientacaoStr = "Manutenção e Reparos"; 
                break;
            case 4:
            	tipoOrientacaoStr = "Testes e Diagnósticos"; 
                break;
            case 5:
            	tipoOrientacaoStr = "Manual de Conduta e Operações Setoriais"; 
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
                System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoEN"), rs.getString("titulo_orientacaoEN"));
                System.out.println("   Tipo: " + rs.getString("tipo_orientacaoEN") );
                System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoEN"));
                System.out.println("╚══════════════════════════════════════════╝");
            	
            }
            if(encontrado == true) {
            	System.out.println("");
            }
            if(encontrado != true) {
            	System.out.println("╔═════════════════════════════════════╗");
	            System.out.println("║    NENHUMA ORIENTAÇÃO ENCONTRADA    ║");
	            System.out.println("╚═════════════════════════════════════╝\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 }
    
	
//-------------------------------------------------------------------------------------------------------------
  	
  	
    	public static void listar_orientacao_pelo_codigo_english(int Codigo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesEnglish where codigo_orientacaoEN = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoEN"), rs.getString("titulo_orientacaoEN"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoEN") );
                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoEN"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║    NENHUMA ORIENTAÇÃO ENCONTRADA    ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    		
    	public static void listar_orientacao_pelo_titulo_english(String titulo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesEnglish where titulo_orientacaoEN = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoEN"), rs.getString("titulo_orientacaoEN"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoEN") );
                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoEN"));
                    System.out.println("╚══════════════════════════════════════════╝");
                }
                
                if(encontrado == true) {
                	System.out.println("");
                }
                if(encontrado != true) {
                	System.out.println("╔═════════════════════════════════════╗");
    	            System.out.println("║    NENHUMA ORIENTAÇÃO ENCONTRADA    ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
//-------------------------------------------------------------------------------------------------------------
    		
    			
    	public static void editar_orientaçao_titulo_pelo_id_english(Scanner leiaNum, Scanner leiaStr){
    		try (Connection conn = Conexao.getConexao()) {
    			boolean encontrado = false;
    			
    			String titulo_orientacao = null;
    			String conteudo_orientacao = null;
    			
    			System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║          EDITAR ORIENTAÇÃO          ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.print("  ? - ID da orientação para atualizar: ");
                int codigo_orientacao = leiaNum.nextInt();
                
                String sql = "select * from orientacoesEnglish where codigo_orientacaoEN = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                	
                	String tituloAtual = rs.getString("titulo_orientacaoEN");
                    String conteudoAtual = rs.getString("conteudo_orientacaoEN");
                    
                	encontrado = true;
                	System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoEN"), rs.getString("titulo_orientacaoEN"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoEN") );
                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoEN"));
                    System.out.println("╚══════════════════════════════════════════╝\n");
                    
                    System.out.print("  ? - Novo título (pressione Enter para manter o atual): ");
                    titulo_orientacao = leiaStr.nextLine();
                    if (titulo_orientacao.trim().isEmpty()) {
                    	titulo_orientacao = tituloAtual;
                    }

                    System.out.print("  ? - Novo conteúdo (pressione Enter para manter o atual): ");
                    conteudo_orientacao = leiaStr.nextLine();
                    if (conteudo_orientacao.trim().isEmpty()) {
                    	conteudo_orientacao = conteudoAtual;
                    }
                   
                }
                if(encontrado != true) {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║    NENHUMA ORIENTAÇÃO ENCONTRADA    ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {

                String sql2 = "UPDATE orientacoesEnglish SET titulo_orientacaoEN = ?, conteudo_orientacaoEN = ? WHERE codigo_orientacaoEN = ?";
                PreparedStatement stmt = conn.prepareStatement(sql2);
                stmt.setString(1, titulo_orientacao);
                stmt.setString(2, conteudo_orientacao);
                stmt.setInt(3, codigo_orientacao);
                int linhasAfetadas = stmt.executeUpdate();

                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

                if (linhasAfetadas > 0) {
                    System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║  ATUALIZAÇÃO REALIZADA COM SUCESSO  ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }else {
                	System.out.println("\n╔═════════════════════════════════════╗");
    	            System.out.println("║          ID NÃO ENCONTRADO          ║");
    	            System.out.println("╚═════════════════════════════════════╝\n");
                }
             }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
    	
    	
    	
//-------------------------------------------------------------------------------------------------------------
    	    		
    	    			
    	    	public static void deletar_orientação_english(Scanner leiaNum){
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			boolean encontrado = false;
    	    			
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	                System.out.println("║         REMOVER ORIENTAÇÃO          ║");
    	                System.out.println("╚═════════════════════════════════════╝");
    	                System.out.print("  ? - ID da orientação para remover: ");
    	                int codigo_orientacao = leiaNum.nextInt();   
    	                
    	                String sql = "select * from orientacoesEnglish where codigo_orientacaoEN = ?; ";
    	                PreparedStatement pstmt = conn.prepareStatement(sql);
    	                pstmt.setInt(1, codigo_orientacao);
    	                ResultSet rs = pstmt.executeQuery();
    	                
    	                if (rs.next()) {
          
    	                	encontrado = true;
    	                	Thread.sleep(300);
    	                	System.out.println("\n╔══════════════════════════════════════════╗");
    	                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoEN"), rs.getString("titulo_orientacaoEN"));
    	                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoEN") );
    	                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoEN"));
    	                    System.out.println("╚══════════════════════════════════════════╝\n");
    	                    Thread.sleep(300);
    	                }
    	                if(encontrado != true) {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║    NENHUMA ORIENTAÇÃO ENCONTRADA    ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {

    	                String sql2 = "DELETE FROM orientacoesEnglish WHERE codigo_orientacaoEN = ?";
    	                PreparedStatement stmt = conn.prepareStatement(sql2);
    	                stmt.setInt(1, codigo_orientacao);
    	                int linhasAfetadas = stmt.executeUpdate();

    	                // logica para atualizar apenas um valor de conteudo e deixar os demais com seus conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

    	                if (linhasAfetadas > 0) {
    	                    System.out.println("╔═════════════════════════════════════╗");
    	    	            System.out.println("║    REMOÇÃO REALIZADA COM SUCESSO    ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║          ID NÃO ENCONTRADO          ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	                }
    	             }
    	                
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	    	
    	    
//-------------------------------------------------------------------------------------------------------------

    	    	
    	    	public static void mensagem_sair_sistema_english() {
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			Thread.sleep(300);
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	    			Thread.sleep(300);
	    	            System.out.println("    🌐 SISTEMA WEGONE ENCERRADO! 🌐   ");
	    	            Thread.sleep(300);
	    	            System.out.println("           ✨ VOLTE SEMPRE ✨         ");
	    	            Thread.sleep(300);
	    	            System.out.println("╚═════════════════════════════════════╝\n");

    	    		} catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	    	}
    	
    	
    	
    	
    	
    	
    	
    	
}