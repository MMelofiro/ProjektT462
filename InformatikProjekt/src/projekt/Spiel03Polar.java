package projekt;
import java.util.Random;

public class Spiel03Polar { // Emir Sultanov
	
   Input input = new Input(); // Input Object für Eingabe

   public void SpielInfo() {  // methode für Einführung in Spiel , information für den Spieler
       System.out.println("Sie betreten den nächsten Raum. Überall liegt Schnee und Eis.");
       System.out.println("Der Schneefall hat aufgehört, und Sie erblicken einen langen Pfad aus Eis, der bis zur nächsten Tür führt.");
       input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung
       System.out.println("Plötzlich durchdringt das markerschütternde Gebrüll eines Eisbären die Luft. Die hungrigen Tiere setzen zum Sprint an.");
       System.out.println("Die Zeit ist knapp. Sie müssen dem Eissee entlang rennen.");
       input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung
   }

   public  void einzigeAktion(Player player) { // Methode zur Aktion des Spieles
       player.recover();  // die (HP) und (ST) des Spielers auffüllt, wie es vorher gespeichert wurde
       if (player.getSt() < 15) { // Wenn Spieler ST benötigt, wird er mehrere zusätzliche ST bekommen
       	System.out.println("Sie haben erst sich erholt, bevor weiter zu gehen");
	player.setSt(player.getSt() +15 ); // ST wird um 15 gestiegen
        player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
       }
      
       System.out.println("Sie müssen schnell handeln und die richtige Geschwindikeit wählen.");
       input.next(); 
       System.out.println("Sie wählen die Geschwindikeit V , mit der sie rennen werden.");
       input.next(); 
       System.out.println("ihre V soll schneller als V der Tieren sein . Wenn der Laufweg genau 1,5 km ist und die Tiere rennen ungefähr diese Strecke für ab 7 bis 18 Minuten ");
       input.next(); 
       
       double vt = Math.random() * 10 + 5;; // Geschwindigkeit der Tiere, zuweisung mit der Methode random.nextDouble, bereich [5;15)

       double v = this.input.scannerDouble("Bitte geben Sie Ihre Geschwindigkeit ein:"); // Zuweisung und Speicherung der Eingabe mit der Fragestellung
     
       if (v > vt && v<40) { // Wenn Spieler V > vt true und V ist nicht groß als 44 ist dann alles in ordnung
           player.setSt(player.getSt() - 15);   // ST wird um 15 sich verringert

           if (player.getSt() > 0) {  // Wenn benutzer richtie Ans also richtige antwort gegeben hat, dann wird überprüft ob er noch ST und HP hat
               System.out.println("Richtig! Sie haben es überlebt. Sie haben zwar einige Ausdauerpunkte verloren.Machen Sie ruhig Pause =) ");
           }
           else {
               System.out.println("Sie sind müde. Erholen Sie sich und fangen sie vom Anfang an ");
               einzigeAktion(player); // Aufforderung des Spieles ersteAktion nochmal machen vom Anfang
               
           }


       } else {
           System.out.println("Sie wurden von den Tieren überholt oder haben die Ziellinie überschritten. Probieren Sie nochmal.");
           System.out.println("");
           einzigeAktion(player);

           }

       }

}
