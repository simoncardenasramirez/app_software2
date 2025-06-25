package co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;


@Component
public class MessageCatalogServiceImpl implements MessageCatalogService {

    private RedisTemplate<String, String> redisTemplate;
    
    

    public MessageCatalogServiceImpl(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}



	@Override
    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
