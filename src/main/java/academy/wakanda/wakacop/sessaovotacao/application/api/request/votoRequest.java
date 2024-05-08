package academy.wakanda.wakacop.sessaovotacao.application.api.request;

import academy.wakanda.wakacop.sessaovotacao.domin.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
	private String cpfAssociado;
	private OpcaoVoto opcaoVoto;
}
