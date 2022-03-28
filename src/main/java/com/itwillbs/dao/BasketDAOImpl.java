package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BasketDTO;
import com.itwillbs.domain.ProductDTO;

@Repository
public class BasketDAOImpl implements BasketDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.basketMapper";
	
	//장바구니 추가
	@Override
	public void insertBasket(BasketDTO basketDTO) {
		System.out.println("BasketDAOImpl insertBaset()");
		sqlSession.insert(namespace+".insertBasket", basketDTO);
	}
	
	//장바구니 목록
	@Override
	public List<BasketDTO> basketList(int member_id){
		return sqlSession.selectList(namespace+".basketList", member_id);
	}
	
	//장바구니 삭제
	@Override
	public void delete(int id) {
		sqlSession.delete(namespace+".delete", id);
	}
	
}