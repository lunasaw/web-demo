package com.luna.web.jest;



import com.luna.web.es.entity.Article;
import com.luna.web.es.mapper.ArticleMapper;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Luna@win10
 * @date 2020/4/10 16:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JestTest {

	@Autowired
	JestClient jestClient;

	@Resource
	ArticleMapper articleMapper;


	/**
	 * 测试构建
	 *
	 * @throws IOException
	 */
	@Test
	public void aTest() throws IOException {
		// 给ES 索引中保存一个文档
		Article article = articleMapper.getByPrimaryKey(1);

		//构建一个索引功能
		Index build = new Index.Builder(article).index("luna").type("news").build();

		//执行
		jestClient.execute(build);
	}

	/**
	 * 测试搜索
	 *
	 * @throws IOException
	 */
	@Test
	public void bTest() throws IOException {
		//查询表达式
		String json = "{\n" +
				"\t\"query\":{\n" +
				"\t\t\"match\":{\n" +
				"\t\t\t\"content\" : \"用心\"\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}";
		Search build = new Search.Builder(json).addIndex("luna").addType("news").build();
		SearchResult execute = jestClient.execute(build);
		System.out.println(execute.getJsonString());
	}


//	@Test
//	public void cTest() {
//		Article article = new Article();
//		articleRepository.index(article);
//	}
}
