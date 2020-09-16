/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service. 
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */

public class Codec {

    Map<Integer, String> hashUrl = new HashMap<>();
    String hostname = "http://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int urlHash = longUrl.hashCode();
        hashUrl.put(urlHash, longUrl);
        return hostname+urlHash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int urlKey = Integer.parseInt(shortUrl.replace(hostname,""));
        return hashUrl.get(urlKey);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));