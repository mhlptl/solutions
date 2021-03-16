package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE: Encode and Decode TinyURL (535) [MEDIUM]
 * 
 * use random index to create shortened url
 * store in map with the shorturl being the key
 */
public class EncodeAndDecodeTinyURL {
	Map<String, String> map = new HashMap<>();
  String values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWZYZ0123456789";
  int size = 7;
  
  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String url = "http://tinyurl.com/";
    String str = createString();
    map.put(str, longUrl);
    return url + str;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    String url = shortUrl.substring(19);
    if(map.containsKey(url)) return map.get(url);
    return "";
  }
  
  private String createString() {
    StringBuilder sb = new StringBuilder();
    
    while(sb.length() != size) {
      int random = (int)(Math.random() * 62.0);
      sb.append(values.charAt(random));
    }
    
    return sb.toString();
  }
}
