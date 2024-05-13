package academy.wakanda.wakacop.associado.application.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService {
	
	@Override
	public void validaAssociadoAptoVoto(String cpfAssociado) {
		log.info("[start] AssociadoApplicationService - validaAssociadoAptoVoto");
		log.info("[finish] AssociadoApplicationService - validaAssociadoAptoVoto");
	}

}
