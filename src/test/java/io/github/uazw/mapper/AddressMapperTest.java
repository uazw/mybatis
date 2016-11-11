package io.github.uazw.mapper;

import io.github.uazw.domain.Address;
import io.github.uazw.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class AddressMapperTest {

    private SqlSession sqlSession;
    private AddressMapper mapper;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(AddressMapper.class);

    }

    @Test
    public void shouldReturnAddressSuccessfullyUsingConstructor() {
        //when

        //given
        Address address = mapper.findAddressByIdUsingConstructor(1);
        //then
        assertNull(address);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.rollback();
    }
}