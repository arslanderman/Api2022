package get_requests.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestDataBodyOuterPojoResponse {

    private Object meta;
    private GoRestDataPojoInnerPojo data;

    public GoRestDataBodyOuterPojoResponse(Object meta, GoRestDataPojoInnerPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GoRestDataBodyOuterPojoResponse() {
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojoInnerPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojoInnerPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoRestDataBodyOuterPojoResponse{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
