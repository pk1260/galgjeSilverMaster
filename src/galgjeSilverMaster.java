import java.util.Scanner;

public class galgjeSilverMaster {

    public static void main (String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Welkom bij galgje een game die je laat hangen van spanning.");
        System.out.println("");
        System.out.println("Voer hier het woord in dat je wilt gebruiken als antwoord");
        String woord = input.nextLine();
        woord = woord.trim(); // alle spaties gaan weg.
        woord = woord.replaceAll(" ", "  ");
        woord = woord.toUpperCase(); // alles naar hoofdletters
        String woord1 = woord.replaceAll("[A-Z]", "_ "); // swapt de letters van het alfabet met onbekende tekens.

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Okey hier is het verborgen woord!");

        int pogingen = 0; // telt de pogingen
        int incorrect = 0; // telt de incorrecten pogingen
        String raad; // slaat de geraden letterinvoer op
        char letter; // pakt de eerste letter van raad voor gebruik
        boolean radenBevatGok;  // boolean voor raad in alle geraaden letters
        String gokken = ""; // slaat alle geraade letters op
        boolean woordBevatGok; // boolean voor raad in woord1

        while (incorrect < 5 && woord1.contains("_")){ // while loop begint

            System.out.println(woord1);
            System.out.println("\n");
            System.out.println("Je heb " + incorrect + " incorrect zover.");
            System.out.println("\n");

            if (incorrect == 1) { // galg met 1 fout
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |            |");
                System.out.println("        |            |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            }

            else if (incorrect == 2) { // galg met 2 fouten
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |      |     |");
                System.out.println("        |            |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            }

            else if (incorrect == 3) { // galg met 3 fouten
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |     -|-    |");
                System.out.println("        |            |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            }

            else if (incorrect == 4) { // galg met 4 fouten
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |     -|-    |");
                System.out.println("        |      |     |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            }

            System.out.println("Gok een letter");
            raad = input.nextLine(); // neemt de gok als volgende input als alles goed gaat
            raad = raad.toUpperCase(); // zet allen letter naar hoofdletters
            letter = raad.charAt(0); // neemt de eerste letter van de geraden letters

            radenBevatGok = (gokken.indexOf(letter)) != -1;
            gokken += letter; // slaat allen letter op in gokken

            letter =  Character.toUpperCase(letter); // verander naar hoofdletter voor vergelijking
            System.out.println("\n");
            if (radenBevatGok == true){ // if begint nu
                System.out.println("Je hebt " + letter + "al gegokt."); // print dit uit
                System.out.println("\n");
                if (incorrect > 0) { // de binnen if begint
                    incorrect--;
                } // // de binnen if eindigt
            }

            woordBevatGok = (woord.indexOf(letter)) != -1;
            if (woordBevatGok == true) { // if begint nu
                System.out.println(letter + " zit in de zin."); // print dit uit
                System.out.println("\n");
                for (int positie = 0; positie < woord.length(); positie++) { // for begint
                    if (woord.charAt(positie) == letter && woord1.charAt(positie) != letter) {
                        // de binnen if begint
                        woord1 = woord1.replaceAll("_ ", "_");
                        String woord2;
                        woord2 = woord1.substring(0, positie) + letter + woord1.substring(positie + 1);
                        woord2 = woord2.replaceAll("_", "_ ");
                        woord1 = woord2;
                        // de binneen if eindigt
                    }
                }
            }// While loop stopt

            else { // else begint
                System.out.println("\n");
                System.out.println(letter + " is niet in de zin."); // print dit uit
                System.out.println("\n");
                incorrect++; // elke incorrecte antwoord +1 na een foute invoer
            }

            pogingen++; // elke opging +1 na een poging
        } // While loop stopt

        if (incorrect == 5) { // galg met 2 fouten
            System.out.println("         ____________");
            System.out.println("        |      |     |");
            System.out.println("        |      O     |");
            System.out.println("        |     -|-    |");
            System.out.println("        |      |     |");
            System.out.println("       	|     / \\    |");
            System.out.println("         ____________");
            System.out.print("\n");
            System.out.println("Sorry je heb je limiet berijkt GAME OVER!");
        }
        else {
            System.out.println("Het woord is:"); // het antwoord
            System.out.println(woord1);
            System.out.println("Gefeliciteerd je heb het opgelost!");
        }

        input.close(); // stopt de scan
    }
}