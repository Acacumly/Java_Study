package src1;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String method;
    private String url;
    private String varsion;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();
    public void addHeader(String key, String value){
        headers.put(key, value);
    }
    //获取某个请求
    public String getHeader(String key){
        return headers.get(key);
    }
    //解析请求参数key1 = value1&key2 =value2


    //添加请求参数
    public void addParameter(String key, String value){
        parameters.put(key, value);
    }
    //获取请求参数
    public String getParameter(String key){
        return parameters.get(key);
    }
    public String getMethod(){
        return method;
    }
}
