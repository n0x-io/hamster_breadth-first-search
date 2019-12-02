import java.util.ArrayList;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class FindGrain implements de.hamster.model.HamsterProgram {public void main() {
	Hamster h = Hamster.getStandardHamster();
    Search srch = new Search(h);
 	
 	// Suche Initialisieren
 	if(srch.init()){
 	 	// Pfad suchen und entsprechend des Ergebnis eine Info ausgeben
 		Field f = srch.findPath();
 		if(f!=null){
		 	if(srch.walkPathGetKorn(f))
		 		h.schreib("Hamster hat Korn gefunden und aufgenommen");
		 	else
		 		h.schreib("Fehler: Hamster konnte Korn nicht aufnehmen!");
		}
		else 
			h.schreib("Fehler: Hamster kann Korn nicht erreichen!");
 	}
 	else
 		h.schreib("Fehler: Initialisierung Fehlgeschlagen!\n(Hinweis: ggf. befindet sich kein oder meherer Körner auf dem Spielfeld.)");
}}