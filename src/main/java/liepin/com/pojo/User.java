package liepin.com.pojo;

import java.io.File;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @author liujinxin
 *
 */
@Alias("user")
public class User {
    private Long uid;
    private String name;
    private String sex;
    private Integer age;
    private byte[] image;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
