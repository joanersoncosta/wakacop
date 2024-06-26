package academy.wakanda.wakacop.associado.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import academy.wakanda.wakacop.associado.infra.client.ConcultaCpfResponse;

@FeignClient(name = "serproClientFeign", url = "https://gateway.apiserpro.serpro.gov.br/consulta-cpf-df-trial")
public interface SerproClientFeign {
	@GetMapping(path = "/v1/cpf/{cpfAssociado}")
	ConcultaCpfResponse consultaCPF(@RequestHeader(value = "Authorization") String token,
			@PathVariable String cpfAssociado);
}
