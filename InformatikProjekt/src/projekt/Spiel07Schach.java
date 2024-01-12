package projekt;

public class Spiel07Schach { // Emir Sultanov
	
    Input input = new Input(); // Input Object für Eingabe

   public  void SchachspielInfo() {  // methode für Einführung in Spiel , information für den Spieler
       System.out.println("Sie befinden sich im Schachspielsraum. Es gibt ein großes Schachbrett 8x8 m² mit den Figuren , " +
               "Jede Schachfigur wiegt etwa 15-30kg.");
       input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung
       System.out.println("Sie müssen nur 2 zum Gewinn führende Züge finden, bzw diese Figuren auf richtige" +
               "Stellen platzieren. Sie dürfen nur 2 Züge, ohne dass HP und ST zu verlieren, ausführen.");
       input.next();
       System.out.println("BSP Züg. Le4 - Läufer geht auf e4 Position.");

   }

   public  void initializeChessboard(char[][] schachbrett) { // Methode  zur Initialiserierung  das Schachbrett mit den Figuren und Koordinaten.

       // Schachbrett ausfüllung mithilfe for Schleife
       for (int zeil = 1; zeil < 9; zeil++) { //  Drückung von einem Schachbrett auf dem Bildschirm aus, AUSFÜLLEN der Zeilen mit den Felder

           for (int spalt = 1; spalt < 9; spalt++) { // Ausfüllen Spalten mit den Felder

               if ((zeil + spalt) % 2 == 0) { // Die Summe von Zeilen- und Spaltenindizes bestimmt , ob die Indizensumme gerade oder ungerade ist damit, ein Feld weiß oder schwarz wird.

                   schachbrett[zeil][spalt] = '\u25A0'; // Wenn die Summe gerade ist wird das Feld als weißes Feld (\u25A0) markiert.

               } else {

                   schachbrett[zeil][spalt] = '\u25A1'; // Wenn die Summe ungerade ist  wird das Feld als schwarzes Feld (\u25A1) markiert.

               }
           }
       }
       char[] koordinaten = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}; // eine Initialisierung eines Zeichenarrays namens koordinaten

       for (int i = 0; i < 8; i++) { // Schleife für Einsetzung der Koordinaten Buchstaben und Nummern

           schachbrett[0][i+1] = koordinaten[i]; //  i+1 stellt sicher, dass die Buchstaben in der richtigen Reihenfolge in den Spalten 1 bis 8 platzieren.

           schachbrett[i+1][0] = (char) ('8' - i); //  Ausfüllen der Koordinaten in Zeilen 8-1 im Array für Zeilen (Es gibt max 9 zeilen)
       }
       // Weiße figüre Stellung
       schachbrett[1][1] = '\u2654'; // Schwarzer König
       schachbrett[5][3] = '\u265E'; // Weißer Springer
       schachbrett[2][8] = '\u265D'; // Weißer Läufer
       schachbrett[3][3] = '\u265A'; // Weißer König
       schachbrett[5][7] = '\u265C'; // Weißer Turm

       for (int zeil = 0; zeil < 9; zeil++) {//  Drückung von einem Schachbrett auf dem Bildschirm aus, Erzeugen der Zeilen im Array es gibt 9 Zeilen max

           for (int spalt = 0;spalt < 9; spalt++) { // Erzeugen des Spaltens im Array mithilfe for Schleife , es gibt 9 Spalten

               System.out.print(schachbrett[zeil][spalt] + " " + " " + " " + " " ); // Für jedes Feld auf dem Schachbrett druckt es den Wert dieses Feldes und einige Leerzeichen, um die Felder voneinander zu trennen.

           }
           System.out.println(); // Es hilft schachbrett visuell korrekt darstellen, jede Zeile des Schachbretts in einer neuen Zeile der Ausgabe dargestellt wird.
       }


   }
   public void SchachStatusKontrolle (Player player) {
	   player.recover(); // die (HP) und (ST) des Spielers auffüllt, wie es vorher gespeichert wurde
       
	      
       if (player.getSt() < 20 || player.getHp() < 20) { // Wenn Spieler ST benötigt, wird er mehrere zusätzliche ST bekommen
           System.out.println("Sie spüren eine Welle der Erholung durch Ihren Körper fließen.");
           player.setSt(player.getSt() +20 ); 
           player.setHp(player.getHp() +20 ); 
       }
       else {
           System.out.println("Sie atmen tief durch und fühlen sich  mehrer erfrischt.");
           player.setSt(player.getSt() +10 ); // Ansonsten bekommt er etwas weniger
       }
   }
   public  void SchachspielAktion(Player player,char[][] schachbrett) { // Erste Eingabe des Spielers, Methode mit den Parametern Player und schachbrett
	   
	
	   
       int ans; // eine Variable namens deklariert die später verwendet wird, um die Antwort des Spielers zu speichern

       System.out.println("Wählen und geben Sie bitte den ersten Zug für die weißen Figuren  an: (1-4)");

           do {  // Wird solange ausgefuhrt, wenn ans nicht gleich 2 UND Spieler hat noch ST HP

               ans = input.scannerInt("1. Läufer Le4 2. König Kb6 3. Turm Tg8 4. Springer Se6: (1-4)", 4); // Zuweisung und Speicherung der Eingabe mit der Fragestellung


           if (ans != 2) { // Wenn die Antwort nicht gleich 2 ist, wird der Spieler aktualisiert.

               // Der Spieler wird nur aktualisiert, wenn die Eingabe korrekt ist

               player.setHp(player.getHp() - 15);  // Wenn Eingabe des Spielers nicht 2 ist, HP wird um 15 sich verringert
               player.setSt(player.getSt() - 15); //  Wenn Eingabe des Spielers nicht 2 ist, ST wird um 15 sich verringert
               player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt

               System.out.println("Probieren Sie es noch einmal.");

               if (player.getHp() <= 0 || player.getSt() <= 0) { // Wenn der Spieler keine HP oder ST mehr hat, wird eine Meldung ausgegeben.

                   System.out.println("Der Zug war falsch, der Schachmatt ist somit in 2 Zügen nicht möglich, probieren Sie noch ");
                   
                   SchachStatusKontrolle(player); // Spieler bekommt Unterstutzung,falls HP und ST ausgegangen sind
                   
                   SchachspielAktion(player,schachbrett);
                   
                   SchachspielAktion2(player,schachbrett);// Aufforderung des Spieles SchachAktion nochmal machen vom Anfang

                   break; // Ende der Schleife
               }
           } else {
               erneuerungSchachbrett(schachbrett); // Aktualisieren  Schachbrett mit der neuen Position
           }
       } while (ans != 2); // Wird solange ausgefuhrt, wenn ans nicht gleich 2

       player.statusZeigen();
   }

   public void SchachspielAktion2 (Player player, char[][] schachbrett) { // Zweite Eingabe des Spielers, Methode mit den Parametern Player und ein schachbrett

       System.out.println("Schwarzer König geht zur einzigen möglichen Position b8");

       ernuerungSchachbrett2(schachbrett); // Aufruf der Methode zum Anzeigen des aktualistirten Schachbrett mit den neuen Positionen

       System.out.println("Wählen und geben Sie bitte den Zug für die weißen Figuren Schachmatt an: (1-4)");
       int ans; // eine Variable namens deklariert die später verwendet wird, um die Antwort des Spielers zu speichern
       do { // Wird solange ausgefuhrt, wenn ans nicht gleich 4 UND Spieler hat noch ST HP
           ans = input.scannerInt("1. König Kc7 2. Springer Sb5 3. Läufer Lf5 4. Turm Tg8  ", 4); //  // Zuweisung und Speicherung der Eingabe des Spieler mit der Fragestellung

           if (ans != 4) { // Wenn die Antwort nicht gleich 4 ist, wird der Spieler aktualisiert.

               // Der Spieler wird nur aktualisiert, wenn die Eingabe korrekt ist
               player.setHp(player.getHp() - 15); // Wenn Eingabe des Spielers nicht 4 ist, HP wird um 15 sich verringert
               player.setSt(player.getSt() - 15); //  Wenn Eingabe des Spielers nicht 4 ist, ST wird um 15 sich verringert
               player.statusZeigen();  // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
               System.out.println("Probieren Sie es noch einmal.");
               if (player.getHp() <= 0 || player.getSt() <= 0) { // Wenn der Spieler keine HP oder ST mehr hat, wird eine Meldung ausgegeben.

                   System.out.println("Sie haben die falschen Figure verschoben, somit sie ihren Rücken beschädet haben und sie brauchen Erholung ");
                   
                   SchachStatusKontrolle(player); // Spieler bekommt Unterstutzung,falls HP und ST ausgegangen sind
                   
                   SchachspielAktion(player,schachbrett); // Aufforderung des Spieles SchachAktion nochmal machen vom Anfang
                   
                   erneuerungSchachbrett(schachbrett);
                   
                   SchachspielAktion2(player,schachbrett);

                   break; // Ende der Schleife
               }
           } else {
               ernuerungSchachbrett3(schachbrett);  // Aufruf der Methode zum Anzeigen des aktualistirten Schachbrett mit den neuen Positionen
               System.out.println("Schachmatt! Herzliche Glückwunsche! Sie haben erfoglreich das Spiel beendet  ");
           }
       } while (ans != 4); // Wird solange ausgefuhrt, wenn ans nicht gleich 2 

   }

   public  void erneuerungSchachbrett(char[][] schachbrett) { // Methode zur Aktualisierung des Schachbrett mit Parameter 2 dimensionales char Arrays  schachbrett
       System.out.println("Super!!, sie haben ersten Zug gefunden!! :) !");
       char weißerKönig = schachbrett[3][3]; // Zuweisung der ursprunglichen Position der Figur
       schachbrett[3][2] = weißerKönig; // Die neue Stelle der Figur weißerKönig wird in array erstellt
       schachbrett[3][3] = '\u25A0'; // Das ursprüngliche Feld der Figur wird weißes Feld sein ("gelöscht")

   }
   public  void ernuerungSchachbrett2 (char[][]schachbrett) { // Methode zur Aktualisierung des Schachbrett mit Parameter 2 dimensionales char Arrays  schachbrett
       char SchwarzerKönig = schachbrett[1][1]; // Zuweisung der ursprunglichen Position der Figur
       schachbrett[1][2] = SchwarzerKönig;  // neue Stelle der Figur SchwarzerKönig wird in array erstellt
       schachbrett[1][1] = '\u25A0'; // Das ursprüngliche Feld der Figur wird weißes Feld sein (sozusagen gelöscht)
       //  das aktualisierte Schachbrett
       for (int zeil = 0; zeil < 9; zeil++) { //  Drückung von einem Schachbrett auf dem Bildschirm aus, Erzeugen der Zeilen im Array es gibt 9 Zeilen max
           for (int spalt = 0; spalt < 9; spalt++) { // Erzeugen des Spaltens im Array mithilfe for Schleife , es gibt 9 Spalten
               System.out.print(schachbrett[zeil][spalt]  + " " + " " + " " + " " ); // Für jedes Feld auf dem Schachbrett druckt es den Wert dieses Feldes und einige Leerzeichen um Felder voneinander zu trennen.
           }
           System.out.println(); // Es hilft  das schachbrett visuell korrekt darstellen, jede Zeile des Schachbretts in einer neuen Zeile der Ausgabe dargestellt wird.
       }

   }
   public void ernuerungSchachbrett3 (char[][]schachbrett) { // Methode zur Aktualisierung des Schachbrett mit Parameter 2 dimensionales char Arrays  schachbrett
       char Turm = schachbrett[5][7]; // Turm;
       schachbrett[1][7] = Turm;
       schachbrett[5][7] = '\u25A0'; // Das ursprüngliche Feld der Figur wird weißes Feld sein
       //  das aktualisierte Schachbrett
       for (int zeil = 0; zeil < 9; zeil++) { //  Drückung von einem Schachbrett auf dem Bildschirm aus, Erzeugen der Zeilen im Array es gibt 9 Zeilen max
           for (int spalt = 0; spalt < 9; spalt++) { // Erzeugen des Spaltens im Array mithilfe for Schleife , es gibt 9 Spalten
               System.out.print(schachbrett[zeil][spalt]  + " " + " " + " " + " " ); // Für jedes Feld auf dem Schachbrett druckt es den Wert dieses Feldes und einige Leerzeichen um Felder voneinander zu trennen.
           }
           System.out.println();  // Es hilft schachbrett visuell korrekt darstellen, jede Zeile des Schachbretts in einer neuen Zeile der Ausgabe dargestellt wird.
       }

   }

}
