package br.com.appwegone;
import java.util.*;

public class MainWO {
	
	 public static void main(String[] args){

	        Scanner leiaStr = new Scanner(System.in);
	        Scanner leiaNum = new Scanner(System.in);
	        
	        
	        int escolhaMenu = 0;
	        int escolhaPesquisa = 0;
	        int escolhaBuscaEspecifica = 0;
	        int escolhaIdioma = 0;
	        
	        System.out.println("╔═════════════════════════════════════╗");
            System.out.println("║            SISTEMA WEGONE           ║");
            System.out.println("╚═════════════════════════════════════╝");
            System.out.println("  1 - 📖 🇧🇷 Português        ");
            System.out.println("  2 - 📖 🇺🇸 English         ");
            System.out.println("  3 - 📖 🇩🇪 Deutsch            ");
            System.out.println("  4 - 📖 🇫🇷 Français           ");
            System.out.println("  5 - 📖 🇪🇸 Español                        ");
            System.out.println("═══════════════════════════════════════");
            System.out.print("  ? - Escolha/choice: ");
			escolhaIdioma = leiaNum.nextInt(); //Escolha do idioma do usuário
			System.out.println("");
	        
			switch(escolhaIdioma) {
				case 1: 
				String tipoUser = Usuarios.menu_login_pt();
				if(tipoUser.equals("admin")){
			        do {
			        	System.out.println("╔═════════════════════════════════════╗");
			            System.out.println("║            SISTEMA WEGONE           ║");
			            System.out.println("╚═════════════════════════════════════╝");
			            System.out.println("  1 - 📝 Cadastrar Orientação        ");
			            System.out.println("  2 - 🔍 Pesquisar Orientação        ");
			            System.out.println("  3 - ✏️ Editar Orientação           ");
			            System.out.println("  4 - 🗑️ Excluir Orientação          ");
			            System.out.println("  5 - 👋 Sair                        ");
			            System.out.println("═══════════════════════════════════════");
			            System.out.print("  ? - Sua Escolha: ");
						escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
						
						switch(escolhaMenu) { //MENU PRINCIPAL 
						case 1:
							Portugues.cadastrar_orientacoes_portugues(leiaStr, leiaNum);
						break; // BREAK DO CASE 1 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
						
						case 2:
							System.out.println("\n╔═════════════════════════════════════╗");
				            System.out.println("║         PESQUISAR ORIENTAÇÃO        ║");
				            System.out.println("╚═════════════════════════════════════╝");
				            System.out.println("  1 - 🧾 Todas as Orientações        ");
				            System.out.println("  2 - 📄 Orientação Específica        ");
				            System.out.println("═══════════════════════════════════════");
				            System.out.print("  ? - Sua Escolha: ");
							escolhaPesquisa = leiaNum.nextInt();
							
							switch(escolhaPesquisa) { //MENU DE PESQUISA
							case 1:
								Portugues.listar_todas_orientacoes_portugues();
							break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
					            System.out.println("║         PESQUISA ESPECÍFICA         ║");
					            System.out.println("╚═════════════════════════════════════╝");
					            System.out.println("  1 - 📊 Buscar pelo Tipo          ");
					            System.out.println("  2 - 📊 Buscar pelo Código        ");
					            System.out.println("  3 - 📊 Buscar pelo Título        ");
					            System.out.println("═══════════════════════════════════════");
					            System.out.print("  ? - Sua Escolha de Busca: ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
						            System.out.println("║             PELO TIPO DA ORIENTAÇÃO           ║");
						            System.out.println("╚═══════════════════════════════════════════════╝");
						            System.out.println("  1 - 🗂️ Manual de operação               ");
						            System.out.println("  2 - 🗂️ Procedimento de segurança        ");
						            System.out.println("  3 - 🗂️ Manutenção e Reparos             ");
						            System.out.println("  4 - 🗂️ Testes e Diagnósticos            ");
						            System.out.println("  5 - 🗂️ Manual de Conduta e Operações Setoriais ");
						            System.out.println("═════════════════════════════════════════════════");
						            System.out.print("  ? - Insira o Tipo: ");
						            int tipoLeitura = leiaNum.nextInt();
						            
							        Portugues.listar_orientacoes_portugues_pelo_tipo(tipoLeitura);
							        
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
						            System.out.println("║      PELO CÓDIGO DA ORIENTAÇÃO      ║");
						            System.out.println("╚═════════════════════════════════════╝");
						            System.out.println("  2 - 📊 Buscar pelo Código               ");
						            System.out.println("══════════════════════════════════════");
						            System.out.print("  ? - Insira o Código: ");
							        int codigo_orientacao = leiaNum.nextInt();
							        Portugues.listar_orientacao_pelo_codigo_portugues(codigo_orientacao);
									break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
						            System.out.println("║      PELO TÍTULO DA ORIENTAÇÃO      ║");
						            System.out.println("╚═════════════════════════════════════╝");
						            System.out.println("  3 - 📊 Buscar pelo Título               ");
						            System.out.println("══════════════════════════════════════");
						            System.out.print("  ? - Insira o Título: ");
							    	String titulo_orientacao = leiaStr.nextLine();
							    	Portugues.listar_orientacao_pelo_titulo_portugues(titulo_orientacao);
									break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
						            System.out.println("║          ESCOLHA INVÁLIDA           ║");
						            System.out.println("╚═════════════════════════════════════╝");
									break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
								
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							}// Fechando chaves do bloco switch(escolhaPesquisa)
							
						break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
						
						//------------------------------------------------------------
							
						case 3:
							Portugues.editar_orientaçao_titulo_pelo_id_portugues(leiaNum, leiaStr);
							break; // BREAK DO CASE 3 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						case 4:
							Portugues.deletar_orientação_portugues(leiaNum);
							break; // BREAK DO CASE 4 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
								
						case 5: 
							Portugues.mensagem_sair_sistema_portugues();
							break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						default:
							System.out.println("\n╔═════════════════════════════════════╗");
				            System.out.println("║          ESCOLHA INVÁLIDA           ║");
				            System.out.println("╚═════════════════════════════════════╝");
							break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
							
						}// Fechando chaves do bloco switch(escolhaMenu)
		
			        }while(escolhaMenu != 5);
			break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) Portugues
			} //Chave que fecha o if(tipoUser.equals("admin"))

			else if(tipoUser.equals("usuario")){
				do {
					System.out.println("╔═════════════════════════════════════╗");
					System.out.println("║            SISTEMA WEGONE           ║");
					System.out.println("╚═════════════════════════════════════╝");
					System.out.println("  1 - 🔍 Pesquisar Orientação        ");
					System.out.println("  2 - 👋 Sair                        ");
					System.out.println("═══════════════════════════════════════");
					System.out.print("  ? - Sua Escolha: ");
					escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
					
					switch(escolhaMenu) { //MENU PRINCIPAL 
					
						case 1:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║         PESQUISAR ORIENTAÇÃO        ║");
							System.out.println("╚═════════════════════════════════════╝");
							System.out.println("  1 - 🧾 Todas as Orientações        ");
							System.out.println("  2 - 📄 Orientação Específica        ");
							System.out.println("═══════════════════════════════════════");
							System.out.print("  ? - Sua Escolha: ");
							escolhaPesquisa = leiaNum.nextInt();
						
							switch(escolhaPesquisa) { //MENU DE PESQUISA
								case 1:
									Portugues.listar_todas_orientacoes_portugues();
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
								System.out.println("║         PESQUISA ESPECÍFICA         ║");
								System.out.println("╚═════════════════════════════════════╝");
								System.out.println("  1 - 📊 Buscar pelo Tipo          ");
								System.out.println("  2 - 📊 Buscar pelo Código        ");
								System.out.println("  3 - 📊 Buscar pelo Título        ");
								System.out.println("═══════════════════════════════════════");
								System.out.print("  ? - Sua Escolha de Busca: ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
									System.out.println("║             PELO TIPO DA ORIENTAÇÃO           ║");
									System.out.println("╚═══════════════════════════════════════════════╝");
									System.out.println("  1 - 🗂️ Manual de operação               ");
									System.out.println("  2 - 🗂️ Procedimento de segurança        ");
									System.out.println("  3 - 🗂️ Manutenção e Reparos             ");
									System.out.println("  4 - 🗂️ Testes e Diagnósticos            ");
									System.out.println("  5 - 🗂️ Manual de Conduta e Operações Setoriais ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.print("  ? - Insira o Tipo: ");
									int tipoLeitura = leiaNum.nextInt();
									
									Portugues.listar_orientacoes_portugues_pelo_tipo(tipoLeitura);
									
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║      PELO CÓDIGO DA ORIENTAÇÃO      ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  2 - 📊 Buscar pelo Código               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Insira o Código: ");
									int codigo_orientacao = leiaNum.nextInt();
									Portugues.listar_orientacao_pelo_codigo_portugues(codigo_orientacao);
									break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║      PELO TÍTULO DA ORIENTAÇÃO      ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  3 - 📊 Buscar pelo Título               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Insira o Título: ");
									String titulo_orientacao = leiaStr.nextLine();
									Portugues.listar_orientacao_pelo_titulo_portugues(titulo_orientacao);
									break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║          ESCOLHA INVÁLIDA           ║");
									System.out.println("╚═════════════════════════════════════╝");
									break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
							
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
						}// Fechando chaves do bloco switch(escolhaPesquisa)
						
					break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
					
						
					//------------------------------------------------------------
							
					case 2: 
						Portugues.mensagem_sair_sistema_portugues();
						break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
						
					//------------------------------------------------------------
						
					default:
						System.out.println("\n╔═════════════════════════════════════╗");
						System.out.println("║          ESCOLHA INVÁLIDA           ║");
						System.out.println("╚═════════════════════════════════════╝");
						break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
						
					}// Fechando chaves do bloco switch(escolhaMenu)
	
				}while(escolhaMenu != 2);
		break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) Portugues
			}else{
				System.out.println("\n╔═════════════════════════════════════╗");
				System.out.println("║           ERRO NO LOGIN             ║");
				System.out.println("╚═════════════════════════════════════╝");
			}
			
//===========================================================================================================	
			
			
			
				case 2: //English
					tipoUser = Usuarios.menu_login_en();
				if(tipoUser.equals("admin")){
			        do {
			        	System.out.println("╔═════════════════════════════════════╗");
			            System.out.println("║            WEGONE SYSTEM            ║");
			            System.out.println("╚═════════════════════════════════════╝");
			            System.out.println("  1 - 📝 Register Orientation        ");
			            System.out.println("  2 - 🔍 Search for Orientation        ");
			            System.out.println("  3 - ✏️ Edit Orientation           ");
			            System.out.println("  4 - 🗑️ Remove Orientation          ");
			            System.out.println("  5 - 👋 Leave System                        ");
			            System.out.println("═══════════════════════════════════════");
			            System.out.print("  ? - Your choice: ");
						escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
						
						switch(escolhaMenu) { //MENU PRINCIPAL 
						case 1:
							English.cadastrar_orientacoes_english(leiaStr, leiaNum);
						break; // BREAK DO CASE 1 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
						
						case 2:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║        SEARCH FOR ORIENTATION       ║");
							System.out.println("╚═════════════════════════════════════╝");
							System.out.println("  1 - 🧾 All Orientations        ");
							System.out.println("  2 - 📄 Especific Orientation        ");
							System.out.println("═══════════════════════════════════════");
							System.out.print("  ? - Your choice: ");
							escolhaPesquisa = leiaNum.nextInt();
							
							switch(escolhaPesquisa) { //MENU DE PESQUISA
							case 1:
								English.listar_todas_orientacoes_english();
							break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
								System.out.println("║          ESPECIFIC SEARCH          ║");
								System.out.println("╚═════════════════════════════════════╝");
								System.out.println("  1 - 📊 Search by Type          ");
								System.out.println("  2 - 📊 Search by ID        ");
								System.out.println("  3 - 📊 Search by Title        ");
								System.out.println("═══════════════════════════════════════");
								System.out.print("  ? - Your search choice : ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
									System.out.println("║             BY TYPE OF ORIENTATION            ║");
									System.out.println("╚═══════════════════════════════════════════════╝");
									System.out.println("  1 - 📊 Search by Type          ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.println("  1 - 🗂️ Operation manual                       ");
									System.out.println("  2 - 🗂️ Safety procedure                       ");
									System.out.println("  3 - 🗂️ Maintenance and Repairs                ");
									System.out.println("  4 - 🗂️ Tests and Diagnostics                  ");
									System.out.println("  5 - 🗂️ Sectoral Conduct and Operations Manual ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.print("  ? - Enter the orientation type: ");
						            int tipoLeitura = leiaNum.nextInt();
						            
							        English.listar_orientacoes_english_pelo_tipo(tipoLeitura);
							        
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║          BY ORIENTATION ID          ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  2 - 📊 Search by ID               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Enter the ID: ");
							        int codigo_orientacao = leiaNum.nextInt();
							        English.listar_orientacao_pelo_codigo_english(codigo_orientacao);
								break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║         BY ORIENTATION TITLE        ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  3 - 📊 Search by Title                ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Enter the title: ");
							    	String titulo_orientacao = leiaStr.nextLine();
							    	English.listar_orientacao_pelo_titulo_english(titulo_orientacao);
								break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║           INVALID CHOICE            ║");
									System.out.println("╚═════════════════════════════════════╝");
								break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
								
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							}// Fechando chaves do bloco switch(escolhaPesquisa)
							
						break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
						
						//------------------------------------------------------------
							
						case 3:
							English.editar_orientaçao_titulo_pelo_id_english(leiaNum, leiaStr);
						break; // BREAK DO CASE 3 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						case 4:
							English.deletar_orientação_english(leiaNum);
						break; // BREAK DO CASE 4 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
								
						case 5: 
							English.mensagem_sair_sistema_english();
						break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						default:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║           INVALID CHOICE            ║");
							System.out.println("╚═════════════════════════════════════╝");
						break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
							
						}// Fechando chaves do bloco switch(escolhaMenu)
		
			        }while(escolhaMenu != 5);
			break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) English
			} //Chave que fecha o if(tipoUser.equals("admin"))
			
			else if(tipoUser.equals("usuario")){
				do {
					System.out.println("╔═════════════════════════════════════╗");
			        System.out.println("║            WEGONE SYSTEM            ║");
			        System.out.println("╚═════════════════════════════════════╝");
			        System.out.println("  1 - 🔍 Search for Orientation        ");
			        System.out.println("  2 - 👋 Leave System                        ");
			        System.out.println("═══════════════════════════════════════");
					escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
					
					switch(escolhaMenu) { //MENU PRINCIPAL 
					
						case 1:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║        SEARCH FOR ORIENTATION       ║");
							System.out.println("╚═════════════════════════════════════╝");
							System.out.println("  1 - 🧾 All Orientations        ");
							System.out.println("  2 - 📄 Especific Orientation        ");
							System.out.println("═══════════════════════════════════════");
							System.out.print("  ? - Your choice: ");
							escolhaPesquisa = leiaNum.nextInt();
						
							switch(escolhaPesquisa) { //MENU DE PESQUISA
								case 1:
									English.listar_todas_orientacoes_english();
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
								System.out.println("║          ESPECIFIC SEARCH          ║");
								System.out.println("╚═════════════════════════════════════╝");
								System.out.println("  1 - 📊 Search by Type          ");
								System.out.println("  2 - 📊 Search by ID        ");
								System.out.println("  3 - 📊 Search by Title        ");
								System.out.println("═══════════════════════════════════════");
								System.out.print("  ? - Your search choice : ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
									System.out.println("║             BY TYPE OF ORIENTATION            ║");
									System.out.println("╚═══════════════════════════════════════════════╝");
									System.out.println("  1 - 📊 Search by Type          ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.println("  1 - 🗂️ Operation manual                       ");
									System.out.println("  2 - 🗂️ Safety procedure                       ");
									System.out.println("  3 - 🗂️ Maintenance and Repairs                ");
									System.out.println("  4 - 🗂️ Tests and Diagnostics                  ");
									System.out.println("  5 - 🗂️ Sectoral Conduct and Operations Manual ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.print("  ? - Enter the orientation type: ");
									int tipoLeitura = leiaNum.nextInt();
									
									English.listar_orientacoes_english_pelo_tipo(tipoLeitura);
									
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║          BY ORIENTATION ID          ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  2 - 📊 Search by ID               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Enter the ID: ");
									int codigo_orientacao = leiaNum.nextInt();
									English.listar_orientacao_pelo_codigo_english(codigo_orientacao);
									break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
						            System.out.println("║         BY ORIENTATION TITLE        ║");
						            System.out.println("╚═════════════════════════════════════╝");
						            System.out.println("  3 - 📊 Search by Title                ");
						            System.out.println("══════════════════════════════════════");
						            System.out.print("  ? - Enter the title: ");
									String titulo_orientacao = leiaStr.nextLine();
									English.listar_orientacao_pelo_titulo_english(titulo_orientacao);
								break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║           INVALID CHOICE            ║");
									System.out.println("╚═════════════════════════════════════╝");
								break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
							
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
						}// Fechando chaves do bloco switch(escolhaPesquisa)
						
					break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
					
						
					//------------------------------------------------------------
							
					case 2: 
						English.mensagem_sair_sistema_english();
						break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
						
					//------------------------------------------------------------
						
					default:
						System.out.println("\n╔═════════════════════════════════════╗");
						System.out.println("║           INVALID CHOICE            ║");
						System.out.println("╚═════════════════════════════════════╝");
					break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
						
					}// Fechando chaves do bloco switch(escolhaMenu)
	
				}while(escolhaMenu != 2);
		break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) Portugues
			}else{
				System.out.println("\n╔═════════════════════════════════════╗");
				System.out.println("║           ERRO NO LOGIN             ║");
				System.out.println("╚═════════════════════════════════════╝");
			}
			
			
			
//===========================================================================================================	
			
			
			
			
				case 3: //Deutsch
				tipoUser = Usuarios.menu_login_al();
				if(tipoUser.equals("admin")){
			        do {
			        	System.out.println("╔═════════════════════════════════════╗");
			            System.out.println("║            WEGONE-SYSTEM            ║");
			            System.out.println("╚═════════════════════════════════════╝");
			            System.out.println("  1 - 📝 Orientierung registrieren        ");
			            System.out.println("  2 - 🔍 Suche nach Orientierung        ");
			            System.out.println("  3 - ✏️ Ausrichtung bearbeiten           ");
			            System.out.println("  4 - 🗑️ Ausrichtung entfernen          ");
			            System.out.println("  5 - 👋 Verlassen Sie das System                        ");
			            System.out.println("═══════════════════════════════════════");
			            System.out.print("  ? - Ihre Wahl: ");
						escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
						
						switch(escolhaMenu) { //MENU PRINCIPAL 
						case 1:
							Alemao.cadastrar_orientacoes_alemao(leiaStr, leiaNum);
						break; // BREAK DO CASE 1 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
						
						case 2:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║        Suche nach Orientierung      ║");
							System.out.println("╚═════════════════════════════════════╝");
							System.out.println("  1 - 🧾 Alle Orientierungen        ");
							System.out.println("  2 - 📄 Spezifische Orientierung        ");
							System.out.println("═══════════════════════════════════════");
							System.out.print("  ? - Ihre Wahl: ");
							escolhaPesquisa = leiaNum.nextInt();
							
							switch(escolhaPesquisa) { //MENU DE PESQUISA
							case 1:
								Alemao.listar_todas_orientacoes_alemao();
							break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
								System.out.println("║          SPEZIFISCHE SUCHE          ║");
								System.out.println("╚═════════════════════════════════════╝");
								System.out.println("  1 - 📊 Suche nach Typ          ");
								System.out.println("  2 - 📊 Suche nach ID        ");
								System.out.println("  3 - 📊 Suche nach Titel        ");
								System.out.println("═══════════════════════════════════════");
								System.out.print("  ? - Ihre Suchauswahl: ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
									System.out.println("║             NACH ORIENTIERUNGSART             ║");
									System.out.println("╚═══════════════════════════════════════════════╝");
									System.out.println("  1 - 📊 Suche nach Typ          ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.println("  1 - 🗂️ Bedienungsanleitung                       ");
									System.out.println("  2 - 🗂️ Sicherheitsverfahren                       ");
									System.out.println("  3 - 🗂️ Wartung und Reparaturen                ");
									System.out.println("  4 - 🗂️ Tests und Diagnose                  ");
									System.out.println("  5 - 🗂️ Branchenhandbuch für Verhalten und Betrieb ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.print("  ? - Geben Sie den Ausrichtungstyp ein: ");
						            int tipoLeitura = leiaNum.nextInt();
						            
							        Alemao.listar_orientacoes_alemao_pelo_tipo(tipoLeitura);
							        
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║          NACH ORIENTIERUNGS-ID          ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  2 - 📊 Suche nach ID               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Geben Sie die ID ein: ");
							        int codigo_orientacao = leiaNum.nextInt();
							        Alemao.listar_orientacao_pelo_codigo_alemao(codigo_orientacao);
								break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║         NACH ORIENTIERUNG TITEL        ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  3 - 📊 Suche nach Titel                ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Geben Sie den Titel ein: ");
							    	String titulo_orientacao = leiaStr.nextLine();
							    	Alemao.listar_orientacao_pelo_titulo_alemao(titulo_orientacao);
								break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║           UNGÜLTIGE WAHL            ║");
									System.out.println("╚═════════════════════════════════════╝");
								break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
								
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							}// Fechando chaves do bloco switch(escolhaPesquisa)
							
						break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
						
						//------------------------------------------------------------
							
						case 3:
							Alemao.editar_orientaçao_titulo_pelo_id_alemao(leiaNum, leiaStr);
							break; // BREAK DO CASE 3 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						case 4:
							Alemao.deletar_orientação_alemao(leiaNum);
							break; // BREAK DO CASE 4 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
								
						case 5: 
							Alemao.mensagem_sair_sistema_alemao();
							break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						default:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║           UNGÜLTIGE WAHL            ║");
							System.out.println("╚═════════════════════════════════════╝");
						break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
							
						}// Fechando chaves do bloco switch(escolhaMenu)
		
			        }while(escolhaMenu != 5);
			break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) Portugues
			} //Chave que fecha o if(tipoUser.equals("admin"))

			else if(tipoUser.equals("usuario")){
				do {
						System.out.println("╔═════════════════════════════════════╗");
			            System.out.println("║            WEGONE-SYSTEM            ║");
			            System.out.println("╚═════════════════════════════════════╝");
			            System.out.println("  1 - 🔍 Suche nach Orientierung        ");
			            System.out.println("  2 - 👋 Verlassen Sie das System                        ");
			            System.out.println("═══════════════════════════════════════");
			            System.out.print("  ? - Ihre Wahl: ");
					escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
					
					switch(escolhaMenu) { //MENU PRINCIPAL 
					
						case 1:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║        Suche nach Orientierung      ║");
							System.out.println("╚═════════════════════════════════════╝");
							System.out.println("  1 - 🧾 Alle Orientierungen        ");
							System.out.println("  2 - 📄 Spezifische Orientierung        ");
							System.out.println("═══════════════════════════════════════");
							System.out.print("  ? - Ihre Wahl: ");
							escolhaPesquisa = leiaNum.nextInt();
						
							switch(escolhaPesquisa) { //MENU DE PESQUISA
								case 1:
									Alemao.listar_todas_orientacoes_alemao();
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
								System.out.println("║          SPEZIFISCHE SUCHE          ║");
								System.out.println("╚═════════════════════════════════════╝");
								System.out.println("  1 - 📊 Suche nach Typ          ");
								System.out.println("  2 - 📊 Suche nach ID        ");
								System.out.println("  3 - 📊 Suche nach Titel        ");
								System.out.println("═══════════════════════════════════════");
								System.out.print("  ? - Ihre Suchauswahl: ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
									System.out.println("║             NACH ORIENTIERUNGSART             ║");
									System.out.println("╚═══════════════════════════════════════════════╝");
									System.out.println("  1 - 📊 Suche nach Typ          ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.println("  1 - 🗂️ Bedienungsanleitung                       ");
									System.out.println("  2 - 🗂️ Sicherheitsverfahren                       ");
									System.out.println("  3 - 🗂️ Wartung und Reparaturen                ");
									System.out.println("  4 - 🗂️ Tests und Diagnose                  ");
									System.out.println("  5 - 🗂️ Branchenhandbuch für Verhalten und Betrieb ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.print("  ? - Geben Sie den Ausrichtungstyp ein: ");
									int tipoLeitura = leiaNum.nextInt();
									
									Alemao.listar_orientacoes_alemao_pelo_tipo(tipoLeitura);
									
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║          NACH ORIENTIERUNGS-ID          ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  2 - 📊 Suche nach ID               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Geben Sie die ID ein: ");
									int codigo_orientacao = leiaNum.nextInt();
									Alemao.listar_orientacao_pelo_codigo_alemao(codigo_orientacao);
								break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║         NACH ORIENTIERUNG TITEL        ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  3 - 📊 Suche nach Titel                ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Geben Sie den Titel ein: ");
									String titulo_orientacao = leiaStr.nextLine();
									Alemao.listar_orientacao_pelo_titulo_alemao(titulo_orientacao);
								break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║           UNGÜLTIGE WAHL            ║");
									System.out.println("╚═════════════════════════════════════╝");
								break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
							
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
						}// Fechando chaves do bloco switch(escolhaPesquisa)
						
					break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
					
						
					//------------------------------------------------------------
							
					case 2: 
						Alemao.mensagem_sair_sistema_alemao();
						break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
						
					//------------------------------------------------------------
						
					default:
						System.out.println("\n╔═════════════════════════════════════╗");
						System.out.println("║           UNGÜLTIGE WAHL            ║");
						System.out.println("╚═════════════════════════════════════╝");
					break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
						
					}// Fechando chaves do bloco switch(escolhaMenu)
	
				}while(escolhaMenu != 2);
		break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) Deutsch
			}else{
				System.out.println("\n╔═════════════════════════════════════╗");
				System.out.println("║           ERRO NO LOGIN             ║");
				System.out.println("╚═════════════════════════════════════╝");
			}
			
			
			
//===========================================================================================================
			
			
			
				case 4: //Français
				tipoUser = Usuarios.menu_login_fr();
				if(tipoUser.equals("admin")){
			        do {
			        	System.out.println("╔═════════════════════════════════════╗");
			            System.out.println("║            SISTEMA WEGONE           ║");
			            System.out.println("╚═════════════════════════════════════╝");
			            System.out.println("  1 - 📝 Cadastrar Orientação        ");
			            System.out.println("  2 - 🔍 Pesquisar Orientação        ");
			            System.out.println("  3 - ✏️ Editar Orientação           ");
			            System.out.println("  4 - 🗑️ Excluir Orientação          ");
			            System.out.println("  5 - 👋 Sair                        ");
			            System.out.println("═══════════════════════════════════════");
			            System.out.print("  ? - Sua Escolha: ");
						escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
						
						switch(escolhaMenu) { //MENU PRINCIPAL 
						case 1:
							Francais.cadastrar_orientacoes_francais(leiaStr, leiaNum);
						break; // BREAK DO CASE 1 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
						
						case 2:
							System.out.println("\n╔═════════════════════════════════════╗");
				            System.out.println("║         PESQUISAR ORIENTAÇÃO        ║");
				            System.out.println("╚═════════════════════════════════════╝");
				            System.out.println("  1 - 🧾 Todas as Orientações        ");
				            System.out.println("  2 - 📄 Orientação Específica        ");
				            System.out.println("═══════════════════════════════════════");
				            System.out.print("  ? - Sua Escolha: ");
							escolhaPesquisa = leiaNum.nextInt();
							
							switch(escolhaPesquisa) { //MENU DE PESQUISA
							case 1:
								Francais.listar_todas_orientacoes_francais();
							break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
					            System.out.println("║         PESQUISA ESPECÍFICA         ║");
					            System.out.println("╚═════════════════════════════════════╝");
					            System.out.println("  1 - 📊 Buscar pelo Tipo          ");
					            System.out.println("  2 - 📊 Buscar pelo Código        ");
					            System.out.println("  3 - 📊 Buscar pelo Título        ");
					            System.out.println("═══════════════════════════════════════");
					            System.out.print("  ? - Sua Escolha de Busca: ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
						            System.out.println("║             PELO TIPO DA ORIENTAÇÃO           ║");
						            System.out.println("╚═══════════════════════════════════════════════╝");
						            System.out.println("  1 - 🗂️ Manual de operação               ");
						            System.out.println("  2 - 🗂️ Procedimento de segurança        ");
						            System.out.println("  3 - 🗂️ Manutenção e Reparos             ");
						            System.out.println("  4 - 🗂️ Testes e Diagnósticos            ");
						            System.out.println("  5 - 🗂️ Manual de Conduta e Operações Setoriais ");
						            System.out.println("═════════════════════════════════════════════════");
						            System.out.print("  ? - Insira o Tipo: ");
						            int tipoLeitura = leiaNum.nextInt();
						            
							        Francais.listar_orientacoes_francais_pelo_tipo(tipoLeitura);
							        
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
						            System.out.println("║      PELO CÓDIGO DA ORIENTAÇÃO      ║");
						            System.out.println("╚═════════════════════════════════════╝");
						            System.out.println("  2 - 📊 Buscar pelo Código               ");
						            System.out.println("══════════════════════════════════════");
						            System.out.print("  ? - Insira o Código: ");
							        int codigo_orientacao = leiaNum.nextInt();
							        Francais.listar_orientacao_pelo_codigo_francais(codigo_orientacao);
									break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
						            System.out.println("║      PELO TÍTULO DA ORIENTAÇÃO      ║");
						            System.out.println("╚═════════════════════════════════════╝");
						            System.out.println("  3 - 📊 Buscar pelo Título               ");
						            System.out.println("══════════════════════════════════════");
						            System.out.print("  ? - Insira o Título: ");
							    	String titulo_orientacao = leiaStr.nextLine();
							    	Francais.listar_orientacao_pelo_titulo_francais(titulo_orientacao);
									break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
						            System.out.println("║          ESCOLHA INVÁLIDA           ║");
						            System.out.println("╚═════════════════════════════════════╝");
									break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
								
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
							
							//------------------------------------------------------------
							
							}// Fechando chaves do bloco switch(escolhaPesquisa)
							
						break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
						
						//------------------------------------------------------------
							
						case 3:
							Francais.editar_orientaçao_titulo_pelo_id_francais(leiaNum, leiaStr);
							break; // BREAK DO CASE 3 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						case 4:
							Francais.deletar_orientação_francais(leiaNum);
							break; // BREAK DO CASE 4 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
								
						case 5: 
							Francais.mensagem_sair_sistema_francais();
							break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
							
						//------------------------------------------------------------
							
						default:
							System.out.println("\n╔═════════════════════════════════════╗");
				            System.out.println("║          ESCOLHA INVÁLIDA           ║");
				            System.out.println("╚═════════════════════════════════════╝");
							break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
							
						}// Fechando chaves do bloco switch(escolhaMenu)
		
			        }while(escolhaMenu != 5);
			break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) Portugues
			} //Chave que fecha o if(tipoUser.equals("admin"))

			else if(tipoUser.equals("usuario")){
				do {
					System.out.println("╔═════════════════════════════════════╗");
					System.out.println("║            SISTEMA WEGONE           ║");
					System.out.println("╚═════════════════════════════════════╝");
					System.out.println("  1 - 🔍 Pesquisar Orientação        ");
					System.out.println("  2 - 👋 Sair                        ");
					System.out.println("═══════════════════════════════════════");
					System.out.print("  ? - Sua Escolha: ");
					escolhaMenu = leiaNum.nextInt(); //Escolha do usuário no menu
					
					switch(escolhaMenu) { //MENU PRINCIPAL 
					
						case 1:
							System.out.println("\n╔═════════════════════════════════════╗");
							System.out.println("║         PESQUISAR ORIENTAÇÃO        ║");
							System.out.println("╚═════════════════════════════════════╝");
							System.out.println("  1 - 🧾 Todas as Orientações        ");
							System.out.println("  2 - 📄 Orientação Específica        ");
							System.out.println("═══════════════════════════════════════");
							System.out.print("  ? - Sua Escolha: ");
							escolhaPesquisa = leiaNum.nextInt();
						
							switch(escolhaPesquisa) { //MENU DE PESQUISA
								case 1:
									Francais.listar_todas_orientacoes_francais();
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
							case 2 :
								System.out.println("\n╔═════════════════════════════════════╗");
								System.out.println("║         PESQUISA ESPECÍFICA         ║");
								System.out.println("╚═════════════════════════════════════╝");
								System.out.println("  1 - 📊 Buscar pelo Tipo          ");
								System.out.println("  2 - 📊 Buscar pelo Código        ");
								System.out.println("  3 - 📊 Buscar pelo Título        ");
								System.out.println("═══════════════════════════════════════");
								System.out.print("  ? - Sua Escolha de Busca: ");
								escolhaBuscaEspecifica = leiaNum.nextInt(); 
								
								switch(escolhaBuscaEspecifica) { //MENU DE PESQUISA ESPECÍFICA
								case 1: 
									System.out.println("\n╔═══════════════════════════════════════════════╗");
									System.out.println("║             PELO TIPO DA ORIENTAÇÃO           ║");
									System.out.println("╚═══════════════════════════════════════════════╝");
									System.out.println("  1 - 🗂️ Manual de operação               ");
									System.out.println("  2 - 🗂️ Procedimento de segurança        ");
									System.out.println("  3 - 🗂️ Manutenção e Reparos             ");
									System.out.println("  4 - 🗂️ Testes e Diagnósticos            ");
									System.out.println("  5 - 🗂️ Manual de Conduta e Operações Setoriais ");
									System.out.println("═════════════════════════════════════════════════");
									System.out.print("  ? - Insira o Tipo: ");
									int tipoLeitura = leiaNum.nextInt();
									
									Francais.listar_orientacoes_francais_pelo_tipo(tipoLeitura);
									
								break; // BREAK DO CASE 1 DO BLOCO switch(escolhaBuscaEspecifica)
							
								//------------------------------------------------------------
								
								case 2:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║      PELO CÓDIGO DA ORIENTAÇÃO      ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  2 - 📊 Buscar pelo Código               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Insira o Código: ");
									int codigo_orientacao = leiaNum.nextInt();
									Francais.listar_orientacao_pelo_codigo_francais(codigo_orientacao);
									break;	// BREAK DO CASE 2 DO BLOCO switch(escolhaBuscaEspecifica)
								
								//------------------------------------------------------------
									
								case 3: 
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║      PELO TÍTULO DA ORIENTAÇÃO      ║");
									System.out.println("╚═════════════════════════════════════╝");
									System.out.println("  3 - 📊 Buscar pelo Título               ");
									System.out.println("══════════════════════════════════════");
									System.out.print("  ? - Insira o Título: ");
									String titulo_orientacao = leiaStr.nextLine();
									Francais.listar_orientacao_pelo_titulo_francais(titulo_orientacao);
									break; // BREAK DO CASE 3 DO BLOCO switch(escolhaBuscaEspecifica)
									
								//------------------------------------------------------------
									
								default:
									System.out.println("\n╔═════════════════════════════════════╗");
									System.out.println("║          ESCOLHA INVÁLIDA           ║");
									System.out.println("╚═════════════════════════════════════╝");
									break; // BREAK DO DEFAULT DO BLOCO switch(escolhaBuscaEspecifica)
									
								}// Fechando chaves do bloco switch(escolhaBuscaEspecifica)
							
							break; // BREAK DO CASE 2 DO BLOCO switch(escolhaPesquisa)
						
						//------------------------------------------------------------
						
						}// Fechando chaves do bloco switch(escolhaPesquisa)
						
					break; // BREAK DO CASE 2 DO BLOCO switch(escolhaMenu)
					
						
					//------------------------------------------------------------
							
					case 2: 
						Francais.mensagem_sair_sistema_francais();
						break; // BREAK DO CASE 5 DO BLOCO switch(escolhaMenu)
						
					//------------------------------------------------------------
						
					default:
						System.out.println("\n╔═════════════════════════════════════╗");
						System.out.println("║          ESCOLHA INVÁLIDA           ║");
						System.out.println("╚═════════════════════════════════════╝");
						break; // BREAK DO DEFAULT DO BLOCO switch(escolhaMenu)
						
					}// Fechando chaves do bloco switch(escolhaMenu)
	
				}while(escolhaMenu != 2);
		break; // BREAK DO CASE 1 DO BLOCO switch(escolhaIdioma) Deutsch
			}else{
				System.out.println("\n╔═════════════════════════════════════╗");
				System.out.println("║           ERRO NO LOGIN             ║");
				System.out.println("╚═════════════════════════════════════╝");
			}
			
			
//===========================================================================================================	
			
			
					
				case 5: //Español
				
			break; // BREAK DO CASE 5 DO BLOCO switch(escolhaIdioma) Español
			
			
			
//===========================================================================================================	
			
			
			
				default:
					System.out.println("\n╔═════════════════════════════════════╗");
		            System.out.println("║          ESCOLHA INVÁLIDA           ║");
		            System.out.println("╚═════════════════════════════════════╝");
			break; // BREAK DO DEFAULT DO BLOCO switch(escolhaIdioma) default
			
		}// Fechando chaves do bloco switch(escolhaIdioma) 
	        leiaStr.close();
	        leiaNum.close();
	 }
}
