package liepin.com.service;
/**
 * 
 * @author liujinxin
 *
 */

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import liepin.com.pojo.User;

@Service
public class UserService {
    @Resource
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertUser(User user) {
        int result = sqlSession.insert("liepin.com.mapper.UserMapper.insertUser", user);
        return result;
    }

    public int deleteUser(User user) {
        int result = sqlSession.delete("liepin.com.mapper.UserMapper.deleteUser", user);
        return result;
    }

    public int updateUser(User user) {
        int result = sqlSession.update("liepin.com.mapper.UserMapper.updateUser", user);
        return result;
    }

    public List<User> selectUserByLimit(int num) {
        List<User> list = sqlSession.selectList("liepin.com.mapper.UserMapper.selectUserByLimit", num * 3);
        return list;
    }

    public int selectUserCount() {
        return sqlSession.selectOne("liepin.com.mapper.UserMapper.selectUserCount");
    }

    public User selectUserByUid(int uid) {
        User u = sqlSession.selectOne("liepin.com.mapper.UserMapper.selectUserByUid", uid);
        return u;

    }

}
