package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo=partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

		if(partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo)) {
			
			if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				
				partita.getIo().mostraMessaggio(" "+nomeAttrezzo+" aggiunto nella borsa");
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
			}else {

				partita.getIo().mostraMessaggio(" Spazio esaurito"); 
			}
			
		}else {
			
			partita.getIo().mostraMessaggio(" "+nomeAttrezzo+" Non presente in stanza"); 
		}

	}

	@Override
	public void setParametro(String parametro) {
		
		this.nomeAttrezzo=parametro;
	}

	@Override
	public String getParametro() {
		
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		
		return "prendi";
	}

}
