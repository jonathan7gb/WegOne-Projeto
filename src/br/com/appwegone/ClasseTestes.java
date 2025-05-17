package br.com.appwegone;
import java.util.*;

public class ClasseTestes {
    public static void main(String[] args) {
        
    
    Scanner leiaStr = new Scanner(System.in);

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
    int escolhaIdioma = leiaStr.nextInt(); //Escolha do idioma do usuário
    System.out.println("");

    switch(escolhaIdioma){
        case 1:
            Usuarios.menu_login_pt();
            break;
        case 2:
            Usuarios.menu_login_en();
            break;
        case 3:
            Usuarios.menu_login_al();
            break;
        case 4:
            Usuarios.menu_login_fr();
            break;
        case 5:
            Usuarios.menu_login_es();
            break;
        default:
            System.out.println("Erro");
            break;
    }
    }
}
