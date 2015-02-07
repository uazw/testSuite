package DaoLayer; /**
 * Created by yang on 2015/2/7.
 */
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseMybatisDaoTest {
    protected SqlSessionFactory sqlSessionFactory;
    protected SqlSession sqlSession;

    protected <T> void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        sqlSession = sqlSessionFactory.openSession();
    }

    protected void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    protected <T> T getMapper(Class<T> mapperClass) {
        return (T) sqlSession.getMapper(mapperClass);
    }

}



