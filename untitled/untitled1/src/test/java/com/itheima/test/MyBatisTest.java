package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xmL";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands =brandMapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        int id=6;
        String resource = "mybatis-config.xmL";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brands =brandMapper.selectById(id);
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition() throws IOException {
        int status=1;
        String companyName = "��Ϊ";
       // String brandName = "��Ϊ";
        companyName = "%"+companyName+"%";
        //brandName = "%" + brandName +"%";
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

/*
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
*/
        String resource = "mybatis-config.xmL";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands =brandMapper.selectByCondition(map);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectBySingleCondition() throws IOException {
        //int status=1;
        ///String companyName = "��Ϊ";
        //String brandName = "��Ϊ";
       //companyName = "%"+companyName+"%";
        //brandName = "%" + brandName +"%";


        Brand brand = new Brand();
        //brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);

        String resource = "mybatis-config.xmL";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands =brandMapper.selectBySingleCondition(brand);
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void testAdd2() throws IOException {
        int status=1;
        String companyName = "fvavad";
        String brandName = "afsfa";
        String description = "asd";
        int ordered=100;


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        String resource = "mybatis-config.xmL";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        //SqlSession sqlSession=sqlSessionFactory.openSession();
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        //sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testAdd() throws IOException {
        int status=1;
        String companyName = "fvavad";
        String brandName = "afsfa";
        String description = "asd";
        int ordered=100;
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        String resource = "mybatis-config.xmL";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        //SqlSession sqlSession=sqlSessionFactory.openSession();
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
//���ղ���
        int status = 1;
        String companyName = "�����ֻ�";
        String brandName = "����";
        String description = "�����ֻ�,�ֻ��е�ս����";
        int ordered = 100;
        int id = 6;
//��װ����
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        //brand.setDescription(description);
        //brand.setOrdered(ordered);
        brand.setId(id);
//1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//SqlSession sqlSession = sqlSessionFactory.openSession(true);
//3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//4. ִ�з���
        brandMapper.update(brand);
       // System.out.println(count);
//�ύ����
        sqlSession.commit();
//5. �ͷ���Դ
        sqlSession.close();
    }
    @Test
    public void testDeleteByIds() throws IOException {
//���ղ���
        int[] ids = {1,2,3};
//1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//SqlSession sqlSession = sqlSessionFactory.openSession(true);
//3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//4. ִ�з���
        brandMapper.deleteByIds(ids);
//�ύ����
        sqlSession.commit();
//5. �ͷ���Դ
        sqlSession.close();
    }
}
