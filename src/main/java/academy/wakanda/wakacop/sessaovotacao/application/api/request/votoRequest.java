package academy.wakanda.wakacop.sessaovotacao.application.api.request;

import academy.wakanda.wakacop.sessaovotacao.domin.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class votoRequest {
	private String cpfAssociado;
	private OpcaoVoto opcaoVoto;
}
