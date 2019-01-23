package liepin.com.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;

import liepin.com.domain.User;
import liepin.com.service.UserService;

/**
 * 
 * @author liujinxin
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initUser(ModelMap map) {
        map.put("user", new liepin.com.domain.User());
        return "insert";

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute("user") User user,
            @RequestPart(value = "image1", required = false) byte[] image) throws IOException {
        liepin.com.pojo.User u = new liepin.com.pojo.User();
        u.setAge(user.getAge());
        u.setImage(image);
        u.setName(user.getName());
        u.setSex(user.getSex());
        u.setImage(image);
        int count = userService.insertUser(u);
        if (count > 0) {
            return "redirect:/user/loadAllUser";
        } else {
            return "insert";
        }
    }

    @RequestMapping(value = "/showphoto")
    public void showPhoto(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("image/jpg");
        OutputStream out = response.getOutputStream();
        Integer uid = Integer.parseInt(request.getParameter("uid"));
        liepin.com.pojo.User user = userService.selectUserByUid(uid);
        byte[] b = user.getImage();
        InputStream in = new ByteArrayInputStream(b);
        BufferedImage bi = null;
        bi = ImageIO.read(in);
        ImageIO.write(bi, "jpg", out);
        out.flush();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/loadAllUser")
    public ModelAndView loadAllUser(ModelMap model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int userCount = userService.selectUserCount();
        int pageCount = 0;
        if (userCount % 3 == 0) {
            pageCount = userCount / 3;
            pageCount -= 1;
        } else {
            pageCount = userCount / 3;
        }
        model.addAttribute("max", pageCount);
        if (request.getParameter("page") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            model.addAttribute("p", page);
            List<liepin.com.pojo.User> list = userService.selectUserByLimit(page);
            mav.addObject("users", list);
            mav.setViewName("show");
            return mav;
        } else {
            model.addAttribute("p", 0);
            List<liepin.com.pojo.User> list = userService.selectUserByLimit(0);
            mav.addObject("users", list);
            mav.setViewName("show");
            return mav;
        }
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(HttpServletRequest request) {
        liepin.com.pojo.User u = new liepin.com.pojo.User();
        u.setUid(Long.parseLong(request.getParameter("uid")));
        int count = userService.deleteUser(u);
        return "redirect:/user/loadAllUser";
    }

    @RequestMapping(value = "/update")
    public ModelAndView update(HttpServletRequest request, ModelMap model) {
        ModelAndView mav = new ModelAndView();
        String uid = request.getParameter("uid");
        liepin.com.pojo.User u = userService.selectUserByUid(Integer.parseInt(uid));
        model.addAttribute("user", new User());
        mav.addObject("updateuser", u);
        mav.setViewName("update");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUser")
    public String updateUser(@ModelAttribute("user") User user,
            @RequestPart(value = "image2", required = false) byte[] image) {
        liepin.com.pojo.User u = new liepin.com.pojo.User();
        u.setAge(user.getAge());
        u.setImage(image);
        u.setName(user.getName());
        u.setSex(user.getSex());
        if (image.length == 0) {
            u.setImage(null);
        } else {
            u.setImage(image);

        }
        u.setUid(user.getUid());
        int count = userService.updateUser(u);
        if (count > 0) {
            return "redirect:/user/loadAllUser";
        } else {
            return "insert";
        }
    }
}
