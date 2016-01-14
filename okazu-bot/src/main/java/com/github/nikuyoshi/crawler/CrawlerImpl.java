/*
 * Copyright 2016 Hiroki Uchida
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.nikuyoshi.crawler;

import java.io.IOException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



/**
 * @author nikuyoshi
 */
public class CrawlerImpl extends CrawlerBase implements Crawler {

  /** おかず、夕飯のレシピURL */
  private final static String COOKPADURL = "http://cookpad.com/search/%E3%81%8A%E3%81%8B%E3%81%9A%20%E5%A4%95%E9%A3%AF";
  
  Random random;
  
  @Override
  public void crawl() throws Exception{
    if(this.uranai()){
      this.crawlCookPad();
    } else {
      this.crawlDmm();
    }
  }
  
  private boolean uranai(){
//    return random.nextBoolean();
    return true;
  }
  
  private String crawlCookPad() throws IOException{
    Document document = Jsoup.connect(COOKPADURL)
        .data("query", "Java")
        .userAgent("Chrome")
        .timeout(3000)
        .get();
    // 
    Element firstRecipe = document.select("div.recipe-preview").first();
    Element recipeImageTag = firstRecipe.select("div.recipe-image > a[href]").first();
    String recipeUrl = recipeImageTag.attr("href");
    Element recipeDescriptionTag = firstRecipe.select("div.recipe_description").first();
    String title = recipeDescriptionTag.text();
    return title + ":" + recipeUrl;
  }
  
  private void crawlDmm(){
    
  }

}
