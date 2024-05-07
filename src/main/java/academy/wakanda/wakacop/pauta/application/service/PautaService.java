package academy.wakanda.wakacop.pauta.application.service;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;

public interface PautaService {

	PautaCadastradaResponse cadastraPauta(NovaPautaRequest pautarequest);

}
