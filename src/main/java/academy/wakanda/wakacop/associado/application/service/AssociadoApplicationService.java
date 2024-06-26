package academy.wakanda.wakacop.associado.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.associado.infra.SerproClientFeign;
import academy.wakanda.wakacop.associado.infra.client.ConcultaCpfResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
	private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
	private final SerproClientFeign serproClientFeign;
	
	@Override
	public void validaAssociadoAptoVoto(String cpfAssociado) {
		log.debug("[start] AssociadoApplicationService - validaAssociadoAptoVoto");
		ConcultaCpfResponse concultaCPFResponse = serproClientFeign.consultaCPF(TOKEN, cpfAssociado);
		valida(concultaCPFResponse);
		log.debug("[finish] AssociadoApplicationService - validaAssociadoAptoVoto");
		log.debug("[TOKEN] {}", TOKEN);
	}

	private void valida(ConcultaCpfResponse concultaCPFResponse) {
		log.debug("[start] AssociadoApplicationService - valida");
		if(concultaCPFResponse.isInvalid()) {
			throw new RuntimeException("CPF associado Inválido!");
		}
		log.debug("[finish] AssociadoApplicationService - valida");
	}
}