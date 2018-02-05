package com.wcc.wsf.common.annotation;

import com.sun.xml.internal.ws.server.sei.MessageFiller;
import com.wcc.wsf.common.codec.Header;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 0-15	16-23	24-31	32-95	96-127
 * magic	version	extend flag	request id	body content length
 * 魔数	协议版本	24-28	29-30	31
 * 消息id
 * <p/>
 * body包长
 * 保留	event( 可支持4种event，
 * 如normal, exception等)
 * <p/>
 * User: Dempe
 * Date: 2016/11/25
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Http {
    enum HttpMethod{
        DELETE,
        GET,
        POST,
        PUT
    }

    HttpMethod method();

    String uri() default "";

    Header[] headers() default {};

    @interface Header{
        String name();
        String value();
    }
}
