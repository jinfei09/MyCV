package cfarika.com.mycv.bean;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * 实体类
 */
@SuppressWarnings("serial")
public abstract class Entity implements Serializable {
	
	@JsonProperty("id")
	protected String _id;

	public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }
	
	// 缓存的key
	protected String cacheKey;

	public String getCacheKey() {
		return cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}
}
