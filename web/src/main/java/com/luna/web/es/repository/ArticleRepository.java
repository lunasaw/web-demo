package com.luna.web.es.repository;


import com.luna.web.es.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/4/10 16:55
 */
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {

	public List<Article> findByNameLike(String name);

}
