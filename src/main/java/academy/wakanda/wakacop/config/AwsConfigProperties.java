package academy.wakanda.wakacop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "aws.config")
@ToString
public class AwsConfigProperties {
	private String region;
	private String accesskey;
	private String secretkey;
	private String endpointuri;
	private String resultadoSessaoTopic;
}
