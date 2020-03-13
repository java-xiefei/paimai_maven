package com.example.demo.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.biz.paimaiBiz;
import com.example.demo.pojo.auction;
import com.example.demo.pojo.auctionrecord;
import com.example.demo.pojo.auctionuser;
import com.example.demo.vo.Oneer;
import com.example.demo.vo.auctionrecordVo;
import com.example.demo.vo.paimaiJG;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/paimais")
public class paimaiAction {
	@Autowired
	private paimaiBiz biz;
	
	private String name = "";
	/**
	 * 用户登录
	 * @param name
	 * @param mm
	 * @param session
	 * @return
	 */
	@GetMapping("{name}/{checkPass}")
	public auctionuser show_1(@PathVariable String name,@PathVariable String checkPass,HttpSession session){
		System.out.println(name);
		System.out.println(checkPass);
		auctionuser yh = biz.show1(name,checkPass);
		session.setAttribute("YH", yh);
		System.out.println(session.getAttribute("YH"));
		return yh;
	}
	/**
	 *  商品分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @return
	 */
	@PostMapping("paimai/{pageNum}/{pageSize}/{name}/{ms}/{kssj}/{jssj}/{qpj}/{sj}")
	public PageInfo<auction> show2(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable String name,@PathVariable String ms,@PathVariable String kssj,@PathVariable String jssj,@PathVariable String qpj,@PathVariable String sj){
		return biz.show2(pageNum, pageSize,name,ms,kssj,jssj,qpj,sj);
	}
	/**
	 * 根据auctionId查商品
	 * @param auctionId
	 * @return
	 */
	@GetMapping("{auctionid}")
	public auction show3(@PathVariable Integer auctionid){
		System.out.println(auctionid);
		return biz.show3(auctionid);
	}
	/**
	 * 根据auctionId查拍卖纪录
	 * @param auctionid
	 * @return
	 */
	@GetMapping("s/{auctionid}")
	public List<auctionrecordVo> show4(@PathVariable Integer auctionid){
		return biz.show4(auctionid);
	}
	/**
	 * 竞拍
	 * @param ac
	 * @return
	 */
	@PostMapping("jinpai")
	public Map<String, String> show5(@RequestBody auctionrecord ac) {
		Map<String, String> msg = new HashMap<String, String>();
		int i = biz.show5(ac);
		if(i>0) {
			msg.put("code", "200");
		}
		return msg;
	}
	@GetMapping("jieshu/{sj}")
	public List<paimaiJG> show6(@PathVariable String sj) {
		System.out.println(sj);
		return biz.show6(sj);
	}
	/**
	 * 主详查询
	 * @param sj
	 * @return
	 */
	@GetMapping("zx/{sj}")
	public List<Oneer> show7(@PathVariable String sj){	
		return biz.show7(sj);
	}
	/**
	 * 查询未到竞拍时间的商品
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @param ms
	 * @param kssj
	 * @param jssj
	 * @param qpj
	 * @param sj
	 * @return
	 */
	@PostMapping("paimaio/{pageNum}/{pageSize}/{name}/{ms}/{kssj}/{jssj}/{qpj}/{sj}/{aid}")
	public PageInfo<auction> show8(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable String name,@PathVariable String ms,@PathVariable String kssj,@PathVariable String jssj,@PathVariable String qpj,@PathVariable String sj,@PathVariable String aid){
		System.out.println(aid);
		return biz.show8(pageNum, pageSize,name,ms,kssj,jssj,qpj,sj,aid);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@GetMapping("sc/{id}")
	public Map<String, String> show9(@PathVariable Integer id) {
		Map<String, String> msg = new HashMap<String, String>();
		if(biz.show9(id)>0) {
			msg.put("code", "200");
		}
		return msg;
	}
	/**
	 * 新增
	 * @param auct
	 * @return
	 */
	@PostMapping("xz")
	public Map<String, String> show10(@RequestBody auction auc){
		Map<String, String> msg = new HashMap<String, String>();
		auc.setAuctionpic(name);
		System.out.println(auc);
		if(biz.show10(auc)>0) {
			msg.put("code", "200");
		}
		return msg;
	}
	/**
	 * 文件上传
	 * @param file
	 */
	@PostMapping("sc")
	public void show11(MultipartFile file) {
		name = "";
		String contentType = file.getContentType(); // 图片文件类型
		System.out.println(contentType);
		String fileName =	file.getOriginalFilename();	 // 图片名字
		System.out.println(fileName);
		UUID uuid=UUID.randomUUID();	//uuid随机值
		System.out.println(uuid);
		String newfileName = uuid.toString()+fileName.substring(fileName.indexOf('.')); //文件重命名
		System.out.println(newfileName);
		name = newfileName;
		try {
			file.transferTo(new File("E:\\myfile\\images\\" + newfileName));	//将文件存到文件夹下面
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改里删除图片的按钮
	 * @param auctionpic
	 */
	@GetMapping("sctp/{auctionpic}")
	public Map<String, String> show12(@PathVariable String auctionpic) {
		Map<String, String> msg = new HashMap<String, String>();
		File f = new File("E:\\myfile\\images\\" +auctionpic);
		if(f.exists()) {
			f.delete();
			msg.put("code", "200");
		}
		return msg;
	}
	/**
	 * 修改
	 * @param auct
	 * @return
	 */
	@PostMapping("xg")
	public Map<String, String> show12(@RequestBody auction auc){
		System.out.println("name:"+name);
		System.out.println(auc);
		Map<String, String> msg = new HashMap<String, String>();
		if("".equals(this.name)||"null".equals(this.name)||this.name==""||" ".equals(this.name)) {
			System.out.println(1);
			if(biz.show11(auc)>0) {
				msg.put("code", "200");
			}
			return msg;
		}else {
			System.out.println(2);
			auc.setAuctionpic(name);
			if(biz.show11(auc)>0) {
				msg.put("code", "200");
			}
			return msg;
		}		
	}
	/**
	 * 注册验证，是否有此账户
	 * @param aname
	 * @return
	 */
	@GetMapping("yz/{aname}")
	public auctionuser show13(@PathVariable String aname) {
		return biz.show12(aname);
	}
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@PostMapping("zxyh")
	public Map<String, String> show14(@RequestBody auctionuser user) {
		 Map<String, String> msg = new HashMap<String, String>();
		 if( biz.show13(user)>0) {
			msg.put("code", "200");
		 }
		return msg;
	}
}
