package Com.Course.Server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",tags = "这是我的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "获取Cookies信息",httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得Cookies信息成功";
    }

    /**
      * 要求客户端携带Cookies信息访问
     */
    @RequestMapping(value = "/get/Demo/Cookies", method = RequestMethod.GET)
    @ApiOperation(value = "客户端携带Cookies信息访问",httpMethod = "GET")
    public String takeCookies(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        System.out.println(cookie);

        if (Objects.isNull(cookie)) {
            return "cookies信息错误";
        } else {
            for (Cookie cook :
                    cookie) {
                System.out.println("getName :" + cook.getName() + "    " +
                        "getValue :" + cook.getValue());
                if (cook.getName().equals("login") &&
                        cook.getValue().equals("true")) {
                    return "恭喜你访问成功";
                }
            }
            return "cookies信息错误";
        }
    }

    /**
     * 实现 一个需要携带参数的get请求
     * 第一种实现方式 以URL拼接方式
     * 模拟获取商品列表
     */
    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    @ApiOperation(value = "第一种携带参数的get请求",httpMethod = "GET")
    public Map<String, Integer> getProductList(@RequestParam Integer start
            , @RequestParam Integer end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("鞋子", 400);
        map.put("方便面", 1);
        map.put("口红", 200);
        return map;
    }

    /**
     * 第二种需要携带参数的get请求
     * url：ip:port/getProductList/param/10/20  (10和20 是你传的参数)
     */
    @RequestMapping(value = "/getProductList2/{start}/{end}", method = RequestMethod.GET)
    @ApiOperation(value = "第二种携带参数的get请求",httpMethod = "GET")
    public Map<String, Integer> getProductList2(@PathVariable Integer start, @PathVariable Integer end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("鞋子", 400);
        map.put("方便面", 1);
        map.put("口红", 200);
        return map;
    }
}