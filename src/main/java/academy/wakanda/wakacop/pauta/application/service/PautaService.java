package academy.wakanda.wakacop.pauta.application.service;

import java.util.UUID;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;
import academy.wakanda.wakacop.pauta.domain.Pauta;

public interface PautaService {
	PautaCadastradaResponse cadastraPauta(NovaPautaRequest pautarequest);
	Pauta getPautaPorId(UUID idPauta);
}
