package academy.wakanda.wakacop.pauta.application.repository;

import java.util.UUID;

import academy.wakanda.wakacop.pauta.domain.Pauta;

public interface PautaRepsitory {
	Pauta salva(Pauta pauta);
	Pauta buscaPautaporId(UUID idPauta);
}
