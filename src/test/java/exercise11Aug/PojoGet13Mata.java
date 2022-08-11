package exercise11Aug;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoGet13Mata {
    /*
      {
    "meta": null,
    "data": {
        "id": 13,
        "name": "Deb Namboothiri DC",
        "email": "dc_deb_namboothiri@barrows.info",
        "gender": "female",
        "status": "inactive"
    }
     */
    private Object meta;
    private PojoGet13Data data;

    public PojoGet13Mata(Object meta, PojoGet13Data data) {
        this.meta = meta;
        this.data = data;
    }

    public PojoGet13Mata() {
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public PojoGet13Data getData() {
        return data;
    }

    public void setData(PojoGet13Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PojoGet13Mata{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
