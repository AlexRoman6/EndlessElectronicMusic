package dad.endlessElectronicMusic.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;

@EnableCaching
@SpringBootApplication
@EntityScan("dad.endlessElectronicMusic.entidades")
@EnableJpaRepositories("dad.endlessElectronicMusic.entidades")
@EnableHazelcastHttpSession
public class Application {

	@Value("${dad.ip.app1}")
	private String ipapp1;
	@Value("${dad.ip.app2}")
	private String ipapp2;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Config config() {
		Config config = new Config();
		NetworkConfig network = config.getNetworkConfig();

		JoinConfig join = network.getJoin();
		join.getMulticastConfig().setEnabled(false);
		join.getTcpIpConfig().addMember(ipapp1).addMember(ipapp2).setEnabled(true);
		network.getInterfaces().setEnabled(true).addInterface(ipapp1).addInterface(ipapp2);
		return config;
	}

	private static final Log LOG = LogFactory.getLog(Application.class);

	@Bean
	public CacheManager cacheManager() {
		LOG.info("Activating cache...");
		return new ConcurrentMapCacheManager("index");
	}

}
