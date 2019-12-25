package Com.Course.Server;

import Com.Course.Bean.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", tags = "这是我所有的post请求")
public class MyPostMethod {
    /**
     * 设置Cookies
     *
     * @return
     */
    /*
    @RequestMapping(value = "/setCookies", method = RequestMethod.POST)
    @ApiOperation(value = "获取Cookies", httpMethod = "POST")
    public String setCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "获取Cookies成功";
    }

     */
    /**
     * 获取cookies
     * 0 标识cookies 信息错误  1 获取cookies信息成功
     */
    /*
    public Integer getCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return 0;
        }
        else {
            for (Cookie c :
                    cookies) {
                if (c.getName().equals("login") && c.getValue().equals("true")){
                    return 1;
                }
            }
            return 0;
        }
    }
     */

    /**
     * 用户登录接口
     */
    @RequestMapping(value = "/getCookies", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录接口", httpMethod = "POST")
    public String userLogin(HttpServletResponse response, @RequestParam(value = "userName", required = true) String userName
            , @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("zhangsan") && password.equals("111111")) {
            Cookie cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功";
        } else {
            return "用户名或者密码错误";
        }
    }

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody UserModel userModel){
          Cookie[] cookies = request.getCookies();
        for (Cookie c :
                cookies) {
            // cookies 验证成功
            if (c.getName().equals("login") && c.getValue().equals("true")){
                UserModel user = new UserModel();
                user.setName("哈哈");
                user.setAge("29");
                user.setAddress("北京市海淀区人民大学");
                return user.toString();
            }
        }
        return "获取用户列表失败";
    }
}
