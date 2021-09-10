package lib.Responses.Folder;

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
        "name",
        "exif",
        "created",
        "resource_id",
        "modified",
        "path",
        "comment_ids",
        "type",
        "revision"
})
public class EmbeddedItem {

    @JsonProperty("name")
    private String name;
    @JsonProperty("exif")
    private Object exif;
    @JsonProperty("created")
    private Object created;
    @JsonProperty("resource_id")
    private Object resourceId;
    @JsonProperty("modified")
    private Object modified;
    @JsonProperty("path")
    private String path;
    @JsonProperty("comment_ids")
    private Object commentIds;
    @JsonProperty("type")
    private Object type;
    @JsonProperty("revision")
    private Object revision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public EmbeddedItem withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("exif")
    public Object getExif() {
        return exif;
    }

    @JsonProperty("exif")
    public void setExif(Object exif) {
        this.exif = exif;
    }

    public EmbeddedItem withExif(Object exif) {
        this.exif = exif;
        return this;
    }

    @JsonProperty("created")
    public Object getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Object created) {
        this.created = created;
    }

    public EmbeddedItem withCreated(Object created) {
        this.created = created;
        return this;
    }

    @JsonProperty("resource_id")
    public Object getResourceId() {
        return resourceId;
    }

    @JsonProperty("resource_id")
    public void setResourceId(Object resourceId) {
        this.resourceId = resourceId;
    }

    public EmbeddedItem withResourceId(Object resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    @JsonProperty("modified")
    public Object getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(Object modified) {
        this.modified = modified;
    }

    public EmbeddedItem withModified(Object modified) {
        this.modified = modified;
        return this;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    public EmbeddedItem withPath(String path) {
        this.path = path;
        return this;
    }

    @JsonProperty("comment_ids")
    public Object getCommentIds() {
        return commentIds;
    }

    @JsonProperty("comment_ids")
    public void setCommentIds(Object commentIds) {
        this.commentIds = commentIds;
    }

    public EmbeddedItem withCommentIds(Object commentIds) {
        this.commentIds = commentIds;
        return this;
    }

    @JsonProperty("type")
    public Object getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Object type) {
        this.type = type;
    }

    public EmbeddedItem withType(Object type) {
        this.type = type;
        return this;
    }

    @JsonProperty("revision")
    public Object getRevision() {
        return revision;
    }

    @JsonProperty("revision")
    public void setRevision(Object revision) {
        this.revision = revision;
    }

    public EmbeddedItem withRevision(Object revision) {
        this.revision = revision;
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

    public EmbeddedItem withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
