package Com.Course.HttpClient.Cookies;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    // 在测试方法之前获取资源文件
    private ResourceBundle bundle;
    private String host;
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        host = bundle.getString("test.url");
    }
    @Test
    public void getCookies() throws IOException {
        String url = bundle.getString("getCookies");
        String getCookies = this.host + url;
        HttpGet get = new HttpGet(getCookies);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        // 获取cookies信息
        CookieStore store = client.getCookieStore();
        this.store = store;
        List<Cookie> list = this.store.getCookies();
        for (Cookie cookie : list) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name: " + name + " ;     value: " + value);
        }
    }

    // 测试携带cookies和参数的post请求 并断言结果
    @Test(dependsOnMethods = {"getCookies"})
    public void testPostCookies() throws IOException {
        // 创建请求的url
        String url = bundle.getString("testPostCookies");
        String postUrl = this.host + url;
        // 创建Client 对象
        DefaultHttpClient client = new DefaultHttpClient();
        // 创建post方法对象
        HttpPost post = new HttpPost(postUrl);
        // 设置请求头信息
        post.setHeader("content-type", "application/json");
        // 设置cookies信息
        client.setCookieStore(this.store);
        // 设置 json 格式参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhangsan");
        jsonObject.put("age", 18);
        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"utf-8");
        post.setEntity(stringEntity);
        // 发起请求
        HttpResponse response = client.execute(post);
        // 获取参数
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        // 对参数进行json格式化
        JSONObject object = new JSONObject(result);
        System.out.println("result :" +object);
        // 断言结果
        String name = object.get("name").toString();
        int age = object.getInt("age");
        Assert.assertEquals(name,"张三");
        Assert.assertEquals(age,10);
    }
}
