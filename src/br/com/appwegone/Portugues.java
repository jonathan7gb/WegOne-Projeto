package br.com.appwegone;
import br.com.conexaobanco.*;
import java.sql.*;
import java.util.*;

public class Portugues {

	public static void cadastrar_orientacoes_portugues(Scanner leiaStr, Scanner leiaNum) {
		try (Connection conn = Conexao.getConexao()) {
			
			String titulo_orientacao = null;
			String conteudo_orientacao = null;
            String tipo = "";
            
            System.out.println("\n╔═════════════════════════════════════╗");
            System.out.println("║         CADASTRAR ORIENTAÇÃO        ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.println("  1 - 🗂️ Manual de operação               ");
            System.out.println("  2 - 🗂️ Procedimento de segurança        ");
            System.out.println("  3 - 🗂️ Manutenção e Reparos             ");
            System.out.println("  4 - 🗂️ Testes e Diagnósticos            ");
            System.out.println("  5 - 🗂️ Manual de Conduta e Operações Setoriais ");
            System.out.println("═══════════════════════════════════════");
            System.out.print("  ? - Insira o Tipo: ");
            int tipoLeitura = leiaNum.nextInt();
                
            switch(tipoLeitura){
                case 1:
                    tipo = "Manual de operação"; 
                    break;
                case 2:
                    tipo = "Procedimento de segurança"; 
                    break;
                case 3:
                    tipo = "Manutenção e Reparos"; 
                    break;
                case 4:
                    tipo = "Testes e Diagnósticos"; 
                    break;
                case 5:
                    tipo = "Manual de Conduta e Operações Setoriais"; 
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
                String sqlVerifica = "SELECT COUNT(*) FROM orientacoesPortugues WHERE titulo_orientacaoPT = ?";
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
	                
	                String sql2 = "INSERT INTO orientacoesPortugues (titulo_orientacaoPT, tipo_orientacaoPT	, conteudo_orientacaoPT) VALUES (?, ?, ?)";
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
	
	
    public static void listar_todas_orientacoes_portugues(){
    	try (Connection conn = Conexao.getConexao()) {
    		boolean encontrado = false;
            String sql = "SELECT * FROM orientacoesPortugues";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("");
            while (rs.next()) {
            	encontrado = true;
            	System.out.println("╔══════════════════════════════════════════╗");
                System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoPT"), rs.getString("titulo_orientacaoPT"));
                System.out.println("   Tipo: " + rs.getString("tipo_orientacaoPT") );
                System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoPT"));
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
  	
  	
    public static void listar_orientacoes_portugues_pelo_tipo(int tipoOrientacao) {
    	boolean encontrado = false;
    	try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoesPortugues where tipo_orientacaoPT = ?";
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
                System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoPT"), rs.getString("titulo_orientacaoPT"));
                System.out.println("   Tipo: " + rs.getString("tipo_orientacaoPT") );
                System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoPT"));
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
  	
  	
    	public static void listar_orientacao_pelo_codigo_portugues(int Codigo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesPortugues where codigo_orientacaopt = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoPT"), rs.getString("titulo_orientacaoPT"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoPT") );
                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoPT"));
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
    		
    		
    	public static void listar_orientacao_pelo_titulo_portugues(String titulo_orientacao){
        	try (Connection conn = Conexao.getConexao()) {
        		boolean encontrado = false;
                String sql = "select * from orientacoesPortugues where titulo_orientacaoPT = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, titulo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                System.out.println("");
                
                while (rs.next()) {
                	encontrado = true;
                	System.out.println("╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoPT"), rs.getString("titulo_orientacaoPT"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoPT") );
                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoPT"));
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
    		
    			
    	public static void editar_orientaçao_titulo_pelo_id_portugues(Scanner leiaNum, Scanner leiaStr){
    		try (Connection conn = Conexao.getConexao()) {
    			boolean encontrado = false;
    			
    			String titulo_orientacao = null;
    			String conteudo_orientacao = null;
    			
    			System.out.println("\n╔═════════════════════════════════════╗");
                System.out.println("║          EDITAR ORIENTAÇÃO          ║");
                System.out.println("╚═════════════════════════════════════╝");
                System.out.print("  ? - ID da orientação para atualizar: ");
                int codigo_orientacao = leiaNum.nextInt();
                
                String sql = "select * from orientacoesPortugues where codigo_orientacaopt = ?; ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, codigo_orientacao);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                	
                	String tituloAtual = rs.getString("titulo_orientacaoPT");
                    String conteudoAtual = rs.getString("conteudo_orientacaoPT");
                    
                	encontrado = true;
                	System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoPT"), rs.getString("titulo_orientacaoPT"));
                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoPT") );
                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoPT"));
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

                String sql2 = "UPDATE orientacoesPortugues SET titulo_orientacaoPT = ?, conteudo_orientacaoPT = ? WHERE codigo_orientacaoPT = ?";
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
    	    		
    	    			
    	    	public static void deletar_orientação_portugues(Scanner leiaNum){
    	    		try (Connection conn = Conexao.getConexao()) {
    	    			boolean encontrado = false;
    	    			
    	    			System.out.println("\n╔═════════════════════════════════════╗");
    	                System.out.println("║         REMOVER ORIENTAÇÃO          ║");
    	                System.out.println("╚═════════════════════════════════════╝");
    	                System.out.print("  ? - ID da orientação para remover: ");
    	                int codigo_orientacao = leiaNum.nextInt();   
    	                
    	                String sql = "select * from orientacoesPortugues where codigo_orientacaopt = ?; ";
    	                PreparedStatement pstmt = conn.prepareStatement(sql);
    	                pstmt.setInt(1, codigo_orientacao);
    	                ResultSet rs = pstmt.executeQuery();
    	                
    	                if (rs.next()) {
          
    	                	encontrado = true;
    	                	Thread.sleep(300);
    	                	System.out.println("\n╔══════════════════════════════════════════╗");
    	                    System.out.printf("   [%d] %s                               %n", rs.getInt("codigo_orientacaoPT"), rs.getString("titulo_orientacaoPT"));
    	                    System.out.println("   Tipo: " + rs.getString("tipo_orientacaoPT") );
    	                    System.out.println("   Conteúdo: " + rs.getString("conteudo_orientacaoPT"));
    	                    System.out.println("╚══════════════════════════════════════════╝\n");
    	                    Thread.sleep(300);
    	                }
    	                if(encontrado != true) {
    	                	System.out.println("\n╔═════════════════════════════════════╗");
    	    	            System.out.println("║    NENHUMA ORIENTAÇÃO ENCONTRADA    ║");
    	    	            System.out.println("╚═════════════════════════════════════╝\n");
    	    	            Thread.sleep(300);
    	                }else {

    	                String sql2 = "DELETE FROM orientacoesPortugues  WHERE codigo_orientacaoPT = ?";
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

    	    	
    	    	public static void mensagem_sair_sistema_portugues() {
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