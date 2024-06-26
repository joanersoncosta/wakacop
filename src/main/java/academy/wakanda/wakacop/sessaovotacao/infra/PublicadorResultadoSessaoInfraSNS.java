package academy.wakanda.wakacop.sessaovotacao.infra;

import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

import academy.wakanda.wakacop.config.AwsConfigProperties;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domin.PublicadorResultadoSessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class PublicadorResultadoSessaoInfraSNS implements PublicadorResultadoSessao {
	private final NotificationMessagingTemplate publicadorResultadoSNS;
    private final AwsConfigProperties awsSnsProperties;

	@Override
	public void publica(ResultadoSessaoVotacao resultadoSessaoVotacao) {
		log.debug("[start] PublicadorResultadoSessaoInfraSNS - publica");
		publicadorResultadoSNS.sendNotification(awsSnsProperties.getResultadoSessaoTopic(), resultadoSessaoVotacao, resultadoSessaoVotacao.getIdPauta().toString());
		log.debug("[finish] PublicadorResultadoSessaoInfraSNS - publica");
	}

}
