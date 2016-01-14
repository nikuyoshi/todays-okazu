/*
 * Copyright 2016 Hiroki Uchida
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nikuyoshi.bot;

import com.github.nikuyoshi.crawler.CrawlerImpl;

/**
 * @author nikuyoshi
 */
public class BotImpl implements Bot {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String... args) throws Exception{
    new BotImpl().execute();
  }

  /* (non-Javadoc)
   * @see com.github.nikuyoshi.bot.Bot#execute()
   */
  @Override
  public void execute() throws Exception {
    CrawlerImpl crawler = new CrawlerImpl();
    crawler.execute();
  }
  
}
