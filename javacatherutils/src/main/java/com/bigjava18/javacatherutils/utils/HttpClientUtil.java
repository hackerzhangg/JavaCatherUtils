package com.bigjava18.javacatherutils.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zgp
 * @Since 2021 -10 -21 12 :16
 * @Description
 */
public class HttpClientUtil {

    private static Log logger = LogFactory.getLog(HttpClientUtil.class);

    /**
     * form-data 请求方式
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public static String doGet(String url, HashMap<String, String> map) throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (map != null) {
                for (Map.Entry<String, String> entries : map.entrySet()) {
                    builder.addParameter(entries.getKey(), entries.getValue());
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            int status = 200;
            if (response.getStatusLine().getStatusCode() == status) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            logger.error("系统错误:",e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                logger.error("系统错误:",e);
            }
        }
        logger.info("【响应结果】:"+resultString);
        return resultString;
    }
}
