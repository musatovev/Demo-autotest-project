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
        "_embedded",
        "name",
        "exif",
        "resource_id",
        "created",
        "modified",
        "path",
        "comment_ids",
        "type",
        "revision"
})
public class Folder {

    @JsonProperty("_embedded")
    private Embedded embedded;
    @JsonProperty("name")
    private Object name;
    @JsonProperty("exif")
    private Object exif;
    @JsonProperty("resource_id")
    private Object resourceId;
    @JsonProperty("created")
    private Object created;
    @JsonProperty("modified")
    private Object modified;
    @JsonProperty("path")
    private Object path;
    @JsonProperty("comment_ids")
    private Object commentIds;
    @JsonProperty("type")
    private Object type;
    @JsonProperty("revision")
    private Object revision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ArrayList<EmbeddedItem> getItemsByType(String type) {
        ArrayList<EmbeddedItem> neededItems = new ArrayList<EmbeddedItem>();
        ArrayList<EmbeddedItem> allItems = this.getEmbedded().getItems();
        if (allItems.size() == 0) {
            System.out.println("Каталог пуст");
            return neededItems;
        }
        for (EmbeddedItem item : allItems)
            if (item.getType().equals(type))
                neededItems.add(item);
        return neededItems;
    }

    public ArrayList<String> getItemsNames() {
        ArrayList<String> itemNames = new ArrayList<String>();
        ArrayList<EmbeddedItem> allItems = this.getEmbedded().getItems();
        if (allItems.size() == 0) {
            System.out.println("Каталог пуст");
            return itemNames;
        }
        for (EmbeddedItem item : allItems)
            itemNames.add(item.getName());
        return itemNames;
    }


    @JsonProperty("_embedded")
    public Embedded getEmbedded() {
        return embedded;
    }

    @JsonProperty("_embedded")
    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public Folder withEmbedded(Embedded embedded) {
        this.embedded = embedded;
        return this;
    }

    @JsonProperty("name")
    public Object getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Object name) {
        this.name = name;
    }

    public Folder withName(Object name) {
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

    public Folder withExif(Object exif) {
        this.exif = exif;
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

    public Folder withResourceId(Object resourceId) {
        this.resourceId = resourceId;
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

    public Folder withCreated(Object created) {
        this.created = created;
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

    public Folder withModified(Object modified) {
        this.modified = modified;
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

    public Folder withPath(Object path) {
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

    public Folder withCommentIds(Object commentIds) {
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

    public Folder withType(Object type) {
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

    public Folder withRevision(Object revision) {
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

    public Folder withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}