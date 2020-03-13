package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.biz.paimaiBiz;

@SpringBootTest
public class PaimaiApplicationTests {

	@Autowired
	private paimaiBiz biz;
	@Test
	public void contextLoads() {
		biz.show2(1,3,"undefined","undefined","undefined","undefined","undefined").getList().forEach(row->{
			System.out.println(row);
		});
	}
}
