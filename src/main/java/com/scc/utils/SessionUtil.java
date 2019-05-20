package com.scc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionUtil {

        private static final String MYBATIS_CONFIG_PATH = "configuration.xml";

        private static InputStream is = null;

        private static SqlSessionFactory sqlSessionFactory = null;

        static {
            try {
                is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /**
         * 私有构造器
         */
        private SessionUtil() {

        };

        /**
         * SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次
         *
         * @return SqlSessionFactory
         */
        public static SqlSessionFactory getSqlSessionFactoryIntance() {

            return sqlSessionFactory;

        }

        /**
         * 每个线程都应该有它自己的 SqlSession 实例。 SqlSession 的实例不能被共享,也是线程 不安全的。
         * 因此最佳的范围是请求或方法范围。
         *
         * @return SqlSession
         */
        public static SqlSession getSqlSessionIntance() {

            return sqlSessionFactory.openSession();

        }
}
