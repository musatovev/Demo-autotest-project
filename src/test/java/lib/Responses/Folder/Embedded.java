package lib.Responses.Folder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sort",
        "items",
        "limit",
        "offset",
        "path",
        "total"
})
public class Embedded {

    @JsonProperty("sort")
    private Object sort;
    @JsonProperty("items")
    private ArrayList<EmbeddedItem> items;
    @JsonProperty("limit")
    private Object limit;
    @JsonProperty("offset")
    private Object offset;
    @JsonProperty("path")
    private Object path;
    @JsonProperty("total")
    private Object total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sort")
    public Object getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(Object sort) {
        this.sort = sort;
    }

    public Embedded withSort(Object sort) {
        this.sort = sort;
        return this;
    }

    @JsonProperty("items")
    public ArrayList<EmbeddedItem> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(ArrayList<EmbeddedItem> items) {
        this.items = items;
    }

    public Embedded withItems(ArrayList<EmbeddedItem> items) {
        this.items = items;
        return this;
    }

    @JsonProperty("limit")
    public Object getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Object limit) {
        this.limit = limit;
    }

    public Embedded withLimit(Object limit) {
        this.limit = limit;
        return this;
    }

    @JsonProperty("offset")
    public Object getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Object offset) {
        this.offset = offset;
    }

    public Embedded withOffset(Object offset) {
        this.offset = offset;
        return this;
    }

    @JsonProperty("path")
    public Object getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(Object path) {
        this.path = path;
    }

    public Embedded withPath(Object path) {
        this.path = path;
        return this;
    }

    @JsonProperty("total")
    public Object getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Object total) {
        this.total = total;
    }

    public Embedded withTotal(Object total) {
        this.total = total;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Embedded withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
