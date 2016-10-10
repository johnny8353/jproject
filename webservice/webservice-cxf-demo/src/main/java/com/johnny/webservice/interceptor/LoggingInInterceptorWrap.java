package com.johnny.webservice.interceptor;

import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Logger;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedWriter;
import org.apache.cxf.message.Message;

/**
 * 类 编 号：
 * 类 名 称：LoggingInInterceptorWrap
 * 内容摘要：LoggingInInterceptor封装类，用于日志持久化
 * 完成日期：2016年9月9日
 * 编码作者：JohnnyHuang 黄福强
 */
public class LoggingInInterceptorWrap extends LoggingInInterceptor{
	@Override
	public void logging(Logger logger, Message message) throws Fault {
        if (message.containsKey(LoggingMessage.ID_KEY)) {
            return;
        }
        String id = (String)message.getExchange().get(LoggingMessage.ID_KEY);
        if (id == null) {
            id = LoggingMessage.nextId();
            message.getExchange().put(LoggingMessage.ID_KEY, id);
        }
        message.put(LoggingMessage.ID_KEY, id);
        final LoggingMessage buffer 
            = new LoggingMessage("Inbound Message\n----------------------------", id);

        Integer responseCode = (Integer)message.get(Message.RESPONSE_CODE);
        if (responseCode != null) {
            buffer.getResponseCode().append(responseCode);
        }

        String encoding = (String)message.get(Message.ENCODING);

        if (encoding != null) {
            buffer.getEncoding().append(encoding);
        }
        String httpMethod = (String)message.get(Message.HTTP_REQUEST_METHOD);
        if (httpMethod != null) {
            buffer.getHttpMethod().append(httpMethod);
        }
        String ct = (String)message.get(Message.CONTENT_TYPE);
        if (ct != null) {
            buffer.getContentType().append(ct);
        }
        Object headers = message.get(Message.PROTOCOL_HEADERS);

        if (headers != null) {
            buffer.getHeader().append(headers);
        }
        String uri = (String)message.get(Message.REQUEST_URL);
        if (uri != null) {
            buffer.getAddress().append(uri);
            String query = (String)message.get(Message.QUERY_STRING);
            if (query != null) {
                buffer.getAddress().append("?").append(query);
            }
        }
        
        if (!isShowBinaryContent() && isBinaryContent(ct)) {
            buffer.getMessage().append(BINARY_CONTENT_MESSAGE).append('\n');
            log(logger, buffer.toString());
            return;
        }
        
        InputStream is = message.getContent(InputStream.class);
        if (is != null) {
            CachedOutputStream bos = new CachedOutputStream();
            if (threshold > 0) {
                bos.setThreshold(threshold);
            }
            try {
                IOUtils.copyAndCloseInput(is, bos);
                bos.flush();

                message.setContent(InputStream.class, bos.getInputStream());
                if (bos.getTempFile() != null) {
                    //large thing on disk...
                    buffer.getMessage().append("\nMessage (saved to tmp file):\n");
                    buffer.getMessage().append("Filename: " + bos.getTempFile().getAbsolutePath() + "\n");
                }
                if (bos.size() > limit) {
                    buffer.getMessage().append("(message truncated to " + limit + " bytes)\n");
                }
                writePayload(buffer.getPayload(), bos, encoding, ct); 
                    
                bos.close();
            } catch (Exception e) {
                throw new Fault(e);
            }
        } else {
            Reader reader = message.getContent(Reader.class);
            if (reader != null) {
                try {
                    CachedWriter writer = new CachedWriter();
                    IOUtils.copyAndCloseInput(reader, writer);
                    message.setContent(Reader.class, writer.getReader());
                    
                    if (writer.getTempFile() != null) {
                        //large thing on disk...
                        buffer.getMessage().append("\nMessage (saved to tmp file):\n");
                        buffer.getMessage().append("Filename: " + writer.getTempFile().getAbsolutePath() + "\n");
                    }
                    if (writer.size() > limit) {
                        buffer.getMessage().append("(message truncated to " + limit + " bytes)\n");
                    }
                    writer.writeCacheTo(buffer.getPayload(), limit);
                } catch (Exception e) {
                    throw new Fault(e);
                }
            }
        }
        log(logger, formatLoggingMessage(buffer));
        //获取请求信息
        
        String requestStr = formatLoggingMessage(buffer);
        
        System.out.println(requestStr);
    }
}
