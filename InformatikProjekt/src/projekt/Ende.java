package projekt;

public class Ende {
	
	public void ende1(Player player) { // Phuong Uyen To
		
		System.out.println("Sie haben alle Herausforderungen des Spiels gemeistert und trifft den Spielveranstalter.");
		System.out.println("Er gratuliert Ihnen und holt einen Koffer heraus, der aussieht, als ob darin ein Preisgeld enthalten wäre.");
		input.next();
		System.out.println("Aber dank der Erfahrung haben Sie erkannt, dass es sich um eine Waffe handelte, und weicht der Kugel aus.");
		System.out.println("Sie sind jedoch immer noch von seinen Untergebenen umgeben.");
		System.out.print("Als er sieht, dass Sie keinen Ausweg mehr haben, scheint er erleichtert zu sein und verrät, dass er weiß, dass Sie ein Detektiv sind");
		System.out.println(", der gekommen ist, um Nachforschungen anzustellen und Ihnen alles über dieses Mordspiel zu erzählen.");
		input.next();
		System.out.println("Er verleitet Sie dazu, mit ihm zusammenzuarbeiten, weil er Ihre Fähigkeiten erkennt und verspricht, Ihnen viel Geld zu zahlen, wenn Sie kooperieren.");
		System.out.println("Sie haben schon ein Signal an die Polizei gesendet und so getan, als würden Sie verhandeln, um Zeit zu gewinnen.");
		input.next();
		System.out.println("Die Organisation wurde verhaftet. Sie gedachten der Opfer und "+ player.getMitspieler()+" und erhielten große Belohnung.");
																
	}
	
	public void ende2(Player player) { // Phuong Uyen To
		
		System.out.println("Sie haben alle Herausforderungen gemeistert und trifft den Spielveranstalter.");
		System.out.println("Er gratuliert Ihnen und holt einen Koffer heraus, der aussieht, als ob darin ein Preisgeld enthalten wäre.");
		input.next();
		System.out.println("Aber dank der Erfahrung haben Sie erkannt, dass es sich um eine Waffe handelte, und weicht der Kugel aus.");
		System.out.println("Sie sind jedoch immer noch von seinen Untergebenen umgeben.");
		System.out.print("Als er sieht, dass Sie keinen Ausweg mehr haben, scheint er erleichtert zu sein und verrät, dass er weiß, dass Sie ein Detektiv sind");
		System.out.println(", der gekommen ist, um Nachforschungen anzustellen und Ihnen alles über dieses Mordspiel zu erzählen.");
		input.next();
		System.out.println("Sie möchten ein Signal an die Polizei senden und so tun, als würden Sie verhandeln, um Zeit zu gewinnen.");
		input.next();
		System.out.println("Aber "+player.getMitspieler()+"hat sich aufgehalten.");
		System.out.println(player.getMitspieler()+" ist ein Mitglied der Organisation.");
		System.out.println("Sie wurden getötet.");
			
	}


}
