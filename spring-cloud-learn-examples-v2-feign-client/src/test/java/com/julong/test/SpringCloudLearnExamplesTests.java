package com.julong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.julong.action.IndexAction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudLearnExamplesTests {

	@Autowired
	private IndexAction indexAction;
	
	@Test
	public void test(){
		String result = indexAction.home();
		System.out.println(result);
	}

	public static void main(String[] args) {

	}
}
