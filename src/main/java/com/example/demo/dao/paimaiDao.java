package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Oneer;
import com.example.demo.vo.Tower;
import com.example.demo.vo.auctionrecordVo;
import com.example.demo.vo.paimaiJG;

public interface paimaiDao {
	List<auctionrecordVo> query(@Param("auctionid") Integer auctionid);
	List<paimaiJG> querybi(@Param("sj") String sj);
	List<Oneer> select1(@Param("sj") String sj);
	List<Tower> select2(@Param("auctionid") Integer auctionid);
}
