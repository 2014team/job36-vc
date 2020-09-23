package com.job36.zuul.filter;
 
import com.google.common.util.concurrent.RateLimiter;
import com.job36.common.entity.ResponseMap;
import com.job36.common.util.GsonUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RouteFilter extends ZuulFilter {

    public static final Logger logger = LoggerFactory.getLogger(RouteFilter.class);
 
    // 定义一个令牌桶，每秒产生2个令牌，即每秒最多处理2个请求
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);
 
    @Override
    public String filterType() {
        // 路由之前
        return FilterConstants.PRE_TYPE;
    }
 
    @Override
    public int filterOrder() {
        return -5;
    }
 
    @Override
    public Object run() throws ZuulException {
        logger.info("通过过滤");
        return null;
    }
 
    @Override
    public boolean shouldFilter() {
        // 获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        // 编码设置
        context.getResponse().setContentType("text/html;charset=UTF-8");
        // 获取到request
        HttpServletRequest request = context.getRequest();
        // 获取到request
        String uri = request.getRequestURI();

        // tryAcquire() 只要能够马上获致到1个令牌，则返回true，不阻塞
        // tryAcquire(5, 3, TimeUnit.SECONDS) 在3秒钟内可以获取到5个令牌，则返回true，不阻塞
        // acquire(5) 获取到5个令牌，否则一直等待，会阻塞，返回值为阻塞的时长
        // acquire() 获取到1个令牌，否则一直等待，会阻塞，返回值为阻塞的时长
        if(!RATE_LIMITER.tryAcquire()) {
            logger.warn("访问量超载");
            // 指定当前请求未通过过滤
            context.setSendZuulResponse(false);
            // 向客户端返回响应码429，请求数量过多
            context.setResponseStatusCode(429);

            // api项目访问量超载响应特殊处理
            if(uri.contains("/job36-api") ) {
                String  errMessage = errApiResponse();
                context.setResponseBody(errMessage);
            }
            return false;
        }
        return true;
    }


    public String errApiResponse(){
        ResponseMap responseMap = new ResponseMap();
        responseMap.failure("访问量超载,请稍后再试!");
        String result  = GsonUtils.toJsonAll(responseMap);
        return result;
    }
}