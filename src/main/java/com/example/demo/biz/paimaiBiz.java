package com.example.demo.biz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.dao.adminDao;
import com.example.demo.dao.auctionDao;
import com.example.demo.dao.auctionrecordDao;
import com.example.demo.dao.auctionuserDao;
import com.example.demo.dao.paimaiDao;
import com.example.demo.pojo.auction;
import com.example.demo.pojo.auctionrecord;
import com.example.demo.pojo.auctionuser;
import com.example.demo.vo.Oneer;
import com.example.demo.vo.auctionrecordVo;
import com.example.demo.vo.paimaiJG;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class paimaiBiz {
	@Autowired
	private paimaiDao pdao;
	@Autowired
	private adminDao mdao;
	@Autowired
	private auctionDao auctdao;
	@Autowired
	private auctionrecordDao redao;
	@Autowired
	private auctionuserDao serdao;
	/**
	 * 用户登录
	 * @param name
	 * @param mm
	 * @return
	 */
	public auctionuser show1(String name,String mm) {
		QueryWrapper<auctionuser> qw = Wrappers.query();
		qw.eq("aname", name).eq("apassword", mm);
		return serdao.selectOne(qw);
	}
	/**
	 * 商品分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @return
	 */
	public PageInfo<auction> show2(Integer pageNum,Integer pageSize,String a,String b,String c,String d,String e,String sj){
		PageHelper.startPage(pageNum, pageSize);
		QueryWrapper<auction> qw = Wrappers.query();
		qw.eq(!"null".equals(a)&&a!="","auctionName", a).eq(!"null".equals(b)&&b!="","auctionDesc",b).eq(!"null".equals(c)&&c!="","auctionStartTime",c).eq(!"null".equals(d)&&d!="","auctionEndTime",d).eq(!"null".equals(e)&&e!="","auctionStartPrice",e).gt("auctionEndTime", sj).lt("auctionStartTime",sj);
		PageInfo<auction> page = new PageInfo<auction>(auctdao.selectList(qw));
		return page;
	}
	/**
	 * 根据auctionId查商品
	 * @param auctionId
	 * @return
	 */
	public auction show3(Integer auctionid){
		return auctdao.selectById(auctionid);
	}
	/**
	 * 根据auctionId查拍卖纪录
	 * @param auctionid
	 * @return
	 */
	public List<auctionrecordVo> show4(Integer auctionid){
		return pdao.query(auctionid);
	}
	/**
	 * 新增竞拍记录
	 * @param ac
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int show5(auctionrecord ac) {
		return redao.insert(ac);
	}
	/**
	 * 查询拍卖结束的商品
	 * @param sj
	 * @return
	 */
	public List<paimaiJG> show6(String sj) {
		return pdao.querybi(sj);
	}
	/**
	 * 主详查询
	 * @param sj
	 * @return
	 */
	public List<Oneer> show7(String sj){
		List<Oneer> bb = pdao.select1(sj);
		bb.forEach(row->{
			row.setTower(pdao.select2(row.getAuctionid()));
		});
		System.out.println(bb);
		return bb;
	}
	/**
	 * 查询未到竞拍时间的商品
	 * @param pageNum
	 * @param pageSize
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param sj
	 * @return
	 */
	public PageInfo<auction> show8(Integer pageNum,Integer pageSize,String a,String b,String c,String d,String e,String sj,String aid){
		PageHelper.startPage(pageNum, pageSize);
		QueryWrapper<auction> qw = Wrappers.query();
		qw.eq(!"null".equals(a)&&a!="","auctionName", a).eq(!"null".equals(b)&&b!="","auctionDesc",b).eq(!"null".equals(c)&&c!="","auctionStartTime",c).eq(!"null".equals(d)&&d!="","auctionEndTime",d).eq(!"null".equals(e)&&e!="","auctionStartPrice",e).eq(!"null".equals(aid)&&aid!="","aid", aid).gt("auctionStartTime", sj);
		PageInfo<auction> page = new PageInfo<auction>(auctdao.selectList(qw));
		return page;
	}
	/**
	 * 删除商品
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int show9(Integer id) {
		//System.out.println(auctdao.selectById(id).getAuctionpic());根据id查出数据库的路径
		File f = new File("E:\\myfile\\images\\" +auctdao.selectById(id).getAuctionpic());
		if(f.exists()) {
			f.delete();
			return auctdao.deleteById(id);
		}
		return 0;
	}
	/**
	 * 新增
	 * @param auc
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int show10(auction auc) {
		return auctdao.insert(auc);
	}
	/**
	 * 修改
	 * @param auc
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int show11(auction auc) {
		int i = auctdao.deleteById(auc.getAuctionid());
		if(i>0) {
			return auctdao.insert(auc);
		}
		return 0;
	}
	/**
	 * 注册验证，是否有此账户
	 * @param aname
	 * @return
	 */
	public auctionuser show12(String aname) {
		QueryWrapper<auctionuser> qw = Wrappers.query();
		qw.eq("aname", aname);
		return serdao.selectOne(qw);
	}
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int show13(auctionuser user) {
		return serdao.insert(user);
	}
}
