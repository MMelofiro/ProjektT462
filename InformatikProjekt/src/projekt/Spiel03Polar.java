package projekt;
import java.util.Random;

public class Spiel03Polar { // Emir Sultanov
	
   Random random = new Random(); // random Object der klasse Random wird erzeugt
   Input input = new Input(); // Input Object für Eingabe

   public void SpielInfo() {  // methode für Einführung in Spiel , information für den Spieler
       System.out.println("Sie betreten den nächsten Raum. Überall liegt Schnee und Eis.");
       System.out.println("Der Schneefall hat aufgehört, und Sie erblicken einen langen Pfad aus Eis, der bis zur nächsten Tür führt.");
       this.input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung
       System.out.println("Plötzlich durchdringt das markerschütternde Gebrüll eines Eisbären die Luft. Die hungrigen Tiere setzen zum Sprint an.");
       System.out.println("Die Zeit ist knapp. Sie müssen dem Eissee entlang rennen.");
       this.input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung
   }

   public  void einzigeAktion(Player player) { // Methode zur Aktion des Spieles
       player.recover();  // die (HP) und (ST) des Spielers auffüllt, wie es vorher gespeichert wurde

       System.out.println("Sie müssen schnell handeln und die richtige Geschwindikeit wählen.");

       System.out.println("Sie wählen die Geschwindikeit V , mit der sie rennen werden.");

       System.out.println("Geben Sie ihre V , die schneller als V der Tieren . Wenn der Laufweg genau 1,5 km ist und die Tiere rennen ungefähr diese Strecke für ab 6 bis 18 Minuten ");

       System.out.println("Beschleunigung ist nicht berücksichtigt");
       double s = 1.5; // Strecke in km ,Zuweisung den Wert der Variabel s

       double vt = random.nextDouble() * 10 + 5; // Geschwindigkeit der Tiere, zuweisung mit der Methode random.nextDouble, bereich [5;15)


       double v = this.input.scannerDouble("Bitte geben Sie Ihre Geschwindigkeit ein:"); // Zuweisung und Speicherung der Eingabe mit der Fragestellung
      // double v = antwort.nextDouble(); // Geschwindigkeit des Spielers , Zuweisung und Speicherung der Eingabe


       if (v > vt) { // Wenn Spieler V > vt true ist dann alles in ordnung
           player.setSt(player.getSt() - 15);   // ST wird um 15 sich verringert

           if (player.getHp() > 0 && player.getSt() > 0) {  // Wenn benutzer richtie Ans also richtige antwort gegeben hat, dann wird überprüft ob er noch ST und HP hat
               System.out.println("Richtig! Sie haben es überlebt. Sie haben zwar einige Ausdauerpunkte verloren.Machen Sie ruhig Pause =) ");
           }
           else {
               System.out.println("Sie waren nah am Gewinn, aber nächstes Mal schaffen Sie es! :) ");
               this.einzigeAktion(player); // Aufforderung des Spieles ersteAktion nochmal machen vom Anfang
           }


       } else {
           System.out.println("Sie wurden von den Tieren überholt oder haben die Ziellinie überschritten. Spiel beendet.");
           this.einzigeAktion(player);

           }

       }

}
