package co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.ParameterCatalogService;

@Service
public class ParameterCatalogServiceImpl implements ParameterCatalogService {

    private final RedisTemplate<String, String> redisTemplate;

    public ParameterCatalogServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getParameter(String parameterName) {
        return redisTemplate.opsForValue().get(parameterName); 
    }
}