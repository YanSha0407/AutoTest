package Com.Course.HttpClient.Cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
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
             String name  = cookie.getName();
             String value = cookie.getValue();
            System.out.println("name: " + name + " ;     value: "+value);
        }
    }

    //  测试携带cookies信息的get的方法
    @Test(dependsOnMethods = {"getCookies"})
    public void testSetCookies() throws IOException {
        String url = bundle.getString("testSetCookies");
        String setCookies = this.host + url;
        HttpGet get = new HttpGet(setCookies);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        int status = response.getStatusLine().getStatusCode();
        if (status == 200){
            System.out.println("status :" + status);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
    }

}
